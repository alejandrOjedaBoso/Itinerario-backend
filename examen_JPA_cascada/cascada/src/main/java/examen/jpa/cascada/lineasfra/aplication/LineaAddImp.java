package examen.jpa.cascada.lineasfra.aplication;

import examen.jpa.cascada.cabecerafra.domain.CabeceraFra;
import examen.jpa.cascada.cabecerafra.infrastructure.dto.output.FacturaOutputDto;
import examen.jpa.cascada.cabecerafra.infrastructure.repository.CabeceraFraRepository;
import examen.jpa.cascada.lineasfra.aplication.port.LineaAddPort;
import examen.jpa.cascada.lineasfra.domain.LineasFra;
import examen.jpa.cascada.lineasfra.infrastructure.dto.input.LineaInputDto;
import examen.jpa.cascada.lineasfra.infrastructure.repository.LineasFraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LineaAddImp implements LineaAddPort {
    @Autowired
    LineasFraRepository lineasFraRepository;
    @Autowired
    CabeceraFraRepository cabeceraFraRepository;
    @Override
    public FacturaOutputDto addLinea(int id, LineaInputDto lineaInputDto) {
        LineasFra lineasFra;
        CabeceraFra cabeceraFra= cabeceraFraRepository.findById(id).orElse(null);
        if (cabeceraFra==null){
            return null;
        }
        lineaInputDto.setCabeceraFra(cabeceraFra);
        lineasFra=lineaInputDto.devolverLineaFra();

        cabeceraFra.getLineasFraList().add(lineasFra);


        //Guardamos
        lineasFraRepository.save(lineasFra);
        cabeceraFraRepository.save(cabeceraFra);

        FacturaOutputDto facturaOutputDto=new FacturaOutputDto();
        facturaOutputDto.convertirFacturaOutput(cabeceraFra);
        return facturaOutputDto;
    }
}
