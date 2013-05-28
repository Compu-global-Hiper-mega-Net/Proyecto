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
}
