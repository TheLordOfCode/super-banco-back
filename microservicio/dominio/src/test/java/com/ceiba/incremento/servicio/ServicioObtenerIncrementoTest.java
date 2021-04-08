package com.ceiba.incremento.servicio;
import com.ceiba.BasePrueba;
import com.ceiba.incremento.excepcion.IncrementoExcepcion;
import com.ceiba.incremento.modelo.entidad.Incremento;
import com.ceiba.incremento.puerto.dao.DaoIncremento;
import com.ceiba.incremento.puerto.repositorio.RepositorioIncremento;
import com.ceiba.incremento.servicio.testdatabuilder.IncrementoTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioObtenerIncrementoTest {
    private static final String EL_INCREMENTO_QUE_INTENTA_OBTENER_NO_EXISTE = "El incremento que intenta obtener no existe en el sistema";

    @Test
    public void obtenerIncrementoTest(){
        // arrange
        Incremento incremento = new IncrementoTestDataBuilder().conId(1L).build();
        RepositorioIncremento repositorioIncremento = Mockito.mock(RepositorioIncremento.class);
        DaoIncremento daoIncremento = Mockito.mock(DaoIncremento.class);
        ServicioObtenerIncremento servicioObtenerIncremento = new ServicioObtenerIncremento(repositorioIncremento, daoIncremento);
        Mockito.when(repositorioIncremento.existePorId(incremento.getId())).thenReturn(true);
        // act
        servicioObtenerIncremento.ejecutar(incremento.getId());
        // assert
        Mockito.verify(daoIncremento).obtenerPorId(incremento.getId());
    }

    @Test
    public void validarExistenciaPreviaIncrementoTest() {
        // arrange
        Incremento incremento = new IncrementoTestDataBuilder().conId(1L).build();
        RepositorioIncremento repositorioIncremento = Mockito.mock(RepositorioIncremento.class);
        DaoIncremento daoIncremento = Mockito.mock(DaoIncremento.class);
        ServicioObtenerIncremento servicioObtenerIncremento = new ServicioObtenerIncremento(repositorioIncremento, daoIncremento);
        Mockito.when(repositorioIncremento.existePorId(incremento.getId())).thenReturn(false);
        // act - assert
        BasePrueba.assertThrows(() -> servicioObtenerIncremento.ejecutar(incremento.getId()), IncrementoExcepcion.class, EL_INCREMENTO_QUE_INTENTA_OBTENER_NO_EXISTE );


    }
}
