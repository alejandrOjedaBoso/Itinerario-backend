package examen.jpa.cascada.cabecerafra.aplication;

import examen.jpa.cascada.cabecerafra.aplication.port.FacturaDeletePort;
import examen.jpa.cascada.cabecerafra.domain.CabeceraFra;
import examen.jpa.cascada.cabecerafra.infrastructure.repository.CabeceraFraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class FacturaDeleteImp implements FacturaDeletePort {
    @Autowired
    CabeceraFraRepository cabeceraFraRepository;
    @Override
    public HttpStatus borrarFactura(int id) {
        CabeceraFra cabeceraFra= cabeceraFraRepository.findById(id).orElse(null);
        if (cabeceraFra==null){
            return HttpStatus.NOT_FOUND;
        }
        cabeceraFraRepository.delete(cabeceraFra);
        return HttpStatus.OK;
    }
}
