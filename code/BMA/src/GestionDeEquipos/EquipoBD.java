/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionDeEquipos;

import GestionActividades.AccesoBDActividad;
import GestionDeCategorias.GestorCategorias;
import GestionDeTemporadas.GestorTemporadas;
import GestionDeTemporadas.TemporadaBD;
import ServiciosAlmacenamiento.BaseDatos;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author
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
public class EquipoBD {

    //Filtrar entrenador correctamente
    static ResultSet BuscarEquipos(BaseDatos accesoBD, String nombre, String temporada, String categoria, String entrenador) throws SQLException {

        int idCategoria = GestorCategorias.getIdCategoria(accesoBD, categoria);

        String select = "SELECT DISTINCT Equipo.nombre, Categoria.tipo, Temporada.curso";
        if (!"".equals(entrenador)) {
            select += ", Usuario.nombre ";
        }

        String from = "FROM Equipo, Categoria, Temporada, Rango, Usuario ";

        String condicion = "WHERE ";

        if (!"".equals(nombre) || !"-Categoria-".equals(categoria) || !"-Temporada-".equals(temporada) || !"".equals(entrenador)) {

            if (!"".equals(nombre)) {
                condicion += "Equipo.nombre='" + nombre + "' AND ";
            }
            if (!"-Categoria-".equals(categoria)) {
                condicion += "Categoria.idCategoria='" + idCategoria + "' AND ";
            }
            if (!"-Temporada-".equals(temporada)) {
                condicion += "Temporada.idTemporada='" + GestorTemporadas.getIdTemporada(accesoBD, temporada) + "' AND ";
            }
            if (!"".equals(entrenador)) {
                condicion += "Rango.Usuario_idUsuario='" + getIdUsuario(accesoBD, entrenador, "primero") + "' AND ";
                condicion += "Usuario.idUsuario=Rango.Usuario_idUsuario AND ";
            }

        }
        condicion = condicion.substring(0, condicion.length() - 5);
        select = select + from + condicion;

        System.out.println("\nLa consulta es: " + select);
        ResultSet listaEquipos = accesoBD.ejecutaConsulta(select);

        return listaEquipos;
    }

    //Correcta
    static int getIdEq(BaseDatos accesoBD, String nombre, String categoria) throws SQLException {

        int idEquipo = 0;

        int idCategoria = GestorCategorias.getIdCategoria(accesoBD, categoria);

        String consulta = "SELECT idEquipo FROM Equipo WHERE Equipo.nombre='" + nombre + "' AND Categoria_idCategoria='" + idCategoria + "'";

        ResultSet res = accesoBD.ejecutaConsulta(consulta);

        if (res.next()) {
            idEquipo = res.getInt(1);
        }
        return idEquipo;
    }

    //Correcta
    static int getIdUsuario(BaseDatos accesoBD, String nombre, String tipo) throws SQLException {

        int id = 0;

        String consulta = "SELECT idUsuario FROM Usuario, Rango WHERE Usuario.nombre='" + nombre + "'";
        consulta += " AND Rango.tipo='" + tipo + "'";

        ResultSet res = accesoBD.ejecutaConsulta(consulta);

        if (res.next()) {
            id = res.getInt(1);
        }

        return id;
    }

    //Filtrar entrenador
    static List<Equipo> getListaEquipos(BaseDatos accesoBD) throws SQLException {

        List<Equipo> equipos = new ArrayList();

        String consulta = "SELECT Equipo.nombre, Categoria.tipo, Temporada.curso, Usuario.nombre, Equipo.fundacion "
                + "FROM Equipo, Categoria, Temporada, Usuario, Rango "
                + "WHERE Equipo.Categoria_idCategoria = Categoria.idCategoria AND "
                + "Equipo.Temporada_idTemporada = Temporada.idTemporada AND "
                + "Usuario.idUsuario = Rango.Usuario_idUsuario AND "
                + "Rango.Equipo_idEquipo = Equipo.idEquipo AND "
                + "Rango.tipo = 'primero'";

        ResultSet res = accesoBD.ejecutaConsulta(consulta);

        String n;
        String temp;
        String cat;
        String entrena;
        String entrena2 = "";
        boolean fundacion;
        Equipo eq;

        while (res.next()) {
            n = res.getString(1);
            cat = res.getString(2);
            temp = res.getString(3);
            entrena = res.getString(4);
            fundacion = res.getBoolean(5);
            eq = new Equipo(n, temp, cat, entrena, entrena2, fundacion);

            equipos.add(eq);
        }

        System.out.println("\nLa consulta es: " + consulta);

        return equipos;
    }

