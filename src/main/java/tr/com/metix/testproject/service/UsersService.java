package tr.com.metix.testproject.service;

import tr.com.metix.testproject.service.dto.CustomerDTO;
import tr.com.metix.testproject.service.dto.UsersDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface UsersService {

    List<UsersDTO> findAll();

    Optional<UsersDTO> findById(Long id);
   // Optional<UsersDTO> findAllById(Long[] userId);

    //List<String> findAllCustomer(List<Long> managerId); // parametre olarak managerId alınacak list seklınde
}
