
package InterfazUsuario;


import GestionDeEquipos.GestorEquipos;
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
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;


/**
 * ****************************************************************************
 * (c) Copyright 2013
 *
 * Moisés Gautier Gómez Julio Ros Martínez Francisco Javier Gómez del Olmo
 * Francisco Santolalla Quiñonero Carlos Jesús Fernández Basso Alexander Moreno
 * Borrego Jesús Manuel Contreras Siles Diego Muñoz Rio
 *
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************
 */

/**
 * Clase para estadisticas de la clasificacion de equipos del paquete InterfazUsuario. Ofrece una manera de interactuar 
 * con  los elementos de la interfaz de estadisticas y diversas funcionalidades para estos elementos.
 * @author Javier
 */

public class ClasificacionLiga extends javax.swing.JFrame {
    
    BaseDatos accesoBD;
    ResultSet retset;
    String temporadaElegida;
    String categoriaElegida;
    JFreeChart Grafica;
    ChartPanel Panel ;
    JFrame Ventana ;
    DefaultCategoryDataset Datos = new DefaultCategoryDataset();
    DefaultTableModel dtm = new DefaultTableModel();
    List<Integer> pGanados = new ArrayList<>();
    List<Integer> pPerdidos = new ArrayList<>();
    
   /**
    * Constructor sin parametros de la clase
    */ 
    public ClasificacionLiga() {
        initComponents();
    }
    
