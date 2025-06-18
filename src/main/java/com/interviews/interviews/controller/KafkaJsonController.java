package com.interviews.interviews.controller;

import com.interviews.interviews.dto.InterviewEvent;
import com.interviews.interviews.kafka.JsonKafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/kafka/json")
@RequiredArgsConstructor
public class KafkaJsonController {

    private final JsonKafkaProducer jsonKafkaProducer;

    @PostMapping("/send")
    public ResponseEntity<String> sendJsonMessage(@RequestBody InterviewEvent event) {
        jsonKafkaProducer.sendInterviewMessage(event);
        return ResponseEntity.ok("✅ JSON message sent to Kafka successfully.");
    }
}