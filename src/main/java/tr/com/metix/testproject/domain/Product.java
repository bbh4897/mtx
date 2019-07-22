package tr.com.metix.testproject.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="product")

public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "product_name")
    private String product_name;

    @Column(name = "type")
    private String type;

    @Column(name = "rent_is")
    private boolean isRent;

    ///////

//    @OneToMany(mappedBy = "product")
//    private Set<ProductRent> productRents = new HashSet<>();
//
//    public Set<ProductRent> getProductRents() {
//        return productRents;
//    }
//
//    public void setProductRents(Set<ProductRent> productRents) {
//        this.productRents = productRents;
//    }

    ///////






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
