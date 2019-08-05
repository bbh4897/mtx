package tr.com.metix.testproject.service.dto;

import java.util.List;
import java.util.Set;

public class UserTestDTO {

    private Long id;
    private List<UserDTO> userDTOS;
    private List<TestDTO> testDTOS;
    private String status;
    private Long score;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<UserDTO> getUserDTOS() {
        return userDTOS;
    }

    public void setUserDTOS(List<UserDTO> userDTOS) {
        this.userDTOS = userDTOS;
    }

    public List<TestDTO> getTestDTOS() {
        return testDTOS;
    }

    public void setTestDTOS(List<TestDTO> testDTOS) {
        this.testDTOS = testDTOS;
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
