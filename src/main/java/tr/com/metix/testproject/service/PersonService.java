package tr.com.metix.testproject.service;

import tr.com.metix.testproject.domain.Person;
import tr.com.metix.testproject.service.dto.PersonDTO;

import java.util.List;
import java.util.Optional;

public interface PersonService {

    List<PersonDTO> findAll(); // Tüm kişileri listeleme

    Optional<PersonDTO> findById(Long id);  // Tek bir kişi getırme

}
