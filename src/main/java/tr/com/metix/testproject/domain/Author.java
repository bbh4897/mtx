package tr.com.metix.testproject.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


    @Entity
    @Table(name = "author")
    public class Author implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
        @SequenceGenerator(name = "sequenceGenerator")
        private Long id;

        @Column(name = "author_name")
        private String author_name;

        @Column(name = "author_lastname")
        private String author_lastname;

        @Column(name = "birth_date")
        private Date birth_date;

        @ManyToOne
        @JsonIgnoreProperties("author")
        private Country country; // yayınevi


        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getAuthor_name() {
            return author_name;
        }

        public void setAuthor_name(String author_name) {
            this.author_name = author_name;
        }

        public String getAuthor_lastname() {
            return author_lastname;
        }

        public void setAuthor_lastname(String author_lastname) {
            this.author_lastname = author_lastname;
        }

        public Date getBirth_date() {
            return birth_date;
        }

        public void setBirth_date(Date birth_date) {
            this.birth_date = birth_date;
        }

        public Country getCountry() {
            return country;
        }

        public void setCountry(Country country) {
            this.country = country;
        }
    }


