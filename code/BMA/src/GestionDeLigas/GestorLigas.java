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
    /**
     * 
     * @param accesoBD
     * @param idCatLig
     * @param idTempLig
     * @param nomb
     * @return 
     */
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
    /**
     * 
     * @param accesoBD
     * @param idCatLig
     * @param idTempLig
     * @param nomb
     * @param idLig
     * @return 
     */
    public static boolean modificaLiga(BaseDatos accesoBD, int idCatLig, int idTempLig, String nomb, int idLig) {

        return LigaBD.modificarLigaBD(accesoBD, nomb, idCatLig, idTempLig, idLig);
    }
    /**
     * 
     * @param accesoBD
     * @param idCatLig
     * @param idTempLig
     * @param nomb
     * @throws SQLException 
     */
    public static void eliminaLiga(BaseDatos accesoBD, int idCatLig, int idTempLig, String nomb) throws SQLException {

        Liga ligaEliminar = new Liga(nomb, idCatLig, idTempLig);

        LigaBD.eliminarLigaBD(accesoBD, ligaEliminar);
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
    public static int getIdLiga(BaseDatos accesoBD, String nom, int idCatLig, int idTempLig) throws SQLException {
        return LigaBD.getIdLiga(accesoBD, nom, idCatLig, idTempLig);
    }

    /**
     * 
     * @param accesoBD
     * @return
     * @throws SQLException 
     */
    public static List<List<String>> getListaLigas(BaseDatos accesoBD) throws SQLException {
        return LigaBD.getListaLigas(accesoBD);
    }
    /**
     * 
     * @param accesoBD
     * @param s
     * @return
     * @throws SQLException 
     */
    public static String getLiga (BaseDatos accesoBD, String s) throws SQLException{
        return LigaBD.getLiga(accesoBD, s);
    }
    
}
