package GestionDeAlumnos;

import ServiciosAlmacenamiento.BaseDatos;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
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
 * Clase que maneja todas las operaciones con los alumnos.
 *
 * @author Compu-global-Hiper-mega-Net
 */
public class GestorAlumnos {

    /**
     * Da de alta un alumno en el sistema.
     *
     * @param accesoBD Conexión con la BD.
     * @param nombre Nombre de pila.
     * @param primerApellido Primer apellido.
     * @param segundoApellido Segundo apellido.
     * @param fechaNac Fecha de nacimiento.
     * @param cuentaCorriente Cuenta correite.
     * @param domicilio Residencia habitual.
     * @param localidad Localidad.
     * @param codPostal Código postal.
     * @param provincia Provincia.
     * @param colegio Colegio donde está escolarizado.
     * @param nombrePadre Nombre del padre.
     * @param nombreMadre Nombre de la madre.
     * @param telFijo Teléfono fijo.
     * @param telMovil Teléfono móvil.
     * @param email Correo electrónico.
     * @param observaciones Observaciones.
     * @param tallaAlumno Talla de vestir.
     * @param sexo Sexo.
     * @return Devuelve un booleano indicando si la operación se ha realizado
     * correctamente.
     */
    public static boolean darAltaAlumno(BaseDatos accesoBD, String nombre,
            String primerApellido, String segundoApellido, Calendar fechaNac,
            String cuentaCorriente, String domicilio, String localidad, int codPostal,
            String provincia, String colegio, String nombrePadre, String nombreMadre,
            int telFijo, int telMovil, String email, String observaciones,
            String tallaAlumno, String sexo) {

        char aux;
        if (sexo.equals("Masculino")) {
            aux = 'M';
        } else {
            aux = 'F';
        }

        // Se creal el alumno
        Alumno alumno = Alumno.crearAlumno(nombre, primerApellido, segundoApellido, fechaNac,
                cuentaCorriente, domicilio, localidad, codPostal, provincia, colegio,
                nombrePadre, nombreMadre, telFijo, telMovil, email, observaciones, tallaAlumno, aux);

        boolean exito = true;
        try {
            // Se inserta el alumno el la BD
            AccesoBDAlumno.insertarAlumnoBD(accesoBD, alumno);
        } catch (SQLException ex) {
            exito = false;
        }
        return exito;
    }

    /**
     * Método para realizar consultas a la BD.
     *
     * @param accesoBD Conexión de la BD.
     * @param consulta Consulta a realizar.
     * @return Devuelve el resultado de la consulta.
     */
    public static ResultSet consultarAlumno(BaseDatos accesoBD, String consulta) {
        return AccesoBDAlumno.consultaAlumnoBD(accesoBD, consulta);
    }

    /**
     * Método para modificar os datos de un alumno.
     *
     * @param accesoBD Conexión con la BD.
     * @param idAlumno Identificador del alumno.
     * @param nombre Nombre de pila.
     * @param primerApellido Primer apellido.
     * @param segundoApellido Segundo apellido.
     * @param fechaNac Fecha de nacimiento.
     * @param cuentaCorriente Cuenta correite.
     * @param domicilio Residencia habitual.
     * @param localidad Localidad.
     * @param codPostal Código postal.
     * @param provincia Provincia.
     * @param colegio Colegio donde está escolarizado.
     * @param nombrePadre Nombre del padre.
     * @param nombreMadre Nombre de la madre.
     * @param telFijo Teléfono fijo.
     * @param telMovil Teléfono móvil.
     * @param email Correo electrónico.
     * @param observaciones Observaciones.
     * @param tallaAlumno Talla de vestir.
     * @param sexo Sexo.
     * @return Devuelve un booleano indicando si la operación se ha realizado
     * correctamente.
     */
    public static boolean modificarDatos(BaseDatos accesoBD, String idAlumno, String nombre, String primerApellido, String segundoApellido, String fechaNac,
            String cuentaCorriente, String domicilio, String localidad, String codPostal, String provincia, String colegio,
            String nombrePadre, String nombreMadre, String telFijo, String telMovil, String email, String observaciones, String tallaAlumno, String sexo) {

        return AccesoBDAlumno.modificarDatosAlumno(accesoBD, idAlumno, nombre, primerApellido, segundoApellido, fechaNac,
                cuentaCorriente, domicilio, localidad, codPostal, provincia, colegio, sexo,
                nombrePadre, nombreMadre, telFijo, telMovil, email, observaciones, tallaAlumno);
    }

    /**
     * Método que se utiliza para eliminar un alumno del sistema.
     *
     * @param accesoBD Conexión con la BD.
     * @param idAlumno Id del alumno a eliminar.
     */
    public static void eliminaAlumno(BaseDatos accesoBD, int idAlumno) {
        AccesoBDAlumno.eliminaAlumnoBD(accesoBD, idAlumno);
    }

