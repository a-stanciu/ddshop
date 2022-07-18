package dd.projects.ddshop.services;

import dd.projects.ddshop.dto.SubcategoryDTO;
import dd.projects.ddshop.entities.Subcategory;
import dd.projects.ddshop.mappers.SubcategoryMapper;
import dd.projects.ddshop.repositories.SubcategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubcategoryService {
    private final SubcategoryRepository subcategoryRepository;

    private final SubcategoryMapper subcategoryMapper;

    @Autowired
    public SubcategoryService(SubcategoryRepository subcategoryRepository, SubcategoryMapper subcategoryMapper) {
        this.subcategoryRepository = subcategoryRepository;
        this.subcategoryMapper = subcategoryMapper;
    }

    public Subcategory createSubcategory(SubcategoryDTO subcategoryDTO) {
        return subcategoryRepository.save(subcategoryMapper.destinationToSource(subcategoryDTO));
    }

    public Subcategory updateSubcategory(SubcategoryDTO subcategoryDTO) {
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

    public SubcategoryRepository getSubcategoryRepository() {
        return subcategoryRepository;
    }
}
