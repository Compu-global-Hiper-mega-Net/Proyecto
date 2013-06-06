package GestionDeTemporadas;

import InterfazUsuario.AñadirModificarTemporada;
import InterfazUsuario.PantallaPrincipal;
import ServiciosAlmacenamiento.BaseDatos;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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

public class GestorTemporadas {

    //private List<Temporada> temporadas;
    
    public static List<String> getListaTemporadas(BaseDatos accesoBD) throws SQLException {
        return TemporadaBD.getListaTemporadas(accesoBD);
    }

    public static int modificarTemporada(BaseDatos accesoBD, int curso, int cursoAnt) throws SQLException {
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
    }

    public static boolean eliminarTemporada(BaseDatos accesoBD, Temporada t) {
        return TemporadaBD.eliminarTemporadaBD(accesoBD, t);
    }

    
    
    public static int InsertarTemporada(int curso, BaseDatos accesoBD) throws SQLException {
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
    }

    public static int getIdTemporada(BaseDatos accesoBD, String temporada) throws SQLException {
        int idTem = TemporadaBD.getIdTemporada(accesoBD, temporada);
        
        return idTem;
    }

    public static String getTemporada(BaseDatos accesoBD, String s) throws SQLException {
        return TemporadaBD.getTemporada(accesoBD, s);
    }

    public static String getTemporada(BaseDatos accesoBD, int idTemp) throws SQLException {
        return TemporadaBD.getTemporada(accesoBD, idTemp);
    }

    private static boolean existeCurso(BaseDatos accesoBD, String cursoNuevoComp) throws SQLException {
        boolean existe = false;  
        String query = "SELECT * FROM Temporada WHERE curso='"+cursoNuevoComp+"'";
        ResultSet res = accesoBD.ejecutaConsulta(query);
      
        if(res.next())      
            existe = true;
        
        return existe;
    }
        
    public  List<Temporada> ConsultarTemporada(String curso){
        return new ArrayList<Temporada>();
    }
    
    public void EliminarTemporada(Temporada temp){
        
    }
    
     //***************************************JAVI******************************************************//  
    public static ResultSet consultarEstadisticasTemporada(BaseDatos accesoBD, int idTemp, int idCate)throws SQLException{
        
        return TemporadaBD.generaEstadisticasTemporada(accesoBD, idTemp, idCate);  
    }
    //***************************************JAVI******************************************************//   
}
