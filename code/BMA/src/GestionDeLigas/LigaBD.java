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
    
    static int insertarLigaBD (BaseDatos accesoBD, Liga l) throws SQLException{
        String query = "INSERT INTO Liga (Categoria_idCategoria, Temporada_idTemporada, nombre) "
                + "VALUES ('"+l.getIdCategoriaLiga()+"','"+l.getIdTemporadaLiga()+"','"+l.getNombre()+"')";
        int correcto = accesoBD.ejecutaActualizacion(query);
        return correcto;
    }
    
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
