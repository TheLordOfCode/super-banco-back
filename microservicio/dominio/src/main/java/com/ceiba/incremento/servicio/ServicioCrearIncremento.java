package com.ceiba.incremento.servicio;

import com.ceiba.incremento.modelo.dto.DtoIncremento;
import com.ceiba.incremento.modelo.entidad.Incremento;
import com.ceiba.incremento.puerto.repositorio.RepositorioDiasFestivos;
import com.ceiba.incremento.puerto.repositorio.RepositorioIncremento;

public class ServicioCrearIncremento {
    private final RepositorioIncremento repositorioIncremento;
    private final CalcularMontoFinal calcularMontoFinal;

    public ServicioCrearIncremento(RepositorioIncremento repositorioIncremento, RepositorioDiasFestivos repositorioDiasFestivos) {
        this.repositorioIncremento = repositorioIncremento;
        this.calcularMontoFinal = new CalcularMontoFinal(repositorioDiasFestivos);
    }

    public DtoIncremento ejecutar(Incremento incremento) {
        double montoFinal = this.calcularMontoFinal.calcular(incremento.getFechaInicio(), incremento.getFechaFin(), incremento.getMontoInicial());
        incremento.setMontoFinal(montoFinal);

        return this.repositorioIncremento.crear(incremento);
    }

}
