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
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


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

/**
 * Clase que permite el paso de objetos de tipo java a objetos de tipo
 * relacional en formato MySql.
 * @author Jesus Manuel Contreras Siles
 * @version 1.0
 */

public class AccesoBDActividad {

		/* Atributos que contiene la tabla actividad
		 * - idActividades
		 * - nAlumnos
		 * - descripcion
		 * - precioSocio
		 * - precioNoSocio
		 * - Temporada_idTemporada
		 * - fechaInicio
		 * - fechaFin
		 * - nombre
		 */

		/**
		 * Metodo para insertar una actividad en la base de datos.
		 * @param accesoBD BaseDatos (BaseDatos) con el acceso a la base de datos.
		 * @param nuevaActividad Actividad (actividad) con la actividad a insertar en la base de datos.
     * @throws SQLException algun tipo de error en la base de datos.
		 */ 

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

		/**
		 * Metodo para realizar consultas sobre actividades.
		 * @param accesoBD BaseDatos (BaseDatos) con el acceso a la base de datos.
		 * @param consulta String (cadena) con la consulta a realizar.
		 * @return ResultSet (java.sql.ResultSet) con el atributo interno de la 
		 */

    public ResultSet consultaActividadBD(BaseDatos accesoBD, String consulta) {
        ResultSet retset;
        retset = accesoBD.ejecutaConsulta(consulta);

        return retset;
    }

		/**
		 * Metodo para modificar una actividad insertada en la base de datos.
		 * @param accesoBD BaseDatos (BaseDatos) con el acceso a la base de datos.
		 * @param idActividad int (entero) con el identificador de la actividad a modificar.
		 * @param descripcion String (cadena) con la descripcion de la actividad.
		 * @param nAlumnos String (cadena) con el numero de los alumnos.
		 * @param precioSocio String (cadena) con el precio de la actividad para los socios.
		 * @param precioNoSocio String (cadena) con el precio de la actividad para los no socios.
		 * @param idTemporada String (cadena) con el identificador de la temporada a la que pertenece la actividad.
		 * @param fechaInicio String (cadena) con la fecha de inicio de la actividad.
		 * @param fechaFin String (cadena) con la fecha de fin de la actividad.
		 * @param nombre String (nombre) con el nombre de la actividad.
		 * @return boolean (logico) con el atributo interno de la comprobación si se ha modificado con exito o no.
		 */

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

		/**
		 * Metodo para eliminar una actividad de la base de datos.
		 * @param accesoBD BaseDatos (BaseDatos) con el acceso a la base de datos.
		 * @param nuevaActividad Actividad (actividad) con la actividad a eliminar.
		 */

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

		/**
		 * Metodo para insertar un alumno en una actividad
		 * @param accesoBD BaseDatos (BaseDatos) con el acceso a la base de datos.
		 * @param idAlumno int (entero) con el identificador del alumno a insertar.
		 * @param idTemporada int (entero) con el identificador de la temporada a la que pertenece la actividad.
		 * @param idActividad int (entero) con el identificador de la actividad a la que se va a insertar la actividad.
     * @throws SQLException algun tipo de error en la base de datos.
		 * @return boolean (logico) con el atributo interno de la comprobación de si se ha insertardo el alumno o no.
		 */

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
		
		/**
		 * Metodo para eliminar un alumno inscrito en una actividad.
		 * @param accesoBD BaseDatos (BaseDatos) con el acceso a la base de datos.
		 * @param idAlumno int (entero) con el id del alumno a eliminar.
		 * @param actividad int (entero) con el id de la actividad a la que pertenece el alumno. 
     * @throws SQLException algun tipo de error en la base de datos.
		 * @return boolean (logico) con el atributo interno de la comprobacion si se ha eliminado con exito o no.
		 */ 

    public static boolean EliminarAlumnoBD(BaseDatos accesoBD, int idAlumno, int actividad) throws SQLException {

        List<Integer> listaAlumnos = new ArrayList<>();
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

		/**
		 * Metodo para consultar los alumnos que hay en una actividad.
		 * @param accesoBD BaseDatos (BaseDatos) con el acceso a la base de datos.
		 * @param actividad int (entero) con el identificador de la actividad.
     * @throws SQLException algun tipo de error en la base de datos.
		 * @return List<Integer> (lista) con el atributo interno de los id de los alumnos inscritos en esa actividad.
		 */

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

		/**
		 * Metodo para consultar la ultima cuota creada.
		 * @para accesoBD BaseDatos (BaseDatos) con el acceso a la base de datos.
     * @throws SQLException algun tipo de error en la base de datos.
		 * @return int (entero) con el atributo interno del identificador de la cuota.
		 */

    public static int getIDCuota(BaseDatos accesoBD) throws SQLException {
        String Consulta = "SELECT MAX(idCuota) FROM Cuota";
        int id = 0;
        ResultSet retset = accesoBD.ejecutaConsulta(Consulta);
        if (retset.next()) {
            id = retset.getInt(1);
        }
        return id;
    }

		/**
		 * Metodo para consultar la cuota a eliminar.
		 * @param accesoBD BaseDatos (BaseDatos) con el acceso a la base de datos.
		 * @param alumno int (entero) con el identificador del alumno.
		 * @param actividad int (entero) con el identificador de la actividad.
     * @throws SQLException algun tipo de error en la base de datos.
		 * @return int (entero) con el atributo interno del identificador de la cuota.
		 */
    
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
