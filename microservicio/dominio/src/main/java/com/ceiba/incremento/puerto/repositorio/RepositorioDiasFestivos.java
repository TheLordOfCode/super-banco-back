package com.ceiba.incremento.puerto.repositorio;

import java.time.LocalDate;

public interface RepositorioDiasFestivos {

    /**
     * Permite contar los días festivos en un rango de fechas
     *
     * @param fechaInicial
     * @param diasLapso
     * @return contador de dias festivos
     */

    Integer contarFestivos(LocalDate fechaInicial, int diasLapso);
}
