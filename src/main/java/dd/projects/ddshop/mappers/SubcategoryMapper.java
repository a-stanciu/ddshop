package dd.projects.ddshop.mappers;

import dd.projects.ddshop.dto.SubcategoryDTO;
import dd.projects.ddshop.entities.Category;
import dd.projects.ddshop.entities.Subcategory;
import dd.projects.ddshop.services.CategoryService;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class SubcategoryMapper {

    @Autowired
    private CategoryService categoryService;

    public abstract SubcategoryDTO sourceToDestination(Subcategory subcategory);

    public abstract Subcategory destinationToSource(SubcategoryDTO subcategoryDTO);

    protected Integer fromIntegerToCategory(Category value) {
        return categoryService.getCategoryId(value);
    }

    protected Category fromCategoryToInteger(Integer value) {
        return categoryService.getCategoryById(value);
    }
}
