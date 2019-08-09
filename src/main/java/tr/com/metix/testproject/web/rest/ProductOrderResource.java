package tr.com.metix.testproject.web.rest;

import org.springframework.web.bind.annotation.*;
import tr.com.metix.testproject.domain.ProductOrder;
import tr.com.metix.testproject.service.ProductOrderService;
import tr.com.metix.testproject.service.dto.ProductDTO;
import tr.com.metix.testproject.service.dto.ProductOrderDTO;

import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductOrderResource {

    private final ProductOrderService productOrderService;

    public ProductOrderResource(ProductOrderService productOrderService) {
        this.productOrderService = productOrderService;
    }

    @DeleteMapping("/productOrderdelete/{id}")
    public void deleteProductOrder(@PathVariable Long id) {

        productOrderService.deleteProductOrder(id);

    }


    @GetMapping("/productOrders")
    public List<ProductOrderDTO> selectProductOrder() {
        return productOrderService.getProductOrder();
    }


    @PostMapping("/productOrdercreate")
    public ProductOrderDTO createProductOrder(@RequestBody ProductOrderDTO productOrderDTO) throws URISyntaxException {


        ProductOrderDTO productOrderDTO1 = productOrderService.createProductOrder(productOrderDTO);
        return productOrderDTO1;
    }

    @PutMapping("/productOrderupdate")
    public ProductOrderDTO updateProductOrder (@RequestBody ProductOrderDTO productOrderDTO) throws URISyntaxException {

        ProductOrderDTO productOrderDTO1 = productOrderService.updateProductOrder(productOrderDTO);
        return productOrderDTO1;
    }

}
