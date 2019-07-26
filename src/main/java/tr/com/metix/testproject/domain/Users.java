package tr.com.metix.testproject.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class Users implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "users_name")
    private String users_name;


    @Column(name = "users_lastname")
    private String users_lastname;

    @ManyToOne
    @JsonIgnoreProperties("users")
    private Users users;



    //////////////////////////////////////////


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

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
}
