package tr.com.metix.testproject.web.rest;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tr.com.metix.testproject.service.RestaurantService;

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


}
