package GestionDeCategorias;

import ServiciosAlmacenamiento.BaseDatos;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;



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
 * Clase que permite hacer el paso de los objetos de tipo Categoria a objetos 
 * relacionales de la Base de Datos.
 * @author Diego, Moises
 */
public class CategoriaBD {
    
    private static String may_min = "COLLATE utf8_bin";
    
    /**
     * Permite obtener una categoria a partir del identificador de la categoria.
     * @param accesoBD Usado para interactuar con la base de datos.
     * @param idCat Contiene el identificador de la categoria de la que queremos 
     * obtener el nombre.
     * @return Un <code>String</code> con el nombre de la categoria.
     * @throws SQLException 
     */
    static String getCategoria(BaseDatos accesoBD, int idCat) throws SQLException {
        String query = "SELECT tipo FROM Categoria WHERE "
                + "idCategoria='"+idCat+"'";
        
        ResultSet res = accesoBD.ejecutaConsulta(query);
        
        String cat = "";
        if(res.next())
            cat = res.getString(1);
        
        return cat;
    }

    /**
     * Permite obtener el identificador de una categoria a partir del nombre.
     * @param accesoBD Usado para interactuar con la base de datos.
     * @param categoria Contiene el nombre de la categoria de la que queremos 
     * saber el identificador.
     * @return Un <code>int</code> con el identificador de la categoria.
     * @throws SQLException 
     */
    static int getIdCategoria(BaseDatos accesoBD, String categoria) throws SQLException {
        String query = "SELECT idCategoria FROM Categoria WHERE "
                + "tipo='"+categoria+"'";
        ResultSet res = accesoBD.ejecutaConsulta(query);
        
        int idCat = 0;
        if(res.next())
            idCat = res.getInt(1);
        
        return idCat;
    }

    /**
     * Permite saber si ya existe una categoria en el sistema.
     * @param accesoBD Usado para interactuar con la base de datos.
     * @param t Contiene el nombre de la categoria de la que queremos saber si 
     * ya existe en el sistema.
     * @return TRUE si la categoria ya existe, FALSE en caso contrario.
     * @throws SQLException 
     */
    static boolean ConsultarCategoria(BaseDatos accesoBD, String t) throws SQLException {
             
        String query = "SELECT * FROM Categoria WHERE "
                + "tipo='"+t+"'";
        ResultSet res = accesoBD.ejecutaConsulta(query);
        
        if(res.next())
            return false;
        else
            return true;
    }

    /**
     * Permite añadir una nueva categoria en la base de datos.
     * @param accesoBD  Usado para interactuar con la base de datos.
     * @param c Objeto de la clase Categoria con los datos de la nueva categoria 
     * que se va a insertar.
     * @return 1 si la insercion fue correcta, 0 en caso contrario.
     * @throws SQLException 
     */
    static int crearCategoria(BaseDatos accesoBD, Categoria c) throws SQLException {
        String query = "INSERT INTO Categoria (tipo, descripcion, edadmin) VALUES ('"+c.getNombreCategoria()+"',"
                + "'"+c.getDescripcion()+"',"+c.getEdadMinima()+")";
        int correcto = accesoBD.ejecutaActualizacion(query);
        return correcto;
    }

    /**
     * Permite obtener una lista con las temporadas almacenadas en la base de datos.
     * @param accesoBD Usado para interactuar con la base de datos.
     * @return Una lista de lista de <code>String</code> con las categorias, 
     * conteniendo tanto el nombre como la descripcion.
     * @throws SQLException 
     */
    static List<List<String>> getListaCategorias(BaseDatos accesoBD) throws SQLException {
        List<List<String>> listaCats = new ArrayList<List<String>>();
        
        String query = "SELECT tipo,descripcion, edadmin FROM Categoria";
        ResultSet res = accesoBD.ejecutaConsulta(query);
        
        List<String> aux;
        
        while(res.next()){
            aux = new ArrayList<String>();
            aux.add(res.getString(1));
            aux.add(res.getString(2));
            aux.add(String.valueOf(res.getInt(3)));
            listaCats.add(aux);
        }
        
        return listaCats;
    }

