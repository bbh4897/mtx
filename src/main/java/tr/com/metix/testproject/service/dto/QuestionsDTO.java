package tr.com.metix.testproject.service.dto;

import tr.com.metix.testproject.domain.Test;

import java.util.List;
import java.util.Set;

public class QuestionsDTO {


    private Long id;

    private String value;

    private List<TestDTO> testDTOS;

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


    public List<TestDTO> getTestDTOS() {
        return testDTOS;
    }

    public void setTestDTOS(List<TestDTO> testDTOS) {
        this.testDTOS = testDTOS;
    }
}
