package com.ceiba.incremento.comando.fabrica;

import com.ceiba.incremento.comando.ComandoIncremento;
import com.ceiba.incremento.modelo.entidad.Incremento;
import org.springframework.stereotype.Component;

@Component
public class FabricaIncremento {
    public Incremento crear(ComandoIncremento comandoIncremento) {
        return new Incremento(
                comandoIncremento.getId(),
                comandoIncremento.getFechaInicio(),
                comandoIncremento.getFechaFin(),
                comandoIncremento.getMontoInicial()
        );
    }
}
