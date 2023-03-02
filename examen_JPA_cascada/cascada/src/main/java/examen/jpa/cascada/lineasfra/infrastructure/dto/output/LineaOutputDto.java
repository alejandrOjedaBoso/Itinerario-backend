package examen.jpa.cascada.lineasfra.infrastructure.dto.output;

import examen.jpa.cascada.lineasfra.domain.LineasFra;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LineaOutputDto {
    int id;
    String producto;
    double cantidad;
    double precio;

    public void convertirLineaOput(LineasFra lineasFra){
        this.setId(lineasFra.getIdLin());
        this.setProducto(lineasFra.getProNomb());
        this.setCantidad(lineasFra.getCantidad());
        this.setPrecio(lineasFra.getPrecio());
    }
}
