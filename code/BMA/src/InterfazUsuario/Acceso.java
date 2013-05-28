/*
 * InterfazAcceso.java
 *
 * Created on 15-mar-2013, 16:22:20
 */
package InterfazUsuario;
import GestionDeUsuarios.*;
import ServiciosAlmacenamiento.BaseDatos;
import java.awt.event.KeyEvent;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 * Interfaz de acceso
 * @author Francisco
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

public class Acceso extends javax.swing.JFrame {
    Connection conexion;   
    Statement stmt;      
    ResultSet retset;
    
    /** Creates new form InterfazAcceso */
    public Acceso() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        userTextfield = new javax.swing.JTextField();
        userLabel = new javax.swing.JLabel();
        passLabel = new javax.swing.JLabel();
        authenticateButton = new javax.swing.JButton();
        passTextfield = new javax.swing.JPasswordField();
        titleLabel2 = new javax.swing.JLabel();
        titleLabel1 = new javax.swing.JLabel();

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        userTextfield.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                userTextfieldKeyReleased(evt);
            }
        });

        userLabel.setText("Usuario:");

        passLabel.setText("Contraseña:");

        authenticateButton.setText("Entrar");
        authenticateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                authenticateButtonActionPerformed(evt);
            }
        });

        passTextfield.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                passTextfieldKeyReleased(evt);
            }
        });

        titleLabel2.setFont(new java.awt.Font("Tahoma", 2, 28)); // NOI18N
        titleLabel2.setText("Application");

        titleLabel1.setFont(new java.awt.Font("Tahoma", 2, 28)); // NOI18N
        titleLabel1.setText("Basketball Management");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(userLabel)
                    .addComponent(passLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(authenticateButton)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(passTextfield, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(userTextfield, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(103, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(136, Short.MAX_VALUE)
                .addComponent(titleLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(127, 127, 127))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(63, Short.MAX_VALUE)
                    .addComponent(titleLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(37, 37, 37)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(70, Short.MAX_VALUE)
                .addComponent(titleLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userLabel)
                    .addComponent(userTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passLabel)
                    .addComponent(passTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(authenticateButton)
                .addGap(59, 59, 59))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(30, 30, 30)
                    .addComponent(titleLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(236, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void authenticateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_authenticateButtonActionPerformed
    BaseDatos accesoBD = new BaseDatos();
    
    String usuario = userTextfield.getText();
    char[] pass = passTextfield.getPassword();
    String consulta_acceso = "SELECT * FROM usuario WHERE user='"
            + usuario + "' AND clave='" + new String (pass) + "'";
    
    System.out.print("\npass "+consulta_acceso);
    retset = GestorUsuarios.consultarUsuario(accesoBD, consulta_acceso);
    try{
        if (retset.next()) {
           (new PantallaPrincipal(accesoBD, usuario)).setVisible(true);
            this.dispose();
        }else{          
            JOptionPane.showMessageDialog(null,
                    "Usuario o contraseña incorrectos", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
    catch(SQLException ex){
        System.out.print(ex.getMessage());
    }
}//GEN-LAST:event_authenticateButtonActionPerformed

    private void userTextfieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_userTextfieldKeyReleased
        // TODO add your handling code here:
         if(evt.getKeyCode() == evt.VK_ENTER){
            BaseDatos accesoBD = new BaseDatos();
            String usuario = userTextfield.getText();
            char[] pass = passTextfield.getPassword();
            String consulta_acceso = "SELECT * FROM usuario WHERE user='"
                    + usuario + "' AND clave='" + new String (pass) + "'";

            System.out.print("\npass "+consulta_acceso);
            retset = GestorUsuarios.consultarUsuario(accesoBD, consulta_acceso);
            try{
                if (retset.next()) {
                   (new PantallaPrincipal(accesoBD, usuario)).setVisible(true);
                    this.dispose();
                }else{          
                    JOptionPane.showMessageDialog(null,
                            "Usuario o contraseña incorrectos", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
            catch(SQLException ex){
                System.out.print(ex.getMessage());
            }
        }
    }//GEN-LAST:event_userTextfieldKeyReleased

    private void passTextfieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passTextfieldKeyReleased
        // TODO add your handling code here:
         if(evt.getKeyCode() == evt.VK_ENTER){
            BaseDatos accesoBD = new BaseDatos();
            String usuario = userTextfield.getText();
            char[] pass = passTextfield.getPassword();
            String consulta_acceso = "SELECT * FROM usuario WHERE user='"
                    + usuario + "' AND clave='" + new String (pass) + "'";

            System.out.print("\npass "+consulta_acceso);
            retset = GestorUsuarios.consultarUsuario(accesoBD, consulta_acceso);
            try{
                if (retset.next()) {
                   (new PantallaPrincipal(accesoBD, usuario)).setVisible(true);
                    this.dispose();
                }else{          
                    JOptionPane.showMessageDialog(null,
                            "Usuario o contraseña incorrectos", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
            catch(SQLException ex){
                System.out.print(ex.getMessage());
            }
        }
    }//GEN-LAST:event_passTextfieldKeyReleased

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
            javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Acceso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Acceso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Acceso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Acceso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new Acceso().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton authenticateButton;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel passLabel;
    private javax.swing.JPasswordField passTextfield;
    private javax.swing.JLabel titleLabel1;
    private javax.swing.JLabel titleLabel2;
    private javax.swing.JLabel userLabel;
    private javax.swing.JTextField userTextfield;
    // End of variables declaration//GEN-END:variables
}