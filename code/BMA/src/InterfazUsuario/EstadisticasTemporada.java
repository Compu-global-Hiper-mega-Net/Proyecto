
package InterfazUsuario;

import GestionDeTemporadas.GestorTemporadas;
import ServiciosAlmacenamiento.BaseDatos;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Javier
 */

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

public class EstadisticasTemporada extends javax.swing.JFrame {
    
    BaseDatos accesoBD;
    ResultSet retset;
    String temporadaElegida;

    public EstadisticasTemporada() {
        initComponents();
    }
    
    
    public EstadisticasTemporada(BaseDatos acceso, String tempElegida) {
        
        initComponents();
        accesoBD = acceso;
        temporadaElegida = tempElegida;
        temporadaElegidaTexto.setText(temporadaElegida);
        try { 
            actualizaComboCategoria();
        } catch (SQLException ex) {
            Logger.getLogger(EstadisticasTemporada.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    private  void actualizaTablaEstadisticas() throws SQLException {
        
        int idTemp = 0, idCate = 0;
        
        String consulta = "SELECT idTemporada FROM mydb.temporada WHERE curso='"+temporadaElegida+"';";
        ResultSet res1 = accesoBD.ejecutaConsulta(consulta);
        if(res1.next()) 
            idTemp = res1.getInt(1);
    
        consulta = "SELECT idCategoria FROM mydb.categoria WHERE tipo='"+elegirCategoriaLista.getSelectedItem().toString()+"';";
        ResultSet res2 = accesoBD.ejecutaConsulta(consulta);
        if(res2.next()) 
            idCate = res2.getInt(1);
                
        //retset = GestorTemporadas.consultarEstadisticasTemporada(accesoBD, idTemp, idCate);
      
        if(retset == null)
            System.out.println("La consulta final es vacia"); 

        else{ 
              DefaultTableModel dtm = new DefaultTableModel();
              dtm.addColumn("Equipo");
              dtm.addColumn("Entrenador");
              dtm.addColumn("Partidos ganados");
              dtm.addColumn("Partidos perdidos");
              dtm.addColumn("Total puntos liga");

              Object[] fila = new Object[6];

              while(retset.next()){

                  fila[0] = retset.getString(1);
                  
                  String entrenador = retset.getString(2)+" "+retset.getString(3)+" "+retset.getString(4);
                  fila[1] = entrenador;
                  
                  String consulta3 = "SELECT COUNT(*) FROM partido p, equipo e WHERE (resultadoLocal > resultadoVisitante)" +
                             "AND p.idEquipo=e.idEquipo AND e.nombre='"+(String) fila[0]+"'";     System.out.printf(consulta3);
                  ResultSet res3 = accesoBD.ejecutaConsulta(consulta3);
                  if(res3.next())
                        fila[2] = res3.getString(1);
                  
                  String consulta4 = "SELECT COUNT(*) FROM partido p, equipo e WHERE (resultadoLocal < resultadoVisitante)" +
                             "AND p.idEquipo=e.idEquipo AND e.nombre='"+(String) fila[0]+"'";         System.out.printf(consulta4);
                  ResultSet res4 = accesoBD.ejecutaConsulta(consulta4);
                  if(res4.next())
                        fila[3] = res4.getString(1);
                  
                  fila[4] = retset.getString(5);

                  dtm.addRow(fila);
              }

              tablaTemporadaEstadisticas.setModel(dtm);
        }
    }
    
    
    
     private void actualizaComboCategoria() throws SQLException {
        elegirCategoriaLista.removeAllItems();
        elegirCategoriaLista.addItem(" ");

        String consulta = "SELECT DISTINCT tipo FROM categoria;";
        ResultSet res = accesoBD.ejecutaConsulta(consulta);
        while (res.next()) {
            elegirCategoriaLista.addItem(res.getString(1));
        }
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelTabEstTemp = new javax.swing.JScrollPane();
        tablaTemporadaEstadisticas = new javax.swing.JTable();
        botonSalir = new javax.swing.JToggleButton();
        temporadaLab = new javax.swing.JLabel();
        elegirCategoriaLab = new javax.swing.JLabel();
        elegirCategoriaLista = new javax.swing.JComboBox();
        botonMostrarEstadisticasTemporada = new javax.swing.JButton();
        temporadaElegidaTexto = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelTabEstTemp.setAutoscrolls(true);

        tablaTemporadaEstadisticas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tablaTemporadaEstadisticas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Equipo", "Entrenador ", "Partidos ganados", "Partidos perdidos", "Total  puntos  liga"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tablaTemporadaEstadisticas.setColumnSelectionAllowed(true);
        panelTabEstTemp.setViewportView(tablaTemporadaEstadisticas);
        tablaTemporadaEstadisticas.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        botonSalir.setText("Salir");
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });

        temporadaLab.setText("Temporada:");

        elegirCategoriaLab.setText("Elegir categoría:");

        elegirCategoriaLista.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        elegirCategoriaLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                elegirCategoriaListaActionPerformed(evt);
            }
        });

        botonMostrarEstadisticasTemporada.setText("Mostrar");
        botonMostrarEstadisticasTemporada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMostrarEstadisticasTemporadaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(temporadaLab)
                        .addGap(18, 18, 18)
                        .addComponent(temporadaElegidaTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(elegirCategoriaLab)
                        .addGap(18, 18, 18)
                        .addComponent(elegirCategoriaLista, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonMostrarEstadisticasTemporada))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(panelTabEstTemp, javax.swing.GroupLayout.PREFERRED_SIZE, 856, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(temporadaLab)
                    .addComponent(elegirCategoriaLab)
                    .addComponent(elegirCategoriaLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonMostrarEstadisticasTemporada)
                    .addComponent(temporadaElegidaTexto))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(panelTabEstTemp, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(81, 81, 81))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonSalir)
                        .addGap(32, 32, 32))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        
        this.setVisible(false);
    }//GEN-LAST:event_botonSalirActionPerformed

    private void elegirCategoriaListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_elegirCategoriaListaActionPerformed

    }//GEN-LAST:event_elegirCategoriaListaActionPerformed

    
    private void botonMostrarEstadisticasTemporadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMostrarEstadisticasTemporadaActionPerformed
      
        if(elegirCategoriaLista.getSelectedItem().equals(" "))
            JOptionPane.showMessageDialog(null,"Seleccione una categoria para ver estadisticas");
        else
            try {
            actualizaTablaEstadisticas();
        } catch (SQLException ex) {
            Logger.getLogger(EstadisticasTemporada.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_botonMostrarEstadisticasTemporadaActionPerformed

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
            java.util.logging.Logger.getLogger(EstadisticasTemporada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EstadisticasTemporada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EstadisticasTemporada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EstadisticasTemporada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new EstadisticasTemporada().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonMostrarEstadisticasTemporada;
    private javax.swing.JToggleButton botonSalir;
    private javax.swing.JLabel elegirCategoriaLab;
    private javax.swing.JComboBox elegirCategoriaLista;
    private javax.swing.JScrollPane panelTabEstTemp;
    private javax.swing.JTable tablaTemporadaEstadisticas;
    private javax.swing.JLabel temporadaElegidaTexto;
    private javax.swing.JLabel temporadaLab;
    // End of variables declaration//GEN-END:variables
}
