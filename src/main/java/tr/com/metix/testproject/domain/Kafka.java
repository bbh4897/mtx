package tr.com.metix.testproject.domain;

public class Kafka {

    private String field1;
    private String field2;

    public Kafka(String field1, String field2) {
        this.field1 = field1;
        this.field2 = field2;
    }

    public Kafka() {
    }

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public String getField2() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }

    @Override
    public String toString() {
        return "Kafka{" +
            "field1='" + field1 + '\'' +
            ", field2='" + field2 + '\'' +
            '}';
    }
}
