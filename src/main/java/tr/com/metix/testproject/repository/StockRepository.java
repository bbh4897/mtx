package tr.com.metix.testproject.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import tr.com.metix.testproject.domain.Restaurant;
import tr.com.metix.testproject.domain.Stock;

public interface StockRepository extends JpaRepository<Stock,Long> {
}
