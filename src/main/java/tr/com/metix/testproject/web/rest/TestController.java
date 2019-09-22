package tr.com.metix.testproject.web.rest;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.RestController;
import tr.com.metix.testproject.domain.Kafka;

@RestController
public class TestController {

//    @KafkaListener(topics = "kafkaObject")
//    public void getKafkaObject(Kafka kafka){
//        System.out.println("Test Kafka : " + kafka.toString());
//    }
}
