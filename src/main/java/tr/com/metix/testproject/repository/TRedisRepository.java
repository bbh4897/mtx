package tr.com.metix.testproject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tr.com.metix.testproject.domain.TestModel;

@Repository
public interface TRedisRepository extends CrudRepository<TestModel, Long> {
}

