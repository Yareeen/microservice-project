package com.example.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@Controller
@CrossOrigin //İsteklerin tümüne izin vermek için
//Simple/Streaming Text Oriented Messaging Protocol
//sockjs js tarafındaki implemantasyonu
public class ApiMessageController {
    @Autowired //otomatik injekt etmek için
    private SimpMessagingTemplate messagingTemplate; //mesajı özelleştirip gönderebiliriz.


    @KafkaListener(topics = "t.location", groupId = "my-group-id")
    //@SendTo("/topic") //tüm mesajlar tüm kullanıcılara gider.
    //@SendToUser()
    public void sendMessageEndpoint(String wsMessage){
        System.out.println(wsMessage);
        messagingTemplate.convertAndSend("/topic",wsMessage);
    }




}
