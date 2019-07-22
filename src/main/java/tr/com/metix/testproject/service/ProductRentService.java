package tr.com.metix.testproject.service;

import tr.com.metix.testproject.domain.ProductRent;

import java.util.List;

public interface ProductRentService {

    List<ProductRent> findAll(); // Tüm kiralanmıs urunlerı getırme

//    Optional<ProductRent> findOne(Long id);  // Tek bir kiralanmış ürün getırme


}
