/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionDeUsuarios;
import ServiciosAlmacenamiento.BaseDatos;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Francisco
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

/**
 * Clase Gestora de Usuarios que permite interactuar con diversos metodos de los usuarios.
 * @author Francisco
 * @version 1.0
 */
public class GestorUsuarios {
    
    /**
     * Permite dar de alta a un nuevo usuario
     * @param accesoBD Usado para interactuar con la base de datos.
     * @param nombre Nombre del usuario.
     * @param primerApellido Primer apellido del usuario.
     * @param segundoApellido Segundo apellido del usuario.
     * @param dni Dni del usuario.
     * @param clave Clave del usuario.
     * @param entrenador Atributo para especificar si el usuario es entrenador.
     * @param telMovil Telefono movil del usuario.
     * @param telFijo Telefono fijo del usuario.
     * @param email Email del usuario.
     * @param numeroCuenta Numero de cuenta del usuario.
     * @return Un booleano que indica si se ha realizado la operacion con exito
     */
    public static boolean darAltaUsuario(BaseDatos accesoBD, String nombre, String primerApellido, String segundoApellido, String dni,
            String clave, boolean entrenador, int telMovil, int telFijo, String email, String numeroCuenta){
        boolean exito = true;
        try {
            if (AccesoBDUsuario.consultaUsuarioDNI(accesoBD, dni)) {
                exito = false;
            } else {
                Usuario usuario = Usuario.crearUsuario(nombre, primerApellido, segundoApellido,
                        dni, clave, entrenador, telMovil, telFijo, email, numeroCuenta);
                AccesoBDUsuario.insertarUsuarioBD(accesoBD, usuario);
            }
        } catch (SQLException ex) {
            exito = false;
        }
        return exito;
    }
    
    
    
