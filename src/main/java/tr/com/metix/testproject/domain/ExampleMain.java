package tr.com.metix.testproject.domain;

import javax.persistence.*;

public class ExampleMain {
    private static EntityManagerFactory entityManagerFactory =
        Persistence.createEntityManagerFactory("example-unit");

    public static void main(String[] args) {
        try {
            persistEntity(); //kayıt
            loadAndUpdateEntity(); // update
            mergeEntity();
            loadAndRemoveEntity(); // delete
        } finally {
            entityManagerFactory.close();
        }
    }

    public static void persistEntity() {
        System.out.println("-- persisting --");
        MyEntity myEntity = new MyEntity("test msg");
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        System.out.println("before EntityManager.persist()");
        em.persist(myEntity);
        System.out.println("after EntityManager.persist()");
        System.out.println("before EntityManager.commit()");
        em.getTransaction().commit();
        System.out.println("after EntityManager.commit()");
        em.close();
    }


    public static void loadAndUpdateEntity() {
        System.out.println("-- loading and updating --");
        EntityManager em = entityManagerFactory.createEntityManager();
        System.out.println("before EntityManager.find()");
        MyEntity myEntity = em.find(MyEntity.class, 1);
        System.out.println("after EntityManager.find()");
        em.getTransaction().begin();
        System.out.println("before updating entity in transaction");
        myEntity.setMsg("new test msg");
        System.out.println("after updating entity in transaction");
        System.out.println("before EntityManager.commit()");
        em.getTransaction().commit();
        System.out.println("after EntityManager.commit()");
        em.close();
    }

    public static void mergeEntity() {
        System.out.println("-- merging --");
        MyEntity myEntity = new MyEntity();
        myEntity.setId(1);
        myEntity.setMsg("New merged msg");
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        System.out.println("before EntityManager.merge()");
        em.merge(myEntity);
        System.out.println("after EntityManager.merge()");
        System.out.println("before EntityManager.commit()");
        em.getTransaction().commit();
        System.out.println("after EntityManager.commit()");
        em.close();
    }

    public static void loadAndRemoveEntity() {
        System.out.println("-- loading and removing --");
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        System.out.println("before EntityManager.find()");
        MyEntity myEntity = em.find(MyEntity.class, 1);
        System.out.println("after EntityManager.find()");
        System.out.println("before EntityManager.remove()");
        em.remove(myEntity);
        System.out.println("after EntityManager.remove()");
        System.out.println("before EntityManager.commit()");
        em.getTransaction().commit();
        System.out.println("after EntityManager.commit()");
        em.close();
    }
}
