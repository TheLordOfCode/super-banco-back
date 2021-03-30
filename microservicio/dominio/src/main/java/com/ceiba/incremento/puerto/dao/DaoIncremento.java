package com.ceiba.incremento.puerto.dao;

import com.ceiba.incremento.modelo.dto.DtoIncremento;

import java.util.List;

public interface DaoIncremento {
    /**
     * Permite listar incrementos
     *
     * @return los incrementos
     */

    List<DtoIncremento> listar();

    /**
     * Permite obtener un incremento por id
     *
     * @return el incremento
     */

    DtoIncremento obtenerPorId(Long id);

}
