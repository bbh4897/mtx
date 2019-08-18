package tr.com.metix.testproject.service.dto;

import java.util.Set;

public class GeneralCategoryDTO {
    private Long id;
    private  String name;
    private Set<RestaurantDTO> restaurants;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<RestaurantDTO> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(Set<RestaurantDTO> restaurants) {
        this.restaurants = restaurants;
    }
}
