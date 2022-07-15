package dd.projects.ddshop.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.rest.core.annotation.RestResource;

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
    @RestResource(path = "assignedValueProductAttribute", rel = "productAttributeId")
    private ProductAttribute productAttributeId;

    @OneToOne
    @JoinColumn(name = "attribute_value_id")
    @RestResource(path = "assignedValueAttributeValue", rel = "attributeValue")
    private AttributeValue attributeValueId;

    @ManyToMany(mappedBy = "assignedValueList")
    private List<Variant> variantList;

}
