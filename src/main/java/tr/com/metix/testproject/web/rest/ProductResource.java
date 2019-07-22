package tr.com.metix.testproject.web.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tr.com.metix.testproject.domain.Product;
import tr.com.metix.testproject.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductResource {

    private static final String ENTITY_NAME = "product";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ProductService productService;


    public ProductResource(ProductService productService) {
        this.productService = productService;
    }

    // Tüm ürünleri listeleme
    @GetMapping("/products")
    public List<Product> getAllProduct() {
        return productService.findAll();
    }

}
