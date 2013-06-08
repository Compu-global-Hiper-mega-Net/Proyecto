package GestionDeInstalaciones;

import GestionDeGrupos.Grupo;
import java.util.List;

/**
 * Clase Instalacion que se encargará de crear una instalación
 * @author Jesus Manuel Contreras Siles
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


public class Instalacion {
    private int capacidadEquipos;
    private int idInstalacion;
    private String localizacion;
    private String nombre;
    
    /*
		 * Metodo constructor
		 * @param nombre de la instalación.
		 * @param capacidadEquipos valida para la instalación.
		 * @param localizacion de la instalación.
		 */
    
    public Instalacion(String nombre, int capacidadEquipos,
            String localizacion){
        

        this.nombre = nombre;
        this.capacidadEquipos = capacidadEquipos;
        this.localizacion = localizacion;
    }
    
		/*
		 * Metodo constructor
		 * @param nombre int (entero) con el id de la instalación.
		 * @param capacidadEquipos int (entero) con la capacidad valida para la instalación.
		 * @param localización String (cadena) con la dirección de la instalación.
		 * @return Instalación (Instalación) con el atributo interno de una instalación.
		 */

    public static Instalacion crearInstalacion (String nombre,
    int capacidadEquipos, String localizacion){
        
        return new Instalacion(nombre, capacidadEquipos, localizacion);
    }

		/*
		 * Metodo constructor
		 * @param idInst int (entero) con id de la instalación.
		 */

    public void setIdInst(int idInst) {
        this.idInstalacion = idInst;
    }
    
		/*
		 * Metodo consultor
		 * @return int (entero) con el atributo interno del iD de la instalación.
		 */

    public int getIdInstalacion(){
        return this.idInstalacion;
    }
    
		/*
		 * Metodo consultor
		 * @return String (cadena) con el atributo interno del nombre de la instalación.
		 */
    
    public String getNombre(){
        return this.nombre;
    }

		/*
		 * Metodo constructor
		 * @param nombre String (cadena) con el nombre de la instalación
		 */
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

		/*
		 * Metodo consultor
		 * @return int (entero) con el atributo interno de la capacidad de los equipos para la instalación.
		 */
    
    public int getCapacidadEquipos(){
        return this.capacidadEquipos;
    }

		/*
		 * Metodo constructor
		 * @param capacidad int (entero) con la capacidad de los equipos para la instalación.
		 */
    
    public void setCapacidadEquipos(int capacidad){
        this.capacidadEquipos = capacidad;
    }

		/*
		 * Metodo consultor
		 * @return String (cadena) con el atributo interno de la dirección de la instalación.
		 */
    
    public String getLocalizacion(){
        return this.localizacion;
    }
	    
		/*
		 * Metodo constructor
		 * @param direccion String (cadena) con la dirección de la instalación.
		 */

    public void setLocalizacion(String direccion){
        this.localizacion = direccion;
    }
}
