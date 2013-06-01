/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionDePartidos;

import java.sql.Time;
import java.util.Date;
/**
 *
 * @author Julio
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
    
        
    public static Partido crearPartido (int idEqLocal, int idEqLocalFundacion,
           int idEqLocalCategoria, int idEqLocalTemporada, int idEqLocalLiga, int idEqVisitante,
           int idEqVisitanteFundacion, int idEqVisitanteCategoria, int idEqVisitanteTemporada, 
           int idEqVisitanteLiga, Date fch, Time hr, int resLocal, int resVisitante){
        
        return new Partido(idEqLocal, idEqLocalFundacion,
           idEqLocalCategoria, idEqLocalTemporada, idEqLocalLiga, idEqVisitante,
           idEqVisitanteFundacion, idEqVisitanteCategoria,idEqVisitanteTemporada, 
           idEqVisitanteLiga, fch, hr, resLocal, resVisitante);
    }
   
    public Partido(int idEqLocal, int idEqLocalFundacion,
           int idEqLocalCategoria, int idEqLocalTemporada, int idEqLocalLiga, int idEqVisitante,
           int idEqVisitanteFundacion, int idEqVisitanteCategoria, int idEqVisitanteTemporada, 
           int idEqVisitanteLiga, Date fch, Time hr, int resLocal, int resVisitante){
        
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

    public int getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(int idPartido) {
        this.idPartido = idPartido;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public int getResultadoLocal() {
        return resultadoLocal;
    }

    public void setResultadoLocal(int resultadoLocal) {
        this.resultadoLocal = resultadoLocal;
    }

    public int getResultadoVisitante() {
        return resultadoVisitante;
    }

    public void setResultadoVisitante(int resultadoVisitante) {
        this.resultadoVisitante = resultadoVisitante;
    }

    public int getIdEquipoLocal() {
        return idEquipoLocal;
    }

    public void setIdEquipoLocal(int idEquipoLocal) {
        this.idEquipoLocal = idEquipoLocal;
    }

    public int getIdEquipoLocalFundacion() {
        return idEquipoLocalFundacion;
    }

    public void setIdEquipoLocalFundacion(int idEquipoLocalFundacion) {
        this.idEquipoLocalFundacion = idEquipoLocalFundacion;
    }

    public int getIdEquipoLocalCategoria() {
        return idEquipoLocalCategoria;
    }

    public void setIdEquipoLocalCategoria(int idEquipoLocalCategoria) {
        this.idEquipoLocalCategoria = idEquipoLocalCategoria;
    }

    public int getIdEquipoLocalTemporada() {
        return idEquipoLocalTemporada;
    }

    public void setIdEquipoLocalTemporada(int idEquipoLocalTemporada) {
        this.idEquipoLocalTemporada = idEquipoLocalTemporada;
    }

    public int getIdEquipoLocalLiga() {
        return idEquipoLocalLiga;
    }

    public void setIdEquipoLocalLiga(int idEquipoLocalLiga) {
        this.idEquipoLocalLiga = idEquipoLocalLiga;
    }

    public int getIdEquipoVisitante() {
        return idEquipoVisitante;
    }

    public void setIdEquipoVisitante(int idEquipoVisitante) {
        this.idEquipoVisitante = idEquipoVisitante;
    }

    public int getIdEquipoVisitanteFundacion() {
        return idEquipoVisitanteFundacion;
    }

    public void setIdEquipoVisitanteFundacion(int idEquipoVisitanteFundacion) {
        this.idEquipoVisitanteFundacion = idEquipoVisitanteFundacion;
    }

    public int getIdEquipoVisitanteCategoria() {
        return idEquipoVisitanteCategoria;
    }

    public void setIdEquipoVisitanteCategoria(int idEquipoVisitanteCategoria) {
        this.idEquipoVisitanteCategoria = idEquipoVisitanteCategoria;
    }

    public int getIdEquipoVisitanteTemporada() {
        return idEquipoVisitanteTemporada;
    }

    public void setIdEquipoVisitanteTemporada(int idEquipoVisitanteTemporada) {
        this.idEquipoVisitanteTemporada = idEquipoVisitanteTemporada;
    }

    public int getIdEquipoVisitanteLiga() {
        return idEquipoVisitanteLiga;
    }

    public void setIdEquipoVisitanteLiga(int idEquipoVisitanteLiga) {
        this.idEquipoVisitanteLiga = idEquipoVisitanteLiga;
    }
    
}
