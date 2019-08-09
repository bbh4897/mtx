package tr.com.metix.testproject.web.rest;

import org.springframework.web.bind.annotation.*;
import tr.com.metix.testproject.service.RestaurantCategoryService;
import tr.com.metix.testproject.service.dto.RestaurantCategoryDTO;
import tr.com.metix.testproject.service.dto.RestaurantDTO;

import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RestaurantCategoryResource {

    private final RestaurantCategoryService restaurantCategoryService;

    public RestaurantCategoryResource(RestaurantCategoryService restaurantCategoryService) {
        this.restaurantCategoryService = restaurantCategoryService;
    }

    @PutMapping("/restaurantCategoryupdate")
    public RestaurantCategoryDTO updateRestaurantCategory (@RequestBody RestaurantCategoryDTO restaurantCategoryDTO) throws URISyntaxException {

        RestaurantCategoryDTO restaurantDTO1 = restaurantCategoryService.updateRestaurantCategory(restaurantCategoryDTO);
        return restaurantCategoryDTO;
    }

    @DeleteMapping("/restaurantCategorydelete/{id}")
    public void deleteUser(@PathVariable Long id) {

        restaurantCategoryService.deleteRestaurantCategory(id);

    }


    @GetMapping("/restaurantCategorys")
    public List<RestaurantCategoryDTO> selectRestaurant() {
        return restaurantCategoryService.getRestaurantCategory();
    }


    @PostMapping("/restaurantCategorycreate")
    public RestaurantCategoryDTO createQuestion(@RequestBody RestaurantCategoryDTO restaurantDTO) throws URISyntaxException {


        RestaurantCategoryDTO restaurantDTO1 = restaurantCategoryService.createRestaurantCategory(restaurantDTO);
        return restaurantDTO1;
    }
}
