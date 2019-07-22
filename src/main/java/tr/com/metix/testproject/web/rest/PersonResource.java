package tr.com.metix.testproject.web.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tr.com.metix.testproject.domain.Person;
import tr.com.metix.testproject.service.PersonService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonResource {

    private static final String ENTITY_NAME = "person";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final PersonService personService;


    public PersonResource(PersonService personService) {
        this.personService = personService;
    }

    // Tüm kişileri listeleme
    @GetMapping("/persons")
    public List<Person> getAllPerson() {
        return personService.findAll();
    }



}
