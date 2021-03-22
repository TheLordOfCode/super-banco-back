package com.ceiba.incremento.servicio.testdatabuilder;

import com.ceiba.incremento.modelo.entidad.Incremento;

public class IncrementoTestDataBuilder {

    private Long id;
    private String fechaInicio;
    private String fechaFin;
    private double montoInicial;
    private double montoFinal;


    public IncrementoTestDataBuilder() {
        fechaInicio = "2020-03-19";
        fechaFin = "2020-03-22";
        montoInicial = 50000.00;

    }

    public IncrementoTestDataBuilder conFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
        return this;
    }

    public IncrementoTestDataBuilder conFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
        return this;
    }

    public IncrementoTestDataBuilder conMontoInicial(Double montoInicial) {
        this.montoInicial = montoInicial;
        return this;
    }

    public IncrementoTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public Incremento build() {
        return new Incremento(id, fechaInicio, fechaFin, montoInicial);
    }
}
