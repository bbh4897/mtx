package tr.com.metix.testproject.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "test")
public class test implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
