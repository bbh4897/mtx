package tr.com.metix.testproject.service.dto;

import java.io.Serializable;

public class UsersDTO implements Serializable {

    private Long id;
    private String users_name;
    private String users_lastname;

    private Long userId;

    /////////////
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsers_name() {
        return users_name;
    }

    public void setUsers_name(String users_name) {
        this.users_name = users_name;
    }

    public String getUsers_lastname() {
        return users_lastname;
    }

    public void setUsers_lastname(String users_lastname) {
        this.users_lastname = users_lastname;
    }
}
