package tr.com.metix.testproject.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tr.com.metix.testproject.domain.Test;
import tr.com.metix.testproject.repository.TestRepository;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class TestREsource {

    private TestRepository testRepository;

    public TestREsource(TestRepository testRepository){
        this.testRepository = testRepository;
    }

    @GetMapping("/add/{id}/{name}")
    public Test add(@PathVariable("id") final Long id, @PathVariable("name") final String name){
        testRepository.save(new Test(id, name));
        return  testRepository.findById(id);
    }

    @GetMapping("/update/{id}/{name}")
    public Test update(@PathVariable("id") final Long id, @PathVariable("name") final String name){
        testRepository.update(new Test(id, name));
        return  testRepository.findById(id);
    }

    @GetMapping("/all")
    public Map<String,Test> all(){
        return testRepository.findAll();
    }
}
