package isteklifsistemi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import isteklifsistemi.model.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
}
