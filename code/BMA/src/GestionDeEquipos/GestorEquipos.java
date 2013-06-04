/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionDeEquipos;

import GestionDeCategorias.GestorCategorias;
import InterfazUsuario.NuevoEquipo;
import ServiciosAlmacenamiento.BaseDatos;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author 
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

public class GestorEquipos {

    public static List<Equipo> ConsultaEquipo(BaseDatos accesoBD, String nombre,
                            String temporada, String categoria, String entrenador,boolean fundacion, char sexo) throws SQLException {

        List<Equipo> listaEquipos = new ArrayList();
        Equipo eq;

        String n;
        String temp;
        String cat;
        String entrena;
        String entrena2="";

        ResultSet res = EquipoBD.BuscarEquipos(accesoBD, nombre, temporada, categoria, entrenador);
        
        while (res.next()) {
            n = res.getString(1);
            cat = res.getString(2);
            temp = res.getString(3);
            entrena = res.getString(4);
            eq = new Equipo(n, temp, cat, entrena, entrena2,fundacion, sexo);

            listaEquipos.add(eq);
        }

        return listaEquipos;
    }

    public static List<Equipo> getListaEquipos(BaseDatos accesoBD) throws SQLException{
       
        List<Equipo> equipos = new ArrayList<Equipo>();
        
        equipos = EquipoBD.getListaEquipos(accesoBD);
        
        return equipos;
    }
    
    public static int getIdEquipo(BaseDatos accesoBD, String equipo, String cat) throws SQLException{
        return EquipoBD.getIdEq(accesoBD, equipo, cat);
    }
    
    public static String getEquipo(BaseDatos accesoBD, String s) throws SQLException{
        return EquipoBD.getEquipo(accesoBD,s);
    }
    
    public static boolean EliminarEquipo(BaseDatos accesoBD, Equipo e) throws SQLException {
        
        return EquipoBD.EliminarEquipoBD(accesoBD, e);
    }
    
    public static void InsertarDatosEquipo(BaseDatos accesoBD, String nombre,
            String temporada, String categoria, String entrenador, String entrenador2, boolean fundacion,char sexo) throws SQLException{
                
        boolean validar = EquipoBD.ConsultarEquipo(accesoBD, nombre, temporada, categoria);
        
        if(validar==false)
            JOptionPane.showMessageDialog(new NuevoEquipo(), "El equipo ya existe", "Error", JOptionPane.ERROR_MESSAGE);
        else{
            Equipo equipo;
            equipo = new Equipo(nombre, temporada, categoria, entrenador, entrenador2, fundacion, sexo);
            
            EquipoBD.crearEquipoBD(accesoBD, equipo);
        }
        
    }
    
    public static void InsertarJugadoresEquipo (BaseDatos accesoBD, DefaultListModel modelo, String categoria,
            String nombre) throws SQLException{
        
        int idCategoria = GestorCategorias.getIdCategoria(accesoBD, categoria);
        int idEquipo = EquipoBD.getIdEq(accesoBD, nombre, categoria);
        int idFundacion = EquipoBD.getIDFundacion(accesoBD);
        String nombreCompleto, nombreJugador, pApellido, sApellido;
        
        for(int i = 0; i < modelo.size(); i++){
            ResultSet ret;
            int idAlumno = 0;
            nombreCompleto = (String) modelo.getElementAt(i);
            pApellido = nombreCompleto.substring(0, nombreCompleto.indexOf(" "));
            nombreCompleto = nombreCompleto.substring(nombreCompleto.indexOf(" ")+1, nombreCompleto.length());
            sApellido = nombreCompleto.substring(0, nombreCompleto.indexOf(" "));
            nombreJugador = nombreCompleto.substring(nombreCompleto.indexOf(" ")+1, nombreCompleto.length());
            
            System.out.print("Nombre\n\n"+nombreJugador);
            System.out.print("Nombre\n\n"+pApellido);
            System.out.print("Nombre\n\n"+sApellido);
            
            String consulta = "SELECT idAlumno FROM alumno WHERE nombre = '" + nombreJugador + 
                    "' AND primerApellido = '" + pApellido + "' AND segundoApellido = '"
                    + sApellido + "'";
            
            System.out.print("Consuelo \n\n"+consulta);
            
            ret = accesoBD.ejecutaConsulta(consulta);
            
            if(ret.next()){
                idAlumno = ret.getInt(1);
            }
            
            EquipoBD.InsertarAlumno(accesoBD, idEquipo, idAlumno , idFundacion, idCategoria);
        }
        
        
    }
}
