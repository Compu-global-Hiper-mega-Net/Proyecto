/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionDeInstalaciones;

import ServiciosAlmacenamiento.BaseDatos;
import java.sql.*;
import java.util.List;

/**
 *
 * @author Jesus Manuel Contreras Siles
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



public class GestorInstalacion {

    public static boolean darAltaInstalacion(BaseDatos accesoBD, String nombre,
            int capacidad, String localizacion) {

        boolean exito = true;
        Instalacion instalacion = new Instalacion(nombre, capacidad, localizacion);

        try {
            AccesoBDInstalacion.insertarInstalacionBD(accesoBD, instalacion);
        } catch (SQLException ex) {
            exito = false;
        }


        return exito;
    }

    public static ResultSet consultaInstalacion(BaseDatos accesoBD, String consulta) {
        AccesoBDInstalacion instalacion = new AccesoBDInstalacion();

        return instalacion.consultaInstalacionBD(accesoBD, consulta);
    }

    public static boolean modificaInstalacion(BaseDatos accesoBD, int idInstalacion, String nombre,
            String capacidad, String locacizacion) {

        return AccesoBDInstalacion.modificarDatosInstalacionBD(accesoBD, idInstalacion,
                nombre, capacidad, locacizacion);
    }
    
    public static void eliminaInstalacion(BaseDatos accesoBD, String nombre,
            int capacidad, String locacizacion){
        
        AccesoBDInstalacion instalacionBD = new AccesoBDInstalacion();
        
        Instalacion instalacionEliminada = Instalacion.crearInstalacion(nombre, capacidad, locacizacion);
        
        instalacionBD.eliminarInstalacionBD(accesoBD, instalacionEliminada);
        
    }

    public static int getIdInstalacion(BaseDatos accesoBD, String inst) throws SQLException {
        return AccesoBDInstalacion.getIdInstalacion(accesoBD, inst);
    }

    public static List<String> getListaInstalaciones(BaseDatos accesoBD) throws SQLException {
        return AccesoBDInstalacion.getListaInstalaciones(accesoBD);
    }
}