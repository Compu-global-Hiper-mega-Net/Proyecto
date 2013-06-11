package GestionDeTemporadas;

import GestionActividades.Actividad;
import GestionDeAlumnos.Alumno;
import GestionDeEquipos.Equipo;
import GestionDeGrupos.Grupo;
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
 * Clase que representa una temporada, que contendrá una fecha de inicio y de fin 
 * de curso y un importe mensual.
 *
  */
public class Temporada {

    private int idTemporada;
    private String curso;
    private String fechaInicio;
    private String fechaFin;
    private double importeMensual;
    
    private List<Equipo> equipos;
    private List<Actividad> actividades;
    private List<Grupo> grupos;
    
    private List<Alumno> alumnos;
    
    /**
     * Constructor de la clase Temporada.
     * @param c Contiene el curso de la temporada.
     */
    public Temporada(String c){
        curso = c;
    }

    /**
     * Contructor de la clase temporada que permite insertar todos los parametros 
     * de temporada.
     * @param curso Contiene el curso de la temporada.
     * @param inicio Contiene la fecha de inicio del curso.
     * @param fin Contiene la fecha de finalizacion del curso.
     * @param importe Contiene la cantidad que se ha de pagar cada mensualidad.
     */
    public Temporada(int curso, String inicio, String fin, double importe) {
        this.curso = Integer.toString(curso);
        this.fechaInicio = inicio;
        this.fechaFin = fin;
        this.importeMensual = importe;
    }

    /**
     * Permite obtener el curso de una temporada.
     * @return Un <code>String</code> con el curso de la temporada.
     */
    public String getCurso() {
        return curso;
    }

    
    //public String getTemporada() {
      //  return curso;
    //}

    
    /**
     * Permite establecer el identificador de la temporada.
     * @param idTemp Contiene el identificador de la temporada que queremos 
     * establecer.
     */
    public void setIdTemporada(int idTemp) {
        this.idTemporada = idTemp;
    }

    /**
     * Permite establecer el curso de una temporada especificado de manera 
     * completa ("anio/anio+1")
     * @param cursoComp Contiene la cadena con el curso expresado de manera completa.
     */
    public void setCursoCompleto(String cursoComp) {
        this.curso = cursoComp;
    }

    /**
     * Permite obtener la fecha de inicio de una temporada.
     * @return Un <code>String</code> con la fecha de inicio de la temporada.
     */
    public String getInicio() {
        return this.fechaInicio;
    }
    
    /**
     * Permite obtener la fecha de fin de una temporada.
     * @return Un <code>String</code> con la fecha de fin de la temporada.
     */
    public String getFin() {
        return this.fechaFin;
    }

    /**
     * Permite obtener el importe que se ha de pagar mensualmente como cuota.
     * @return Un <code>double</code> con el importe mensual.
     */
    public double getImporte() {
        return this.importeMensual;
    }
    
    /**
     * Permite obtener el identificador de la temporada actual
     * @return int devuelve un tipo int (entero) que contiene el identificador
     * de la temporada actual.
     */

    public int getIdTemporada() {
        return this.idTemporada;
    }
    
    
}
