package dd.projects.ddshop.mappers;

import dd.projects.ddshop.dto.OrderDTO;
import dd.projects.ddshop.entities.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderDTO sourceToDestination(Order order);

    Order destinationToSource(OrderDTO orderDTO);
}
