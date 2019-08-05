package tr.com.metix.testproject.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import tr.com.metix.testproject.domain.UserTest;
import tr.com.metix.testproject.domain.UserTestAnswer;
import tr.com.metix.testproject.service.dto.UserTestAnswerDTO;
import tr.com.metix.testproject.service.dto.UserTestDTO;

@Mapper(componentModel = "spring")
public interface UserTestAnswerMapper {

    UserTestAnswerMapper INSTANCE = Mappers.getMapper(UserTestAnswerMapper.class);

    @Mapping(source = "usertests", target = "userTestDTOS")
    @Mapping(source = "answer.id", target = "answerId")
    UserTestAnswerDTO userTestAnswerToUserTestAnswerDTO(UserTestAnswer userTestAnswer);

    @Mapping(source = "userTestDTOS", target = "usertests")
    @Mapping(source = "answerId", target = "answer.id")
    UserTestAnswer userTestAnswerDTOToUserTestAnswer(UserTestAnswerDTO userTestAnswerDTO);

}
