package dd.projects.ddshop.services;

import dd.projects.ddshop.dto.SubcategoryDTO;
import dd.projects.ddshop.entities.Subcategory;
import dd.projects.ddshop.mappers.SubcategoryMapper;
import dd.projects.ddshop.repositories.SubcategoryRepository;
import dd.projects.ddshop.validators.SubcategoryValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubcategoryService {
    private final SubcategoryRepository subcategoryRepository;

    private final SubcategoryMapper subcategoryMapper;
    private final SubcategoryValidator subcategoryValidator;

    @Autowired
    public SubcategoryService(SubcategoryRepository subcategoryRepository, SubcategoryMapper subcategoryMapper, SubcategoryValidator subcategoryValidator) {
        this.subcategoryRepository = subcategoryRepository;
        this.subcategoryMapper = subcategoryMapper;
        this.subcategoryValidator = subcategoryValidator;
    }

    public Subcategory createSubcategory(SubcategoryDTO subcategoryDTO) {
        subcategoryValidator.validate(subcategoryDTO);
        return subcategoryRepository.save(subcategoryMapper.destinationToSource(subcategoryDTO));
    }

    public Subcategory updateSubcategory(int id, SubcategoryDTO subcategoryDTO) {
        subcategoryDTO.setId(id);
        subcategoryValidator.validate(subcategoryDTO);
        return subcategoryRepository.save(subcategoryMapper.destinationToSource(subcategoryDTO));
    }

    public void deleteSubcategoryById(int id) {
        subcategoryRepository.deleteById(id);
    }

    public Subcategory getSubcategoryById(int id) {
        return subcategoryRepository
                        .findById(id)
                        .orElse(null);
    }

    public List<SubcategoryDTO> getSubcategories() {
        return subcategoryRepository
                .findAll()
                .stream()
                .map(subcategoryMapper::sourceToDestination)
                .toList();
    }

    public int getSubcategoryId(Subcategory subcategory) {
        return subcategory.getId();
    }

    public void deleteAllSubcategories() {
        subcategoryRepository.deleteAll();
    }
}
