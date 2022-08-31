package dd.projects.ddshop.validators;

import dd.projects.ddshop.dto.CategoryDTO;
import dd.projects.ddshop.exceptions.IllegalInputException;
import org.springframework.stereotype.Component;

@Component
public class CategoryValidator {
    public void validate(CategoryDTO categoryDTO) throws IllegalInputException {
        if (categoryDTO.getName() == null) {
            throw new IllegalInputException("Name cannot be null");
        }
    }
}
