package tr.com.metix.testproject.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tr.com.metix.testproject.domain.Test;


@RestController
@RequestMapping("/api")
public class TestResource {

    @Autowired
    private KafkaTemplate<String, Test> kafkaTemplate;

    private static final String TOPIC = "testkafka";

    @GetMapping("/publish/{name}")
    public String post(@PathVariable("name") final String name) {

        kafkaTemplate.send(TOPIC, new Test(name, "Technology"));

        return "Published successfully";
    }

}
