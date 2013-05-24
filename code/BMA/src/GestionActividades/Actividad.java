package GestionActividades;

import java.util.Date;

/**
 * Clase que representa las actividades que se realizan en una temporada que no
 * tienen relación con las temporadas en si, como Campus de Semana Santa.
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

    public Actividad(String nombre){
        this.nombre = nombre;
    }
    
    public static Actividad creaActividad(String descripcion, int nAlumnos, float precioSocio, float precioNoSocio, int idTemporada, Date fechaInicio, Date fechaFin, String nombre) {

        return new Actividad(descripcion, nAlumnos, precioSocio, precioNoSocio, idTemporada, fechaInicio, fechaFin, nombre);
    }
    
    public int getIdActividad() {
        return this.idActividad;
    }

    public void setIdActividad(int id) {
        this.idActividad = id;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String desc) {
        this.descripcion = desc;
    }

    public int getNAlumnos() {
        return this.nAlumnos;
    }

    public void setNAlumnos(int n) {
        this.nAlumnos = n;
    }

    public float getPrecioSocio() {
        return this.precioSocio;
    }

    public void setPrecioSocio(float precio) {
        this.precioSocio = precio;
    }

    public float getPrecioNoSocio() {
        return this.precioNoSocio;
    }

    public void setPrecioNoSocio(float precio) {
        this.precioNoSocio = precio;
    }

    public int getIdTemporada() {
        return this.idTemporada;
    }

    public void setIdTemporada(int id) {
        this.idTemporada = id;
    }

    public Date getFechaInicio() {
        return this.fechaInicio;
    }

    public void setFechaInicio(Date fecha) {
        this.fechaInicio = fecha;
    }

    public Date getFechaFin() {
        return this.fechaFin;
    }

    public void setFechaFin(Date fecha) {
        this.fechaFin = fecha;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
}