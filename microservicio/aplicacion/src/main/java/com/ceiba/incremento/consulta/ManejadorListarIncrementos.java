package com.ceiba.incremento.consulta;

import com.ceiba.incremento.modelo.dto.DtoIncremento;
import com.ceiba.incremento.puerto.dao.DaoIncremento;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarIncrementos {
    private final DaoIncremento daoIncremento;

    public ManejadorListarIncrementos(DaoIncremento daoIncremento) {
        this.daoIncremento = daoIncremento;
    }

    public List<DtoIncremento> ejecutar() {
        return this.daoIncremento.listar();
    }
}
