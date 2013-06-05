package GestionDeAlumnos;

import ServiciosAlmacenamiento.BaseDatos;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa al alumno y sus datos personales, además de los nombres
 * del padre y la madre.
 *
 * @author Alex Moreno
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

public class GestorAlumnos {

    public static boolean darAltaAlumno(BaseDatos accesoBD, String nombre, String primerApellido, String segundoApellido, java.util.Date fechaNac,
                    String cuentaCorriente, String domicilio, String localidad, int codPostal, String provincia, String colegio,
                    String nombrePadre, String nombreMadre, int telFijo, int telMovil, String email, String observaciones, String tallaAlumno, String sexo){
        
        char aux;
        if(sexo.equals("Masculino")){
            aux='M';
        }else
            aux='F';
        Alumno alumno = Alumno.crearAlumno(nombre, primerApellido, segundoApellido, fechaNac,
                cuentaCorriente, domicilio, localidad, codPostal, provincia, colegio,
                nombrePadre, nombreMadre, telFijo, telMovil, email, observaciones, tallaAlumno, aux);
        boolean exito = true;
        try {
            AccesoBDAlumno.insertarAlumnoBD(accesoBD, alumno);
        } catch (SQLException ex) {
            exito = false;
        }
        return exito;
    }
    public static ResultSet consultarAlumno(BaseDatos accesoBD, String consulta){
        AccesoBDAlumno alumno=new AccesoBDAlumno();
        
        return alumno.consultaAlumnoBD(accesoBD, consulta);
    }
    
    public static boolean modificarDatos(BaseDatos accesoBD, String idAlumno, String nombre, String primerApellido, String segundoApellido, String fechaNac,
            String cuentaCorriente, String domicilio, String localidad, String codPostal, String provincia, String colegio,
            String nombrePadre, String nombreMadre, String telFijo, String telMovil, String email, String observaciones, String tallaAlumno) {
        
        return AccesoBDAlumno.modificarDatosAlumno(accesoBD, idAlumno, nombre, primerApellido, segundoApellido, fechaNac,
            cuentaCorriente, domicilio, localidad, codPostal, provincia, colegio,
            nombrePadre, nombreMadre, telFijo, telMovil, email, observaciones, tallaAlumno);
    }
    public static void eliminaAlumno(BaseDatos accesoBD, String nombre, String primerApellido, String segundoApellido, java.util.Date fechaNac,
            String cuentaCorriente, String domicilio, String localidad, int codPostal, String provincia, String colegio,
            String nombrePadre, String nombreMadre, int telFijo, int telMovil, String email, String observaciones, String tallaAlumno, char sexo){
        
        AccesoBDAlumno alumnoBD=new AccesoBDAlumno();
        Alumno alumnoEliminado = Alumno.crearAlumno(nombre, primerApellido, segundoApellido, fechaNac,
                cuentaCorriente, domicilio, localidad, codPostal, provincia, colegio,
                nombrePadre, nombreMadre, telFijo, telMovil, email, observaciones, tallaAlumno, sexo);
        alumnoBD.eliminaAlumnoBD(accesoBD, alumnoEliminado);
    }

    public static List<String> getAlumnos(BaseDatos accesoBD, String s) throws SQLException {
        List<String> als = new ArrayList<String>();
        als = AccesoBDAlumno.getListaAlumnos(accesoBD, s);
        
        return als;
    }
    
    public static List<String> getNombreAl(BaseDatos accesoBD, List<Integer> listaAlumnos) throws SQLException {
        List<String> listanomAl = new ArrayList<String>();
        listanomAl = AccesoBDAlumno.getNombreAl(accesoBD, listaAlumnos);

        return listanomAl;
    }

    public static List<Integer> getIdAl(BaseDatos accesoBD, List<String> listaAlumnos) throws SQLException {
        List<Integer> listaIDAl = new ArrayList<Integer>();
        listaIDAl = AccesoBDAlumno.getIdAl(accesoBD, listaAlumnos);
        
        return listaIDAl;
    }

    public static int getIdAl(BaseDatos accesoBD, String alumno) throws SQLException {
        return AccesoBDAlumno.getIdAl(accesoBD, alumno);
    }

    public static List<String> getAlumnosSinGrupo(BaseDatos accesoBD, String s) throws SQLException {
        List<String> als = new ArrayList<String>();
        als = AccesoBDAlumno.getListaAlumnosSinGrupo(accesoBD, s);
        
        return als;
    }
    
    
    //***************************************JAVI******************************************************//  
     public static ResultSet consultarEstadisticasAlumno(BaseDatos accesoBD, String nombre, String apellido1, String apellido2, String numCuenta) throws SQLException {
         
        return AccesoBDAlumno.buscarEstadisticas(accesoBD, nombre, apellido1, apellido2, numCuenta);  
    }
   //***************************************JAVI******************************************************//     
}
