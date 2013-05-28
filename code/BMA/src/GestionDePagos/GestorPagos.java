/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionDePagos;

import GestionDeInstalaciones.Instalacion;
import ServiciosAlmacenamiento.BaseDatos;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author David
 */
public class GestorPagos {
    
    public static ResultSet consultarPago(BaseDatos accesoBD, String consulta){
        PagoBD pago=new PagoBD();
        
        return pago.consultaPagoBD(accesoBD, consulta);
    }
    public static boolean compruebaSiAlumnoEraSocioEnEsaTemporada(BaseDatos accesoBD, int idAlumno, int idTemporada){
        PagoBD pago=new PagoBD();
        
        return pago.compruebaSiAlumnoEraSocioEnEsaTemporada(accesoBD, idAlumno, idTemporada);
        
    }
    public static void modificarCuota(BaseDatos accesoBD, int idCuota, boolean pagado){
        PagoBD pago=new PagoBD();
        
        pago.modificarCuotaBD(accesoBD, idCuota, pagado);
        
    }
}
