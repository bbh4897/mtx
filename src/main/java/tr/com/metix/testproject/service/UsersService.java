package tr.com.metix.testproject.service;

import tr.com.metix.testproject.service.dto.UserDTO;
import tr.com.metix.testproject.service.dto.UsersDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface UsersService {


    Optional<UsersDTO> findById(Long id);

    List<UsersDTO> findAll();




}
