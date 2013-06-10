package GestionDeCategorias;

import ServiciosAlmacenamiento.BaseDatos;
import java.sql.SQLException;



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
 * Clase que representa las categorías a las que puede pertenecer un alumno.
 * @author Diego, Moises
 */

public class Categoria {

    private int idCategoria;
    private String tipo;
    private String descripcion;
    private int EdadMinima;
    
    /**
     * Permite modificar una categoria almacenada en la base de datos.
     * @param accesoBD Usado para interactuar con la base de datos.
     * @param cNuevo Objeto de la clase Categoria con los nuevos datos que 
     * queremos modificar.
     * @param cViejo Objeto de la clase Categoria con los antiguos datos que van 
     * a ser modificados.
     * @return 1 si la modificacion ha tenido exito, 0 en caso contrario.
     * @throws SQLException 
     */
    static int Modificar(BaseDatos accesoBD, Categoria cNuevo, Categoria cViejo, int EdadMinima) throws SQLException {
        return CategoriaBD.ModificarCategoria(accesoBD, cNuevo, cViejo, EdadMinima);
    }
    
    /**
     * Contructor de la clase Categoria.
     * @param categoria Nombre de la categoria.
     */
    
    public Categoria(String categoria){
        this.tipo = categoria;
    }
    
    /**
     * Constructor de la clase Categoria.
     * @param t Contiene el nombre de la categoria.
     * @param desc Contiene la descripcion de la categoria.
     */
    
    public Categoria(String t, String desc, int EdadMinima){
        this.tipo = t;
        this.descripcion = desc;
        this.EdadMinima = EdadMinima;
    }

    /**
     * Permite obtener el nombre de una cateogira.
     * @return Un <code>String</code> con el nombre de la categoria.
     */
    
    public String getNombreCategoria() {
        return this.tipo;
    }
    
    /**
     * Permite obtener la descripcion de una categoria.
     * @return Un <code>String</code> con la descripcion de la categoria.
     */
    
    public String getDescripcion(){
        return this.descripcion;
    }

    /**
     * Permite establecer la descripcion de la categoria.
     * @param desc Contiene la descripcion de la categoria.
     */
    
    public void setDescripcion(String desc) {
        this.descripcion = desc;
    }

    /**
     * Permite establecer el nombre de la categoria.
     * @param t Contiene el nombre de la categoria.
     */
    
    public void setTipo(String t) {
        this.tipo = t;
    }
   
    /**
     * Permite establecer el identificador de la categoria.
     * @param idCat Contiene el identificador de la categoria.
     */
    
    public void setIdCat(int idCat) {
        this.idCategoria = idCat;
    }

    /**
     * Permite obtener el identificador de la categoria.
     * @return Un <code> String </code> que contiene el identificador de la categoria.
     */
    
    public String getIdCategoria() {
        return Integer.toString(this.idCategoria);
    }

    /**
     * Permite obtener la edad minima de la categoria.
     * @return Un <code> int </code> que contiene la edad mínima de la categoría
     */
    
    public int getEdadMinima() {
        return EdadMinima;
    }

    /**
     * Permite establecer la edad minima de la categoria.
     * @param EdadMinima Contiene el valor numerico de la edad minima
     * de la categoria.
     */
    
    public void setEdadMinima(int EdadMinima) {
        this.EdadMinima = EdadMinima;
    }

    
}
