package tr.com.metix.testproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tr.com.metix.testproject.domain.Person;
import tr.com.metix.testproject.repository.PersonRepository;
import tr.com.metix.testproject.service.dto.PersonDTO;
import tr.com.metix.testproject.service.mapper.PersonMapper;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    private final PersonMapper personMapper;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    public PersonServiceImpl(PersonRepository personRepository, PersonMapper personMapper) {
        this.personRepository = personRepository;
        this.personMapper = personMapper;
    }

    // Tüm kişileri listeleme
    @Override
    @Transactional(readOnly = true)
    public List<PersonDTO> findAll()

    {
        return personRepository.findAll().stream()
            .map(personMapper::personToPersonDTO)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<PersonDTO> findById(Long id)
    {

        return personRepository.findById(id).map(personMapper::personToPersonDTO);
    }
}
