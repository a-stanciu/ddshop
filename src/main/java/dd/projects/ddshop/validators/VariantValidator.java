package dd.projects.ddshop.validators;

import dd.projects.ddshop.dto.VariantDTO;
import org.springframework.stereotype.Component;

@Component
public class VariantValidator {
    public void validate(VariantDTO variantDTO) throws Exception {
        if (variantDTO.getProductId() == null) {
            throw new Exception("Product ID cannot be null");
        }

        if (variantDTO.getQuantity() < 0) {
            throw new Exception("Quantity is invalid");
        }

        if (variantDTO.getPrice() < 0) {
            throw new Exception("Price is invalid");
        }
    }
}
