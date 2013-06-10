/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionDeEquipos;

import GestionDeCategorias.GestorCategorias;
import InterfazUsuario.NuevoEquipo;
import ServiciosAlmacenamiento.BaseDatos;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

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
 * Clase que permite realizar la gestión los equipos.
 *
 * @author Jesús Manuel Contreras Siles
 * @version 1.0
 */
public class GestorEquipos {

    /**
     * Metodo para la consulta de un equipo
     * @param accesoBD acceso a la base de datos.
     * @param nombre nombre del equipo a consultar.
     * @param temporada temporada a la que pertenece.
     * @param categoria categoria a la que pertenece.
     * @param entrenador entrenador encargado del equipo.
     * @param fundación valor lógico que comprueba si pertence a la fundación o no.
     * @param sexo sexo del equipo.
     * @throws SQLException algun tipo de error en la base de datos.
     * @return Lista<Equipo> (lista) con el atributo interno de un equipo.
     */
    public static List<Equipo> ConsultaEquipo(BaseDatos accesoBD, String nombre,
            String temporada, String categoria, String entrenador, boolean fundacion, String sexo) throws SQLException {

        List<Equipo> listaEquipos = new ArrayList();
        Equipo eq;

        String n;
        String temp;
        String cat;
        String entrena;
        String entrena2 = "";

        ResultSet res = EquipoBD.BuscarEquipos(accesoBD, nombre, temporada, categoria, entrenador);

        while (res.next()) {
            n = res.getString(1);
            cat = res.getString(2);
            temp = res.getString(3);
            entrena = res.getString(4);
            eq = new Equipo(n, temp, cat, entrena, entrena2, fundacion, sexo);

            listaEquipos.add(eq);
        }

        return listaEquipos;
    }

    /** 
     * Metodo que devuelve una lista con todos los equipos.
     * @param accesoBD acceso a la base de datos.
     * @throws SQLException algun tipo de error en la base de datos.
     * @return List<Equipo> (lista) con el atributo interno de todos los equipos.
     */
    public static List<Equipo> getListaEquipos(BaseDatos accesoBD) throws SQLException {

        List<Equipo> equipos = new ArrayList<Equipo>();

        equipos = EquipoBD.getListaEquipos(accesoBD);

        return equipos;
    }

    /** 
     * Metodo que devuelve el Id de un equipo.
     * @param accesoBD acceso a la base de datos.
     * @param equipo datos relacionados del equipo.
     * @param cat dato perteneciente a la categoria del equipo.
     * @throws SQLException algun tipo de error en la base de datos.
     * @return int (entero) con el atributo interno del Id de un equipo. 
     */
    public static int getIdEquipo(BaseDatos accesoBD, String equipo, String cat) throws SQLException {
        return EquipoBD.getIdEq(accesoBD, equipo, cat);
    }

    /** 
     * Metodo que devuelve el id de la liga a la que pertenece un equipo
     * @param accesoBD acceso a la base de datos.
     * @param idEquipo id del equipo.
     * @throws SQLException algun tipo de error en la base de datos.
     * @return int (entero) con el atributo interno del Id de un equipo.
     */
    public static int getIdLigaEquipo(BaseDatos accesoBD, int idEquipo) throws SQLException {
        return EquipoBD.getIdLigaEq(accesoBD, idEquipo);
    }

    /** 
     * Metodo que devuelve el nombre de un equipo
     * @param accesoBD acceso a la base de datos.
     * @param s id del equipo.
     * @throws SQLException algun tipo de error en la base de datos.
     * @return String (cadena) con el atributo interno del nombre del equipo.
     */
    public static String getEquipo(BaseDatos accesoBD, String s) throws SQLException {
        return EquipoBD.getEquipo(accesoBD, s);
    }

    /** 
     * Metodo para eliminar un equipo.
     * @param accesoBD acceso a la base de datos.
     * @param e equipo a borrar.
     * @throws SQLException algun tipo de error en la base de datos.
     * @return boolean (lógico) con el atributo interno del resultado de la eliminación, es decir, si ha tenido exito o no.
     */
    public static boolean EliminarEquipo(BaseDatos accesoBD, Equipo e) throws SQLException {

        return EquipoBD.EliminarEquipoBD(accesoBD, e);
    }

