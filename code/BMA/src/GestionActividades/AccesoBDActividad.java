/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionActividades;

import ServiciosAlmacenamiento.BaseDatos;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
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
        String fechaInicioString = String.format("%1$tY-%1$tm-%1$td", nuevaActividad.getFechaInicio());
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
            actualizacion = actualizacion + "nAlumnos = \"" + nAlumnos + "\" , ";
        }
        if (precioSocio != null) {
            actualizacion = actualizacion + "precioSocio = \"" + precioSocio + "\" , ";
        }
        if (precioNoSocio != null) {
            actualizacion = actualizacion + "precioNoSocio = \"" + precioNoSocio + "\" , ";
        }
        if (idTemporada != null) {
            actualizacion = actualizacion + "Temporada_idTemporada = \"" + idTemporada + "\" , ";
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

    public static boolean InsertarAlumnoActividadBD(BaseDatos accesoBD, int idAlumno, int idTemporada, int idActividad) throws SQLException {
        boolean exito = false;
        List<Integer> listaAlumnos = new ArrayList<>();
        listaAlumnos = getAlumnosActividad(accesoBD, idActividad);

        if (listaAlumnos.indexOf(idAlumno) == -1) {

            try {

                int idcuota = getIDCuota(accesoBD);
                Calendar calendar =  GregorianCalendar.getInstance();
                String fecha = calendar.get(GregorianCalendar.YEAR) + "-" + (calendar.get(GregorianCalendar.MONTH)+1) + "-" + calendar.get(GregorianCalendar.DAY_OF_MONTH);

                String consulta = "INSERT INTO CUOTA (fecha, pagado) VALUES ('" + fecha + "',1)";
                System.out.print("\n\nNo existe el alumno y por lo tanto se inserta");
                
                accesoBD.ejecutaActualizacion(consulta);


                String insercion = "INSERT INTO pagoActividades (Alumno_idAlumno, Actividades_idActividades,"
                        + "Actividades_Temporada_idTemporada, Cuota_idCuota) VALUE (" + idAlumno + ", "
                        + idActividad + ", " + idTemporada + ", " + idcuota + ")";


                accesoBD.ejecutaActualizacion(insercion);
                exito = true;
            } catch (SQLException ex) {
                Logger.getLogger(AccesoBDActividad.class.getName()).log(Level.SEVERE, null, ex);
                exito = false;
            }
        }else
             System.out.print("\n\nexiste el alumno y por lo tanto no se inserta");

        return exito;
    }

    public static boolean EliminarAlumnoBD(BaseDatos accesoBD, int idAlumno, int actividad) throws SQLException {

        List<Integer> listaAlumnos = new ArrayList<Integer>();
        listaAlumnos = getAlumnosActividad(accesoBD, actividad);
        boolean exito = false;

        if (listaAlumnos.indexOf(idAlumno) != -1) {
            int idCuota = getIDCuotaEliminar(accesoBD,idAlumno,actividad);
            String deleteCuota = "DELETE FROM cuota WHERE idCuota = " + idCuota;
            String delete = "DELETE FROM pagoactividades WHERE Alumno_idAlumno = " + idAlumno + " AND Actividades_idActividades"
            + "= " + actividad;
            System.out.print("\n\nEliminar alumno " + delete);
            exito = accesoBD.eliminar(delete);
            exito = accesoBD.eliminar(deleteCuota);
        }else
            System.out.print("\n\nNo ha entrado en eliminar");

        return exito;
    }

    public static List<Integer> getAlumnosActividad(BaseDatos accesoBD, int actividad) throws SQLException {

        List<Integer> listaAlumnos = new ArrayList<>();
        String consulta = "SELECT Alumno_idAlumno FROM pagoactividades WHERE "
                + "Actividades_idActividades = " + actividad;
        ResultSet retset = accesoBD.ejecutaConsulta(consulta);

        while (retset.next()) {
            listaAlumnos.add(retset.getInt(1));
        }

        return listaAlumnos;
    }

    public static int getIDCuota(BaseDatos accesoBD) throws SQLException {
        String Consulta = "SELECT MAX(idCuota) FROM Cuota";
        int id = 0;
        ResultSet retset = accesoBD.ejecutaConsulta(Consulta);
        if (retset.next()) {
            id = retset.getInt(1);
        }
        return id;
    }
    
    public static int getIDCuotaEliminar(BaseDatos accesoBD, int alumno, int actividad) throws SQLException{
        int id = 0;
        String consulta = "SELECT Cuota_idCuota FROM pagoactividades WHERE "
                + "Actividades_idActividades = " + actividad + " AND Alumno_idAlumno =" + alumno;
        ResultSet retset = accesoBD.ejecutaConsulta(consulta);
        
        System.out.print("\nConsulta de la cuota " + consulta);
        
        if(retset.next()){
            id = retset.getInt(1);
        }
        
        return id;
    }
}
