package dd.projects.ddshop.dto;

import dd.projects.ddshop.entities.Cart;
import dd.projects.ddshop.entities.Variant;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartEntryDTO {
    private int id;

    private int quantity;

    private int pricePerPiece;

    private int totalPricePerEntry;

    private Cart cartId;

    private Variant variantId;
}
