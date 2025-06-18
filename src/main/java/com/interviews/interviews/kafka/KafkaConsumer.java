package com.interviews.interviews.kafka;

import com.interviews.interviews.dto.InterviewEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaConsumer {

    // Consume as InterviewEvent, not String
    @KafkaListener(
            topics = "interview-topic",
            groupId = "interview-group",
            containerFactory = "interviewKafkaListenerContainerFactory"
    )
    public void consume(InterviewEvent event) {
        log.info("✅ Consumed Interview Event: {}", event);
    }
}