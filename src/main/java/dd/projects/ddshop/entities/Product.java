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

    private Date addedDate;

    private String pictureUri;

    @ManyToOne
    @JoinColumn(name = "subcategory_id")
    private Subcategory subcategoryId;

    @OneToMany(mappedBy = "productId")
    private List<Variant> variantList;
}
