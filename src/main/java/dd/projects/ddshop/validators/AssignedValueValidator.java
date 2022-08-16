package dd.projects.ddshop.validators;

import dd.projects.ddshop.dto.AssignedValueDTO;
import org.springframework.stereotype.Component;

@Component
public class AssignedValueValidator {
    public void validate(AssignedValueDTO assignedValueDTO) throws Exception {
        if (assignedValueDTO.getProductAttributeId() == null) {
            throw new Exception("Product attribute ID cannot be null");
        }

        if (assignedValueDTO.getAttributeValueId() == null) {
            throw new Exception("Attribute value ID cannot be null");
        }
    }
}
