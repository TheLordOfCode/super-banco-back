package com.ceiba.incremento.consulta;

import com.ceiba.incremento.modelo.dto.DtoIncremento;
import com.ceiba.incremento.servicio.ServicioObtenerIncremento;
import org.springframework.stereotype.Component;

@Component
public class ManejadorObtenerIncremento {
    private final ServicioObtenerIncremento servicioObtenerIncremento;

    public ManejadorObtenerIncremento(ServicioObtenerIncremento servicioObtenerIncremento) {
        this.servicioObtenerIncremento = servicioObtenerIncremento;
    }

    public DtoIncremento ejecutar(Long id) {
        return this.servicioObtenerIncremento.ejecutar(id);
    }
}
