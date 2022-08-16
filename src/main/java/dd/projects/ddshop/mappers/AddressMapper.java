package dd.projects.ddshop.mappers;

import dd.projects.ddshop.dto.AddressDTO;
import dd.projects.ddshop.entities.Address;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface AddressMapper {
    AddressDTO sourceToDestination(Address address);

    Address destinationToSource(AddressDTO addressDTO);
}
