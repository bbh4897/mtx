package tr.com.metix.testproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.com.metix.testproject.domain.RestaurantCategory;

public interface RestaurantCategoryRepository extends JpaRepository<RestaurantCategory,Long> {
}
