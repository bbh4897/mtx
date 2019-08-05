package tr.com.metix.testproject.service.dto;

import java.util.Set;

public class UserTestAnswerDTO {

    private Long id;
    private Set<Long> userTestId;
    private Long answerId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Long> getUserTestId() {
        return userTestId;
    }

    public void setUserTestId(Set<Long> userTestId) {
        this.userTestId = userTestId;
    }

    public Long getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Long answerId) {
        this.answerId = answerId;
    }
}
