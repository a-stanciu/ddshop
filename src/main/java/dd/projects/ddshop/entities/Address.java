package dd.projects.ddshop.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String streetLine;

    private String postalCode;

    private String city;

    private String county;

    private String country;

    @OneToOne(mappedBy = "defaultDeliveryAddress")
    private User userDeliveryAddress;

    @OneToOne(mappedBy = "defaultBillingAddress")
    private User userBillingAddress;

    @OneToOne(mappedBy = "deliveryAddress")
    private Order deliveryAddress;

    @OneToOne(mappedBy = "invoiceAddress")
    private Order invoiceAddress;
}
