package tr.com.metix.testproject.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import tr.com.metix.testproject.domain.Test;

import java.util.Map;

@Repository
public class TestRepositoryImpl implements TestRepository {

    private RedisTemplate<String, Test> redisTemplate;
    private HashOperations hashOperations;


    public TestRepositoryImpl(RedisTemplate<String,Test> redisTemplate){
        this.redisTemplate = redisTemplate;
        hashOperations = redisTemplate.opsForHash();
    }



    @Override
    public void save(Test test) {
        hashOperations.put("TEST", test.getId(), test);
    }

    @Override
    public Map<String, Test> findAll() {
        return hashOperations.entries("TEST");
    }

    @Override
    public Test findById(Long id) {
        return (Test) hashOperations.get("TEST", id);
    }

    @Override
    public void update(Test test) {
        save(test);
    }

    @Override
    public void delete(Long id) {
        hashOperations.delete("TEST", id);
    }
}
