package tr.com.metix.testproject.service.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import tr.com.metix.testproject.domain.Questions;
import tr.com.metix.testproject.service.dto.QuestionsDTO;

@Mapper(componentModel = "spring")
public interface QuestionsMapper {

    QuestionsMapper INSTANCE = Mappers.getMapper(QuestionsMapper.class);

    @Mapping(source = "tests", target = "testDTOS")
    QuestionsDTO questionsToQuestionsDTO(Questions questions);

    @Mapping(source = "testDTOS", target = "tests")
    Questions questionsDTOToQuestions(QuestionsDTO questionsDTO);
}
