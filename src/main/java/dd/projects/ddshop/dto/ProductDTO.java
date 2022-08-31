package dd.projects.ddshop.dto;

import dd.projects.ddshop.entities.Subcategory;
import dd.projects.ddshop.entities.Variant;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class ProductDTO {
    private int id;

    private String name;

    private String description;

    private Date addedDate;

    private String pictureUri;

    private Subcategory subcategoryId;

    private List<Variant> variantList;
}
