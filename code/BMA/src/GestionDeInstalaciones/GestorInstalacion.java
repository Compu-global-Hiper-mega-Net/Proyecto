/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionDeInstalaciones;

import ServiciosAlmacenamiento.BaseDatos;
import java.sql.*;
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
 * Clase que permite realizar la gestión de una instalación
 *
 * @author Jesus Manuel Contreras Siles
 * @version 1.0
 */
public class GestorInstalacion {

    /** 
     * Metodo para la inserción de una instalación.
     * @param accesoBD BaseDatos (BaseDatos) con el acceso a la base de datos.
     * @param nombre String (cadena) con el nombre de una instalación.
     * @param capacidad int (entero) con la capacidad de una instalación.
     * @param localizacion String (cadena) con la dirección de una instalación.
     * @return boolean (lógico) con el atributo interno de la comprobación si se ha insertado con exito o no.
     */
    public static boolean darAltaInstalacion(BaseDatos accesoBD, String nombre,
            int capacidad, String localizacion) {

        boolean exito = true;
        Instalacion instalacion = new Instalacion(nombre, capacidad, localizacion);

        try {
            AccesoBDInstalacion.insertarInstalacionBD(accesoBD, instalacion);
        } catch (SQLException ex) {
            exito = false;
        }


        return exito;
    }

    /** 
     * Metodo para la consulta de una instalación.
     * @param accesoBD BaseDatos (BaseDatos) acceso a la base de datos.
     * @param consulta String (cadena) con la consulta a realizar.
     * @return ResultSet (java.sql.ResultSet) con el resultado de la consulta.
     */
    public static ResultSet consultaInstalacion(BaseDatos accesoBD, String consulta) {
        AccesoBDInstalacion instalacion = new AccesoBDInstalacion();

        return instalacion.consultaInstalacionBD(accesoBD, consulta);
    }

    /** 
     * Metodo para modificar una instalación.
     * @param accesoBD BaseDatos (BaseDatos) con el acceso a la base de datos.
     * @param idInstalacion int (entero) con el id de la instalación.
     * @param nombre String (cadena) con el nombre de una instalación.
     * @param capacidad int (entero) con la capacidad de la instalación.
     * @param localizacion String (cadena) con la dirección de la instalación.
     * @return boolean (lógico) con el atributo interno de la comprobación de si se ha modificado con éxito o no.
     */
    public static boolean modificaInstalacion(BaseDatos accesoBD, int idInstalacion, String nombre,
            String capacidad, String locacizacion) {

        return AccesoBDInstalacion.modificarDatosInstalacionBD(accesoBD, idInstalacion,
                nombre, capacidad, locacizacion);
    }

    /** 
     * Metodo para eliminar una instalación.
     * @param accesoBD BaseDatos (BaseDatos) con el acceso a la base de datos.
     * @param nombre String (cadena) con el nombre de la instalación.
     * @param capacidad int (entero) con la capacidad de la instalación.
     * @param localizacion String (cadena) con la dirección de la instalación.
     */
    public static void eliminaInstalacion(BaseDatos accesoBD, String nombre,
            int capacidad, String locacizacion) {

        AccesoBDInstalacion instalacionBD = new AccesoBDInstalacion();

        Instalacion instalacionEliminada = Instalacion.crearInstalacion(nombre, capacidad, locacizacion);

        instalacionBD.eliminarInstalacionBD(accesoBD, instalacionEliminada);

    }

    /** 
     * Metodo consultor, devuelve el id de una instalación
     * @param accesoBD BaseDatos (BaseDatos) con el acceso a la base de datos.
     * @param inst String (cadena) con el nombre de la instalación.
     * @throws SQLException algun tipo de error en la base de datos.
     * @return int (entero) con el atributo interno del id de la instalación.
     */
    public static int getIdInstalacion(BaseDatos accesoBD, String inst) throws SQLException {
        return AccesoBDInstalacion.getIdInstalacion(accesoBD, inst);
    }

    /** 
     * Metodo consultor, devuelve una lista con el nombre de todas las instalaciones.
     * @param accesoBD BaseDatos (BaseDatos) con el acceso a la base de datos.
     * @throws SQLException algun tipo de error en la base de datos.
     * @return List<String> (lista) atributo interno con el nombre de todas las instalaciones.
     */
    public static List<String> getListaInstalaciones(BaseDatos accesoBD) throws SQLException {
        return AccesoBDInstalacion.getListaInstalaciones(accesoBD);
    }
}
