package dd.projects.ddshop.repositories;

import dd.projects.ddshop.entities.Variant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VariantRepository extends JpaRepository<Variant, Integer> {
}
