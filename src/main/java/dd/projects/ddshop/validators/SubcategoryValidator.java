package dd.projects.ddshop.validators;

import dd.projects.ddshop.dto.SubcategoryDTO;
import org.springframework.stereotype.Component;

@Component
public class SubcategoryValidator {
    public void validate(SubcategoryDTO subcategoryDTO) throws Exception {
        if (subcategoryDTO.getName() == null) {
            throw new Exception("Name cannot be null");
        }
    }
}
