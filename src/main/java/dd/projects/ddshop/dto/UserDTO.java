package dd.projects.ddshop.dto;

import dd.projects.ddshop.entities.Address;
import dd.projects.ddshop.entities.Cart;
import dd.projects.ddshop.entities.Order;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Getter
@Setter
public class UserDTO {
    private int id;

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;

    private String password;

    private Address defaultDeliveryAddress;

    private Address defaultBillingAddress;

    private Cart userId;

    private List<Order> orderList;
}
