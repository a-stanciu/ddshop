package dd.projects.ddshop.mappers;

import dd.projects.ddshop.dto.AttributeValueDTO;
import dd.projects.ddshop.entities.AttributeValue;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface AttributeValueMapper {
    AttributeValueDTO sourceToDestination(AttributeValue attributeValue);

    AttributeValue destinationToSource(AttributeValueDTO attributeValueDTO);
}
