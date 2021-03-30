package com.ceiba.incremento.puerto.repositorio;

import com.ceiba.incremento.modelo.dto.DtoIncremento;
import com.ceiba.incremento.modelo.entidad.Incremento;


public interface RepositorioIncremento {
    /**
     * Permite crear un incremento
     *
     * @param incremento
     * @return el id generado
     */
    DtoIncremento crear(Incremento incremento);

    /**
     * Permite actualizar un incremento
     *
     * @param incremento
     */
    void actualizar(Incremento incremento);

    /**
     * Permite eliminar un incremento
     *
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite Verificar si existe incremento por id
     *
     * @param id
     */
    boolean existePorId(Long id);

}
