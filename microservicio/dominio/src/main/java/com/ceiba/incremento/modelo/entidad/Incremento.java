package com.ceiba.incremento.modelo.entidad;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.ceiba.dominio.ValidadorArgumento.*;


@Setter
@Getter
public class Incremento {
    private static final String FORMATO_FECHA = "yyyy-MM-dd";
    private static final String SE_DEBE_INGRESAR_LA_FECHA_INICIO = "Se debe ingresar la fecha de inicio";
    private static final String LA_FECHA_DE_INICIO_ES_INVALIDA = "La fecha de inicio es inválida";
    private static final String LA_FECHA_FINAL_ES_INVALIDA = "La fecha final es inválida";
    private static final String SE_DEBE_INGRESAR_LA_FECHA_FIN = "Se debe ingresar la fecha final";
    private static final String LA_FECHA_FIN_ES_DESPUES_DE_LA_FECHA_INICIO = "Se debe ingresar una fecha final mayor a la fecha inicio";
    private static final String LAPSO_DE_TIEMPO_MENOR_QUINCE_DIAS = "El lapso de tiempo entre las fechas debe ser menor o igual a quince dias";
    private static final String SE_DEBE_INGRESAR_EL_MONTO_INICIAL = "Se debe ingresar el monto de dinero inicial";
    private static final String VALOR_MONTO_MAXIMO = "El monto máximo debe ser de 5000000";
    private static final String VALOR_MONTO_MINIMO = "El monto mínimo debe ser de 10000";

    private static final int MONTO_MAXIMO = 5000000;
    private static final int MONTO_MINIMO = 10000;
    private static final int CANTIDAD_MAXIMA_DIAS = 15;


    private Long id;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private double montoInicial;
    private double montoFinal;


    public Incremento(Long id, String fechaInicio, String fechaFin, double montoInicial) {
        validarFechaCorrecta(fechaInicio, LA_FECHA_DE_INICIO_ES_INVALIDA);
        validarFechaCorrecta(fechaFin, LA_FECHA_FINAL_ES_INVALIDA);
        validarObligatorio(fechaInicio, SE_DEBE_INGRESAR_LA_FECHA_INICIO);
        validarObligatorio(fechaFin, SE_DEBE_INGRESAR_LA_FECHA_FIN);
        validarObligatorio(montoInicial, SE_DEBE_INGRESAR_EL_MONTO_INICIAL);
        validarTopeMaximo(montoInicial, MONTO_MAXIMO, VALOR_MONTO_MAXIMO);
        validarTopeMinimo(montoInicial, MONTO_MINIMO, VALOR_MONTO_MINIMO);

        LocalDate fechaInicial = obtenerLocalDateDesdeUnString(fechaInicio);
        LocalDate fechaFinal = obtenerLocalDateDesdeUnString(fechaFin);

        validarMenor(fechaInicial, fechaFinal, LA_FECHA_FIN_ES_DESPUES_DE_LA_FECHA_INICIO);
        validarLapsoTiempo(fechaInicial, fechaFinal, CANTIDAD_MAXIMA_DIAS, LAPSO_DE_TIEMPO_MENOR_QUINCE_DIAS);

        this.id = id;
        this.fechaInicio = fechaInicial;
        this.fechaFin = fechaFinal;
        this.montoInicial = montoInicial;
    }

    public LocalDate obtenerLocalDateDesdeUnString(String fecha) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(FORMATO_FECHA);
        return LocalDate.parse(fecha, formatter);
    }

}
