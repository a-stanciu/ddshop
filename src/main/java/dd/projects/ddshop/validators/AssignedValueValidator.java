package dd.projects.ddshop.validators;

import dd.projects.ddshop.dto.AssignedValueDTO;
import dd.projects.ddshop.exceptions.IllegalInputException;
import org.springframework.stereotype.Component;

@Component
public class AssignedValueValidator {
    public void validate(AssignedValueDTO assignedValueDTO) throws IllegalInputException {
        if (assignedValueDTO.getProductAttributeId() == null) {
            throw new IllegalInputException("Product attribute ID cannot be null");
        }

        if (assignedValueDTO.getAttributeValueId() == null) {
            throw new IllegalInputException("Attribute value ID cannot be null");
        }
    }
}
