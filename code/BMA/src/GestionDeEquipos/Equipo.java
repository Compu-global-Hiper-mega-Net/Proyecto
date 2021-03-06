/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionDeEquipos;

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
 * Clase Equipo que se encargará de crear un equipo
 *
 * @author Jesús Manuel Contreras Siles
 * @version 1.0
 */
public class Equipo {

    private String nombre;
    private String temporada;
    private String categoria;
    private boolean Fundacion;
    private String entrenador;
    private String entrenador2;
    private String sexo;

    /**
     * Metodo constructor
     * @param Nombre, nombre del equipo. 
     * @param temporada, temporada en la que se inscribe el equipo.
     * @param categoria, categoria a la que pertenece.
     * @param entrandor, el cual se corresponde con el nombre del primer entrenador. 
     * @param entrenador2, se corresponde con el nombre del segundo entrenador. 
     * fundación, este parámetro determina si pertenece a la fundación.
     * @param sexo, determina el sexo de los componentes del equipo.
     */
    
    public Equipo(String nombre, String temporada, String categoria, String entrenador, String entrenador2, boolean fundacion, String sexo) {
        this.nombre = nombre;
        this.temporada = temporada;
        this.categoria = categoria;
        this.entrenador = entrenador;
        this.entrenador2 = entrenador2;
        this.Fundacion = fundacion;
        this.sexo = sexo;
    }

    /**
     * Metodo consultor
     * @return String (cadena) con el atributo interno del nombre del equipo.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo consultor
     * @return String (cadena) con el atributo interno del temporada del equipo
     */
    public String getTemporada() {
        return temporada;
    }

    /**
     * Metodo consultor
     * @return String (cadena) con el atributo interno del categoria del equipo.
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * Metodo consultor
     * @return String (cadena) con el atributo interno del nombre del entrenador que dirige el equipo.
     */
    public String getEntrenador() {
        return entrenador;
    }

    /**
     * Metodo consultor
     * @return String (cadena) con el atributo interno del nombre del segundo entrenador.
     */
    public String getEntrenador2() {
        return entrenador2;
    }

    /**
     * Metodo consultor
     * @return boolean (lógico) con el atributo interno de la comprobación de si pertenece o no a la fundación.
     */
    public boolean getFundacion() {
        return Fundacion;
    }

    /**
     * Metodo consultor
     * @return char (caracter) con el atributo interno del sexo del equipo.
     */
    public String getSexo() {
        return sexo;
    }
}
