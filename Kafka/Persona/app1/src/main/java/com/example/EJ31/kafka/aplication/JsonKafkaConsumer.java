package com.example.EJ31.kafka.aplication;

import com.example.EJ31.Persona.domain.Persona;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaConsumer {
    private static final Logger LOGGER= LoggerFactory.getLogger(JsonKafkaConsumer.class);

    @KafkaListener(topics="mytopico2", groupId = "myGroup")
    public void consumir(Persona persona){
        LOGGER.info("Mensaje Json recivido: "+ persona.toString());
    }
}
