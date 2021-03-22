package com.ceiba.incremento.servicio.testdatabuilder;

import com.ceiba.incremento.comando.ComandoIncremento;

public class ComandoIncrementoTestDataBuilder {

    private Long id;
    private String fechaInicio;
    private String fechaFin;
    private Double montoInicial;

    public ComandoIncrementoTestDataBuilder() {
        fechaInicio = "2020-02-12";
        fechaFin = "2020-02-14";
        montoInicial = 50000.00;
    }

    public ComandoIncrementoTestDataBuilder conNombre(String nombre) {
        this.fechaInicio = nombre;
        return this;
    }

    public ComandoIncremento build() {
        return new ComandoIncremento(id, fechaInicio, fechaFin, montoInicial);
    }
}
