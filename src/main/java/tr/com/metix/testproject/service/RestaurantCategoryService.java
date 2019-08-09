package tr.com.metix.testproject.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tr.com.metix.testproject.domain.Restaurant;
import tr.com.metix.testproject.domain.RestaurantCategory;
import tr.com.metix.testproject.domain.User;
import tr.com.metix.testproject.repository.RestaurantCategoryRepository;
import tr.com.metix.testproject.repository.RestaurantRepository;
import tr.com.metix.testproject.security.SecurityUtils;
import tr.com.metix.testproject.service.dto.RestaurantCategoryDTO;
import tr.com.metix.testproject.service.mapper.RestaurantCategoryMapper;
import tr.com.metix.testproject.web.rest.errors.BadRequestAlertException;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class RestaurantCategoryService {

    private final UserService userService;
    private final RestaurantCategoryRepository restaurantCategoryRepository;
    private final RestaurantCategoryMapper restaurantCategoryMapper;
    private final RestaurantRepository restaurantRepository;

    public RestaurantCategoryService(UserService userService, RestaurantCategoryRepository restaurantCategoryRepository, RestaurantCategoryMapper restaurantCategoryMapper, RestaurantRepository restaurantRepository) {
        this.userService = userService;
        this.restaurantCategoryRepository = restaurantCategoryRepository;
        this.restaurantCategoryMapper = restaurantCategoryMapper;
        this.restaurantRepository = restaurantRepository;
    }

    public void deleteRestaurantCategory(Long id) throws BadRequestAlertException {
        Optional<User> u = userService.getUserWithAuthoritiesByLogin(SecurityUtils.getCurrentUserLogin().get()); // currentUser tum satır
        Optional<RestaurantCategory> restaurant = restaurantCategoryRepository.findById(id); // currentUser uyusan ıdnın tum satırı

//        System.out.println(" Current : " + u.get().getId());
//        System.out.println(" Restaurant : " +restaurant.get().getUser().getId());

        if (u.get().getId() != restaurant.get().getRestaurant().getId()) {
            throw new BadRequestAlertException("Yalnızca Restaurant Sahibi Restaurant Kategorisi Silebilir!! ", null, "test");
        }

        restaurantCategoryRepository.deleteById(id);

    }

    public List<RestaurantCategoryDTO> getRestaurantCategory(){
        List<RestaurantCategoryDTO>  restaurant = restaurantCategoryRepository.findAll().stream().map(restaurantCategoryMapper::toDTO).collect(Collectors.toCollection(LinkedList::new));
        return restaurant;
    }

    public RestaurantCategoryDTO createRestaurantCategory (RestaurantCategoryDTO restaurantCategoryDTO) throws BadRequestAlertException {

        if (restaurantCategoryDTO.getId() != null) {
            throw new BadRequestAlertException("Bu id'ye sahip restaurant kategori zaten kayır edilmiş !! ", null, "idexists");
        }

        RestaurantCategory restaurant1 = restaurantCategoryMapper.toEntity(restaurantCategoryDTO);
        restaurant1 = restaurantCategoryRepository.save(restaurant1);
        return restaurantCategoryMapper.toDTO(restaurant1);
    }


    public RestaurantCategoryDTO updateRestaurantCategory (RestaurantCategoryDTO restaurantCategoryDTO) throws BadRequestAlertException {

        if (restaurantCategoryDTO.getId() == null) {
            throw new BadRequestAlertException("geçersiz ID  ! ", null, "idnull");
        }

        Optional<RestaurantCategory> restaurantCategory = restaurantCategoryRepository.findById(restaurantCategoryDTO.getId());
        Optional<User> u = userService.getUserWithAuthoritiesByLogin(SecurityUtils.getCurrentUserLogin().get()); // currentUser tum satır
        Optional<Restaurant> restaurant = restaurantRepository.findById(restaurantCategory.get().getRestaurant().getId());

//        System.out.println(" Current : " + u.get().getId());
//        System.out.println(" Restaurant : " +restaurant.get().getUser().getId());

        if (u.get().getId() != restaurant.get().getUser().getId()) {
            throw new BadRequestAlertException("Yalnızca Restaurant Sahibi Restaurant Kategorisi güncelleyebilir!! ", null, "test");
        }

        if(restaurantCategory.get().getRestaurant().getId() != restaurant.get().getId()){
            throw new BadRequestAlertException("Bu restaurant sizin değil", null, "test");
        }




        RestaurantCategory restaurant1 = restaurantCategoryMapper.toEntity(restaurantCategoryDTO);
        restaurant1 = restaurantCategoryRepository.save(restaurant1);
        return restaurantCategoryMapper.toDTO(restaurant1);
    }

}
