package examen.jpa.cascada.cabecerafra.infrastructure;

import examen.jpa.cascada.cabecerafra.aplication.port.FacturaDeletePort;
import examen.jpa.cascada.cabecerafra.aplication.port.FacturaGetPort;
import examen.jpa.cascada.cabecerafra.infrastructure.dto.output.FacturaOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Date;
import java.util.List;

@RestController
public class FacturaController {
    @Autowired
    FacturaGetPort facturaGetPort;
    @Autowired
    FacturaDeletePort facturaDeletePort;
    @GetMapping("/factura")
    public ResponseEntity<List<FacturaOutputDto>> devolverFactura() {
        return new ResponseEntity<>(facturaGetPort.getAllFactura(), HttpStatus.OK);
    }
    @DeleteMapping("/factura/{idFra}")
    public ResponseEntity<String> borrarFactura(@PathVariable("idFra") int id){
        HttpStatus httpStatus= facturaDeletePort.borrarFactura(id);
        return ResponseEntity.status(httpStatus).body("timestamp: "+new Date()+",\n"+"error: "+httpStatus);
    }
}
