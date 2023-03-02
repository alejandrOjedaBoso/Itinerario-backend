package examen.jpa.cascada.lineasfra.aplication.port;

import examen.jpa.cascada.cabecerafra.infrastructure.dto.output.FacturaOutputDto;
import examen.jpa.cascada.lineasfra.infrastructure.dto.input.LineaInputDto;

public interface LineaAddPort {
    public FacturaOutputDto addLinea(int id, LineaInputDto lineaInputDto);
}
