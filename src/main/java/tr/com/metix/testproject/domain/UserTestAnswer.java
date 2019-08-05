package tr.com.metix.testproject.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class UserTestAnswer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    //@Column(name = "usertestanswer_id")
    private Long id;


    @ManyToMany
    @JoinTable(name = "usertestanswer_usertest",
        joinColumns = @JoinColumn(name = "usertestanswer_id"),
        inverseJoinColumns = @JoinColumn(name = "usertest_id"))
    private Set<UserTest> usertests = new HashSet<>();


    @ManyToOne
    @JsonIgnoreProperties("user_test_answer")
    private Answer answer;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<UserTest> getUsertests() {
        return usertests;
    }

    public void setUsertests(Set<UserTest> usertests) {
        this.usertests = usertests;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }
}
