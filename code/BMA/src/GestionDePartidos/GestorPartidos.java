/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionDePartidos;

import ServiciosAlmacenamiento.BaseDatos;
import java.sql.*;
import java.util.Date;
import java.util.List;

/**
 * Clase encargada de la gestión de los partidos
 * @author Julio Ros Martínez
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
public class GestorPartidos {

		/* Método para insertar un partido
		 * @param accesoBD, acceso a la base de datos.
		 * @param idEquipoLocal, id del equipo local.
                 * @param idEquipoLocalFundacion, id de la fundación a la que pertenece el equipo local
                 * @param idEquipoLocalCategoria, id de la categoría a la que pertenece el equipo local
                 * @param idEquipoLocalTemporada, id de la temporada a la que pertenece el equipo local
                 * @param idEquipoLocalLiga, id de la liga a la que pertenece el equipo local
		 * @param idEquipoVisitante, id del equipo visitante.
                 * @param idEquipoVisitanteFundacion, id de la fundación a la que pertenece el equipo Visitante
                 * @param idEquipoVisitanteCategoria, id de la categoría a la que pertenece el equipo Visitante
                 * @param idEquipoVisitanteTemporada, id de la temporada a la que pertenece el equipo Visitante
                 * @param idEquipoVisitanteLiga, id de la liga a la que pertenece el equipo visitante
                 * @param fecha, la fecha del partido
                 * @param hora, la hora del partido
                 * @param idPart, id del partido a introducir
		 * @throws SQLExcepción, algun tipo de error en la base de datos.
		 * @return boolean (valor lógico) que indica si la inserción se ha realizado correctamente o no.
		 */ 
    
   public static boolean introducirPartido(BaseDatos accesoBD, int idEquipoLocal, int idEquipoLocalFundacion,
           int idEquipoLocalCategoria, int idEquipoLocalTemporada, int idEquipoLocalLiga, int idEquipoVisitante,
           int idEquipoVisitanteFundacion, int idEquipoVisitanteCategoria, int idEquipoVisitanteTemporada, 
           int idEquipoVisitanteLiga, Date fecha, Time hora, int resultadoLocal, int resultadoVisitante) {

        boolean exito = true;
        Partido part = new Partido(idEquipoLocal, idEquipoLocalFundacion,
           idEquipoLocalCategoria, idEquipoLocalTemporada, idEquipoLocalLiga, idEquipoVisitante,
           idEquipoVisitanteFundacion, idEquipoVisitanteCategoria, idEquipoVisitanteTemporada, 
           idEquipoVisitanteLiga, fecha, hora, resultadoLocal, resultadoVisitante);

        try {
            PartidoBD.insertarPartido(accesoBD, part);
        } catch (SQLException ex) {
            exito = false;
        }


        return exito;
    }

		/* Funcion para consultar un partido
		 * @param accesoBD, acceso a la base de datos.
		 * @param consulta, la consulta a realizar.
		 * @throws SQLExcepción, algun tipo de error en la base de datos.
		 * @return ResultSet (java.sql.ResultSet) con el atributo interno de la consulta del partido.
		 */ 
   
    public static ResultSet consultaPartido(BaseDatos accesoBD, String consulta) {
        PartidoBD partido = new PartidoBD();

        return partido.consultaPartidoBD(accesoBD, consulta);
    }

		/* Funcion para modificar los datos de un partido
		 * @param accesoBD, acceso a la base de datos.
		 * @param idEquipoLocal, id del equipo local.
                 * @param idEquipoLocalFundacion, id de la fundación a la que pertenece el equipo local
                 * @param idEquipoLocalCategoria, id de la categoría a la que pertenece el equipo local
                 * @param idEquipoLocalTemporada, id de la temporada a la que pertenece el equipo local
                 * @param idEquipoLocalLiga, id de la liga a la que pertenece el equipo local
		 * @param idEquipoVisitante, id del equipo visitante.
                 * @param idEquipoVisitanteFundacion, id de la fundación a la que pertenece el equipo Visitante
                 * @param idEquipoVisitanteCategoria, id de la categoría a la que pertenece el equipo Visitante
                 * @param idEquipoVisitanteTemporada, id de la temporada a la que pertenece el equipo Visitante
                 * @param idEquipoVisitanteLiga, id de la liga a la que pertenece el equipo visitante
                 * @param fecha, la fecha del partido
                 * @param hora, la hora del partido
                 * @param idPart, id del partido a modificar
		 * @throws SQLExcepción, algun tipo de error en la base de datos.
		 * @return boolean (valor lógico) que indica si la modificación se ha realizado correctamente o no.
		 */
    
    public static boolean modificaPartido(BaseDatos accesoBD, int idEquipoLocal, int idEquipoLocalFundacion,
           int idEquipoLocalCategoria, int idEquipoLocalTemporada, int idEquipoLocalLiga, int idEquipoVisitante,
           int idEquipoVisitanteFundacion, int idEquipoVisitanteCategoria, int idEquipoVisitanteTemporada, 
           int idEquipoVisitanteLiga, Date fecha, Time hora, int idPartido) {

        return PartidoBD.modificarDatosPartidoBD(accesoBD, idEquipoLocal, idEquipoLocalFundacion,idEquipoLocalCategoria,
                idEquipoLocalTemporada, idEquipoLocalLiga, idEquipoVisitante,idEquipoVisitanteFundacion, idEquipoVisitanteCategoria,
                idEquipoVisitanteTemporada, idEquipoVisitanteLiga, fecha, hora, idPartido);
    }

		/* Procedimiento para eliminar un partido
		 * @param accesoBD, acceso a la base de datos.
		 * @param nuevoPartido, el partido a eliminar.
		 * @throws SQLExcepción, algun tipo de error en la base de datos.
		 */ 
        
    public static void eliminaPartido(BaseDatos accesoBD, int idEquipoLocal, int idEquipoLocalFundacion,
           int idEquipoLocalCategoria, int idEquipoLocalTemporada, int idEquipoLocalLiga, int idEquipoVisitante,
           int idEquipoVisitanteFundacion, int idEquipoVisitanteCategoria, int idEquipoVisitanteTemporada, 
           int idEquipoVisitanteLiga, Date fecha, Time hora, int resultadoLocal, int resultadoVisitante) throws SQLException{
        
        
        Partido partidoEliminar = new Partido(idEquipoLocal, idEquipoLocalFundacion,
           idEquipoLocalCategoria, idEquipoLocalTemporada, idEquipoLocalLiga, idEquipoVisitante,
           idEquipoVisitanteFundacion, idEquipoVisitanteCategoria, idEquipoVisitanteTemporada, 
           idEquipoVisitanteLiga, fecha, hora, resultadoLocal, resultadoVisitante);
        
        PartidoBD.eliminarPartidoBD(accesoBD, partidoEliminar);
        
    }
    
                /*
		 * Funcion para obtener el id de un partido
		 * @param accesoBD, acceso a la base de datos.
                 * @param fch, fecha del partido
                 * @param hr, hora del partido
                 * @param eqL, id del equipo local
                 * @param eqV, id del equipo Visitante
		 * @throws SQLExcepción, algun tipo de error en la base de datos.
                 * @return int (entero) con el atributo interno del id de un partido
		 */    
    
    public static int getIdPartido(BaseDatos accesoBD, String fecha, String hora, int equipoLocal, int equipoVisitante) throws SQLException {
        return PartidoBD.getIdPartido(accesoBD, fecha, hora, equipoLocal, equipoVisitante);
    }
                /*
		 * Funcion para obtener una lista de partidos
                 * @param accesoBD, acceso a la base de datos
		 * @throws SQLExcepción, algun tipo de error en la base de datos.
                 * @return List<List<String>> (Lista de lista de cadenas) con los datos de los partidos almacenados en la base de datos
		 */

    public static List<List<String>> getListaPartidos(BaseDatos accesoBD) throws SQLException {
        return PartidoBD.getListaPartidos(accesoBD);
    }
                /*
		 * Funcion para obtener una lista de partidos a través de una serie de atributos dados
                 * @param accesoBD, acceso a la base de datos.
                 * @param fecha, la fecha del partido
                 * @param temporada, temporada en la que se juega ese partido
                 * @param categoria, categoría en la que se juega ese partido
                 * @param equipoLoc, id del equipo local
                 * @param equipoVis, id del equipo visitante
		 * @throws SQLExcepción, algun tipo de error en la base de datos.
                 * @return List<List<String>> (Lista de lista de cadenas) con los datos de los partidos almacenados en la base de datos que cumplen con los atributos
		 */
    
    public static List<List<String>> getListaPartidosFiltro(BaseDatos accesoBD, String fecha, String temporada, String categoria, String equipoLoc, String equipoVis) throws SQLException{
        return PartidoBD.getListaPartidosFiltro(accesoBD, fecha, temporada, categoria, equipoLoc, equipoVis);
    }
    
}
