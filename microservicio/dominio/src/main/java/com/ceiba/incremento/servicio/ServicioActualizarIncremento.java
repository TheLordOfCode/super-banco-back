package com.ceiba.incremento.servicio;

import com.ceiba.incremento.excepcion.IncrementoExcepcion;
import com.ceiba.incremento.modelo.dto.DtoIncremento;
import com.ceiba.incremento.modelo.entidad.Incremento;
import com.ceiba.incremento.puerto.repositorio.RepositorioDiasFestivos;
import com.ceiba.incremento.puerto.repositorio.RepositorioIncremento;

public class ServicioActualizarIncremento {
    private static final String EL_INCREMENTO_QUE_INTENTA_ACTUALIZAR_NO_EXISTE = "El incremento que intenta actualizar no existe en el sistema";
    private final RepositorioIncremento repositorioIncremento;
    private final CalcularMontoFinal calcularMontoFinal;

    public ServicioActualizarIncremento(RepositorioIncremento repositorioIncremento, RepositorioDiasFestivos repositorioDiasFestivos) {
        this.repositorioIncremento = repositorioIncremento;
        this.calcularMontoFinal = new CalcularMontoFinal(repositorioDiasFestivos);
    }

    public DtoIncremento ejecutar(Incremento incremento) {
        validarExistenciaPreviaIncremento(incremento.getId());
        double montoFinal = this.calcularMontoFinal.calcular(incremento.getFechaInicio(), incremento.getFechaFin(), incremento.getMontoInicial());
        incremento.setMontoFinal(montoFinal);
        return this.repositorioIncremento.actualizar(incremento);

    }

    private void validarExistenciaPreviaIncremento(long id) {
        boolean existe = this.repositorioIncremento.existePorId(id);
        if (!existe) {
            throw new IncrementoExcepcion(EL_INCREMENTO_QUE_INTENTA_ACTUALIZAR_NO_EXISTE);
        }
    }
}
