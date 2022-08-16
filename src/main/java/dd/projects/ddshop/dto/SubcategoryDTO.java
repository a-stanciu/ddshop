package dd.projects.ddshop.dto;

import dd.projects.ddshop.entities.Category;
import dd.projects.ddshop.entities.Product;
import dd.projects.ddshop.entities.ProductAttribute;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SubcategoryDTO {
    private int id;

    private String name;

    private List<Product> productList;

    private List<Category> categoryList;

    private List<ProductAttribute> productAttributeList;
}
