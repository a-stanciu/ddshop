package dd.projects.ddshop.mappers;

import dd.projects.ddshop.dto.CartEntryDTO;
import dd.projects.ddshop.entities.CartEntry;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CartEntryMapper {
    CartEntryDTO sourceToDestination(CartEntry cartEntry);
    CartEntry destinationToSource(CartEntryDTO cartEntryDTO);
}
