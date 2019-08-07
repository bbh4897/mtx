package tr.com.metix.testproject.domain;

import javax.persistence.*;

public class MyEntityListener {

    @PrePersist
    void onPrePersist(MyEntity myEntity) {
        System.out.println("MyEntityListener.onPrePersist(): " + myEntity);
    }

    @PostPersist
    void onPostPersist(MyEntity myEntity) {
        System.out.println("MyEntityListener.onPostPersist(): " + myEntity);
    }

    @PostLoad
    void onPostLoad(MyEntity myEntity) {
        System.out.println("MyEntityListener.onPostLoad(): " + myEntity);
    }

    @PreUpdate
    void onPreUpdate(MyEntity myEntity) {
        System.out.println("MyEntityListener.onPreUpdate(): " + myEntity);
    }

    @PostUpdate
    void onPostUpdate(MyEntity myEntity) {
        System.out.println("MyEntityListener.onPostUpdate(): " + myEntity);
    }

    @PreRemove
    void onPreRemove(MyEntity myEntity) {
        System.out.println("MyEntityListener.onPreRemove(): " + myEntity);
    }

    @PostRemove
    void onPostRemove(MyEntity myEntity) {
        System.out.println("MyEntityListener.onPostRemove(): " + myEntity);
    }
}
