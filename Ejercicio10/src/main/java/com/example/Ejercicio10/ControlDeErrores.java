package com.example.Ejercicio10;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ControlDeErrores {
    public ControlDeErrores() {
        log.error("ERROR CRITICO");
        log.info("INFO");
        log.warn("WARNING");
        log.debug("DEBUG");
        log.trace("TRACE");
    }

}