   /**
    * Permite consultar los datos del usuario.
    * @param accesoBD Usado para interactuar con la base de datos.
    * @param consulta Parametro de tipo string usado para crear una cadena con la consulta.
    * @return ResultSet con los datos de la consulta.
    */
    public static ResultSet consultarUsuario(BaseDatos accesoBD, String consulta){
        return AccesoBDUsuario.consultaUsuarioBD(accesoBD, consulta);
    }
    
    
    /**
     * Permite saber si el usuario tiene permimsos de administrador
     * @param accesoBD Permite interactuar con la base de datos.
     * @param usuario Parametro de tipo string con el nombre del usuario.
     * @return Un booleano que indica si este usuario tiene permisos o no.
     */
    public static boolean tengoPermisosAdministrador(BaseDatos accesoBD, String usuario) {
        boolean tengoPermisos = true;
        String consulta = "SELECT entrenador FROM usuario WHERE user='" + usuario + "'";
        ResultSet rs = AccesoBDUsuario.consultaUsuarioBD(accesoBD, consulta);
        try {
            rs.next();
            if (rs.getBoolean(1)) {
                tengoPermisos = false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestorUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tengoPermisos;
    }

    
    /**
     * Permite actualizar los datos del usuario especificado.
     * @param accesoBD permite interactuar con la base de datos.
     * @param actualizacion Parametro de tipo string que contiene la actualizacion.
     */
    public static void actualizaUsuario(BaseDatos accesoBD, String actualizacion){
        AccesoBDUsuario Usuario=new AccesoBDUsuario();
        try {
            Usuario.actualizaUsuarioBD(accesoBD, actualizacion);
        } catch (SQLException ex) {
            Logger.getLogger(GestorUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
    
    
    /**
     * Permite dar de baja a un usuario.
     * @param accesoBD Usado para interactuar con la base de datos.
     * @param nombre Nombre del usuario.
     * @param primerApellido Primer apellido del usuario.
     * @param segundoApellido Segundo apellido del usuario.
     * @param dni Dni del usuario.
     * @param clave Clave del usuario.
     * @param entrenador Atributo para especificar si el usuario es entrenador.
     * @param telMovil Telefono movil del usuario.
     * @param telFijo Telefono fijo del usuario.
     * @param email Email del usuario.
     * @param numeroCuenta Numero de cuenta del usuario.
     */
    public static void eliminaUsuario(BaseDatos accesoBD, String nombre, String primerApellido, String segundoApellido, 
            String dni, String clave, boolean entrenador, int telMovil, int telFijo,
            String email, String numeroCuenta ){
        
        AccesoBDUsuario usuarioBD=new AccesoBDUsuario();
        Usuario usuarioEliminado = Usuario.crearUsuario(nombre,
            primerApellido, segundoApellido, dni,
            clave, entrenador, telMovil, telFijo,
            email, numeroCuenta);
        usuarioBD.eliminaUsuarioBD(accesoBD, usuarioEliminado);
    }
    
    
    /**
     * Permite obtener una lista de entrenadores.
     * @param accesoBD Permite interactuar con la base de datos.
     * @param s Parametro de tipo string usado para obtener la lista de entrenadores.
     * @return Una lista de tipo string con los entrenadores.
     * @throws SQLException Muestra los mensajes de error en las consultas.
     */
    public static List<String> getEntrenadores(BaseDatos accesoBD, String s) throws SQLException{
        List<String> res = new ArrayList<String>();        
        res = AccesoBDUsuario.getListaEntrenadores(accesoBD, s);

        return res;
    }

    
    /**
     * Permite obtener el id de un entrenador.
     * @param accesoBD Permite interactuar con la base de datos.
     * @param entrenador Parametro de tipo string usado para obtener el id del entrenador.
     * @return Entero que identifica el id del entrenador.
     * @throws SQLException Muestra los mensajes de error en las consultas.
     */
    public static int getIdEnt(BaseDatos accesoBD, String entrenador) throws SQLException {
        int res = AccesoBDUsuario.getIdEnt(accesoBD, entrenador);

        return res;
    }

    
    /**
     * Permite obtener un entrenador el cual es especificado por su nombre.
     * @param accesoBD Permite interactuar con la base de datos.
     * @param s Parametro de tipo string usado para obtener el entrenador.
     * @return Un valor de tipo string con el entrenador obtenido.
     * @throws SQLException Muestra los mensajes de error en las consultas.
     */
    public static String getEntrenador(BaseDatos accesoBD, String s) throws SQLException {
        return AccesoBDUsuario.getEntrenador(accesoBD, s);
    }

    
    /**
     * Permite obtener un entrenador el cual es especificado por su id.
     * @param accesoBD Permite interactuar con la base de datos.
     * @param idEnt Parametro de tipo entero usado para obtener el entrenador. 
     * @return Un valor de tipo string con el entrenador obtenido.
     * @throws SQLException Muestra los mensajes de error en las consultas.
     */
    public static String getEntrenador(BaseDatos accesoBD, int idEnt) throws SQLException {
        String query = "SELECT nombre, primerApellido, segundoApellido FROM Usuario WHERE "
                + "idUsuario='"+idEnt+"'";
        ResultSet res = accesoBD.ejecutaConsulta(query);
        
        String ent = "";
        if(res.next())
            ent = (res.getString(1)+" "+res.getString(2)+" "+res.getString(3));
        
        return ent;
    }
    
    
    /**
     * Permite consultar los datos de las estadisticas de un entrenador identificado por 
     * su nombre, apellidos y DNI haciendo una llamada a generarEstadisticas de AccesoBDUsuario.
     * @param accesoBD Permite interactuar con la base de datos.
     * @param nombre Nombre del usuario.
     * @param primerApellido Primer apellido del usuario.
     * @param segundoApellido Segundo apellido del usuario.
     * @param DNI Dni del usuario.
     * @return ResultSet con los datos de la consulta realizada.
     * @throws SQLException Muestra los mensajes de error en las consultas.
     */
     public static ResultSet consultarEstadisticasEntrenador(BaseDatos accesoBD, String nombre, String apellido1, String apellido2, String DNI) throws SQLException {
         
        return AccesoBDUsuario.generarEstadisticas(accesoBD, nombre, apellido1, apellido2, DNI);  
    }
}
