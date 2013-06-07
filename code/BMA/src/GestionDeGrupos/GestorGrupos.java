package GestionDeGrupos;

import GestionDeAlumnos.Alumno;
import GestionDeAlumnos.GestorAlumnos;
import GestionDeInstalaciones.Instalacion;
import GestionDeTemporadas.GestorTemporadas;
import GestionDeUsuarios.Usuario;
import GestionDeCategorias.Categoria;
import GestionDeTemporadas.Temporada;
import GestionDeUsuarios.GestorUsuarios;
import ServiciosAlmacenamiento.BaseDatos;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
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
 * Clase gestora del paquete GestionDeGrupos. Ofrece una manera de interactuar 
 * con la base de datos y con los objetos de la clase Grupo.
 * @author Diego
 */
public class GestorGrupos {

    private List<Grupo> grupos;
    
    /**
     * Permite obtener una lista de todos los grupos almacenados en la base de datos.
     * @param accesoBD Usado para interactuar con la base de datos.
     * @return Una lista de lista de cadenas cuyo contenido de cada lista son 
     * los datos del grupo.
     * @throws SQLException 
     */
    public static List<List<String>> getListaGrupos(BaseDatos accesoBD) throws SQLException {
        List<List<String>> grupos = new ArrayList<List<String>>();
        grupos = GruposBD.getListaGrupos(accesoBD);
        
        return grupos;
    }

    /**
     * Permite obtener una lista de todos los grupos almacenados en la base de 
     * datos filtrados por una serie de parametros.
     * @param accesoBD Usado para interactuar con la base de datos.
     * @param temporada <code>String</code> con la temporada que queremos 
     * aplicar como filtro.
     * @param categoria <code>String</code> con la categoria que queremos 
     * aplicar como filtro.
     * @param entrenador <code>String</code> con el entrenador que queremos 
     * aplicar como filtro.
     * @return Una lista de lista de cadenas con los grupos seleccionados mediante 
     * el filtro establecido por los parametros.
     * @throws SQLException 
     */
    public static List<List<String>> getListaGruposFiltro(BaseDatos accesoBD, String temporada, String categoria, String entrenador) throws SQLException {
        List<List<String>> grupos = new ArrayList<List<String>>();
        grupos = GruposBD.getListaGruposFiltro(accesoBD, temporada, categoria, entrenador);
        
        return grupos;
    }

    /**
     * Permite obtener la temporada en la que se encuentra un grupo concreto.
     * @param accesoBD Usado para interactuar con la base de datos.
     * @param idGrupo Identificador del grupo del que queremos saber la temporada.
     * @return Un <code>String</code> con la temporada del grupo.
     * @throws SQLException 
     */
    public static String getTemporada(BaseDatos accesoBD, String idGrupo) throws SQLException {
        return GruposBD.getTemporada(accesoBD, idGrupo);
    }

    /**
     * Permite obtener la categoria de un grupo concreto.
     * @param accesoBD Usado para interactuar con la base de datos.
     * @param idGrupo Identificador del grupo del que queremos saber la categoria.
     * @return Un <code>String</code> con la categoria del grupo.
     * @throws SQLException 
     */
    public static String getCategoria(BaseDatos accesoBD, String idGrupo) throws SQLException {
        return GruposBD.getCategoria(accesoBD, idGrupo);
    }

    /**
     * Permite obtener la primera hora de un grupo de entrenamiento.
     * @param accesoBD Usado para interactuar con la base de datos.
     * @param idGrupo Identificador del grupo del que queremos saber la hora.
     * @return Un <code>String</code> con la primera hora del grupo.
     * @throws SQLException 
     */
    public static String getHora1(BaseDatos accesoBD, String idGrupo) throws SQLException {
        return GruposBD.getHora1(accesoBD, idGrupo);
    }

    /**
     * Permite obtener la segunda hora de un grupo de entrenamiento.
     * @param accesoBD Usado para interactuar con la base de datos.
     * @param idGrupo Identificador del grupo del que queremos saber la hora.
     * @return Un <code>String</code> con la segunda hora del grupo.
     * @throws SQLException 
     */
    public static String getHora2(BaseDatos accesoBD, String idGrupo) throws SQLException {
        return GruposBD.getHora2(accesoBD, idGrupo);
    }

    /**
     * Permite obtener el primer dia de entrenamiento de un grupo.
     * @param accesoBD Usado para interactuar con la base de datos.
     * @param idGrupo Identificador del grupo del que queremos saber el primer dia
     * de la semana que entrena.
     * @return Un <code>String</code> con el primer dia de entrenamiento del grupo.
     * @throws SQLException 
     */
    public static String getDia1(BaseDatos accesoBD, String idGrupo) throws SQLException {
        return GruposBD.getDia1(accesoBD, idGrupo);
    }

