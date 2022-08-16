package dd.projects.ddshop.validators;

import dd.projects.ddshop.dto.AttributeValueDTO;
import org.springframework.stereotype.Component;

@Component
public class AttributeValueValidator {
    public void validate(AttributeValueDTO attributeValueDTO) throws Exception {
        if (attributeValueDTO.getValue() == null) {
            throw new Exception("Value cannot be null");
        }
    }
}
