package dd.projects.ddshop.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Variant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product productId;

    private int quantity;

    private int price;

    @OneToMany(mappedBy = "variantId")
    private List<CartEntry> cartEntryList;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "variant_combination",
            joinColumns = @JoinColumn(name = "variant_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "assigned_value_id", referencedColumnName = "id"))
    private List<AssignedValue> assignedValueList;

}
