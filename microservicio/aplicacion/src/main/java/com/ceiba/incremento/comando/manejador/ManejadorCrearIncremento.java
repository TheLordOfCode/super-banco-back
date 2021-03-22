package com.ceiba.incremento.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.incremento.comando.ComandoIncremento;
import com.ceiba.incremento.comando.fabrica.FabricaIncremento;
import com.ceiba.incremento.modelo.entidad.Incremento;
import com.ceiba.incremento.servicio.ServicioCrearIncremento;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearIncremento implements ManejadorComandoRespuesta<ComandoIncremento, ComandoRespuesta<Long>> {

    private final FabricaIncremento fabricaIncremento;
    private final ServicioCrearIncremento servicioCrearIncremento;

    public ManejadorCrearIncremento(FabricaIncremento fabricaIncremento, ServicioCrearIncremento servicioCrearIncremento) {
        this.fabricaIncremento = fabricaIncremento;
        this.servicioCrearIncremento = servicioCrearIncremento;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoIncremento comandoIncremento) {
        Incremento incremento = this.fabricaIncremento.crear(comandoIncremento);
        return new ComandoRespuesta<>(this.servicioCrearIncremento.ejecutar(incremento));
    }

}
