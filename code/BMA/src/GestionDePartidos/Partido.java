package GestionDePartidos;

import java.sql.Time;
import java.util.Date;

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
 * Clase Partido
 *
 * @author Julio Ros Martínez
 * @version 1.0
 */
public class Partido {

    private int idPartido;
    private Date fecha;
    private Time hora;
    private int resultadoLocal;
    private int resultadoVisitante;
    private int idEquipoLocal;
    private int idEquipoLocalFundacion;
    private int idEquipoLocalCategoria;
    private int idEquipoLocalTemporada;
    private int idEquipoLocalLiga;
    private int idEquipoVisitante;
    private int idEquipoVisitanteFundacion;
    private int idEquipoVisitanteCategoria;
    private int idEquipoVisitanteTemporada;
    private int idEquipoVisitanteLiga;

    /**
     * Constructor de la clase
     * @param idEqLocal id del equipo local
     * @param idEqLocalFundacion id de la fundación a la que pertenece el equipo local
     * @param idEqLocalTemporada id de la temporada a la que pertenece el equipo local
     * @param idEqLocalLiga id de la liga a la que pertenece el equipo local
     * @param idEqVisitante id del equipo Visitante. 
     * @param idEqVisitanteFundacion id de la fundación a la que pertenece el equipo Visitante
     * @param idEqVisitanteTemporada id de la temporada a la que pertenece el equipo Visitante
     * @param idEqVisitantelLiga id de la liga a la que pertenece el equipo Visitante
     * @param fch la fecha del partido
     * @param hr la hora del partido
     * @param resLocal el resultado del equipo local
     * @param resVisitante el resultado del equipo visitante
     */
    public Partido(int idEqLocal, int idEqLocalFundacion,
            int idEqLocalCategoria, int idEqLocalTemporada, int idEqLocalLiga, int idEqVisitante,
            int idEqVisitanteFundacion, int idEqVisitanteCategoria, int idEqVisitanteTemporada,
            int idEqVisitanteLiga, Date fch, Time hr, int resLocal, int resVisitante) {

        idEquipoLocal = idEqLocal;
        idEquipoLocalFundacion = idEqLocalFundacion;
        idEquipoLocalCategoria = idEqLocalCategoria;
        idEquipoLocalTemporada = idEqLocalTemporada;
        idEquipoLocalLiga = idEqLocalLiga;
        idEquipoVisitante = idEqVisitante;
        idEquipoVisitanteFundacion = idEqVisitanteFundacion;
        idEquipoVisitanteCategoria = idEqVisitanteCategoria;
        idEquipoVisitanteTemporada = idEqVisitanteTemporada;
        idEquipoVisitanteLiga = idEqVisitanteLiga;
        fecha = fch;
        hora = hr;
        resultadoLocal = resLocal;
        resultadoVisitante = resVisitante;
    }

    /**
     * Método para obtener la id del partido
     * @return int (entero) con el atributo interno del Id del partido
     */
    public int getIdPartido() {
        return idPartido;
    }

    /**
     * Procedimiento para dar valor a la id del partido
     * @param idPartido id del partido
     */
    public void setIdPartido(int idPartido) {
        this.idPartido = idPartido;
    }

    /**
     * Método para obtener la fecha del partido
     * @return Date (fecha) con el atributo interno de la fecha del partido
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * Procedimiento para establecer la fecha del partido
     * @param fecha la fecha del partido
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * Metodo para obtener la hora del partido
     * @return Time (hora) con el atributo interno de la hora del partido
     */
    public Time getHora() {
        return this.hora;
    }

    /**
     * Procedimiento para establecer la hora del partido
     * @param hora la hora del partido
     */
    public void setHora(Time hora) {
        this.hora = hora;
    }

    /**
     * Metodo para obtener el resultado del equipo local
     * @return int (entero) con el atributo interno del resultado del equipo local
     */
    public int getResultadoLocal() {
        return resultadoLocal;
    }

   /**
    * Procedimiento para establecer el resultado del equipo local
    * @param resultadoLocal el resultado del equipo local
    */
    public void setResultadoLocal(int resultadoLocal) {
        this.resultadoLocal = resultadoLocal;
    }

    /**
     * Metodo para obtener el resultado del equipo visitante
     * @return int (entero) con el atributo interno del resultado del equipo visitante
     */
    public int getResultadoVisitante() {
        return resultadoVisitante;
    }

    /**
     * Procedimiento para establecer el resultado del equipo visitante
     * @param resultadoVisitante el resultado del equipo visitante
     */
    public void setResultadoVisitante(int resultadoVisitante) {
        this.resultadoVisitante = resultadoVisitante;
    }

    /**
     * Metodo para obtener el id del equipo local
     * @return int (entero) con el atributo interno del id de equipo local
     */
    public int getIdEquipoLocal() {
        return idEquipoLocal;
    }

    /**
     * Procedimiento para establecer la id del equipo local
     * @param idEquipoLocal el identificador del equipo local
     */
    public void setIdEquipoLocal(int idEquipoLocal) {
        this.idEquipoLocal = idEquipoLocal;
    }

    /**
     * Metodo para obtener el id de la fundación a la que pertenece el equipo local
     * @return int (entero) con el atributo interno del id de la fundación a la que pertenece el equipo local
     */
    public int getIdEquipoLocalFundacion() {
        return idEquipoLocalFundacion;
    }

