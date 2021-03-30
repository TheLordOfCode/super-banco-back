package com.ceiba.incremento.comando.manejador;

import com.ceiba.incremento.comando.ComandoIncremento;
import com.ceiba.incremento.comando.fabrica.FabricaIncremento;
import com.ceiba.incremento.modelo.dto.DtoIncremento;
import com.ceiba.incremento.modelo.entidad.Incremento;
import com.ceiba.incremento.servicio.ServicioCrearIncremento;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearIncremento {

    private final FabricaIncremento fabricaIncremento;
    private final ServicioCrearIncremento servicioCrearIncremento;

    public ManejadorCrearIncremento(FabricaIncremento fabricaIncremento, ServicioCrearIncremento servicioCrearIncremento) {
        this.fabricaIncremento = fabricaIncremento;
        this.servicioCrearIncremento = servicioCrearIncremento;
    }

    public DtoIncremento ejecutar(ComandoIncremento comandoIncremento) {
        Incremento incremento = this.fabricaIncremento.crear(comandoIncremento);
        return this.servicioCrearIncremento.ejecutar(incremento);
    }

}