    /**
     * Constructor con parametros de la clase, usado para inicializar varios componentes y hacer una llamada al metodo actualizaComboCategoria() y
     * actualizaComboTemporada()
     * @param acceso parametro de tipo BaseDatos usado para acceder a la base de datos.
     */
    public ClasificacionLiga(BaseDatos acceso) {
        
        accesoBD = acceso;
        initComponents();
        
        try {
            actualizaComboTemporada();
            actualizaComboCategoria();
        } catch (SQLException ex) {
            Logger.getLogger(EstadisticasTemporada.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    /**
     * Metodo que actualiza la tabla que se va a mostrar en las estadisitcas de la clasificacion, para ello hace dos consultas a las base de datos para
     * obtener el idTemporada y el  idCategoria respectivamente, seguidamente obtiene los datos de la consulta principal haciendo una llamada al
     * metodo consultarClasificacion(accesoBD, idTemp, idCate) de GestorEquipos y por ultimo va actualizando los datos de la tabla
     * con los resultados obtenidos en retset de la consulta principal y haciendo para cada fila dos consultas para obtener para cada equipo
     * el numero de  partidos que ha ganadao y de partidos que ha perdido respectivamente.
     * @throws SQLException 
     */
    private void actualizaTablaClasificacion() throws SQLException {

        int idTemp = 0, idCate = 0, i=1;

        String consulta = "SELECT idTemporada FROM mydb.temporada WHERE curso='"+elegirTemporadaLis.getSelectedItem().toString()+"';";
        ResultSet res1 = accesoBD.ejecutaConsulta(consulta);
        if (res1.next()) {
            idTemp = res1.getInt(1);
        }

        consulta = "SELECT idCategoria FROM mydb.categoria WHERE tipo='"+elegirCategoriaLis.getSelectedItem().toString()+"';";
        ResultSet res2 = accesoBD.ejecutaConsulta(consulta);
        if (res2.next()) {
            idCate = res2.getInt(1);
        }

        retset = GestorEquipos.consultarClasificacion(accesoBD, idTemp, idCate);

        if (retset == null) {
           JOptionPane.showMessageDialog(null,"No hay datos que mostrar en la tabla de clasificacion");  
        } else {
            DefaultTableModel dtm = new DefaultTableModel();
            dtm.addColumn("Posicion");
            dtm.addColumn("Nombre equipo");
            dtm.addColumn("Partidos jugados");
            dtm.addColumn("Partidos ganados");
            dtm.addColumn("Partidos perdidos");
            dtm.addColumn("Puntos a favor");
            dtm.addColumn("Puntos en contra");

            Object[] fila = new Object[7];

            while (retset.next()) {

                fila[0] = i;
                i++;
                
                fila[1] = retset.getString(1);

                String consulta3 = "SELECT COUNT(*) FROM partido p, equipo e WHERE (resultadoLocal > resultadoVisitante)"
                        + "AND p.idEquipo=e.idEquipo AND e.nombre='"+(String) fila[1]+"'";
                System.out.printf(consulta3);
                ResultSet res3 = accesoBD.ejecutaConsulta(consulta3);
                if (res3.next()) {
                    fila[3] = res3.getString(1);
                    pGanados.add(res3.getInt(1));
                }

                String consulta4 = "SELECT COUNT(*) FROM partido p, equipo e WHERE (resultadoLocal < resultadoVisitante)"
                        + "AND p.idEquipo=e.idEquipo AND e.nombre='"+(String) fila[1]+"'";
                System.out.printf(consulta4);
                ResultSet res4 = accesoBD.ejecutaConsulta(consulta4);
                if (res4.next()) {
                    fila[4] = res4.getString(1);
                    pPerdidos.add(res4.getInt(1));
                }
                
                fila[2] = res3.getInt(1)+res4.getInt(1);

                fila[5] = retset.getString(2);
                fila[6] = retset.getString(3);

                dtm.addRow(fila);
            }

            tablaEstadisticasClasificacion.setModel(dtm);
        }
    }
    
    /**
     * Metodo que actualiza el combo con la lista de temporadas existentes en la base de datos,
     * para ello hace una consulta para obtener estos datos.
     * @throws SQLException 
     */
    private void actualizaComboTemporada() throws SQLException {
        elegirTemporadaLis.removeAllItems();
        elegirTemporadaLis.addItem(" ");

        String consulta = "SELECT DISTINCT curso FROM temporada;";
        ResultSet res = accesoBD.ejecutaConsulta(consulta);
        while (res.next()) {
            elegirTemporadaLis.addItem(res.getString(1));
        }
    }

    /**
     * Metodo que actualiza el combo con la lista de categorias existentes en la base de datos,
     * para ello hace una consulta para obtener estos datos.
     * @throws SQLException 
     */
    private void actualizaComboCategoria() throws SQLException {
        elegirCategoriaLis.removeAllItems();
        elegirCategoriaLis.addItem(" ");

        String consulta = "SELECT DISTINCT tipo FROM categoria;";
        ResultSet res = accesoBD.ejecutaConsulta(consulta);
        while (res.next()) {
            elegirCategoriaLis.addItem(res.getString(1));
        }
    }
    
    
    /**
    * Metodo que actualiza las graficas que se muestran con los datos de la clasificacion, para ello primero se comprueba que grupo de datos de ha elegido en 
    * la interfaz (pudiendo elegir varios o uno solo) y seguidamente se añaden a Datos todos los datos obtenidos en cunsultas anteriores los cuales
    * se mostraran en  la grafica
    * @throws SQLException 
    */
    private void actualizaGraficas() throws SQLException {
        
        int i=0, j=0, k=0;
        
        try {
            if (estadisticasPartidosJugados.isSelected()){
                retset.beforeFirst();
                while(retset.next()){
                    Datos.addValue((pGanados.get(i)+pPerdidos.get(i)), (Comparable) tablaEstadisticasClasificacion.getColumnName(2), (Comparable) retset.getString(1)); 
                    i++;
                }
            }
            if (estadisticasPartidosGanados.isSelected()){
                retset.beforeFirst();
                while(retset.next()){
                    Datos.addValue(pGanados.get(j), (Comparable) tablaEstadisticasClasificacion.getColumnName(3), (Comparable) retset.getString(1)); 
                    j++;
                }
            }
            if(estadisticasPartidosPerdidos.isSelected()){
                retset.beforeFirst();
                while(retset.next()){
                    Datos.addValue(pPerdidos.get(k), (Comparable) tablaEstadisticasClasificacion.getColumnName(4), (Comparable) retset.getString(1)); 
                        k++;
                }
            }
            if(estadisticasPuntosFavor.isSelected()){
                retset.beforeFirst();
                while(retset.next())
                     Datos.addValue(retset.getInt(2), (Comparable) tablaEstadisticasClasificacion.getColumnName(5), (Comparable) retset.getString(1)); 
            }
            if(estadisticasPuntosContra.isSelected()){
                retset.beforeFirst();
                while(retset.next())
                     Datos.addValue(retset.getInt(3), (Comparable) tablaEstadisticasClasificacion.getColumnName(6), (Comparable) retset.getString(1)); 
            }
        } catch (SQLException ex) {
              Logger.getLogger(EstadisticasJugador.class.getName()).log(Level.SEVERE, null, ex);
        }

        Grafica = ChartFactory.createBarChart3D(null, "Equipos", null,
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

        clasificacionLab = new javax.swing.JLabel();
        botonSalir = new javax.swing.JToggleButton();
        elegirCategoriaLab = new javax.swing.JLabel();
        elegirCategoriaLis = new javax.swing.JComboBox();
        panelTabClasificacion = new javax.swing.JScrollPane();
        tablaEstadisticasClasificacion = new javax.swing.JTable();
        elegirTemporadaLis = new javax.swing.JComboBox();
        botonMostrarClasificacion = new javax.swing.JButton();
        mostrarGraficasLiga = new javax.swing.JButton();
        estadisticasPuntosContra = new javax.swing.JCheckBox();
        estadisticasPuntosFavor = new javax.swing.JCheckBox();
        estadisticasPartidosPerdidos = new javax.swing.JCheckBox();
        estadisticasPartidosGanados = new javax.swing.JCheckBox();
        estadisticasPartidosJugados = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        clasificacionLab.setText("Clasificación de la liga en la temporada:");

        botonSalir.setText("Salir");
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });

        elegirCategoriaLab.setText("Elegir categoría:");

        elegirCategoriaLis.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        elegirCategoriaLis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                elegirCategoriaLisActionPerformed(evt);
            }
        });

