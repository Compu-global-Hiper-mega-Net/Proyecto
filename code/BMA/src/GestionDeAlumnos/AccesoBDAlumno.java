/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionDeAlumnos;

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
 * Clase que se comunica directamente con la base de datos
 *
 * @author Compu-global-Hiper-mega-Net
 */
class AccesoBDAlumno {

    /**
     * Se inserta el alumno den la BD.
     *
     * @param accesoBD Conexión con la BD.
     * @param alumnoNuevo Nuevo alumno.
     * @throws SQLException Excepción que se lanza cuando hay un problema con la
     * BD.
     */
    protected static void insertarAlumnoBD(BaseDatos accesoBD, Alumno alumnoNuevo) throws SQLException {
        String dateString = String.format("%1$tY-%1$tm-%1$td", alumnoNuevo.getFechaNacimiento());

        
        String inserccion = "INSERT INTO alumno (nombre, primerApellido, segundoApellido,"
                + "fechaNacimiento, colegio, email, localidad, provincia, codigoPostal, domicilio, "
                + "nombrePadre, nombreMadre, numeroCuenta, talla, telFijo, telMovil, sexo) VALUES ('"
                + alumnoNuevo.getNombre() + "', '" + alumnoNuevo.getPrimerApellido() + "', '"
                + alumnoNuevo.getSegundoApellido() + "','" + dateString + "', '" + alumnoNuevo.getColegio()
                + "', '" + alumnoNuevo.getEmail() + "', '" + alumnoNuevo.getLocalidad() + "', '"
                + alumnoNuevo.getProvincia() + "', " + alumnoNuevo.getCodPostal() + ", '"
                + alumnoNuevo.getDomicilio() + "', '" + alumnoNuevo.getNombrePadre()
                + "', '" + alumnoNuevo.getNombreMadre() + "', '" + alumnoNuevo.getCuentaCorriente()
                + "', '" + alumnoNuevo.getTallaAlumno() + "', " + alumnoNuevo.getTelFijo() + ", "
                + alumnoNuevo.getTelMovil() + ", '" + alumnoNuevo.getSexo() + "' )";

        accesoBD.ejecutaActualizacion(inserccion);
        
        /*Calendar fecha = alumnoNuevo.getFechaNacimiento();
        Calendar fechasistema;
        fechasistema = new GregorianCalendar();
        String cat_alum = "";
        int id_alumno = 0, id_categoria = 0;
            
        int Edad = fechasistema.get(Calendar.YEAR) - fecha.get(Calendar.YEAR);
        
        // Selecciono la categoría según la edad que tenga el alumno 
        // en ese año, dado que el curso comienza una sola vez en
        // la temporada.
        
        if(Edad >= 9 && Edad < 18)
        {
            if(Edad >= 9 && Edad <= 10)
                cat_alum = "benjamín";
            
            if(Edad >= 11 && Edad <= 12)
                cat_alum = "alevín";
            
            if(Edad >= 13 && Edad <= 14)
                cat_alum = "infantil";
            
            if(Edad >= 15 && Edad <= 16)
                cat_alum = "cadete";
            
            if(Edad >= 17 && Edad < 18)
                cat_alum = "junior";      
            
        }
        
        System.out.print("\n inser " + inserccion);
        
        // Selecciono el último id introducido que será el del alumno en la BD
        
        id_alumno = accesoBD.obtenerUltimoIdActualizacion(inserccion);
        
        String idCategoria = "SELECT idCategoria FROM categoria WHERE tipo ='" + cat_alum + "'";
        
        ResultSet res_categoria = accesoBD.ejecutaConsulta(idCategoria);
        
        if(res_categoria.next())
            id_categoria = res_categoria.getInt(1);
        
        String categoria_alumno = "INSERT INTO categoriaalumno (categoria_idCategoria, alumno_idAlumno) VALUES ('" 
                + id_categoria + "', '" + id_alumno + "' )";
        
        
        // Introducimos los datos del alumno en la tabla intermedia
        // categoria alumno para así luego no tener que realizar
        // búsqueda en la tabla de los alumnos
        
        accesoBD.ejecutaActualizacion(categoria_alumno);*/
       
    }

