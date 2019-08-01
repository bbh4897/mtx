package tr.com.metix.testproject.web.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tr.com.metix.testproject.domain.Customer;
import tr.com.metix.testproject.domain.User;
import tr.com.metix.testproject.repository.CustomerRepository;
import tr.com.metix.testproject.security.SecurityUtils;
import tr.com.metix.testproject.service.CustomerService;
import tr.com.metix.testproject.service.UserService;
import tr.com.metix.testproject.service.dto.CustomerDTO;
import tr.com.metix.testproject.web.rest.errors.BadRequestAlertException;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CustomerResource {

    private final CustomerService customerService;
    private final UserService userService;
    private final CustomerRepository customerRepository;

    @Value("${jhipster.clientApp.name}")
    private String applicationName;




    public CustomerResource(CustomerService customerService, UserService userService, CustomerRepository customerRepository) {
        this.customerService = customerService;
        this.userService = userService;
        this.customerRepository = customerRepository;
    }




    // /
    @DeleteMapping("/deletecustomer/{id}")
    public void deleteCustomer(@PathVariable Long id) {

        Optional<User> u = userService.getUserWithAuthoritiesByLogin(SecurityUtils.getCurrentUserLogin().get());


        Optional<Customer> customer = customerRepository.findById(id);

        System.out.println("cccccc : " + customer.get().getOwner().getId());

        if(customer.get().getOwner().getId() == u.get().getId()){
            System.out.println(" GİRİYOR : / " + u.get().getId() + " getownerId " + customer.get().getOwner().getId());
            customerService.deleteCustomer(id);
        }
        else{
            throw new BadRequestAlertException("Bu müşteriyi silemezsiniz", null, "test");
        }


//        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, null, id.toString())).build();
    }


/// createCustomer
    @PostMapping("/customercreate")
    public Customer createCustomer(@Valid @RequestBody CustomerDTO customerDTO){

            Customer newCustomer = customerService.createCustomer(customerDTO);
            return newCustomer;
    }


    /// ManagerId'si girilen kişilerin ve altındaki kişilerin müşterılerını getırme
    @GetMapping("/customers")
    public ResponseEntity<List<CustomerDTO>> getAllUsers(@RequestParam Long userId) {

        return new ResponseEntity<List<CustomerDTO>>(customerService.findCustomersByHierarchy(userId), null, HttpStatus.OK);
    }

    ///// update hiyerarşi




    ///// update işlem

    @PutMapping("/customer")
    public Optional<CustomerDTO> updateCustomer2(@Valid @RequestBody CustomerDTO customerDTO) {




        Optional<CustomerDTO> updatedCustomer = customerService.updateCustomer(customerDTO);


        return updatedCustomer;

    }



}




