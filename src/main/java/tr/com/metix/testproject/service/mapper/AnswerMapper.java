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

    @Mapping(source = "questions", target = "questionsDTO")
    AnswerDTO answerToAnswerDTO(Answer answer);

    @Mapping(source = "questionsDTO", target = "questions")
    Answer answerDTOToAnswer(AnswerDTO answerDTO);

}
