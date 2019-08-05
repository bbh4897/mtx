package tr.com.metix.testproject.service.dto;

import java.util.List;
import java.util.Set;

public class AnswerDTO {

    private Long id;
    private String value;

    private List<QuestionsDTO> questionsDTO;

    private boolean isCorrect;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<QuestionsDTO> getQuestionsDTO() {
        return questionsDTO;
    }

    public void setQuestionsDTO(List<QuestionsDTO> questionsDTO) {
        this.questionsDTO = questionsDTO;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }
}


