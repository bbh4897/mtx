package tr.com.metix.testproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;
import tr.com.metix.testproject.domain.Users;
import tr.com.metix.testproject.repository.CustomerRepository;
import tr.com.metix.testproject.repository.UsersRepository;
import tr.com.metix.testproject.service.dto.CustomerDTO;
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

    @Override
    public List<UsersDTO> findAll() {
        return usersRepository.findAll().stream()
            .map(usersMapper::usersToUsersDTO)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    @Override
    public Optional<UsersDTO> findById(Long id) {
        return usersRepository.findById(id).map(usersMapper::usersToUsersDTO);
    }

    @Override
    public List<String> findAllCustomer(@RequestParam List<Long> managerId) { // Parametre olarak managerId verıldı (2)

        System.out.println("testtttttt : " + managerId);

        List<Users> users = usersRepository.findAllById(managerId); // managerId'si ? olan userın bılgılerı getırıldı (userId, name, lastname, managerId)

        System.out.println("testtttttt : " + users.size());
        System.out.println("testtttttt : " + users);

        if(!users.isEmpty()){
            throw new BadRequestAlertException("Bu id'ye sahip yönetici bulunmamaktadır.", ENTITY_NAME, "testt");
        }

        ArrayList<Long> arrayList = new ArrayList<>();
        ArrayList<String> arrayList2 = new ArrayList<>();
        List<CustomerDTO> customers = null;
     //   arrayList.add(managerId);

//        for (UsersDTO u: users)
//        {
//            arrayList.add(u.getId());
//        }
//
//        for(Long c : arrayList){
//            customers  = customerRepository.findUsersByIdContains(c);
//        }
//
//
//        for (CustomerDTO c: customers)
//        {
//            arrayList2.add(c.getCustomer_name());
//        }
//


        return arrayList2;
    }


}
