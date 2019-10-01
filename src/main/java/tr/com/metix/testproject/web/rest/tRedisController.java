package tr.com.metix.testproject.web.rest;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import tr.com.metix.testproject.domain.SModel;
import tr.com.metix.testproject.domain.User;
import tr.com.metix.testproject.repository.UserRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class tRedisController {

    private final UserRepository userRepository;
    private HashOperations hashOperations;

    public tRedisController(RedisTemplate<String, SModel> redisTemplate, UserRepository userRepository) {
        this.hashOperations = redisTemplate.opsForHash();
        this.userRepository = userRepository;
    }


    @PostMapping("/add")
    public void post2(@RequestBody User user) {
        hashOperations.put("USER_CACHE2", user.getId(), user);
    }

    @GetMapping("/get/{id}")
    public User get2(@PathVariable Long id) {
        return (User) hashOperations.get("USER_CACHE2", id);
    }

    @GetMapping("/all")
    public Map<Long, User> findAll() {

        Map<Long, User> map = new HashMap<>();
        map = hashOperations.entries("USER_CACHE2");
        for (int i = 0; i < map.size(); i++) {
            System.out.println("TESSSSST : " + map.keySet() + " -- " + map.values());
        }

        return hashOperations.entries("USER_CACHE2");
    }

    @DeleteMapping("/delete")
    public void delete(Long id) {
        hashOperations.delete("USER_CACHE2", id);
    }

    @GetMapping("/dbTORedis")
    public void dbToRedis() {
        List<User> users = userRepository.findAll();

        Map<Long, User> map = new HashMap<>();

        map = hashOperations.entries("USER_CACHE2");

        System.out.println("MAP : " + map.keySet());

        if(map.isEmpty()){
            System.out.println("MAP BOŞ");
            for(int i=0;i<users.size();i++){
                post2(users.get(i));
            }
        }
        else{
            System.out.println("MAP BOŞ DEĞİL");
            System.out.println("MAP test : " + map.keySet());
            System.out.println("wwwwww : " + map.containsKey(2));

            for(int i=0; i<users.size();i++) {
                if (map.containsKey(users.get(i).getId())) {
                    System.out.println("OKKKKKK" + users.get(i).getId());
                }
            }
        }

    }
}
