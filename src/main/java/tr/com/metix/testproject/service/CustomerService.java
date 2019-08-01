package tr.com.metix.testproject.service;


import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tr.com.metix.testproject.domain.Authority;
import tr.com.metix.testproject.domain.Customer;
import tr.com.metix.testproject.domain.User;
import tr.com.metix.testproject.repository.CustomerRepository;
import tr.com.metix.testproject.repository.UserRepository;
import tr.com.metix.testproject.service.dto.CustomerDTO;
import tr.com.metix.testproject.service.dto.UserDTO;
import tr.com.metix.testproject.service.mapper.CustomerMapper;
import tr.com.metix.testproject.service.mapper.UserMapper;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class CustomerService {

    private final UserRepository userRepository;
    private final UserService userService;
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    private final UserMapper userMapper;

    public CustomerService(UserRepository userRepository, UserService userService, CustomerRepository customerRepository, CustomerMapper customerMapper, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userService = userService;
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
        this.userMapper = userMapper;
    }

    public List<CustomerDTO> findCustomersByHierarchy(Long userId) { // [  (5)  ]     OWNERID
        List<Long> ids = new ArrayList<Long>();
        ids.add(userId); // [ (5)  ]

        List<UserDTO> h = userService.getHierarchicalUserIds(ids); // ownerId'si {5}  olanların listesi [ {6,7} ] **** {6,7} -> {8,9,10,11}

        for(UserDTO u : h){
            ids.add(u.getId()); // [ {5,6,7,8,9,10,11} ]
        }

//        customerRepository.findAllByOwner_IdIn(ids, PageRequest.of(0, 50, Sort.by("name").ascending().and(Sort.by("surname").descending())));
        return customerRepository.findAllByOwner_IdIn(ids, PageRequest.of(0, 50)).stream().map(customerMapper::customerToCostumerDTO)
            .collect(Collectors.toCollection(LinkedList::new)); //
    }

    /////////////

    public void deleteCustomer(Long id) {

        customerRepository.deleteById(id);

    }

    // create customer
    public Customer createCustomer(CustomerDTO customerDTO) {

        Customer customer = new Customer();

        customer.setName(customerDTO.getName());

        Optional<User> u = userRepository.findById(customerDTO.getOwnerId());

        customer.setOwner(u.get());

        customerRepository.save(customer);
        return customer;
    }


    ////// update
//    List<Long> ids = new ArrayList<>();

    public List<Long> findCustomersByHierarchy2(Long customerId) { // [  (4)  ]



        Optional<CustomerDTO> c = customerRepository.findById(customerId).map(customerMapper::customerToCostumerDTO); // id'si 4 olan satır

//        System.out.println("xxxxxxxxxxx : " + c.get().getId());
//        ids.add(c.get().getOwnerId()); // 8
//

        System.out.println("ownerId : " + c.get().getOwnerId()); // 7

        List<Long> h = userService.asd(c.get().getOwnerId()); // 7 -- 6 -- 5

//        System.out.println("hhhhh : " + h.get(0).getManagerId());



        return h; // 7 -- 6 -- 5
    }




}