    /**
     * Permite obtener el segundo dia de entrenamiento de un grupo.
     * @param accesoBD Usado para interactuar con la base de datos.
     * @param idGrupo Identificador del grupo del que queremos saber el segundo dia
     * de la semana que entrena.
     * @return Un <code>String</code> con el segundo dia de entrenamiento del grupo.
     * @throws SQLException 
     */
    public static String getDia2(BaseDatos accesoBD, String idGrupo) throws SQLException {
        return GruposBD.getDia2(accesoBD, idGrupo);
    }

    /**
     * Permite obtener la instalacion donde entrena un grupo de entrenamiento.
     * @param accesoBD Usado para interactuar con la base de datos.
     * @param idGrupo Identificador del grupo del que queremos saber la instalacion.
     * @return Un <code>String</code> con la instalacion donde entrena el grupo 
     * pasado por parametro.
     * @throws SQLException 
     */
    public static String getInstalacion(BaseDatos accesoBD, String idGrupo) throws SQLException {
        return GruposBD.getInstalacion(accesoBD, idGrupo);
    }

    /**
     * Permite obtener una lista de los alumnos introducidos en un grupo concreto.
     * @param accesoBD Usado para interactuar con la base de datos.
     * @param idGrupo Identificador del grupo del que queremos obtener los alumnos.
     * @return Una lista de <code>String</code> con los alumnos que componen el grupo.
     * @throws SQLException 
     */
    public static List<String> getListaAlumnosIntroducidos(BaseDatos accesoBD, String idGrupo) throws SQLException {
        return GruposBD.getListaAlumnosIntroducidos(accesoBD, idGrupo);
    }

    /**
     * Permite eliminar un alumno concreto de un grupo de entrenamiento.
     * @param accesoBD Usado para interactuar con la base de datos.
     * @param idGrupo Identificador del grupo del que queremos eliminar el alumno.
     * @param idAl Identificador del alumno que queremos eliminar.
     * @throws SQLException 
     */
    public static void eliminarAlumnoIntroducido(BaseDatos accesoBD, int idGrupo, int idAl) throws SQLException {
        GruposBD.eliminarAlumnoIntroducido(accesoBD, idGrupo, idAl);
    }

    /**
     * Permite obtener el nombre del entrenador de un grupo de entrenamiento.
     * @param accesoBD Usado para interactuar con la base de datos.
     * @param idGrupo Identificador del grupo del que queremos saber el entrenador.
     * @return Un <code>String</code> con el nombre del entrenador del grupo.
     * @throws SQLException 
     */
    public static String getEntrenador(BaseDatos accesoBD, String idGrupo) throws SQLException {
        return GruposBD.getEntrenador(accesoBD, idGrupo);
    }

    //public static void modificarGrupo(BaseDatos accesoBD, Grupo g, String idGrupo) {
        //Grupo.Modificar(g);
    //}

    /**
     * Permite modificar un grupo con nuevos datos.
     * @param accesoBD Usado para interactuar con la base de datos.
     * @param gNuevo Objeto de la clase Grupo con los nuevos datos que queremos 
     * modificar.
     * @param gViejo Objeto de la clase Grupo con los antiguos datos que van a 
     * ser modificados.
     * @param idGrupo Identificador del grupo del que queremos cambiar datos.
     * @param listaAlumnos Lista con los alumnos que queremos modificar del grupo.
     * @throws SQLException 
     */
    public static void modificarGrupo(BaseDatos accesoBD, Grupo gNuevo, Grupo gViejo, String idGrupo, List<String> listaAlumnos) throws SQLException {
        Grupo.Modificar(accesoBD, gNuevo, gViejo, idGrupo, listaAlumnos);
    }

    /**
     * Permite obtener el identificador de la temporada de un grupo concreto.
     * @param accesoBD Usado para interactuar con la base de datos.
     * @param idGrup Identificador del grupo del que queremos saber el 
     * identificador de temporada.
     * @return Un <code>int</code> con el identificador de la temporada del grupo 
     * de entrenamiento.
     * @throws SQLException 
     */
    public static int getIdTemporada(BaseDatos accesoBD, int idGrup) throws SQLException {
        return GruposBD.getIdTemporada(accesoBD, idGrup);
    }

    /**
     * Permite eliminar un grupo de la base de datos.
     * @param accesoBD Usado para interactuar con la base de datos.
     * @param g Objeto de la clase Grupo que queremos eliminar.
     * @return TRUE si se ha eliminado con exito, FALSE en caso contrario.
     * @throws SQLException 
     */
    public static boolean EliminarGrupos(BaseDatos accesoBD, Grupo g) throws SQLException {
        boolean GrupoEliminado = GruposBD.EliminarGrupo(accesoBD, g);
        return GrupoEliminado;
    }

