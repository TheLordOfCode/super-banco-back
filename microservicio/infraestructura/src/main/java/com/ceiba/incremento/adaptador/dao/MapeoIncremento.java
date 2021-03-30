package com.ceiba.incremento.adaptador.dao;

import com.ceiba.incremento.modelo.dto.DtoIncremento;
import com.ceiba.incremento.modelo.entidad.Incremento;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class MapeoIncremento implements RowMapper<DtoIncremento>, MapperResult {
    @Override
    public DtoIncremento mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Long id = resultSet.getLong("id");
        LocalDate fechaInicio = extraerLocalDate(resultSet, "fechaInicio");
        LocalDate fechaIFin = extraerLocalDate(resultSet, "fechaFin");
        double montoInicial = resultSet.getDouble("montoInicial");
        double montoFinal = resultSet.getDouble("montoFinal");

        return new DtoIncremento(id, fechaInicio, fechaIFin, montoInicial, montoFinal);
    }
}
