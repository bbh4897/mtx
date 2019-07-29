package tr.com.metix.testproject.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "customer")
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name="customer_id")
    private Long id;

    @Column(name = "customer_name")
    private String customer_name;


    @Column(name = "customer_lastname")
    private String customer_lastname;

    @ManyToOne
    @JsonIgnoreProperties("customer")
    private User owner;


    ///////////////////////////////////////


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCustomer_lastname() {
        return customer_lastname;
    }

    public void setCustomer_lastname(String customer_lastname) {
        this.customer_lastname = customer_lastname;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
