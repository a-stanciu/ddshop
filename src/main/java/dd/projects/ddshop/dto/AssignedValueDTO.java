package dd.projects.ddshop.dto;

import dd.projects.ddshop.entities.AttributeValue;
import dd.projects.ddshop.entities.ProductAttribute;
import dd.projects.ddshop.entities.Variant;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AssignedValueDTO {
    private int id;

    private ProductAttribute productAttributeId;

    private AttributeValue attributeValueId;

    private List<Variant> variantList;
}
