package GestionDeTemporadas;

import GestionDeGrupos.GruposBD;
import ServiciosAlmacenamiento.BaseDatos;
import java.sql.ResultSet;
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
 * Clase Gestora de Temporadas que permite interactuar entre las tablas de la 
 * base de datos referentes a Temporadas y los objetos de la clase Temporada.
 * @author Diego
 */
public class GestorTemporadas {

    //private List<Temporada> temporadas;
    
    /**
     * Permite obtener una lista con las temporadas almacenadas en la BD.
     * @param accesoBD Usado para interactuar con la base de datos.
     * @return Una lista de <code>String</code> con las temporadas.
     * @throws SQLException 
     */
    public static List<String> getListaTemporadas(BaseDatos accesoBD) throws SQLException {
        return TemporadaBD.getListaTemporadas(accesoBD);
    }

    /*/**
     * Premite modificar el curso de una temporada.
     * @param accesoBD Usado para interactuar con la base de datos.
     * @param curso Contiene el nuevo curso que queremos almacenar.
     * @param cursoAnt Contiene el curso anterior que va a ser modificado.
     * @return 1 si la modificacion ha tenido exito, 0 en caso contraio.
     * @throws SQLException 
     */
    /*public static int modificarTemporada(BaseDatos accesoBD, int curso, int cursoAnt) throws SQLException {
        int correcto = 0;
        boolean validar = TemporadaBD.consultarTemporada(curso, accesoBD);
        
        if(validar == false)
            JOptionPane.showMessageDialog(null, "La temporada ya existe", "Error", JOptionPane.ERROR_MESSAGE);
        else {
            String cursoNuevo = curso +"/"+(curso+1);
            String cursoAnterior =  cursoAnt +"/"+(cursoAnt+1);
            
            correcto = TemporadaBD.modificarTemporada(accesoBD, cursoAnterior, cursoNuevo);
            JOptionPane.showMessageDialog(null, "Temporada modificada", "Exito", JOptionPane.INFORMATION_MESSAGE);
        }
        
        return correcto;
    }*/

    /**
     * Permite eliminar una temporada de la base de datos.
     * @param accesoBD Usado para interactuar con la base de datos.
     * @param t Objeto de la clase Temporada que va a ser eliminado.
     * @return TRUE si la eliminacion ha tenido exito, FALSE en caso contraio.
     */
    public static boolean eliminarTemporada(BaseDatos accesoBD, Temporada t) {
        return TemporadaBD.eliminarTemporadaBD(accesoBD, t);
    }

    
    
    /*public static int InsertarTemporada(int curso, BaseDatos accesoBD) throws SQLException {
        int correcto = 0;
        boolean validar = TemporadaBD.consultarTemporada(curso, accesoBD);
        
        if(validar == false)
            JOptionPane.showMessageDialog(null, "La temporada ya existe", "Error", JOptionPane.ERROR_MESSAGE);
        else{
            int auxCurso = curso+1;
            String cursoComp = Integer.toString(curso)+"/"+Integer.toString(auxCurso);
            Temporada t = new Temporada(cursoComp);
            correcto = TemporadaBD.insertarTemporadaBD(accesoBD, t);
            JOptionPane.showMessageDialog(null, "Temporada creada", "Exito", JOptionPane.INFORMATION_MESSAGE);
        }
        return correcto;
    }*/

    /**
     * Permite obtener el identificador de una temporada a partir del curso de 
     * la temporada.
     * @param accesoBD Usado para interactuar con la base de datos.
     * @param temporada Contiene el curso de la temporada.
     * @return Un <code>int</code> con el identificador de la temporada.
     * @throws SQLException 
     */
    public static int getIdTemporada(BaseDatos accesoBD, String temporada) throws SQLException {
        int idTem = TemporadaBD.getIdTemporada(accesoBD, temporada);
        
        return idTem;
    }

    /**
     * Permite obtener una temporada a partir del identificador de la temporada.
     * @param accesoBD Usado para interactuar con la base de datos.
     * @param s Contiene el identificador de la temporada de la que queremos saber 
     * el curso.
     * @return Un <code>String</code> con el identificador de la temporada.
     * @throws SQLException 
     */
    public static String getTemporada(BaseDatos accesoBD, String s) throws SQLException {
        return TemporadaBD.getTemporada(accesoBD, s);
    }

    /**
     * Permite obtener una temporada a partir del identificador de la temporada.
     * @param accesoBD Usado para interactuar con la base de datos.
     * @param idTemp Contiene el identificador de la temporada de la que queremos saber 
     * el curso.
     * @return Un <code>String</code> con el identificador de la temporada.
     * @throws SQLException 
     */
    public static String getTemporada(BaseDatos accesoBD, int idTemp) throws SQLException {
        return TemporadaBD.getTemporada(accesoBD, idTemp);
    }

    /**
     * Permite saber si existe el curso pasado por parametro.
     * @param accesoBD Usado para interactuar con la base de datos.
     * @param cursoNuevoComp Contiene el curso que queremos comprobar si ya existe.
     * @return TRUE si el curso ya existe, FALSE en caso contrario.
     * @throws SQLException 
     */
    private static boolean existeCurso(BaseDatos accesoBD, String cursoNuevoComp) throws SQLException {
        boolean existe = false;  
        String query = "SELECT * FROM Temporada WHERE curso='"+cursoNuevoComp+"'";
        ResultSet res = accesoBD.ejecutaConsulta(query);
      
        if(res.next())      
            existe = true;
        
        return existe;
    }

