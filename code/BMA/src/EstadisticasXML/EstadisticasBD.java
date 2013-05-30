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
public class EstadisticasBD {
    
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
