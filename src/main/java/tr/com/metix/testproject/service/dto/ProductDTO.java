package tr.com.metix.testproject.service.dto;

import javax.persistence.*;
import java.io.Serializable;

public class ProductDTO implements Serializable {


    private Long id;
    private String product_name;
    private String type;
    private boolean isRent;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isRent() {
        return isRent;
    }

    public void setRent(boolean rent) {
        isRent = rent;
    }
}
