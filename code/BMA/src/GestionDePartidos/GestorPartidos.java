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
    
   public static boolean darAltaPartido(BaseDatos accesoBD, Date fecha,
            Date hora, int resultadoLocal, int resultadoVisitante) {

        boolean exito = true;
        Partido instalacion = new Partido(fecha, hora, resultadoLocal, resultadoVisitante);

        try {
            PartidoBD.insertarPartido(accesoBD, instalacion);
        } catch (SQLException ex) {
            exito = false;
        }


        return exito;
    }
   
    public static ResultSet consultaPartido(BaseDatos accesoBD, String consulta) {
        PartidoBD partido = new PartidoBD();

        return partido.consultaPartidoBD(accesoBD, consulta);
    }
    
    public static boolean modificaPartido(BaseDatos accesoBD,int idPartido, 
            Date fecha, Date hora, int resultadoLocal, int resultadoVisitante) {

        return PartidoBD.modificarDatosPartidoBD(accesoBD, idPartido, fecha, 
                hora, resultadoLocal, resultadoVisitante);
    }
        
    public static void eliminaPartido(BaseDatos accesoBD, Date fecha, Date hora,
            int resultadoLocal, int resultadoVisitante){
        
        PartidoBD partBD = new PartidoBD();
        
        Partido partidoEliminar = Partido.crearPartido(fecha, hora,
            resultadoLocal, resultadoVisitante);
        
        partBD.eliminarPartidoBD(accesoBD, partidoEliminar);
        
    }
    
    public static int getIdPartido(BaseDatos accesoBD, Date fecha, Date hora) throws SQLException {
        return PartidoBD.getIdPartido(accesoBD, fecha, hora);
    }

    public static List<Date> getListaPartidos(BaseDatos accesoBD) throws SQLException {
        return PartidoBD.getListaPartidos(accesoBD);
    }
    
}
