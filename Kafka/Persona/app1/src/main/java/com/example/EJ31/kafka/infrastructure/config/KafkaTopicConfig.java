package com.example.EJ31.kafka.infrastructure.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
    @Bean
    public NewTopic nuevoTopico(){
        return TopicBuilder.name("mytopico")
                .build();
    }
   /*
   @Bean
    public NewTopic nuevoTopico2(){
        return TopicBuilder.name("mytopico2")
                .build();
    }
    */
}
