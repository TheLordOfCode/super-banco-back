package com.ceiba.infraestructura.jdbc;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;


public interface MapperResult {

	default LocalDate extraerLocalDate(ResultSet resultSet, String label) throws SQLException {
        Date fecha = resultSet.getDate(label);
        LocalDate resultado = null;
        if (!resultSet.wasNull()) {
            resultado = fecha.toLocalDate();
        }
        return resultado;
    } 

}
