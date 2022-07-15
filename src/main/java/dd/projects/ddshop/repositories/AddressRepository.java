package dd.projects.ddshop.repositories;

import dd.projects.ddshop.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
    //List<Address> getAllByCityIsInAndCountryEquals(String city);
}
