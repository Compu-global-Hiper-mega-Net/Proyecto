/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfazUsuario;

import GestionDeCategorias.GestorCategorias;
import GestionDeLigas.*;
import GestionDeTemporadas.GestorTemporadas;
import ServiciosAlmacenamiento.BaseDatos;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Julio
 */
public class PrincipalLiga extends javax.swing.JFrame {
    
    private BaseDatos accesoBD;
    private JFrame pL;

    /**
     * Creates new form PantallaLiga
     */
    public PrincipalLiga(JFrame pL, BaseDatos bd) {
        initComponents();
        this.setLocationRelativeTo(pL);
        this.accesoBD = bd;
        this.pL = pL;
        actualizaTablaLiga();
    }

    private PrincipalLiga() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LigasLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        botonNuevaLiga = new javax.swing.JButton();
        botonModificarLiga = new javax.swing.JButton();
        botonEliminarLiga = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaLigas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        LigasLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        LigasLabel.setText("Ligas");

        botonNuevaLiga.setText("Nueva Liga");
        botonNuevaLiga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonNuevaLigaActionPerformed(evt);
            }
        });

        botonModificarLiga.setText("Modificar Liga");
        botonModificarLiga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonModificarLigaActionPerformed(evt);
            }
        });

        botonEliminarLiga.setText("Eliminar Liga");
        botonEliminarLiga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarLigaActionPerformed(evt);
            }
        });

        tablaLigas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nombre", "Categoria", "Temporada"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaLigas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(botonNuevaLiga)
                        .addGap(30, 30, 30)
                        .addComponent(botonModificarLiga)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonEliminarLiga)))
                .addGap(18, 18, 18))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(LigasLabel)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LigasLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonNuevaLiga)
                    .addComponent(botonModificarLiga)
                    .addComponent(botonEliminarLiga))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonNuevaLigaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNuevaLigaActionPerformed
        // TODO add your handling code here:                                              
        try {
            new NuevaLiga(accesoBD, this).setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_botonNuevaLigaActionPerformed

    private void botonModificarLigaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonModificarLigaActionPerformed
        // TODO add your handling code here:        
        int idLiga = 0;

        int iTablaLiga = tablaLigas.getSelectedRow();
        
        if (iTablaLiga >= 0) {
            try {
                idLiga = GestorLigas.getIdLiga(accesoBD, 
                        tablaLigas.getValueAt(iTablaLiga, 0).toString(), 
                        GestorCategorias.getIdCategoria(accesoBD, tablaLigas.getValueAt(iTablaLiga, 1).toString()),
                        GestorTemporadas.getIdTemporada(accesoBD, tablaLigas.getValueAt(iTablaLiga, 2).toString()));
               
            } catch (SQLException ex) {
                Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {        
                    new ModificarLiga(accesoBD, 
                            tablaLigas.getValueAt(iTablaLiga, 0).toString(),
                            tablaLigas.getValueAt(iTablaLiga, 1).toString(),
                            tablaLigas.getValueAt(iTablaLiga, 2).toString(),
                            idLiga, this).setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (iTablaLiga == -1) {
            JOptionPane.showMessageDialog(this, "No se ha seleccionado ninguna liga", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_botonModificarLigaActionPerformed

    private void botonEliminarLigaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarLigaActionPerformed
        // TODO add your handling code here:        
        try {  
            int iTablaLiga = tablaLigas.getSelectedRow();
            if (iTablaLiga == -1) {
                JOptionPane.showMessageDialog(this, "Debes seleccionar una Liga", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                int idCatLig, idTempLig;
                String nomb;
                
                nomb = tablaLigas.getValueAt(iTablaLiga,0).toString();
                idCatLig = GestorCategorias.getIdCategoria(accesoBD, tablaLigas.getValueAt(iTablaLiga,1).toString());
                idTempLig = GestorTemporadas.getIdTemporada(accesoBD, tablaLigas.getValueAt(iTablaLiga,2).toString());
                
                Liga l = new Liga(nomb, idCatLig, idTempLig);

               int continuar = JOptionPane.showConfirmDialog(this, "¿Desea eliminar la Liga?", "Confirmar", JOptionPane.YES_NO_OPTION);
               if (continuar == JOptionPane.YES_OPTION) {
                   LigaBD.eliminarLigaBD(accesoBD, l);
                   actualizaTablaLiga();

               }
            }
        } catch (SQLException ex) {
            Logger.getLogger(PrincipalLiga.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_botonEliminarLigaActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        // TODO add your handling code here:
        actualizaTablaLiga();
    }//GEN-LAST:event_formWindowGainedFocus

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
            java.util.logging.Logger.getLogger(PrincipalLiga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrincipalLiga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrincipalLiga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrincipalLiga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //Create and display the form 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrincipalLiga().setVisible(true);
            }
        });
    }
    
    private void actualizaTablaLiga(){
        List<List<String>> lpar = new ArrayList<List<String>>();
        try {
            lpar = GestorLigas.getListaLigas(accesoBD);
        } catch (SQLException ex) {
            Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("Nombre");
        dtm.addColumn("Categoria");
        dtm.addColumn("Temporada");String aux;
        Object[] fila = new Object[3];
        for (List<String> it : lpar) {
            aux = it.get(0);
            try {
                fila[1] = getCategoria(aux.substring(0, aux.indexOf(",")));
            } catch (SQLException ex) {
                Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
            aux = aux.substring(aux.indexOf(",") + 1, aux.length());
            try {
                fila[2] = getTemporada(aux.substring(0, aux.indexOf(",")));
            } catch (SQLException ex) {
                Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
            aux = aux.substring(aux.indexOf(",") + 1, aux.length());
            fila[0] = aux;            
            dtm.addRow(fila);
        }

        tablaLigas.setModel(dtm);        
    }

    private String getCategoria(String s) throws SQLException {

        String cat = GestorCategorias.getCategoria(accesoBD, Integer.parseInt(s));
        return cat;
    }

    private String getTemporada(String s) throws SQLException {

        return GestorTemporadas.getTemporada(accesoBD, s);
    }
    
    List<String> getListaTemps() throws SQLException {
        return GestorTemporadas.getListaTemporadas(accesoBD);
    }
    
    List<List<String>> getListaCategorias() throws SQLException {
        List<List<String>> cats = new ArrayList<List<String>>();
        cats = GestorCategorias.getListaCategorias(accesoBD);
        return cats;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LigasLabel;
    private javax.swing.JButton botonEliminarLiga;
    private javax.swing.JButton botonModificarLiga;
    private javax.swing.JButton botonNuevaLiga;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tablaLigas;
    // End of variables declaration//GEN-END:variables
}
