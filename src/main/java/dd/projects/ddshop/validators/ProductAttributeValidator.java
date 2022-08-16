package dd.projects.ddshop.validators;

import dd.projects.ddshop.dto.ProductAttributeDTO;
import org.springframework.stereotype.Component;

@Component
public class ProductAttributeValidator {
    public void validate(ProductAttributeDTO productAttributeDTO) throws Exception {
        if (productAttributeDTO.getName() == null) {
            throw new Exception("Name cannot be null");
        }

        if (productAttributeDTO.getAssignedValue() == null) {
            throw new Exception("Assigned value cannot be null");
        }
    }
}
