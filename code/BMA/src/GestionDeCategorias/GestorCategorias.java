package GestionDeCategorias;

import InterfazUsuario.PantallaPrincipal;
import ServiciosAlmacenamiento.BaseDatos;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

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

public class GestorCategorias {
    
    public static String getCategoria(BaseDatos accesoBD, int idCat) throws SQLException {
        return CategoriaBD.getCategoria(accesoBD, idCat);
    }

    public static int getIdCategoria(BaseDatos accesoBD, String categoria) throws SQLException, SQLException, SQLException, SQLException, SQLException {
        return CategoriaBD.getIdCategoria(accesoBD, categoria);
    }

    public static void InsertarDatosCategorias(BaseDatos accesoBD, String t, String desc) throws SQLException {
        boolean validar = CategoriaBD.ConsultarCategoria(accesoBD, t);
        
        if(!validar){
            JOptionPane.showMessageDialog(null, "La categoria ya existe", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            Categoria c = new Categoria(t, desc);
            CategoriaBD.crearCategoria(accesoBD, c);
            JOptionPane.showMessageDialog(null, "Categoria creada", "Exito", JOptionPane.INFORMATION_MESSAGE);
        }
    }


    public static List<List<String>> getListaCategorias(BaseDatos accesoBD) throws SQLException {
        return CategoriaBD.getListaCategorias(accesoBD);
    }

    public static void ModificarCategoria(BaseDatos accesoBD, Categoria cNuevo, Categoria cViejo) throws SQLException {
        boolean existe = existeCategoria(accesoBD, cNuevo);
        
        if (existe) {
            JOptionPane.showMessageDialog(null, "La categoria ya existe", "Error", JOptionPane.ERROR_MESSAGE);
        } else{
            Categoria.Modificar(accesoBD, cNuevo, cViejo);
            JOptionPane.showMessageDialog(null, "Categoria modificada", "Exito", JOptionPane.INFORMATION_MESSAGE);
        }
       
    }

    private static boolean existeCategoria(BaseDatos accesoBD, Categoria c) throws SQLException {
        return CategoriaBD.existeCategoria(accesoBD, c);
    }

    public static void EliminarCategorias(BaseDatos accesoBD, Categoria c) {
        boolean categoriaEliminada = false;
        
        categoriaEliminada = CategoriaBD.EliminarCategoria(accesoBD, c);
        
        if(categoriaEliminada)
            JOptionPane.showMessageDialog(new PantallaPrincipal(), "Categoria eliminada", "Exito", JOptionPane.NO_OPTION);
        else
            JOptionPane.showMessageDialog(new PantallaPrincipal(), "Error al eliminar", "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static List<String> getTipoCategorias(BaseDatos accesoBD) throws SQLException {
        return CategoriaBD.getTipoCategorias(accesoBD);
    }

    }

    

