package dd.projects.ddshop.dto;

import dd.projects.ddshop.entities.Order;
import dd.projects.ddshop.entities.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDTO {
    private int id;

    private String streetLine;

    private String postalCode;

    private String city;

    private String county;

    private String country;

    private User userDeliveryAddress;

    private User userBillingAddress;

    private Order deliveryAddress;

    private Order invoiceAddress;
}
