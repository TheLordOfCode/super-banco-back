package com.ceiba.incremento.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.incremento.excepcion.IncrementoExcepcion;
import com.ceiba.incremento.modelo.entidad.Incremento;
import com.ceiba.incremento.puerto.repositorio.RepositorioIncremento;
import com.ceiba.incremento.servicio.testdatabuilder.IncrementoTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioEliminarIncrementoTest {
    private static final String EL_INCREMENTO_A_ELIMINAR_NO_EXISTE = "El incremento a eliminar no existe ";

    @Test
    public void validarEliminarIncrementoTest() {
        // arrange
        Incremento incremento = new IncrementoTestDataBuilder().conId(1L).build();
        RepositorioIncremento repositorioIncremento = Mockito.mock(RepositorioIncremento.class);
        ServicioEliminarIncremento servicioEliminarIncremento = new ServicioEliminarIncremento(repositorioIncremento);
        Mockito.when(repositorioIncremento.existePorId(incremento.getId())).thenReturn(true);
        // act
        servicioEliminarIncremento.ejecutar(incremento.getId());
        // assert
        Mockito.verify(repositorioIncremento).eliminar(incremento.getId());

    }

    @Test
    public void validarExistenciaPreviaIncrementoTest() {
        // arrange
        Incremento incremento = new IncrementoTestDataBuilder().conId(1L).build();
        RepositorioIncremento repositorioIncremento = Mockito.mock(RepositorioIncremento.class);
        ServicioEliminarIncremento servicioEliminarIncremento = new ServicioEliminarIncremento(repositorioIncremento);
        Mockito.when(repositorioIncremento.existePorId(incremento.getId())).thenReturn(false);
        // act - assert
        BasePrueba.assertThrows(() -> servicioEliminarIncremento.ejecutar(incremento.getId()), IncrementoExcepcion.class, EL_INCREMENTO_A_ELIMINAR_NO_EXISTE);


    }
}
