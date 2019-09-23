package tr.com.metix.testproject.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
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
        for(int i=0; i<10;i++)
        kafkaTemplate.send("kafka2", kafka);
    }

    @KafkaListener(topics = "kafka2")
    public void getKafkaObject(Kafka kafka) throws InterruptedException {
        System.out.println("Consumer : " + kafka.toString());
        Thread.sleep(2000);
    }
}
