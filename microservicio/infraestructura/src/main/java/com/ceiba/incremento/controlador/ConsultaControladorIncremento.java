package com.ceiba.incremento.controlador;

import com.ceiba.incremento.consulta.ManejadorListarIncrementos;
import com.ceiba.incremento.consulta.ManejadorObtenerIncremento;
import com.ceiba.incremento.modelo.dto.DtoIncremento;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/incrementos")
@Api(tags = {"Controlador consulta incrementos"})
public class ConsultaControladorIncremento {

    private final ManejadorListarIncrementos manejadorListarIncrementos;
    private final ManejadorObtenerIncremento manejadorObtenerIncremento;

    public ConsultaControladorIncremento(ManejadorListarIncrementos manejadorListarIncrementos, ManejadorObtenerIncremento manejadorObtenerIncremento) {
        this.manejadorListarIncrementos = manejadorListarIncrementos;
        this.manejadorObtenerIncremento = manejadorObtenerIncremento;
    }

    @GetMapping
    @ApiOperation("Listar Incrementos")
    public List<DtoIncremento> listar() {
        return this.manejadorListarIncrementos.ejecutar();
    }


    @GetMapping(value = "/{id}")
    @ApiOperation("Obtener Por Id")
    public DtoIncremento obtenerPorId(@PathVariable Long id) {
        return this.manejadorObtenerIncremento.ejecutar(id);
    }
}
