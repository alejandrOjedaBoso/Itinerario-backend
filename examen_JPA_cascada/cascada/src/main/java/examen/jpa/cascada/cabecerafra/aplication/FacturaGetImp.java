package examen.jpa.cascada.cabecerafra.aplication;

import examen.jpa.cascada.cabecerafra.aplication.port.FacturaGetPort;
import examen.jpa.cascada.cabecerafra.domain.CabeceraFra;
import examen.jpa.cascada.cabecerafra.infrastructure.dto.output.FacturaOutputDto;
import examen.jpa.cascada.cabecerafra.infrastructure.repository.CabeceraFraRepository;
import examen.jpa.cascada.lineasfra.domain.LineasFra;
import examen.jpa.cascada.lineasfra.infrastructure.repository.LineasFraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FacturaGetImp implements FacturaGetPort {
    @Autowired
    CabeceraFraRepository cabeceraFraRepository;
    @Autowired
    LineasFraRepository lineasFraRepository;

    @Override
    public List<FacturaOutputDto> getAllFactura() {
        List<FacturaOutputDto> facturaOutputDtoList=new ArrayList<FacturaOutputDto>();
        FacturaOutputDto facturaOutputDto=null;

        //Traemos todas las cabeceras
        for (CabeceraFra cabecera: cabeceraFraRepository.findAll()) {
            //Instanciamos el output de la factura
            facturaOutputDto=new FacturaOutputDto();

            //metemos los datoas a factura
            facturaOutputDto.convertirFacturaOutput(cabecera);

            //añadimos el output a la salida
            facturaOutputDtoList.add(facturaOutputDto);
        }
        return facturaOutputDtoList;
    }
}
