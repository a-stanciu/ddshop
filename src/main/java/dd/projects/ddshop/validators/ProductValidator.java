package dd.projects.ddshop.validators;

import dd.projects.ddshop.dto.ProductDTO;
import org.springframework.stereotype.Component;

@Component
public class ProductValidator {
    public void validate(ProductDTO productDTO) throws Exception {
        if (productDTO.getName() == null) {
            throw new Exception("Name cannot be null");
        }

        if (productDTO.getDescription() == null) {
            throw new Exception("Description cannot be null");
        }

        if (productDTO.getAddedDate() == null) {
            throw new Exception("Added date cannot be null");
        }
    }
}
