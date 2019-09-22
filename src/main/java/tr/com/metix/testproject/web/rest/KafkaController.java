package tr.com.metix.testproject.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tr.com.metix.testproject.domain.Kafka;

@RestController
@RequestMapping("/api")
public class KafkaController {

    private KafkaTemplate<String,Kafka> kafkaTemplate;

    @Autowired
    public KafkaController(KafkaTemplate<String,Kafka> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping("/kafka")
    public void post(@RequestBody Kafka kafka){
        kafkaTemplate.send("kafkaObject", kafka);
    }
}
