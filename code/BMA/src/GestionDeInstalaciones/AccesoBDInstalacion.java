/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionDeInstalaciones;

import ServiciosAlmacenamiento.BaseDatos;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Clase que permite el paso de objetos de tipo java a objetos de tipo relacional en formato MySql.
 * @author Jesus Manuel Contreras Siles
 * @version 1.0
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


public class AccesoBDInstalacion {

		/* Atributos que contiene la tabla Instalación.
		 * - idInstalación
		 * - nombre
		 * - capacidadEquipos
		 * - localización
		 */

		/* Metodo para insertar una instalación en la base de datos
		 * @param accesoBD BaseDatos (BaseDatos) con el acceso a la base de datos.
		 * @param nuevaInstalacion Instalacion (instalacion) con la información de una instalación.
		 * @throws SQLExcepción algun tipo de error en la base de datos.
		 */

    public static void insertarInstalacionBD(BaseDatos accesoBD, Instalacion nuevaInstalacion) throws SQLException {

        String insercion = "INSERT INTO Instalacion (nombre, "
                + "capacidadEquipos, localizacion) VALUES (\"";

        insercion = insercion + nuevaInstalacion.getNombre() + "\","
                + nuevaInstalacion.getCapacidadEquipos() + ",\""
                + nuevaInstalacion.getLocalizacion() + "\");";

        accesoBD.ejecutaActualizacion(insercion);

    }

		/* Metodo consultor para consultar el id de una instalación
		 * @param accesoBD BaseDatos (BaseDatos) con el acceso de una base de datos.
		 * @param inst String (cadena) con el nombre de una instalación.
		 * @throws SQLExcepción algun tipo de error en la base de datos.
		 * @return int (entero) con el atributo interno del id de una instalación.
		 */

    static int getIdInstalacion(BaseDatos accesoBD, String inst) throws SQLException {
        String query = "SELECT idInstalacion FROM Instalacion WHERE "
                + "nombre='" + inst + "'";
        System.out.println("instalacion:"+inst);
        ResultSet res2 = accesoBD.ejecutaConsulta(query);
       
        int idInst = 0;
        if (res2.next()) {
            idInst = res2.getInt(1);
        }
        
        return idInst;
    }

		/* Metodo consultor el cual devuelve una lista con los nombres de todas las instalaciones.
		 * @param accesoBD BaseDatos (BaseDatos) con el acceso a la base de datos.
		 * @throws SQLExcepción algun tipo de error en la base de datos.
		 * @return List<String> (lista) con el atributo interno de los nombre de todas las intalaciones.
		 */

    static List<String> getListaInstalaciones(BaseDatos accesoBD) throws SQLException {
        List<String> inst = new ArrayList<String>();
        String query = "SELECT nombre, localizacion FROM Instalacion";
        ResultSet res = accesoBD.ejecutaConsulta(query);

        while (res.next()) {
            inst.add(res.getString(1) + "," + res.getString(2));
        }

        return inst;
    }
	

		/* Metodo consultor el cual devuelve el resutado de una consulta.
		 * @param accesoBD BaseDatos (BaseDatos) con el acceso a la base de datos.
		 * @param consulta String (cadena) con la consulta a realizar.
		 * @return ResultSet (java.sql.ResultSet) con el atributo interno del resultado de la consulta.
		 */

    public ResultSet consultaInstalacionBD(BaseDatos accesoBD, String consulta) {
        ResultSet retset;
        retset = accesoBD.ejecutaConsulta(consulta);

        return retset;
    }

		/* Metodo constructor el cual modifica los datos de una instalación en la base de datos.
		 * @param accesoBD BaseDatos (BaseDatos) con el acceso a la base de datos.
		 * @param idInstalación int (entero) con el id de la instalación.
		 * @param nombre String (cadena) con el nombre de una instalación.
		 * @param capacidad int (entero) con la capacidad de la instalación.
		 * @param localización String (cadena) con la dirección de la instalación.
		 * @return boolean (lógico) con el atributo interno de la comprobación de si se ha modificado con éxito o no.
		 */

    public static boolean modificarDatosInstalacionBD(BaseDatos accesoBD, int idInstalacion,
            String nombre, String capacidadEquipos, String localizacion) {

        boolean exito = true;
        String actualizacion = "UPDATE Instalacion SET ";

        if (nombre != null) {
            actualizacion = actualizacion + "nombre = \"" + nombre + "\" , ";
        }
        if (capacidadEquipos != null) {
            actualizacion = actualizacion + "capacidadEquipos = " + Integer.parseInt(capacidadEquipos) + " , ";
        }
        if (localizacion != null) {
            actualizacion = actualizacion + "localizacion = \"" + localizacion + "\" , ";
        }

        actualizacion = actualizacion.substring(0, actualizacion.length() - 2);
        actualizacion = actualizacion + " WHERE idInstalacion= " + idInstalacion;

        try {
            accesoBD.ejecutaActualizacion(actualizacion);
        } catch (SQLException ex) {
            exito = false;
        }

        return exito;
    }

		/* Metodo constructo el cual elimina una instalación de la base de datos.
		 * @param accesoBD BaseDatos (BaseDatos) con el acceso a la base de datos.
		 * @param nuevaInstalación Instalacion (instalacion) con la información de una instalación.
		 */

    public static void eliminarInstalacionBD(BaseDatos accesoBD, Instalacion nuevaInstalacion) {
        String selId = new String();

				//Consulta el id de la instalación a eliminar
        selId = "SELECT i.idInstalacion FROM Instalacion i WHERE i.nombre= \""
                + nuevaInstalacion.getNombre();
        if (nuevaInstalacion.getCapacidadEquipos() > 0) {
            selId = selId + "\" AND i.capacidadEquipos= " + nuevaInstalacion.getCapacidadEquipos()
                    + " ";
        }
        if (nuevaInstalacion.getLocalizacion() != null) {
            selId = selId + " AND i.localizacion= \"" + nuevaInstalacion.getLocalizacion()
                    + "\" ";
        }

        ResultSet retset;
        try {
            retset = accesoBD.ejecutaConsulta(selId);
            if (retset.next()) {
                nuevaInstalacion.setIdInstalacion(retset.getInt("idInstalacion"));
            }
        } catch (SQLException ex) {
            System.out.print(ex.getMessage());
        }

        String delete = "DELETE FROM Instalacion WHERE idInstalacion = "
                + nuevaInstalacion.getIdInstalacion();
        
            boolean exito = accesoBD.eliminar(delete);
						//Si ha habido algun error en la base de datos, lanza un panel de diálogo.
            if (!exito) {
                JOptionPane.showMessageDialog(null, "Ha habido un error en la base de datos",
                        "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Instalacion Eliminada",
                        "Confirmacion", JOptionPane.INFORMATION_MESSAGE);
            }
        
    }
}
