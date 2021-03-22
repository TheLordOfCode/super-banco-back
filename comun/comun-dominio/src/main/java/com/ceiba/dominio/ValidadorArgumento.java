package com.ceiba.dominio;

import static java.time.temporal.ChronoUnit.DAYS;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ceiba.dominio.excepcion.ExcepcionLongitudValor;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;

public class ValidadorArgumento {
    private static final String FORMATO_FECHA = "yyyy-MM-dd";

	private ValidadorArgumento() {}

    public static void validarObligatorio(Object valor, String mensaje) {
        if (valor == null) {
            throw new ExcepcionValorObligatorio(mensaje);
        }
    }
    
    public static void validarLongitud(String valor,int longitud,String mensaje){
        if(valor.length() < longitud){
            throw new ExcepcionLongitudValor(mensaje);
        }
    }
    
    public static <T> void validarNoVacio(List<T> lista, String mensaje) {
        if (lista.isEmpty()) {
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

    public static void validarPositivo(Double valor, String mensaje) {
        if (valor <= 0) {
            throw new ExcepcionValorInvalido(mensaje);
        }
    }

    public static void validarIgual(Double valor, Double valorEsperado, String mensaje) {
        if (!valor.equals(valorEsperado)) {
            throw new ExcepcionValorInvalido(mensaje);
        }
    }

    public static void validarLongitudMinima(Object valor, int longitudMinima, String mensaje) {
        if (valor.toString().length() < longitudMinima) {
            throw new ExcepcionLongitudValor(mensaje);
        }
    }
    public static void validarFormatoFecha(String valor, String mensaje) {

        Pattern patronFecha = Pattern.compile("\\d{4}-\\d{2}-\\d{2}");

        Matcher comparadorFormatoFecha = patronFecha.matcher(valor);

        if (!comparadorFormatoFecha.matches()) {
            throw new ExcepcionValorInvalido(mensaje);
        }
    }
    public static void validarFechaCorrecta(String valor, String mensaje){
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
	    if (diasLapso > cantidadMaximaDias ) {
            throw new ExcepcionValorInvalido(mensaje);
        }
    }
    public static void validarMenor(LocalDate fechaInicial, LocalDate fechaFinal, String mensaje) {
        if (fechaInicial.isAfter(fechaFinal)) {
            throw new ExcepcionValorInvalido(mensaje);
        }
    }

    public static void validarMenor(Long numeroInicial, Long numeroFinal, String mensaje) {
        if (numeroInicial > numeroFinal) {
            throw new ExcepcionValorInvalido(mensaje);
        }
    }

    public static void validarRegex(String correoElectronico, String regex, String mensaje) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(correoElectronico);

        if (!matcher.matches()) {
            throw new ExcepcionValorInvalido(mensaje);
        }
    }



    public static <E extends Enum<E>> E validarValido(String valor, Class<E> enumAObtener, String mensaje) {
        E enumObtenido = null;
        if(null != valor) {
            Optional<E> resultadoOpcional = Arrays.stream(enumAObtener.getEnumConstants())
                    .filter(resultado -> resultado.toString().equals(valor)).findFirst();

            if (resultadoOpcional.isPresent()) {
                enumObtenido = resultadoOpcional.get();
            } else {
                throw new ExcepcionValorInvalido(mensaje);
            }
        }
        return enumObtenido;
    }

    public static void validarNumerico(String valor,String mensaje) {
        try {
            Long.parseLong(valor);
        } catch (NumberFormatException numberFormatException) {
            throw new ExcepcionValorInvalido(mensaje);
        }
    }
}
