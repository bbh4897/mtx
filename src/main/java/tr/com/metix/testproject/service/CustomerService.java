package tr.com.metix.testproject.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tr.com.metix.testproject.repository.CustomerRepository;
import tr.com.metix.testproject.service.dto.CustomerDTO;
import tr.com.metix.testproject.service.mapper.CustomerMapper;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;


    public CustomerService(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }



    public List<CustomerDTO> findAllByOwner_IdIn(List<Long> ids){

        return customerRepository.findAllByOwner_IdIn(ids).stream().map(customerMapper::customerToCustomerDTO)
            .collect(Collectors.toCollection(LinkedList::new));
    }



}
