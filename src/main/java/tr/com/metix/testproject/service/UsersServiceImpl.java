package tr.com.metix.testproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tr.com.metix.testproject.repository.CustomerRepository;
import tr.com.metix.testproject.repository.UsersRepository;
import tr.com.metix.testproject.service.dto.UsersDTO;
import tr.com.metix.testproject.service.mapper.UsersMapper;
import tr.com.metix.testproject.web.rest.errors.BadRequestAlertException;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class UsersServiceImpl implements UsersService {

    private static final String ENTITY_NAME = "users";
    private final UsersRepository usersRepository;
    private final CustomerRepository customerRepository;
    private final UsersMapper usersMapper;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    public UsersServiceImpl(UsersRepository usersRepository, CustomerRepository customerRepository, UsersMapper usersMapper) {
        this.usersRepository = usersRepository;
        this.customerRepository = customerRepository;
        this.usersMapper = usersMapper;
    }

//    @Override
//    public List<UsersDTO> findAll() {
//        return usersRepository.findAll().stream()
//            .map(usersMapper::usersToUsersDTO)
//            .collect(Collectors.toCollection(LinkedList::new));
//    }

    @Override
    public Optional<UsersDTO> findById(Long id) {

        return usersRepository.findById(id).map(usersMapper::usersToUsersDTO2);


    }

    @Override
    public List<UsersDTO> findAll() {

        return  usersRepository.findAll().stream().map(usersMapper::usersToUsersDTO2)
            .collect(Collectors.toCollection(LinkedList::new));


    }



}
