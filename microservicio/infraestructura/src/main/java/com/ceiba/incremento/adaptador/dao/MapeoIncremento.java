package com.ceiba.incremento.adaptador.dao;

import com.ceiba.incremento.modelo.dto.DtoIncremento;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class MapeoIncremento implements RowMapper<DtoIncremento>, MapperResult {
    @Override
    public DtoIncremento mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Long id = resultSet.getLong("id");
        LocalDate fechaInicio = extraerLocalDate(resultSet, "fechaInicio");
        LocalDate fechaIFin = extraerLocalDate(resultSet, "fechaFin");
        double montoInicial = resultSet.getDouble("montoInicial");
        double montoFinal = resultSet.getDouble("montoFinal");

        return new DtoIncremento(id, fechaInicio.toString(), fechaIFin.toString(), montoInicial, montoFinal);
    }

}
