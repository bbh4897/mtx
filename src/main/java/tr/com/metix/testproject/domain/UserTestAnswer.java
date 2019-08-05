package tr.com.metix.testproject.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class UserTestAnswer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "usertestanswer_id")
    private Long id;


    @ManyToMany
    @JoinTable(name = "usertestanswer_usertest",
        joinColumns = @JoinColumn(name = "usertestanswer_id"),
        inverseJoinColumns = @JoinColumn(name = "usertest_id"))
    private Set<UserTest> usertests = new HashSet<>();


    @ManyToMany
    @JoinTable(name = "usertestanswer_answer",
        joinColumns = @JoinColumn(name = "usertestanswer_id"),
        inverseJoinColumns = @JoinColumn(name = "answer_id"))
    private Set<Answer> answers = new HashSet<>();


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

    public Set<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(Set<Answer> answers) {
        this.answers = answers;
    }
}
