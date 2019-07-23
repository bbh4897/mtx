package tr.com.metix.testproject.service.dto;

import javax.persistence.*;
import java.io.Serializable;

public class PersonDTO implements Serializable {


    private Long id;
    private String firstName;
    private String lastName;
    private String eMail;
    private String telephone;
    private boolean isBan;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public boolean isBan() {
        return isBan;
    }

    public void setBan(boolean ban) {
        isBan = ban;
    }
}
