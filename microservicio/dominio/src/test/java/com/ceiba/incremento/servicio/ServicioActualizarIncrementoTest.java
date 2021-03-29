package com.ceiba.incremento.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.incremento.excepcion.IncrementoExcepcion;
import com.ceiba.incremento.modelo.entidad.Incremento;
import com.ceiba.incremento.puerto.repositorio.RepositorioDiasFestivos;
import com.ceiba.incremento.puerto.repositorio.RepositorioIncremento;
import com.ceiba.incremento.servicio.testdatabuilder.IncrementoTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioActualizarIncrementoTest {
    private static final String EL_INCREMENTO_QUE_INTENTA_ACTUALIZAR_NO_EXISTE = "El incremento que intenta actualizar no existe en el sistema";
    private static final Double VALOR_MONTO_FINAL = 120000.00;

    @Test
    public void validarIncrementoExistenciaPreviaTest() {
        // arrange
        Incremento incremento = new IncrementoTestDataBuilder().conId(1L).build();
        RepositorioIncremento repositorioIncremento = Mockito.mock(RepositorioIncremento.class);
        RepositorioDiasFestivos repositorioDiasFestivos = Mockito.mock(RepositorioDiasFestivos.class);
        Mockito.when(repositorioIncremento.existePorId(Mockito.anyLong())).thenReturn(false);
        ServicioActualizarIncremento servicioActualizarIncremento = new ServicioActualizarIncremento(repositorioIncremento, repositorioDiasFestivos);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarIncremento.ejecutar(incremento), IncrementoExcepcion.class, EL_INCREMENTO_QUE_INTENTA_ACTUALIZAR_NO_EXISTE);
    }
    @Test
    public void validarActualizarIncrementoTest(){
        Incremento incremento = new IncrementoTestDataBuilder().conId(1L).build();
        RepositorioIncremento repositorioIncremento = Mockito.mock(RepositorioIncremento.class);
        RepositorioDiasFestivos repositorioDiasFestivos = Mockito.mock(RepositorioDiasFestivos.class);

        Mockito.when(repositorioIncremento.existePorId(Mockito.anyLong())).thenReturn(true);
        CalcularMontoFinal calcularMontoFinal = Mockito.mock(CalcularMontoFinal.class);
        Mockito.when(calcularMontoFinal.calcular(Mockito.any(), Mockito.any(), Mockito.anyDouble())).thenReturn(VALOR_MONTO_FINAL);
        ServicioActualizarIncremento servicioActualizarIncremento = new ServicioActualizarIncremento(repositorioIncremento, repositorioDiasFestivos);
        // act
        servicioActualizarIncremento.ejecutar(incremento);
        // assert
        Mockito.verify(repositorioIncremento).actualizar(incremento);

    }
}