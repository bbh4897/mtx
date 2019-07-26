package tr.com.metix.testproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tr.com.metix.testproject.repository.CustomerRepository;
import tr.com.metix.testproject.service.dto.CustomerDTO;
import tr.com.metix.testproject.service.mapper.CustomerMapper;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

//    private final CustomerRepository customerRepository;
//    private final CustomerMapper customerMapper;
//
//    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
//    @Autowired
//    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
//        this.customerRepository = customerRepository;
//        this.customerMapper = customerMapper;
//    }
//
//    @Override
//    public List<CustomerDTO> findAll() {
//        return customerRepository.findAll().stream()
//            .map(customerMapper::customerToCustomerDTO)
//            .collect(Collectors.toCollection(LinkedList::new));
//    }
//
//    @Override
//    public Optional<CustomerDTO> findById(Long id) {
//        return customerRepository.findById(id).map(customerMapper::customerToCustomerDTO);
//    }
//


}
