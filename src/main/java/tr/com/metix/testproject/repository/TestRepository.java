package tr.com.metix.testproject.repository;

import tr.com.metix.testproject.domain.Test;

import java.util.Map;

public interface TestRepository {

    void save(Test test);

    Map<String, Test> findAll();

    Test findById(Long id);

    void update(Test test);

    void delete(Long id);

}
