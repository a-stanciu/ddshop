package dd.projects.ddshop.mappers;

import dd.projects.ddshop.dto.AddressDTO;
import dd.projects.ddshop.entities.Address;
import dd.projects.ddshop.entities.User;
import dd.projects.ddshop.services.UserService;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class AddressMapper {

    @Autowired
    UserService userService;

    public abstract AddressDTO sourceToDestination(Address address);

    public abstract Address destinationToSource(AddressDTO addressDTO);

    protected Integer fromUserToInteger(User value) {
        return value.getId();
    }

    protected User fromIntegerToUser(Integer value) {
        return userService.getUserById(value);
    }
}
