/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionDeEquipos;

import GestionDeTemporadas.Temporada;
import GestionDeUsuarios.Usuario;
import GestionDeCategorias.Categoria;

/**
 *
 * @author
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
public class Equipo {

    private int idEquipo;
    private String nombre;
    private String temporada;
    private String categoria;
    private boolean Fundacion;
    private String entrenador;
    private String entrenador2;

    public Equipo(String nombre, String temporada, String categoria, String entrenador, String entrenador2, boolean fundacion) {
        this.nombre = nombre;
        this.temporada = temporada;
        this.categoria = categoria;
        this.entrenador = entrenador;
        this.entrenador2 = entrenador2;
        this.Fundacion = fundacion;
    }

    /**
     * @return the idEquipo
     */
    public int getIdEquipo() {
        return idEquipo;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return the temporada
     */
    public String getTemporada() {
        return temporada;
    }

    /**
     * @return the categoria
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * @return the entrenador
     */
    public String getEntrenador() {
        return entrenador;
    }

    /**
     * @return the entrenador2
     */
    public String getEntrenador2() {
        return entrenador2;
    }
    
        /**
     * @return the Pertenece fundacion
     */
    public boolean getFundacion() {
        return Fundacion;
    }
}
