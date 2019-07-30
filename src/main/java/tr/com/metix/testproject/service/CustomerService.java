package tr.com.metix.testproject.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tr.com.metix.testproject.repository.CustomerRepository;
import tr.com.metix.testproject.repository.UserRepository;
import tr.com.metix.testproject.service.dto.CustomerDTO;
import tr.com.metix.testproject.service.dto.UserDTO;
import tr.com.metix.testproject.service.mapper.CustomerMapper;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CustomerService {

    private final UserRepository userRepository;
    private final UserService userService;
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerService(UserRepository userRepository, UserService userService, CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.userRepository = userRepository;
        this.userService = userService;
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    public List<CustomerDTO> findCustomersByHierarchy(Long userId) { // [  (5)  ]
        List<Long> ids = new ArrayList<Long>();
        ids.add(userId); // [ (5)  ]

        List<UserDTO> h = userService.getHierarchicalUserIds(ids); // ownerId'si {5}  olanların listesi [ {6,7} ] **** {6,7} -> {8,9,10,11}

        for(UserDTO u : h){
            ids.add(u.getId()); // [ {5,6,7,8,9,10,11} ]
        }

        return customerRepository.findAllByOwner_IdIn(ids).stream().map(customerMapper::customerToCostumerDTO)
            .collect(Collectors.toCollection(LinkedList::new)); //
    }



}
