//package by.cniitu.readxml.repository;
//
//import by.cniitu.readxml.model.Users;
//import lombok.RequiredArgsConstructor;
//import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
//import org.springframework.stereotype.Repository;
//import reactor.core.publisher.Mono;
//
//@Repository
//@RequiredArgsConstructor
//
//public class FileRepository {
//
//    private final ReactiveMongoTemplate mongoTemplate;
//
//    public Mono<Users> saveUser(Users users) {
//        return mongoTemplate.save(users);
//    }
//}
