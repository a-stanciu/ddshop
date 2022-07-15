package dd.projects.ddshop.mappers;

import dd.projects.ddshop.dto.CartDTO;
import dd.projects.ddshop.entities.Cart;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CartMapper {
    CartDTO sourceToDestination(Cart cart);
    Cart destinationToSource(CartDTO cartDTO);
}
