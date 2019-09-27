package tr.com.metix.testproject.web.rest;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import tr.com.metix.testproject.domain.SModel;
import tr.com.metix.testproject.domain.TestModel;
import tr.com.metix.testproject.repository.TRedisRepository;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class tRedisController {

    private TRedisRepository tRedisRepository;
    private HashOperations hashOperations;

    public tRedisController(TRedisRepository tRedisRepository, RedisTemplate<String, SModel> redisTemplate) {
        this.tRedisRepository = tRedisRepository;
        this.hashOperations = redisTemplate.opsForHash();
    }

    @PostMapping("/add")
    public  void post(@RequestBody TestModel testModel){
        tRedisRepository.save(testModel);
    }

    @GetMapping("/all/{id}")
    public TestModel get(@PathVariable Long id){
        return tRedisRepository.findById(id).get();
    }

    /////// REDIS

    @PostMapping("/add2")
    public  void post2(@RequestBody SModel sModel){
        hashOperations.put("TM",sModel.getId(), sModel);
    }

    @GetMapping("/all2/{id}")
    public SModel get2(@PathVariable Long id){
        return (SModel) hashOperations.get("TM", id);
    }
//    @GetMapping("/allT")
//    public Map<String,SModel> get2(){
//        return hashOperations.entries("TM");
//    }

}
