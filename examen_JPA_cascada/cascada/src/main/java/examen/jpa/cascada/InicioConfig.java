package examen.jpa.cascada;

import examen.jpa.cascada.cabecerafra.domain.CabeceraFra;
import examen.jpa.cascada.cabecerafra.infrastructure.repository.CabeceraFraRepository;
import examen.jpa.cascada.cliente.domain.Cliente;
import examen.jpa.cascada.cliente.infrastructure.repository.ClienteRepository;
import examen.jpa.cascada.lineasfra.domain.LineasFra;
import examen.jpa.cascada.lineasfra.infrastructure.repository.LineasFraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class InicioConfig {
    @Autowired
    ClienteRepository clienteRepository;
    @Autowired
    CabeceraFraRepository cabeceraFraRepository;
    @Autowired
    LineasFraRepository lineasFraRepository;

    @Bean
    public void inicioClienteFactura(){
        //Creo una lista para guardar las lineas de la factura y subirla de un save
        List<LineasFra> lineas=new ArrayList<LineasFra>();

        //Creamos un cliente de prueba
        Cliente cliente=new Cliente(1,"Alejandro");

        //una factura e prueba con dos lineas
        CabeceraFra cabeceraFra=new CabeceraFra(1,cliente,12.10,new ArrayList<LineasFra>());
        LineasFra linea1=new LineasFra(1,cabeceraFra,"Maniquis",3,9.0);
        LineasFra linea2=new LineasFra(2,cabeceraFra,"Mangos",4,3);

        //Agregamos las lineas a la lista de la cabecera
        cabeceraFra.getLineasFraList().add(linea1);
        cabeceraFra.getLineasFraList().add(linea2);

        //Agrego las lineas a la lista
        lineas.add(linea1);
        lineas.add(linea2);

        //Guardamos la factura con las lineas
        lineasFraRepository.saveAll(lineas);
        cabeceraFraRepository.save(cabeceraFra);

        //Guardamos el Cliente
        clienteRepository.save(cliente);
    }
}
