package dd.projects.ddshop.dto;

import dd.projects.ddshop.entities.Subcategory;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CategoryDTO {
    private int id;

    private String name;

    private List<Subcategory> subcategoryList;
}
