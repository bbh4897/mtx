package tr.com.metix.testproject.service;

import tr.com.metix.testproject.domain.Person;

import java.util.List;

public interface PersonService {

    List<Person> findAll(); // Tüm kişileri listeleme

    //  Optional<Person> findOne(Long id);  // Tek bir kişi getırme

}
