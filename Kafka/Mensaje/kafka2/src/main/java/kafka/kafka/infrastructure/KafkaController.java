package kafka.kafka.infrastructure;

import kafka.kafka.aplication.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/kafka")
public class KafkaController {
    @Autowired
    KafkaProducer kafkaProducer;
    @PostMapping("/enviar/{topic}")
    public ResponseEntity<String> enviarMensaje(@PathVariable String topic,@RequestParam("message") String message){

        kafkaProducer.sendMessage(message,topic);
        return ResponseEntity.ok("El mensaje ha sido enviado al topico");
    }
}
