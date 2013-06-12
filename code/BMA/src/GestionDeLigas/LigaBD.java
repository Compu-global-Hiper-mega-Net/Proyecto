/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionDeLigas;

import ServiciosAlmacenamiento.BaseDatos;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
 *
 * @author Julio
 */
public class LigaBD {
    
    /*static boolean consultarLiga (int idCatLig, int idTempLig, String nombre){
        boolean validar;
        
        int auxCurso = curso+1;
        String temp = Integer.toString(curso)+"/"+Integer.toString(auxCurso);
        
        String query = "SELECT * FROM Temporada WHERE curso='"+temp+"'";
        ResultSet res = accesoBD.ejecutaConsulta(query);
        
        if(res.next())
            validar = false;
        else
            validar = true;
        
        return validar;
    }*/
    
    /**
     * 
     * @param accesoBD
     * @param l
     * @return
     * @throws SQLException 
     */
    static int insertarLigaBD (BaseDatos accesoBD, Liga l) throws SQLException{
        String query = "INSERT INTO Liga (Categoria_idCategoria, Temporada_idTemporada, nombre) "
                + "VALUES ('"+l.getIdCategoriaLiga()+"','"+l.getIdTemporadaLiga()+"','"+l.getNombre()+"')";
        int correcto = accesoBD.ejecutaActualizacion(query);
        return correcto;
    }
    
    /**
     * 
     * @param accesoBD
     * @return
     * @throws SQLException 
     */
    static List<List<String>> getListaLigas (BaseDatos accesoBD) throws SQLException{
        String query = "SELECT Categoria_idCategoria, Temporada_idTemporada, nombre FROM Liga";
        ResultSet res = accesoBD.ejecutaConsulta(query);
        
        List<List<String>> ligas = new ArrayList<List<String>>();

        List<String> aux;

        while (res.next()) {
            aux = new ArrayList<String>();
            aux.add(res.getString(1) + "," + res.getString(2) + "," + res.getString(3));
            ligas.add(aux);
        }

        return ligas;
    }
    
    /**
     * 
     * @param accesoBD
     * @param nomb
     * @param idCatLig
     * @param idTempLig
     * @param idLiga
     * @return 
     */
    static boolean modificarLigaBD (BaseDatos accesoBD, String nomb, int idCatLig, int idTempLig, int idLiga){
        boolean exito = true;
        String actualizacion = "UPDATE Liga SET"
                + " Categoria_idCategoria= '" + idCatLig + "',"
                + " Temporada_idTemporada= '" + idTempLig + "',"
                + " nombre= '" + nomb + "'"
                + " WHERE idLiga= " + idLiga;

        try {
            accesoBD.ejecutaActualizacion(actualizacion);
        } catch (SQLException ex) {
            exito = false;
        }
        
        return exito;
    }
    
    /**
     * 
     * @param accesoBD
     * @param l
     * @throws SQLException 
     */
    public static void eliminarLigaBD (BaseDatos accesoBD, Liga l) throws SQLException{
        int idLiga = getIdLiga(accesoBD, l.getNombre(), l.getIdCategoriaLiga(), l.getIdTemporadaLiga());

        String delete = "DELETE FROM Liga WHERE idLiga = "
                + idLiga;

        boolean exito = accesoBD.eliminar(delete);
        if (!exito) {
            JOptionPane.showMessageDialog(null, "Ha habido un error en la base de datos",
                    "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Liga Eliminada con éxito",
                    "Confirmacion", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    /**
     * 
     * @param accesoBD
     * @param nom
     * @param idCatLig
     * @param idTempLig
     * @return
     * @throws SQLException 
     */
    static int getIdLiga (BaseDatos accesoBD, String nom, int idCatLig, int idTempLig) throws SQLException{
        String query = "SELECT idLiga FROM Liga WHERE "
                + "Categoria_idCategoria='" + idCatLig + "'"
                + " AND Temporada_idTemporada='" + idTempLig + "'"
                + " AND nombre= '" + nom + "'";

        ResultSet res = accesoBD.ejecutaConsulta(query);

        int idLig = 0;
        if (res.next()) {
            idLig = res.getInt(1);
        }

        return idLig;
    }
    
    /**
     * 
     * @param accesoBD
     * @param s
     * @return
     * @throws SQLException 
     */
    static String getLiga (BaseDatos accesoBD, String s) throws SQLException{        
        String nombre = null;
        String query = "SELECT nombre FROM Liga WHERE idLiga = "+s;
        ResultSet res = accesoBD.ejecutaConsulta(query);
        if(res.next()){
            nombre = res.getString(1);
        }
        return nombre;
        
    }
}
