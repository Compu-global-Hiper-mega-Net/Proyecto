/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionActividades;

import GestionActividades.AccesoBDActividad;
import ServiciosAlmacenamiento.BaseDatos;
import java.sql.*;
import java.util.Date;

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

public class GestorActividad {
    
    public static boolean darAltaActividad (BaseDatos accesoBD,String descripcion, int nAlumnos, float precioSocio, float precioNoSocio, int idTemporada, Date fechaInicio, Date fechaFin, String nombre){
       
        boolean exito = true;
        Actividad actividad = new Actividad(descripcion, nAlumnos, precioSocio, precioNoSocio, idTemporada, fechaInicio, fechaFin, nombre);
        
         try {
            AccesoBDActividad.insertarActividadBD(accesoBD, actividad);
        } catch (SQLException ex) {
            exito = false;
        }


        return exito;
    }
    
    public static boolean InsertarAlumnoActividad (BaseDatos accesoBD, int idAlumno, int idTemporada, int idActividad){
        boolean exito = true;
        
        AccesoBDActividad.InsertarAlumnoActividadBD(accesoBD, idAlumno, idTemporada, idActividad);
        
        return exito;
    }
    
    public static ResultSet consultaActividad(BaseDatos accesoBD, String consulta){
        AccesoBDActividad actividad = new AccesoBDActividad();

        return actividad.consultaActividadBD(accesoBD, consulta);
    }
    
    public static boolean modificaActividad(BaseDatos accesoBD, int idActividad, String descripcion, String nAlumnos,
            String precioSocio, String precioNoSocio, String idTemporada, String fechaInicio, 
            String fechaFin, String nombre){
        
        return AccesoBDActividad.modificarDatosActividadBD(accesoBD, idActividad, descripcion, nAlumnos, precioSocio, 
                precioNoSocio, idTemporada, fechaInicio, fechaFin, nombre);
    }
    
    public static void eliminaActividad(BaseDatos accesoBD, String descripcion, int nAlumnos, float precioSocio, float precioNoSocio, int idTemporada, 
            Date fechaInicio, Date fechaFin, String nombre){
        
        AccesoBDActividad actividadBD = new AccesoBDActividad();
        
        Actividad actividadEliminada = Actividad.creaActividad(descripcion, nAlumnos, precioSocio, precioNoSocio, idTemporada, fechaInicio, fechaFin, nombre);
        
        actividadBD.eliminarActividadBD(accesoBD, actividadEliminada);
        
    }
    
}
