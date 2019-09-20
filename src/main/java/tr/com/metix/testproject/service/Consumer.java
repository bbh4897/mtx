package tr.com.metix.testproject.service;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
@Service
public class Consumer {

    @KafkaListener(topics = "kafkaMesajTest", groupId = "group_id")
    public void consume(String message){
        System.out.println("Consumer : " + message);
    }
}
