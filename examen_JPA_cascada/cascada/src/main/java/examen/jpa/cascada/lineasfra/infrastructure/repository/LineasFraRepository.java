package examen.jpa.cascada.lineasfra.infrastructure.repository;

import examen.jpa.cascada.cabecerafra.domain.CabeceraFra;
import examen.jpa.cascada.lineasfra.domain.LineasFra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface LineasFraRepository extends JpaRepository<LineasFra, Integer> {
    List<LineasFra> findByCabeceraFra(CabeceraFra cabeceraFra);
}
