package by.cniitu.readxml.service;

import by.cniitu.readxml.model.User;
import by.cniitu.readxml.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Flux<User> findAll() {
        return userRepository.findAll();
    }

    public Mono<User> findById(String id) {
        return userRepository.findById(id)
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found")));
    }

    public Mono<User> create(User user) {
        return userRepository.save(user);
    }

    public Mono<User> saveUser(User user) {
        return userRepository.save(user);
    }

    public Flux<User> saveAll(Iterable<User> user) {
        return userRepository.saveAll(user);
    }

    public Mono<Void> delete(String id) {
        return userRepository.deleteById(id);
    }

    public Mono<User> update(String id, User user) {
        return findById(id).flatMap(r -> {
            r.setId(user.getId());
            r.setPersonalinfo(user.getPersonalinfo());
            r.setContactinfo(user.getContactinfo());
            r.setEmployment(user.getEmployment());
            r.setEducation(user.getEducation());
            r.setSkills(user.getSkills());
            return userRepository.save(r);
        });
    }

}
