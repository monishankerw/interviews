package com.interviews.interviews.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    private static final String INTERVIEW_TOPIC = "interview-topic";
    private static final String LOGS_TOPIC = "logs-topic";

    public void sendInterviewMessage(String message) {
        log.info("Sending message to '{}': {}", INTERVIEW_TOPIC, message);
        kafkaTemplate.send(INTERVIEW_TOPIC, message);
    }

    public void sendLogMessage(String message) {
        log.info("Sending log to '{}': {}", LOGS_TOPIC, message);
        kafkaTemplate.send(LOGS_TOPIC, message);
    }
}