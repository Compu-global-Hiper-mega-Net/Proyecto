/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionDePagos;

import ServiciosAlmacenamiento.BaseDatos;
import java.sql.SQLException;
import java.util.List;
import java.sql.*;

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
 * Clase gestor pagos que se encarga de mediar entre la clase objeto
 * de cuota precio con las demás empleadas.
 * @author Carlos, Francis
 */

public class GestorPagos {
    
    /**
     * Metodo consultor
     * @param accesoBD Parametro formal que contiene informacion para conectar
     * con la base de datos de nuestro sistema.
     * @param consulta Parametro formal de tipo String (cadena) que contiene
     * la query que vamos a realizar sobre nuestra base de datos.
     * @return ResultSet devuelve el objeto SQL que devuelve la consulta
     * sobre nuestra base de datos.
     */
    public static ResultSet consultarPago(BaseDatos accesoBD, String consulta){
        PagoBD pago=new PagoBD();
        
        return pago.consultaPagoBD(accesoBD, consulta);
    }
    
    /**
     * Metodo consultor 
     * @param accesoBD Parametro formal que contiene informacion para conectar
     * con la base de datos de nuestro sistema.
     * @param idAlumno Parametro formal de tipo int (entero) que contiene
     * el identificador del alumno.
     * @param idTemporada Parametro formal de tipo int (entero) que contiene
     * el identificador del alumno.
     * @return boolean devuelve un valor booleano true o false dependiendo de si
     * ha tenido éxito o no en la consulta.
     */
    public static boolean compruebaSiAlumnoEraSocioEnEsaTemporada(BaseDatos accesoBD, int idAlumno, int idTemporada){
        PagoBD pago=new PagoBD();
        
        return pago.compruebaSiAlumnoEraSocioEnEsaTemporada(accesoBD, idAlumno, idTemporada);
        
    }
    
    /**
     * Metodo modificador
     * @param accesoBD Parametro formal que contiene informacion para conectar
     * con la base de datos de nuestro sistema.
     * @param idCuota Parametro formal de tipo int (entero) que contiene
     * el identificador de la cuota.
     * @param pagado Parametro formal de tipo boolean (booleano) que contiene
     * el valor de pagado (true) o no pagado (false).
     */
    public static void modificarCuota(BaseDatos accesoBD, int idCuota, boolean pagado){
        PagoBD pago=new PagoBD();
        
        pago.modificarCuotaBD(accesoBD, idCuota, pagado);
        
    }

    /**
     * Metodo consultor
     * @param accesoBD Parametro formal que contiene informacion para conectar
     * con la base de datos de nuestro sistema.
     * @param idAl Parametro formal de tipo int (entero) que contiene
     * el identificador del alumno.
     * @param idTemp Parametro formal de tipo int (entero) que contiene
     * el identificador de la temporada.
     * @return List<Integer> devuelve un tipo Abstracto List (Lista) de tipos
     * Integer (entero) con los id de las cuotas almacenadas en nuestro sistema.
     * @throws SQLException Se lanzara dicha excepción cuando encuentre un error
     * al realizar una operación sobre la base de datos relacional.
     */
    public static List<Integer> getIdCuotas(BaseDatos accesoBD, int idAl, int idTemp) throws SQLException {
        return PagoBD.getIdCuotas(accesoBD, idAl, idTemp);
    }
}
