package tr.com.metix.testproject.domain;

import javax.persistence.*;

@Entity
@EntityListeners(MyEntityListener.class)
public class MyEntity {
    @Id
    @GeneratedValue
    private int id;
    private String msg;

       public MyEntity() { }

    public MyEntity(String msg) {
        this.msg = msg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
