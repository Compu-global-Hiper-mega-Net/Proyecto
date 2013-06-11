/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionDePagos;

import GestionActividades.Actividad;
import GestionDeTemporadas.Temporada;
import java.text.ParseException;

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
 * Clase Pago de Actividad
 *
 * @author Carlos, Francis
 */
public class PagoActividad {

    private int idPagoActividad;
    private String recibo;
    private Actividad actividad;
    private CuotaPrecio cuota;
    private Temporada temporada;
    
    /**
     * Constructor de la clase
     * @param actividad Parametro formal de tipo String (cadena) que contiene
     * el dato de la actividad a la que pertenece el pago.
     * @param temporada Parametro formal de tipo String (cadena) que contiene
     * el dato de la temporada a la que pertenece el pago.
     * @param fecha Parametro formal de tipo String (cadena) que contiene
     * el dato de la fecha cuando se realizo el pago.
     * @param importe Parametro formal de tipo String (cadena) que contiene
     * el dato del importe del pago.
     * @param pagado
     * @throws ParseException excepción que se lanzará al encontrar un problema
     * al transformar un tipo conocido a un atributo interno de la clase.
     */

    public PagoActividad(String actividad, String temporada, String fecha, String importe, String pagado) throws ParseException {
        this.actividad = new Actividad(actividad);
        this.temporada = new Temporada(temporada);
        cuota = new CuotaPrecio(fecha, importe, pagado);
    }

    /**
     * Metodo consultor
     * @return int devuelve el identificador del pago de la actividad
     */
    public int getIdPagoActividad() {
        return idPagoActividad;
    }

    /**
     * Metodo consultor
     * @return String devuelve el recibo del pago almacenado en nuestro
     * sistema.
     */
    public String getRecibo() {
        return recibo;
    }

    /**
     * Metodo consultor
     * @return Actividad devuelve un objeto de tipo Actividad en donde
     * vendrán los datos relacionados con la misma para su tratamiento.
     */
    public Actividad getActividad() {
        return actividad;
    }

    /**
     * Metodo consultor
     * @return CuotraPrecio devuelve un objeto de tipo CuotaPrecio en donde
     * vendrán los datos relacionados con la misma para su tratamiento.
     */
    public CuotaPrecio getCuota() {
        return cuota;
    }

    /**
     * Metodo consultor
     * @return Temporada devuelve un objeto de tipo Temporada en donde
     * vendrán los datos relacionados con la misma para su tratamiento.
     */
    public Temporada getTemporada() {
        return temporada;
    }

    /**
     * Metodo consultor
     * @return Object devuelve un objeto de tipo Object en donde vendrán
     * contenido la excpeción creada para cuando se halle un error 
     * con la devolución de un nombre.
     */
    public Object getNombre() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Metodo consultor
     * @return Object devuelve un objeto de tipo Object en donde vendrán
     * contenido la excpeción creada para cuando se halle un error 
     * con la devolución de una categoria.
     */
    public Object getCategoria() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Metodo consultor
     * @return Object devuelve un objeto de tipo Object en donde vendrán
     * contenido la excpeción creada para cuando se halle un error 
     * con la devolución de un entrenador.
     */

    public Object getEntrenador() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Metodo consultor
     * @return Object devuelve un objeto de tipo Object en donde vendrán
     * contenido la excpeción creada para cuando se halle un error 
     * con la devolución del segundo entreandor
     */
    
    public Object getEntrenador2() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
