package com.ceiba.incremento.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.incremento.comando.ComandoIncremento;
import com.ceiba.incremento.servicio.testdatabuilder.ComandoIncrementoTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationMock.class)
@WebMvcTest(ComandoControladorIncremento.class)
public class ComandoControladoIncrementoTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Test
    public void crear() throws Exception {
        // arrange
        ComandoIncremento incremento = new ComandoIncrementoTestDataBuilder().build();

        // act - assert
        mocMvc.perform(post("/incrementos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(incremento)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'id': 201, 'fechaInicio': '2020-02-12', 'fechaFin': '2020-02-14', 'montoInicial': 50000.0 , 'montoFinal': 105125.0 }"));

    }

    //realizar consulta para verificar que el flujo se ejecuto correctamente manejo de assert
    @Test
    public void actualizar() throws Exception {
        // arrange
        Long id = 200L;
        double montoInicial = 60000;
        ComandoIncremento incremento = new ComandoIncrementoTestDataBuilder().conMontoInicial(montoInicial).build();

        // act - assert
        mocMvc.perform(put("/incrementos/{id}", id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(incremento)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'id': 200, 'fechaInicio': '2020-02-12', 'fechaFin': '2020-02-14', 'montoInicial': 60000.0 , 'montoFinal': 126150.0 }"));
    }

    @Test
    public void eliminar() throws Exception {
        // arrange
        Long id = 201L;

        // act - assert
        mocMvc.perform(delete("/incrementos/{id}", id)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }
}
