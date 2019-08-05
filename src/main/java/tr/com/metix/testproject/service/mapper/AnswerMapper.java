package tr.com.metix.testproject.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import tr.com.metix.testproject.domain.Answer;
import tr.com.metix.testproject.domain.Questions;
import tr.com.metix.testproject.service.dto.AnswerDTO;
import tr.com.metix.testproject.service.dto.QuestionsDTO;

@Mapper(componentModel = "spring")
public interface AnswerMapper {

    AnswerMapper INSTANCE = Mappers.getMapper(AnswerMapper.class);

    @Mapping(source = "questions.id", target = "questionsId")
    AnswerDTO answerToAnswerDTO(Answer answer);

    @Mapping(source = "questionsId", target = "questions.id")
    Answer answerDTOToAnswer(AnswerDTO answerDTO);

}
