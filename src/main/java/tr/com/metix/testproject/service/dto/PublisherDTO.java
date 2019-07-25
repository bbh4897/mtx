package tr.com.metix.testproject.service.dto;

import tr.com.metix.testproject.domain.Country;

import java.io.Serializable;
import java.util.List;

public class PublisherDTO implements Serializable {


    private Long id;
    private String publisher_name;
    private List<CountryDTO> countryDTO;

    public List<CountryDTO> getCountryDTO() {
        return countryDTO;
    }

    public void setCountryDTO(List<CountryDTO> countryDTO) {
        this.countryDTO = countryDTO;
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
