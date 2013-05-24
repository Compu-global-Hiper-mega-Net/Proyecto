package bma;

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

public enum DiasSemana {
    Lunes, Martes, Miercoles, Jueves, Viernes, Sabado, Domingo;

    public static int getNumeroDia(String dia) {
        
        int res = 0;
        
        if("Lunes".equals(dia))
            res = 0;
        else if("Martes".equals(dia))
            res = 1;
        else if("Miercoles".equals(dia))
            res = 2;
        else if("Jueves".equals(dia))
            res = 3;
        else if("Viernes".equals(dia))
            res = 4;
        else if("Sabado".equals(dia))
            res = 5;
        else if("Domingo".equals(dia))
            res = 6;
        
        
        return res;
    
    }
   
}
