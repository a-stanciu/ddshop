package dd.projects.ddshop.services;

import dd.projects.ddshop.dto.ProductAttributeDTO;
import dd.projects.ddshop.entities.ProductAttribute;
import dd.projects.ddshop.mappers.ProductAttributeMapper;
import dd.projects.ddshop.repositories.ProductAttributeRepository;
import dd.projects.ddshop.validators.ProductAttributeValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductAttributeService {
    private final ProductAttributeRepository productAttributeRepository;
    private final ProductAttributeMapper productAttributeMapper;
    private final ProductAttributeValidator productAttributeValidator;

    @Autowired
    public ProductAttributeService(ProductAttributeRepository productAttributeRepository, ProductAttributeMapper productAttributeMapper, ProductAttributeValidator productAttributeValidator) {
        this.productAttributeRepository = productAttributeRepository;
        this.productAttributeMapper = productAttributeMapper;
        this.productAttributeValidator = productAttributeValidator;
    }

    public ProductAttribute createProductAttribute(ProductAttributeDTO productAttributeDTO) {
        productAttributeValidator.validate(productAttributeDTO);
        return productAttributeRepository.save(productAttributeMapper.destinationToSource(productAttributeDTO));
    }

    public ProductAttribute updateProductAttribute(int id, ProductAttributeDTO productAttributeDTO) {
        productAttributeDTO.setId(id);
        productAttributeValidator.validate(productAttributeDTO);
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
}
