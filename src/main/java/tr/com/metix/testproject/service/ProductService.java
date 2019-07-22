package tr.com.metix.testproject.service;

import tr.com.metix.testproject.domain.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAll(); // Tüm urunlerı getırme

    // Optional<Product> findOne(Long id);  // Tek bir ürün getırme

}
