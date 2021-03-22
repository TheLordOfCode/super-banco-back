package com.ceiba.incremento.servicio;

import com.ceiba.incremento.puerto.repositorio.RepositorioIncremento;

public class ServicioEliminarIncremento {
    private final RepositorioIncremento repositorioIncremento;

    public ServicioEliminarIncremento(RepositorioIncremento repositorioIncremento) {
        this.repositorioIncremento = repositorioIncremento;
    }

    public void ejecutar(Long id) {
        this.repositorioIncremento.eliminar(id);
    }
}
