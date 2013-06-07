package GestionDeTemporadas;

import ServiciosAlmacenamiento.BaseDatos;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
 * Clase que permite hacer el paso de los objetos de tipo Temporada a objetos 
 * relacionales de la Base de Datos.
 * @author Diego
 */
public class TemporadaBD {

    /**
     * Permite saber si una temporada ya esta introducida en la base de datos.
     * @param curso Contiene el año que queremos saber si ya esta introducido en 
     * la base de datos.
     * @param accesoBD Usado para interactuar con la base de datos.
     * @return TRUE si la temporada ya existe, FALSE en caso contrario.
     * @throws SQLException 
     */
    static boolean consultarTemporada(int curso, BaseDatos accesoBD) throws SQLException {
        boolean validar;
        
        int auxCurso = curso+1;
        String temp = Integer.toString(curso)+"/"+Integer.toString(auxCurso);
        
        String query = "SELECT * FROM Temporada WHERE curso='"+temp+"'";
        ResultSet res = accesoBD.ejecutaConsulta(query);
        
        if(res.next())
            validar = false;
        else
            validar = true;
        
        return validar;
    }

    /**
     * Permite insertar una nueva temporada en la Base de Datos.
     * @param accesoBD Usado para interactuar con la base de datos.
     * @param t Objeto de la clase Temporada con los datos de la nueva temporada.
     * @return 1 si la insercion ha sido correcta, 0 en caso contrario.
     * @throws SQLException 
     */
    static int insertarTemporadaBD(BaseDatos accesoBD, Temporada t) throws SQLException {
        String query = "INSERT INTO Temporada (curso, inicio, fin, importeMensual) "
                + "VALUES ('"+t.getCurso()+"','"+t.getInicio()+"','"+t.getFin()+"','"+Double.toString(t.getImporte())+"')";
        int correcto = accesoBD.ejecutaActualizacion(query);
        return correcto;
    }

    /**
     * Permite obtener una lista con todas las temporadas almacenadas en el sistema.
     * @param accesoBD Usado para interactuar con la base de datos.
     * @return Lista de <code>String</code> con las temporadas almacenadas.
     * @throws SQLException 
     */
    static List<String> getListaTemporadas(BaseDatos accesoBD) throws SQLException {
        String query = "SELECT curso FROM Temporada ORDER BY curso DESC";
        ResultSet resCons = accesoBD.ejecutaConsulta(query);
        
        List<String> res = new ArrayList<>();
        
        while(resCons.next()){
            res.add(resCons.getString(1));
        }
        
        return res;
    }

    /**
     * Permite modificar una temporada previamente almacenada en la BD.
     * @param accesoBD Usado para interactuar con la base de datos.
     * @param cursoAnterior Año de la temporada que queremos modificar.
     * @param cursoNuevo Año de la nueva temporada que queremos almacenar.
     * @return 1 si la modificacion ha sido correcta, 0 en caso contrario.
     * @throws SQLException 
     */
    static int modificarTemporada(BaseDatos accesoBD, String cursoAnterior, String cursoNuevo) throws SQLException {
        int correcto = 0;
        String query = "UPDATE Temporada SET curso='"+cursoNuevo+"' WHERE curso='"+cursoAnterior+"'";
        correcto = accesoBD.ejecutaActualizacion(query);
        
        return correcto;
    }

    /**
     * Permite eliminar una temporada de la base de datos.
     * @param accesoBD Usado para interactuar con la base de datos.
     * @param t Objeto de la clase Temporada con los datos de la temporada que 
     * queremos eliminar.
     * @return TRUE si la eliminacion ha sido correcta, FALSE en caso contrario.
     */
    static boolean eliminarTemporadaBD(BaseDatos accesoBD, Temporada t) {
        boolean correcto = false;
        String query = "DELETE FROM Temporada WHERE curso='"+t.getCurso()+"'";
        correcto = accesoBD.eliminar(query);
        
        return correcto;
    }

    /**
     * Permite obtener el identificador de una temporada a partir del curso.
     * @param accesoBD Usado para interactuar con la base de datos.
     * @param temporada Contiene el curso de la temporada expresado como "anio/anio+1".
     * @return Un <code>int</code> con el identificador de la temporada pasada 
     * por parametro.
     * @throws SQLException 
     */
    static int getIdTemporada(BaseDatos accesoBD, String temporada) throws SQLException {
        int idTemp = 0;
        
        String query = "SELECT idTemporada FROM Temporada WHERE curso='"+temporada+"'";
        ResultSet res = accesoBD.ejecutaConsulta(query);
        
        if(res.next())
            idTemp = res.getInt(1);

        return idTemp;
    }

    /**
     * Permite obtener una temporada a partir del identificador.
     * @param accesoBD Usado para interactuar con la base de datos.
     * @param s Contiene el identificador de la temporada.
     * @return <code>String</code> con la temporada correspondiente al identificador 
     * pasado por parametro.
     * @throws SQLException 
     */
    static String getTemporada(BaseDatos accesoBD, String s) throws SQLException {
        String query = "SELECT curso FROM Temporada WHERE idTemporada='"+s+"'";
        ResultSet res = accesoBD.ejecutaConsulta(query);
        String temp = "";
        
        if(res.next())
            temp = res.getString(1);
        
        return temp;
    }

