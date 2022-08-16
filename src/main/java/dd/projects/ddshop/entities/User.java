package dd.projects.ddshop.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;

    private String password;

    public User(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        this.email = username;
        this.password = password;
    }

    @OneToOne
    @JoinColumn(name = "default_delivery_address")
    @RestResource(path = "userAddress", rel = "defaultDeliveryAddress")
    private Address defaultDeliveryAddress;

    @OneToOne
    @JoinColumn(name = "default_billing_address")
    @RestResource(path = "userAddress", rel = "defaultBillingAddress")
    private Address defaultBillingAddress;

    @OneToOne(mappedBy = "userId")
    private Cart userId;

    @OneToMany(mappedBy = "userId")
    private List<Order> orderList;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<>();
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
