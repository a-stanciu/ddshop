package dd.projects.ddshop.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class VariantCombination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int variantId;

    private int assignedValueId;
}
