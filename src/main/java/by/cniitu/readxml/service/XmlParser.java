package by.cniitu.readxml.service;

import by.cniitu.readxml.model.User;
import by.cniitu.readxml.model.Users;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.reactivestreams.Subscriber;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class XmlParser {
    private final UserService userService;

    public XmlParser(UserService userService) {
        this.userService = userService;
    }

    public Flux<User> parseXmlFile(String xmlFilePath) {
        return Mono.fromCallable(() -> parseXml(xmlFilePath))
                .subscribeOn(Schedulers.boundedElastic())
                .flatMapMany(Flux::fromIterable)
                .buffer(10)
                .flatMap(userService::saveAll);
    }

    private List<User> parseXml(String xmlFilePath) {
        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(Users.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Users users = (Users) jaxbUnmarshaller.unmarshal(new StringReader(xmlFilePath));
            System.out.println(users);
            return List.of(users.getUser());
        } catch (JAXBException e) {
            e.printStackTrace();
            throw new IllegalStateException(e.getCause());
        }
    }
}
