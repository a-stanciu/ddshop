package dd.projects.ddshop.mappers;

import dd.projects.ddshop.dto.AssignedValueDTO;
import dd.projects.ddshop.entities.AssignedValue;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AssignedValueMapper {
    AssignedValueDTO sourceToDestination(AssignedValue assignedValue);

    AssignedValue destinationToSource(AssignedValueDTO assignedValueDTO);
}
