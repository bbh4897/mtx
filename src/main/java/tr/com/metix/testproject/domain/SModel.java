package tr.com.metix.testproject.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class SModel implements Serializable {

    private Long id;
    private String name2;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }
}