    /**
     * Método para obtener una lista de alumnos según un criterio en el primer
     * apellido.
     *
     * @param accesoBD Conexión con la BD.
     * @param s Palabra que buscaremos en el primer apellido para encontrar a
     * los alumnos que coincidan con ella.
     * @return Devuelve la lista de alumnos que contienen la palabra ese en su
     * primer apellido.
     * @throws SQLException Excepción que se lanza cuando hay un problema con la
     * BD.
     */
    public static List<String> getAlumnos(BaseDatos accesoBD, String s) throws SQLException {
        return AccesoBDAlumno.getListaAlumnos(accesoBD, s);
    }

    /**
     * Método para obtener el nombre completo de los alumnos de una lista de ids
     * de alumnos.
     *
     * @param accesoBD Conexión con la BD.
     * @param listaAlumnos Ids de los alumnos.
     * @return Devuelve una lista de nombres de alumnos.
     * @throws SQLException Excepción que se lanza cuando hay un problema con la
     * BD.
     */
    public static List<String> getNombreAl(BaseDatos accesoBD, List<Integer> listaAlumnos) throws SQLException {
        return AccesoBDAlumno.getNombreAl(accesoBD, listaAlumnos);
    }

    /**
     * Método para obtener el id de los alumnos de una lista de nombres
     * completos de alumnos.
     *
     * @param accesoBD Conexión con la BD.
     * @param listaAlumnos Nombres completos de los alumnos.
     * @return Devuelve una lista de ids de alumnos.
     * @throws SQLException Excepción que se lanza cuando hay un problema con la
     * BD.
     */
    public static List<Integer> getIdAl(BaseDatos accesoBD, List<String> listaAlumnos) throws SQLException {
        return AccesoBDAlumno.getIdAl(accesoBD, listaAlumnos);
    }

    /**
     * Método para obtener el id de un alumno de su nombre completo.
     *
     * @param accesoBD Conexión con la BD.
     * @param alumno Nombre del alumno.
     * @return El id del alumno en cuestión.
     * @throws SQLException Excepción que se lanza cuando hay un problema con la
     * BD.
     */
    public static int getIdAl(BaseDatos accesoBD, String alumno) throws SQLException {
        return AccesoBDAlumno.getIdAl(accesoBD, alumno);
    }

    /**
     * Metodo para saber que alumnos no estan en ningún grupo.
     *
     * @param accesoBD Conexión con la BD.
     * @param s Criterio que se emparejara con el primer apellido de los
     * alumnos.
     * @return Una lista de nombres con los alumnos no asignados a ningún grupo.
     * @throws SQLException Excepción que se lanza cuando hay un problema con la
     * BD.
     */
    public static List<String> getAlumnosSinGrupo(BaseDatos accesoBD, String s) throws SQLException {
        return AccesoBDAlumno.getListaAlumnosSinGrupo(accesoBD, s);
    }

    /**
     * Método con el que obtener las estadisticas de un alumno.
     *
     * @param accesoBD Conexión con la BD.
     * @param idAlumno Id del alumno.
     * @return Devuelve las estadísticas del alumno especificado.
     * @throws SQLException Excepción que se lanza cuando hay un problema con la
     * BD.
     */
    public static ResultSet consultarEstadisticasAlumno(BaseDatos accesoBD, int idAlumno) throws SQLException {
        return AccesoBDAlumno.buscarEstadisticas(accesoBD, idAlumno);
    }

    public static List<String> getAlumnosCategoria(BaseDatos bd, int anio,int temporada) throws SQLException {
        System.out.print("tempo"+temporada);
        String ComprobacionMenores = "Select edadmin from categoria where "
                + "categoria.idcategoria=(select min(c.idcategoria) from categoria c)";
        String query;
        ResultSet sal = bd.ejecutaConsulta(ComprobacionMenores);
        sal.next();
        GregorianCalendar g = new GregorianCalendar();
        int edad = temporada- sal.getInt(1);//g.get(GregorianCalendar.YEAR) - sal.getInt(1);
        if (edad == anio) {
            query = "SELECT primerApellido, segundoApellido, nombre FROM "
                    + "mydb.alumno WHERE "
                    + "fechaNacimiento >'" + anio + "-1-1' ";
        } else {
            query = "SELECT primerApellido, segundoApellido, nombre FROM "
                    + "mydb.alumno WHERE "
                    + "fechaNacimiento >'" + anio + "-1-1' And fechaNacimiento <'" + (anio + 1) + "-1-1'";
        }

        ResultSet res = bd.ejecutaConsulta(query);

        List<String> listaAls = new ArrayList<String>();

        while (res.next()) {
            listaAls.add(res.getString(1) + " " + res.getString(2) + " " + res.getString(3));
        }

        return listaAls;
    }
}
