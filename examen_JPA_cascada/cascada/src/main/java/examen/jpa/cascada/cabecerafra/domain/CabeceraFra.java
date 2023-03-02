package examen.jpa.cascada.cabecerafra.domain;

import examen.jpa.cascada.cliente.domain.Cliente;
import examen.jpa.cascada.lineasfra.domain.LineasFra;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CabeceraFra {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idCab;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idCli")
    private Cliente cliente;

    private double importeFra;
    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    private List<LineasFra> lineasFraList;
}
