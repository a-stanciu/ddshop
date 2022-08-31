package dd.projects.ddshop.validators;

import dd.projects.ddshop.dto.CartDTO;
import dd.projects.ddshop.exceptions.IllegalInputException;
import org.springframework.stereotype.Component;

@Component
public class CartValidator {
    public void validate(CartDTO cartDTO) throws IllegalInputException {
        if (cartDTO.getUserId() == null) {
            throw new IllegalInputException("User ID cannot be null");
        }

        if (cartDTO.getTotalPrice() < 0) {
            throw new IllegalInputException("Total price is invalid");
        }
    }
}