    /**
     * Obtiene una lista de alumnos segun el primer apellido del alumno.
     *
     * @param accesoBD Conexión con la BD.
     * @param s Parametro a comparar con el primer apellido.
     * @return Una Lista de nombres.
     * @throws SQLException Excepción que se lanza cuando hay un problema con la
     * BD.
     */
    protected static List<String> getListaAlumnos(BaseDatos accesoBD, String s) throws SQLException {
        List<String> als = new ArrayList<>();
        String query;

        // Si el parámetro es vacío se devuelven todos los alumnos.
        if (!s.equals("")) {
            query = "SELECT nombre, primerApellido, segundoApellido FROM Alumno "
                    + "WHERE primerApellido LIKE '%" + s + "%' OR nombre LIKE '%" + s + "%' OR segundoApellido LIKE '%" + s + "%'";
        } else {
            query = "SELECT nombre, primerApellido, segundoApellido FROM Alumno";
        }
        ResultSet res = accesoBD.ejecutaConsulta(query);

        while (res.next()) {
            als.add(res.getString(2) + " " + res.getString(3) + " " + res.getString(1));
        }

        return als;
    }

    /**
     * Método que de una lista de ids obtiene sus nombres.
     *
     * @param accesoBD Conexión con la BD.
     * @param listaAlumnos Lista de ids.
     * @return Lista con los nombres de los alumnos.
     * @throws SQLException Excepción que se lanza cuando hay un problema con la
     * BD.
     */
    protected static List<String> getNombreAl(BaseDatos accesoBD, List<Integer> listaAlumnos) throws SQLException {
        List<String> listaNombreAl = new ArrayList<>();

        for (int s : listaAlumnos) {
            String query = "SELECT primerApellido, segundoApellido, nombre FROM alumno"
                    + " WHERE idAlumno = " + s;

            ResultSet ret = accesoBD.ejecutaConsulta(query);

            if (ret.next()) {
                listaNombreAl.add(ret.getString(1) + " " + ret.getString(2) + " " + ret.getString(3));
                System.out.print("\n\n" + listaNombreAl);
            }
        }

        return listaNombreAl;
    }

    /**
     * Método que retorna ids de alumnos segun sus nombres.
     *
     * @param accesoBD Conexion con la BD.
     * @param listaAlumnos Lista de alumnos.
     * @return Lista de Enteros, ids.
     * @throws SQLException Excepción que se lanza cuando hay un problema con la
     * BD.
     */
    protected static List<Integer> getIdAl(BaseDatos accesoBD, List<String> listaAlumnos) throws SQLException {
        List<Integer> listaIDAl = new ArrayList<>();
        String aux, apellido1, apellido2;

        for (String s : listaAlumnos) {
            aux = s;

            // Se recuperan los apellidos y se busca por ellos.
            apellido1 = aux.substring(0, aux.indexOf(" "));
            apellido2 = aux.substring(aux.indexOf(" ") + 1, aux.indexOf(" ", aux.indexOf(" ") + 1));

            String query = "SELECT idAlumno FROM Alumno WHERE primerApellido='" + apellido1 + "'"
                    + "AND segundoApellido='" + apellido2 + "'";
            ResultSet res = accesoBD.ejecutaConsulta(query);

            if (res.next()) {
                listaIDAl.add(res.getInt(1));
            }
        }

        return listaIDAl;
    }

    /**
     * Método que de un alumno devuelve un id.
     *
     * @param accesoBD Conexion con la BD.
     * @param s Parámetro a comparar con el primer apellido.
     * @return Id Entero.
     * @throws SQLException Excepción que se lanza cuando hay un problema con la
     * BD.
     */
    protected static int getIdAl(BaseDatos accesoBD, String s) throws SQLException {
        int idAl = 0;
        String aux, apellido1, apellido2;

        aux = s;

        // Se sacan los apellidos y se busca por ellos.
        apellido1 = aux.substring(0, aux.indexOf(" "));
        apellido2 = aux.substring(aux.indexOf(" ") + 1, aux.indexOf(" ", aux.indexOf(" ") + 1));

        String query = "SELECT idAlumno FROM Alumno WHERE primerApellido='" + apellido1 + "'"
                + " AND segundoApellido='" + apellido2 + "'";

        ResultSet res = accesoBD.ejecutaConsulta(query);

        System.out.println("," + apellido1 + "," + apellido2 + ",");

        if (res.next()) {
            idAl = res.getInt(1);
        }
        //System.out.println();
        System.out.println(idAl);
        return idAl;
    }

    /**
     * Método que retorna una lista de alumnos sin grupo asignado.
     *
     * @param accesoBD Conexión con la BD.
     * @param s Parámetro a comparar con el primer apellido.
     * @return Lista de Strings.
     * @throws SQLException Excepción que se lanza cuando hay un problema con la
     * BD.
     */
    protected static List<String> getListaAlumnosSinGrupo(BaseDatos accesoBD, String s) throws SQLException {
        List<String> als = new ArrayList<>();
        String query;

        if (!s.equals("")) {
            query = "SELECT nombre, primerApellido, segundoApellido FROM Alumno "
                    + "WHERE primerApellido LIKE '%" + s + "%'";
        } else {
            query = "SELECT nombre, primerApellido, segundoApellido from Alumno"
                    + " WHERE idAlumno NOT IN "
                    + "(SELECT Alumno_idAlumno from Alumnogrupo) ";
        }
        ResultSet res = accesoBD.ejecutaConsulta(query);

        while (res.next()) {
            als.add(res.getString(2) + " " + res.getString(3) + " " + res.getString(1));
        }

        return als;
    }

