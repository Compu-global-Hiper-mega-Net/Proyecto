package GestionActividades;

import java.util.Date;



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
 * Clase que representa las actividades que se realizan en una temporada que no
 * tienen relación con las temporadas en si, como Campus de Semana Santa.
 *
 * @author Jesús Manuel Contreras Siles
 * @version 1.0
 */

public class Actividad {

    private int idActividad;
    private String descripcion;
    private int nAlumnos;
    private float precioSocio;
    private float precioNoSocio;
    private int idTemporada;
    private Date fechaInicio;
    private Date fechaFin;
    private String nombre;

		/**
		 * Constructor de la clase
		 * @param descripcion String (cadena) con la descripcion de la actividad
		 * @param precioSocio  float (flotante) con el costo de la actividad para los socios.
		 * @param precioNoSocio float (flotante) con el costo de la actividad para los no socios.
		 * @param nAlumno int (entero) con el numero de alumnos.
		 * @param idTemporada int (entero) con el id de la temporada a la que pertenece la actividad.
		 * @param fechaInicio Date (fecha) con la fecha de inicio de la actividad.
		 * @param fechaFin Date (fecha) con la fecha de finalizacion de la actividad.
		 * @param nombre String (cadena) con el nombre de la actividad.
		 */    

    Actividad(String descripcion, int nAlumnos, float precioSocio, float precioNoSocio, int idTemporada, Date fechaInicio, Date fechaFin, String nombre) {

        this.descripcion = descripcion;
        this.precioSocio = precioSocio;
        this.nAlumnos = nAlumnos;
        this.precioNoSocio = precioNoSocio;
        this.idTemporada = idTemporada;
        this.fechaFin = fechaFin;
        this.fechaInicio = fechaInicio;
        this.nombre = nombre;

    }

		/**
		 * Metodo constructor
		 * @param descripcion String (cadena) con la descripcion de la actividad
		 * @param precioSocio  float (flotante) con el costo de la actividad para los socios.
		 * @param precioNoSocio float (flotante) con el costo de la actividad para los no socios.
		 * @param nAlumno int (entero) con el numero de alumnos.
		 * @param idTemporada int (entero) con el id de la temporada a la que pertenece la actividad.
		 * @param fechaInicio Date (fecha) con la fecha de inicio de la actividad.
		 * @param fechaFin Date (fecha) con la fecha de finalizacion de la actividad.
		 * @param nombre String (cadena) con el nombre de la actividad.
		 * @return Actividad (actividad) con el atributo interno de una actividad.
		 */    

    
    public static Actividad creaActividad(String descripcion, int nAlumnos, float precioSocio, float precioNoSocio, int idTemporada, Date fechaInicio, Date fechaFin, String nombre) {

        return new Actividad(descripcion, nAlumnos, precioSocio, precioNoSocio, idTemporada, fechaInicio, fechaFin, nombre);
    }

    public Actividad(String actividad) {
        nombre=actividad;
    }

		/**
		 * Metodo consultor
		 * @return int (entero) con el atributo interno del id de la actividad.
		 */
    
    public int getIdActividad() {
        return this.idActividad;
    }

		/**
		 * Metodo constructor
		 * @param id int (entero) con el id de una instalacion.
		 */

    public void setIdActividad(int id) {
        this.idActividad = id;
    }

		/**
		 * Metodo consultor
		 * @return String (cadena) con el atributo interno de la descripción de una actividad.
		 */

    public String getDescripcion() {
        return this.descripcion;
    }

		/**
		 * Metodo constructor
		 * @param desc String (cadena) con la descripción de una instalacion.
		 */

    public void setDescripcion(String desc) {
        this.descripcion = desc;
    }

		/**
		 * Metodo consultor
		 * @return int (entero) con el atributo interno del numero de alumnos.
		 */

    public int getNAlumnos() {
        return this.nAlumnos;
    }

		/**
		 * Metodo constructor
		 * @param n int (entero) con el numero de alumnos de una actividad.
		 */

    public void setNAlumnos(int n) {
        this.nAlumnos = n;
    }

		/**
		 * Metodo consultor
		 * @return float (flotante) con el atributo interno del precio de la actividad para los socios.
		 */

    public float getPrecioSocio() {
        return this.precioSocio;
    }

		/**
		 * Metodo constructor
		 * @param precio float (flotante) con el precio de la actividad para los socios.
		 */

    public void setPrecioSocio(float precio) {
        this.precioSocio = precio;
    }

		/**
		 * Metodo consultor
		 * @return float (flotante) con el atributo interno del precio de la actividad para los no socios.
		 */

    public float getPrecioNoSocio() {
        return this.precioNoSocio;
    }

		/**
		 * Metodo constructor
		 * @param precio float (flotante) con el precio de la actividad para los no socios.
		 */

    public void setPrecioNoSocio(float precio) {
        this.precioNoSocio = precio;
    }

		/**
		 * Metodo consultor
		 * @return int (entero) con el atributo interno del identificador de la temporada a la que pertenece la actividad.
		 */

    public int getIdTemporada() {
        return this.idTemporada;
    }

		/**
		 * Metodo constructor
		 * @param id int (entero) con el identificador de la temporada a la que pertenece la actividad.
		 */

    public void setIdTemporada(int id) {
        this.idTemporada = id;
    }

		/**
		 * Metodo consultor
		 * @return Date (fecha) con el atributo interno de la fecha de inicio de la actividad.
		 */

    public Date getFechaInicio() {
        return this.fechaInicio;
    }

		/**
		 * Metodo constructor
		 * @return fecha Date (fecha) con la fecha de inicio de la actividad.
		 */

    public void setFechaInicio(Date fecha) {
        this.fechaInicio = fecha;
    }

		/**
		 * Metodo consultor
		 * @return Date (fecha) con el atributo interno de la fecha de finalizacion de la actividad.
		 */

    public Date getFechaFin() {
        return this.fechaFin;
    }

		/**
		 * Metodo constructor
		 * @return fecha Date (fecha) con la fecha de finalizacion de la actividad.
		 */

    public void setFechaFin(Date fecha) {
        this.fechaFin = fecha;
    }
    
		/**
		 * Metodo consultor
		 * @return String (cadena) con el atributo interno del nombre de la actividad.
		 */
		
    public String getNombre(){
        return this.nombre;
    }

		/**
		 * Metodo constructor
		 * @param nombre String (cadena) con el nombre de la actividad.
		 */
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
}
