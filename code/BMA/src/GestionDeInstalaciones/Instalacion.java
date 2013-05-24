package GestionDeInstalaciones;

import GestionDeGrupos.Grupo;
import java.util.List;

/**
 *
 * @author Diego
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
    
    //private List<Actividad> actividades;
    
    Instalacion(String nombre, int capacidadEquipos,
            String localizacion){
        

        this.nombre = nombre;
        this.capacidadEquipos = capacidadEquipos;
        this.localizacion = localizacion;
    }
    
    public static Instalacion crearInstalacion (String nombre,
    int capacidadEquipos, String localizacion){
        
        return new Instalacion(nombre, capacidadEquipos, localizacion);
    }

    public Instalacion(String inst) {
        this.nombre = inst;
    }

    public void setIdInst(int idInst) {
        this.idInstalacion = idInst;
    }
    
    public int getIdInstalacion(){
        return this.idInstalacion;
    }
    
    public void setIdInstalacion(int id){
        this.idInstalacion = id;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public int getCapacidadEquipos(){
        return this.capacidadEquipos;
    }
    
    public void setCapacidadEquipos(int capacidad){
        this.capacidadEquipos = capacidad;
    }
    
    public String getLocalizacion(){
        return this.localizacion;
    }
    
    public void setLocalizacion(String direccion){
        this.localizacion = direccion;
    }
}
