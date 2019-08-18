package tr.com.metix.testproject.web.rest;

import org.springframework.web.bind.annotation.*;
import tr.com.metix.testproject.domain.ProductOrder;
import tr.com.metix.testproject.service.ProductOrderService;
import tr.com.metix.testproject.service.dto.ProductOrderDTO;
import tr.com.metix.testproject.service.dto.RestaurantCategoryDTO;

import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductOrderResource {
    private final ProductOrderService productOrderService;

    public ProductOrderResource(ProductOrderService productOrderService) {
        this.productOrderService = productOrderService;
    }

    @GetMapping("/productOrders")
    public List<ProductOrderDTO> selectProductOrder() {
        return productOrderService.getProductOrder();
    }

    @PostMapping("/productOrdercreate")
    public ProductOrderDTO createProductOrder(@RequestBody ProductOrderDTO productOrderDTO) throws URISyntaxException {

        ProductOrderDTO restaurantCategoryDTO1 = productOrderService.createProductOrder(productOrderDTO);
        return restaurantCategoryDTO1;
    }


    @DeleteMapping("/deleteProductOrder/{id}")
    public void deleteProductOrder(@PathVariable Long id) {

        productOrderService.deleteProductOrder(id);

    }

    @PutMapping("/updateProductOrder")
    public ProductOrderDTO updateProductOrder (@RequestBody ProductOrderDTO productOrderDTO) throws URISyntaxException {

        ProductOrderDTO productOrderDTO1 = productOrderService.updtaeProductOrder(productOrderDTO);
        return productOrderDTO1;
    }
}
