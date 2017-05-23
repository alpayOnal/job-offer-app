package isteklifsistemi.service;

import isteklifsistemi.model.SubCategoryProperty;
import isteklifsistemi.repository.PropertyRepository;
import org.springframework.stereotype.Service;
import isteklifsistemi.model.Category;
import isteklifsistemi.model.SubCategory;
import isteklifsistemi.repository.CategoryRepository;
import isteklifsistemi.repository.SubCategoryRepository;

@Service
public class HizmetKatalogu {
    private final CategoryRepository categoryRepository;
    private final SubCategoryRepository subCategoryRepository;
    private final PropertyRepository propertyRepository;

    public HizmetKatalogu(CategoryRepository categoryRepository, SubCategoryRepository subCategoryRepository,
                           PropertyRepository propertyRepository1) {
        this.categoryRepository = categoryRepository;
        this.subCategoryRepository = subCategoryRepository;
        this.propertyRepository = propertyRepository1;
    }

    public Category create(Category category) {
        return categoryRepository.save(category);
    }

    public SubCategory createSubCategory(SubCategory category) {
        return subCategoryRepository.save(category);
    }

    public Category findCategoryOne(long id) {
        return categoryRepository.findOne(id);
    }

    public SubCategory findSubCategoryOne(long id) {
        return subCategoryRepository.findOne(id);
    }

    public Iterable<SubCategory> findAllSubCategories() {
        return subCategoryRepository.findAll();
    }

    public Iterable<Category> findAllCategories() {
        return categoryRepository.findAll();
    }
    public SubCategoryProperty createSubCategoryProperty(SubCategoryProperty subCategoryProperty) {
        return propertyRepository.save(subCategoryProperty);
    }
}
