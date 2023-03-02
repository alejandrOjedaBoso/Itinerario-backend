package examen.jpa.cascada.lineasfra.infrastructure;

import examen.jpa.cascada.cabecerafra.infrastructure.dto.output.FacturaOutputDto;
import examen.jpa.cascada.cabecerafra.infrastructure.repository.CabeceraFraRepository;
import examen.jpa.cascada.lineasfra.aplication.port.LineaAddPort;
import examen.jpa.cascada.lineasfra.infrastructure.dto.input.LineaInputDto;
import examen.jpa.cascada.lineasfra.infrastructure.repository.LineasFraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class LineaControllador {
    @Autowired
    LineaAddPort lineaAddPort;

    @PostMapping("/factura/linea/{idFra}")
    public ResponseEntity aniadirLinea(@PathVariable int idFra, @RequestBody LineaInputDto lineaInputDto){
        FacturaOutputDto facturaOutputDto=lineaAddPort.addLinea(idFra,lineaInputDto);
        if(facturaOutputDto==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("timestamp: "+new Date()+",\n"+"error: "+HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>((facturaOutputDto),HttpStatus.OK);
    }
}
