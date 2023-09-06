package com.example.kafkaproduce.Bootstrap;

import com.example.kafkaproduce.Config.LocationGenerator;
import com.example.kafkaproduce.Config.Producer;
import com.example.kafkaproduce.Model.Location;
import com.example.kafkaproduce.Model.LocationMessage;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class LocaitonBootstrap implements CommandLineRunner {

    private final Producer producer;
    int j=0;
    public void run(String... args) throws Exception {

       for(int i=0; i<10;i++){
           sendLocationsToKafka();
       }

    }

    public void sendLocationsToKafka() throws JsonProcessingException {
       /* Location startLocation = LocationGenerator.generateRandomLocation();
        Location endLocation = LocationGenerator.generateRandomLocation();

        producer.sendMessage(startLocation);
        producer.sendMessage(endLocation);

        */
        Location startLocation = LocationGenerator.generateRandomLocation();
        Location endLocation = LocationGenerator.generateRandomLocation();

        LocationMessage message = new LocationMessage();
        message.setId(j);
        message.setStartloc(startLocation);
        message.setEndloc(endLocation);

        j++;

        producer.sendMessage(message);
    }

}
