package com.ceiba.incremento.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoIncremento {
    private Long id;
    private String fechaInicio;
    private String fechaFin;
    private Double montoInicial;
}
