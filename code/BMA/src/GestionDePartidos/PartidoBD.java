package GestionDePartidos;

import ServiciosAlmacenamiento.BaseDatos;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
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
 * Clase que permite el paso de objetos de tipo java a objetos de tipo
 * relacional en formato Sql.
 *
 * @author Julio Ros Martínez
 * @version 1.0
 */
public class PartidoBD {

    /**
     * Procedimiento para insertar un partido en la base de datos
     * @param accesoBD acceso a la base de datos.
     * @param partido partido a insertar
     * @throws SQLException algun tipo de error en la base de datos.
     */
    public static void insertarPartido(BaseDatos accesoBD, Partido nuevoPartido) throws SQLException {

        String insercion = "INSERT INTO partido (idEquipo, equipo_Fundacion_idFundacion, equipo_Categoria_idCategoria, "
                + "equipo_Temporada_idTemporada, equipo_liga_idLiga, idEquipoVisitante, equipo_Fundacion_idFundacion1, "
                + "equipo_Categoria_idCategoria1, equipo_Temporada_idTemporada1, equipo_liga_idLiga1, fecha, hora, "
                + "resultadoLocal, resultadoVisitante) VALUES (";
        insercion = insercion + nuevoPartido.getIdEquipoLocal() + ", "
                + nuevoPartido.getIdEquipoLocalFundacion() + ", "
                + nuevoPartido.getIdEquipoLocalCategoria() + ", "
                + nuevoPartido.getIdEquipoLocalTemporada() + ", "
                + nuevoPartido.getIdEquipoLocalLiga() + ", "
                + nuevoPartido.getIdEquipoVisitante() + ", "
                + nuevoPartido.getIdEquipoVisitanteFundacion() + ", "
                + nuevoPartido.getIdEquipoVisitanteCategoria() + ", "
                + nuevoPartido.getIdEquipoVisitanteTemporada() + ", "
                + nuevoPartido.getIdEquipoVisitanteLiga() + ", \""
                + nuevoPartido.getFecha() + "\", \""
                + nuevoPartido.getHora() + "\", "
                + nuevoPartido.getResultadoLocal() + ", "
                + nuevoPartido.getResultadoVisitante() + ");";

        accesoBD.ejecutaActualizacion(insercion);
    }

    /**
     * Funcion para obtener el id de un partido
     * @param accesoBD acceso a la base de datos.
     * @param fch fecha del partido
     * @param hr hora del partido
     * @param eqL id del equipo local
     * @param eqV id del equipo Visitante
     * @throws SQLException algun tipo de error en la base de datos.
     * @return int (entero) con el atributo interno del id de un partido
     */
    static int getIdPartido(BaseDatos accesoBD, String fch, String hr, int eqL, int eqV) throws SQLException {
        String query = "SELECT idPartido FROM Partido WHERE "
                + "fecha='" + fch + "'"
                + " AND hora='" + hr + "'"
                + " AND idEquipo= '" + eqL + "'"
                + " AND idEquipoVisitante= '" + eqV + "'";

        System.out.println(query);

        ResultSet res = accesoBD.ejecutaConsulta(query);

        int idPart = 0;
        if (res.next()) {
            idPart = res.getInt(1);
        }

        return idPart;
    }
    
    /**
     * Funcion para obtener una lista de partidos
     * @param accesoBD acceso a la base de datos
     * @throws SQLException algun tipo de error en la base de datos.
     * @return List<List<String>> (Lista de lista de cadenas) con los datos de los partidos almacenados en la base de datos
     */

