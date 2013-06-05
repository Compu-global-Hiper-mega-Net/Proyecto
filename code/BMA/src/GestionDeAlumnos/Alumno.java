/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionDeAlumnos;

import java.util.Date;

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

public class Alumno {

    private int idAlumno;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private Date fechaNacimiento;
    private String cuentaCorriente;
    private String domicilio;
    private String localidad;
    private int codPostal;
    private String provincia;
    private String colegio;
    private String nombrePadre;
    private String nombreMadre;
    private int telFijo;
    private int telMovil;
    private String email;
    private String observaciones;
    private String tallaAlumno;
    private char sexo;

    public Alumno(){
        
    }
    
    Alumno(String nombre, String primerApellido, String segundoApellido, java.util.Date fechaNac,
            String cuentaCorriente, String domicilio, String localidad, int codPostal, String provincia, String colegio,
            String nombrePadre, String nombreMadre, int telFijo, int telMovil, String email, String observaciones, String tallaAlumno, char sexo) {
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.fechaNacimiento = fechaNac;
        this.cuentaCorriente = cuentaCorriente;
        this.domicilio = domicilio;
        this.localidad = localidad;
        this.codPostal = codPostal;
        this.provincia = provincia;
        this.colegio = colegio;
        this.nombrePadre = nombrePadre;
        this.nombreMadre = nombreMadre;
        this.email = email;
        this.telFijo = telFijo;
        this.telMovil = telMovil;
        this.tallaAlumno = tallaAlumno;
        this.sexo=sexo;
    }

    public static Alumno crearAlumno(String nombre, String primerApellido, String segundoApellido, Date fechaNac,
            String cuentaCorriente, String domicilio, String localidad, int codPostal, String provincia, String colegio,
            String nombrePadre, String nombreMadre, int telFijo, int telMovil, String email, String observaciones, String tallaAlumno, char sexo) {
        return new Alumno(nombre, primerApellido, segundoApellido, fechaNac,
                cuentaCorriente, domicilio, localidad, codPostal, provincia, colegio,
                nombrePadre, nombreMadre, telFijo, telMovil, email, observaciones, tallaAlumno, sexo);
    }

    public int getIdAlumno() {
        return idAlumno;
    }
    public char getSexo(){
        return this.sexo;
    }
    public void setIdAlumno(int id) {
        this.idAlumno = id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public java.util.Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getCuentaCorriente() {
        return cuentaCorriente;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public String getLocalidad() {
        return localidad;
    }

    public int getCodPostal() {
        return codPostal;
    }

    public String getProvincia() {
        return provincia;
    }

    public String getColegio() {
        return colegio;
    }

    public String getNombrePadre() {
        return nombrePadre;
    }

    public String getNombreMadre() {
        return nombreMadre;
    }

    public int getTelFijo() {
        return telFijo;
    }

    public int getTelMovil() {
        return telMovil;
    }

    public String getEmail() {
        return email;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public String getTallaAlumno() {
        return tallaAlumno;
    }
}
