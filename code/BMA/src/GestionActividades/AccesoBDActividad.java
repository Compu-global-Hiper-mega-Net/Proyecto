/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionActividades;

import ServiciosAlmacenamiento.BaseDatos;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
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

public class AccesoBDActividad {

    public static void insertarActividadBD(BaseDatos accesoBD, Actividad nuevaActividad) throws SQLException {
        String fechaInicioString = String.format("%1$tY-%1$tm-%1$td",nuevaActividad.getFechaInicio());
        String fechaFinString = String.format("%1$tY-%1$tm-%1$td", nuevaActividad.getFechaFin());
        String insercion = "INSERT INTO actividades ("
                + "nAlumnos, descripcion, precioSocio, precioNoSocio, Temporada_idTemporada, fechaInicio"
                + ", fechaFin, nombre) VALUES (";

        insercion = insercion + nuevaActividad.getNAlumnos() + ",\"" + nuevaActividad.getDescripcion() + "\","
                + nuevaActividad.getPrecioSocio() + "," + nuevaActividad.getPrecioNoSocio() + ","
                + nuevaActividad.getIdTemporada() + ",\"" + fechaInicioString + "\",\""
                + fechaFinString + "\",\"" + nuevaActividad.getNombre() + "\");";

        System.out.print("\n inser " + insercion);
        accesoBD.ejecutaActualizacion(insercion);
        
    }

    public ResultSet consultaActividadBD(BaseDatos accesoBD, String consulta) {
        ResultSet retset;
        retset = accesoBD.ejecutaConsulta(consulta);

        return retset;
    }

    public static boolean modificarDatosActividadBD(BaseDatos accesoBD, int idActividad, String descripcion, String nAlumnos, String precioSocio, String precioNoSocio,
            String idTemporada, String fechaInicio, String fechaFin, String nombre) {

        boolean exito = true;

        String actualizacion = "UPDATE actividades SET ";

        if (descripcion != null) {
            actualizacion = actualizacion + "descripcion = \"" + descripcion + "\" , ";
        }
        if (nAlumnos != null) {
            actualizacion = actualizacion + "nAlumnos = " + nAlumnos + " , ";
        }
        if (precioSocio != null) {
            actualizacion = actualizacion + "precioSocio = " + precioSocio + " , ";
        }
        if (precioNoSocio != null) {
            actualizacion = actualizacion + "precioNoSocio = " + precioNoSocio + " , ";
        }
        if (idTemporada != null) {
            actualizacion = actualizacion + "Temporada_idTemporada = " + idTemporada + " , ";
        }
        if (fechaInicio != null) {
            actualizacion = actualizacion + "fechaInicio = \"" + fechaInicio + "\" , ";
        }
        if (fechaFin != null) {
            actualizacion = actualizacion + "fechaFin = \"" + fechaFin + "\" , ";
        }
        if (nombre != null) {
            actualizacion = actualizacion + "nombre = \"" + nombre + "\" , ";
        }

        actualizacion = actualizacion.substring(0, actualizacion.length() - 2);
        actualizacion = actualizacion + " WHERE idActividades= " + idActividad;
        
        System.out.print("\n" + actualizacion);

        try {
            accesoBD.ejecutaActualizacion(actualizacion);
            System.out.print("\nModificado act\n " + actualizacion);
        } catch (SQLException ex) {
            exito = false;
        }


        return exito;
    }

    public static void eliminarActividadBD(BaseDatos accesoBD, Actividad nuevaActividad) {
        String selId = new String();

        selId = "SELECT a.idActividades FROM actividades a WHERE a.nAlumnos = "
                + nuevaActividad.getNAlumnos();
        if (nuevaActividad.getDescripcion() != null) {
            selId = selId + " AND a.descripcion = \"" + nuevaActividad.getDescripcion() + "\" ";
        }
        if (nuevaActividad.getPrecioSocio() > 0) {
            selId = selId + " AND a.precioSocio = " + nuevaActividad.getPrecioSocio();
        }
        if (nuevaActividad.getPrecioNoSocio() > 0) {
            selId = selId + " AND a.precioNoSocio = " + nuevaActividad.getPrecioNoSocio();
        }
        if (nuevaActividad.getIdTemporada() != 0) {
            selId = selId + " AND a.Temporada_idTemporada = " + nuevaActividad.getIdTemporada();
        }
        if (nuevaActividad.getFechaInicio() != null) {
            selId = selId + " AND a.fechaInicio = \"" + nuevaActividad.getFechaInicio() + "\" ";
        }
        if (nuevaActividad.getFechaFin() != null) {
            selId = selId + " AND a.fechaFin = \"" + nuevaActividad.getFechaFin() + "\" ";
        }
        if (nuevaActividad.getNombre() != null) {
            selId = selId + " AND a.nombre = \"" + nuevaActividad.getNombre() + "\" ";
        }

        System.out.println("Consulta eliminar " + selId);
        ResultSet retset;
        try {
            retset = accesoBD.ejecutaConsulta(selId);
            if (retset.next()) {
                nuevaActividad.setIdActividad(retset.getInt(1));
            }
        } catch (SQLException ex) {
            System.out.print(ex.getMessage());
        }

        String delete = "DELETE FROM actividades WHERE idActividades = "
                + nuevaActividad.getIdActividad();

        System.out.print(delete);
        
        boolean exito = accesoBD.eliminar(delete);
        if (!exito) {
            JOptionPane.showMessageDialog(null, "Ha habido un error en la base de datos",
                    "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Actividad Eliminada",
                    "Confirmacion", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public static boolean InsertarAlumnoActividadBD (BaseDatos accesoBD, int idAlumno, int idTemporada, int idActividad){
        boolean exito = false;
        
        try {
            ResultSet rts, retset;
            exito = true;
            
            String insercion = "INSERT INTO pagoActividades (Alumno_idAlumno, Actividades_idActividades,"
                    + "Actividades_Temporada_idTemporada, Couta_idCuota) SET (";
            String cuota = "SELECT Cuota_idCuota FROM pagotemporada WHERE AlumnoTemporada_Alumno_idAlumno = " + idAlumno + 
                    " AND AlumnoTemporada_Temporada_idTemporada = " + idTemporada;
            
            rts = accesoBD.ejecutaConsulta(cuota);
            int idcuota = rts.getInt("Cuota_idCuota");
            insercion = insercion + idAlumno + ", " + idActividad + ", "+ idcuota + ")";
            
            retset = accesoBD.ejecutaConsulta(insercion);
        } catch (SQLException ex) {
            Logger.getLogger(AccesoBDActividad.class.getName()).log(Level.SEVERE, null, ex);
            exito = false;
        }
        return exito;
    }
}
