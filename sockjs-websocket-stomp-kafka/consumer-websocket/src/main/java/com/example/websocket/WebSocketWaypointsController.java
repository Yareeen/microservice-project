package com.example.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketWaypointsController {
    @Autowired //otomatik injekt etmek için
    private SimpMessagingTemplate messagingTemplate; //mesajı özelleştirip gönderebiliriz
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @MessageMapping("/waypoints/ws")
    public void handleLocationMessage(@Payload String waypoints) {
        // WebSocket üzerinden gelen waypoints verisini Kafka'ya gönderin
        kafkaTemplate.send("t.waypoints", waypoints);
        System.out.println(waypoints);
        messagingTemplate.convertAndSend("/topic",waypoints);
    }
}