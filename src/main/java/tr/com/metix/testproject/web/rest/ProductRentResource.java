package tr.com.metix.testproject.web.rest;


import io.github.jhipster.web.util.HeaderUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tr.com.metix.testproject.domain.Person;
import tr.com.metix.testproject.domain.Product;
import tr.com.metix.testproject.domain.ProductRent;
import tr.com.metix.testproject.service.PersonService;
import tr.com.metix.testproject.service.ProductRentService;
import tr.com.metix.testproject.service.ProductService;
import tr.com.metix.testproject.web.rest.errors.BadRequestAlertException;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProductRentResource {

    private static final String ENTITY_NAME = "product_rent";

//    private final ProductRentRepository productRentRepository;
//    private final PersonRepository personRepository;
//    private final ProductRepository productRepository;

    private final PersonService personService;
    private final ProductService productService;
    private final ProductRentService productRentService;



    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    public ProductRentResource(PersonService personService, ProductService productService, ProductRentService productRentService) {
        this.personService = personService;
        this.productService = productService;
        this.productRentService = productRentService;
    }


    // Kiralanmış tüm ürünleri getirme
    @GetMapping("/productsrent")
    public List<ProductRent> getAllProductRent(){
        return productRentService.findAll();
    }


//    @GetMapping("/productsrent/{id}")
//    public ResponseEntity<ProductRent> getProductRent(@PathVariable Long id){
//        Optional<ProductRent> productRent = productRentRepository.findById(id);
//        return ResponseUtil.wrapOrNotFound(productRent);
//    }

    // Teslim tarihi gecikmiş ürünler (end date < now date)
    @GetMapping("/latedelivery")
    public List<ProductRent> findLateDelivery(){

        ProductRent productRent = null;
        List<ProductRent> late_delivery_products = null;

        if(productRent.getDeliveryDate()==null){
            late_delivery_products = productRentService.findAllByEndDateLessThan(Calendar.getInstance().getTime());
        }
        else{
            late_delivery_products = productRentService.findAllByEndDateLessThan(productRent.getDeliveryDate());
        }


        return late_delivery_products;

    }

    // Kirada olan ürünler (Teslim tarihi null)
    @GetMapping("/currentproductrent")
    public List<ProductRent> AllRentProduct(){
        List<ProductRent> cpr = productRentService.findAllByDeliveryDateIsNull();
        return cpr;
    }

    // Kiraya Verme ( ürün kiralanabilirse ve kişi banlı değilse)
    @PostMapping("/rentproduct")
    public ResponseEntity<ProductRent> createRentProduct(@Valid @RequestBody ProductRent productRent) throws URISyntaxException {


        if(productRent.getPerson().getId()==null) {
            throw new BadRequestAlertException("Kişi idsi zorunludur.", ENTITY_NAME, "testt");
        }
        if(productRent.getProduct().getId()==null) {
            throw new BadRequestAlertException("Ürün idsi zorunludur.", ENTITY_NAME, "testt");
        }

        Optional<Person> person = personService.findById(productRent.getPerson().getId());
        Optional<Product> product = productService.findById(productRent.getProduct().getId());

        if(!person.isPresent()) {
            throw new BadRequestAlertException("Bu idye kayıtlı kişi bulunamadı.", ENTITY_NAME, "testt");
        }

        if(!product.isPresent()) {
            throw new BadRequestAlertException("Bu idye kayıtlı ürün bulunamadı.", ENTITY_NAME, "testt");
        }

        if(person.get().isBan()) {  //(true)
            throw new BadRequestAlertException("Kişi banlı olduğundan kiralama yapılamadı.", ENTITY_NAME, "testt");
        }

        if(product.get().isRent()) {  // (true)
            throw new BadRequestAlertException("Bu ürün zaten kirada.", ENTITY_NAME, "testt");
        }


        product.get().setRent(true);
        productService.save(product.get()); // product'ın güncellenmiş hali save edildi.

        productRent.setPerson(person.get());
        productRent.setProduct(product.get());

        productRentService.save(productRent);


        return ResponseEntity.created(new URI("/api/rentproduct/" + productRent.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, productRent.getId().toString()))
            .body(productRent);
    }


    // Kirayı Bitirme
    @PutMapping("/productsrent")
    public ResponseEntity<ProductRent> updateProductRent(@RequestBody ProductRent productRent) throws URISyntaxException {


        Optional<Product> product = productService.findById(productRent.getProduct().getId());
        Optional<Person> person = personService.findById(productRent.getPerson().getId());
        Optional<ProductRent> pr = productRentService.findById(productRent.getId());
//
        if( (!pr.isPresent())) {
            throw new BadRequestAlertException("Bu idye kayıtlı kiralama işlemi bulunamadı ", ENTITY_NAME, "testt");
        }

        if(pr.get().getDeliveryDate()!=null){
            throw new BadRequestAlertException("Bu ürün zaten teslim edildi", ENTITY_NAME, "testt");
        }


        System.out.println("teslim tarihi : " + productRent.getDeliveryDate());
        System.out.println("IDDDDD : " + productRent.getId());

        // Teslim Tarihi anlık tarih
        productRent.setDeliveryDate(Calendar.getInstance().getTime());
        System.out.println("Teslim tarihi anlık : " + productRent.getDeliveryDate());

        // Ürünün kiralanabilir olması
        product.get().setRent(false);
        productService.save(product.get()); // Ürünün güncellenmiş hali save edildi.

        productRent.setProduct(product.get());

        productRentService.save(productRent);



        return ResponseEntity.created(new URI("/api/rentproduct/" + productRent.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, productRent.getId().toString()))
            .body(productRent);
    }

}
