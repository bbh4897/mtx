package tr.com.metix.testproject.service.dto;

import java.util.Set;

public class AnswerDTO {

    private Long id;
    private String value;

    private Set<Long> questionsId;

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

    public Set<Long> getQuestionsId() {
        return questionsId;
    }

    public void setQuestionsId(Set<Long> questionsId) {
        this.questionsId = questionsId;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }
}


