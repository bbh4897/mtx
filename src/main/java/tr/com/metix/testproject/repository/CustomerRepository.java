package tr.com.metix.testproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.com.metix.testproject.domain.Customer;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

    List<Customer> findAllByOwner_IdIn(List<Long> userIds);

   // void deleteById(Long id); /// customerId'sı verılen kısıyı sılme

    void deleteByOwner_Id(Long id); // ownerId2Sı verılen kısının musterılerını sılme

}
