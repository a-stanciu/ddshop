package dd.projects.ddshop.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "`order`")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userId;

    @OneToOne
    @JoinColumn(name = "delivery_address")
    @RestResource(path = "orderAddress", rel = "deliveryAddress")
    private Address deliveryAddress;

    @OneToOne
    @JoinColumn(name = "invoice_address")
    @RestResource(path = "orderAddress", rel = "invoiceAddress")
    private Address invoiceAddress;

    private int totalPrice;

    private Date orderDate;

    private int paymentType;

    @OneToOne
    @JoinColumn(name = "cart_id")
    @RestResource(path = "orderCart", rel = "cartId")
    private Cart cartId;
}
