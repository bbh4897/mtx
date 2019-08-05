package tr.com.metix.testproject.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import tr.com.metix.testproject.domain.Answer;
import tr.com.metix.testproject.domain.UserTest;
import tr.com.metix.testproject.service.dto.AnswerDTO;
import tr.com.metix.testproject.service.dto.UserTestDTO;

@Mapper(componentModel = "spring")
public interface UserTestMapper {

    UserTestMapper INSTANCE = Mappers.getMapper(UserTestMapper.class);

   // @Mapping(source = "users", target = "userDTOS")
    @Mapping(source = "tests", target = "testDTOS")
    UserTestDTO userTestToUserTestDTO(UserTest userTest);

 //   @Mapping(source = "userDTOS", target = "users")
    @Mapping(source = "testDTOS", target = "tests")
    UserTest userTestDTOToUserTest(UserTestDTO userTestDTO);

}