    /**
     * Permite obtener una temporada a partir del identificador.
     * @param accesoBD Usado para interactuar con la base de datos.
     * @param s Contiene el identificador de la temporada.
     * @return <code>String</code> con la temporada correspondiente al identificador 
     * pasado por parametro.
     * @throws SQLException 
     */
    static String getTemporada(BaseDatos accesoBD, int idTemp) throws SQLException {
        String query = "SELECT curso FROM Temporada WHERE idTemporada='"+idTemp+"'";
        ResultSet res = accesoBD.ejecutaConsulta(query);
        String temp = "";
        
        if(res.next())
            temp = res.getString(1);
        
        return temp;
    }
    
    
     /**
     * Permite generar las estadisticas de una temporada.
     * @param accesoBD Usado para interactuar con la base de datos.
     * @param idTemp Entero que identifica el id de la temporada para realizar la consulta.
     * @param idCate Entero que identifica el id de la categoria para realizar la consulta.
     * @return ResultSet con los datos de la consulta o null en caso de que no se encuentren
     * datos en la BD.
     * @throws SQLException 
     */
    public static ResultSet generaEstadisticasTemporada(BaseDatos accesoBD,int idTemp, int idCate)throws SQLException{
        
        String consulta = "SELECT e.nombre,  u.nombre, u.primerApellido, u.segundoApellido, SUM(p.resultadoLocal) FROM equipo e, usuario u, rango r, partido p " +
                          "WHERE e.temporada_idTemporada='"+idTemp+"' AND e.Categoria_idCategoria='"+idCate+"' " +
                          "AND e.idEquipo=r.Equipo_idEquipo AND u.idUsuario=r.Usuario_idUsuario AND r.tipo='PRIMERO' " +
                          "AND e.idEquipo=p.idEquipo GROUP BY p.idEquipo; ";
        ResultSet resSet = accesoBD.ejecutaConsulta(consulta);
       
        if (!resSet.next())
            return null;
        else{
            resSet.beforeFirst();
            return resSet;
        }    
    }
   

    /**
     * Permite modificar una temporada previamente almacenada en la BD.
     * @param accesoBD Usado para interactuar con la base de datos.
     * @param cursoAnterior Año de la temporada que queremos modificar.
     * @param t Objeto de la clase temporada que contiene los nuevos datos que 
     * queremos modificar.
     * @return 1 si la modificacion ha sido correcta, 0 en caso contrario.
     * @throws SQLException 
     */
    static int modificarTemporada(BaseDatos accesoBD, String cursoAnterior, Temporada t) throws SQLException {
        int correcto = 0;
        String query = "UPDATE Temporada SET curso='"+t.getCurso()+"',"
                + "inicio='"+t.getInicio()+"',fin='"+t.getFin()+"',importeMensual='"+t.getImporte()+"'"
                + " WHERE curso='"+cursoAnterior+"'";
        correcto = accesoBD.ejecutaActualizacion(query);
        
        return correcto;
    }

    /**
     * Permite obtener el importe mensual de una temporada.
     * @param bd Usado para interactuar con la base de datos.
     * @param curso Contiene el curso del cual queremos saber el importe de las 
     * mensualidades.
     * @return Un <code>double</code> con el importe mensual.
     * @throws SQLException 
     */
    static double getImporte(BaseDatos bd, String curso) throws SQLException {
        String query = "SELECT importeMensual FROM Temporada WHERE "
                + "curso='"+curso+"'";
        ResultSet res = bd.ejecutaConsulta(query);
        
        double imp = 0;
        if(res.next())
            imp = res.getDouble(1);
        
        return imp;
    }

    /**
     * Permite obtener la fecha de inicio de un curso.
     * @param bd Usado para interactuar con la base de datos.
     * @param curso Contiene el curso de la temporada expresado como "anio/anio+1".
     * @return Un <code>String</code> con la fecha de inicio de la temporada.
     * @throws SQLException 
     */
    static String getInicio(BaseDatos bd, String curso) throws SQLException {
        String query = "SELECT inicio FROM Temporada "
                + "WHERE curos='"+curso+"'";
        ResultSet res = bd.ejecutaConsulta(query);
        
        String i = null;
        if(res.next())
            i = res.getString(1);
        
        return i;
    }
    
    /**
     * Permite obtener la fecha de fin de un curso.
     * @param bd Usado para interactuar con la base de datos.
     * @param curso Contiene el curso de la temporada expresado como "anio/anio+1".
     * @return Un <code>String</code> con la fecha de fin de la temporada.
     * @throws SQLException 
     */
    static String getFin(BaseDatos bd, String curso) throws SQLException {
        String query = "SELECT fin FROM Temporada "
                + "WHERE curos='"+curso+"'";
        ResultSet res = bd.ejecutaConsulta(query);
        
        String f = null;
        if(res.next())
            f = res.getString(1);
        
        return f;
    }
    
}
