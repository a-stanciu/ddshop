package dd.projects.ddshop.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class OrderDTO {
    private int id;

    private int totalPrice;

    private Date orderDate;

    private int paymentType;
}
