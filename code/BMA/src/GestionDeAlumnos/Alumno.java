package GestionDeAlumnos;

import java.util.Calendar;

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
 * Classe que se empareja y guarda los datos de los alumnos.
 *
 * @author Compu-global-Hiper-mega-Net
 */
public class Alumno {

    private int idAlumno;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private Calendar fechaNacimiento;
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

    /**
     * Constructor protegido del alumno.
     *
     * @param nombre Nombre del alumno.
     * @param primerApellido Primer apellido.
     * @param segundoApellido Segundo apellido.
     * @param fechaNac Fecha de nacimiento.
     * @param cuentaCorriente Cuenta corriente.
     * @param domicilio Residencia habitual.
     * @param localidad Localidad.
     * @param codPostal Codigo postal.
     * @param provincia Provincia.
     * @param colegio Colegio donde el alumno está matriculado.
     * @param nombrePadre Nombre del padre.
     * @param nombreMadre Nombre de la madre.
     * @param telFijo Teléfono fijo.
     * @param telMovil Teléfono movil.
     * @param email Correo electrónico.
     * @param observaciones Observaciones.
     * @param tallaAlumno Talla de topa.
     * @param sexo Sexo.
     */
    Alumno(String nombre, String primerApellido, String segundoApellido, Calendar fechaNac,
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
        this.sexo = sexo;
    }

    /**
     * Constructor público de la clase.
     *
     * @param nombre Nombre del alumno.
     * @param primerApellido Primer apellido.
     * @param segundoApellido Segundo apellido.
     * @param fechaNac Fecha de nacimiento.
     * @param cuentaCorriente Cuenta corriente.
     * @param domicilio Residencia habitual.
     * @param localidad Localidad.
     * @param codPostal Codigo postal.
     * @param provincia Provincia.
     * @param colegio Colegio donde el alumno está matriculado.
     * @param nombrePadre Nombre del padre.
     * @param nombreMadre Nombre de la madre.
     * @param telFijo Teléfono fijo.
     * @param telMovil Teléfono movil.
     * @param email Correo electrónico.
     * @param observaciones Observaciones.
     * @param tallaAlumno Talla de topa.
     * @param sexo Sexo.
     * @return Devuelve el alumno.
     */
    public static Alumno crearAlumno(String nombre, String primerApellido, String segundoApellido, Calendar fechaNac,
            String cuentaCorriente, String domicilio, String localidad, int codPostal, String provincia, String colegio,
            String nombrePadre, String nombreMadre, int telFijo, int telMovil, String email, String observaciones, String tallaAlumno, char sexo) {
        return new Alumno(nombre, primerApellido, segundoApellido, fechaNac,
                cuentaCorriente, domicilio, localidad, codPostal, provincia, colegio,
                nombrePadre, nombreMadre, telFijo, telMovil, email, observaciones, tallaAlumno, sexo);
    }

    /**
     * Método para pedir el identificador de un alumno.
     *
     * @return Un entero representando el idetificador.
     */
    public int getIdAlumno() {
        return idAlumno;
    }

    /**
     * Método para averiguar el género de un alumno.
     *
     * @return Un carácter (M o F)
     */
    public char getSexo() {
        return this.sexo;
    }

    /**
     * Método que guarda el identificador de un alumno.
     *
     * @param id Identificador del alumno.
     */
    public void setIdAlumno(int id) {
        this.idAlumno = id;
    }

    /**
     * Método para averiguar el nombre del alumno.
     *
     * @return Un string con el nombre.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método para pedir el primer apellido del alumno.
     *
     * @return Un string con el primer apellido.
     */
    public String getPrimerApellido() {
        return primerApellido;
    }

    /**
     * Método para pedir el segundo apellido del alumno.
     *
     * @return Un string con el segundo apellido.
     */
    public String getSegundoApellido() {
        return segundoApellido;
    }

    /**
     * Método para padir la fecha de nacimiento del alumno.
     *
     * @return Un Calendar con la fecha.
     */
    public Calendar getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Método para saber la cuenta corriente actual.
     *
     * @return Un String con la cuenta.
     */
    public String getCuentaCorriente() {
        return cuentaCorriente;
    }

    /**
     * Método para descubrir el domicilio del alumno.
     *
     * @return Un String.
     */
    public String getDomicilio() {
        return domicilio;
    }

    /**
     * Método que descubre la localidad del alumno.
     *
     * @return Un String.
     */
    public String getLocalidad() {
        return localidad;
    }

    /**
     * Método que descubre el código postal del alumno.
     * @return Un Entero.
     */
    public int getCodPostal() {
        return codPostal;
    }

    /**
     * Método que descubre la provincia del alumno.
     * @return Un String.
     */
    public String getProvincia() {
        return provincia;
    }

    /**
     * Método que descubre la colegio del alumno.
     * @return Un String.
     */
    public String getColegio() {
        return colegio;
    }

    /**
     * Método que descubre el nombre del padre del alumno.
     * @return Un String.
     */
    public String getNombrePadre() {
        return nombrePadre;
    }

    /**
     * Método que descubre el nombre de la madre del alumno.
     * @return Un String.
     */
    public String getNombreMadre() {
        return nombreMadre;
    }

    /**
     * Método que descubre el teléfono fijo del alumno.
     * @return Un Entero.
     */
    public int getTelFijo() {
        return telFijo;
    }

    /**
     * Método que descubre el teléfono movil del alumno.
     * @return Un Entero.
     */
    public int getTelMovil() {
        return telMovil;
    }

    /**
     * Método que descubre el correo electrónico del alumno.
     * @return Un String.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Método que descubre las observaciones del alumno.
     * @return Un String.
     */
    public String getObservaciones() {
        return observaciones;
    }

    /**
     * Método que descubre la talla del alumno.
     * @return Un String.
     */
    public String getTallaAlumno() {
        return tallaAlumno;
    }
}
