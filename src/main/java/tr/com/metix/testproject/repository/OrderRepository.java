package tr.com.metix.testproject.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import tr.com.metix.testproject.domain.Order;

public interface OrderRepository extends JpaRepository<Order,Long> {
}