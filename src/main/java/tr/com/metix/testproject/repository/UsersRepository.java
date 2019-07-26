package tr.com.metix.testproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.com.metix.testproject.domain.Users;
import tr.com.metix.testproject.service.dto.UsersDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Long> {

    Optional<Users> findById(Long id);
   // List<UsersDTO> findAllById(ArrayList<Long[]> managerId);
//    List<UsersDTO> findUsersByIdContains(ArrayList<Long[]> managerId);



}
