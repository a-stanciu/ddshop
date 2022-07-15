package dd.projects.ddshop.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String description;

    private int price;

    private int availableQuantity;

    private Date addedDate;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "products_categories",
        joinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id"))
    private List<Category> categoryList;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "products_attributes",
        joinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "product_attribute_id", referencedColumnName = "id"))
    private List<ProductAttribute> productAttributeList;

    @OneToMany(mappedBy = "productId")
    private List<Variant> variantList;
}
