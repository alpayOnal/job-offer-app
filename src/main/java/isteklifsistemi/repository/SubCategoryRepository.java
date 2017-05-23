package isteklifsistemi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import isteklifsistemi.model.SubCategory;

@Repository
public interface SubCategoryRepository extends CrudRepository<SubCategory, Long> {
}