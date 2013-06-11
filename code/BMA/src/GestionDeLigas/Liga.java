/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionDeLigas;

/**
 *
 * @author Julio
 */
public class Liga {
    private int idLiga;
    private String nombre;
    private int idCategoriaLiga;
    private int idTemporadaLiga;
    
    public Liga (String nomb, int idCatLig, int idTempLig){
        this.nombre = nomb;
        this.idCategoriaLiga = idCatLig;
        this.idTemporadaLiga = idTempLig;
    }

    public int getIdLiga() {
        return idLiga;
    }

    public String getNombre() {
        return nombre;
    }

    public int getIdCategoriaLiga() {
        return idCategoriaLiga;
    }

    public int getIdTemporadaLiga() {
        return idTemporadaLiga;
    }
    
    
    
}
