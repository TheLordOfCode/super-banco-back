package com.ceiba.incremento.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.incremento.modelo.entidad.Incremento;
import com.ceiba.incremento.puerto.repositorio.RepositorioDiasFestivos;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class CalcularMontoFinalTest {
    private static final String FECHA_INICIAL = "2020-02-03";
    private static final String FECHA_FINAL = "2020-02-08";
    private static final Double VALOR_MONTO_INICIAL = 350000.00;
    private static final Double VALOR_MONTO_FINAL = 755168.7500000001;
    private static final int DIAS_LAPSO = 5;
    private static final int DIAS_FESTIVO = 1;
    @Mock
    private RepositorioDiasFestivos repositorioDiasFestivos;

    @InjectMocks
    private CalcularMontoFinal calcularMontoFinal;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void CalcularTest() {

        Mockito.when(repositorioDiasFestivos.contarFestivos(
                Incremento.obtenerLocalDateDesdeUnString(FECHA_INICIAL), DIAS_LAPSO)).thenReturn(DIAS_FESTIVO);

        Double montoFinal = calcularMontoFinal.calcular(Incremento.obtenerLocalDateDesdeUnString(FECHA_INICIAL),
                Incremento.obtenerLocalDateDesdeUnString(FECHA_FINAL), VALOR_MONTO_INICIAL);

        Assert.assertEquals(montoFinal, VALOR_MONTO_FINAL);

    }
}
