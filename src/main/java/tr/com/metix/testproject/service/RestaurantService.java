package tr.com.metix.testproject.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tr.com.metix.testproject.domain.Restaurant;
import tr.com.metix.testproject.domain.User;
import tr.com.metix.testproject.repository.RestaurantRepository;
import tr.com.metix.testproject.repository.UserRepository;
import tr.com.metix.testproject.security.SecurityUtils;
import tr.com.metix.testproject.service.dto.RestaurantDTO;
import tr.com.metix.testproject.service.mapper.RestaurantMapper;
import tr.com.metix.testproject.web.rest.errors.BadRequestAlertException;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class RestaurantService {

    private final UserService userService;
    private final UserRepository userRepository;
    private final RestaurantRepository restaurantRepository;
    private final RestaurantMapper restaurantMapper;

    public RestaurantService(UserService userService, UserRepository userRepository, RestaurantRepository restaurantRepository, RestaurantMapper restaurantMapper) {
        this.userService = userService;
        this.userRepository = userRepository;
        this.restaurantRepository = restaurantRepository;
        this.restaurantMapper = restaurantMapper;
    }


    public void deleteRestaurant(Long id) throws BadRequestAlertException {
        Optional<User> u = userService.getUserWithAuthoritiesByLogin(SecurityUtils.getCurrentUserLogin().get()); // currentUser tum satır
        Optional<Restaurant> restaurant = restaurantRepository.findById(id); // currentUser uyusan ıdnın tum satırı

//        System.out.println(" Current : " + u.get().getId());
//        System.out.println(" Restaurant : " +restaurant.get().getUser().getId());

        if (u.get().getId() != restaurant.get().getUser().getId()) {
            throw new BadRequestAlertException("Yalnızca Restaurant Sahibi Restaurant Silebilir!! ", null, "test");
        }

        restaurantRepository.deleteById(id);

    }


    public List<RestaurantDTO> getRestaurant(){
        List<RestaurantDTO>  restaurant = restaurantRepository.findAll().stream().map(restaurantMapper::toDTO).collect(Collectors.toCollection(LinkedList::new));
        return restaurant;
    }



    public RestaurantDTO createRestaurant (RestaurantDTO restaurantDTO) throws BadRequestAlertException {

        if (restaurantDTO.getId() != null) {
            throw new BadRequestAlertException("Bu id'ye sahip restaurant zaten kayır edilmiş !! ", null, "idexists");
        }

        Restaurant restaurant1 = restaurantMapper.toEntity(restaurantDTO);
        restaurant1 = restaurantRepository.save(restaurant1);
        return restaurantMapper.toDTO(restaurant1);
    }


}
