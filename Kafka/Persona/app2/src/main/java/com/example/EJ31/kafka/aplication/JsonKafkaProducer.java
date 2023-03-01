package com.example.EJ31.kafka.aplication;

import com.example.EJ31.Persona.domain.Persona;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaProducer {
    private static final Logger LOGGER= LoggerFactory.getLogger(JsonKafkaProducer.class);

    private KafkaTemplate<String, Persona> kafkaTemplate;

    public JsonKafkaProducer(KafkaTemplate<String, Persona> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    public void sendMessage(Persona data, String topico){
        LOGGER.info("Mensaje enviado: "+ data.toString());

        Message<Persona> message= MessageBuilder
                .withPayload(data)
                .setHeader(KafkaHeaders.TOPIC,topico)
                .build();
        kafkaTemplate.send(message);
    }
}
