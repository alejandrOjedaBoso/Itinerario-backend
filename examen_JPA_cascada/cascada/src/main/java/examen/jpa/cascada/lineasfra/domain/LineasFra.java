package examen.jpa.cascada.lineasfra.domain;

import examen.jpa.cascada.cabecerafra.domain.CabeceraFra;
import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class LineasFra {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idLin;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idFra")
    private CabeceraFra cabeceraFra;
    @Column(nullable = false)
    private String proNomb;
    private double cantidad;
    private double precio;
}
