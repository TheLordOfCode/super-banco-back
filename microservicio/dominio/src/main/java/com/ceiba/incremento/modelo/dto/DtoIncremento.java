package com.ceiba.incremento.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoIncremento {
    private Long id;
    private String fechaInicio;
    private String fechaFin;
    private Double montoInicial;
    private Double montoFinal;
}
