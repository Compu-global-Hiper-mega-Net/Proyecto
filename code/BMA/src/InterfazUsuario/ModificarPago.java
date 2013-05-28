/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ModificarPago.java
 *
 * Created on 28-may-2013, 18:54:53
 */
package InterfazUsuario;
import GestionDePagos.GestorPagos;
import ServiciosAlmacenamiento.BaseDatos;
import javax.swing.*;
/**
 *
 * @author Francisco
 */
public class ModificarPago extends javax.swing.JFrame {
    BaseDatos accesoBD=new BaseDatos();
    int idCuota;
    /** Creates new form ModificarPago */
    public ModificarPago() {
        initComponents();
    }
    public ModificarPago(BaseDatos acceso, int idcuota, String  nombre, String primerApellido, String segundoApellido, String curso, String fecha, boolean pagado) {

        accesoBD = acceso;
        initComponents();
        jLabel1.setText("Alumno: "+nombre+" "+primerApellido+" "+segundoApellido);
        jLabel2.setText("Temporada: "+curso);
        jLabel3.setText("Fecha del Pago: "+fecha);
        jLabel4.setVisible(false);
        idCuota=idcuota;
        botonPagado.setSelected(pagado);
    }
    public ModificarPago(BaseDatos acceso, int idcuota, String  nombre, String primerApellido, String segundoApellido, String curso, String fecha, 
             boolean pagado, String actividad) {

        accesoBD = acceso;
        initComponents();
        jLabel1.setText("Alumno: "+nombre+" "+primerApellido+" "+segundoApellido);
        jLabel2.setText("Temporada: "+curso);
        jLabel3.setText("Fecha del Pago: "+fecha);
        jLabel4.setVisible(true);
        jLabel4.setText("Actividad: "+actividad);
        idCuota=idcuota;
        botonPagado.setSelected(pagado);
    }    
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botonPagado = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        botonGuardarCambiosPago = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        botonPagado.setText("Pagado");
        botonPagado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonPagadoActionPerformed(evt);
            }
        });

        jLabel1.setText("Alumno: ");

        jLabel2.setText("Temporada:");

        jLabel3.setText("Fecha del Pago:");

        jLabel4.setText("Actividad:");

        botonGuardarCambiosPago.setText("Guardar Cambios");
        botonGuardarCambiosPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarCambiosPagoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botonPagado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 131, Short.MAX_VALUE)
                        .addComponent(botonGuardarCambiosPago)
                        .addGap(57, 57, 57))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addContainerGap(287, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addGap(26, 26, 26)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonPagado)
                    .addComponent(botonGuardarCambiosPago))
                .addGap(75, 75, 75))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void botonPagadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonPagadoActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_botonPagadoActionPerformed

private void botonGuardarCambiosPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarCambiosPagoActionPerformed
    boolean pagado;
    pagado=botonPagado.isSelected();

    GestorPagos.modificarCuota(accesoBD, idCuota, pagado);
    JOptionPane.showMessageDialog(null, "Cambios Guardados con Exito", "Confirmacion", JOptionPane.INFORMATION_MESSAGE);
    this.dispose();
}//GEN-LAST:event_botonGuardarCambiosPagoActionPerformed

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
            java.util.logging.Logger.getLogger(ModificarPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModificarPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModificarPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModificarPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new ModificarPago().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonGuardarCambiosPago;
    private javax.swing.JCheckBox botonPagado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
