package com.ceiba.incremento.controlador;

import com.ceiba.incremento.comando.ComandoIncremento;
import com.ceiba.incremento.comando.manejador.ManejadorActualizarIncremento;
import com.ceiba.incremento.comando.manejador.ManejadorCrearIncremento;
import com.ceiba.incremento.comando.manejador.ManejadorEliminarIncremento;
import com.ceiba.incremento.modelo.dto.DtoIncremento;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/incrementos")
@Api(tags = {"Controlador comando incremento"})
public class ComandoControladorIncremento {

    private final ManejadorCrearIncremento manejadorCrearIncremento;
    private final ManejadorEliminarIncremento manejadorEliminarIncremento;
    private final ManejadorActualizarIncremento manejadorActualizarIncremento;


    @Autowired
    public ComandoControladorIncremento(ManejadorCrearIncremento manejadorCrearIncremento,
                                        ManejadorEliminarIncremento manejadorEliminarIncremento,
                                        ManejadorActualizarIncremento manejadorActualizarIncremento) {
        this.manejadorCrearIncremento = manejadorCrearIncremento;
        this.manejadorEliminarIncremento = manejadorEliminarIncremento;
        this.manejadorActualizarIncremento = manejadorActualizarIncremento;
    }

    @PostMapping
    @ApiOperation("Crear Incremento")

    public DtoIncremento crear(@RequestBody ComandoIncremento comandoIncremento) {
        return manejadorCrearIncremento.ejecutar(comandoIncremento);
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation("Eliminar Incremento")

    public void eliminar(@PathVariable Long id) {
        manejadorEliminarIncremento.ejecutar(id);
    }

    @PutMapping(value = "/{id}")
    @ApiOperation("Actualizar Incremento")
    public  DtoIncremento actualizar(@RequestBody ComandoIncremento comandoIncremento, @PathVariable Long id) {
        comandoIncremento.setId(id);
        return manejadorActualizarIncremento.ejecutar(comandoIncremento);
    }

}
