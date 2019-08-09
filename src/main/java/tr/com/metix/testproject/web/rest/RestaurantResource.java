package tr.com.metix.testproject.web.rest;

import org.springframework.web.bind.annotation.*;
import tr.com.metix.testproject.service.RestaurantService;
import tr.com.metix.testproject.service.dto.RestaurantDTO;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RestaurantResource {
    private final RestaurantService restaurantService;

    public RestaurantResource(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }


    @DeleteMapping("/restaurantdelete/{id}")
    public void deleteUser(@PathVariable Long id) {

        restaurantService.deleteRestaurant(id);

    }


    @GetMapping("/restaurants")
    public List<RestaurantDTO> selectRestaurant() {
        return restaurantService.getRestaurant();
    }


}
