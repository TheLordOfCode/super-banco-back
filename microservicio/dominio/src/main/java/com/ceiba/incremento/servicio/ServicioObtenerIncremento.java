package com.ceiba.incremento.servicio;

import com.ceiba.incremento.excepcion.IncrementoExcepcion;
import com.ceiba.incremento.modelo.dto.DtoIncremento;
import com.ceiba.incremento.puerto.dao.DaoIncremento;
import com.ceiba.incremento.puerto.repositorio.RepositorioIncremento;

public class ServicioObtenerIncremento {
    private static final String EL_INCREMENTO_QUE_INTENTA_OBTENER_NO_EXISTE = "El incremento que intenta obtener no existe en el sistema";
    private final RepositorioIncremento repositorioIncremento;
    private final DaoIncremento daoIncremento;

    public ServicioObtenerIncremento(RepositorioIncremento repositorioIncremento, DaoIncremento daoIncremento) {
        this.repositorioIncremento = repositorioIncremento;
        this.daoIncremento = daoIncremento;
    }

    public DtoIncremento ejecutar(Long id) {
        validarExistenciaPreviaIncremento(id);
        return this.daoIncremento.obtenerPorId(id);
    }

    private void validarExistenciaPreviaIncremento(long id) {
        boolean existe = this.repositorioIncremento.existePorId(id);
        if (!existe) {
            throw new IncrementoExcepcion(EL_INCREMENTO_QUE_INTENTA_OBTENER_NO_EXISTE);
        }
    }
}
