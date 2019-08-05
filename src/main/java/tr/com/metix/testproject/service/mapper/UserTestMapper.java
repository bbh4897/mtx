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

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "test.id", target = "testId")
    UserTestDTO userTestToUserTestDTO(UserTest userTest);

    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "testId", target = "test.id")
    UserTest userTestDTOToUserTest(UserTestDTO userTestDTO);

}
