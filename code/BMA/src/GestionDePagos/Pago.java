/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionDePagos;

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
 * Clase Pago
 * @author Carlos, Francis
 * @deprecated NO VALIDA
 */
public class Pago {
    
    /* Atributos internos de la clase */
    
    private int idPago;
    private CuotaPrecio importe;
    private PagoActividad actividad;
    private PagoTemporada temporada;
    private String fecha;
    
    /**
     * Constructor de la clase - NO VALIDA -
     * @param fecha 
     * @param importe 
     * @param pagado 
     */
    Pago(String fecha, float importe, int  pagado){
        this.fecha = fecha;
    }
}
