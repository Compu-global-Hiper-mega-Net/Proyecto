package GestionDeUsuarios;

/**
 * Clase que indica los usuarios del sistema como entrenadores y
 * administradores.
 *
 * @author Alex Moreno
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

public class Usuario {

    private int idUsuario;
    private String dni;
    private String clave;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private String numeroCuenta;
    private int telMovil;
    private int telFijo;
    private String email;
    private boolean entrenador;

    Usuario(String nombre, String primerApellido, String segundoApellido, String dni,
            String clave, boolean entrenador, int telMovil, int telFijo,
            String email, String numeroCuenta){
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.dni = dni;
        this.clave = clave;
        this.entrenador = entrenador;
        this.numeroCuenta = numeroCuenta;
        this.telMovil = telMovil;
        this.telFijo = telFijo;
        this.email = email;
    }

    public Usuario(String e) {
        this.nombre = e;
    }
    public void setIdUsuario(int idUsuario){
        this.idUsuario=idUsuario;
    }
    
    public static Usuario crearUsuario(String nombre,
            String primerApellido, String segundoApellido, String dni,
            String clave, boolean entrenador, int telMovil, int telFijo,
            String email, String numeroCuenta) {
        return new Usuario(nombre,
            primerApellido, segundoApellido, dni,
            clave, entrenador, telMovil, telFijo,
            email, numeroCuenta);
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public String getDni() {
        return dni;
    }

    public String getClave() {
        return clave;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public int getTelMovil() {
        return telMovil;
    }

    public int getTelFijo() {
        return telFijo;
    }

    public String getEmail() {
        return email;
    }

    public boolean getEntrenador() {
        return entrenador;
    }

    public void setIdEnt(int idEnt) {
        this.idUsuario = idEnt;
    }
}
