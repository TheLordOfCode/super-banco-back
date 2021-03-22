package com.ceiba.incremento.servicio;

import com.ceiba.incremento.modelo.entidad.Incremento;
import com.ceiba.incremento.puerto.repositorio.RepositorioDiasFestivos;
import com.ceiba.incremento.puerto.repositorio.RepositorioIncremento;
import com.ceiba.incremento.servicio.testdatabuilder.IncrementoTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioCrearIncrementoTest {
    private static final Double VALOR_MONTO_FINAL = 110000.00;


    @Test
    public void validarCrearIncrementoTest() {
        // arrange
        Incremento incremento = new IncrementoTestDataBuilder().build();
        RepositorioIncremento repositorioIncremento = Mockito.mock(RepositorioIncremento.class);
        RepositorioDiasFestivos repositorioDiasFestivos = Mockito.mock(RepositorioDiasFestivos.class);
        CalcularMontoFinal calcularMontoFinal = Mockito.mock(CalcularMontoFinal.class);

        Mockito.when(calcularMontoFinal.calcular(Mockito.any(), Mockito.any(), Mockito.anyDouble())).thenReturn(VALOR_MONTO_FINAL);
        ServicioCrearIncremento servicioCrearIncremento = new ServicioCrearIncremento(repositorioIncremento, repositorioDiasFestivos);
        // act
        servicioCrearIncremento.ejecutar(incremento);
        // assert
        Mockito.verify(repositorioIncremento).crear(incremento);
    }
}
