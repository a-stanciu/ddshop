package dd.projects.ddshop.mappers;

import dd.projects.ddshop.dto.AddressDTO;
import dd.projects.ddshop.entities.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    AddressDTO sourceToDestination(Address address);
    Address destinationToSource(AddressDTO addressDTO);
}
