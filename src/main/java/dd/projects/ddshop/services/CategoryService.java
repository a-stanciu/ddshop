package dd.projects.ddshop.services;

import dd.projects.ddshop.dto.CategoryDTO;
import dd.projects.ddshop.entities.Category;
import dd.projects.ddshop.mappers.CategoryMapper;
import dd.projects.ddshop.repositories.CategoryRepository;
import dd.projects.ddshop.validators.CategoryValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;
    private final CategoryValidator categoryValidator;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository, CategoryMapper categoryMapper, CategoryValidator categoryValidator) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
        this.categoryValidator = categoryValidator;
    }

    public Category createCategory(CategoryDTO categoryDTO) {
        categoryValidator.validate(categoryDTO);
        return categoryRepository.save(categoryMapper.destinationToSource(categoryDTO));
    }

    public Category updateCategory(int id, CategoryDTO categoryDTO) {
        categoryDTO.setId(id);
        categoryValidator.validate(categoryDTO);
        return categoryRepository.save(categoryMapper.destinationToSource(categoryDTO));
    }

    public void deleteCategoryById(int id) {
        categoryRepository.deleteById(id);
    }

    public Category getCategoryById(int id) {
        return categoryRepository
                .findById(id)
                .orElse(null);
    }

    public List<CategoryDTO> getCategories() {
        return categoryRepository
                .findAll()
                .stream()
                .map(categoryMapper::sourceToDestination)
                .toList();
    }

    public int getCategoryId(Category category) {
        return category.getId();
    }

    public void deleteAllCategories() {
        categoryRepository.deleteAll();
    }
}
