package examen.jpa.cascada.cabecerafra.aplication.port;

import examen.jpa.cascada.cabecerafra.infrastructure.dto.output.FacturaOutputDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface FacturaGetPort {
    public List<FacturaOutputDto> getAllFactura();
}
