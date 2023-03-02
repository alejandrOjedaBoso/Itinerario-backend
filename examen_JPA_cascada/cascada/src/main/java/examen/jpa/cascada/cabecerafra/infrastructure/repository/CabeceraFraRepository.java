package examen.jpa.cascada.cabecerafra.infrastructure.repository;

import examen.jpa.cascada.cabecerafra.domain.CabeceraFra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CabeceraFraRepository extends JpaRepository<CabeceraFra,Integer> {
}
