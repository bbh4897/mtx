package tr.com.metix.testproject.service;

import tr.com.metix.testproject.domain.Product;
import tr.com.metix.testproject.service.dto.ProductDTO;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<ProductDTO> findAll(); // Tüm urunlerı getırme

    Optional<ProductDTO> findById(Long id);  // Tek bir ürün getırme

    ProductDTO save(ProductDTO productDTO);
}
