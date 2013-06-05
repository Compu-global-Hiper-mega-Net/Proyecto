/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EstadisticasXML;

/**
 * Clase EstadisticasXML que se encargará de consultar y modificar los
 * atributos internos del schema XML que ha sido generado.
 * @author Moisés Gautier Gómez
 * @version 1.0
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


public class EstadisticasXML {
    
    // Atributos pertenecientes al jugador para identificarlo
    
    String Nombre, Apellidos;
    
    // Identificador del alumno
    
    int idAlumno;
    
    // Puntos acumulados en total por el jugador
    
    int Puntos;
    
    // Porcentaje de tiros dependiendo cual sea de ellos
    // Se podrá representar como un porcentaje o como el resultado
    // de tiros acertados entre el total de lanzados.
    
    double TirosDeCampo, TirosLibres, Triples;
    
    // Número de rebotes del tipo que sea según el jugador
    
    int RebotesOfensivos, RebotesDefensivos;
    
    // Número de asistencias, robos y perdidas realizadas por el jugador.
    // También se puntua (valoración) la actuación del jugador en el partido.
    
    int Asistencias, Robos, Perdidas, Valoracion;
    
    /*
     * Método consultor
     * @return Devuelve un int (entero) con el atributo interno
     * del nombre del jugador.
     * @version 1.0
     */

    public int getidAlumno() {
        return idAlumno;
    }
    
    /*
     * Método consultor
     * @return Devuelve un String (cadena) con el atributo interno
     * del nombre del jugador.
     * @version 1.0
     */

    public String getNombre() {
        return Nombre;
    }

    /*
     * Método consultor
     * @return Devuelve un String (cadena) con el atributo interno
     * de los apellidos del jugador.
     * @version 1.0
     */
    
    public String getApellidos() {
        return Apellidos;
    }
    
    /*
     * Método consultor
     * @return Devuelve un int (entero) con el atributo interno
     * de los puntos del jugador.
     * @version 1.0
     */

    public int getPuntos() {
        return Puntos;
    }
    
    /*
     * Método consultor
     * @return Devuelve un double (real) con el atributo interno
     * de los tiros de campo del jugador (tiros acertados / tiros lanzados).
     * @version 1.0
     */

    public double getTirosDeCampo() {
        return TirosDeCampo;
    }
    
    /*
     * Método consultor
     * @return Devuelve un double (real) con el atributo interno
     * de los tiros libres del jugador (tiros acertados / tiros lanzados).
     * @version 1.0
     */

    public double getTirosLibres() {
        return TirosLibres;
    }
    
    /*
     * Método consultor
     * @return Devuelve un double (real) con el atributo interno
     * de los triples del jugador (tiros acertados / tiros lanzados).
     * @version 1.0
     */

    public double getTriples() {
        return Triples;
    }
    
    /*
     * Método consultor
     * @return Devuelve un int (entero) con el atributo interno
     * de los rebotes ofensivos del jugador.
     * @version 1.0
     */

    public int getRebotesOfensivos() {
        return RebotesOfensivos;
    }
    
    /*
     * Método consultor
     * @return Devuelve un int (entero) con el atributo interno
     * de los rebotes defensivos del jugador.
     * @version 1.0
     */

    public int getRebotesDefensivos() {
        return RebotesDefensivos;
    }
    
    /*
     * Método consultor
     * @return Devuelve un int (entero) con el atributo interno
     * del numero de asistencias del jugador.
     * @version 1.0
     */

    public int getAsistencias() {
        return Asistencias;
    }
    
    /*
     * Método consultor
     * @return Devuelve un int (entero) con el atributo interno
     * del numero de robos del jugador.
     * @version 1.0
     */

    public int getRobos() {
        return Robos;
    }
    
    /*
     * Método consultor
     * @return Devuelve un int (entero) con el atributo interno
     * del numero de perdidas del jugador.
     * @version 1.0
     */

    public int getPerdidas() {
        return Perdidas;
    }
    
    /*
     * Método consultor
     * @return Devuelve un int (entero) con el atributo interno
     * de la valoración del jugador.
     * @version 1.0
     */

    public int getValoracion() {
        return Valoracion;
    }
    
    /*
     * Método modificador
     * @param Apellidos Parámetro formal de tipo String (cadena) que modifica
     * el atributo interno correspondiente al schema del XML.
     * @return 
     * @version 1.0
     */
    
    public void setidAlumno(int idAlumnno) {
        this.idAlumno = idAlumno;
    }
    
    /*
     * Método modificador
     * @param Nombre Parámetro formal de tipo String (cadena) que modifica
     * el atributo interno correspondiente al schema del XML.
     * @return 
     * @version 1.0
     */

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    
    /*
     * Método modificador
     * @param Apellidos Parámetro formal de tipo String (cadena) que modifica
     * el atributo interno correspondiente al schema del XML.
     * @return 
     * @version 1.0
     */
    
    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }
    
    /*
     * Método modificador
     * @param Puntos Parámetro formal de tipo int (entero) que modifica
     * el atributo interno correspondiente al schema del XML.
     * @return 
     * @version 1.0
     */

    public void setPuntos(int Puntos) {
        this.Puntos = Puntos;
    }
    
    /*
     * Método modificador
     * @param TirosDeCampo Parámetro formal de tipo double (real) que modifica
     * el atributo interno correspondiente al schema del XML.
     * @return 
     * @version 1.0
     */

    public void setTirosDeCampo(double TirosDeCampo) {
        this.TirosDeCampo = TirosDeCampo;
    }
    
    /*
     * Método modificador
     * @param TirosLibres Parámetro formal de tipo double (real) que modifica
     * el atributo interno correspondiente al schema del XML.
     * @return 
     * @version 1.0
     */

    public void setTirosLibres(double TirosLibres) {
        this.TirosLibres = TirosLibres;
    }
    
    /*
     * Método modificador
     * @param Triples Parámetro formal de tipo double (real) que modifica
     * el atributo interno correspondiente al schema del XML.
     * @return 
     * @version 1.0
     */

    public void setTriples(double Triples) {
        this.Triples = Triples;
    }
    
    /*
     * Método modificador
     * @param RebotesOfensivos Parámetro formal de tipo int (entero) 
     * que modifica el atributo interno correspondiente al schema del XML.
     * @return 
     * @version 1.0
     */

    public void setRebotesOfensivos(int RebotesOfensivos) {
        this.RebotesOfensivos = RebotesOfensivos;
    }
    
    /*
     * Método modificador
     * @param RebotesDefensivos Parámetro formal de tipo int (entero) que modifica
     * el atributo interno correspondiente al schema del XML.
     * @return 
     * @version 1.0
     */

    public void setRebotesDefensivos(int RebotesDefensivos) {
        this.RebotesDefensivos = RebotesDefensivos;
    }
    
    /*
     * Método modificador
     * @param Asistencias Parámetro formal de tipo int (entero) que modifica
     * el atributo interno correspondiente al schema del XML.
     * @return 
     * @version 1.0
     */

    public void setAsistencias(int Asistencias) {
        this.Asistencias = Asistencias;
    }
    
    /*
     * Método modificador
     * @param Robos Parámetro formal de tipo int (entero) que modifica
     * el atributo interno correspondiente al schema del XML.
     * @return 
     * @version 1.0
     */

    public void setRobos(int Robos) {
        this.Robos = Robos;
    }
    
    /*
     * Método modificador
     * @param Perdidas Parámetro formal de tipo int (entero) que modifica
     * el atributo interno correspondiente al schema del XML.
     * @return 
     * @version 1.0
     */

    public void setPerdidas(int Perdidas) {
        this.Perdidas = Perdidas;
    }
    
    /*
     * Método modificador
     * @param Valoracion Parámetro formal de tipo int (entero) que modifica
     * el atributo interno correspondiente al schema del XML.
     * @return 
     * @version 1.0
     */

    public void setValoracion(int Valoracion) {
        this.Valoracion = Valoracion;
    }
    
    
}
