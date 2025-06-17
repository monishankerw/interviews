package com.interviews.interviews.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaTopicConfig {

    // Create a topic named "interview-topic" with 1 partition and 1 replica
    @Bean
    public NewTopic interviewTopic() {
        return new NewTopic("interview-topic", 1, (short) 1);
    }

    // You can define more topics like this:
    @Bean
    public NewTopic logsTopic() {
        return new NewTopic("logs-topic", 3, (short) 1);
    }
}