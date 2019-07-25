package tr.com.metix.testproject.service.dto;

import java.io.Serializable;

public class CountryDTO implements Serializable {


    private Long id;
    private String country_name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry_name() {
        return country_name;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }
}
