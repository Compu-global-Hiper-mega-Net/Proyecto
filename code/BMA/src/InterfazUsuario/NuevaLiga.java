/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfazUsuario;

import GestionDeCategorias.GestorCategorias;
import GestionDeLigas.GestorLigas;
import GestionDeTemporadas.GestorTemporadas;
import ServiciosAlmacenamiento.BaseDatos;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Julio
 */
public class NuevaLiga extends javax.swing.JFrame {
    
    private PrincipalLiga principal;
    private BaseDatos accesoBD;

    /**
     * Creates new form NuevaLiga
     */
    public NuevaLiga() {
        initComponents();
    }
    public NuevaLiga(BaseDatos acceso, PrincipalLiga p) throws SQLException {  
        initComponents();
        accesoBD = acceso;
        principal = p;
        
        List<String> temporadas = new ArrayList<>();
        temporadas = principal.getListaTemps();
        actualizaComboTemporada(temporadas);
        
        List<List<String>> categorias = new ArrayList<>();
        categorias = principal.getListaCategorias();
        actualizaComboCategoria(categorias);
                
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nuevaLigaLabel = new javax.swing.JLabel();
        nombreLabel = new javax.swing.JLabel();
        categoriaLabel = new javax.swing.JLabel();
        temporadaLabel = new javax.swing.JLabel();
        nombreText = new javax.swing.JTextField();
        comboCategoria = new javax.swing.JComboBox();
        comboTemporada = new javax.swing.JComboBox();
        botonGuardar = new javax.swing.JButton();
        botonCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        nuevaLigaLabel.setText("Crear Liga");

        nombreLabel.setText("Nombre:");

        categoriaLabel.setText("Categoria: ");

        temporadaLabel.setText("Temporada: ");

        comboCategoria.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        comboTemporada.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        botonGuardar.setText("Guardar");
        botonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarActionPerformed(evt);
            }
        });

        botonCancelar.setText("Cancelar");
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nuevaLigaLabel)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(botonGuardar)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(categoriaLabel)
                                    .addComponent(temporadaLabel)
                                    .addComponent(nombreLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(nombreText)
                                    .addComponent(comboCategoria, 0, 160, Short.MAX_VALUE)
                                    .addComponent(comboTemporada, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonCancelar)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nuevaLigaLabel)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreLabel)
                    .addComponent(nombreText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(categoriaLabel)
                    .addComponent(comboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(temporadaLabel)
                    .addComponent(comboTemporada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonGuardar)
                    .addComponent(botonCancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_botonCancelarActionPerformed

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
        // TODO add your handling code here:
        String mensajeError = "ERROR: Se han encontrado los siguientes errores: \n";
        boolean error = false;        
        /*
         * Comprobacion de errores
         */
        if(nombreText.getText().length() < 1){
            error = true;
            mensajeError += "-No se ha introducido Nombre\n";
        }
        if(comboTemporada.getSelectedItem() == "-Temporada-"){
            error = true;
            mensajeError += "-No se ha introducido Temporada\n";
        }
        if(comboCategoria.getSelectedItem() == "-Categoria-"){
            error = true;
            mensajeError += "-No se ha introducido Categoria\n";
        }
        /*
         * Fin de la comprobacion de errores
         */
        
        if(!error){
            try {
                boolean exito = GestorLigas.introducirLiga(accesoBD, 
                        GestorCategorias.getIdCategoria(accesoBD,comboCategoria.getSelectedItem().toString()), 
                        GestorTemporadas.getIdTemporada(accesoBD, comboTemporada.getSelectedItem().toString()),
                        nombreText.getText());
                if(exito){
                    JOptionPane.showMessageDialog(null, "Liga creada con exito", "Confirmacion", JOptionPane.INFORMATION_MESSAGE);
                    this.setVisible(false);
                    this.dispose();
                } else{
                    JOptionPane.showMessageDialog(null, "Ha habido un error en la base de datos",
                        "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException ex) {
                Logger.getLogger(NuevaLiga.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else{
            JOptionPane.showMessageDialog(this, mensajeError, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_botonGuardarActionPerformed

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
            java.util.logging.Logger.getLogger(NuevaLiga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NuevaLiga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NuevaLiga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NuevaLiga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NuevaLiga().setVisible(true);
            }
        });
    }
    
    private void actualizaComboTemporada(List<String> temps) throws SQLException {
        comboTemporada.removeAllItems();
        comboTemporada.addItem("-Temporada-");
        for(String s : temps)
            comboTemporada.addItem(s);
        
    }
    
    private void actualizaComboCategoria(List<List<String>> cats) throws SQLException {
        comboCategoria.removeAllItems();
        comboCategoria.addItem("-Categoria-");
        for(List<String> s : cats){
            comboCategoria.addItem(s.get(0));
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCancelar;
    private javax.swing.JButton botonGuardar;
    private javax.swing.JLabel categoriaLabel;
    private javax.swing.JComboBox comboCategoria;
    private javax.swing.JComboBox comboTemporada;
    private javax.swing.JLabel nombreLabel;
    private javax.swing.JTextField nombreText;
    private javax.swing.JLabel nuevaLigaLabel;
    private javax.swing.JLabel temporadaLabel;
    // End of variables declaration//GEN-END:variables
}