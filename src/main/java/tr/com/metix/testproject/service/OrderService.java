package tr.com.metix.testproject.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tr.com.metix.testproject.domain.Order;
import tr.com.metix.testproject.domain.Restaurant;
import tr.com.metix.testproject.domain.User;
import tr.com.metix.testproject.repository.OrderRepository;
import tr.com.metix.testproject.security.SecurityUtils;
import tr.com.metix.testproject.service.dto.OrderDTO;
import tr.com.metix.testproject.service.dto.RestaurantDTO;
import tr.com.metix.testproject.service.mapper.OrderMapper;
import tr.com.metix.testproject.web.rest.errors.BadRequestAlertException;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class OrderService {

    private final UserService userService;
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    public OrderService(UserService userService, OrderRepository orderRepository, OrderMapper orderMapper) {
        this.userService = userService;
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }


    public void deleteOrder(Long id) throws BadRequestAlertException {
        Optional<User> u = userService.getUserWithAuthoritiesByLogin(SecurityUtils.getCurrentUserLogin().get()); // currentUser tum satır
        Optional<Order> order = orderRepository.findById(id); // currentUser uyusan ıdnın tum satırı

//        System.out.println(" Current : " + u.get().getId());
//        System.out.println(" Restaurant : " +restaurant.get().getUser().getId());

        if (u.get().getId() != order.get().getUser().getId()) {
            throw new BadRequestAlertException("Yalnızca Restaurant Sahibi Restaurant Silebilir!! ", null, "test");
        }

        orderRepository.deleteById(id);

    }


    public List<OrderDTO> getOrder(){
        List<OrderDTO>  order = orderRepository.findAll().stream().map(orderMapper::toDTO).collect(Collectors.toCollection(LinkedList::new));
        return order;
    }



    public OrderDTO createOrder (OrderDTO orderDTO) throws BadRequestAlertException {

        if (orderDTO.getId() != null) {
            throw new BadRequestAlertException("Bu id'ye sahip restaurant zaten kayır edilmiş !! ", null, "idexists");
        }

        Order order = orderMapper.toEntity(orderDTO);
        order = orderRepository.save(order);
        return orderMapper.toDTO(order);
    }


    public OrderDTO updateOrder (OrderDTO orderDTO) throws BadRequestAlertException {

        if (orderDTO.getId() == null) {
            throw new BadRequestAlertException("geçersiz ID ! ", null, "idnull");
        }

        Optional<User> u = userService.getUserWithAuthoritiesByLogin(SecurityUtils.getCurrentUserLogin().get()); // currentUser tum satır
        Optional<Order> order = orderRepository.findById(orderDTO.getId()); // currentUser uyusan ıdnın tum satırı

//        System.out.println(" Current : " + u.get().getId());
//        System.out.println(" Restaurant : " +restaurant.get().getUser().getId());

        if (u.get().getId() != order.get().getUser().getId()) {
            throw new BadRequestAlertException("Yalnızca Müşteri Restaurant Silebilir!! ", null, "test");
        }


        Order order1 = orderMapper.toEntity(orderDTO);
        order1 = orderRepository.save(order1);
        return orderMapper.toDTO(order1);
    }

}
