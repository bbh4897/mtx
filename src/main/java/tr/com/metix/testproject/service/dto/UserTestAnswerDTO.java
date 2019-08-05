package tr.com.metix.testproject.service.dto;

import java.util.List;
import java.util.Set;

public class UserTestAnswerDTO {

    private Long id;
    private List<UserTestDTO> userTestDTOS;
    private Long answerId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<UserTestDTO> getUserTestDTOS() {
        return userTestDTOS;
    }

    public void setUserTestDTOS(List<UserTestDTO> userTestDTOS) {
        this.userTestDTOS = userTestDTOS;
    }

    public Long getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Long answerId) {
        this.answerId = answerId;
    }
}
