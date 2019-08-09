package tr.com.metix.testproject.web.rest;

import org.springframework.web.bind.annotation.*;
import tr.com.metix.testproject.service.OrderService;
import tr.com.metix.testproject.service.dto.OrderDTO;
import tr.com.metix.testproject.service.dto.RestaurantDTO;

import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderResource {

    private final OrderService orderService;

    public OrderResource(OrderService orderService) {
        this.orderService = orderService;
    }

    @DeleteMapping("/orderdelete/{id}")
    public void deleteOrder(@PathVariable Long id) {

        orderService.deleteOrder(id);

    }


    @GetMapping("/orders")
    public List<OrderDTO> selectOrder() {
        return orderService.getOrder();
    }


    @PostMapping("/ordercreate")
    public OrderDTO createOrder(@RequestBody OrderDTO orderDTO) throws URISyntaxException {


        OrderDTO orderDTO1 = orderService.createOrder(orderDTO);
        return orderDTO1;
    }

    @PutMapping("/orderupdate")
    public OrderDTO updateOrder (@RequestBody OrderDTO orderDTO) throws URISyntaxException {

        OrderDTO orderDTO1 = orderService.updateOrder(orderDTO);
        return orderDTO1;
    }
}
