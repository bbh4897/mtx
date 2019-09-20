package tr.com.metix.testproject.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
@Service
public class Producer {

    private static final String TOPIC = "kafkaMesajTest";
    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;
    public void sendMessage(String message){
        System.out.println("Producer : " + message);
        this.kafkaTemplate.send(TOPIC,message);
    }
}
