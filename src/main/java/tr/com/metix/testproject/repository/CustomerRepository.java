package tr.com.metix.testproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.com.metix.testproject.domain.Customer;
import tr.com.metix.testproject.service.dto.CustomerDTO;

import java.util.ArrayList;
import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

//    List<CustomerDTO> findAllByIdContains(ArrayList<Long[]> userId);

    List<CustomerDTO> findUsersByIdContains(Long userId);
    List<Customer> findAll();

}
