package tr.com.metix.testproject.service.dto;

import java.util.Set;

public class UserTestDTO {

    private Long id;
    private Set<Long> userId;
    private Set<Long> testId;
    private String status;
    private Long score;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Long> getUserId() {
        return userId;
    }

    public void setUserId(Set<Long> userId) {
        this.userId = userId;
    }

    public Set<Long> getTestId() {
        return testId;
    }

    public void setTestId(Set<Long> testId) {
        this.testId = testId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }
}
