package dd.projects.ddshop.validators;

import dd.projects.ddshop.dto.VariantDTO;
import dd.projects.ddshop.exceptions.IllegalInputException;
import org.springframework.stereotype.Component;

@Component
public class VariantValidator {
    public void validate(VariantDTO variantDTO) throws IllegalInputException {
        if (variantDTO.getProductId() == null) {
            throw new IllegalInputException("Product ID cannot be null");
        }

        if (variantDTO.getQuantity() < 0) {
            throw new IllegalInputException("Quantity is invalid");
        }

        if (variantDTO.getPrice() < 0) {
            throw new IllegalInputException("Price is invalid");
        }
    }
}
