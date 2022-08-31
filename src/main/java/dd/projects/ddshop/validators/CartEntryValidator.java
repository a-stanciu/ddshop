package dd.projects.ddshop.validators;

import dd.projects.ddshop.dto.CartEntryDTO;
import dd.projects.ddshop.exceptions.IllegalInputException;
import org.springframework.stereotype.Component;

@Component
public class CartEntryValidator {
    public void validate(CartEntryDTO cartEntryDTO) throws IllegalInputException {
        if (cartEntryDTO.getQuantity() < 0) {
            throw new IllegalInputException("Invalid quantity");
        }

        if (cartEntryDTO.getPricePerPiece() < 0) {
            throw new IllegalInputException("Price per piece invalid");
        }

        if (cartEntryDTO.getTotalPricePerEntry() < 0) {
            throw new IllegalInputException("Total price per entry invalid");
        }
    }
}
