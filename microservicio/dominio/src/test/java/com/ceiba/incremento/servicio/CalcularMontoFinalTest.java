package com.ceiba.incremento.servicio;

import com.ceiba.incremento.modelo.entidad.Incremento;
import org.junit.Test;
import org.mockito.Mockito;

public class CalcularMontoFinalTest {
    private static final String FECHA_INICIAL = "2020-02-03";
    private static final String FECHA_FINAL = "2020-02-08";
    private static final Double VALOR_MONTO_INICIAL = 350000.00;
    private static final Double VALOR_MONTO_FINAL = 780677.1875000001;

    @Test
    public void CalcularTest() {
        CalcularMontoFinal calcularMontoFinal = Mockito.mock(CalcularMontoFinal.class);
        Mockito.when(calcularMontoFinal.calcular(
                Incremento.obtenerLocalDateDesdeUnString(FECHA_INICIAL),
                Incremento.obtenerLocalDateDesdeUnString(FECHA_FINAL),
                VALOR_MONTO_INICIAL)).thenReturn(VALOR_MONTO_FINAL);
    }
}
