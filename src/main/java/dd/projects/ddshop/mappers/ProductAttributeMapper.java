package dd.projects.ddshop.mappers;

import dd.projects.ddshop.dto.ProductAttributeDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductAttributeMapper {
    ProductAttributeDTO sourceToDestination(ProductAttribute productAttribute);
    ProductAttribute destinationToSource(ProductAttributeDTO productAttributeDTO);
}
