package tr.com.metix.testproject.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import tr.com.metix.testproject.domain.Users;
import tr.com.metix.testproject.service.dto.UsersDTO;

@Mapper(componentModel = "spring")
public interface UsersMapper {

    UsersMapper INSTANCE = Mappers.getMapper(UsersMapper.class);

   // @Mapping(source = "users.id", target = "userId")
    UsersDTO usersToUsersDTO(Users users);

 //   @Mapping(source = "userId", target = "users.id")
    Users usersDTOToUsers(UsersDTO usersDTO);
}
