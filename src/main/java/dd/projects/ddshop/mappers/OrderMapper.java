package dd.projects.ddshop.mappers;

import dd.projects.ddshop.dto.OrderDTO;
import dd.projects.ddshop.entities.Order;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderMapper {
    OrderDTO sourceToDestination(Order order);

    Order destinationToSource(OrderDTO orderDTO);
}
