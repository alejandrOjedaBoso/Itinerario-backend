package examen.jpa.cascada.cabecerafra.infrastructure.dto.output;

import examen.jpa.cascada.cabecerafra.domain.CabeceraFra;
import examen.jpa.cascada.cliente.infrastructure.dto.ouput.ClienteOutputDto;
import examen.jpa.cascada.lineasfra.domain.LineasFra;
import examen.jpa.cascada.lineasfra.infrastructure.dto.output.LineaOutputDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FacturaOutputDto {
    int id;
    double importe=0;
    ClienteOutputDto clienteOutputDto;
    List<LineaOutputDto> lineaOutputDtoList;

    public void convertirFacturaOutput(CabeceraFra cabeceraFra){
        this.setId(cabeceraFra.getIdCab());
        this.setImporte(cabeceraFra.getImporteFra());

        //Tranformamos el cliente a un outputDto
        ClienteOutputDto clienteOutputDto=new ClienteOutputDto();
        clienteOutputDto.convertirClienteDto(cabeceraFra.getCliente());
        this.setClienteOutputDto(clienteOutputDto);

        //Agregamos una lista
        this.setLineaOutputDtoList(new ArrayList<LineaOutputDto>());
        for (LineasFra linea:cabeceraFra.getLineasFraList()) {
            LineaOutputDto lineaOutputDto=new LineaOutputDto();
            lineaOutputDto.convertirLineaOput(linea);
            this.getLineaOutputDtoList().add(lineaOutputDto);
        }
    }
}
