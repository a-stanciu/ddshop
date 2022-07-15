package dd.projects.ddshop.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ProductDTO {
    private int id;

    private String name;

    private String description;

    private int price;

    private int availableQuantity;

    private Date addedDate;
}
