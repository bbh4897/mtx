package tr.com.metix.testproject.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tr.com.metix.testproject.domain.Restaurant;
import tr.com.metix.testproject.domain.User;
import tr.com.metix.testproject.repository.RestaurantRepository;
import tr.com.metix.testproject.repository.UserRepository;
import tr.com.metix.testproject.security.SecurityUtils;
import tr.com.metix.testproject.web.rest.errors.BadRequestAlertException;

import java.util.Optional;

@Service
@Transactional
public class RestaurantService {

    private final UserService userService;
    private final UserRepository userRepository;
    private final RestaurantRepository restaurantRepository;

    public RestaurantService(UserService userService, UserRepository userRepository, RestaurantRepository restaurantRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
        this.restaurantRepository = restaurantRepository;
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

}