    static List<List<String>> getListaPartidos(BaseDatos accesoBD) throws SQLException { //DUDAS EVERYWHERE
        List<List<String>> partidos = new ArrayList<List<String>>();
        String query = "SELECT fecha, hora, equipo_Categoria_idCategoria, equipo_Temporada_idTemporada, "
                + "equipo_liga_idLiga, idEquipo, idEquipoVisitante, resultadoLocal, resultadoVisitante FROM Partido";
        ResultSet res = accesoBD.ejecutaConsulta(query);

        List<String> aux;

        while (res.next()) {
            aux = new ArrayList<String>();
            aux.add(res.getString(1) + "," + res.getString(2) + "," + res.getString(3) + "," + res.getString(4)
                    + "," + res.getString(5) + "," + res.getString(6) + "," + res.getString(7) + "," + res.getString(8) + "," + res.getString(9));
            partidos.add(aux);
        }

        return partidos;
    }
    
    /**
     * Funcion para obtener una lista de partidos a través de una serie de atributos dados
     * @param accesoBD acceso a la base de datos.
     * @param fecha la fecha del partido
     * @param temporada temporada en la que se juega ese partido
     * @param categoria categoría en la que se juega ese partido
     * @param equipoLoc id del equipo local
     * @param equipoVis id del equipo visitante
     * @throws SQLException algun tipo de error en la base de datos.
     * @return List<List<String>> (Lista de lista de cadenas) con los datos de los partidos almacenados en la base de datos que cumplen con los atributos
     */

    public static List<List<String>> getListaPartidosFiltro(BaseDatos accesoBD, String fecha, String temporada, String categoria, String equipoLoc, String equipoVis) throws SQLException {
        List<List<String>> partidos = new ArrayList<>();
        boolean and = false;
        boolean primeraVez = true;
        String query = "SELECT fecha, hora, equipo_Categoria_idCategoria, equipo_Temporada_idTemporada, "
                + "idEquipo, idEquipoVisitante, resultadoLocal, resultadoVisitante FROM Partido";
        if (fecha != null) {
            if (primeraVez) {
                query += " WHERE ";
                primeraVez = false;
            }
            query += "fecha = \"" + fecha + "\" ";
            and = true;
        }
        if (!temporada.equals("0")) {
            if (primeraVez) {
                query += " WHERE ";
                primeraVez = false;
            }
            if (and) {
                query += "AND ";
            }
            query += "equipo_Temporada_idTemporada = " + temporada + " ";
            and = true;
        }

        if (!categoria.equals("0")) {
            if (primeraVez) {
                query += " WHERE ";
                primeraVez = false;
            }
            if (and) {
                query += "AND ";
            }
            query += "equipo_Categoria_idCategoria = " + categoria + " ";
            and = true;
        }
        if (!equipoLoc.equals("0")) {
            if (primeraVez) {
                query += " WHERE ";
                primeraVez = false;
            }
            if (and) {
                query += "AND ";
            }
            query += "idEquipo = " + equipoLoc + " ";
            and = true;
        }
        if (!equipoVis.equals("0")) {
            if (primeraVez) {
                query += " WHERE ";
                primeraVez = false;
            }
            if (and) {
                query += "AND ";
            }
            query += "idEquipoVisitante = " + equipoVis;
        }
        query += ";";

        System.out.println();
        System.out.println(query);

        ResultSet res = accesoBD.ejecutaConsulta(query);

        List<String> aux;

        while (res.next()) {
            aux = new ArrayList<>();
            aux.add(res.getString(1) + "," + res.getString(2) + "," + res.getString(3) + "," + res.getString(4)
                    + "," + res.getString(5) + "," + res.getString(6) + "," + res.getString(7) + "," + res.getString(8));
            partidos.add(aux);
        }
        return partidos;
    }

    /** 
     * Funcion para consultar un partido
     * @param accesoBD acceso a la base de datos.
     * @param consulta la consulta a realizar.
     * @throws SQLException algun tipo de error en la base de datos.
     * @return ResultSet (java.sql.ResultSet) con el atributo interno de la consulta del partido.
     */
    public ResultSet consultaPartidoBD(BaseDatos accesoBD, String consulta) {
        ResultSet retset;
        retset = accesoBD.ejecutaConsulta(consulta);

        return retset;
    }

