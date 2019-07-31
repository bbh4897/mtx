package tr.com.metix.testproject.web.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tr.com.metix.testproject.domain.Customer;
import tr.com.metix.testproject.service.CustomerService;
import tr.com.metix.testproject.service.UserService;
import tr.com.metix.testproject.service.dto.CustomerDTO;
import tr.com.metix.testproject.service.dto.UserDTO;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerResource {

    private final CustomerService customerService;
    private final UserService userService;

    @Value("${jhipster.clientApp.name}")
    private String applicationName;


    public CustomerResource(CustomerService customerService, UserService userService) {
        this.customerService = customerService;
        this.userService = userService;
    }




    // /
    @DeleteMapping("/deletecustomer/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
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

    ///// update test

    @GetMapping("/customersupdate")
    public List<UserDTO> getAllUsersUpdate(@RequestParam Long customerId) {

        return  customerService.findCustomersByHierarchy2(customerId);
    }



}




