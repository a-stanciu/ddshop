package dd.projects.ddshop.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartEntryDTO {
    private int id;

    private int quantity;

    private int pricePerPiece;

    private int totalPricePerEntry;
}
