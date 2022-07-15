package dd.projects.ddshop.services;

import dd.projects.ddshop.dto.ProductAttributeDTO;
import dd.projects.ddshop.entities.ProductAttribute;
import dd.projects.ddshop.mappers.ProductAttributeMapper;
import dd.projects.ddshop.repositories.ProductAttributeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductAttributeService {
    private final ProductAttributeRepository productAttributeRepository;
    private final ProductAttributeMapper productAttributeMapper;

    @Autowired
    public ProductAttributeService(ProductAttributeRepository productAttributeRepository, ProductAttributeMapper productAttributeMapper) {
        this.productAttributeRepository = productAttributeRepository;
        this.productAttributeMapper = productAttributeMapper;
    }

    public ProductAttribute createProductAttribute(ProductAttributeDTO productAttributeDTO) {
        return productAttributeRepository.save(productAttributeMapper.destinationToSource(productAttributeDTO));
    }

    public ProductAttribute updateProductAttribute(ProductAttributeDTO productAttributeDTO) {
        return productAttributeRepository.save(productAttributeMapper.destinationToSource(productAttributeDTO));
    }

    public void deleteProductAttributeById(int id) {
        productAttributeRepository.deleteById(id);
    }

    public List<ProductAttributeDTO> getProductAttributes() {
        return productAttributeRepository
                .findAll()
                .stream()
                .map(productAttributeMapper::sourceToDestination)
                .toList();
    }

    public ProductAttributeRepository getProductAttributeRepository() {
        return productAttributeRepository;
    }
}
