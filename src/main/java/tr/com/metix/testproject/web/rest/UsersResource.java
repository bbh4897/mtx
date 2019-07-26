package tr.com.metix.testproject.web.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tr.com.metix.testproject.service.CustomerService;
import tr.com.metix.testproject.service.UsersService;
import tr.com.metix.testproject.service.dto.CustomerDTO;
import tr.com.metix.testproject.service.dto.UsersDTO;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UsersResource {

    private static final String ENTITY_NAME = "users";

    private final UsersService usersService;
    private final CustomerService customerService;


    @Value("${jhipster.clientApp.name}")
    private String applicationName;


    public UsersResource(UsersService usersService, CustomerService customerService, CustomerService customerService1) {
        this.usersService = usersService;
        this.customerService = customerService1;
    }

    @GetMapping("/user")
    public Optional<UsersDTO> getUser(Long id)
    {

        return usersService.findById(id);
    }

    // UserId sı ? olan kısılerın musterısını getır
//    @GetMapping("/user")
//    public Optional<CustomerDTO> getUser(Long id)
//    {
//
//        return customerService.findById(id);
//    }

//    @GetMapping("/customers")
//    public List<String> getAllCustomer(ArrayList<Long> managerId)
//    {
//        return customerService.findAllCustomer(managerId);
//    }



}
