package tr.com.metix.testproject.service;

import tr.com.metix.testproject.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> findAll(); // Tüm urunlerı getırme

    Optional<Product> findById(Long id);  // Tek bir ürün getırme

    void save(Product product);
}
