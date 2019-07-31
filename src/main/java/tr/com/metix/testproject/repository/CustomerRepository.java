package tr.com.metix.testproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.com.metix.testproject.domain.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

    List<Customer> findAllByOwner_IdIn(List<Long> userIds);

   // void deleteById(Long id); /// customerId'sı verılen kısıyı sılme

    void deleteByOwner_Id(Long id); // ownerId2Sı verılen kısının musterılerını sılme


    Optional<Customer> findById(Long id);





}
