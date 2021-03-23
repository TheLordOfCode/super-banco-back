package com.ceiba.dominio;

import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import static java.time.temporal.ChronoUnit.DAYS;

public class ValidadorArgumento {
    private static final String FORMATO_FECHA = "yyyy-MM-dd";

    private ValidadorArgumento() {
    }

    public static void validarObligatorio(Object valor, String mensaje) {
        if (valor == null) {
            throw new ExcepcionValorObligatorio(mensaje);
        }
    }


    public static void validarTopeMaximo(Double valor, int topeMaximo, String mensaje) {
        if (valor > topeMaximo) {
            throw new ExcepcionValorInvalido(mensaje);
        }
    }

    public static void validarTopeMinimo(Double valor, int topeMinimo, String mensaje) {
        if (valor < topeMinimo) {
            throw new ExcepcionValorInvalido(mensaje);
        }
    }


    public static void validarFechaCorrecta(String valor, String mensaje) {
        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat(FORMATO_FECHA);
            formatoFecha.setLenient(false);
            formatoFecha.parse(valor);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(FORMATO_FECHA);
            LocalDate.parse(valor, formatter);
        } catch (ParseException | DateTimeParseException parseException) {
            throw new ExcepcionValorInvalido(mensaje);
        }
    }

    public static void validarLapsoTiempo(LocalDate fechaInicial, LocalDate fechaFinal, int cantidadMaximaDias, String mensaje) {
        int diasLapso = (int) DAYS.between(fechaInicial, fechaFinal);
        if (diasLapso > cantidadMaximaDias) {
            throw new ExcepcionValorInvalido(mensaje);
        }
    }

    public static void validarMenor(LocalDate fechaInicial, LocalDate fechaFinal, String mensaje) {
        if (fechaInicial.isAfter(fechaFinal)) {
            throw new ExcepcionValorInvalido(mensaje);
        }
    }
}
