package tr.com.metix.testproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.com.metix.testproject.domain.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person,Long> {

    // Kişi Banlı mı?(Banlı olmayan  / false )
    // boolean findAllByBanIsFalse();
}
