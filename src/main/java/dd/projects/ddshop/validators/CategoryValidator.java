package dd.projects.ddshop.validators;

import dd.projects.ddshop.dto.CategoryDTO;
import org.springframework.stereotype.Component;

@Component
public class CategoryValidator {
    public void validate(CategoryDTO categoryDTO) throws Exception {
        if (categoryDTO.getName() == null) {
            throw new Exception("Name cannot be null");
        }
    }
}
