/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EstadisticasXML;

import GestionActividades.AccesoBDActividad;
import GestionActividades.Actividad;
import ServiciosAlmacenamiento.BaseDatos;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Clase que permite el paso de objetos de tipo java a objetos de tipo relacional
 * en formato mysql.
 * 
 * @author Moises Gautier Gomez
 * @version 1.0
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

public class EstadisticasBD {
    
    /* Atributos que contiene la 
     * tabla estadisticaalumno
     * - partido_idPartido
     * - partido_idEquipo
     * - partido_equipo_Fundacion_idFundacion
     * - partido_equipo_Categoria_idCategoria
     * - partido_equipo_Temporada_idTemporada
     * - partido_equipo_liga_idLiga
     * - partido_idEquipoVisitante
     * - partido_equipo_Fundacion_idFundacion1
     * - partido_equipo_Categoria_idCategoria1
     * - partido_equipo_Temporada_idTemporada1
     * - partido_equipo_liga_idLiga1
     * - alumno_idAlumno
     * - puntos
     * - rebotesOfensivos
     * - rebotesDefensivos
     * - asistencias
     * - robos
     * - perdidas
     * Los datos de los id habrá que obtenerlos previamente
     * bajo una consulta del jugador en la bd. No se van a introducir
     * en el XML.
     */
    
    /*
     * @param accesoBD
     * @param
     * @version
     */
    
     public static void insertarEstadisticasJugadoresBD(BaseDatos accesoBD, EstadisticasJugadores nuevaEstadisticaJugador) throws SQLException {
        
        String insercion = "INSERT INTO actividades ("
                + "nAlumnos, descripcion, precioSocio, precioNoSocio, Temporada_idTemporada, fechaInicio"
                + ", fechaFin, nombre) VALUES (";

        System.out.print("\n inser " + insercion);
        accesoBD.ejecutaActualizacion(insercion);
        
    }
     
     /*
      * @param
      * @param
      * @version
      */
     
     public ResultSet consultaEstadisticasJugadoresBD(BaseDatos accesoBD, String consulta) {
        ResultSet retset;
        retset = accesoBD.ejecutaConsulta(consulta);

        return retset;
    }
     
     /*
      * @param
      * @param
      * @version
      */
     
    public static boolean modificarEstadisticasJugadoresBD(BaseDatos accesoBD, int DATOSENTRADA)
    {
        return true;
    }
    
    /*
     * @param
     * @param
     * @version
     */

    public static void eliminarEstadisticasJugadoresBD(BaseDatos accesoBD, EstadisticasJugadores nuevasEstadisticas) {
        
    }
    
    /*
     * @param
     * @param
     * @version
     */
    
    public static boolean insertarEstadisticasPartidoBD (BaseDatos accesoBD, EstadisticasPartido nuevasEstadisticasPartido){
        return true;
    }
    
    /*
     * @param
     * @param
     * @version
     */
    
    public static boolean modificarEstadisticasPartidoBD (BaseDatos accesoBD, EstadisticasPartido nuevasEstadisticasPartido){
        return true;
    }
    
    /*
     * @param
     * @param
     * @version
     */
    
    public static boolean consultaEstadisticasPartidoBD (BaseDatos accesoBD, EstadisticasPartido nuevasEstadisticasPartido){
        return true;
    }
    
    /*
     * @param
     * @param
     * @version
     */
    
    public static boolean eliminarEstadisticasPartidoBD (BaseDatos accesoBD, EstadisticasPartido nuevasEstadisticasPartido){
        return true;
    }
    
}
