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
 *
 * @author Julio
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
   
    public static ResultSet consultaPartido(BaseDatos accesoBD, String consulta) {
        PartidoBD partido = new PartidoBD();

        return partido.consultaPartidoBD(accesoBD, consulta);
    }
    
    public static boolean modificaPartido(BaseDatos accesoBD, int idEquipoLocal, int idEquipoLocalFundacion,
           int idEquipoLocalCategoria, int idEquipoLocalTemporada, int idEquipoLocalLiga, int idEquipoVisitante,
           int idEquipoVisitanteFundacion, int idEquipoVisitanteCategoria, int idEquipoVisitanteTemporada, 
           int idEquipoVisitanteLiga, Date fecha, Time hora, int idPartido) {

        return PartidoBD.modificarDatosPartidoBD(accesoBD, idEquipoLocal, idEquipoLocalFundacion,idEquipoLocalCategoria,
                idEquipoLocalTemporada, idEquipoLocalLiga, idEquipoVisitante,idEquipoVisitanteFundacion, idEquipoVisitanteCategoria,
                idEquipoVisitanteTemporada, idEquipoVisitanteLiga, fecha, hora, idPartido);
    }
        
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
    
    public static int getIdPartido(BaseDatos accesoBD, String fecha, String hora, int equipoLocal, int equipoVisitante) throws SQLException {
        return PartidoBD.getIdPartido(accesoBD, fecha, hora, equipoLocal, equipoVisitante);
    }

    public static List<List<String>> getListaPartidos(BaseDatos accesoBD) throws SQLException {
        return PartidoBD.getListaPartidos(accesoBD);
    }
    
    public static List<List<String>> getListaPartidosFiltro(BaseDatos accesoBD, String fecha, String temporada, String categoria, String equipoLoc, String equipoVis) throws SQLException{
        return PartidoBD.getListaPartidosFiltro(accesoBD, fecha, temporada, categoria, equipoLoc, equipoVis);
    }
    
}
