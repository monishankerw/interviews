package com.interviews.interviews.kafka;

import com.interviews.interviews.dto.InterviewEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class JsonKafkaProducer {

    public static final String INTERVIEW_TOPIC = "interview-topic";

    private final KafkaTemplate<String, InterviewEvent> kafkaTemplate;

    public void sendInterviewMessage(InterviewEvent data) {
        log.info("🔹 Sending message to topic '{}': {}", INTERVIEW_TOPIC, data);

        Message<InterviewEvent> message = MessageBuilder
                .withPayload(data)
                .setHeader(KafkaHeaders.TOPIC, INTERVIEW_TOPIC)
                .build();

        kafkaTemplate.send(message);
    }
}