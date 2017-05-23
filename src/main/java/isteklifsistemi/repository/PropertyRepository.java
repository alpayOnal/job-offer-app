package isteklifsistemi.repository;

import isteklifsistemi.model.SubCategoryProperty;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by alpay on 5/21/17.
 */

@Repository
public interface PropertyRepository extends CrudRepository<SubCategoryProperty, Long> {
}