    /**
     * Permite modificar una categoria existente en la base de datos.
     * @param accesoBD Usado para interactuar con la base de datos.
     * @param cNuevo Objeto de la clase Categoria con los nuevos datos que queremos 
     * modificar.
     * @param cViejo Objeto de la clase Categoria con los antiguos datos que van a ser 
     * modificados.
     * @return 1 si la modificacion fue correcta, 0 en caso contrario.
     * @throws SQLException 
     */
    static int ModificarCategoria(BaseDatos accesoBD, Categoria cNuevo, Categoria cViejo, int EdadMinima) throws SQLException {
        int correcto;
        
        String query = "SELECT idCategoria FROM Categoria WHERE "
                + "tipo='"+cViejo.getNombreCategoria()+"' "+may_min+" AND "
                + "descripcion='"+cViejo.getDescripcion()+"' "+may_min+" AND "
                + "edadmin=" + EdadMinima;
        ResultSet res = accesoBD.ejecutaConsulta(query);
        
        int idCat = 0;
        while(res.next())
            idCat = res.getInt(1);
        
        query = "UPDATE Categoria SET tipo='"+cNuevo.getNombreCategoria()+"', "
                + "descripcion='"+cNuevo.getDescripcion()+"', edadmin="+EdadMinima+" WHERE "
                + "idCategoria='"+idCat+"' ";
        
        correcto = accesoBD.ejecutaActualizacion(query);
        
        return correcto;
    }

    /**
     * Permite saber si una cateogoria ya existe en la base de datos.
     * @param accesoBD Usado para interactuar con la base de datos.
     * @param c Objeto de la clase Categoria con los datos de la categoria de la 
     * que queremos saber si ya existe en la BD.
     * @return TRUE si la categoria ya existe, FALSE en caso contrario.
     * @throws SQLException 
     */
    static boolean existeCategoria(BaseDatos accesoBD, Categoria c) throws SQLException {
        boolean existe;
        
        String query = "SELECT * FROM Categoria WHERE "
                + "tipo='"+c.getNombreCategoria()+"' "+may_min+" AND "
                + "descripcion='"+c.getDescripcion()+"' "+may_min+" AND "
                + "edadmin="+c.getEdadMinima();
        
        ResultSet res = accesoBD.ejecutaConsulta(query);
        
        if(res.next())
            existe = true;
        else
            existe = false;
        
        System.out.println();
        System.out.println("existe vale:"+existe);
        
        return existe;
    }

    /**
     * Permite eliminar una categoria de la base de datos.
     * @param accesoBD Usado para interactuar con la base de datos.
     * @param c Objeto de la clase Categoria con los datos de la categoria 
     * que queremos eliminar.
     * @return TRUE si se ha eliminado con exito, FALSE en caso contrario.
     */
    static boolean EliminarCategoria(BaseDatos accesoBD, Categoria c) {
        String query = "DELETE FROM Categoria WHERE "
                + "tipo='"+c.getNombreCategoria()+"' AND "
                + "descripcion='"+c.getDescripcion()+"' AND "
                + "edadmin="+c.getEdadMinima()+"";
        System.out.println(query);
        boolean res = accesoBD.eliminar(query);
        
        
        return res;
    }

    /**
     * Permite obtener los nombres de las cateogiras almacenadas en la BD.
     * @param accesoBD Usado para interactuar con la base de datos.
     * @return Una lista de <code>String</code> con los nombres de las categorias.
     * @throws SQLException 
     */
    
    static List<String> getTipoCategorias(BaseDatos accesoBD) throws SQLException {
        List<String> listaCats = new ArrayList<String>();
        
        String query = "SELECT tipo FROM Categoria";
        ResultSet res = accesoBD.ejecutaConsulta(query);
        
        while (res.next()) {
            listaCats.add(res.getString(1));
        }
        
        return listaCats;
    }

    /**
     * Permite obtener los nombres de las cateogiras almacenadas en la BD.
     * @param accesoBD Usado para interactuar con la base de datos.
     * @return Una lista de <code>String</code> con los nombres de las categorias.
     * @throws SQLException 
     */
    
    static int getAnioCategoria(BaseDatos bd, String cat) throws SQLException {
        String query = "SELECT edadmin FROM Categoria WHERE "
                + "tipo='"+cat+"'";
        ResultSet res = bd.ejecutaConsulta(query);
        
        int edadMin = 0;
        if(res.next())
            edadMin = res.getInt(1);
        
        GregorianCalendar g = new GregorianCalendar();
        int edad = g.get(GregorianCalendar.YEAR) - edadMin;
        
        return edad;
    }
    
    static int getEdadMinimaCategoria(BaseDatos bd, String cat) throws SQLException
    {
        String query = "SELECT edadmin FROM Categoria WHERE"
                + "tipo='"+cat+"'";
        
        ResultSet res = bd.ejecutaConsulta(query);
        int Edad = 0;
        
        if(res.next())
            Edad = res.getInt(1);
        
        return Edad;
        
        
    }
}
