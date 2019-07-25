package tr.com.metix.testproject.domain;


import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "publisher")
public class Publisher implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "publisher_name")
    private String publisher_name;

    @ManyToMany
    @JoinTable(name = "publisher_country",
        joinColumns = @JoinColumn(name = "publisher_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "country_id", referencedColumnName = "id"))
    private Set<Country> country = new HashSet<>();



    public Set<Country> getCountry() {
        return country;
    }

    public void setCountry(Set<Country> country) {
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPublisher_name() {
        return publisher_name;
    }

    public void setPublisher_name(String publisher_name) {
        this.publisher_name = publisher_name;
    }


}
