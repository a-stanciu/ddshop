package dd.projects.ddshop.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Subcategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToMany(mappedBy = "subcategoryId")
    @JsonManagedReference
    private List<Product> productList;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonBackReference
    private Category categoryId;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "subcategory_product_attribute",
            joinColumns = @JoinColumn(name = "subcategory_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "product_attribute_id", referencedColumnName = "id"))
    private List<ProductAttribute> productAttributeList;
}
