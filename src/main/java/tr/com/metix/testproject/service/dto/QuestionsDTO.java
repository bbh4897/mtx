package tr.com.metix.testproject.service.dto;

import java.util.Set;

public class QuestionsDTO {


    private Long id;

    private String value;

    private Set<Long> testId;

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

    public Set<Long> getTestId() {
        return testId;
    }

    public void setTestId(Set<Long> testId) {
        this.testId = testId;
    }
}
