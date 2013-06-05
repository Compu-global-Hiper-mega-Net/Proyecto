package GestionDeGrupos;

import GestionDeAlumnos.Alumno;
import GestionDeInstalaciones.Instalacion;
import GestionDeTemporadas.Temporada;
import GestionDeUsuarios.Usuario;
import ServiciosAlmacenamiento.BaseDatos;
import GestionDeCategorias.Categoria;
import bma.Entrenador;
import bma.Horario;
import bma.Sexo;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.util.List;

/**
 * Clase que nos agrupa a los alumnos en un grupo de entrenamiento.
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

public class Grupo {

    //static void Modificar(Grupo g) {
      //  GruposBD.ModificarGruposBD(g);
    //}

    static void Modificar(BaseDatos accesoBD, Grupo gNuevo, Grupo gViejo, String idGrupo, List<String> listaAlumnos) throws SQLException {
        GruposBD.ModificarGruposBD(accesoBD, gNuevo, gViejo, idGrupo, listaAlumnos);
    }

    private int idGrupo;
    //private Calendar[] horarios;
    
    private String sexo;
    private Categoria categoria;
    //private Categoria categoria;
    private Temporada temporada;
    private List<Alumno> alumnos;
    private Horario horario;
    
    private Usuario entrenador;
    private Instalacion instalacion;

    public Grupo(String temp, String dia1, String dia2, String hora, String min, String entrenador, String cat, String inst) throws ParseException {
                
        temporada = new Temporada(temp);
        horario = new Horario(dia1, dia2, hora, min);
        this.entrenador = new Usuario(entrenador);
        categoria = new Categoria(cat);
        this.instalacion = new Instalacion(inst);
    }

    public Grupo(String cat, String ent, String inst, String temp) {
        this.categoria = new Categoria(cat);
        this.entrenador = new Usuario(ent);
        this.instalacion = new Instalacion(inst);
        this.temporada = new Temporada(temp);
    }

    

    public String getDia1() {
        return horario.getDia1();
    }
    
    String getDia2() {
        return horario.getDia2();
    }
    
    public String getHora1(){
        String s = horario.getHora1().toString();
        return s;
    }

    Time getHora1Time() {
        return horario.getHora1();
    }

    String getTemporada() {
        return temporada.getTemporada();
    }

    String getEntrenador() {
        return entrenador.getNombre();
    }

    String getInstalacion() {
        return instalacion.getNombre();
    }
    
    public String getCategoria(){
        return categoria.getNombreCategoria();
    }

    public void setIdGrupo(int idGrup) {
        this.idGrupo = idGrup;
    }

    public void setIdCat(int idCat) {
        this.categoria.setIdCat(idCat);
    }

    public void setIdEnt(int idEnt) {
        this.entrenador.setIdEnt(idEnt);
    }

    public void setIdInst(int idInst) {
        this.instalacion.setIdInst(idInst);
    }
    
    public void setIdTemp(int idTemp) {
        this.temporada.setIdTemporada(idTemp);
    }

    String getIdGrupo() {
        return Integer.toString(this.idGrupo);
    }

    
    
    
}
