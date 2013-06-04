/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfazUsuario;

import GestionDePartidos.*;
import GestionDeTemporadas.*;
import GestionDeCategorias.*;
import GestionDeEquipos.*;
import GestionDeInstalaciones.*;
import ServiciosAlmacenamiento.BaseDatos;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.Color;
import java.sql.SQLException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.border.Border;


/**
 *
 * @author Julio
 */
public class NuevoPartido extends javax.swing.JFrame {
    BaseDatos accesoBD;
    private Border bordeError;
    private Border bordeDatePicker;
    PantallaPrincipal principal;
    Object equipoAnterior1, equipoAnterior2;
    int idCat, idTemp;
    boolean noEntry; //Variable que impide el paso a los ItemStateChanged mientras se actualizan los ComboBox

    /**
     * Creates new form NuevoPartido
     */
    public NuevoPartido() {
        initComponents();
        bordeError = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.red);
    }
    
    public NuevoPartido(BaseDatos acceso, PantallaPrincipal p) throws SQLException {
        accesoBD = acceso;
        initComponents();
        principal = p;
        bordeError = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.red);
        noEntry = true;
        ((JTextFieldDateEditor) fechaPartido.getComponents()[1]).setEditable(false);
        
        List<String> temporadas = new ArrayList<String>();
        temporadas = principal.getListaTemps();
        actualizaComboTemporada(temporadas);
        
        List<List<String>> categorias = new ArrayList<List<String>>();
        categorias = principal.getListaCategorias();
        actualizaComboCategoria(categorias);  
        
        List<String> instalaciones = new ArrayList<String>();
        instalaciones = principal.getListaInstalaciones(null);
        actualizaComboInstalacion(instalaciones);
        
        idCat = idTemp = 0;
        List<String> equipos = new ArrayList<String>();
        equipos = principal.getListaEquipos(idCat,idTemp);
        actualizaComboEquipo(equipos, 1);
        actualizaComboEquipo(equipos, 2);
        equipoAnterior1 = "";
        equipoAnterior2 = "";
        
        noEntry = false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CrearPartidoLabel = new javax.swing.JLabel();
        TemporadaLabel = new javax.swing.JLabel();
        ComboTemporada = new javax.swing.JComboBox();
        CategoriaLabel = new javax.swing.JLabel();
        ComboCategoria = new javax.swing.JComboBox();
        EquipoLocalLabel = new javax.swing.JLabel();
        EquipoVisitanteLabel = new javax.swing.JLabel();
        ComboEquipo = new javax.swing.JComboBox();
        ComboEquipo2 = new javax.swing.JComboBox();
        fechaLabel = new javax.swing.JLabel();
        fechaPartido = new com.toedter.calendar.JDateChooser();
        horaLabel = new javax.swing.JLabel();
        textHora = new javax.swing.JTextField();
        lugarLabel = new javax.swing.JLabel();
        ComboInstalacion = new javax.swing.JComboBox();
        Cancelar = new javax.swing.JButton();
        Guardar = new javax.swing.JButton();
        textMin = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        CrearPartidoLabel.setText("Crear Partido");

        TemporadaLabel.setText("Temporada:");

        ComboTemporada.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ComboTemporada.setName(""); // NOI18N
        ComboTemporada.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ComboTemporadaItemStateChanged(evt);
            }
        });

        CategoriaLabel.setText("Categoría: ");

        ComboCategoria.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ComboCategoria.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ComboCategoriaItemStateChanged(evt);
            }
        });

        EquipoLocalLabel.setText("Equipo Local: ");

        EquipoVisitanteLabel.setText("Equipo Visitante: ");

        ComboEquipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ComboEquipo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ComboEquipoItemStateChanged(evt);
            }
        });

        ComboEquipo2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ComboEquipo2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ComboEquipo2ItemStateChanged(evt);
            }
        });

        fechaLabel.setText("Fecha: ");

        fechaPartido.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                fechaPartidoFocusLost(evt);
            }
        });

        horaLabel.setText("Hora (hh:mm) ");

        textHora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textHoraActionPerformed(evt);
            }
        });

        lugarLabel.setText("Lugar: ");

        Cancelar.setText("Cancelar");
        Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarActionPerformed(evt);
            }
        });

        Guardar.setText("Guardar");
        Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarActionPerformed(evt);
            }
        });

        jLabel1.setText(":");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Guardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Cancelar)
                .addGap(31, 31, 31))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(EquipoVisitanteLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ComboEquipo2, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                        .addComponent(textHora, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(CrearPartidoLabel)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(lugarLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ComboInstalacion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(fechaLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fechaPartido, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(horaLabel))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(EquipoLocalLabel)
                                    .addGap(21, 21, 21)
                                    .addComponent(ComboEquipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(TemporadaLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(ComboTemporada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(34, 34, 34)
                                    .addComponent(CategoriaLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(ComboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textMin, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(horaLabel)
                        .addComponent(textMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(textHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(CrearPartidoLabel)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TemporadaLabel)
                            .addComponent(ComboTemporada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CategoriaLabel)
                            .addComponent(ComboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(EquipoLocalLabel)
                            .addComponent(ComboEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(EquipoVisitanteLabel)
                            .addComponent(ComboEquipo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(fechaLabel)
                            .addComponent(fechaPartido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lugarLabel)
                    .addComponent(ComboInstalacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Cancelar)
                    .addComponent(Guardar))
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
                                     

    private void fechaPartidoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fechaPartidoFocusLost
        Date dateFromDateChooser = fechaPartido.getDate();
        String dateString = String.format("%1$tY-%1$tm-%1$td", dateFromDateChooser);
        if (dateString.equals("null-null-null")) {
            fechaPartido.setBorder(bordeError);
        } else {
            fechaPartido.setBorder(bordeDatePicker);
        }
    }//GEN-LAST:event_fechaPartidoFocusLost

    private void textHoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textHoraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textHoraActionPerformed

    private void GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarActionPerformed
        // TODO add your handling code here:
        String mensajeError = "ERROR: Se han encontrado los siguientes errores: \n";
        boolean error = false;
        /*
         * Comprobacion de errores
         */
        if(ComboTemporada.getSelectedItem() == "-Temporada-"){
            error = true;
            mensajeError += "-No se ha introducido Temporada\n";
        }
        if(ComboCategoria.getSelectedItem() == "-Categoria-"){
            error = true;
            mensajeError += "-No se ha introducido Categoria\n";
        }
        if(ComboEquipo.getSelectedItem() == "-Equipo Local-"){
            error = true;
            mensajeError += "-No se ha introducido Equipo Local\n";
        }
        if(ComboEquipo2.getSelectedItem() == "-Equipo Visitante-"){
            error = true;
            mensajeError += "-No se ha introducido Equipo Visitante\n";
        }        
        if(fechaPartido.equals(null)){
            error = true;
            mensajeError += "-No se ha introducido Fecha\n";
        }
        if(textHora.getText().length() != 2 || textMin.getText().length() != 2 || Integer.parseInt(textHora.getText()) > 24 
           || Integer.parseInt(textHora.getText()) < 0 || Integer.parseInt(textMin.getText()) > 59 || Integer.parseInt(textMin.getText()) < 0){
            error = true;
            mensajeError += "-Error en los campos de la hora\n";
        }
        if(ComboInstalacion.getSelectedItem() == "-Instalacion-"){
            error = true;
            mensajeError += "-No se ha introducido Instalación\n";
        }
        /*
         * Fin Comprobacion de Errores
         */
        
        if(!error){            
                /*Revisar esta insercion por:
                 * idFundacion, idLiga, etc
                 */
            java.sql.Date sqlDate = new java.sql.Date(fechaPartido.getDate().getTime());
            try {
                boolean exito = GestorPartidos.introducirPartido(accesoBD, GestorEquipos.getIdEquipo(accesoBD,ComboEquipo.getSelectedItem().toString(),ComboCategoria.getSelectedItem().toString()), 1,
                                GestorCategorias.getIdCategoria(accesoBD, ComboCategoria.getSelectedItem().toString()), GestorTemporadas.getIdTemporada(accesoBD, ComboTemporada.getSelectedItem().toString()), 1, 
                                GestorEquipos.getIdEquipo(accesoBD,ComboEquipo2.getSelectedItem().toString(),ComboCategoria.getSelectedItem().toString()), 1, 
                                GestorCategorias.getIdCategoria(accesoBD, ComboCategoria.getSelectedItem().toString()), GestorTemporadas.getIdTemporada(accesoBD, ComboTemporada.getSelectedItem().toString()), 1, 
                                sqlDate, convierteHoraTime(textHora.getText(), textMin.getText()), 0, 0);
                if(exito){
                    JOptionPane.showMessageDialog(null, "Partido creado con exito", "Confirmacion", JOptionPane.INFORMATION_MESSAGE);
                    this.setVisible(false);
                    this.dispose();
                } else{
                    JOptionPane.showMessageDialog(null, "Ha habido un error en la base de datos",
                        "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException ex) {
                Logger.getLogger(NuevoPartido.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            this.setVisible(false);
        } else{
            JOptionPane.showMessageDialog(this, mensajeError, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_GuardarActionPerformed

    private void CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_CancelarActionPerformed

    private void ComboEquipoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ComboEquipoItemStateChanged
        // TODO add your handling code here:
        if(!noEntry){
            if(ComboEquipo.getSelectedItem() != "-Equipo Local-"){
                if(equipoAnterior1 == ""){
                    equipoAnterior1 = ComboEquipo.getSelectedItem();
                    ComboEquipo2.removeItem(equipoAnterior1);

                }else {
                    ComboEquipo2.addItem(equipoAnterior1);
                    equipoAnterior1 = ComboEquipo.getSelectedItem();
                    ComboEquipo2.removeItem(equipoAnterior1); 
                }
            } else{
                if(equipoAnterior1 != ""){
                    ComboEquipo2.addItem(equipoAnterior1);
                    equipoAnterior1 = "";
                }
            }
        }
    }//GEN-LAST:event_ComboEquipoItemStateChanged

    private void ComboEquipo2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ComboEquipo2ItemStateChanged
        // TODO add your handling code here:
        if(!noEntry){
            if(ComboEquipo2.getSelectedItem() != "-Equipo Visitante-"){
                if(equipoAnterior2 == ""){
                    equipoAnterior2 = ComboEquipo2.getSelectedItem();
                    ComboEquipo.removeItem(equipoAnterior2);

                }else {
                    ComboEquipo.addItem(equipoAnterior2);
                    equipoAnterior2 = ComboEquipo2.getSelectedItem();
                    ComboEquipo.removeItem(equipoAnterior2); 
                }
            } else{
                if(equipoAnterior2 != ""){
                    ComboEquipo.addItem(equipoAnterior2);
                    equipoAnterior2 = "";
                }
            }
        }
    }//GEN-LAST:event_ComboEquipo2ItemStateChanged

    private void ComboTemporadaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ComboTemporadaItemStateChanged
        // TODO add your handling code here:
        
        if(!noEntry){
            if(ComboTemporada.getSelectedItem() != "-Temporada-"){
                try {            
                    idTemp = GestorTemporadas.getIdTemporada(accesoBD, ComboTemporada.getSelectedItem().toString());
                } catch (SQLException ex) {
                   Logger.getLogger(NuevoPartido.class.getName()).log(Level.SEVERE, null, ex);
                }
                List<String> equipos = new ArrayList<String>();
                try {
                    noEntry = true;
                    equipos = principal.getListaEquipos(idCat,idTemp);
                    actualizaComboEquipo(equipos, 1);
                    actualizaComboEquipo(equipos, 2);
                    noEntry = false;
                } catch (SQLException ex) {
                    Logger.getLogger(NuevoPartido.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else{
                idTemp = 0;
                List<String> equipos = new ArrayList<String>();
                try {
                    noEntry = true;
                    equipos = principal.getListaEquipos(idCat,idTemp);
                    actualizaComboEquipo(equipos, 1);
                    actualizaComboEquipo(equipos, 2);
                    noEntry = false;
                } catch (SQLException ex) {
                    Logger.getLogger(NuevoPartido.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                equipoAnterior1 = "";
                equipoAnterior2 = "";   
        }
    }//GEN-LAST:event_ComboTemporadaItemStateChanged

    private void ComboCategoriaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ComboCategoriaItemStateChanged
        // TODO add your handling code here:
        if(!noEntry){
            if(ComboCategoria.getSelectedItem() != "-Categoria-"){
                try {            
                    idCat = GestorCategorias.getIdCategoria(accesoBD, ComboCategoria.getSelectedItem().toString());
                } catch (SQLException ex) {
                    Logger.getLogger(NuevoPartido.class.getName()).log(Level.SEVERE, null, ex);
                }
                List<String> equipos = new ArrayList<String>();
                try {
                    noEntry = true;
                    equipos = principal.getListaEquipos(idCat,idTemp);
                    actualizaComboEquipo(equipos, 1);
                    actualizaComboEquipo(equipos, 2);
                    noEntry = false;
                } catch (SQLException ex) {
                    Logger.getLogger(NuevoPartido.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else{
                idCat = 0;
                List<String> equipos = new ArrayList<String>();
                try {
                    noEntry = true;
                    equipos = principal.getListaEquipos(idCat,idTemp);
                    actualizaComboEquipo(equipos, 1);
                    actualizaComboEquipo(equipos, 2);
                    noEntry = false;
                } catch (SQLException ex) {
                    Logger.getLogger(NuevoPartido.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                equipoAnterior1 = "";
                equipoAnterior2 = "";
        }
    }//GEN-LAST:event_ComboCategoriaItemStateChanged

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
            java.util.logging.Logger.getLogger(NuevoPartido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NuevoPartido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NuevoPartido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NuevoPartido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NuevoPartido().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cancelar;
    private javax.swing.JLabel CategoriaLabel;
    private javax.swing.JComboBox ComboCategoria;
    private javax.swing.JComboBox ComboEquipo;
    private javax.swing.JComboBox ComboEquipo2;
    private javax.swing.JComboBox ComboInstalacion;
    private javax.swing.JComboBox ComboTemporada;
    private javax.swing.JLabel CrearPartidoLabel;
    private javax.swing.JLabel EquipoLocalLabel;
    private javax.swing.JLabel EquipoVisitanteLabel;
    private javax.swing.JButton Guardar;
    private javax.swing.JLabel TemporadaLabel;
    private javax.swing.JLabel fechaLabel;
    private com.toedter.calendar.JDateChooser fechaPartido;
    private javax.swing.JLabel horaLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lugarLabel;
    private javax.swing.JTextField textHora;
    private javax.swing.JTextField textMin;
    // End of variables declaration//GEN-END:variables
    private void actualizaComboTemporada(List<String> temps) throws SQLException {
        ComboTemporada.removeAllItems();
        ComboTemporada.addItem("-Temporada-");
        for(String s : temps)
            ComboTemporada.addItem(s);
        
    }
    
    private void actualizaComboCategoria(List<List<String>> cats) throws SQLException {
        ComboCategoria.removeAllItems();
        ComboCategoria.addItem("-Categoria-");
        for(List<String> s : cats)
            ComboCategoria.addItem(s.get(0));        
    }
    
    private void actualizaComboInstalacion(List<String> insts) throws SQLException {
        ComboInstalacion.removeAllItems();
        ComboInstalacion.addItem("-Instalacion-");
        for(String s : insts)
            ComboInstalacion.addItem(s);
    }
    
    private void actualizaComboEquipo(List<String> equipos, int numEquipo) throws SQLException {
        if(numEquipo == 1){
            ComboEquipo.removeAllItems();
            ComboEquipo.addItem("-Equipo Local-");
            for(String s : equipos)
                ComboEquipo.addItem(s);
        } else{
            ComboEquipo2.removeAllItems();
            ComboEquipo2.addItem("-Equipo Visitante-");
            for(String s : equipos)
                ComboEquipo2.addItem(s);
        }
    }
    
    private Time convierteHoraTime(String h, String m){
        String hora = h+":"+m;
        java.sql.Time horaDate = null;
        
        try{
            SimpleDateFormat sdf = new java.text.SimpleDateFormat("hh:mm", new Locale("es","ES"));
            horaDate = new java.sql.Time(sdf.parse(hora).getTime());
            
        } catch(Exception e){
            System.out.println("Error al obtener el formato de la hora: " + e.getMessage());
        }
        
        return horaDate;
    }
}
