package isteklifsistemi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import isteklifsistemi.model.Talep;
import isteklifsistemi.model.User;

@Repository
public interface TalepRepository extends CrudRepository<Talep, Long> {
    Iterable<Talep> findAllByUser(User user);
}
