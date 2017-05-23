package isteklifsistemi.controller;

import isteklifsistemi.model.SubCategoryProperty;
import org.springframework.web.bind.annotation.*;
import isteklifsistemi.model.Category;
import isteklifsistemi.model.SubCategory;
import isteklifsistemi.service.HizmetKatalogu;

@RestController
@RequestMapping("/api/v1/categories")
public class HizmetController {
    private HizmetKatalogu hizmetKatalogu;

    public HizmetController(HizmetKatalogu hizmetKatalogu) {
        this.hizmetKatalogu = hizmetKatalogu;
    }

    @GetMapping("/main")
    public Iterable<Category> getAllCategories() {
        return hizmetKatalogu.findAllCategories();
    }

    @GetMapping
    public Iterable<SubCategory> getAllSubCategories() {
        return hizmetKatalogu.findAllSubCategories();
    }

    @PostMapping
    public Category createCategory(@RequestBody Category category) {
        return hizmetKatalogu.create(category);
    }

    @PostMapping("/{parentId}")
    public SubCategory createCategory(@PathVariable long parentId, @RequestBody SubCategory subCategory) {
        Category category = hizmetKatalogu.findCategoryOne(parentId);
        subCategory.setParent(category);
        return hizmetKatalogu.createSubCategory(subCategory);
    }

    @PostMapping("/{subId}/property")
    public SubCategory createProperty(
            @PathVariable long subId, @RequestBody SubCategoryProperty subCategoryProperty) {

        SubCategory subCategory = hizmetKatalogu.findSubCategoryOne(subId);
        hizmetKatalogu.createSubCategoryProperty(subCategoryProperty);
        subCategory.getProperties().add(subCategoryProperty);
        return hizmetKatalogu.createSubCategory(subCategory);
    }
}
