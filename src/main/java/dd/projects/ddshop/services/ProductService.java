package dd.projects.ddshop.services;

import dd.projects.ddshop.dto.ProductDTO;
import dd.projects.ddshop.entities.Product;
import dd.projects.ddshop.mappers.ProductMapper;
import dd.projects.ddshop.repositories.ProductRepository;
import dd.projects.ddshop.validators.ProductValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final ProductValidator productValidator;

    @Autowired
    public ProductService(ProductRepository productRepository, ProductMapper productMapper, ProductValidator productValidator) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.productValidator = productValidator;
    }

    public Product createProduct(ProductDTO productDTO) {
        productValidator.validate(productDTO);
        return productRepository.save(productMapper.destinationToSource(productDTO));
    }

    public Product updateProduct(int id, ProductDTO productDTO) {
        productDTO.setId(id);
        productValidator.validate(productDTO);
        return productRepository.save(productMapper.destinationToSource(productDTO));
    }

    public void deleteProductById(int id) {
        productRepository.deleteById(id);
    }

    public ProductDTO getProductById(int id) {
        return productMapper.sourceToDestination(
                productRepository
                        .findById(id)
                        .orElse(null)
        );
    }

    public List<ProductDTO> getProducts() {
        return productRepository
                .findAll()
                .stream()
                .map(productMapper::sourceToDestination)
                .toList();
    }

    public void deleteAllProducts() {
        productRepository.deleteAll();
    }
}
