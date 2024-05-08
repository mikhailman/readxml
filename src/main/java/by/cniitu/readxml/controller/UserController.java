package by.cniitu.readxml.controller;

import by.cniitu.readxml.model.User;
import by.cniitu.readxml.service.XmlParser;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import by.cniitu.readxml.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Tag(name = "Users")
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    // swagger - http://localhost:8888/webjars/swagger-ui/index.html

    private final XmlParser xmlParser;
    private final UserService userService;

    @Operation(summary = "Save user")
    @PostMapping
    public Mono<User> saveUser(User user) {
        return userService.saveUser(user);
    }

    // ниже метод уже есть метод get с парсингом xml
//    @Operation(summary = "Find all users")
//    @GetMapping
//    public Flux<User> findAll() {
//        return userService.findAll();
//    }

    @Operation(summary = "Find user by id")
    @GetMapping("/{id}")
    public Mono<User> findById(@PathVariable String id) {
        return userService.findById(id);
    }

    @Operation(summary = "Delete user")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> delete(@PathVariable String id) {
        return userService.delete(id);
    }

//    @PostMapping("/upload")
//    public Mono<Void> uploadUsers(@RequestParam("file") MultipartFile file) {
//        return xmlParser.parseXmlFile(String.valueOf(file))
//                .flatMap(userRepository::save)
//                .then();
//    }

    @Operation(summary = "Update user")
    @PutMapping("/{id}")
    public Mono<User> update(@PathVariable String id,
                             @RequestBody User user) {
        return userService.update(id, user);
    }

    @Operation(summary = "parse xml")
    @GetMapping
    public Flux<User> getUser() {



        String xmlString = "D:\\workspase\\cniitu\\123.xml";
//        String xmlString = """
//                <users>
//                    <user id="1">
//                        <personalinfo>
//                            <firstname>John</firstname>
//                            <lastname>Doe</lastname>
//                            <email>john.doe@example.com</email>
//                            <dateofbirth>1990-01-01</dateofbirth>
//                            <gender>Male</gender>
//                        </personalinfo>
//                        <contactinfo>
//                            <phonenumber>+1234567890</phonenumber>
//                            <address>
//                                <street>123 Main St</street>
//                                <city>New York</city>
//                                <state>NY</state>
//                                <postalcode>10001</postalcode>
//                                <country>USA</country>
//                            </address>
//                        </contactinfo>
//                        <employment>
//                            <companyname>Example Corp</companyname>
//                            <position>Software Engineer</position>
//                            <startdate>2015-06-01</startdate>
//                            <enddate>Present</enddate>
//                        </employment>
//                        <education>
//                            <universityname>Example University</universityname>
//                            <degree>Bachelor's in Computer Science</degree>
//                            <graduationyear>2014</graduationyear>
//                        </education>
//                        <skills>
//                            <skill>Java</skill>
//                            <skill>Spring Boot</skill>
//                            <skill>MongoDB</skill>
//                            <skill>REST API</skill>
//                        </skills>
//                    </user>
//                </users>
//
//                """;

        return xmlParser.parseXmlFile(xmlString);
    }
}
