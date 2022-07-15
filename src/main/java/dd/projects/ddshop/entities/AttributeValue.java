package dd.projects.ddshop.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class AttributeValue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "product_attribute_id")
    private ProductAttribute productAttributeId;

    private String value;

    @OneToOne(mappedBy = "attributeValueId")
    private AssignedValue attributeValueId;
}
