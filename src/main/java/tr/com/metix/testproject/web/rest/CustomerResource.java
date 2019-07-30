package tr.com.metix.testproject.web.rest;

import io.github.jhipster.web.util.HeaderUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import tr.com.metix.testproject.config.Constants;
import tr.com.metix.testproject.domain.Customer;
import tr.com.metix.testproject.domain.User;
import tr.com.metix.testproject.security.AuthoritiesConstants;
import tr.com.metix.testproject.service.CustomerService;
import tr.com.metix.testproject.service.dto.CustomerDTO;
import tr.com.metix.testproject.service.dto.UserDTO;
import tr.com.metix.testproject.web.rest.errors.BadRequestAlertException;
import tr.com.metix.testproject.web.rest.errors.EmailAlreadyUsedException;
import tr.com.metix.testproject.web.rest.errors.LoginAlreadyUsedException;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerResource {

    private final CustomerService customerService;

    @Value("${jhipster.clientApp.name}")
    private String applicationName;


    public CustomerResource(CustomerService customerService) {
        this.customerService = customerService;
    }

    /// ManagerId'si girilen kişilerin ve altındaki kişilerin müşterılerını getırme
    @GetMapping("/customers")
    public ResponseEntity<List<CustomerDTO>> getAllUsers(@RequestParam Long userId) {

        return new ResponseEntity<List<CustomerDTO>>(customerService.findCustomersByHierarchy(userId), null, HttpStatus.OK);
    }


    // /
    @DeleteMapping("/deletecustomer/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, null, id.toString())).build();
    }



    @PostMapping("/customers")
    public Customer createUser(@Valid @RequestBody CustomerDTO customerDTO) {
        Customer newCustomer;

        if (customerDTO.getId() != null) {
            throw new BadRequestAlertException("Bu id'ye sahip bir müşteri zaten bulunmakta", null, "test");

        } else {
            newCustomer  = customerService.createCustomer(customerDTO);

        }

        return newCustomer;
    }



}
