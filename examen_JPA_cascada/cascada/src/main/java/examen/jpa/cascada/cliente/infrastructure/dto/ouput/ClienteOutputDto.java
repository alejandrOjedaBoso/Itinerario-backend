package examen.jpa.cascada.cliente.infrastructure.dto.ouput;

import examen.jpa.cascada.cliente.domain.Cliente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteOutputDto {
    int id;
    String nombre;

    public void convertirClienteDto(Cliente cliente){
        this.setId(cliente.getIdCli());
        this.setNombre(cliente.getNombre());
    }
}
