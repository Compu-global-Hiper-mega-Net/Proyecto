package GestionDeGrupos;

import GestionDeAlumnos.GestorAlumnos;
import GestionDeCategorias.GestorCategorias;
import GestionDePagos.GestorPagos;
import GestionDeTemporadas.GestorTemporadas;
import GestionDeUsuarios.GestorUsuarios;
import InterfazUsuario.PantallaPrincipal;
import ServiciosAlmacenamiento.BaseDatos;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
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
 * Clase gestora de la BD que hace de mediadora entre la base de datos y nuestro
 * sistema.
 *
 * @author Diego y Carlos
 */
public class GruposBD {

    /**
     * Permite saber si un grupo ya ha sido almacenado.
     *
     * @param accesoBD Usado para interactuar con la base de datos.
     * @param dia1 Primer dia de entrenamiento.
     * @param dia2 Segundo dia de entrenamiento.
     * @param hora Hora del entrenamiento.
     * @param min Minuto del entrenamiento.
     * @param cat Categoria del grupo de entrenamiento.
     * @param instalacion Lugar donde se realiza el entrenamiento.
     * @return TRUE si el equipo no ha sido creado y FALSE en caso contrario.
     * @throws SQLException
     */
    static boolean ConsultarGrupos(BaseDatos accesoBD, String dia1, String dia2, String hora, String min, String cat, String instalacion) throws SQLException {
        /*boolean validar = false;
        
         String query = "SELECT * FROM Horario, Usuario, Grupo "
         + "WHERE Horario.dia1='"+dia1+"' "
         + "AND Horario.hora1='"+hora+"' "
         + "AND Grupo.Usuario_idUsuario=Usuario.idUsuario";
        
         ResultSet res = accesoBD.ejecutaConsulta(query);
         if(res.next())
         validar = false;
         else
         validar = true;
        
         return validar;*/


        boolean validar = false;

        String query = "SELECT idCategoria FROM Categoria WHERE tipo='" + cat + "'";

        ResultSet res = accesoBD.ejecutaConsulta(query);
        int idCat = 0;
        while (res.next()) {
            idCat = res.getInt(1);
        }

        /*query = "SELECT count(*) from mydb.categoria, mydb.Grupo, mydb.horario, mydb.instalacion where "
                + "horario.Instalacion_idInstalacion=instalacion.idInstalacion AND "
                + "horario.hora1='18:00:00' AND grupo.categoria_idCategoria=categoria.idCategoria AND "
                + "grupo.Categoria_idCategoria='1' ";*/
        
        query = "SELECT count(*) from mydb.categoria, mydb.Grupo, mydb.horario, mydb.instalacion where "
                + "horario.Instalacion_idInstalacion=instalacion.idInstalacion AND "
                + "horario.hora1='"+hora+":"+min+":00' AND grupo.categoria_idCategoria=categoria.idCategoria AND "
                + "grupo.Categoria_idCategoria='1' ";

        res = accesoBD.ejecutaConsulta(query);

        int nCons = 0, nCons2 = 0;
        while (res.next()) {
            nCons = res.getInt(1);
        }

        nCons = nCons * 1;

        /*query = "select count(*) from mydb.categoria, mydb.Grupo, mydb.horario, mydb.instalacion where "
                + "horario.Instalacion_idInstalacion=instalacion.idInstalacion AND "
                + "horario.hora1='18:00:00' AND grupo.categoria_idCategoria=categoria.idCategoria AND "
                + "grupo.Categoria_idCategoria<>'1' ";*/
        
        query = "select count(*) from mydb.categoria, mydb.Grupo, mydb.horario, mydb.instalacion where "
                + "horario.Instalacion_idInstalacion=instalacion.idInstalacion AND "
                + "horario.hora1='"+hora+":"+min+"00' AND grupo.categoria_idCategoria=categoria.idCategoria AND "
                + "grupo.Categoria_idCategoria<>'1' ";
        res = accesoBD.ejecutaConsulta(query);

        while (res.next()) {
            nCons2 = res.getInt(1);
        }
        nCons2 = nCons2 * 2;



        instalacion = instalacion.substring(0, instalacion.indexOf(",", 0));

        query = "SELECT idInstalacion FROM instalacion WHERE nombre='" + instalacion + "'";
        res = accesoBD.ejecutaConsulta(query);
        int idInst = 0;
        while (res.next()) {
            idInst = res.getInt(1);
        }

        query = "SELECT capacidadEquipos FROM instalacion WHERE idInstalacion='" + idInst + "'";
        res = accesoBD.ejecutaConsulta(query);

        int capacidad = 0;
        while (res.next()) {
            capacidad = res.getInt(1);
        }

        int resta = capacidad - (nCons + nCons2);


        if (resta == 0) {
            JOptionPane.showMessageDialog(null, "La instalacion esta llena", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (idCat != 1 && resta == 1) {
            JOptionPane.showMessageDialog(null, "No hay capacidad", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            validar = true;
        }


        return validar;
    }

    /**
     * Crea un grupo nuevo en la Base de Datos con todos los parametros
     * necesarios.
     *
     * @param accesoBD Usado para interactuar con la base de datos.
     * @param g Grupo que se va a crear.
     * @param listaIDAl Lista de alumnos que va a tener el grupo.
     * @param idEnt Identificador del entrenador que tendrá el grupo.
     * @param idCat Identificador de la categoria que tendrá el grupo.
     * @param idTemp Identificador de la temporada que tendrá el grupo.
     * @param idInst Identificador de la instalacion que tendrá el grupo.
     * @throws SQLException
     */
    static void crearGruposBD(BaseDatos accesoBD, Grupo g, List<Integer> listaIDAl, int idEnt, int idCat, int idTemp, int idInst) throws SQLException {
        boolean eliminar = false;
        String dia1, dia2;
        dia1 = g.getDia1();
        dia2 = g.getDia2();
        Time hora = g.getHora1Time();

        String query1 = "INSERT INTO Horario (Instalacion_IdInstalacion, "
                + "dia1, dia2, hora1, hora2) VALUES "
                + "('" + idInst + "','" + dia1 + "','" + dia2 + "','" + hora + "','" + hora + "')";
        int res1 = accesoBD.ejecutaActualizacion(query1);


        //Comentado para intentar solucionar la eliminacion de grupos
        /*String query2 = "SELECT idHorario FROM Horario WHERE "
         + "Instalacion_idInstalacion='" + idInst + "'"
         + " AND dia1='" + dia1 + "' AND dia2='" + dia2 + "' AND hora1='" + hora + "'";
         ResultSet res2 = accesoBD.ejecutaConsulta(query2);
         int idHorario = 0;
         if (res2.next()) {
         idHorario = res2.getInt(1);
         }*/


        //Intento de solucion para eliminar grupo
        query1 = "SELECT DISTINCT LAST_INSERT_ID() FROM Horario";
        ResultSet res2 = accesoBD.ejecutaConsulta(query1);
        int idHorario = 0;
        if (res2.next()) {
            idHorario = res2.getInt(1);
        }


        String query3 = "INSERT INTO Grupo (n_alumnos, Categoria_idCategoria, "
                + "Usuario_idUsuario, Temporada_idTemporada, Horario_idHorario, "
                + "Horario_Instalacion_idInstalacion) VALUES "
                + "('" + listaIDAl.size() + "','" + idCat + "','" + idEnt + "','" + idTemp + "',"
                + "'" + idHorario + "'," + "'" + idInst + "')";
        int res3 = accesoBD.ejecutaActualizacion(query3);


        String query4 = "SELECT idGrupo FROM Grupo WHERE "
                + "Categoria_idCategoria='" + idCat + "' "
                + "AND Usuario_idUsuario='" + idEnt + "' "
                + "AND Temporada_idTemporada='" + idTemp + "' "
                + "AND Horario_idHorario='" + idHorario + "' "
                + "AND Horario_Instalacion_idInstalacion='" + idInst + "'";
        ResultSet res4 = accesoBD.ejecutaConsulta(query4);
        int idGrupo = 0;
        if (res4.next()) {
            idGrupo = res4.getInt(1);
        }

        String query5 = "";
        int res5 = 0;
        boolean existeAl;
        int curso = GestorTemporadas.getAnio(accesoBD, idTemp);
        int auxcurso;
        int auxCont = 9;
        int idCuota = 0;
        boolean alumnoTresGrupos = false;
        boolean salir = false;
        
        for (Integer it : listaIDAl) {            
            if(!salir){
                alumnoTresGrupos = GestorGrupos.AlumnoTresGrupos(accesoBD, it, idTemp);
                
                if(alumnoTresGrupos){
                    String nomAlumno = GestorAlumnos.getNombreAlumno(accesoBD, it);
                    JOptionPane.showMessageDialog(null, "El alumno "+nomAlumno+" ya esta en dos grupos.", "Error", JOptionPane.ERROR_MESSAGE);
                    salir = true;
                }
                
                query5 = "INSERT INTO Alumnogrupo (Alumno_idAlumno, Grupo_idGrupo, "
                    + "Grupo_Categoria_idCategoria, Grupo_Usuario_idUsuario, "
                    + "Grupo_Temporada_idTemporada) VALUES "
                    + "('" + it + "','" + idGrupo + "','" + idCat + "','" + idEnt + "','" + idTemp + "')";
                res5 = accesoBD.ejecutaActualizacion(query5);


                existeAl = GestorGrupos.existeAlumnoTemporada(accesoBD, it, idTemp);
                if (!existeAl) {

                    query5 = "INSERT INTO AlumnoTemporada (Alumno_idAlumno,"
                        + "Temporada_idTemporada) VALUES "
                        + "('" + it + "','" + idTemp + "')";
                    res5 = accesoBD.ejecutaActualizacion(query5);
                    auxcurso = curso;
                    auxCont = 9;
                    for (int i = 0; i < 9; i++) {

                        query5 = "INSERT INTO Cuota (fecha,pagado) VALUES "
                            + "('" + auxcurso + "-" + auxCont + "-1','0')";
                        res5 = accesoBD.ejecutaActualizacion(query5);

                        query5 = "SELECT DISTINCT LAST_INSERT_ID() FROM Cuota";
                        res4 = accesoBD.ejecutaConsulta(query5);
                        if (res4.next()) {
                        idCuota = res4.getInt(1);
                        }

                        query5 = "INSERT INTO PagoTemporada "
                            + "(Cuota_idCuota,AlumnoTemporada_Alumno_idAlumno,"
                            + "AlumnoTemporada_Temporada_idTemporada) VALUES "
                            + "('" + idCuota + "','" + it + "','" + idTemp + "')";
                        res5 = accesoBD.ejecutaActualizacion(query5);

                        auxCont++;
                        if (auxCont > 12) {
                            auxCont = 1;
                            auxcurso = auxcurso + 1;
                        }
                    }
                }
            }
        }
    }

    /**
     * Permite obtener una lista de todos los alumnos disponibles en la BD.
     *
     * @param accesoBD Usado para interactuar con la base de datos.
     * @return Devuelve una lista de listas cuyo contenido es el identificador
     * del grupo, el numero de alumnos del grupo, el identificador de la
     * categoria del grupo, el identificador del entrenador del grupo y el
     * identificador de la temporada del grupo.
     * @throws SQLException
     */
    static List<List<String>> getListaGrupos(BaseDatos accesoBD) throws SQLException {
        List<List<String>> grupos = new ArrayList<>();

        String query = "SELECT idGrupo, n_alumnos, Categoria_idCategoria, "
                + "Usuario_idUsuario, Temporada_idTemporada "
                + "FROM Grupo";
        ResultSet res = accesoBD.ejecutaConsulta(query);

        List<String> aux;

        while (res.next()) {
            aux = new ArrayList<>();
            aux.add(res.getString(1) + "," + res.getString(2) + "," + res.getString(3) + "," + res.getString(4) + "," + res.getString(5));
            grupos.add(aux);
        }

        return grupos;
    }

    /**
     * Permite obtener una lista de los grupos filtrandolo con ciertos datos.
     *
     * @param accesoBD Usado para interactuar con la base de datos.
     * @param temporada Un String con la temporada por la que queremos filtrar.
     * @param categoria Un String con la categoria por la que queremos filtrar.
     * @param entrenador Un String con el entrenador por el que queremos
     * filtrar.
     * @return Devuelve una lista de listas cuyo contenido es el identificador
     * del grupo, el numero de alumnos del grupo, el identificador de la
     * categoria del grupo, el identificador del entrenador del grupo y el
     * identificador de la temporada del grupo que coincidan con los filtros
     * establecidos.
     * @throws SQLException
     */
    static List<List<String>> getListaGruposFiltro(BaseDatos accesoBD, String temporada, String categoria, String entrenador) throws SQLException {
        int idTemp = 0, idCat = 0, idEnt = 0;

        if (temporada != "-Ninguno-") {
            idTemp = GestorTemporadas.getIdTemporada(accesoBD, temporada);
        }


        if (categoria != "-Ninguno-") {
            idCat = GestorCategorias.getIdCategoria(accesoBD, categoria);
        }


        if (entrenador != "-Ninguno-") {
            idEnt = GestorUsuarios.getIdEnt(accesoBD, entrenador);
        }

        List<List<String>> grupos = new ArrayList<List<String>>();
        String query;
        /*String query = "SELECT idGrupo, n_alumnos, Categoria_idCategoria, "
         + "Usuario_idUsuario, Temporada_idTemporada "
         + "FROM Grupo WHERE Categoria_idCategoria='"+idCat+"' AND "
         + "Usuario_idUsuario='"+idEnt+"' AND "
         + "Temporada_idTemporada='"+idTemp+"'";*/

        if (idEnt != 0 || idCat != 0 || idTemp != 0) {
            query = "SELECT idGrupo, n_alumnos, Categoria_idCategoria, "
                    + "Usuario_idUsuario, Temporada_idTemporada "
                    + "FROM Grupo WHERE";
        } else {
            query = "SELECT idGrupo, n_alumnos, Categoria_idCategoria, "
                    + "Usuario_idUsuario, Temporada_idTemporada "
                    + "FROM Grupo ";
        }

        if (idEnt != 0) {
            query = query.concat(" Usuario_idUsuario='" + idEnt + "' AND");
        }


        if (idCat != 0) {
            query = query.concat(" Categoria_idCategoria='" + idCat + "' AND");
        }

        if (idTemp != 0) {
            query = query.concat(" Temporada_idTemporada='" + idTemp + "' AND");
        }


        if (idEnt != 0 || idCat != 0 || idTemp != 0) {
            query = query.substring(0, query.length() - 4);
        }

        ResultSet res = accesoBD.ejecutaConsulta(query);



        List<String> aux;

        while (res.next()) {
            aux = new ArrayList<String>();
            aux.add(res.getString(1) + "," + res.getString(2) + "," + res.getString(3) + "," + res.getString(4) + "," + res.getString(5));
            grupos.add(aux);
        }

        return grupos;
    }

    /**
     * Permite obtener un String con la temporada en la que se encuentra el
     * grupo pasado por parametro.
     *
     * @param accesoBD Usado para interactuar con la base de datos.
     * @param idGrupo String con el identificador del grupo del que queremos
     * saber la temporada.
     * @return Un String con la temporada del grupo pasado por parametro.
     * @throws SQLException
     */
    static String getTemporada(BaseDatos accesoBD, String idGrupo) throws SQLException {

        String query = "SELECT Temporada_idTemporada FROM Grupo WHERE "
                + "idGrupo='" + idGrupo + "'";
        ResultSet res = accesoBD.ejecutaConsulta(query);

        int idTemp = 0;
        if (res.next()) {
            idTemp = res.getInt(1);
        }



        String temp = GestorTemporadas.getTemporada(accesoBD, idTemp);
        return temp;
    }

    /**
     * Permite obtener la categoria del grupo pasado por parametro.
     *
     * @param accesoBD Usado para interactuar con la base de datos.
     * @param idGrupo <code>String</code> con el identificador del grupo del que
     * queremos saber la categoria.
     * @return Un <code>String</code> con la categoria del grupo.
     * @throws SQLException
     */
    static String getCategoria(BaseDatos accesoBD, String idGrupo) throws SQLException {
        String query = "SELECT Categoria_idCategoria FROM Grupo WHERE "
                + "idGrupo='" + idGrupo + "'";

        ResultSet res = accesoBD.ejecutaConsulta(query);

        int idCat = 0;
        if (res.next()) {
            idCat = res.getInt(1);
        }

        return GestorCategorias.getCategoria(accesoBD, idCat);
    }

    /**
     * Permite obtener la hora a la que entrena un grupo.
     *
     * @param accesoBD Usado para interactuar con la base de datos.
     * @param idGrupo <code>String</code> con el identificador del grupo del que
     * queremos saber la hora de entrenamiento.
     * @return Devuelve un <code>String</code> con la hora de entrenamiento del
     * grupo cuyo identificador es <code>idGrupo</code>.
     * @throws SQLException
     */
    static String getHora1(BaseDatos accesoBD, String idGrupo) throws SQLException {
        String query = "SELECT Horario_idHorario FROM Grupo WHERE "
                + "idGrupo='" + idGrupo + "'";
        ResultSet res = accesoBD.ejecutaConsulta(query);

        int idHor = 0;
        if (res.next()) {
            idHor = res.getInt(1);
        }

        String query2 = "SELECT hora1 FROM Horario WHERE "
                + "idHorario='" + idHor + "'";
        ResultSet res2 = accesoBD.ejecutaConsulta(query2);

        String hora1 = "";
        if (res2.next()) {
            hora1 = res2.getString(1);
        }

        return hora1;
    }

    /**
     * Permite obtener la hora a la que entrena un grupo.
     * @param accesoBD Usado para interactuar con la base de datos.
     * @param idGrupo <code>String</code> con el identificador del grupo del que
     * queremos saber la hora de entrenamiento.
     * @return Devuelve un <code>String</code> con la hora de entrenamiento del
     * grupo cuyo identificador es <code>idGrupo</code>.
     * @throws SQLException 
     */
    static String getHora2(BaseDatos accesoBD, String idGrupo) throws SQLException {
        String query = "SELECT Horario_idHorario FROM Grupo WHERE "
                + "idGrupo='" + idGrupo + "'";
        ResultSet res = accesoBD.ejecutaConsulta(query);

        int idHor = 0;
        if (res.next()) {
            idHor = res.getInt(1);
        }

        String query2 = "SELECT hora2 FROM Horario WHERE "
                + "idHorario='" + idHor + "'";
        ResultSet res2 = accesoBD.ejecutaConsulta(query2);

        String hora2 = "";
        if (res2.next()) {
            hora2 = res2.getString(1);
        }

        return hora2;
    }

    /**
     * Permite saber el primer dia de entrenamiento de un grupo de
     * entrenamiento.
     *
     * @param accesoBD Usado para interactuar con la base de datos.
     * @param idGrupo <code>String</code> con el identificador del grupo del que
     * queremos saber el primer dia de entrenamiento.
     * @return Un <code>String</code> con el primer dia de entrenamiento del
     * grupo cuyo identificador es <code>idGrupo</code>.
     * @throws SQLException
     */
    static String getDia1(BaseDatos accesoBD, String idGrupo) throws SQLException {
        String query = "SELECT Horario_idHorario FROM Grupo WHERE "
                + "idGrupo='" + idGrupo + "'";
        ResultSet res = accesoBD.ejecutaConsulta(query);

        int idHor = 0;
        if (res.next()) {
            idHor = res.getInt(1);
        }

        String query2 = "SELECT dia1 FROM Horario WHERE "
                + "idHorario='" + idHor + "'";
        ResultSet res2 = accesoBD.ejecutaConsulta(query2);

        String dia1 = "";
        if (res2.next()) {
            dia1 = res2.getString(1);
        }



        return dia1;
    }

    /**
     * Permite saber el segundo dia de entrenamiento de un grupo de
     * entrenamiento.
     *
     * @param accesoBD Usado para interactuar con la base de datos.
     * @param idGrupo <code>String</code> con el identificador del grupo del que
     * queremos saber el segundo dia de entrenamiento.
     * @return Un <code>String</code> con el segundo dia de entrenamiento del
     * grupo cuyo identificador es <code>idGrupo</code>.
     * @throws SQLException
     */
    static String getDia2(BaseDatos accesoBD, String idGrupo) throws SQLException {
        String query = "SELECT Horario_idHorario FROM Grupo WHERE "
                + "idGrupo='" + idGrupo + "'";
        ResultSet res = accesoBD.ejecutaConsulta(query);

        int idHor = 0;
        if (res.next()) {
            idHor = res.getInt(1);
        }

        String query2 = "SELECT dia2 FROM Horario WHERE "
                + "idHorario='" + idHor + "'";
        ResultSet res2 = accesoBD.ejecutaConsulta(query2);

        String dia2 = "";
        if (res2.next()) {
            dia2 = res2.getString(1);
        }

        return dia2;
    }

    /**
     * Permite saber la instalacion donde entrena un grupo de entrenamiento.
     *
     * @param accesoBD Usado para interactuar con la base de datos.
     * @param idGrupo <code>String</code> con el identificador del grupo del que
     * queremos saber la instalacion donde entrena.
     * @return Un <code>String</code> con el nombre de la instalacion donde
     * entrena el grupo cuyo identificador es <code>idGrupo</code>.
     * @throws SQLException
     */
    static String getInstalacion(BaseDatos accesoBD, String idGrupo) throws SQLException {
        String query = "SELECT Horario_idHorario FROM Grupo WHERE "
                + "idGrupo='" + idGrupo + "'";
        ResultSet res = accesoBD.ejecutaConsulta(query);

        int idHor = 0;
        if (res.next()) {
            idHor = res.getInt(1);
        }

        String query2 = "SELECT Instalacion_idInstalacion FROM Horario WHERE "
                + "idHorario='" + idHor + "'";
        ResultSet res2 = accesoBD.ejecutaConsulta(query2);



        int idInst = 0;
        if (res2.next()) {
            idInst = res2.getInt(1);
        }

        String query3 = "SELECT nombre, localizacion FROM Instalacion WHERE "
                + "idInstalacion='" + idInst + "'";
        ResultSet res3 = accesoBD.ejecutaConsulta(query3);



        String inst = "";
        if (res3.next()) {
            inst = (res3.getString(1) + "," + res3.getString(2));
        }



        return inst;
    }

    /**
     * Permite obtener una lista de los alumnos de un grupo.
     *
     * @param accesoBD Usado para interactuar con la base de datos.
     * @param idGrupo <code>String</code> con el identificador del grupo del que
     * queremos obtener la lista de alumnos.
     * @return Un <code>List&lt String &gt </code> con la lista de alumnos que
     * tiene el grupo cuyo identificador es <code>idGrupo</code>.
     * @throws SQLException
     */
    static List<String> getListaAlumnosIntroducidos(BaseDatos accesoBD, String idGrupo) throws SQLException {

        String query = "SELECT Alumno_idAlumno From AlumnoGrupo WHERE "
                + "Grupo_idGrupo='" + idGrupo + "'";
        ResultSet res = accesoBD.ejecutaConsulta(query);


        int idAl = 0;
        String query2 = "";
        ResultSet res2 = null;

        List<String> als = new ArrayList<String>();

        while (res.next()) {
            idAl = res.getInt(1);
            query2 = "SELECT nombre, primerApellido, segundoApellido FROM Alumno "
                    + "WHERE idAlumno='" + idAl + "'";
            res2 = accesoBD.ejecutaConsulta(query2);
            res2.next();
            als.add(res2.getString(2) + " " + res2.getString(3) + " " + res2.getString(1));
        }

        return als;
    }

    /**
     * Permite eliminar un alumno de un grupo concreto.
     *
     * @param accesoBD Usado para interactuar con la base de datos.
     * @param idGrupo <code>int</code> con el identificador del grupo del que
     * queremos eliminar un alumno.
     * @param idAl <code>int</code> con el identificador del alumno que queremos
     * eliminar del grupo.
     * @throws SQLException
     */
    static void eliminarAlumnoIntroducido(BaseDatos accesoBD, int idGrupo, int idAl) throws SQLException {
        ResultSet resSet;
        boolean res;
        List<Integer> idCuotas = new ArrayList<Integer>();
        String query = null;

        int idTemp = GestorGrupos.getIdTemporada(accesoBD, idGrupo);

        boolean existe = GestorGrupos.existeAlumnoEnDosGrupos(accesoBD, idAl, idTemp);
        if (!existe) {
            idCuotas = GestorPagos.getIdCuotas(accesoBD, idAl, idTemp);

            query = "DELETE FROM PagoTemporada WHERE "
                    + "AlumnoTemporada_Alumno_idAlumno='" + idAl + "' AND "
                    + "AlumnoTemporada_Temporada_idTemporada='" + idTemp + "'";
            res = accesoBD.eliminar(query);

            for (Integer i : idCuotas) {
                query = "DELETE FROM Cuota WHERE "
                        + "idCuota='" + i + "'";
                res = accesoBD.eliminar(query);
            }
        }


        query = "DELETE FROM AlumnoGrupo WHERE "
                + "Alumno_idAlumno='" + idAl + "' AND Grupo_idGrupo='" + idGrupo + "'";

        res = accesoBD.eliminar(query);




        /* Con esto se actualiza el numero de alumnos en el grupo */
        query = "SELECT n_alumnos FROM Grupo WHERE "
                + "idGrupo='" + idGrupo + "'";
        resSet = accesoBD.ejecutaConsulta(query);
        int nAls = 0;

        if (resSet.next()) {
            nAls = resSet.getInt(1);
        }

        nAls = nAls - 1;

        query = "UPDATE Grupo SET n_alumnos='" + nAls + "' WHERE "
                + "idGrupo='" + idGrupo + "'";
        int nRes = accesoBD.ejecutaActualizacion(query);


        /* if (res) {
         System.out.println("se ha eliminado");
         } else {
         System.out.println("no se ha eliminado");
         }*/
    }

    /**
     * Permite obtener el entrenador asignado en un grupo
     *
     * @param accesoBD Usado para interactuar con la base de datos.
     * @param idGrupo <code>String</code> con el identificador del grupo del que
     * queremos saber el entrenador.
     * @return Un <code>String</code> con el entrenador del grupo cuyo
     * identificador es <code>idGrupo</code>.
     * @throws SQLException
     */
    static String getEntrenador(BaseDatos accesoBD, String idGrupo) throws SQLException {
        String query = "SELECT Usuario_idUsuario FROM Grupo WHERE "
                + "idGrupo='" + idGrupo + "'";
        ResultSet res = accesoBD.ejecutaConsulta(query);

        int idEnt = 0;
        if (res.next()) {
            idEnt = res.getInt(1);
        }

        String ent = GestorUsuarios.getEntrenador(accesoBD, idEnt);

        return ent;
    }

    //static void ModificarGruposBD(Grupo g) {
    //  throw new UnsupportedOperationException("Not yet implemented");
    //}
    /**
     * Permite modificar un grupo de la base de datos cambiandole ciertos
     * campos.
     *
     * @param accesoBD Usado para interactuar con la base de datos.
     * @param gNuevo Objeto de la clase Grupo que contiene los nuevos parametros
     * a modificar.
     * @param gViejo Objeto de la clase Grupo que contiene los antiguos
     * parametros que serán modificados.
     * @param idGrupo <code>String</code> con el identificador del grupo que
     * queremos modificar.
     * @param listaAlumnos Lista de <code>String</code> con los alumnos que
     * serán modificados del grupo.
     * @throws SQLException
     */
    static void ModificarGruposBD(BaseDatos accesoBD, Grupo gNuevo, Grupo gViejo, String idGrupo, List<String> listaAlumnos) throws SQLException {
        //String query = "UPDATE Temporada SET curso='"+cursoNuevo+"' WHERE curso='"+cursoAnterior+"'";
        boolean horMod = false, dia1Mod = false, dia2Mod = false;
        String query1 = "", query2 = "";
        int res1 = 0, idTemp = 0, idEnt = 0, idCat = 0, idDia1 = 0;
        ResultSet res2;

        idCat = GestorCategorias.getIdCategoria(accesoBD, gViejo.getCategoria());

        if (gNuevo.getTemporada() != gViejo.getTemporada()) {

            idTemp = GestorTemporadas.getIdTemporada(accesoBD, gNuevo.getTemporada());
            query1 = "UPDATE Grupo SET Temporada_idTemporada='" + idTemp + "' "
                    + "WHERE idGrupo='" + idGrupo + "'";
            res1 = accesoBD.ejecutaActualizacion(query1);
            query1 = "UPDATE AlumnoGrupo SET Grupo_Temporada_idTemporada='" + idTemp + "' "
                    + "WHERE Grupo_idGrupo='" + idGrupo + "'";
            res1 = accesoBD.ejecutaActualizacion(query1);
        }

        if (gNuevo.getEntrenador() != gViejo.getEntrenador()) {
            idEnt = GestorUsuarios.getIdEnt(accesoBD, gNuevo.getEntrenador());

            query1 = "UPDATE Grupo SET Usuario_idUsuario='" + idEnt + "' "
                    + "WHERE idGrupo='" + idGrupo + "'";
            res1 = accesoBD.ejecutaActualizacion(query1);
        }



        if (gNuevo.getDia1() != gViejo.getDia1()) {
            query1 = "SELECT Horario_idHorario FROM Grupo WHERE "
                    + "idGrupo='" + idGrupo + "'";
            res2 = accesoBD.ejecutaConsulta(query1);
            int idHor = 0;
            if (res2.next()) {
                idHor = res2.getInt(1);
            }

            query1 = "UPDATE Horario SET dia1='" + gNuevo.getDia1() + "' "
                    + "WHERE idHorario='" + idHor + "'";
            res1 = accesoBD.ejecutaActualizacion(query1);

            dia1Mod = true;
        }

        if (gNuevo.getDia2() != gViejo.getDia2()) {
            query1 = "SELECT Horario_idHorario FROM Grupo WHERE "
                    + "idGrupo='" + idGrupo + "'";
            res2 = accesoBD.ejecutaConsulta(query1);
            int idHor = 0;
            if (res2.next()) {
                idHor = res2.getInt(1);
            }

            query1 = "UPDATE Horario SET dia2='" + gNuevo.getDia2() + "' "
                    + "WHERE idHorario='" + idHor + "'";
            res1 = accesoBD.ejecutaActualizacion(query1);

            dia2Mod = true;
        }

        if (gNuevo.getHora1() != gViejo.getHora1()) {
            query1 = "SELECT Horario_idHorario FROM Grupo WHERE "
                    + "idGrupo='" + idGrupo + "'";
            res2 = accesoBD.ejecutaConsulta(query1);
            int idHor = 0;
            if (res2.next()) {
                idHor = res2.getInt(1);
            }

            query1 = "UPDATE Horario SET hora1='" + gNuevo.getHora1() + "' "
                    + "WHERE idHorario='" + idHor + "'";
            res1 = accesoBD.ejecutaActualizacion(query1);

            horMod = true;
        }

        if (gNuevo.getInstalacion() != gViejo.getInstalacion()) {
            String auxInstN, auxInstV;

            auxInstN = gNuevo.getInstalacion();
            auxInstN = auxInstN.substring(0, auxInstN.indexOf(","));

            auxInstV = gViejo.getInstalacion();
            auxInstV = auxInstV.substring(0, auxInstV.indexOf(","));

            query1 = "SELECT idInstalacion FROM Instalacion "
                    + "WHERE nombre='" + auxInstV + "'";
            res2 = accesoBD.ejecutaConsulta(query1);

            int idInstV = 0;
            if (res2.next()) {
                idInstV = res2.getInt(1);
            }

            query1 = "SELECT idInstalacion FROM Instalacion "
                    + "WHERE nombre='" + auxInstN + "'";
            res2 = accesoBD.ejecutaConsulta(query1);

            int idInstN = 0;
            if (res2.next()) {
                idInstN = res2.getInt(1);
            }

            query1 = "SELECT Horario_idHorario FROM Grupo "
                    + "WHERE idGrupo='" + idGrupo + "'";
            res2 = accesoBD.ejecutaConsulta(query1);

            int idHor = 0;
            if (res2.next()) {
                idHor = res2.getInt(1);
            }

            query1 = "UPDATE Horario SET Instalacion_idInstalacion='" + idInstN + "' "
                    + "WHERE idHorario='" + idHor + "' AND Instalacion_idInstalacion='" + idInstV + "'";


            res1 = accesoBD.ejecutaActualizacion(query1);

            query1 = "UPDATE Grupo SET Horario_Instalacion_idInstalacion='" + idInstN + "' "
                    + "WHERE idGrupo='" + idGrupo + "' AND "
                    + "Horario_Instalacion_idInstalacion='" + idInstV + "' "
                    + "AND Horario_idHorario='" + idHor + "'";
            res1 = accesoBD.ejecutaActualizacion(query1);
        }

        if (listaAlumnos.size() > 0) {
            List<Integer> idAls = GestorAlumnos.getIdAl(accesoBD, listaAlumnos);

            String auxQ = "SELECT Categoria_idCategoria FROM Grupo WHERE "
                    + "idGrupo='" + idGrupo + "'";
            ResultSet auxR = accesoBD.ejecutaConsulta(auxQ);
            if (auxR.next()) {
                idCat = auxR.getInt(1);
            }

            auxQ = "SELECT Usuario_idUsuario FROM Grupo WHERE "
                    + "idGrupo='" + idGrupo + "'";
            auxR = accesoBD.ejecutaConsulta(auxQ);
            if (auxR.next()) {
                idEnt = auxR.getInt(1);
            }

            auxQ = "SELECT Temporada_idTemporada FROM Grupo WHERE "
                    + "idGrupo='" + idGrupo + "'";
            auxR = accesoBD.ejecutaConsulta(auxQ);
            if (auxR.next()) {
                idTemp = auxR.getInt(1);
            }

            String query = "";
            int res = 0;
            for (Integer it : idAls) {
                query = "INSERT INTO Alumnogrupo (Alumno_idAlumno, Grupo_idGrupo, "
                        + "Grupo_Categoria_idCategoria, Grupo_Usuario_idUsuario, "
                        + "Grupo_Temporada_idTemporada) VALUES "
                        + "('" + it + "','" + idGrupo + "','" + idCat + "','" + idEnt + "','" + idTemp + "')";
                res = accesoBD.ejecutaActualizacion(query);
            }

            query = "SELECT n_alumnos FROM Grupo WHERE "
                    + "idGrupo='" + idGrupo + "'";
            auxR = accesoBD.ejecutaConsulta(query);

            int nAls = 0;
            if (auxR.next()) {
                nAls = auxR.getInt(1);
            }

            // System.out.println("nAls antes vale:" + nAls);

            nAls = nAls + listaAlumnos.size();
            //System.out.println("nAls despues vale:" + nAls);

            query = "UPDATE Grupo SET n_alumnos='" + nAls + "' "
                    + "WHERE idGrupo='" + idGrupo + "'";
            res = accesoBD.ejecutaActualizacion(query);
        }
    }

    /**
     * Permite obtener el identificador de una temporada a partir del
     * identificador de un grupo.
     *
     * @param accesoBD Usado para interactuar con la base de datos.
     * @param idGrup <code>int</code> con el identificador del grupo del que
     * queremos saber el identificador de temporada.
     * @return
     * @throws SQLException
     */
    static int getIdTemporada(BaseDatos accesoBD, int idGrup) throws SQLException {
        String query = "SELECT Temporada_idTemporada FROM Grupo WHERE "
                + "idGrupo='" + idGrup + "'";
        ResultSet res = accesoBD.ejecutaConsulta(query);

        int idTemp = 0;
        if (res.next()) {
            idTemp = res.getInt(1);
        }

        return idTemp;
    }

    /**
     * Permite eliminar un grupo de la base de datos.
     *
     * @param accesoBD Usado para interactuar con la base de datos.
     * @param g Objeto de la clase Grupo que será el grupo que queremos
     * eliminar.
     * @return <code>TRUE</code> si el grupo se ha eliminado correctamente,
     * <code>FALSE</code> en caso contrario.
     * @throws SQLException
     */
    static boolean EliminarGrupo(BaseDatos accesoBD, Grupo g) throws SQLException {
        boolean GrupoEliminado = false;

        int idInst = 0;
        String query1 = "SELECT Horario_idHorario, Horario_Instalacion_idInstalacion"
                + " FROM Grupo WHERE "
                + "idGrupo='" + g.getIdGrupo() + "'";
        ResultSet res1 = accesoBD.ejecutaConsulta(query1);



        int idHor = 0;
        if (res1.next()) {
            idHor = res1.getInt(1);
            idInst = res1.getInt(2);
        }
        /*
         * Primeramente Eliminamos los alumnos del grupos en cuestion
         */
        String queryAlumnos = "SELECT Alumno_idAlumno FROM alumnogrupo Where"
                + " Grupo_idGrupo = '" + g.getIdGrupo() + "' "
                + " AND Grupo_Categoria_idCategoria= '" + g.getIdCategoria() + "' "
                + " AND Grupo_Usuario_idUsuario = '" + g.getIdEntrenador() + "' AND "
                + " Grupo_Temporada_idTemporada = '" + g.getIdTemporada() + "' ";
        ResultSet AlumnosBorrados = accesoBD.ejecutaConsulta(queryAlumnos);

        String query3 = " DELETE FROM alumnogrupo WHERE "
                + " Grupo_idGrupo = '" + g.getIdGrupo() + "' "
                + " AND Grupo_Categoria_idCategoria= '" + g.getIdCategoria() + "' "
                + " AND Grupo_Usuario_idUsuario = '" + g.getIdEntrenador() + "' AND "
                + " Grupo_Temporada_idTemporada = '" + g.getIdTemporada() + "' ";
        // System.out.println(query3);
        boolean eliminaAlumGrup = false;
        eliminaAlumGrup = accesoBD.eliminar(query3);

        String queryGrupoPagos = "select Alumno_idAlumno,count(Alumno_idAlumno) FROM alumnogrupo Where"
                + " Alumno_idAlumno = '";

        while (AlumnosBorrados.next()) {

            ResultSet AlumnosEnGrupos = accesoBD.ejecutaConsulta(queryGrupoPagos + AlumnosBorrados.getString(1) + "' ");
            /*String queryPagos = "select * FROM alumnogrupo,pago Where"
             + " Alumno_idAlumno = '";*/
            if (!AlumnosEnGrupos.next()) {

                String Pagos = "No se han dado de bajo pagos";
                // System.out.println("PAgos no eliminados " + Pagos + AlumnosBorrados.getString(1));
            } else {
                //borrar pagos

                String BorradoPago = "DELETE FROM cuota WHERE idCuota IN (select pt.Cuota_idCuota"
                        + " FROM alumnogrupo ag,pagotemporada pt"
                        + " Where ag.Alumno_idAlumno = '" + AlumnosBorrados.getString(1) + "'  "
                        + " AND pt.AlumnoTemporada_Alumno_idAlumno=ag.Alumno_idAlumno"
                        + " AND pt.AlumnoTemporada_Temporada_idTemporada=ag.Grupo_Temporada_idTemporada)";



                accesoBD.eliminar(BorradoPago);
                String Pagos = "Se han dado de bajo pagos";
            }

        }


        String query4 = "DELETE FROM Grupo WHERE "
                + "idGrupo='" + g.getIdGrupo() + "'";
        boolean eliminaGrupo = false;
        eliminaGrupo = accesoBD.eliminar(query4);
        //System.out.println(query4);

        String query2 = "DELETE FROM Horario WHERE idHorario='" + idHor + "' AND "
                + "Instalacion_idInstalacion='" + idInst + "'";

        boolean eliminaHor = false;
        eliminaHor = accesoBD.eliminar(query2);
        // System.out.println(query2);

        //Alumno_idAlumno='"+g.+"'


        if (eliminaHor == true && eliminaGrupo == true && eliminaAlumGrup == true) {
            GrupoEliminado = true;
        } else {
            GrupoEliminado = false;
        }

        return GrupoEliminado;
    }

    /**
     * Permite saber si un alumno esta dado de alta en una temporada.
     *
     * @param bd Usado para interactuar con la base de datos.
     * @param idAl Identificador del alumno del que queremos saber si se
     * encuentra en la temporada.
     * @param idTemp Identificador de la temporada en la que queremos saber si
     * se encuentra el alumno.
     * @return TRUE si el alumno esta en la temporada, FALSE en caso contrario.
     * @throws SQLException
     */
    static boolean existeAlumnoTemporada(BaseDatos bd, int idAl, int idTemp) throws SQLException {
        String query = "SELECT * FROM AlumnoTemporada "
                + "WHERE Alumno_idAlumno='" + idAl + "' "
                + "AND Temporada_idTemporada='" + idTemp + "'";
        ResultSet res = bd.ejecutaConsulta(query);
        //System.out.println("consulta:" + query);
        boolean existe = false;

        if (res.next()) {
            existe = true;
        }

        return existe;
    }

    /**
     * Permite obtener el año (expresado como "anio/anio+1" de una temporada.
     *
     * @param bd Usado para interactuar con la base de datos.
     * @param idTemp Identificador de la temporada de la que queremos saber el
     * curso.
     * @return Un <code>int</code> con el curso de la temporada.
     * @throws SQLException
     */
    public static int getAnio(BaseDatos bd, int idTemp) throws SQLException {
        String query = "SELECT curso FROM Temporada "
                + "WHERE idTemporada='" + idTemp + "'";
        ResultSet res = bd.ejecutaConsulta(query);

        String auxAnio = null;
        if (res.next()) {
            auxAnio = res.getString(1);
        }

        auxAnio = auxAnio.substring(0, auxAnio.indexOf("/"));

        return Integer.parseInt(auxAnio);
    }

    /**
     * Permite saber si un alumno esta en dos grupos de entrenamiento.
     *
     * @param accesoBD Usado para interactuar con la base de datos.
     * @param idAl Identificador con el alumno del que queremos saber si esta en
     * dos grupos de entrenamiento.
     * @param idTemp Identificador de la temporada.
     * @return TRUE si el alumno esta en dos grupos de entrenamiento, FALSE en
     * caso contrario.
     * @throws SQLException
     */
    static boolean existeAlumnoEnDosGrupos(BaseDatos accesoBD, int idAl, int idTemp) throws SQLException {
        String query = "SELECT * FROM AlumnoGrupo WHERE "
                + "Alumno_idAlumno='" + idAl + "' AND "
                + "Grupo_Temporada_idTemporada='" + idTemp + "'";
        ResultSet res = accesoBD.ejecutaConsulta(query);

        int cont = 0;
        while (res.next()) {
            cont++;
        }

        if (cont > 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Permite saber si un alumno esta en dos grupos de entrenamiento.
     * @param accesoBD Usado para interactuar con la base de datos.
     * @param it Parametro formal que representa el número de alumnos que
     * coinciden.
     * @param idTemp Identificador de la temporada.
     * @return TRUE si el alumno esta en tres grupos de entrenamiento, FALSE en
     * caso contrario.
     * @throws SQLException 
     */
    static boolean AlumnoTresGrupos(BaseDatos accesoBD, Integer it, int idTemp) throws SQLException {
        String query = "SELECT COUNT(*) from AlumnoGrupo WHERE "
                + "Alumno_idAlumno='" + it + "' AND "
                + "Grupo_Temporada_idTemporada='" + idTemp + "'";
        ResultSet res = accesoBD.ejecutaConsulta(query);

        boolean existe = false;
        int n = 0;


        if (res.next());
        n = res.getInt(1);

        if (n >= 2) {
            existe = true;
        }

        return existe;
    }
}
