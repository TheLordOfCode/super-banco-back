package com.ceiba.incremento.adaptador.repositorio;

import com.ceiba.incremento.modelo.entidad.Incremento;
import com.ceiba.incremento.puerto.repositorio.RepositorioIncremento;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;


@Repository
public class RepositorioIncrementoMysql implements RepositorioIncremento {
    @SqlStatement(namespace = "incremento", value = "crear")
    private static String sqlCrear;
    @SqlStatement(namespace = "incremento", value = "actualizar")
    private static String sqlActualizar;
    @SqlStatement(namespace = "incremento", value = "eliminar")
    private static String sqlEliminar;
    @SqlStatement(namespace = "incremento", value = "existePorId")
    private static String sqlExistePorId;
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;


    public RepositorioIncrementoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Incremento incremento) {
        return this.customNamedParameterJdbcTemplate.crear(incremento, sqlCrear);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
    }

    @Override
    public void actualizar(Incremento incremento) {
        this.customNamedParameterJdbcTemplate.actualizar(incremento, sqlActualizar);
    }

    @Override
    public boolean existePorId(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistePorId, paramSource, Boolean.class);
    }

}