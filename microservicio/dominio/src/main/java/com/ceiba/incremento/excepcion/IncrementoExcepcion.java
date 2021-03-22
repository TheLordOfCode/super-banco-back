package com.ceiba.incremento.excepcion;

public class IncrementoExcepcion extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public IncrementoExcepcion(String message) {
        super(message);
    }
}
