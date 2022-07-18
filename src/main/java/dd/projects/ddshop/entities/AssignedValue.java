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
public class AssignedValue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "product_attribute_id")
    private ProductAttribute productAttributeId;

    @ManyToOne
    @JoinColumn(name = "attribute_value_id")
    private AttributeValue attributeValueId;

    @ManyToMany(mappedBy = "assignedValueList")
    private List<Variant> variantList;
}
