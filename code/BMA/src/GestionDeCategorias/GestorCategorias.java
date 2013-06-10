package GestionDeCategorias;

import InterfazUsuario.PantallaPrincipal;
import ServiciosAlmacenamiento.BaseDatos;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;



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
 * Clase Gestora de Categorias que permite interactuar entre las tablas de la 
 * base de datos referentes a Categorias y los objetos de la clase Categoria.
 * @author Diego
 */
public class GestorCategorias {
    
    /**
     * Permite obtener una categoria a partir del identificador de la categoria.
     * @param accesoBD Usado para interactuar con la base de datos.
     * @param idCat Contiene el identificador de la categoria de la que queremos 
     * obtener el nombre.
     * @return Un <code>String</code> con el nombre de la categoria.
     * @throws SQLException 
     */
    public static String getCategoria(BaseDatos accesoBD, int idCat) throws SQLException {
        return CategoriaBD.getCategoria(accesoBD, idCat);
    }

    /**
     * Permite obtener el identificador de una categoria a partir del nombre.
     * @param accesoBD Usado para interactuar con la base de datos.
     * @param categoria Contiene el nombre de la categoria de la que queremos 
     * saber el identificador.
     * @return Un <code>int</code> con el identificador de la categoria.
     * @throws SQLException 
     */
    public static int getIdCategoria(BaseDatos accesoBD, String categoria) throws SQLException{
        return CategoriaBD.getIdCategoria(accesoBD, categoria);
    }

    /**
     * Permite insertar una nueva categoria en la base de datos
     * @param accesoBD Usado para interactuar con la base de datos.
     * @param t Contiene el nombre de la categoria que queremos insertar.
     * @param desc Contiene la descripcion de la categoria que queremos insertar.
     * @throws SQLException 
     */
    public static void InsertarDatosCategorias(BaseDatos accesoBD, String t, String desc, int EdadMinima) throws SQLException {
        boolean validar = CategoriaBD.ConsultarCategoria(accesoBD, t);
        
        if(!validar){
            JOptionPane.showMessageDialog(null, "La categoria ya existe", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            Categoria c = new Categoria(t, desc, EdadMinima);
            CategoriaBD.crearCategoria(accesoBD, c);
            JOptionPane.showMessageDialog(null, "Categoria creada", "Exito", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /**
     * Permite obtener una lista con las temporadas almacenadas en la base de datos.
     * @param accesoBD Usado para interactuar con la base de datos.
     * @return Una lista de lista de <code>String</code> con las categorias, 
     * conteniendo tanto el nombre como la descripcion.
     * @throws SQLException 
     */
    public static List<List<String>> getListaCategorias(BaseDatos accesoBD) throws SQLException {
        return CategoriaBD.getListaCategorias(accesoBD);
    }

    /**
     * Permite modificar una categoria existente en la base de datos.
     * @param accesoBD Usado para interactuar con la base de datos.
     * @param cNuevo Objeto de la clase Categoria con los nuevos datos que queremos 
     * modificar.
     * @param cViejo Objeto de la clase Categoria con los antiguos datos que van a ser 
     * modificados.
     * @throws SQLException 
     */
    public static void ModificarCategoria(BaseDatos accesoBD, Categoria cNuevo, Categoria cViejo, int EdadMinima) throws SQLException {
        boolean existe = existeCategoria(accesoBD, cNuevo);
        
        if (existe) {
            JOptionPane.showMessageDialog(null, "La categoria ya existe", "Error", JOptionPane.ERROR_MESSAGE);
        } else{
            Categoria.Modificar(accesoBD, cNuevo, cViejo, EdadMinima);
            JOptionPane.showMessageDialog(null, "Categoria modificada", "Exito", JOptionPane.INFORMATION_MESSAGE);
        }
       
    }

    /**
     * Permite saber si una cateogoria ya existe en la base de datos.
     * @param accesoBD Usado para interactuar con la base de datos.
     * @param c Objeto de la clase Categoria con los datos de la categoria de la 
     * que queremos saber si ya existe en la BD.
     * @return TRUE si la categoria ya existe, FALSE en caso contrario.
     * @throws SQLException 
     */
    private static boolean existeCategoria(BaseDatos accesoBD, Categoria c) throws SQLException {
        return CategoriaBD.existeCategoria(accesoBD, c);
    }

    /**
     * Permite eliminar una categoria de la base de datos.
     * @param accesoBD Usado para interactuar con la base de datos.
     * @param c Objeto de la clase Categoria con los datos de la categoria 
     * que queremos eliminar.
     */
    public static void EliminarCategorias(BaseDatos accesoBD, Categoria c) {
        boolean categoriaEliminada = false;
        
        categoriaEliminada = CategoriaBD.EliminarCategoria(accesoBD, c);
        
        if(categoriaEliminada)
            JOptionPane.showMessageDialog(null, "Categoria eliminada", "Exito", JOptionPane.NO_OPTION);
        else
            JOptionPane.showMessageDialog(null, "Error al eliminar", "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    /**
     * Permite obtener los nombres de las cateogiras almacenadas en la BD.
     * @param accesoBD Usado para interactuar con la base de datos.
     * @return Una lista de <code>String</code> con los nombres de las categorias.
     * @throws SQLException 
     */
    public static List<String> getTipoCategorias(BaseDatos accesoBD) throws SQLException {
        return CategoriaBD.getTipoCategorias(accesoBD);
    }

    public static int getAnioCategoria(BaseDatos bd, String cat) throws SQLException {
        return CategoriaBD.getAnioCategoria(bd, cat);
    }

}

    