    /**
     * Método para realizar consultas.
     *
     * @param accesoBD Conexión con la BD.
     * @param consulta Consulta a la BD.
     * @return La respuesta a la consulta.
     */
    public static ResultSet consultaAlumnoBD(BaseDatos accesoBD, String consulta) {
        return accesoBD.ejecutaConsulta(consulta);
    }

    /**
     * Metodo que modifica los datos de un alumno y retorna si se ha realizado
     * correctamente.
     *
     * @param accesoBD Conexión con la BD.
     * @param idAlumno Identificador del alumno.
     * @param nombre Nombre.
     * @param primerApellido Primer apellido.
     * @param segundoApellido Segundo apellido.
     * @param fechaNac Fecha de nacimiento.
     * @param cuentaCorriente Cuenta corriente.
     * @param domicilio Residencia habitual.
     * @param localidad Localidad.
     * @param codPostal Código postal.
     * @param provincia Provincia.
     * @param colegio Colegio en el que está escolarizado el alumno.
     * @param sexo Sexo.
     * @param nombrePadre Nombre del padre.
     * @param nombreMadre Nombre de la madre.
     * @param telFijo Teléfono fijo.
     * @param telMovil Teléfono móvil.
     * @param email Correo electrónico.
     * @param observaciones Observaciones.
     * @param tallaAlumno Talla de ropa.
     * @return Booleano.
     */
    public static boolean modificarDatosAlumno(BaseDatos accesoBD, String idAlumno, String nombre, String primerApellido, String segundoApellido, String fechaNac,
            String cuentaCorriente, String domicilio, String localidad, String codPostal, String provincia, String colegio, String sexo,
            String nombrePadre, String nombreMadre, String telFijo, String telMovil, String email, String observaciones, String tallaAlumno) {
        boolean exito = true;
        // Se insertan en la actualización los datos que tienen que actualizarse
        String actualizacion = "UPDATE alumno SET ";
        if (nombre != null) {
            actualizacion = actualizacion + "nombre='" + nombre + "', ";
        }
        if (primerApellido != null) {
            actualizacion = actualizacion + "primerApellido='" + primerApellido + "', ";
        }
        if (segundoApellido != null) {
            actualizacion = actualizacion + "segundoApellido='" + segundoApellido + "', ";
        }
        if (fechaNac != null) {
            actualizacion = actualizacion + "fechaNacimiento='" + fechaNac + "', ";
        }
        if (cuentaCorriente != null) {
            actualizacion = actualizacion + "numeroCuenta='" + cuentaCorriente + "', ";
        }
        if (domicilio != null) {
            actualizacion = actualizacion + "domicilio='" + domicilio + "', ";
        }
        if (localidad != null) {
            actualizacion = actualizacion + "localidad='" + localidad + "', ";
        }
        if (codPostal != null) {
            actualizacion = actualizacion + "codigoPostal=" + codPostal + ", ";
        }
        if (provincia != null) {
            actualizacion = actualizacion + "provincia='" + provincia + "', ";
        }
        if (colegio != null) {
            actualizacion = actualizacion + "colegio='" + colegio + "', ";
        }
        if (nombrePadre != null) {
            actualizacion = actualizacion + "nombrePadre='" + nombrePadre + "', ";
        }
        if (nombreMadre != null) {
            actualizacion = actualizacion + "nombreMadre='" + nombreMadre + "', ";
        }
        if (telFijo != null) {
            actualizacion = actualizacion + "telFijo=" + telFijo + ", ";
        }
        if (telMovil != null) {
            actualizacion = actualizacion + "telMovil=" + telMovil + ", ";
        }
        if (email != null) {
            actualizacion = actualizacion + "email='" + email + "', ";
        }
        if (observaciones != null) {
            actualizacion = actualizacion + "observaciones='" + observaciones + "', ";
        }
        if (tallaAlumno != null) {
            actualizacion = actualizacion + "talla='" + tallaAlumno + "', ";
        }
        actualizacion = actualizacion.substring(0, actualizacion.length() - 2);
        actualizacion = actualizacion + " WHERE idAlumno=" + idAlumno;
        try {
            accesoBD.ejecutaActualizacion(actualizacion);
            System.out.print("\nModificado act\n " + actualizacion);
        } catch (SQLException ex) {
            exito = false;
        }
        return exito;
    }

