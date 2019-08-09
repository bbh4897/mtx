package tr.com.metix.testproject.repository;

import org.hibernate.criterion.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import tr.com.metix.testproject.domain.Restaurant;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
