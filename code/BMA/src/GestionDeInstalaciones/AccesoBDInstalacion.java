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
 *
 * @author Jesus Manuel Contreras Siles
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

    public static void insertarInstalacionBD(BaseDatos accesoBD, Instalacion nuevaInstalacion) throws SQLException {

        String insercion = "INSERT INTO Instalacion (nombre, "
                + "capacidadEquipos, localizacion) VALUES (\"";

        insercion = insercion + nuevaInstalacion.getNombre() + "\","
                + nuevaInstalacion.getCapacidadEquipos() + ",\""
                + nuevaInstalacion.getLocalizacion() + "\");";

        System.out.print("\n inser " + insercion);
        accesoBD.ejecutaActualizacion(insercion);

    }

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

    static List<String> getListaInstalaciones(BaseDatos accesoBD) throws SQLException {
        List<String> inst = new ArrayList<String>();
        String query = "SELECT nombre, localizacion FROM Instalacion";
        ResultSet res = accesoBD.ejecutaConsulta(query);

        while (res.next()) {
            inst.add(res.getString(1) + "," + res.getString(2));
        }

        return inst;
    }

    public ResultSet consultaInstalacionBD(BaseDatos accesoBD, String consulta) {
        ResultSet retset;
        retset = accesoBD.ejecutaConsulta(consulta);

        return retset;
    }

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
            System.out.print("\nModificado act\n " + actualizacion);
        } catch (SQLException ex) {
            exito = false;
        }

        return exito;
    }

    public static void eliminarInstalacionBD(BaseDatos accesoBD, Instalacion nuevaInstalacion) {
        String selId = new String();

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

        System.out.println("Consulta eliminar " + selId);
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
            if (!exito) {
                JOptionPane.showMessageDialog(null, "Ha habido un error en la base de datos",
                        "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Instalacion Eliminada",
                        "Confirmacion", JOptionPane.INFORMATION_MESSAGE);
            }
        
    }
}
