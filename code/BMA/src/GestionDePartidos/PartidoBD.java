/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionDePartidos;

import ServiciosAlmacenamiento.BaseDatos;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
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
public class PartidoBD {
    
    public static void insertarPartido(BaseDatos accesoBD, Partido nuevoPartido) throws SQLException {
        
        String insercion = "INSERT INTO partido (idEquipo, equipo_Fundacion_idFundacion, equipo_Categoria_idCategoria, "
                + "equipo_Temporada_idTemporada, equipo_liga_idLiga, idEquipoVisitante, equipo_Fundacion_idFundacion1, "
                + "equipo_Categoria_idCategoria1, equipo_Temporada_idTemporada1, equipo_liga_idLiga1, fecha, hora, "
                + "resultadoLocal, resultadoVisitante) VALUES (";
        insercion = insercion + nuevoPartido.getIdEquipoLocal() + ", "
                + nuevoPartido.getIdEquipoLocalFundacion() + ", "
                + nuevoPartido.getIdEquipoLocalCategoria() + ", "
                + nuevoPartido.getIdEquipoLocalTemporada() + ", "
                + nuevoPartido.getIdEquipoLocalLiga() + ", "
                + nuevoPartido.getIdEquipoVisitante() + ", "
                + nuevoPartido.getIdEquipoVisitanteFundacion() + ", "
                + nuevoPartido.getIdEquipoVisitanteCategoria() + ", "
                + nuevoPartido.getIdEquipoVisitanteTemporada() + ", "
                + nuevoPartido.getIdEquipoVisitanteLiga() + ", \""
                + nuevoPartido.getFecha() + "\", \""
                + nuevoPartido.getHora() + "\", "
                + nuevoPartido.getResultadoLocal() + ", "
                + nuevoPartido.getResultadoVisitante() + ");";
        
        System.out.print("\n inser " + insercion);
        accesoBD.ejecutaActualizacion(insercion);
    }
    
    
    static int getIdPartido(BaseDatos accesoBD, Date fch, Time hr) throws SQLException {
        String query = "SELECT idPartido FROM Partido WHERE "
                + "fecha='" + fch + "'"
                + " AND hora='"+ hr + "'";
        
        ResultSet res = accesoBD.ejecutaConsulta(query);
       
        int idPart = 0;
        if (res.next()) {
            idPart = res.getInt(1);
        }
        
        return idPart;
    }
    
    
    static List<Date> getListaPartidos(BaseDatos accesoBD) throws SQLException { //DUDAS EVERYWHERE
        List<Date> part = new ArrayList<Date>();
        String query = "SELECT fecha, hora FROM Partido";
        ResultSet res = accesoBD.ejecutaConsulta(query);

        while (res.next()) {
            part.add(res.getDate(1));
            part.add(res.getDate(2));
        }

        return part;
    }
    
    public ResultSet consultaPartidoBD(BaseDatos accesoBD, String consulta) {
        ResultSet retset;
        retset = accesoBD.ejecutaConsulta(consulta);

        return retset;
    }
       
    public static boolean modificarDatosPartidoBD(BaseDatos accesoBD, int idPartido,
            Date fecha, Time hora, int resultadoLocal, int resultadoVisitante) {

        boolean exito = true;
        String actualizacion = "UPDATE Partido SET ";

        if (fecha != null) {
            actualizacion = actualizacion + "fecha = \"" + fecha + "\" , ";
        }
        if (hora != null) {
            actualizacion = actualizacion + "hora = " + hora + " , ";
        }
        if (resultadoLocal != 0) {
            actualizacion = actualizacion + "resultadoLocal = \"" + resultadoLocal + "\" , ";
        }
        if (resultadoVisitante != 0) {
            actualizacion = actualizacion + "resultadoVisitante = \"" + resultadoVisitante + "\" , ";
        }

        actualizacion = actualizacion.substring(0, actualizacion.length() - 2);
        actualizacion = actualizacion + " WHERE idPartido= " + idPartido;

        try {
            accesoBD.ejecutaActualizacion(actualizacion);
            System.out.print("\nModificado act\n " + actualizacion);
        } catch (SQLException ex) {
            exito = false;
        }

        return exito;
    }

    public static void eliminarPartidoBD(BaseDatos accesoBD, Partido nuevoPartido) {
        String selId = new String();

        selId = "SELECT i.idPartido FROM Partido i WHERE i.fecha= \""
                + nuevoPartido.getFecha()
                + "AND i.hora = '" + nuevoPartido.getHora() + "\");";

        System.out.println("Consulta eliminar " + selId);
        ResultSet retset;
        try {
            retset = accesoBD.ejecutaConsulta(selId);
            if (retset.next()) {
                nuevoPartido.setIdPartido(retset.getInt("idPartido"));
            }
        } catch (SQLException ex) {
            System.out.print(ex.getMessage());
        }

        String delete = "DELETE FROM Instalacion WHERE idInstalacion = "
                + nuevoPartido.getIdPartido();
        
            boolean exito = accesoBD.eliminar(delete);
            if (!exito) {
                JOptionPane.showMessageDialog(null, "Ha habido un error en la base de datos",
                        "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Instalacion Eliminada",
                        "Confirmacion", JOptionPane.INFORMATION_MESSAGE);
            }
        
    }
}
