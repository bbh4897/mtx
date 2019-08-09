package tr.com.metix.testproject.web.rest;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tr.com.metix.testproject.service.RestaurantCategoryService;
import tr.com.metix.testproject.service.dto.RestaurantCategoryDTO;
import tr.com.metix.testproject.service.dto.RestaurantDTO;

import java.net.URISyntaxException;
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
}
