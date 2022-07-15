package dd.projects.ddshop.repositories;

import dd.projects.ddshop.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
