package tr.com.metix.testproject.web.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tr.com.metix.testproject.service.UsersService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UsersResource {

    private static final String ENTITY_NAME = "users";
    private final UsersService customerService;
    @Value("${jhipster.clientApp.name}")
    private String applicationName;


    public UsersResource(UsersService customerService) {
        this.customerService = customerService;
    }


//    @GetMapping("/customers")
//    public List<String> getAllCustomer(ArrayList<Long> managerId)
//    {
//        return customerService.findAllCustomer(managerId);
//    }



}
