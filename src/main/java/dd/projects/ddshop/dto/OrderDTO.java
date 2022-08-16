package dd.projects.ddshop.dto;

import dd.projects.ddshop.entities.Address;
import dd.projects.ddshop.entities.Cart;
import dd.projects.ddshop.entities.User;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class OrderDTO {
    private int id;

    private User userId;

    private Address deliveryAddress;

    private Address invoiceAddress;

    private int totalPrice;

    private Date orderDate;

    private int paymentType;

    private Cart cartId;
}
