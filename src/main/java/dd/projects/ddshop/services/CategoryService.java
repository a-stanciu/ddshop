package dd.projects.ddshop.services;

import dd.projects.ddshop.dto.CategoryDTO;
import dd.projects.ddshop.mappers.CategoryMapper;
import dd.projects.ddshop.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    public Category createCategory(CategoryDTO categoryDTO) {
        return categoryRepository.save(categoryMapper.destinationToSource(categoryDTO));
    }

    public Category updateCategory(CategoryDTO categoryDTO) {
        return categoryRepository.save(categoryMapper.destinationToSource(categoryDTO));
    }

    public void deleteCategoryById(int id) {
        categoryRepository.deleteById(id);
    }

    public List<CategoryDTO> getCategories() {
        return categoryRepository
                .findAll()
                .stream()
                .map(categoryMapper::sourceToDestination)
                .toList();
    }

    public CategoryRepository getCategoryRepository() {
        return categoryRepository;
    }
}