    /**
     * Método que elimina un alumno de la BD.
     *
     * @param accesoBD Conexión con la BD.
     * @param alumnoNuevo Alumno a eliminar.
     */
    public static void eliminaAlumnoBD(BaseDatos accesoBD, Alumno alumnoNuevo) {

        String selId = "SELECT a.idAlumno FROM alumno a WHERE a.nombre='" + alumnoNuevo.getNombre() + "' AND a.primerApellido='"
                + alumnoNuevo.getPrimerApellido() + "' AND a.segundoApellido='" + alumnoNuevo.getSegundoApellido() + "' AND a.nombrePadre='"
                + alumnoNuevo.getNombrePadre() + "' AND a.nombreMadre='" + alumnoNuevo.getNombreMadre() + "' ";
        if (alumnoNuevo.getCuentaCorriente() != null) {
            selId = selId + " AND a.numeroCuenta='" + alumnoNuevo.getCuentaCorriente() + "' ";
        }
        if (alumnoNuevo.getTelMovil() != 0) {
            selId = selId + " AND a.telMovil=" + alumnoNuevo.getTelMovil() + " ";
        }
        if (alumnoNuevo.getTelFijo() != 0) {
            selId = selId + " AND a.telFijo=" + alumnoNuevo.getTelFijo() + " ";
        }
        if (alumnoNuevo.getEmail() != null) {
            selId = selId + " AND a.email='" + alumnoNuevo.getEmail() + "' ";
        }

        ResultSet retset;
        try {
            retset = accesoBD.ejecutaConsulta(selId);
            if (retset.next()) {
                alumnoNuevo.setIdAlumno(retset.getInt("idAlumno"));
            }
        } catch (SQLException ex) {
            System.out.print(ex.getMessage());
        }

        // Se elimina toda información relacionada con el alumno.
        String delete1 = "delete from alumnoGrupo where alumnoGrupo.alumno_idalumno= " + alumnoNuevo.getIdAlumno();
        String delete2 = "delete from alumnoEquipo where alumnoEquipo.alumno_idalumno= " + alumnoNuevo.getIdAlumno();
        String delete3 = "delete from alumnoTemporada where alumnoTemporada.alumno_idalumno= " + alumnoNuevo.getIdAlumno();
        String delete4 = "delete from pagoActividades where pagoActividades.alumno_idalumno= " + alumnoNuevo.getIdAlumno();
        String delete5 = "DELETE FROM alumno WHERE alumno.idAlumno = " + alumnoNuevo.getIdAlumno();

        try {
            accesoBD.ejecutaActualizacion(delete1);
            accesoBD.ejecutaActualizacion(delete2);
            accesoBD.ejecutaActualizacion(delete3);
            accesoBD.ejecutaActualizacion(delete4);
            accesoBD.ejecutaActualizacion(delete5);
        } catch (SQLException ex) {
            Logger.getLogger(AccesoBDAlumno.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Método que devuelve las estadísticas de un alumno.
     * @param accesoBD Conexión con la BD.
     * @param nombre Nombre.
     * @param apellido1 Primer apellido.
     * @param apellido2 Segundo apellido.
     * @param numCuenta Número de cuenta.
     * @return Conjunto de datos.
     * @throws SQLException Excepción que se lanza cuando hay un problema con la
     * BD.
     */
    public static ResultSet buscarEstadisticas(BaseDatos accesoBD, String nombre, String apellido1, String apellido2, String numCuenta) throws SQLException {
        // Se busca el identificador del alumno
        String consulta = "SELECT idAlumno FROM Alumno "
                + "WHERE nombre='" + nombre + "' AND primerApellido='" + apellido1 + "' AND segundoApellido='" + apellido2 + "'"
                + " AND numeroCuenta='" + numCuenta + "'";
        ResultSet rst = accesoBD.ejecutaConsulta(consulta);

        if (!rst.next()) {
            return null;
        } else {
            // Se buscan con el sus estadísticas.
            int idAlumno = rst.getInt(1);
            consulta = "SELECT p.idEquipo, p.idEquipoVisitante, e.asistencias, e.rebotesOfensivos, e.rebotesDefensivos, e.robos, e.perdidas, e.puntos FROM "
                    + "EstadisticaAlumno e, partido p "
                    + "WHERE e.alumno_idAlumno='" + idAlumno + "' AND e.partido_idPartido=p.idPartido";
            rst = accesoBD.ejecutaConsulta(consulta);

            if (!rst.next()) {
                return null;
            } else {
                rst.beforeFirst();
                return rst;
            }
        }
    }
}