    /**
     * Permite insertar una nueva temporada en la base de datos.
     * @param accesoBD Usado para interactuar con la base de datos.
     * @param t Objeto de la clase Temporada que contiene todos los datos de la 
     * nueva temporada.
     * @return 1 si la insercion ha sido correcta, 0 en caso contrario.
     * @throws SQLException 
     */
    public static int InsertarTemporada(BaseDatos accesoBD, Temporada t) throws SQLException {
        int correcto = 0;
        boolean validar = TemporadaBD.consultarTemporada(Integer.parseInt(t.getCurso()), accesoBD);
        
        if(validar == false)
            JOptionPane.showMessageDialog(null, "La temporada ya existe", "Error", JOptionPane.ERROR_MESSAGE);
        else{
            //int auxCurso = curso+1;
            int auxCurso = Integer.parseInt(t.getCurso())+1;
            String cursoComp = Integer.toString(Integer.parseInt(t.getCurso()))+"/"+Integer.toString(auxCurso);
            t.setCursoCompleto(cursoComp);
            //Temporada t = new Temporada(cursoComp);
            correcto = TemporadaBD.insertarTemporadaBD(accesoBD, t);
            JOptionPane.showMessageDialog(null, "Temporada creada", "Exito", JOptionPane.INFORMATION_MESSAGE);
        }
        return correcto;
    }

    /**
     * Permite modificar una temporada almacenada previamente en la BD.
     * @param accesoBD Usado para interactuar con la base de datos.
     * @param t Objeto de la clase Temporada que contiene los nuevos datos que 
     * se quieren modificar.
     * @param aAnt Contiene el año de la temporada que se quiere modificar.
     * @return <code>1</code> si la modificacion ha sido correcta, <code>0</code> en caso contrario.
     * @throws SQLException 
     */
    public static int modificarTemporada(BaseDatos accesoBD, Temporada t, int aAnt) throws SQLException {
        int correcto = 0;
        boolean validar = true;
        
        if(aAnt != Integer.parseInt(t.getCurso()))
            validar = TemporadaBD.consultarTemporada(Integer.parseInt(t.getCurso()), accesoBD);
        
        if(validar == false)
            JOptionPane.showMessageDialog(null, "La temporada ya existe", "Error", JOptionPane.ERROR_MESSAGE);
        else {
            String cursoNuevo = t.getCurso() +"/"+(Integer.parseInt(t.getCurso())+1);
            String cursoAnterior =  aAnt +"/"+(aAnt+1);
            
            t.setCursoCompleto(cursoNuevo);
            
            correcto = TemporadaBD.modificarTemporada(accesoBD, cursoAnterior, t);
            JOptionPane.showMessageDialog(null, "Temporada modificada", "Exito", JOptionPane.INFORMATION_MESSAGE);
        }
        
        return correcto;
    }

    /**
     * Permite obtener el importe de la cuota mensual de una temporada.
     * @param bd Usado para interactuar con la base de datos.
     * @param curso Contiene la temporada de la que queremos saber el importe mensual.
     * @return El importe de la cuota mensual de la temporada pasada por parametro.
     * @throws SQLException 
     */
    public static double getImporte(BaseDatos bd, String curso) throws SQLException {
        return TemporadaBD.getImporte(bd, curso);
    }

    /**
     * Permite obtener el inicio del curso de la temporada.
     * @param bd Usado para interactuar con la base de datos.
     * @param curso Contiene el curso del que queremos saber la fecha de inicio.
     * @return <code>String</code> que contiene la fecha de inicio del curso.
     * @throws SQLException 
     */
    public static String getInicio(BaseDatos bd, String curso) throws SQLException {
        return TemporadaBD.getInicio(bd, curso);
    }
    
    /**
     * Permite obtener fecha de fin del curso de la temporada.
     * @param bd Usado para interactuar con la base de datos.
     * @param curso Contiene el curso del que queremos saber la fecha de fin.
     * @return <code>String</code> que contiene la fecha de fin del curso.
     * @throws SQLException 
     */
    public static String getFin(BaseDatos bd, String curso) throws SQLException {
        return TemporadaBD.getFin(bd, curso);
    }

    /**
     * Permite obtener el año de la temporada a partir del identificador de la 
     * temporada.
     * @param bd Usado para interactuar con la base de datos.
     * @param idTemp Identificador de la temporada.
     * @return <code>int</code> con el año del curso expresado como "xxxx"
     * @throws SQLException 
     */
    public static int getAnio(BaseDatos bd, int idTemp) throws SQLException {
        return GruposBD.getAnio(bd, idTemp);
    }
        
   
    /*public  List<Temporada> ConsultarTemporada(String curso){
        return new ArrayList<Temporada>();
    }
    
    public void EliminarTemporada(Temporada temp){
        
    }*/
    
    
     /**
     * Permite generar las estadisticas de una temporada haciendo una llamada al metodo
     * correspondiente de TemporadaBD.
     * @param accesoBD Usado para interactuar con la base de datos.
     * @param idTemp Entero que identifica el id de la temporada para realizar la consulta.
     * @param idCate Entero que identifica el id de la categoria para realizar la consulta.
     * @return ResultSet con los datos de la consulta o null en caso de que no se encuentren
     * datos en la BD.
     * @throws SQLException 
     */
    public static ResultSet consultarEstadisticasTemporada(BaseDatos accesoBD, int idTemp, int idCate)throws SQLException{
        
        return TemporadaBD.generaEstadisticasTemporada(accesoBD, idTemp, idCate);  
    } 
}
