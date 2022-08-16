package dd.projects.ddshop.dto;

import dd.projects.ddshop.entities.CartEntry;
import dd.projects.ddshop.entities.Order;
import dd.projects.ddshop.entities.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CartDTO {
    private int id;

    private User userId;

    private int totalPrice;

    private Order cartId;

    private List<CartEntry> cartEntryList;
}
