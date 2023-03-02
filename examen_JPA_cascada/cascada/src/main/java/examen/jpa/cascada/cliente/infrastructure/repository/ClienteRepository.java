package examen.jpa.cascada.cliente.infrastructure.repository;

import examen.jpa.cascada.cliente.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
