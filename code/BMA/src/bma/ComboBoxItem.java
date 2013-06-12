package bma;

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
 * Clase que permite dar mayor funcionalidad a los combobox incluyendo además de
 * la descripción del item el identificador de ese item con respecto a la base
 * de datos
 *
 * @author Alex
 */
public class ComboBoxItem {

    private int id;
    private String description;

    /**
     * Constructor de la clase
     * @param id Parametro formal de tipo int (entero) que se corresponde
     * con el identificador de la clase o tabla asociada de nuestra base
     * de datos relacional.
     * @param description Parametro formal de tipo String (cadena) que se
     * corresponde con la descripcion del item que el usuario verá del
     * comboBox.
     */
    public ComboBoxItem(int id, String description) {
        this.id = id;
        this.description = description;
    }

    /**
     * Método consultor
     * @return int devuelve un tipo int (entero) que es el identificador 
     * de la clase o tabla asociada de nuestra base de datos relacional.
     */
    public int getId() {
        return id;
    }

    /**
     * Método consultor
     * @return String devuelve un tipo String (cadena) que se corresponde
     * con la descripción del item que el usuario verá del comboBox.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Método consultor sobrecargado (toString)
     * @return String devuelve un tipo String (entero) que se correponde con la 
     * descripción del item que el usuario verá del comboBox.
     */
    @Override
    public String toString() {
        return description;
    }

    /**
     * Método consultor sobrecargado (equals)
     * @param object Parametro formal de tipo Object que permite comparar
     * el objeto de entrada (preferiblemente otro comboBox) con el identificador
     * interno de la clase comboBoxItem.
     * @return boolean devuelve un tipo boolean (booleano) comprobación de si
     * la operación de igualdad entre Objetos ha sido satisfactoria (true)
     * o no (false).
     */
    @Override
    public boolean equals(Object object) {
        return id == ((ComboBoxItem) object).getId();
    }
}
