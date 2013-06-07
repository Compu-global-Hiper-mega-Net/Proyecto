/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionDeUsuarios;

import ServiciosAlmacenamiento.BaseDatos;
import java.sql.ResultSet;
import java.sql.SQLException;
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
 * Clase  que permite interactuar con las tablas de la base de datos referentes 
 * a los usuarios haciendo diferentes consultas en esta base de datos.
 * @author Francisco
 * @version 1.0
 */
class AccesoBDUsuario {

    /**
     * Permite insertar un nuevo usuario en la base de datos.
     * @param accesoBD Usado para interactuar con la base de datos.
     * @param nuevoUsuario Objeto de tipo Usuario que se va a insertar en la base de datos.
     */
    public static void insertarUsuarioBD(BaseDatos accesoBD, Usuario nuevoUsuario) {
        String insercion = "INSERT INTO usuario (nombre, primerApellido,"
                + "segundoApellido, DNI, clave, entrenador, numeroCuenta,"
                + "telMovil, telFijo, email) values ('"
                + nuevoUsuario.getNombre() + "', '" + nuevoUsuario.getPrimerApellido() + "', '" + nuevoUsuario.getSegundoApellido()
                + "','" + nuevoUsuario.getDni() + "', '" + nuevoUsuario.getClave() + "', " + nuevoUsuario.getEntrenador() + ", '"
                + nuevoUsuario.getNumeroCuenta() + "', " + nuevoUsuario.getTelMovil() + ", " + nuevoUsuario.getTelFijo() + ", '"
                + nuevoUsuario.getEmail() + "')";

        System.out.print("\n insert usuario--> " + insercion);
        try {
            accesoBD.ejecutaActualizacion(insercion);
        } catch (SQLException ex) {
            Logger.getLogger(AccesoBDUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    /**
     * Permite saber si existe un usuario en la base de datos.
     * @param accesoBD Usado para interactuar con la base de datos.
     * @param dni Parametro de tipo string que se usa para identificar el usuario.
     * @return Un booleano que indica si existe o no el usuario en cuestion.
     * @throws SQLException Muestra los mensajes de error en las consultas.
     */
    public static boolean consultaUsuarioDNI(BaseDatos accesoBD, String dni) throws SQLException {
        boolean existe = true;
        ResultSet rs = accesoBD.ejecutaConsulta("SELECT dni FROM usuario WHERE dni='" + dni + "'");
        if (!rs.next()) {
            existe = false;
        }
        return existe;
    }
    

    /**
     * 
     * @param accesoBD Usado para interactuar con la base de datos.
     * @param consulta
     * @return ResultSet con los datos de la consulta realizada.
     */
    public static ResultSet consultaUsuarioBD(BaseDatos accesoBD, String consulta) {
        return accesoBD.ejecutaConsulta(consulta);
    }

    
    /**
     * Permite obtener el id de un entrenador de la base de datos.
     * @param accesoBD Usado para interactuar con la base de datos.
     * @param entrenador Parametro de tipo string usado para obtener el id del entrenador.
     * @return Parametro de tipo entero usado para obtener el entrenador. 
     * @throws SQLException Muestra los mensajes de error en las consultas.
     */
    static int getIdEnt(BaseDatos accesoBD, String entrenador) throws SQLException {
        
        int id = 0;
        String nombre = "", apellido1 = "", apellido2 = "";
        String aux = entrenador;

        int n = 0;
        for(int i = 0; i < entrenador.length(); i++){
            if(entrenador.charAt(i) == ' ')
                n++;
        }
        
        if(n == 3){
            nombre = aux.substring(0, aux.indexOf(" ", aux.indexOf(" ")+1));
            aux = aux.substring(aux.indexOf(" ", aux.indexOf(" ")+1), aux.length());
            apellido1 = aux.substring(aux.indexOf(" ") + 1, aux.indexOf(" ", aux.indexOf(" ") + 1));
            apellido2 = aux.substring(aux.indexOf(" ", aux.indexOf(" ") + 1) + 1, aux.length());
        }
        else{
            nombre = aux.substring(0, aux.indexOf(" "));
            apellido1 = aux.substring(aux.indexOf(" ") + 1, aux.indexOf(" ", aux.indexOf(" ") + 1));
            apellido2 = aux.substring(aux.indexOf(" ", aux.indexOf(" ") + 1) + 1, aux.length());
        }

        String query = "SELECT idUsuario FROM Usuario WHERE nombre='" + nombre + "' AND "
                + "primerApellido='" + apellido1 + "' AND segundoApellido='" + apellido2 + "'";
        ResultSet res = accesoBD.ejecutaConsulta(query);
        if (res.next()) {
            id = res.getInt(1);
        }

        return id;
    }
    
    

    /**
     * 
     * @param accesoBD Usado para interactuar con la base de datos.
     * @param s Parametro de tipo string usado para obtener el entrenador.
     * @return
     * @throws SQLException Muestra los mensajes de error en las consultas.
     */
    static List<String> getListaEntrenadores(BaseDatos accesoBD, String s) throws SQLException {
        String query = "";
        if (!"".equals(s)) {
            query = "SELECT nombre, primerApellido, segundoApellido FROM Usuario WHERE "
                    + "nombre LIKE '%" + s + "%' AND entrenador='1'";
        } else {
            query = "SELECT nombre, primerApellido, segundoApellido FROM Usuario WHERE entrenador='1'";
        }

        ResultSet resCons = accesoBD.ejecutaConsulta(query);

        List<String> res = new ArrayList<String>();

        while (resCons.next()) {
            res.add(resCons.getString(1) + " " + resCons.getString(2) + " " + resCons.getString(3));
        }

        return res;
    }

    
    /**
     * 
     * @param accesoBD Usado para interactuar con la base de datos.
     * @param s Parametro de tipo string usado para obtener el entrenador.
     * @return
     * @throws SQLException Muestra los mensajes de error en las consultas.
     */
    static String getEntrenador(BaseDatos accesoBD, String s) throws SQLException {
        String query = "SELECT nombre, primerApellido, segundoApellido FROM Usuario "
                + "WHERE idUsuario='" + s + "'";
        ResultSet res = accesoBD.ejecutaConsulta(query);

        String ent = "";

        if (res.next()) {
            ent = (res.getString(1) + " " + res.getString(2) + " " + res.getString(3));
        }

        return ent;
    }
    
    

    /**
     * Permite actualizar los datos de un usuario.
     * @param accesoBD Usado para interactuar con la base de datos.
     * @param actualizacion Parametro de tipo string que contiene la actualizacion del usuario.
     * @throws SQLException Muestra los mensajes de error en las consultas.
     */
    public void actualizaUsuarioBD(BaseDatos accesoBD, String actualizacion) throws SQLException {
        accesoBD.ejecutaActualizacion(actualizacion);
    }

    
    /**
     * Permite eliminar un usuario de la base de datos
     * @param accesoBD Usado para interactuar con la base de datos.
     * @param usuarioNuevo Parametro de tipo Usuario que contiene al nuevo usuario.
     */
    public void eliminaUsuarioBD(BaseDatos accesoBD, Usuario usuarioNuevo) {

        String selId = new String();

        selId = "SELECT u.idUsuario, u.entrenador FROM usuario u WHERE u.nombre='" + usuarioNuevo.getNombre() + "' AND u.primerApellido='"
                + usuarioNuevo.getPrimerApellido() + "' AND u.segundoApellido='" + usuarioNuevo.getSegundoApellido() + "' AND u.dni='"
                + usuarioNuevo.getDni() + "'";
        if (usuarioNuevo.getNumeroCuenta() != null) {
            selId = selId + " AND u.numeroCuenta='" + usuarioNuevo.getNumeroCuenta() + "' ";
        }
        if (usuarioNuevo.getTelMovil() != 0) {
            selId = selId + " AND u.telMovil=" + usuarioNuevo.getTelMovil() + " ";
        }
        if (usuarioNuevo.getTelFijo() != 0) {
            selId = selId + " AND u.telFijo=" + usuarioNuevo.getTelFijo() + " ";
        }
        if (usuarioNuevo.getEmail() != null) {
            selId = selId + " AND u.email='" + usuarioNuevo.getEmail() + "' ";
        }
        if (usuarioNuevo.getClave() != null) {
            selId = selId + " AND u.clave='" + usuarioNuevo.getClave() + "' ";
        }

        ResultSet retset;
        try {
            retset = accesoBD.ejecutaConsulta(selId);
            if (retset.next()) {
                usuarioNuevo.setIdUsuario(retset.getInt("idUsuario"));
                if (retset.getBoolean("entrenador") == false) {
                    String consulta = "SELECT * FROM usuario WHERE usuario.entrenador=false";
                    ResultSet retset1 = accesoBD.ejecutaConsulta(consulta);
                    int i = 0;
                    while (retset1.next()) {
                        i++;
                    }
                    //en el caso de que solo halla un administrador, este no podra ser eliminado
                    if (i == 1) {
                        return;
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.print(ex.getMessage());
        }

        String delete1 = "delete from alumnogrupo where alumnogrupo.grupo_usuario_idusuario= " + usuarioNuevo.getIdUsuario();
        String delete2 = "delete from horario where horario.grupo_usuario_idusuario= " + usuarioNuevo.getIdUsuario();
        String delete3 = "delete from rango where rango.usuario_idusuario= " + usuarioNuevo.getIdUsuario();
        String delete4 = "delete from grupo where grupo.usuario_idusuario= " + usuarioNuevo.getIdUsuario();
        String delete5 = "delete from usuario where usuario.idusuario= " + usuarioNuevo.getIdUsuario();

        try {
            accesoBD.ejecutaActualizacion(delete1);
            accesoBD.ejecutaActualizacion(delete2);
            accesoBD.ejecutaActualizacion(delete3);
            accesoBD.ejecutaActualizacion(delete4);
            accesoBD.ejecutaActualizacion(delete5);
        } catch (SQLException ex) {
            Logger.getLogger(AccesoBDUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

 
     /**
     * Permite consultar los datos de las estadisticas de un entrenador identificado por 
     * su nombre, apellidos y DNI realizando la consulta en la base de datos.
     * @param accesoBD Permite interactuar con la base de datos.
     * @param nombre Nombre del usuario.
     * @param primerApellido Primer apellido del usuario.
     * @param segundoApellido Segundo apellido del usuario.
     * @param DNI Dni del usuario.
     * @return ResultSet con los datos de la consulta realizada.
     * @throws SQLException Muestra los mensajes de error en las consultas.
     */
    public static ResultSet generarEstadisticas(BaseDatos accesoBD, String nombre, String apellido1, String apellido2, String DNI) throws SQLException {

        String consulta;

        consulta = "SELECT idUsuario FROM usuario "
                + "WHERE nombre='" + nombre + "' AND primerApellido='" + apellido1 + "' AND segundoApellido='" + apellido2 + "'"
                + " AND DNI='" + DNI + "' AND entrenador=1";
        ResultSet rst = accesoBD.ejecutaConsulta(consulta);

        if (!rst.next()) {
              return null;
        }
        else{
              int idUsu = rst.getInt(1);
              consulta = "SELECT fecha, idEquipo ,idEquipoVisitante, resultadoLocal, resultadoVisitante FROM  partido , rango "
                       + "WHERE Usuario_idUsuario=" + idUsu + " AND Equipo_idEquipo=idEquipo";
              rst = accesoBD.ejecutaConsulta(consulta);

              if (!rst.next())
                   return null;
              else{
                   rst.beforeFirst();
                   return rst;
              }        
        }
    }
     
}
