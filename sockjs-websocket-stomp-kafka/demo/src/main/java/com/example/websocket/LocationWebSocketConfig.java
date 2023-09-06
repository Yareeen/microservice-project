package com.example.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

//Bu yapılandırmanın mesaj aracısı tabanlı bir WebSocket sağladığını
// ve STOMP uç noktalarını kaydettiğini unutmayın.
@Configuration
@EnableWebSocketMessageBroker
public class LocationWebSocketConfig implements WebSocketMessageBrokerConfigurer {



    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic"); // "/location" için mesaj broker
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/location").setAllowedOriginPatterns("*").withSockJS();
        registry.addEndpoint("/waypoints/ws").setAllowedOriginPatterns("*").withSockJS();
    }
}

