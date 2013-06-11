
package GestionDePagos;

import ServiciosAlmacenamiento.BaseDatos;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
 * Clase Pago que contiene los metodos o controladores con la base de datos
 * de nuestro sistema, en concreto para los pagos del mismo.
 * @author Carlos, Francis
 */
public class PagoBD {

    /**
     * Metodo consultor
     * @param accesoBD Parametro formal de tipo BaseDatos que contiene la 
     * información necesaria para realizar la conexión con nuestra
     * base de datos.
     * @param idAl Parametro formal de tipo int (entero) que contiene 
     * el identificador de un alumno.
     * @param idTemp Parametro formal de tipo int (entero) que contiene
     * el identificador de una temporada.
     * @return List<Integer> devuelve un tipo Abstracto List de Integer (enteros)
     * que contiene un listado de identificadores de cuotas.
     * @throws SQLException excepción que se lanzará cuando ocurra un error
     * dentro de la consulta SQL en nuestra base de datos.
     */
    public static List<Integer> getIdCuotas(BaseDatos accesoBD, int idAl, int idTemp) throws SQLException {
        List<Integer> idCuotas = new ArrayList<>();
        
        String query = "SELECT Cuota.idCuota FROM Cuota, PagoTemporada WHERE "
                + "Cuota.idCuota=PagoTemporada.Cuota_idCuota AND "
                + "PagoTemporada.AlumnoTemporada_Alumno_idAlumno='"+idAl+"' AND "
                + "PagoTemporada.AlumnoTemporada_Temporada_idTemporada='"+idTemp+"'";
        ResultSet res = accesoBD.ejecutaConsulta(query);
        
        while(res.next())
            idCuotas.add(res.getInt(1));
        
        return idCuotas;
    }
    
    /**
     * Metodo consultor
     * @param accesoBD Parametro formal de tipo BaseDatos que contiene la 
     * información necesaria para realizar la conexión con nuestra
     * base de datos.
     * @param consulta Parametro formal de tipo String (cadena) que contiene
     * la query que se va a realizar sobre nuestra base de datos.
     * @return ResultSet devuelve un conjunto de tipo ResulSet, objeto que
     * se obtiene de la consulta realizada sobre nuestra base de datos.
     */
    public ResultSet consultaPagoBD(BaseDatos accesoBD, String consulta){
        ResultSet retset;
        retset = accesoBD.ejecutaConsulta(consulta);

        return retset;
    }
    
    /**
     * Metodo consultor
     * @param accesoBD Parametro formal de tipo BaseDatos que contiene la 
     * información necesaria para realizar la conexión con nuestra
     * base de datos.
     * @param idAlumno Parametro formal de tipo int (entero) que contiene 
     * el identificador de un alumno.
     * @param idTemporada Parametro formal de tipo int (entero) que contiene 
     * el identificador de una temporada.
     * @return boolean devuelve un tipo boolean (booleano) que servirá para
     * comprobar si se ha realizado con éxito (true) o no (false) nuestra
     * consulta sobre la base de datos.
     */
    public boolean compruebaSiAlumnoEraSocioEnEsaTemporada(BaseDatos accesoBD, int idAlumno, int idTemporada){
        ResultSet retset;
        String consulta;
        consulta = "SELECT * FROM temporada, alumno, alumnotemporada altemp WHERE temporada.idTemporada="+idTemporada+" AND alumno.idAlumno="+idAlumno+
           " AND temporada.idTemporada=altemp.temporada_idTemporada AND altemp.alumno_idAlumno=alumno.idAlumno ";
        System.out.print("\nComprueba "+consulta);
        retset = accesoBD.ejecutaConsulta(consulta);
        try{
            if(retset.next()){
                return true;
            }else{
                return false;
            }
        }catch (SQLException ex) {
            System.out.print(ex.getMessage());
            return false;
        }
    }
    
    /**
     * Metodo modificador
     * @param accesoBD Parametro formal de tipo BaseDatos que contiene la 
     * información necesaria para realizar la conexión con nuestra
     * base de datos.
     * @param idCuota Parametro formal de tipo int (entero) que contiene 
     * el identificador de una cuota.
     * @param pagado Parametro formal de tipo boolean (booleano) que contiene
     * la información de si se ha pagado la cuota (true) o no (false).
     */
    void modificarCuotaBD(BaseDatos accesoBD, int idCuota, boolean pagado){
        String actualizacion;
        String pagadoString;
        if(pagado){
            pagadoString="true";
        }else{
            pagadoString="false";
        }
        actualizacion="\nupdate cuota set cuota.pagado="+pagadoString+" where cuota.idCuota="+idCuota;
        System.out.print("la act "+actualizacion);
        try{
            accesoBD.ejecutaActualizacion(actualizacion);
        }catch (SQLException ex) {
            System.out.print(ex.getMessage());
        }
    }  
}
