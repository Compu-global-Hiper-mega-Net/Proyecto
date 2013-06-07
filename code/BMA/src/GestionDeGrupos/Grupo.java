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
    
    private int idGrupo;
    //private Calendar[] horarios;
    
    private String sexo;
    private Categoria categoria;
    //private Categoria categoria;
    private Temporada temporada;
    private List<Alumno> alumnos;
    private Horario horario;
    
    private Usuario entrenador = new Usuario();
    private Instalacion instalacion;

    //static void Modificar(Grupo g) {
      //  GruposBD.ModificarGruposBD(g);
    //}

    /**
     * Permite modificar un grupo previamente almacenado en la BD.
     * @param accesoBD Usado para interactuar con la base de datos.
     * @param gNuevo Objeto de la clase Grupo con los nuevos parametros del grupo 
     * que queremos modificar.
     * @param gViejo Objeto de la clase Grupo con los antiguos parametros que serán 
     * modificados.
     * @param idGrupo <code>String</code> con el identificador del grupo del que 
     * queremos modificar datos.
     * @param listaAlumnos Lista de <code>String</code> con los alumnos que serán 
     * modificados del grupo.
     * @throws SQLException 
     */
    static void Modificar(BaseDatos accesoBD, Grupo gNuevo, Grupo gViejo, String idGrupo, List<String> listaAlumnos) throws SQLException {
        GruposBD.ModificarGruposBD(accesoBD, gNuevo, gViejo, idGrupo, listaAlumnos);
    }

    /**
     * Constructor de la clase Grupo.
     * @param temp <code>String</code> con la temporada en la que se va a ha crear 
     * el grupo.
     * @param dia1 <code>String</code> con el primer dia de entrenamiento del grupo.
     * @param dia2 <code>String</code> con el segundo dia de entrenamiento del grupo.
     * @param hora <code>String</code> con la hora a la que entrena el grupo.
     * @param min <code>String</code> con los minutos a los que entrena el grupo.
     * @param entrenador <code>String</code> con el nombre del entrenados que 
     * entrenará al grupo.
     * @param cat <code>String</code> con el nombre de la categoria del grupo.
     * @param inst <code>String</code> con el nombre de la instalacion donde 
     * entrenará el grupo.
     * @throws ParseException 
     */
    public Grupo(String temp, String dia1, String dia2, String hora, String min, String entrenador, String cat, String inst) throws ParseException {
        temporada = new Temporada(temp);
        horario = new Horario(dia1, dia2, hora, min);
        this.entrenador = new Usuario(entrenador);
        categoria = new Categoria(cat);
        this.instalacion = new Instalacion(inst);
    }

    /**
     * Constructor de la clase Grupo.
     * @param cat <code>String</code> con el nombre de la categoria del grupo.
     * @param ent <code>String</code> con el nombre del entrenados que 
     * entrenará al grupo.
     * @param inst <code>String</code> con el nombre de la instalacion donde 
     * entrenará el grupo.
     * @param temp  <code>String</code> con la temporada en la que se va a ha crear 
     * el grupo.
     */
    public Grupo(String cat, String ent, String inst, String temp) {
        this.categoria = new Categoria(cat);
        this.entrenador = new Usuario(ent);
        this.instalacion = new Instalacion(inst);
        this.temporada = new Temporada(temp);
    }

    
    /**
     * Permite obtener el primer dia de entrenamiento del grupo.
     * @return Un <code>String</code> con el primer dia de entrenamiento.
     */
    public String getDia1() {
        return horario.getDia1();
    }
    
    /**
     * Permite obtener el segundo dia de entrenamiento del grupo.
     * @return Un <code>String</code> con el segundo dia de entrenamiento.
     */
    String getDia2() {
        return horario.getDia2();
    }
    
    /**
     * Permite obtener la hora de entrenamiento del grupo
     * @return Un <code>String</code> con la hora del entrenamiento.
     */
    public String getHora1(){
        String s = horario.getHora1().toString();
        return s;
    }

    /**
     * Permite obtener la hora de entrenamiento del grupo.
     * @return Tipo <code>Date</code> con la hora de entrenamiento.
     */
    Time getHora1Time() {
        return horario.getHora1();
    }

    /**
     * Permite obtener la temporada del grupo.
     * @return Un <code>String</code> con la temporada en la que fue creado el grupo.
     */
    String getTemporada() {
        //return temporada.getTemporada();
        return temporada.getCurso();
    }

    /**
     * Permite obtener el nombre del entrenador del grupo.
     * @return Un <code>String</code> con el nombre del entrenador del grupo.
     */
    String getEntrenador() {
        return entrenador.getNombre();
    }

    /**
     * Permite obtener el nombre de la instalacion donde entrena el grupo.
     * @return Un <code>String</code> con el nombre de la instalacion donde entrena
     * el grupo.
     */
    String getInstalacion() {
        return instalacion.getNombre();
    }
    
    /**
     * Permite obtener el nombre de la categoria asociada al grupo.
     * @return Un <code>String</code> con el nombre de la categoria del grupo.
     */
    public String getCategoria(){
        return categoria.getNombreCategoria();
    }

    /**
     * Permite establecer el identificador del objeto de la clase Grupo.
     * @param idGrup El identificador del grupo que queremos
     * establecer en el grupo.
     */
    public void setIdGrupo(int idGrup) {
        this.idGrupo = idGrup;
    }

    /**
     * Permite establecer el identificador de la categoria de la clase Grupo.
     * @param idCat El identificador de la categoria.
     */
    public void setIdCat(int idCat) {
        this.categoria.setIdCat(idCat);
    }

    /**
     * Permite establecer el identificador del entrenador del grupo en el objeto 
     * de la clase Grupo.
     * @param idEnt El identificador del entrenador que queremos establecer en 
     * el grupo.
     */
    public void setIdEnt(int idEnt) {
        this.entrenador.setIdEnt(idEnt);
    }

    /**
     * Permite establecer el identificador de la instalacion del grupo en el 
     * objeto de la clase Grupo.
     * @param idInst El identificador de la instalacion que queremos establecer 
     * en el grupo.
     */
    public void setIdInst(int idInst) {
        this.instalacion.setIdInst(idInst);
    }
    
    /**
     * Permite establecer el identificador de la temporada del grupo en el 
     * objeto de la clase Grupo.
     * @param idTemp El identificador de la temporada que queremos establecer 
     * en el grupo.
     */
    public void setIdTemp(int idTemp) {
        this.temporada.setIdTemporada(idTemp);
    }

    /**
     * Permite obtener el identificador del grupo.
     * @return Un <code>String</code> con el identificador del grupo.
     */
    String getIdGrupo() {
        return Integer.toString(this.idGrupo);
    }

    int getIdInstalacion() {
        return this.instalacion.getIdInstalacion();
    }

    String getIdCategoria() {
        return this.categoria.getIdCategoria();
    }

    int getIdEntrenador() {
        return this.entrenador.getIdEntrenador();
    }

    int getIdTemporada() {
        return this.temporada.getIdTemporada();
    }

    
    
    
}
