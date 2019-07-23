package tr.com.metix.testproject.service;

import tr.com.metix.testproject.domain.Person;

import java.util.List;
import java.util.Optional;

public interface PersonService {

    List<Person> findAll(); // Tüm kişileri listeleme

    Optional<Person> findById(Long id);  // Tek bir kişi getırme

}
