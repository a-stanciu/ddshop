package dd.projects.ddshop.services;

import dd.projects.ddshop.dto.ProductDTO;
import dd.projects.ddshop.mappers.ProductMapper;
import dd.projects.ddshop.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Autowired
    public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public Product createProduct(ProductDTO productDTO) {
        return productRepository.save(productMapper.destinationToSource(productDTO));
    }

    public Product updateProduct(ProductDTO productDTO) {
        return productRepository.save(productMapper.destinationToSource(productDTO));
    }

    public void deleteAddressById(int id) {
        productRepository.deleteById(id);
    }

    public List<ProductDTO> getProducts() {
        return productRepository
                .findAll()
                .stream()
                .map(productMapper::sourceToDestination)
                .toList();
    }

    public ProductRepository getProductRepository() {
        return productRepository;
    }
}