    /** 
     * Funcion para modificar los datos de un partido
     * @param accesoBD acceso a la base de datos.
     * @param idEquipoLocal id del equipo local.
     * @param idEquipoLocalFundacion id de la fundación a la que pertenece el equipo local
     * @param idEquipoLocalCategoria id de la categoría a la que pertenece el equipo local
     * @param idEquipoLocalTemporada id de la temporada a la que pertenece el equipo local
     * @param idEquipoLocalLiga id de la liga a la que pertenece el equipo local
     * @param idEquipoVisitante id del equipo visitante.
     * @param idEquipoVisitanteFundacion id de la fundación a la que pertenece el equipo Visitante
     * @param idEquipoVisitanteCategoria id de la categoría a la que pertenece el equipo Visitante
     * @param idEquipoVisitanteTemporada id de la temporada a la que pertenece el equipo Visitante
     * @param idEquipoVisitanteLiga id de la liga a la que pertenece el equipo visitante
     * @param fecha la fecha del partido
     * @param hora la hora del partido
     * @param idPart id del partido a modificar
     * @throws SQLException algun tipo de error en la base de datos.
     * @return boolean (valor lógico) que indica si la modificación se ha realizado correctamente o no.
     */
    public static boolean modificarDatosPartidoBD(BaseDatos accesoBD, int idEquipoLocal, int idEquipoLocalFundacion,
            int idEquipoLocalCategoria, int idEquipoLocalTemporada, int idEquipoLocalLiga, int idEquipoVisitante,
            int idEquipoVisitanteFundacion, int idEquipoVisitanteCategoria, int idEquipoVisitanteTemporada,
            int idEquipoVisitanteLiga, Date fecha, Time hora, int idPart) {

        boolean exito = true;
        String actualizacion = "UPDATE Partido SET"
                + " idEquipo= '" + idEquipoLocal + "',"
                + " equipo_Fundacion_idFundacion= '" + idEquipoLocalFundacion + "',"
                + " equipo_Categoria_idCategoria= '" + idEquipoLocalCategoria + "',"
                + " equipo_Temporada_idTemporada= '" + idEquipoLocalTemporada + "',"
                + " equipo_liga_idLiga= '" + idEquipoLocalLiga + "',"
                + " idEquipoVisitante= '" + idEquipoVisitante + "',"
                + " equipo_Fundacion_idFundacion1= '" + idEquipoVisitanteFundacion + "',"
                + " equipo_Categoria_idCategoria1= '" + idEquipoVisitanteCategoria + "',"
                + " equipo_Temporada_idTemporada= '" + idEquipoVisitanteTemporada + "',"
                + " equipo_liga_idLiga1= '" + idEquipoVisitanteLiga + "',"
                + " fecha= '" + fecha + "',"
                + " hora= '" + hora + "'"
                + " WHERE idPartido= " + idPart;

        System.out.println(actualizacion);

        try {
            accesoBD.ejecutaActualizacion(actualizacion);
            System.out.print("\nModificado act\n " + actualizacion);
        } catch (SQLException ex) {
            exito = false;
        }

        return exito;
    }

    /** 
     * Procedimiento para eliminar un partido
     * @param accesoBD acceso a la base de datos.
     * @param nuevoPartido el partido a eliminar.
     * @throws SQLException algun tipo de error en la base de datos.
     */
    public static void eliminarPartidoBD(BaseDatos accesoBD, Partido nuevoPartido) throws SQLException {
        int idPartido = getIdPartido(accesoBD, nuevoPartido.getFecha().toString(), nuevoPartido.getHora().toString(), nuevoPartido.getIdEquipoLocal(), nuevoPartido.getIdEquipoVisitante());

        String delete = "DELETE FROM partido WHERE idPartido = "
                + idPartido;

        boolean exito = accesoBD.eliminar(delete);
        if (!exito) {
            JOptionPane.showMessageDialog(null, "Ha habido un error en la base de datos",
                    "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Partido Eliminado con éxito",
                    "Confirmacion", JOptionPane.INFORMATION_MESSAGE);
        }

    }
}
