package com.ceiba.incremento.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class DtoIncremento {
    private Long id;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Double montoInicial;
    private Double montoFinal;
}
