package tr.com.metix.testproject.web.rest;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import tr.com.metix.testproject.domain.SModel;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class tRedisController {

    private HashOperations hashOperations;

    public tRedisController(RedisTemplate<String, SModel> redisTemplate) {
        this.hashOperations = redisTemplate.opsForHash();
    }


    @PostMapping("/add")
    public void post2(@RequestBody SModel sModel) {
        hashOperations.put("fff", sModel.getId(), sModel);
    }

    @GetMapping("/get/{id}")
    public SModel get2(@PathVariable Long id) {
        return (SModel) hashOperations.get("fff", id);
    }

    @GetMapping("/all")
    public Map<Long,SModel> findAll(){
        return hashOperations.entries("fff");
    }


}
