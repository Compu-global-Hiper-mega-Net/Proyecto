/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionDePagos;

import GestionDeAlumnos.GestorAlumnos;
import GestionDeTemporadas.GestorTemporadas;
import ServiciosAlmacenamiento.BaseDatos;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author David
 */
public class PagoBD {

    static List<Integer> getIdCuotas(BaseDatos accesoBD, int idAl, int idTemp) throws SQLException {
        List<Integer> idCuotas = new ArrayList<Integer>();
        
        String query = "SELECT Cuota.idCuota FROM Cuota, PagoTemporada WHERE "
                + "Cuota.idCuota=PagoTemporada.Cuota_idCuota AND "
                + "PagoTemporada.AlumnoTemporada_Alumno_idAlumno='"+idAl+"' AND "
                + "PagoTemporada.AlumnoTemporada_Temporada_idTemporada='"+idTemp+"'";
        ResultSet res = accesoBD.ejecutaConsulta(query);
        
        while(res.next())
            idCuotas.add(res.getInt(1));
        
        return idCuotas;
    }
    
    ResultSet consultaPagoBD(BaseDatos accesoBD, String consulta){
        ResultSet retset;
        retset = accesoBD.ejecutaConsulta(consulta);

        return retset;
    }
    boolean compruebaSiAlumnoEraSocioEnEsaTemporada(BaseDatos accesoBD, int idAlumno, int idTemporada){
        ResultSet retset;
        String consulta=new String();
        consulta="SELECT * FROM temporada, alumno, alumnotemporada altemp WHERE temporada.idTemporada="+idTemporada+" AND alumno.idAlumno="+idAlumno+
                " AND temporada.idTemporada=altemp.temporada_idTemporada AND altemp.alumno_idAlumno=alumno.idAlumno ";
        System.out.print("\nComprueba "+consulta);
        retset = accesoBD.ejecutaConsulta(consulta);
        try{
            if(retset.next()){
                return true;
            }else{
                return false;
            }
        }catch (SQLException ex) {
            System.out.print(ex.getMessage());
            return false;
        }
    }
    void modificarCuotaBD(BaseDatos accesoBD, int idCuota, boolean pagado){
        String actualizacion;
        String pagadoString;
        if(pagado){
            pagadoString="true";
        }else{
            pagadoString="false";
        }
        actualizacion="\nupdate cuota set cuota.pagado="+pagadoString+" where cuota.idCuota="+idCuota;
        System.out.print("la act "+actualizacion);
        try{
            accesoBD.ejecutaActualizacion(actualizacion);
        }catch (SQLException ex) {
            System.out.print(ex.getMessage());
        }
    }  
}