    //Probar con cascade
    static boolean EliminarEquipoBD(BaseDatos accesoBD, Equipo e) throws SQLException {

        boolean equipoEliminado = true;

        int idCategoria = GestorCategorias.getIdCategoria(accesoBD, e.getCategoria());
        int idEquipo = getIdEq(accesoBD, e.getNombre(), e.getCategoria());

        //String delete1 = "DELETE FROM Rango WHERE Equipo_idEquipo='" + idEquipo + "' AND Equipo_Categoria_idCategoria='"+idCategoria+"'";
        //String delete2 = "DELETE FROM TemporadaEquipo where temporadaequipo.Equipo_idEquipo= " + idEquipo;
        String delete3 = "DELETE FROM Equipo WHERE Equipo.idEquipo= " + idEquipo;

        //equipoEliminado = accesoBD.eliminar(delete1);
        //equipoEliminado = accesoBD.eliminar(delete2);
        //equipoEliminado = accesoBD.eliminar(delete3);

        //equipoEliminado = false;
        //System.out.println("\nDELETE 1: " + delete1);
        //System.out.println("\nDELETE 2: " + delete2);
        System.out.println("\nDELETE 3: " + delete3);

        return equipoEliminado;
    }

    //Correcta
    static boolean ConsultarEquipo(BaseDatos accesoBD, String nombre, String temporada,
            String categoria) throws SQLException {

        boolean validar;

        int idCategoria = GestorCategorias.getIdCategoria(accesoBD, categoria);

        String consulta = "SELECT Equipo.nombre, Categoria.tipo, Temporada.curso "
                + "FROM Equipo, Categoria, Temporada "
                + "WHERE Equipo.nombre='" + nombre + "' "
                + "AND Categoria.idCategoria='" + idCategoria + "' "
                + "AND Temporada.idTemporada='" + GestorTemporadas.getIdTemporada(accesoBD, temporada) + "'";

        ResultSet res = accesoBD.ejecutaConsulta(consulta);

        System.out.println("\nLa consulta es: " + consulta);

        if (res.next()) {
            validar = false;
        } else {
            validar = true;
        }

        return validar;
    }

    //Correcta
    static void crearEquipoBD(BaseDatos accesoBD, Equipo equipo) throws SQLException {

        int idTemporada = GestorTemporadas.getIdTemporada(accesoBD, equipo.getTemporada());
        int idCategoria = GestorCategorias.getIdCategoria(accesoBD, equipo.getCategoria());
        int idEntrenador = getIdUsuario(accesoBD, equipo.getEntrenador(), "primero");
        int idEntrenador2 = getIdUsuario(accesoBD, equipo.getEntrenador2(), "segundo");
        int idFundacion = getIDFundacion(accesoBD);
        int idLiga = getIDLiga(accesoBD);

        //Insertar en Equipo
        String Consulta = "INSERT INTO equipo (Fundacion_idFundacion, Categoria_idCategoria, nombre, fundacion, liga_idLiga, "
                + "temporada_idTemporada) VALUES ("
                + idFundacion + ", " + idCategoria + ", '" + equipo.getNombre() + "', " + equipo.getFundacion() + ", "
                + idLiga + ", " + idTemporada + ")";
        System.out.print("\n\nAcanderMore " + Consulta);
        
        accesoBD.ejecutaActualizacion(Consulta);

    }

    static void InsertarAlumno (BaseDatos acceso, int equipo, int alumno, int fundacion, int categoria) throws SQLException{
        String consulta = "INSERT INTO alumnoequipo (Alumno_idAlumno, Equipo_idEquipo, Equipo_Fundacion_idFundacion,"
                + "Equipo_Categoria_idCategoria) VALUES ("+
                alumno + ", " + equipo + ", " + fundacion + ", " + categoria + ")";
        
        acceso.ejecutaActualizacion(consulta);
        
    }
    
    static int getIDFundacion(BaseDatos acceso) {
        String consulta = "SELECT idFundacion FROM fundacion";
        int id = 0;
        ResultSet ret;

        ret = acceso.ejecutaConsulta(consulta);
        try {
            if (ret.next()) {
                id = ret.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EquipoBD.class.getName()).log(Level.SEVERE, null, ex);
        }

        return id;
    }

    private static int getIDLiga(BaseDatos acceso) {
        String consulta = "SELECT idLiga FROM liga";
        int id = 0;
        ResultSet ret;

        ret = acceso.ejecutaConsulta(consulta);
        try {
            if (ret.next()) {
                id = ret.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EquipoBD.class.getName()).log(Level.SEVERE, null, ex);
        }

        return id;
    }
    
}
