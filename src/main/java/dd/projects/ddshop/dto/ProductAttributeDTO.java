package dd.projects.ddshop.dto;

import dd.projects.ddshop.entities.AssignedValue;
import dd.projects.ddshop.entities.AttributeValue;
import dd.projects.ddshop.entities.Subcategory;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductAttributeDTO {
    private int id;

    private String name;

    private AssignedValue assignedValue;

    private List<Subcategory> subcategoryList;

    private List<AttributeValue> attributeValueList;
}
