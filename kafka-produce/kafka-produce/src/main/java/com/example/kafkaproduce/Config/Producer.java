package com.example.kafkaproduce.Config;

import com.example.kafkaproduce.Model.LocationMessage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class Producer {


    private String locationTopic;

    private final ObjectMapper objectMapper;
    private final KafkaTemplate<String, String> kafkaTemplate;


    public String sendMessage(LocationMessage location) throws JsonProcessingException {
        String locationMessage = objectMapper.writeValueAsString(location);
        kafkaTemplate.send("t.location", locationMessage);

        log.info("location produced {}", locationMessage);

        return "message sent";
    }
}