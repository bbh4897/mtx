package tr.com.metix.testproject.service.dto;

import java.io.Serializable;

public class LanguageDTO implements Serializable {


    private Long id;
    private String language_name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLanguage_name() {
        return language_name;
    }

    public void setLanguage_name(String language_name) {
        this.language_name = language_name;
    }
}
