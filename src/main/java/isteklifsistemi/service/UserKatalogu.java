package isteklifsistemi.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import isteklifsistemi.model.User;
import isteklifsistemi.repository.UserRepository;

import java.security.Principal;

@Service
public class UserKatalogu {

    private UserRepository repository;


    public UserKatalogu(UserRepository repository) {
        this.repository = repository;
    }

    public User findOne(Long id) {
        return repository.findOne(id);
    }

    public User findOneByEmail(String email) {
        return repository.findOneByEmail(email);
    }

    public Iterable<User> findAll() {
        return repository.findAll();
    }

    public User save(User user) {
        //user.setPasswordHashed(new BCryptPasswordEncoder().encode(user.getPasswordHashed()));
        return repository.save(user);
    }

    public void delete(User user) {
        repository.delete(user.getId());
    }

    public User findBy(Principal principal) {
        return findOneByEmail(principal.getName());
    }

}
