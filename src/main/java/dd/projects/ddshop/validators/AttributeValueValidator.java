package dd.projects.ddshop.validators;

import dd.projects.ddshop.dto.AttributeValueDTO;
import dd.projects.ddshop.exceptions.IllegalInputException;
import org.springframework.stereotype.Component;

@Component
public class AttributeValueValidator {
    public void validate(AttributeValueDTO attributeValueDTO) throws IllegalInputException {
        if (attributeValueDTO.getValue() == null) {
            throw new IllegalInputException("Value cannot be null");
        }
    }
}
