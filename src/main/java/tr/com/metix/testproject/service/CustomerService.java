package tr.com.metix.testproject.service;

import tr.com.metix.testproject.service.dto.CustomerDTO;
import java.util.Optional;

public interface CustomerService {

//    List<CustomerDTO> findAll();
//
//    Optional<CustomerDTO> findById(Long id);

    Optional<CustomerDTO> findById(Long id);
}
