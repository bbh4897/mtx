package tr.com.metix.testproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.com.metix.testproject.domain.ProductRent;

import java.util.Date;
import java.util.List;

@Repository
public interface ProductRentRepository extends JpaRepository<ProductRent,Long> {

//    public List<ProductRent> findDeliveryDate();

    // Teslim tarihi gecikmiş ürünler ()
    List<ProductRent> findAllByEndDateLessThan(Date date);
    // Şuan kirada olan tüm ürünler
    List<ProductRent> findAllByDeliveryDateIsNull();

}
