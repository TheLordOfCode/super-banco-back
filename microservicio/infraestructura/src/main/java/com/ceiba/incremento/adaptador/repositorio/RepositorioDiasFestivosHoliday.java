package com.ceiba.incremento.adaptador.repositorio;

import com.ceiba.incremento.adaptador.dao.HolidayUtil;
import com.ceiba.incremento.puerto.repositorio.RepositorioDiasFestivos;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public class RepositorioDiasFestivosHoliday implements RepositorioDiasFestivos {
    @Override
    public Integer contarFestivos(LocalDate fechaInicial, int diasLapso) {
        int contarFestivos = 0;
        for (long dia = 0; dia <= diasLapso; dia++) {
            LocalDate fechaAValidar = fechaInicial.plusDays(dia);
            HolidayUtil diasFestivos = new HolidayUtil(fechaAValidar.getYear());
            boolean esFestivo = diasFestivos.isHoliday(fechaAValidar.getMonthValue(), fechaAValidar.getDayOfMonth());
            if (esFestivo) {
                contarFestivos++;
            }
        }
        return contarFestivos;
    }
}