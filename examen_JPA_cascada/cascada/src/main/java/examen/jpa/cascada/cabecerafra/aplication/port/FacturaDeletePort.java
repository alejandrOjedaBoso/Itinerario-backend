package examen.jpa.cascada.cabecerafra.aplication.port;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public interface FacturaDeletePort {
    public HttpStatus borrarFactura(int id);
}
