package tr.com.metix.testproject.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tr.com.metix.testproject.domain.Product;
import tr.com.metix.testproject.domain.Restaurant;
import tr.com.metix.testproject.domain.RestaurantCategory;
import tr.com.metix.testproject.domain.User;
import tr.com.metix.testproject.repository.ProductRepository;
import tr.com.metix.testproject.repository.RestaurantCategoryRepository;
import tr.com.metix.testproject.repository.RestaurantRepository;
import tr.com.metix.testproject.security.SecurityUtils;
import tr.com.metix.testproject.service.dto.ProductDTO;
import tr.com.metix.testproject.service.mapper.ProductMapper;
import tr.com.metix.testproject.web.rest.errors.BadRequestAlertException;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductService {

    private final UserService userService;
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final RestaurantRepository restaurantRepository;
    private final RestaurantCategoryRepository restaurantCategoryRepository;

    public ProductService(UserService userService, ProductRepository productRepository, ProductMapper productMapper, RestaurantRepository restaurantRepository, RestaurantCategoryRepository restaurantCategoryRepository) {
        this.userService = userService;
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.restaurantRepository = restaurantRepository;
        this.restaurantCategoryRepository = restaurantCategoryRepository;
    }

    public void deleteProduct(Long id) throws BadRequestAlertException {
        Optional<User> u = userService.getUserWithAuthoritiesByLogin(SecurityUtils.getCurrentUserLogin().get()); // currentUser tum satır
        Optional<Product> product = productRepository.findById(id); // currentUser uyusan ıdnın tum satırı

//        System.out.println(" Current : " + u.get().getId());
//        System.out.println(" Restaurant : " +restaurant.get().getUser().getId());

        if (u.get().getId() != product.get().getId()) {
            throw new BadRequestAlertException("Yalnızca Restaurant Sahibi ürün Silebilir!! ", null, "test");
        }

        productRepository.deleteById(id);

    }

    public List<ProductDTO> getProduct(){
        List<ProductDTO>  product = productRepository.findAll().stream().map(productMapper::toDTO).collect(Collectors.toCollection(LinkedList::new));
        return product;
    }

    public ProductDTO createProduct (ProductDTO productDTO) throws BadRequestAlertException {

        if (productDTO.getId() != null) {
            throw new BadRequestAlertException("Bu id'ye sahip ürün zaten kayır edilmiş !! ", null, "idexists");
        }

        Product product = productMapper.toEntity(productDTO);
        product = productRepository.save(product);
        return productMapper.toDTO(product);
    }


    public ProductDTO updateProduct (ProductDTO productDTO) throws BadRequestAlertException {

        if (productDTO.getId() == null) {
            throw new BadRequestAlertException("geçersiz ID  ! ", null, "idnull");
        }


        Optional<Product> product = productRepository.findById(productDTO.getId());
        Optional<User> u = userService.getUserWithAuthoritiesByLogin(SecurityUtils.getCurrentUserLogin().get()); // currentUser tum satır

        Optional<RestaurantCategory> restaurantCategory = restaurantCategoryRepository.findById(product.get().getRestaurantCategory().getId());

        Optional<Restaurant> restaurant = restaurantRepository.findById(restaurantCategory.get().getRestaurant().getId());



        if (u.get().getId() != restaurant.get().getUser().getId()) {
            throw new BadRequestAlertException("Yalnızca Restaurant Sahii Restaurant Kategorisi güncelleyebilir!! ", null, "test");
        }

        if(restaurantCategory.get().getRestaurant().getId() != restaurant.get().getId()){
            throw new BadRequestAlertException("Bu restaurant sizin değil", null, "test");
        }


        Product restaurant1 = productMapper.toEntity(productDTO);
        restaurant1 = productRepository.save(restaurant1);
        return productMapper.toDTO(restaurant1);
    }


}
