package com.ceiba.incremento.comando.manejador;

import com.ceiba.incremento.comando.ComandoIncremento;
import com.ceiba.incremento.comando.fabrica.FabricaIncremento;
import com.ceiba.incremento.modelo.entidad.Incremento;
import com.ceiba.incremento.servicio.ServicioActualizarIncremento;
import com.ceiba.manejador.ManejadorComando;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarIncremento implements ManejadorComando<ComandoIncremento> {
    private final FabricaIncremento fabricaIncremento;
    private final ServicioActualizarIncremento servicioActualizarIncremento;

    public ManejadorActualizarIncremento(FabricaIncremento fabricaIncremento, ServicioActualizarIncremento servicioActualizarIncremento) {
        this.fabricaIncremento = fabricaIncremento;
        this.servicioActualizarIncremento = servicioActualizarIncremento;
    }

    public void ejecutar(ComandoIncremento comandoIncremento) {
        Incremento incremento = this.fabricaIncremento.crear(comandoIncremento);
        this.servicioActualizarIncremento.ejecutar(incremento);
    }
}
