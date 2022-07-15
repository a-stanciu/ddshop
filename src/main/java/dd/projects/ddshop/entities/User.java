package dd.projects.ddshop.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;

    private String password;

    @OneToOne
    @JoinColumn(name = "default_delivery_address")
    @RestResource(path = "userAddress", rel = "defaultDeliveryAddress")
    private Address defaultDeliveryAddress;

    @OneToOne
    @JoinColumn(name = "default_billing_address")
    @RestResource(path = "userAddress", rel = "defaultBillingAddress")
    private Address defaultBillingAddress;

    @OneToOne(mappedBy = "userId")
    private Cart userId;

    @OneToMany(mappedBy = "userId")
    private List<Order> orderList;
}
