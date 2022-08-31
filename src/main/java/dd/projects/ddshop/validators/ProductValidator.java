package dd.projects.ddshop.validators;

import dd.projects.ddshop.dto.ProductDTO;
import dd.projects.ddshop.exceptions.IllegalInputException;
import org.springframework.stereotype.Component;

@Component
public class ProductValidator {
    public void validate(ProductDTO productDTO) throws IllegalInputException {
        if (productDTO.getName() == null) {
            throw new IllegalInputException("Name cannot be null");
        }

        if (productDTO.getDescription() == null) {
            throw new IllegalInputException("Description cannot be null");
        }

        if (productDTO.getAddedDate() == null) {
            throw new IllegalInputException("Added date cannot be null");
        }
    }
}
