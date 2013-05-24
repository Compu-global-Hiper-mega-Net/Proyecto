package bma;

import GestionDeInstalaciones.Instalacion;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

/**
 *
 * @author Diego
 */

/*
 ******************************************************************************
                   (c) Copyright 2013 
                   * 
                   * Moisés Gautier Gómez
                   * Julio Ros Martínez
                   * Francisco Javier Gómez del Olmo
                   * Francisco Santolalla Quiñonero
                   * Carlos Jesús Fernández Basso
                   * Alexander Moreno Borrego
                   * Jesús Manuel Contreras Siles
                   * Diego Muñoz Rio
 
    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************
 */

public class Horario {
    private String Dia1;
    private Time Hora1;
    private String Dia2;
    private Time Hora2;
    
    private Instalacion instalacion;

    public Horario(String dia1, String dia2, String hora, String min) throws ParseException {
        Dia1 = dia1;
        Dia2 = dia2;
        
        String aux1 = hora.concat(":").concat(min);
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
        Hora1 = new Time(sdf.parse(aux1).getTime());
        Hora2 = new Time(sdf.parse(aux1).getTime());
    }

    public String getDia1() {
        return Dia1.toString();
    }

    public String getDia2() {
        return Dia2.toString();
    }

    public Time getHora1() {
        return Hora1;
    }

    public Time getHora2() {
        return Hora2;
    }
    
    
}
