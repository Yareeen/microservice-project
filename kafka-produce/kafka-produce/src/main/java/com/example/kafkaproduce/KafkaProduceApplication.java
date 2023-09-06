package com.example.kafkaproduce;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
@RequiredArgsConstructor

public class KafkaProduceApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaProduceApplication.class, args);

	}

}
