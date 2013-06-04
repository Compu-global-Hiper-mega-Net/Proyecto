
package InterfazUsuario;


import ServiciosAlmacenamiento.BaseDatos;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Javier
 */
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

public class ClasificacionLiga extends javax.swing.JFrame {
    
    BaseDatos accesoBD;
    ResultSet retset;
    String temporadaElegida;
    String categoriaElegida;

    public ClasificacionLiga() {
        initComponents();
    }
    
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
    
    private void actualizaTablaClasificacion() throws SQLException {

        int idTemp = 0, idCate = 0;

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

                fila[0] = retset.getString(1);

                String entrenador = retset.getString(2) + " " + retset.getString(3) + " " + retset.getString(4);
                fila[1] = entrenador;

                String consulta3 = "SELECT COUNT(*) FROM partido p, equipo e WHERE (resultadoLocal > resultadoVisitante)"
                        + "AND p.idEquipo=e.idEquipo AND e.nombre='" + (String) fila[0] + "'";
                System.out.printf(consulta3);
                ResultSet res3 = accesoBD.ejecutaConsulta(consulta3);
                if (res3.next()) {
                    fila[2] = res3.getString(1);
                }

                String consulta4 = "SELECT COUNT(*) FROM partido p, equipo e WHERE (resultadoLocal < resultadoVisitante)"
                        + "AND p.idEquipo=e.idEquipo AND e.nombre='" + (String) fila[0] + "'";
                System.out.printf(consulta4);
                ResultSet res4 = accesoBD.ejecutaConsulta(consulta4);
                if (res4.next()) {
                    fila[3] = res4.getString(1);
                }

                fila[4] = retset.getString(5);

                dtm.addRow(fila);
            }

            tablaClasificacion.setModel(dtm);
        }
    }
    
    private void actualizaComboTemporada() throws SQLException {
        elegirTemporadaLis.removeAllItems();
        elegirTemporadaLis.addItem(" ");

        String consulta = "SELECT DISTINCT curso FROM temporada;";
        ResultSet res = accesoBD.ejecutaConsulta(consulta);
        while (res.next()) {
            elegirTemporadaLis.addItem(res.getString(1));
        }
    }

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
        tablaClasificacion = new javax.swing.JTable();
        elegirTemporadaLis = new javax.swing.JComboBox();
        botonMostrarClasificacion = new javax.swing.JButton();

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

        tablaClasificacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tablaClasificacion.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaClasificacion.setColumnSelectionAllowed(true);
        panelTabClasificacion.setViewportView(tablaClasificacion);
        tablaClasificacion.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tablaClasificacion.getColumnModel().getColumn(6).setResizable(false);

        elegirTemporadaLis.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        botonMostrarClasificacion.setText("Mostrar");

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
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(panelTabClasificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 921, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
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
                .addComponent(panelTabClasificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(botonSalir)
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        
        this.setVisible(false);
    }//GEN-LAST:event_botonSalirActionPerformed

    private void elegirCategoriaLisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_elegirCategoriaLisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_elegirCategoriaLisActionPerformed

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
    private javax.swing.JScrollPane panelTabClasificacion;
    private javax.swing.JTable tablaClasificacion;
    // End of variables declaration//GEN-END:variables
}
