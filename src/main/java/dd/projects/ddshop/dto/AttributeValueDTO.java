package dd.projects.ddshop.dto;

import dd.projects.ddshop.entities.AssignedValue;
import dd.projects.ddshop.entities.ProductAttribute;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AttributeValueDTO {
    private int id;

    private String value;

    private ProductAttribute productAttributeId;

    private List<AssignedValue> assignedValueList;
}
