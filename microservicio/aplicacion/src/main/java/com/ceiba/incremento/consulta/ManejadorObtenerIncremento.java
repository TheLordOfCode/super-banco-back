package com.ceiba.incremento.consulta;

import com.ceiba.incremento.modelo.dto.DtoIncremento;
import com.ceiba.incremento.puerto.dao.DaoIncremento;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorObtenerIncremento {
    private final DaoIncremento daoIncremento;

    public ManejadorObtenerIncremento(DaoIncremento daoIncremento) {
        this.daoIncremento = daoIncremento;
    }

    public DtoIncremento ejecutar(Long id) {
        return this.daoIncremento.obtenerPorId(id);
    }
}
