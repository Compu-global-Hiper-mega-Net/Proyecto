
package InterfazUsuario;

import ServiciosAlmacenamiento.BaseDatos;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;


/******************************************************************************
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
 ******************************************************************************/

/**
 * Clase para estadisticas de jugador del paquete InterfazUsuario. Ofrece una manera de interactuar 
 * con  los elementos de la interfaz de estadisticas y diversas funcionalidades para estos elementos.
 * @author Javier
 */

 public class EstadisticasJugador extends javax.swing.JFrame {  
   
    BaseDatos accesoBD;
    ResultSet retset; 
    JFreeChart Grafica;
    ChartPanel Panel ;
    JFrame Ventana ;
    DefaultCategoryDataset Datos = new DefaultCategoryDataset();
    DefaultTableModel dtm = new DefaultTableModel();
    List <String> partidosJug = new ArrayList <>();
    
    /**
     * Constructor sin parametros de la clase
     */       
    public EstadisticasJugador() {
        initComponents();
    }
    
    /**
     * Constructor con parametros de la clase, usado para inicializar varios componentes y hacer una llamada al metodo actualizaTablaEstadisticas()
     * @param acceso parametro de tipo BaseDatos usado para acceder a la base de datos
     * @param rst parametro de tipo ResultSet usado para obtener el resultado de las consultas al interactuar con la base de datos.
     * @param jugadorElegido parametro de tipo String usado para obtener de la interfaz principal el nombre del jugador elegido para mostrarlo en 
     * esta interfaz
     */
    public EstadisticasJugador(BaseDatos acceso, ResultSet rst, String jugadorElegido) {
        
        accesoBD = acceso;
        retset = rst;
        initComponents();
        nombreAlumnoElegido.setText(jugadorElegido);
        try {
            actualizaTablaEstadisticas();
        } catch (SQLException ex) {
            Logger.getLogger(EstadisticasEntrenador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    /**
     * Metodo que actualiza la tabla que se va a mostrar en las estadisitcas del jugador, para ello obtiene los datos de retset en la consulta que se 
     * realizo desde la interfaz principal y  para cada fila de la tabla hace dos consultas a las base de datos para obtener los nombres de los equipos 
     * @throws SQLException 
     */
    private  void actualizaTablaEstadisticas() throws SQLException {   
       
        dtm.addColumn("Partido");
        dtm.addColumn("Asistencias");
        dtm.addColumn("Rebotes ofensivos");
        dtm.addColumn("Rebotes defensivos");
        dtm.addColumn("Robos");
        dtm.addColumn("Perdidas");
        dtm.addColumn("Puntos");

        Object[] fila = new Object[7];

        while(retset.next()){       

            int idEquipoLoc = retset.getInt(1);
            String consulta1 = "SELECT nombre FROM equipo WHERE idEquipo='"+idEquipoLoc+"'";
            ResultSet rst1 = accesoBD.ejecutaConsulta(consulta1); 

            int idEquipoVis = retset.getInt(2);
            String consulta2 = "SELECT nombre FROM equipo WHERE idEquipo='"+idEquipoVis+"'";
            ResultSet rst2 = accesoBD.ejecutaConsulta(consulta2);

            if(rst1.next()&& rst2.next()){
               String nombrePartido = (rst1.getString(1)+" - "+rst2.getString(1));
               fila[0] = nombrePartido;

               partidosJug.add(nombrePartido);
            }
            fila[1] = retset.getString(3);
            fila[2] = retset.getString(4);
            fila[3] = retset.getString(5);
            fila[4] = retset.getString(6);
            fila[5] = retset.getString(7);
            fila[6] = retset.getString(8);

            dtm.addRow(fila);
        }
        tablaJugadoresEstadisticas.setModel(dtm);
    }
    
    /**
     * Metodo que actualiza las graficas que se muestran con los datos de jugadores, para ello primero se comprueba que grupo de datos de ha elegido en 
     * la interfaz (pudiendo elegir varios o uno solo) y seguidamente se añaden a Datos todos los datos obtenidos en cunsultas anteriores los cuales
     * se mostraran en  la grafica
     * @throws SQLException 
     */
     private  void actualizaGraficas() throws SQLException{ 
         
        int i;
        List<String> idDatos = new ArrayList<>();
        List<Integer> numCol = new ArrayList<>();
            
            if (estadisticasAsistencias.isSelected()){
                idDatos.add("asistencias");
                numCol.add(1);
            }if(estadisticasRebOfen.isSelected()){
               idDatos.add("rebotesOfensivos");
               numCol.add(2);
            }if(estadisticasRebDef.isSelected()){
               idDatos.add("rebotesDefensivos");
               numCol.add(3);
            }if(estadisticasRobos.isSelected()){
               idDatos.add("robos");
               numCol.add(4);
            }if(estadisticasPerdidas.isSelected()){
               idDatos.add("perdidas");
               numCol.add(5);
            }if(estadisticasPuntos.isSelected()){
               idDatos.add("puntos");
               numCol.add(6);
            }
              
        for (int j = 0; j < idDatos.size(); j++) {
            try {
                i=0;
                retset.beforeFirst();
                while(retset.next()){ 
                        Datos.addValue(retset.getInt(idDatos.get(j)), (Comparable) dtm.getColumnName(numCol.get(j)), (Comparable) partidosJug.get(i)); 
                        i++;
                }
            } catch (SQLException ex) {
                  Logger.getLogger(EstadisticasJugador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        Grafica = ChartFactory.createBarChart3D(null, "Partidos jugados", null,
                                               Datos, PlotOrientation.HORIZONTAL, true, true, false);  
     }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botonSalir = new javax.swing.JToggleButton();
        panelTabEstJug = new javax.swing.JScrollPane();
        tablaJugadoresEstadisticas = new javax.swing.JTable();
        jugadorLab = new javax.swing.JLabel();
        nombreAlumnoElegido = new javax.swing.JLabel();
        verGraficas = new javax.swing.JButton();
        estadisticasRebOfen = new javax.swing.JCheckBox();
        estadisticasRebDef = new javax.swing.JCheckBox();
        estadisticasPerdidas = new javax.swing.JCheckBox();
        estadisticasPuntos = new javax.swing.JCheckBox();
        estadisticasAsistencias = new javax.swing.JCheckBox();
        estadisticasRobos = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        botonSalir.setText("Salir");
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });

        panelTabEstJug.setAutoscrolls(true);

        tablaJugadoresEstadisticas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tablaJugadoresEstadisticas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Partido ", "Asistencias", "Rebotes ofensivos", "Rebotes defensivos", "Robos", "Perdidas", "Puntos"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tablaJugadoresEstadisticas.setColumnSelectionAllowed(true);
        panelTabEstJug.setViewportView(tablaJugadoresEstadisticas);
        tablaJugadoresEstadisticas.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        jugadorLab.setText("Jugador:");

        verGraficas.setText("Ver Graficas");
        verGraficas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verGraficasActionPerformed(evt);
            }
        });

        estadisticasRebOfen.setText("Datos Graficas");

        estadisticasRebDef.setText("Datos Graficas");

        estadisticasPerdidas.setText("Datos Graficas");

        estadisticasPuntos.setText("Datos Graficas");

        estadisticasAsistencias.setText("Datos Graficas");

        estadisticasRobos.setText("Datos Graficas");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jugadorLab, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nombreAlumnoElegido, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelTabEstJug, javax.swing.GroupLayout.PREFERRED_SIZE, 936, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(estadisticasAsistencias)
                                .addGap(38, 38, 38)
                                .addComponent(estadisticasRebOfen)
                                .addGap(35, 35, 35)
                                .addComponent(estadisticasRebDef)
                                .addGap(37, 37, 37)
                                .addComponent(estadisticasRobos)
                                .addGap(33, 33, 33)
                                .addComponent(estadisticasPerdidas))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(verGraficas, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botonSalir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(estadisticasPuntos)
                                .addGap(18, 18, 18)))))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(106, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jugadorLab)
                    .addComponent(nombreAlumnoElegido))
                .addGap(32, 32, 32)
                .addComponent(panelTabEstJug, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(estadisticasRebOfen)
                    .addComponent(estadisticasRebDef)
                    .addComponent(estadisticasPerdidas)
                    .addComponent(estadisticasPuntos)
                    .addComponent(estadisticasAsistencias)
                    .addComponent(estadisticasRobos))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonSalir)
                    .addComponent(verGraficas))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Metodo que al pulsar el boton para salir de la interfaz de estadistics de jugador , cierra esta ventana y ademas cierra
     * la ventana que muestra las graficas, si es que se creo alguna.
     * @param evt parametro de tipo java.awt.event.ActionEvent
     */
    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        
        this.setVisible(false);
        Ventana.setVisible(false);
    }//GEN-LAST:event_botonSalirActionPerformed

    /**
     * Metodo que al pulsar el boton para ver las graficas de las estadisticas del jugador comprueba que al menos se haya seleccionado un grupo de datos
     * para mostrar la grafica, mientras no sea asi mostrara un mensaje indicando que se seleccione uno o varios grupos de datos. Seguidamente hace una 
     * llamada a actualizaGraficas() donde se van a introducir los datos de la grafica en Datos y por ultimo se crea una nueva ventana que muestra la grafica.
     * @param evt parametro de tipo java.awt.event.ActionEvent
     */
    private void verGraficasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verGraficasActionPerformed
 
         if(!estadisticasAsistencias.isSelected() && !estadisticasRebOfen.isSelected()&& !estadisticasRebDef.isSelected()
         && !estadisticasRobos.isSelected() && !estadisticasPerdidas.isSelected() && !estadisticasPuntos.isSelected())
              JOptionPane.showMessageDialog(null,"Seleccione al menos un grupo de datos para ver grafica");
                                              
         else{
             try {
                 Datos.clear();
                 actualizaGraficas();
             } catch (SQLException ex) {
                 Logger.getLogger(EstadisticasJugador.class.getName()).log(Level.SEVERE, null, ex);
             }
             Panel = new ChartPanel(Grafica);
             Ventana = new JFrame("Gráficas");
             Ventana.getContentPane().add(Panel);
             Ventana.pack();
             Ventana.setVisible(true);
             Ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
         }
    }//GEN-LAST:event_verGraficasActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton botonSalir;
    private javax.swing.JCheckBox estadisticasAsistencias;
    private javax.swing.JCheckBox estadisticasPerdidas;
    private javax.swing.JCheckBox estadisticasPuntos;
    private javax.swing.JCheckBox estadisticasRebDef;
    private javax.swing.JCheckBox estadisticasRebOfen;
    private javax.swing.JCheckBox estadisticasRobos;
    private javax.swing.JLabel jugadorLab;
    private javax.swing.JLabel nombreAlumnoElegido;
    private javax.swing.JScrollPane panelTabEstJug;
    private javax.swing.JTable tablaJugadoresEstadisticas;
    private javax.swing.JButton verGraficas;
    // End of variables declaration//GEN-END:variables
}
