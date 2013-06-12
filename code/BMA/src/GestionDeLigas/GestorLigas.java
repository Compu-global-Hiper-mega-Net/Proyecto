/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionDeLigas;

import ServiciosAlmacenamiento.BaseDatos;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Julio
 */
public class GestorLigas {
    public static boolean introducirLiga(BaseDatos accesoBD, int idCatLig, int idTempLig, String nomb) {

        boolean exito = true;
        Liga lig = new Liga(nomb, idCatLig, idTempLig);

        try {
            LigaBD.insertarLigaBD(accesoBD, lig);
        } catch (SQLException ex) {
            exito = false;
        }

        return exito;
    }
    public static boolean modificaLiga(BaseDatos accesoBD, int idCatLig, int idTempLig, String nomb, int idLig) {

        return LigaBD.modificarLigaBD(accesoBD, nomb, idCatLig, idTempLig, idLig);
    }
    public static void eliminaLiga(BaseDatos accesoBD, int idCatLig, int idTempLig, String nomb) throws SQLException {

        Liga ligaEliminar = new Liga(nomb, idCatLig, idTempLig);

        LigaBD.eliminarLigaBD(accesoBD, ligaEliminar);
    }
    
    public static int getIdLiga(BaseDatos accesoBD, String nom, int idCatLig, int idTempLig) throws SQLException {
        return LigaBD.getIdLiga(accesoBD, nom, idCatLig, idTempLig);
    }

    public static List<List<String>> getListaLigas(BaseDatos accesoBD) throws SQLException {
        return LigaBD.getListaLigas(accesoBD);
    }
    
    public static String getLiga (BaseDatos accesoBD, String s) throws SQLException{
        return LigaBD.getLiga(accesoBD, s);
    }
    
}
