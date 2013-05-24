package GestionDeCategorias;

import ServiciosAlmacenamiento.BaseDatos;
import java.sql.SQLException;

/**
 * Clase que representa las categorías a las que puede pertenecer un alumno.
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

public class Categoria {

    static int Modificar(BaseDatos accesoBD, Categoria cNuevo, Categoria cViejo) throws SQLException {
        return CategoriaBD.ModificarCategoria(accesoBD, cNuevo, cViejo);
    }

    private int idCategoria;
    private String tipo;
    private String descripcion;
    
    public Categoria(String categoria){
        this.tipo = categoria;
    }
    
    public Categoria(String t, String desc){
        this.tipo = t;
        this.descripcion = desc;
    }

    public String getNombreCategoria() {
        return this.tipo;
    }
    
    public String getDescripcion(){
        return this.descripcion;
    }

    public void setDescripcion(String desc) {
        this.descripcion = desc;
    }

    public void setTipo(String t) {
        this.tipo = t;
    }
   
    public void setIdCat(int idCat) {
        this.idCategoria = idCat;
    }

}
