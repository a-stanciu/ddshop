package dd.projects.ddshop.mappers;

import dd.projects.ddshop.dto.ProductAttributeDTO;
import dd.projects.ddshop.entities.ProductAttribute;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductAttributeMapper {
    ProductAttributeDTO sourceToDestination(ProductAttribute productAttribute);

    ProductAttribute destinationToSource(ProductAttributeDTO productAttributeDTO);
}
