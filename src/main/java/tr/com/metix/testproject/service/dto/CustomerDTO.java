package tr.com.metix.testproject.service.dto;

import tr.com.metix.testproject.domain.Customer;

public class CustomerDTO {

    private Long id;
    private String name;
    private Long ownerId;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }
}
