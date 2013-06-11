/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionDePagos;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
 * Clase que contiene la cuota o precio de las mensualidades de la temporada
 * o la cuota de la actividad pertinente
 * @author Carlos, Francis
 */
public class CuotaPrecio {

    private Date fechaPago;
    private int idCuotaPrecio;
    private float importe;
    private boolean pagado;

    /**
     * Constructor de la clase
     * @param fecha Parametro formal de tipo String (cadena) que contiene
     * la fecha de la cuota.
     * @param importe Parametro formal de tipo String (cadena) que contiene
     * el importe de la cuota pagada por el alumno.
     * @param pagado Parametro formal de tipo String (cadena) que contiene
     * el información asociada al pago o no de la cuota
     * @throws ParseException Excepción que se lanzará cuando se encuentre
     * una situación inesperada al parsear un tipo o documento a nuestro dominio
     */
    
    public CuotaPrecio(String fecha, String importe, String pagado) throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        this.fechaPago = (Date) formato.parse(fecha);
        this.importe = Float.parseFloat(importe);
        this.pagado = Boolean.parseBoolean(pagado);
    }
    
    /**
     * Metodo consultor
     * @return int devuelve el identificador del precio de la cuota de
     * nuestro sistema.
     */
    public int getIdCuotaPrecio(){
        return this.idCuotaPrecio;
    }
}