    /**
     * Procedimiento para establecer la id de la fundación a la que pertenece el equipo local
     * @param idEquipoLocalFundacion el identificador del equipo local de la
     * fundación
     */
    public void setIdEquipoLocalFundacion(int idEquipoLocalFundacion) {
        this.idEquipoLocalFundacion = idEquipoLocalFundacion;
    }

    /**
     * Metodo para obtener el id de la categoria a la que pertenece el equipo local
     * @return int (entero) con el atributo interno del id de la categoria a la que pertenece el equipo local
     */
    public int getIdEquipoLocalCategoria() {
        return idEquipoLocalCategoria;
    }

    /**
     * Procedimiento para establecer la id de la categoría a la que pertenece el equipo local
     * @param idEquipoLocalCategoria el identificador del equipo local según
     * su categoria
     */
    public void setIdEquipoLocalCategoria(int idEquipoLocalCategoria) {
        this.idEquipoLocalCategoria = idEquipoLocalCategoria;
    }

    /**
     * Metodo para obtener el id de la temporada a la que pertenece el equipo local
     * @return int (entero) con el atributo interno del id de la temporada a la que pertenece el equipo local
     */
    public int getIdEquipoLocalTemporada() {
        return idEquipoLocalTemporada;
    }

    /**
     * Procedimiento para establecer la id de la temporada a la que pertenece el equipo local
     * @param idEquipoLocalTemporada el identificador del equipo local
     * de la temporada actual
     */
    public void setIdEquipoLocalTemporada(int idEquipoLocalTemporada) {
        this.idEquipoLocalTemporada = idEquipoLocalTemporada;
    }

    /**
     * Metodo para obtener el id de la liga a la que pertenece el equipo local
     * @return int (entero) con el atributo interno del id de la liga a la que pertenece el equipo local
     */
    public int getIdEquipoLocalLiga() {
        return idEquipoLocalLiga;
    }

    /**
     * Procedimiento para establecer la id de la liga a la que pertenece el equipo local
     * @param idEquipoLocalLiga el identificador del equipo local de la liga
     */
    public void setIdEquipoLocalLiga(int idEquipoLocalLiga) {
        this.idEquipoLocalLiga = idEquipoLocalLiga;
    }

    /**
     * Metodo para obtener el id de la temporada a la que pertenece el equipo visitante
     * @return int (entero) con el atributo interno del id de la temporada a la que pertenece el equipo visitante
     */
    public int getIdEquipoVisitante() {
        return idEquipoVisitante;
    }

    /**
     * Procedimiento para establecer la id del equipo local
     * @param idEquipoVisitante el identificador del equipo visitante
     */
    public void setIdEquipoVisitante(int idEquipoVisitante) {
        this.idEquipoVisitante = idEquipoVisitante;
    }

    /**
     * Metodo para obtener el id de la fundación a la que pertenece el equipo visitante
     * @return int (entero) con el atributo interno del id de la fundación a la que pertenece el equipo visitante
     */
    public int getIdEquipoVisitanteFundacion() {
        return idEquipoVisitanteFundacion;
    }

    /**
     * Procedimiento para establecer la id de la fundación a la que pertenece el equipo visitante
     * @param idEquipoVisitanteFundacion el identificador del equipo visitante
     * de la fundación.
     */
    public void setIdEquipoVisitanteFundacion(int idEquipoVisitanteFundacion) {
        this.idEquipoVisitanteFundacion = idEquipoVisitanteFundacion;
    }

    /**
     * Metodo para obtener el id de la categoria a la que pertenece el equipo visitante
     * @return int (entero) con el atributo interno del id de la categoría a la que pertenece el equipo visitante
     */
    public int getIdEquipoVisitanteCategoria() {
        return idEquipoVisitanteCategoria;
    }

    /**
     * Procedimiento para establecer la id de la categoría a la que pertenece el equipo visitante
     * @param idEquipoVisitanteCategoria el identificador del equipo visitante
     * según su categoria
     */
    public void setIdEquipoVisitanteCategoria(int idEquipoVisitanteCategoria) {
        this.idEquipoVisitanteCategoria = idEquipoVisitanteCategoria;
    }

    /**
     * Metodo para obtener el id de la temporada a la que pertenece el equipo visitante
     * @return int (entero) con el atributo interno del id de la temporada a la que pertenece el equipo visitante
     */
    public int getIdEquipoVisitanteTemporada() {
        return idEquipoVisitanteTemporada;
    }

    /**
     * Procedimiento para establecer la id de la temporada a la que pertenece el equipo visitante
     * @param idEquipoVisitanteTemporada el identificador del equipo visitante
     * de la temporada actual
     */
    public void setIdEquipoVisitanteTemporada(int idEquipoVisitanteTemporada) {
        this.idEquipoVisitanteTemporada = idEquipoVisitanteTemporada;
    }

    /**
     * Metodo para obtener el id de la liga a la que pertenece el equipo visitante
     * @return int (entero) con el atributo interno del id de la liga a la que pertenece el equipo visitante
     */
    public int getIdEquipoVisitanteLiga() {
        return idEquipoVisitanteLiga;
    }

    /**
     * Procedimiento para establecer la id de la liga a la que pertenece el equipo visitante
     * @param idEquipoVisitanteLiga el identificador del equipo visitante
     * de la liga
     */
    public void setIdEquipoVisitanteLiga(int idEquipoVisitanteLiga) {
        this.idEquipoVisitanteLiga = idEquipoVisitanteLiga;
    }
}
