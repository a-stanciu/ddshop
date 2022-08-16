package dd.projects.ddshop.dto;

import dd.projects.ddshop.entities.AssignedValue;
import dd.projects.ddshop.entities.CartEntry;
import dd.projects.ddshop.entities.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class VariantDTO {
    private int id;

    private Product productId;

    private int quantity;

    private int price;

    private List<CartEntry> cartEntryList;

    private List<AssignedValue> assignedValueList;

}
