package com.example.EJ31.kafka.infrastructure;

import com.example.EJ31.Persona.domain.Persona;
import com.example.EJ31.kafka.aplication.JsonKafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/json")
public class JsonMessageController {
    @Autowired
    JsonKafkaProducer jsonKafkaProducer;

    public JsonMessageController(JsonKafkaProducer jsonKafkaProducer) {
        this.jsonKafkaProducer = jsonKafkaProducer;
    }

    @PostMapping("/enviar/{topico}")
    public ResponseEntity<String> enviar(@RequestBody Persona persona, @PathVariable String topico){
        jsonKafkaProducer.sendMessage(persona,topico);
        return ResponseEntity.ok("Mensaje enviado al topico de kafka: "+topico);
    }
}