        panelTabClasificacion.setAutoscrolls(true);

        tablaEstadisticasClasificacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tablaEstadisticasClasificacion.setModel(new javax.swing.table.DefaultTableModel(
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
                "Posicion", "Nombre equipo", "Partidos jugados", "Partidos ganados", "Partidos perdidos", "Puntos a favor", "Puntos en contra"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tablaEstadisticasClasificacion.setColumnSelectionAllowed(true);
        panelTabClasificacion.setViewportView(tablaEstadisticasClasificacion);
        tablaEstadisticasClasificacion.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tablaEstadisticasClasificacion.getColumnModel().getColumn(6).setResizable(false);

        elegirTemporadaLis.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        botonMostrarClasificacion.setText("Mostrar");
        botonMostrarClasificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMostrarClasificacionActionPerformed(evt);
            }
        });

        mostrarGraficasLiga.setText("Ver Graficas");
        mostrarGraficasLiga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarGraficasLigaActionPerformed(evt);
            }
        });

        estadisticasPuntosContra.setText("Datos Graficas");

        estadisticasPuntosFavor.setText("Datos Graficas");

        estadisticasPartidosPerdidos.setText("Datos Graficas");

        estadisticasPartidosGanados.setText("Datos Graficas");

        estadisticasPartidosJugados.setText("Datos Graficas");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(clasificacionLab)
                        .addGap(18, 18, 18)
                        .addComponent(elegirTemporadaLis, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(elegirCategoriaLab)
                        .addGap(18, 18, 18)
                        .addComponent(elegirCategoriaLis, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonMostrarClasificacion))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(668, 668, 668)
                        .addComponent(mostrarGraficasLiga, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelTabClasificacion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 921, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(estadisticasPartidosJugados)
                .addGap(34, 34, 34)
                .addComponent(estadisticasPartidosGanados)
                .addGap(35, 35, 35)
                .addComponent(estadisticasPartidosPerdidos)
                .addGap(34, 34, 34)
                .addComponent(estadisticasPuntosFavor)
                .addGap(34, 34, 34)
                .addComponent(estadisticasPuntosContra)
                .addGap(46, 46, 46))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(68, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clasificacionLab)
                    .addComponent(elegirCategoriaLab)
                    .addComponent(elegirCategoriaLis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(elegirTemporadaLis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonMostrarClasificacion))
                .addGap(32, 32, 32)
                .addComponent(panelTabClasificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(estadisticasPuntosContra)
                    .addComponent(estadisticasPuntosFavor)
                    .addComponent(estadisticasPartidosPerdidos)
                    .addComponent(estadisticasPartidosGanados)
                    .addComponent(estadisticasPartidosJugados))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonSalir)
                    .addComponent(mostrarGraficasLiga))
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    /**
     * Metodo que al pulsar el boton para salir de la interfaz de estadistics de la clasificacion cierra esta ventana.
     * @param evt parametro de tipo java.awt.event.ActionEvent
     */
    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        
        this.setVisible(false);
    }//GEN-LAST:event_botonSalirActionPerformed

    private void elegirCategoriaLisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_elegirCategoriaLisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_elegirCategoriaLisActionPerformed

    /**
     * Metodo que actualiza la tabla que muestra los datos de las estadisticas cada vez que se pulsa el boton Mostrar
     * de la interfaz, despues de borrar los datos anteriones de  la tabla comprueba que se haya elegido una categoria 
     * y una temporada de cada respectivo  combo y si no es asi muestra un mensaje indicando que se elija una categoria
     * y una temporada. Una vez elegida la categoria y la temporada se llama al metodo actualizaTablaEstadisticas() que
     * actualiza la tabla con los nuevos datos.
     * @param evt parametro de tipo java.awt.event.ActionEvent
     */
    private void botonMostrarClasificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMostrarClasificacionActionPerformed
        
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("Posicion");
        dtm.addColumn("Nombre equipo");
        dtm.addColumn("Partidos jugados");
        dtm.addColumn("Partidos ganados");
        dtm.addColumn("Partidos perdidos");
        dtm.addColumn("Puntos a favor");
        dtm.addColumn("Puntos en contra");
        tablaEstadisticasClasificacion.setModel(dtm);
   
        if (elegirTemporadaLis.getSelectedItem().equals(" ") || elegirCategoriaLis.getSelectedItem().equals(" ")) {
            JOptionPane.showMessageDialog(null, "Seleccione temporada y categoria para ver clasificacion");
        } else {
            try {
                actualizaTablaClasificacion();
            } catch (SQLException ex) {
                Logger.getLogger(EstadisticasTemporada.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_botonMostrarClasificacionActionPerformed

    /**
     * Metodo que al pulsar el boton para ver las graficas de las estadisticas de la clasificacion comprueba que al menos se haya seleccionado un grupo de datos
     * para mostrar la grafica, mientras no sea asi mostrara un mensaje indicando que se seleccione uno o varios grupos de datos. Seguidamente hace una 
     * llamada a actualizaGraficas() donde se van a introducir los datos de la grafica en Datos y por ultimo se crea una nueva ventana que muestra la grafica.
     * @param evt parametro de tipo java.awt.event.ActionEvent
     */
    private void mostrarGraficasLigaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrarGraficasLigaActionPerformed
       
        if(!estadisticasPartidosJugados.isSelected() && !estadisticasPartidosGanados.isSelected()&& !estadisticasPartidosPerdidos.isSelected()
         && !estadisticasPuntosContra.isSelected() && !estadisticasPuntosFavor.isSelected())
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
    }//GEN-LAST:event_mostrarGraficasLigaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ClasificacionLiga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClasificacionLiga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClasificacionLiga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClasificacionLiga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ClasificacionLiga().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonMostrarClasificacion;
    private javax.swing.JToggleButton botonSalir;
    private javax.swing.JLabel clasificacionLab;
    private javax.swing.JLabel elegirCategoriaLab;
    private javax.swing.JComboBox elegirCategoriaLis;
    private javax.swing.JComboBox elegirTemporadaLis;
    private javax.swing.JCheckBox estadisticasPartidosGanados;
    private javax.swing.JCheckBox estadisticasPartidosJugados;
    private javax.swing.JCheckBox estadisticasPartidosPerdidos;
    private javax.swing.JCheckBox estadisticasPuntosContra;
    private javax.swing.JCheckBox estadisticasPuntosFavor;
    private javax.swing.JButton mostrarGraficasLiga;
    private javax.swing.JScrollPane panelTabClasificacion;
    private javax.swing.JTable tablaEstadisticasClasificacion;
    // End of variables declaration//GEN-END:variables

}
