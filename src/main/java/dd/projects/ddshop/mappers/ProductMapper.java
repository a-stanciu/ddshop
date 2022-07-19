package dd.projects.ddshop.mappers;

import dd.projects.ddshop.dto.ProductDTO;
import dd.projects.ddshop.entities.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDTO sourceToDestination(Product product);

    Product destinationToSource(ProductDTO productDTO);
}
