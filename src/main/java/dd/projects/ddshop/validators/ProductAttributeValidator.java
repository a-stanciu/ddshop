package dd.projects.ddshop.validators;

import dd.projects.ddshop.dto.ProductAttributeDTO;
import dd.projects.ddshop.exceptions.IllegalInputException;
import org.springframework.stereotype.Component;

@Component
public class ProductAttributeValidator {
    public void validate(ProductAttributeDTO productAttributeDTO) throws IllegalInputException {
        if (productAttributeDTO.getName() == null) {
            throw new IllegalInputException("Name cannot be null");
        }

        if (productAttributeDTO.getAssignedValue() == null) {
            throw new IllegalInputException("Assigned value cannot be null");
        }
    }
}
