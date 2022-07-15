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
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "user_id")
    @RestResource(path = "cartUser", rel = "userId")
    private User userId;

    private int totalPrice;

    @OneToOne(mappedBy = "cartId")
    private Order cartId;

    @OneToMany(mappedBy = "cartId")
    private List<CartEntry> cartEntryList;
}
