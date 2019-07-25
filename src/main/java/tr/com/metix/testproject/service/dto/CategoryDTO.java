package tr.com.metix.testproject.service.dto;

import java.io.Serializable;

public class CategoryDTO implements Serializable {


    private Long id;
    private String category_name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }
}
