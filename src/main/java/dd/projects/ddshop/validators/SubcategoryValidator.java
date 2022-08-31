package dd.projects.ddshop.validators;

import dd.projects.ddshop.dto.SubcategoryDTO;
import dd.projects.ddshop.exceptions.IllegalInputException;
import org.springframework.stereotype.Component;

@Component
public class SubcategoryValidator {
    public void validate(SubcategoryDTO subcategoryDTO) throws IllegalInputException {
        if (subcategoryDTO.getName() == null) {
            throw new IllegalInputException("Name cannot be null");
        }
    }
}
