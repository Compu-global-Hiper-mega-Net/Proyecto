package GestionDeTemporadas;

import ServiciosAlmacenamiento.BaseDatos;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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

public class TemporadaBD {

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

    static int insertarTemporadaBD(BaseDatos accesoBD, Temporada t) throws SQLException {
        String query = "INSERT INTO Temporada (curso) VALUES ('"+t.getCurso()+"')";
        int correcto = accesoBD.ejecutaActualizacion(query);
        return correcto;
    }

    static List<String> getListaTemporadas(BaseDatos accesoBD) throws SQLException {
        String query = "SELECT curso FROM Temporada ORDER BY curso DESC";
        ResultSet resCons = accesoBD.ejecutaConsulta(query);
        
        List<String> res = new ArrayList<>();
        
        while(resCons.next()){
            res.add(resCons.getString(1));
        }
        
        return res;
    }

    static int modificarTemporada(BaseDatos accesoBD, String cursoAnterior, String cursoNuevo) throws SQLException {
        int correcto = 0;
        String query = "UPDATE Temporada SET curso='"+cursoNuevo+"' WHERE curso='"+cursoAnterior+"'";
        correcto = accesoBD.ejecutaActualizacion(query);
        
        return correcto;
    }

    static boolean eliminarTemporadaBD(BaseDatos accesoBD, Temporada t) {
        boolean correcto = false;
        String query = "DELETE FROM Temporada WHERE curso='"+t.getCurso()+"'";
        correcto = accesoBD.eliminar(query);
        
        return correcto;
    }

    static int getIdTemporada(BaseDatos accesoBD, String temporada) throws SQLException {
        int idTemp = 0;
        
        String query = "SELECT idTemporada FROM Temporada WHERE curso='"+temporada+"'";
        ResultSet res = accesoBD.ejecutaConsulta(query);
        
        if(res.next())
            idTemp = res.getInt(1);

        return idTemp;
    }

    static String getTemporada(BaseDatos accesoBD, String s) throws SQLException {
        String query = "SELECT curso FROM Temporada WHERE idTemporada='"+s+"'";
        ResultSet res = accesoBD.ejecutaConsulta(query);
        String temp = "";
        
        if(res.next())
            temp = res.getString(1);
        
        return temp;
    }

    static String getTemporada(BaseDatos accesoBD, int idTemp) throws SQLException {
        String query = "SELECT curso FROM Temporada WHERE idTemporada='"+idTemp+"'";
        ResultSet res = accesoBD.ejecutaConsulta(query);
        String temp = "";
        
        if(res.next())
            temp = res.getString(1);
        
        return temp;
    }
    
    //***************************************JAVI******************************************************//  
    public static ResultSet generaEstadisticasTemporada(BaseDatos accesoBD,int idTemp, int idCate)throws SQLException{
        
        String consulta = "SELECT e.nombre,  u.nombre, u.primerApellido, u.segundoApellido, SUM(p.resultadoLocal) FROM equipo e, usuario u, rango r, partido p " +
                          "WHERE e.temporada_idTemporada='"+idTemp+"' AND e.Categoria_idCategoria='"+idCate+"' " +
                          "AND e.idEquipo=r.Equipo_idEquipo AND u.idUsuario=r.Usuario_idUsuario AND r.tipo='PRIMERO' " +
                          "AND e.idEquipo=p.idEquipo GROUP BY p.idEquipo; ";
        ResultSet resSet = accesoBD.ejecutaConsulta(consulta);
       
        if (!resSet.next())
            return null;
        else
            return resSet;
    }
    //***************************************JAVI******************************************************//  
    
}
