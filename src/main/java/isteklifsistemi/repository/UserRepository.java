package isteklifsistemi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import isteklifsistemi.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findOneByEmail(String email);
}