package com.ceiba.incremento.adaptador.dao;

import com.ceiba.incremento.modelo.dto.DtoIncremento;
import com.ceiba.incremento.puerto.dao.DaoIncremento;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class DaoIncrementoMysql implements DaoIncremento {

    @SqlStatement(namespace = "incremento", value = "listar")
    private static String sqlListar;
    @SqlStatement(namespace = "incremento", value = "listarPorId")
    private static String sqlListarPorId;

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    public DaoIncrementoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoIncremento> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoIncremento());
    }

    @Override
    public DtoIncremento obtenerPorId(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlListarPorId, paramSource, new MapeoIncremento());

    }


}
