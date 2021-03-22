package com.ceiba.configuracion;

import com.ceiba.incremento.puerto.repositorio.RepositorioDiasFestivos;
import com.ceiba.incremento.puerto.repositorio.RepositorioIncremento;
import com.ceiba.incremento.servicio.ServicioActualizarIncremento;
import com.ceiba.incremento.servicio.ServicioCrearIncremento;
import com.ceiba.incremento.servicio.ServicioEliminarIncremento;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    @Bean
    public ServicioCrearIncremento servicioCrearIncremento(RepositorioIncremento repositorioIncremento, RepositorioDiasFestivos repositorioDiasFestivos) {
        return new ServicioCrearIncremento(repositorioIncremento, repositorioDiasFestivos);
    }

    @Bean
    public ServicioEliminarIncremento servicioEliminarIncremento(RepositorioIncremento repositorioIncremento) {
        return new ServicioEliminarIncremento(repositorioIncremento);
    }

    @Bean
    public ServicioActualizarIncremento servicioActualizarIncremento(RepositorioIncremento repositorioIncremento, RepositorioDiasFestivos repositorioDiasFestivos) {
        return new ServicioActualizarIncremento(repositorioIncremento, repositorioDiasFestivos);
    }


}
