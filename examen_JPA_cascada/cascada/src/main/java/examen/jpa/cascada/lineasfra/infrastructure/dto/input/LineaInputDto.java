package examen.jpa.cascada.lineasfra.infrastructure.dto.input;

import examen.jpa.cascada.cabecerafra.domain.CabeceraFra;
import examen.jpa.cascada.lineasfra.aplication.port.LineaAddPort;
import examen.jpa.cascada.lineasfra.domain.LineasFra;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LineaInputDto {
    private int idLin;
    CabeceraFra cabeceraFra;
    String proNomb;
    double cantidad;
    double precio;
    public LineaInputDto(int idLin,String proNomb,double cantidad,double precio){
        this.setIdLin(idLin);
        this.setProNomb(proNomb);
        this.setCantidad(cantidad);
        this.setPrecio(precio);
    }
    public LineasFra devolverLineaFra(){
        LineasFra lineasFra=new LineasFra();

        lineasFra.setIdLin(this.getIdLin());
        lineasFra.setProNomb(this.getProNomb());
        lineasFra.setPrecio(this.getPrecio());
        lineasFra.setCabeceraFra(this.getCabeceraFra());
        lineasFra.setCantidad(this.getCantidad());

        return lineasFra;
    }
}
