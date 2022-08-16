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

    public Subcategory createSubcategory(SubcategoryDTO subcategoryDTO) throws Exception {
        subcategoryValidator.validate(subcategoryDTO);
        return subcategoryRepository.save(subcategoryMapper.destinationToSource(subcategoryDTO));
    }

    public Subcategory updateSubcategory(int id, SubcategoryDTO subcategoryDTO) throws Exception {
        subcategoryDTO.setId(id);
        subcategoryValidator.validate(subcategoryDTO);
        return subcategoryRepository.save(subcategoryMapper.destinationToSource(subcategoryDTO));
    }

    public void deleteSubcategoryById(int id) {
        subcategoryRepository.deleteById(id);
    }

    public List<SubcategoryDTO> getSubcategories() {
        return subcategoryRepository
                .findAll()
                .stream()
                .map(subcategoryMapper::sourceToDestination)
                .toList();
    }
}
