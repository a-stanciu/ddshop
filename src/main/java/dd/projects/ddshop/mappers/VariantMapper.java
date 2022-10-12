package dd.projects.ddshop.mappers;

import dd.projects.ddshop.dto.VariantDTO;
import dd.projects.ddshop.entities.Variant;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface VariantMapper {
    VariantDTO sourceToDestination(Variant variant);

    Variant destinationToSource(VariantDTO variantDTO);
}
