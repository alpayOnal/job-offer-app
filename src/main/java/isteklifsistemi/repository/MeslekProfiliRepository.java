package isteklifsistemi.repository;

import isteklifsistemi.model.MeslekProfili;
import isteklifsistemi.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by alpay on 5/21/17.
 */

@Repository
public interface MeslekProfiliRepository extends CrudRepository<MeslekProfili, Long> {
    Iterable<MeslekProfili> findAllByUser(User user);
}
