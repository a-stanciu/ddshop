package dd.projects.ddshop.validators;

import dd.projects.ddshop.dto.CartEntryDTO;
import org.springframework.stereotype.Component;

@Component
public class CartEntryValidator {
    public void validate(CartEntryDTO cartEntryDTO) throws Exception {
        if (cartEntryDTO.getQuantity() < 0) {
            throw new Exception("Invalid quantity");
        }

        if (cartEntryDTO.getPricePerPiece() < 0) {
            throw new Exception("Price per piece invalid");
        }

        if (cartEntryDTO.getTotalPricePerEntry() < 0) {
            throw new Exception("Total price per entry invalid");
        }
    }
}
