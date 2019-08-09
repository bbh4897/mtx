package tr.com.metix.testproject.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tr.com.metix.testproject.domain.Order;
import tr.com.metix.testproject.domain.ProductOrder;
import tr.com.metix.testproject.domain.Restaurant;
import tr.com.metix.testproject.domain.User;
import tr.com.metix.testproject.repository.OrderRepository;
import tr.com.metix.testproject.repository.ProductOrderRepository;
import tr.com.metix.testproject.security.SecurityUtils;
import tr.com.metix.testproject.service.dto.OrderDTO;
import tr.com.metix.testproject.service.dto.ProductOrderDTO;
import tr.com.metix.testproject.service.dto.RestaurantDTO;
import tr.com.metix.testproject.service.mapper.ProductOrderMapper;
import tr.com.metix.testproject.web.rest.errors.BadRequestAlertException;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductOrderService {

    private final UserService userService;
    private final OrderRepository orderRepository;
    private final ProductOrderRepository productOrderRepository;
    private final ProductOrderMapper productOrderMapper;

    public ProductOrderService(UserService userService, OrderRepository orderRepository, ProductOrderRepository productOrderRepository, ProductOrderMapper productOrderMapper) {
        this.userService = userService;
        this.orderRepository = orderRepository;
        this.productOrderRepository = productOrderRepository;
        this.productOrderMapper = productOrderMapper;
    }

    public void deleteProductOrder(Long id) throws BadRequestAlertException {

        Optional<User> u = userService.getUserWithAuthoritiesByLogin(SecurityUtils.getCurrentUserLogin().get()); // currentUer tum satır
        Optional<Order> order = orderRepository.findById(id); // currentUser uyusan ıdnın tum atırı



        if (u.get().getId() != order.get().getUser().getId()) {
            throw new BadRequestAlertException("Yalnızca Restaurant Sahibi Restaurant Silebilir!! ", null, "test");
        }

        productOrderRepository.deleteById(id);

    }


    public List<ProductOrderDTO> getProductOrder(){
        List<ProductOrderDTO>  productOrder = productOrderRepository.findAll().stream().map(productOrderMapper::toDTO).collect(Collectors.toCollection(LinkedList::new));
        return productOrder;
    }



    public ProductOrderDTO createProductOrder (ProductOrderDTO productOrderDTO) throws BadRequestAlertException {

        if (productOrderDTO.getId() != null) {
            throw new BadRequestAlertException("Bu id'ye sahip restaurant zaten kayır edilmiş !! ", null, "idexists");
        }

        ProductOrder productOrder = productOrderMapper.toEntity(productOrderDTO);
        productOrder = productOrderRepository.save(productOrder);
        return productOrderMapper.toDTO(productOrder);
    }


    public ProductOrderDTO updateProductOrder (ProductOrderDTO productOrderDTO) throws BadRequestAlertException {

        if (productOrderDTO.getId() == null) {
            throw new BadRequestAlertException("geçersiz ID ! ", null, "idnull");
        }

        Optional<User> u = userService.getUserWithAuthoritiesByLogin(SecurityUtils.getCurrentUserLogin().get()); // currentUser tum satır
        Optional<ProductOrder> productOrder = productOrderRepository.findById(productOrderDTO.getId()); // currentUser uyusan ıdnın tum satırı
        List<Order> order = orderRepository.findAll();

//        if (u.get().getId() != productOrder.get().getOrders()) {
//            throw new BadRequestAlertException("Yalnızca Restaurant Sahibi Restaurant güncelleyebilir!! ", null, "test");
//        }


        ProductOrder productOrder1 = productOrderMapper.toEntity(productOrderDTO);
        productOrder1 = productOrderRepository.save(productOrder1);
        return productOrderMapper.toDTO(productOrder1);
    }
}
