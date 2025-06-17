package com.interviews.interviews.controller;

import com.interviews.interviews.kafka.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/kafka")
@RequiredArgsConstructor
public class KafkaMessageController {

    private final KafkaProducer kafkaProducer;

    @PostMapping("/interview")
    public ResponseEntity<String> sendInterviewMessage(@RequestParam String message) {
        System.out.println("Received Kafka message: " + message);
        kafkaProducer.sendInterviewMessage(message);
        return ResponseEntity.ok("Message sent to interview-topic");
    }

    @PostMapping("/logs")
    public ResponseEntity<String> sendLogMessage(@RequestParam String message) {
        kafkaProducer.sendLogMessage(message);
        return ResponseEntity.ok("Message sent to logs-topic");
    }
}