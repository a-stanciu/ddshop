package dd.projects.ddshop.validators;

import dd.projects.ddshop.dto.CartDTO;
import org.springframework.stereotype.Component;

@Component
public class CartValidator {
    public void validate(CartDTO cartDTO) throws Exception {
        if (cartDTO.getUserId() == null) {
            throw new Exception("User ID cannot be null");
        }

        if (cartDTO.getTotalPrice() < 0) {
            throw new Exception("Total price is invalid");
        }
    }
}
