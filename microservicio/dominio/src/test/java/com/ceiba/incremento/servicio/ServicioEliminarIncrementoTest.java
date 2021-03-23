package com.ceiba.incremento.servicio;

import com.ceiba.incremento.modelo.entidad.Incremento;
import com.ceiba.incremento.puerto.repositorio.RepositorioIncremento;
import com.ceiba.incremento.servicio.testdatabuilder.IncrementoTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioEliminarIncrementoTest {

    @Test
    public void validarEliminarIncrementoTest(){
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
}
