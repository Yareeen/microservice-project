package com.example.kafkaproduce.Controller;

import com.example.kafkaproduce.Config.LocationGenerator;
import com.example.kafkaproduce.Config.Producer;
import com.example.kafkaproduce.Model.Location;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/message")
public class LocationController {

    private final Producer producer;

    @GetMapping
    public void createLocation(@RequestBody Location location) throws JsonProcessingException {
        log.info("create location request received");


    }

}
