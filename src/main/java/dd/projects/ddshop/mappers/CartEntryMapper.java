package dd.projects.ddshop.mappers;

import dd.projects.ddshop.dto.CartEntryDTO;
import dd.projects.ddshop.entities.CartEntry;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CartEntryMapper {
    CartEntryDTO sourceToDestination(CartEntry cartEntry);

    CartEntry destinationToSource(CartEntryDTO cartEntryDTO);
}
