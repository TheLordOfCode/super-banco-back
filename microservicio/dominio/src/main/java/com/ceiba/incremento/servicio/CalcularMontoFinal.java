package com.ceiba.incremento.servicio;

import com.ceiba.incremento.puerto.repositorio.RepositorioDiasFestivos;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

public class CalcularMontoFinal {
    private static final int SABADO = 6;
    private static final int DOMINGO = 7;
    private static final double INTERES = 0.05;
    private static final double INTERES_FIN_DE_SEMANA = 0.015;

    private final RepositorioDiasFestivos repositorioDiasFestivos;

    public CalcularMontoFinal(RepositorioDiasFestivos repositorioDiasFestivos) {
        this.repositorioDiasFestivos = repositorioDiasFestivos;

    }

    public double calcular(LocalDate fechaInicial, LocalDate fechaFinal, Double montoInicial) {

        int diasLapso = (int) DAYS.between(fechaInicial, fechaFinal);
        int diasFinchos = 0;
        int diasFestivos = 0;
        diasFinchos = contarDiasFinSemana(fechaInicial, diasLapso);
        diasFestivos = this.repositorioDiasFestivos.contarFestivos(fechaInicial, diasLapso);
        return montoInicial * (Math.pow((1 + INTERES), (diasLapso - diasFinchos - diasFestivos)) + Math.pow((1 + INTERES_FIN_DE_SEMANA), (diasFinchos - diasFestivos)));
    }

    private int contarDiasFinSemana(LocalDate fechaInicial, int diasLapso) {
        int contadorFinchos = 0;
        for (long dia = 0; dia <= diasLapso; dia++) {
            LocalDate fechaAValidar = fechaInicial.plusDays(dia);
            if (fechaAValidar.getDayOfWeek().getValue() == SABADO || fechaAValidar.getDayOfWeek().getValue() == DOMINGO) {
                contadorFinchos++;
            }
        }
        return contadorFinchos;
    }

}
