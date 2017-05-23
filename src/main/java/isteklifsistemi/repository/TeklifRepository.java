package isteklifsistemi.repository;

import isteklifsistemi.model.Teklif;
import isteklifsistemi.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by alpay on 5/20/17.
 */

@Repository
public interface TeklifRepository extends CrudRepository<Teklif, Long> {
    Iterable<Teklif> findAllByUser(User user);
}