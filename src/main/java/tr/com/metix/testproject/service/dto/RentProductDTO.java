package tr.com.metix.testproject.service.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import tr.com.metix.testproject.domain.Person;
import tr.com.metix.testproject.domain.Product;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

public class RentProductDTO implements Serializable {


    private Long id;
    private Date startDate;
    private Date endDate;
    private Date deliveryDate;


    private Long personId;
    private Long productId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