    /** 
     * Metodo para insertar un equipo.
     * @param accesoBD acceso a la base de datos.
     * @param nombre nombre del equipo a insertar.
     * @param temporada temporada a la que pertenece.
     * @param categoria categoria a la que pertenece.
     * @param entrenador nombre entrenador encargado del equipo.
     * @param entrenador2 nombre del segundo entrenador del equipo.
     * @param fundacion valor logico que determina si pertenece a la fundación o no.
     * @param sexo determina el sexo del equipo.
     * @throws SQLException algun tipo de error en la base de datos.
     */
    public static void InsertarDatosEquipo(BaseDatos accesoBD, String nombre,
            String temporada, String categoria, String entrenador, String entrenador2, boolean fundacion, String sexo) throws SQLException {

        boolean validar = EquipoBD.ConsultarEquipo(accesoBD, nombre, temporada, categoria);

        if (validar == false) {
            JOptionPane.showMessageDialog(new NuevoEquipo(), "El equipo ya existe", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            Equipo equipo;
            equipo = new Equipo(nombre, temporada, categoria, entrenador, entrenador2, fundacion, sexo);

            EquipoBD.crearEquipoBD(accesoBD, equipo);
        }

    }

    /** 
     * Metodo para inscribir alumnos en un equipo.
     * @param accesoBD acceso a la base de datos.
     * @param modelo lista de los alumnos a inscribir.
     * @param categoria categoria del equipo.
     * @param nombre nombre del equipo a que se van a inscribir.
     * @throws SQLException algun tipo de error en la base de datos.
     */
    public static void InsertarJugadoresEquipo(BaseDatos accesoBD, DefaultListModel modelo, String categoria,
            String nombre) throws SQLException {

        int idCategoria = GestorCategorias.getIdCategoria(accesoBD, categoria);
        int idEquipo = EquipoBD.getIdEq(accesoBD, nombre, categoria);
        int idFundacion = EquipoBD.getIDFundacion(accesoBD);
        String nombreCompleto, nombreJugador, pApellido, sApellido;

        //De la lista, se coge los alumnos de uno en uno y se inserta.
        for (int i = 0; i < modelo.size(); i++) {
            ResultSet ret;
            int idAlumno = 0;
            //Obtenemos el nombre del alumno de la lista.
            nombreCompleto = (String) modelo.getElementAt(i);
            pApellido = nombreCompleto.substring(0, nombreCompleto.indexOf(" "));
            nombreCompleto = nombreCompleto.substring(nombreCompleto.indexOf(" ") + 1, nombreCompleto.length());
            sApellido = nombreCompleto.substring(0, nombreCompleto.indexOf(" "));
            nombreJugador = nombreCompleto.substring(nombreCompleto.indexOf(" ") + 1, nombreCompleto.length());

            //Debug para ver si se obtiene correctamente el nombre
            System.out.print("Nombre\n\n" + nombreJugador);
            System.out.print("Nombre\n\n" + pApellido);
            System.out.print("Nombre\n\n" + sApellido);

            String consulta = "SELECT idAlumno FROM alumno WHERE nombre = '" + nombreJugador
                    + "' AND primerApellido = '" + pApellido + "' AND segundoApellido = '"
                    + sApellido + "'";

            System.out.print("Consuelo \n\n" + consulta);
            //Aqui, se saca el idAlumno
            ret = accesoBD.ejecutaConsulta(consulta);

            if (ret.next()) {
                idAlumno = ret.getInt(1);
            }
            //Se llama a la funcion InsertarAlumno que se encarga de insertarlo en la Base de datos
            EquipoBD.InsertarAlumno(accesoBD, idEquipo, idAlumno, idFundacion, idCategoria);
        }


    }

    /** 
     * Metodo para generar la clasificación
     * @param accesoBD acceso a la base de datos.
     * @param idTemp Id de la temporada del equipo.
     * @param idCate Id de la categoria del equipo.
     * @throws SQLException algun tipo de error en la base de datos.
     * @return ResultSet (java.sql.ResultSet)
     */
    public static ResultSet consultarClasificacion(BaseDatos accesoBD, int idTemp, int idCate) throws SQLException {

        return EquipoBD.generaClasificacion(accesoBD, idTemp, idCate);
    }

    /** 
     * Metodo para obtener el id de la fundacion según el equipo.
     * @param accesoBD acceso a la base de datos.
     * @param idEq identificador del equipo
     * @throws SQLException algun tipo de error en la base de datos.
     * @return ResultSet (java.sql.ResultSet)
     */
    public static int getIdFundacionEquipo(BaseDatos accesoBD, int idEq) throws SQLException {
        return EquipoBD.getIdFundacionEquipo(accesoBD, idEq);
    }

    /**
     * Metodo para modificar los equipos
     * @param accesoBD acceso a la base de datos.
     * @param equipo parametro formal del tipo Equipo que contien los datos
     * representativos de un equipo obtenidos del formulario.
     * @return devuelve un tipo boolean que nos permite saber si se ha ejectuado
     * o no la query sobre nuestra base de datos.
     * @throws SQLException 
     */
    public static boolean modificarEquipos(BaseDatos accesoBD, Equipo equipo) throws SQLException {
        return EquipoBD.modificarDatosEquipo(accesoBD, equipo);
    }
}
