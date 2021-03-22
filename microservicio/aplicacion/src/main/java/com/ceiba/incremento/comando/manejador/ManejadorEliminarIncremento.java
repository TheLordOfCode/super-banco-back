package com.ceiba.incremento.comando.manejador;

import com.ceiba.incremento.servicio.ServicioEliminarIncremento;
import com.ceiba.manejador.ManejadorComando;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarIncremento implements ManejadorComando<Long> {

    private final ServicioEliminarIncremento servicioEliminarIncremento;

    public ManejadorEliminarIncremento(ServicioEliminarIncremento servicioEliminarIncremento) {
        this.servicioEliminarIncremento = servicioEliminarIncremento;
    }

    public void ejecutar(Long idIncremento) {
        this.servicioEliminarIncremento.ejecutar(idIncremento);
    }

}
