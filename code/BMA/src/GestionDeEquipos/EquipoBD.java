/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionDeEquipos;

import GestionDeCategorias.GestorCategorias;
import GestionDeTemporadas.GestorTemporadas;
import ServiciosAlmacenamiento.BaseDatos;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


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
 * Clase que permite el paso de objetos de tipo java a objetos de tipo
 * relacional en formato MySql.
 *
 * @author Jesús Manuel Contreras Siles, Francisco Javier Gómez del Olmo
 * @version 1.0
 */
public class EquipoBD {

    /*Atributos que contiene la tabla Equipo
     * - idEquipo
     * - Fundacion_idFundacion
     * - Categoria_idCategoria
     * - nombre
     * - fundacion
     * - liga_idLiga
     * - temporada_idTemporada
     * - sexo
     */

    /**
     * Funcion para buscar Equipos en la base de datos
     * @param accesoBD acceso a la base de datos.
     * @param nombre nombre del equipo a buscar.
     * @param temporada temporada a la que pertenece.
     * @param categoria categoria a la que pertenece.
     * @param entrenador entrenador encargado de ese equipo.
     * @throws SQLException algun tipo de error en la base de datos.
     * @return ResultSet (java.sql.ResultSet) con el atributo interno de la consulta realizada en la base de datos.
     */
    static ResultSet BuscarEquipos(BaseDatos accesoBD, String nombre, String temporada, String categoria, String entrenador) throws SQLException {

        int idCategoria = GestorCategorias.getIdCategoria(accesoBD, categoria);

        String select = "SELECT DISTINCT Equipo.nombre, Categoria.tipo, Temporada.curso,";
        if (!"".equals(entrenador)) {
            select += ", Usuario.nombre ";
        }

        String from = "Equipo.sexo FROM Equipo, Categoria, Temporada, Rango, Usuario ";

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

    /**
     * Metodo para consultar el Id de un equipo
     * @param accesoBD acceso a la base de datos.
     * @param nombre nombre del equipo a buscar su Id correspondiente.
     * @param categoria categoria a la que pertenece dicho equipo.
     * @throws SQLException algun tipo de error en la base de datos.
     * @return int (entero) con el atributo interno del Id de un equipo.
     */
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

    /** 
     * Metodo para consultar el Id de una liga asociada a un equipo
     * @param accesoBD acceso a la base de datos.
     * @param idEquipo id del equipo del que se quiere buscar la liga.
     * @throws SQLException algun tipo de error en la base de datos.
     * @return int (entero) con el atributo interno del Id de la liga asociada con el equipo.
     */
    static int getIdLigaEq(BaseDatos accesoBD, int idEquipo) throws SQLException {
        int idLiga = 0;

        String consulta = "SELECT liga_idLiga FROM Equipo WHERE Equipo.idEquipo='" + idEquipo + "'";

        ResultSet res = accesoBD.ejecutaConsulta(consulta);

        if (res.next()) {
            idLiga = res.getInt(1);
        }
        return idLiga;
    }

    /** 
     * Metodo para consultar el Id de un usuario
     * @param accesoBD acceso a la base de datos.
     * @param nombre nombre del usuario a buscar su Id correspondiente.
     * @param tipo tipo de usuario que es (primer o segundo).
     * @throws SQLException algun tipo de error en la base de datos.
     * @return int (entero) con el atributo interno del Id de un usuario.
     */
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

    /**
     * Metodo para consultar el id de un usuario.
     * @param accesoBD acceso a la base de datos.
     * @param nombre nombre del usuario a buscar su Id correspondiente.
     * @return int (entero) con el atributo interno del Id de un usuario.
     * @throws SQLException algun tipo de error en la base de datos.
     */
    static int getIdUsuarioNuevo(BaseDatos accesoBD, String nombre) throws SQLException {

        int id = 0;

        String consulta = "SELECT idUsuario FROM usuario WHERE CONCAT(`primerApellido`,' ',`segundoApellido`,' ',`nombre`) = '" + nombre + "'";

        ResultSet res = accesoBD.ejecutaConsulta(consulta);

        if (res.next()) {
            id = res.getInt(1);
        }

        return id;
    }

    /**
     * Metodo para buscar todos los equipos
     * @param accesoBD acceso a la base de datos.
     * @throws SQLException algun tipo de error en la base de datos.
     * @return List<Equipo> (lista) con el atributo interno de una lista de equipos.
     */
    static List<Equipo> getListaEquipos(BaseDatos accesoBD) throws SQLException {

        List<Equipo> equipos = new ArrayList();

        String consulta = "SELECT Equipo.nombre, Categoria.tipo, Temporada.curso, CONCAT(`Usuario`.`nombre`,' ',`Usuario`.`primerApellido`,' ',`Usuario`.`segundoApellido`) as nombre, Equipo.fundacion, Equipo.sexo "
                + "FROM Equipo, Categoria, Temporada, Usuario, Rango "
                + "WHERE Equipo.Categoria_idCategoria = Categoria.idCategoria AND "
                + "Equipo.Temporada_idTemporada = Temporada.idTemporada AND "
                + "Usuario.idUsuario = Rango.Usuario_idUsuario AND "
                + "Rango.Equipo_idEquipo = Equipo.idEquipo";

        ResultSet res = accesoBD.ejecutaConsulta(consulta);

        String n;
        String temp;
        String cat;
        String entrena;
        String entrena2 = "";
        boolean fundacion;
        String sexo;
        Equipo eq;

        while (res.next()) {
            n = res.getString(1);
            cat = res.getString(2);
            temp = res.getString(3);
            entrena = res.getString(4);
            if (res.next()) {
                entrena2 = res.getString(4);
            }
            fundacion = res.getBoolean(5);
            sexo = res.getString(6);
            eq = new Equipo(n, temp, cat, entrena, entrena2, fundacion, sexo);

            equipos.add(eq);
        }

        System.out.println("\nLa consulta es: " + consulta);

        return equipos;
    }

    /** 
     * Metodo para consultar el nombre de un equipo.
     * @param accesoBD acceso a la base de datos.
     * @param s id del equipo a consultar.
     * @throws SQLException algun tipo de error en la base de datos.
     * @return String (cadena) con el atributo interno del nombre del equipo.
     */
    static String getEquipo(BaseDatos accesoBD, String s) throws SQLException {
        String nombreEquipo = "";
        String query = "SELECT nombre FROM Equipo WHERE idEquipo = " + s + ";";
        ResultSet res = accesoBD.ejecutaConsulta(query);
        while (res.next()) {
            nombreEquipo = res.getString(1);
        }
        return nombreEquipo;
    }

    /**
     * Metodo para borrar un equipo de la base de datos.
     * @param accesoBD acceso a la base de datos.
     * @param e equipo a borrar.
     * @throws SQLException algun tipo de error en la base de datos.
     * @return boolean (lógico) con el atributo interno de la comprobación si se ha eliminado un equipo con exito o no.
     */
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

    /** 
     * Metodo para consultar un equipo
     * @param accesoBD acceso a la base de datos.
     * @param nombre nombre del equipo a consultar.
     * @param temporada temporada en la que se ha inscrito.
     * @param categoria categoria a la que pertenece.
     * @throws SQLException algun tipo de error en la base de datos.
     * @return boolean (lógico) con el atributo interno de la comprobación si se ha consultado un equipo con exito o no.
     */
    static boolean ConsultarEquipo(BaseDatos accesoBD, String nombre, String temporada,
            String categoria) throws SQLException {

        boolean validar;

        int idCategoria = GestorCategorias.getIdCategoria(accesoBD, categoria);

        String consulta = "SELECT Equipo.nombre, Categoria.tipo, Temporada.curso "
                + "FROM Equipo, Categoria, Temporada "
                + "WHERE Equipo.nombre='" + nombre + "' "
                + "AND Categoria.idCategoria=" + idCategoria
                + " AND Temporada.idTemporada=" + GestorTemporadas.getIdTemporada(accesoBD, temporada);

        ResultSet res = accesoBD.ejecutaConsulta(consulta);

        System.out.println("\nLa consulta es: " + consulta);

        if (res.next()) {
            validar = false;
        } else {
            validar = true;
        }

        return validar;
    }

    /** 
     * Metodo para crear un equipo en la base de datos
     * @param accesoBD acceso a la base de datos.
     * @param equipo equipo a insertar.
     * @throws SQLException algun tipo de error en la base de datos.
     */
    static void crearEquipoBD(BaseDatos accesoBD, Equipo equipo) throws SQLException {

        int idTemporada = GestorTemporadas.getIdTemporada(accesoBD, equipo.getTemporada());
        int idCategoria = GestorCategorias.getIdCategoria(accesoBD, equipo.getCategoria());
        int idEntrenador = getIdUsuarioNuevo(accesoBD, equipo.getEntrenador());
        int idEntrenador2 = getIdUsuarioNuevo(accesoBD, equipo.getEntrenador2());
        int idFundacion = getIDFundacion(accesoBD);
        int idLiga = getIDLiga(accesoBD);
        String sexo = equipo.getSexo();

        String Consulta = "INSERT INTO equipo (Fundacion_idFundacion, Categoria_idCategoria, nombre, fundacion, liga_idLiga, "
                + "temporada_idTemporada, sexo) VALUES ("
                + idFundacion + ", " + idCategoria + ", '" + equipo.getNombre() + "', " + equipo.getFundacion() + ", "
                + idLiga + ", " + idTemporada + ", '" + sexo + "')";
        int idequipo = accesoBD.obtenerUltimoIdActualizacion(Consulta, "idEquipo", "equipo");

        String InsercionEntrenadorPrimero = "INSERT INTO `mydb`.`rango`"
                + " (`Usuario_idUsuario`, `Equipo_idEquipo`, `Equipo_Fundacion_idFundacion`, "
                + "`Equipo_Categoria_idCategoria`, `Equipo_Temporada_idTemporada`, `tipo`) "
                + "VALUES (" + idEntrenador + ", " + idequipo + ", 1, " + idCategoria + ", " + idTemporada + ", 'Primero')";

        String InsercionEntrenadorSegundo = "INSERT INTO `mydb`.`rango`"
                + " (`Usuario_idUsuario`, `Equipo_idEquipo`, `Equipo_Fundacion_idFundacion`, "
                + "`Equipo_Categoria_idCategoria`, `Equipo_Temporada_idTemporada`, `tipo`) "
                + "VALUES (" + idEntrenador2 + ", " + idequipo + ", 1, " + idCategoria + ", " + idTemporada + ", 'Segundo')";


        accesoBD.ejecutaActualizacion(InsercionEntrenadorPrimero);
        accesoBD.ejecutaActualizacion(InsercionEntrenadorSegundo);

    }

    /** 
     * Metodo para inscribir un alumno en un equipo.
     * @param acceso acceso a la base de datos.
     * @param equipo id del equipo al que se va a inscribir.
     * @param alumno id del alumno que se va a inscribir.
     * @param fundacion id de la fundación a la que pertenece el equipo.
     * @param categoria categoria del equipo.
     * @throws SQLException algun tipo de error en la base de datos.
     */
    static void InsertarAlumno(BaseDatos acceso, int equipo, int alumno, int fundacion, int categoria) throws SQLException {
        String consulta = "INSERT INTO alumnoequipo (Alumno_idAlumno, Equipo_idEquipo, Equipo_Fundacion_idFundacion,"
                + "Equipo_Categoria_idCategoria) VALUES ("
                + alumno + ", " + equipo + ", " + fundacion + ", " + categoria + ")";

        System.out.println("La consulta es " + consulta);

        acceso.ejecutaActualizacion(consulta);

    }

    /** 
     * Metodo para obtener el Id de la fundación.
     * @param acceso acceso a la base de datos.
     * @throws SQLException algun tipo de error en la base de datos.
     * @return int (entero) con el atributo interno del Id de la fundación.
     */
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
    
    /**
     * Metodo consultor
     * @param acceso acceso a la base de datos
     * @return int devuelve el número de equipos que hay en la base de
     * datos.
     * @throws SQLException si encuentra algún error al ejectuar la query SQL
     */
    public static int getNumEquipos(BaseDatos acceso) throws SQLException
    {
        String query = "SELECT COUNT(idEquipo) FROM Equipo";
        
        int num = 0;
        
        ResultSet res = acceso.ejecutaConsulta(query);
        if(res.next())
           num = res.getInt(1);
        
        return num;
    }

    /** 
     * Metodo para obtener el Id de la liga.
     * @param acceso acceso a la base de datos.
     * @throws SQLException algun tipo de error en la base de datos.
     * @return int (entero) con el atributo interno Id de la liga.
     */
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

    /**
     * Metodo para modificar datos del equipo
     * @param accesoBD acceso a la base de datos.
     * @throws SQLException algun tipo de error en la base de datos.
     * @return boolean (lógico) con el atributo interno de la comprobación si se ha modificado un equipo con exito o no.
     */
    public static boolean modificarDatosEquipo(BaseDatos accesoBD, Equipo equipo) throws SQLException {

        boolean exito = true;
        int idCategoria = GestorCategorias.getIdCategoria(accesoBD, equipo.getCategoria());
        int idFundacion = (equipo.getFundacion() == true ? 1 : 0);
        int idTemporada = GestorTemporadas.getIdTemporada(accesoBD, equipo.getTemporada());
        int idEquipo = getIdEq(accesoBD, equipo.getNombre(), equipo.getCategoria());


        String actualizacion = "UPDATE Equipo SET "
                + "Fundacion_idFundacion = 1 , Categoria_idCategoria = " + idCategoria + ", "
                + "nombre = '" + equipo.getNombre() + "', fundacion = "
                + idFundacion + ", liga_idLiga = 1, temporada_idTemporada = "
                + idTemporada + ", sexo = '" + equipo.getSexo() + "'"
                + " WHERE idEquipo = " + idEquipo;

        try {
            accesoBD.ejecutaActualizacion(actualizacion);
            System.out.print("\nModificado act\n " + actualizacion);
        } catch (SQLException ex) {
            exito = false;
        }

        return exito;
    }

    /**
     * Metodo para generar la clasificación de un equipo 
     * @param accesoBD acceso a la base de datos.
     * @param idTemp Id de la temporada del equipo.
     * @param idCate Id de la categoria del equipo.
     * @throws SQLException algun tipo de error en la base de datos.
     * @return ResultSet (java.sql.ResultSet) con el atributo interno de la consulta de los puntos obtenidos y recibidos.
     */
    public static ResultSet generaClasificacion(BaseDatos accesoBD, int idTemp, int idCate) throws SQLException {

        String consulta = "SELECT e.nombre, SUM(p.resultadoLocal), SUM(p.resultadoVisitante) FROM equipo e, partido p "
                + "WHERE e.temporada_idTemporada='" + idTemp + "' AND e.Categoria_idCategoria='" + idCate + "' "
                + "AND e.idEquipo=p.idEquipo GROUP BY p.idEquipo; ";
        ResultSet resSet = accesoBD.ejecutaConsulta(consulta);

        if (!resSet.next()) {
            return null;
        } else {
            resSet.beforeFirst();
            return resSet;
        }
    }

    /**
     * Metodo para obtener el id de la fundacion según un equipo
     * @param accesoBD acceso a la base de datos.
     * @param idEq Id del equipo.
     * @return devuelve un tipo int (entero) que contiene el dato del id
     * de la fundacion según un equipo.
     * @throws SQLException algun tipo de error en la base de datos.
     */
    public static int getIdFundacionEquipo(BaseDatos accesoBD, int idEq) throws SQLException {
        int id = 0;
        String consulta = "SELECT Fundacion_idFundacion FROM equipo WHERE idEquipo = '" + idEq + "';";
        ResultSet ret = accesoBD.ejecutaConsulta(consulta);
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
