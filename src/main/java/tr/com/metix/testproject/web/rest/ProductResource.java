package tr.com.metix.testproject.web.rest;

import org.springframework.web.bind.annotation.*;
import tr.com.metix.testproject.service.ProductService;
import tr.com.metix.testproject.service.dto.ProductDTO;
import tr.com.metix.testproject.service.dto.RestaurantDTO;

import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductResource {

    private final ProductService productService;

    public ProductResource(ProductService productService) {
        this.productService = productService;
    }

    @DeleteMapping("/productdelete/{id}")
    public void deleteProduct(@PathVariable Long id) {

        productService.deleteProduct(id);

    }


    @GetMapping("/products")
    public List<ProductDTO> selectProduct() {
        return productService.getProduct();
    }


    @PostMapping("/productcreate")
    public ProductDTO createProduct(@RequestBody ProductDTO productDTO) throws URISyntaxException {


        ProductDTO productDTO1 = productService.createProduct(productDTO);
        return productDTO1;
    }

    @PutMapping("/productupdate")
    public ProductDTO updateProduct (@RequestBody ProductDTO productDTO) throws URISyntaxException {

        ProductDTO productDTO1 = productService.updateProduct(productDTO);
        return productDTO1;
    }


}
