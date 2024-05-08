//package by.cniitu.readxml.controller;
//
//import by.cniitu.readxml.model.User;
//import by.cniitu.readxml.model.Users;
//import by.cniitu.readxml.repository.UserRepository;
//import by.cniitu.readxml.service.XmlParser;
//import jakarta.xml.bind.JAXBContext;
//import jakarta.xml.bind.JAXBException;
//import jakarta.xml.bind.Unmarshaller;
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.io.File;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.List;
//
//
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/users")
//public class FileController {
//    private final UserRepository userRepository;
//
//    //
////    private final XmlParser xmlParser;
////
////    public List<User> readXml() {
////
//    public static void main(String[] args) {
//
//
//        Path testFilePath = Paths.get("D:\\workspase\\cniitu\\aaa.xml");
//        Path fileName = testFilePath.getFileName();
//        System.out.println(fileName.getRoot());
//
//
//        File xmlFile = new File("D:\\workspase\\cniitu\\aaa.xml");
//        JAXBContext jaxbContext;
//
//        try {
//            jaxbContext = JAXBContext.newInstance(Users.class);
//            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
//            Users employee = (Users) jaxbUnmarshaller.unmarshal(xmlFile);
//            System.out.println(employee);
//        } catch (JAXBException e) {
//            e.printStackTrace();
//        }
//
//
////        String xmlString = """
////                <users>
////                    <user id="1">
////                        <personalinfo>
////                            <firstname>John</firstname>
////                            <lastname>Doe</lastname>
////                            <email>john.doe@example.com</email>
////                            <dateofbirth>1990-01-01</dateofbirth>
////                            <gender>Male</gender>
////                        </personalinfo>
////                        <contactinfo>
////                            <phonenumber>+1234567890</phonenumber>
////                            <address>
////                                <street>123 Main St</street>
////                                <city>New York</city>
////                                <state>NY</state>
////                                <postalcode>10001</postalcode>
////                                <country>USA</country>
////                            </address>
////                        </contactinfo>
////                        <employment>
////                            <companyname>Example Corp</companyname>
////                            <position>Software Engineer</position>
////                            <startdate>2015-06-01</startdate>
////                            <enddate>Present</enddate>
////                        </employment>
////                        <education>
////                            <universityname>Example University</universityname>
////                            <degree>Bachelor's in Computer Science</degree>
////                            <graduationyear>2014</graduationyear>
////                        </education>
////                        <skills>
////                            <skill>Java</skill>
////                            <skill>Spring Boot</skill>
////                            <skill>MongoDB</skill>
////                            <skill>REST API</skill>
////                        </skills>
////                    </user>
////                </users>
////                """;
////
////
////        return (List<User>) xmlParser.parseXmlFile(xmlString);
//    }
//}
////}
////
