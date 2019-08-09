package tr.com.metix.testproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.com.metix.testproject.domain.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant,Long> {
}
