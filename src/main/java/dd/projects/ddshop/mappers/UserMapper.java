package dd.projects.ddshop.mappers;

import dd.projects.ddshop.dto.UserDTO;
import dd.projects.ddshop.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface UserMapper {
    UserDTO sourceToDestination(User user);

    User destinationToSource(UserDTO userDTO);
}