    /**
     * Permite comprobar si un alumno ya esta dado de alta en una temporada concreta.
     * @param bd Usado para interactuar con la base de datos.
     * @param idAl Identificador con el alumno del que queremos saber si se 
     * encuentra en la temporada.
     * @param idTemp Identificador de la temporada para comprobar si el alumno 
     * esta en dicha temporada.
     * @return TRUE si el alumno esta en la temporada, FALSE en caso contrario.
     * @throws SQLException 
     */
    static boolean existeAlumnoTemporada(BaseDatos bd, int idAl, int idTemp) throws SQLException {
        return GruposBD.existeAlumnoTemporada(bd, idAl, idTemp);
    }

    /**
     * Permite saber si un alumno esta en dos grupos de entrenamiento.
     * @param accesoBD Usado para interactuar con la base de datos.
     * @param idAl Identificador con el alumno del que queremos saber si esta 
     * en dos grupos de entrenamiento.
     * @param idTemp Identificador de la temporada.
     * @return TRUE si el alumno esta en dos grupos de entrenamiento, FALSE en 
     * caso contrario.
     * @throws SQLException 
     */
    static boolean existeAlumnoEnDosGrupos(BaseDatos accesoBD, int idAl, int idTemp) throws SQLException {
        return GruposBD.existeAlumnoEnDosGrupos(accesoBD, idAl, idTemp);
    }

    /**
     * Inserta un nuevo grupo en la base de datos.
     * @param accesoBD Usado para interactuar con la base de datos.
     * @param listaAlumnos Lista con los alumnos que queremos introducir en el grupo.
     * @param temporada Contiene el curso de la temporada en la que queremos 
     * introducir el nuevo grupo.
     * @param categoria Contiene la categoria del grupo que queremos crear.
     * @param dia1 Contiene el primer dia de entrenamiento del grupo que queremos crear.
     * @param dia2 Contiene el segundo dia de entrenamiento del grupo que queremos crear.
     * @param hora Contiene la hora del grupo de entrenamiento que vamos a crear.
     * @param min Contiene los minutos del grupo de entrenamiento que vamos a crear.
     * @param entrenador <code>String</code> con el nombre del entrenador que 
     * vamos a asignar al grupo.
     * @param instalacion Contiene el nombre de la instalacion donde va a 
     * entrenar el grupo.
     * @throws ParseException
     * @throws SQLException 
     */
    public static void insertarDatosGrupo(BaseDatos accesoBD, List<String> listaAlumnos, 
            String temporada, String categoria, String dia1, 
            String dia2, String hora, String min, String entrenador, String instalacion) throws ParseException, SQLException {
        
        boolean validar = GruposBD.ConsultarGrupos(accesoBD, dia1, dia2, hora, min, categoria, instalacion);
        if(validar == false)
            JOptionPane.showMessageDialog(null, "El grupo ya existe", "Error", JOptionPane.ERROR_MESSAGE);
        else{
            List<Integer> listaIDAl = new ArrayList<Integer>();
            listaIDAl = GestorAlumnos.getIdAl(accesoBD, listaAlumnos);
            
            int idEnt = GestorUsuarios.getIdEnt(accesoBD, entrenador);
            
            /***************************************************************/
            /**CODIGO PROVISIONAL HASTA TENER IMPLEMENTACION DE CATEGORIA **/
            String query1 = "SELECT idCategoria FROM Categoria WHERE tipo='"+categoria+"'";
            ResultSet res1 = accesoBD.ejecutaConsulta(query1);
            int idCat = 0;
            if(res1.next())
                idCat = res1.getInt(1);
            /***************************************************************/
            /***************************************************************/
            
            int idTemp = GestorTemporadas.getIdTemporada(accesoBD, temporada);
            
            /***************************************************************/
            /**CODIGO PROVISIONAL HASTA TENER IMPLEMENTACION DE INSTALACIONES **/
            String auxString = instalacion.substring(0, instalacion.indexOf(","));
            String query2 = "SELECT idInstalacion FROM Instalacion WHERE nombre='"+auxString+"'";
            ResultSet res2 = accesoBD.ejecutaConsulta(query2);
            int idInst = 0;
            if(res2.next())
                idInst = res2.getInt(1);
            /***************************************************************/
            /***************************************************************/
            Grupo g = new Grupo(temporada, dia1, dia2, hora, min, entrenador, categoria, auxString);
            
            GruposBD.crearGruposBD(accesoBD, g, listaIDAl, idEnt, idCat, idTemp, idInst);
        }
       
    }
    
    /*public void InsertarGrupo(BaseDatos accesoBD, Temporada temp, List<Alumno> als, Categoria cat, Horario hor, Usuario ent, Instalacion inst) throws SQLException{
        boolean validar = GruposBD.ConsultarGrupos(accesoBD, temp, cat, hor, inst);
    }*/
    
    //public List<Grupo> ConsultarGrupo(Temporada t, List<Alumno> a, Categoria c, Usuario ent, Instalacion inst){
      //  return new ArrayList<Grupo>();
    //}
    
    //public void ModificarGrupo(Grupo g){
        
    //}
    
    //public void EliminarGrupo(Grupo g){
        
    //}
}
