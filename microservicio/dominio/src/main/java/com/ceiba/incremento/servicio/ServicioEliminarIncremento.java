package com.ceiba.incremento.servicio;

import com.ceiba.incremento.excepcion.IncrementoExcepcion;
import com.ceiba.incremento.puerto.repositorio.RepositorioIncremento;

public class ServicioEliminarIncremento {
    private final RepositorioIncremento repositorioIncremento;
    private static final String EL_INCREMENTO_A_ELIMINAR_NO_EXISTE = "El incremento a eliminar no existe ";


    public ServicioEliminarIncremento(RepositorioIncremento repositorioIncremento) {
        this.repositorioIncremento = repositorioIncremento;
    }

    public void ejecutar(Long id) {
        validarExistenciaPreviaIncremento(id);
        this.repositorioIncremento.eliminar(id);
    }


     private void validarExistenciaPreviaIncremento(Long id) {
        boolean existe = this.repositorioIncremento.existePorId(id);
        if (!existe) {
            throw new IncrementoExcepcion(EL_INCREMENTO_A_ELIMINAR_NO_EXISTE);
        }
    }

}
