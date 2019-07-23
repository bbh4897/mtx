package tr.com.metix.testproject.service;

import tr.com.metix.testproject.domain.ProductRent;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ProductRentService {

    List<ProductRent> findAll(); // Tüm kiralanmıs urunlerı getırme

//    Optional<ProductRent> findOne(Long id);  // Tek bir kiralanmış ürün getırme

    // Teslim tarihi gecikmiş ürünler ()
    List<ProductRent> findAllByEndDateLessThan(Date date);
    // Şuan kirada olan tüm ürünler
    List<ProductRent> findAllByDeliveryDateIsNull();


    void save(ProductRent productRent);

    Optional<ProductRent> findById(Long id);
}
