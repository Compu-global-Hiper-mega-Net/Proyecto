/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfazUsuario;

import GestionDeCategorias.GestorCategorias;
import GestionDeEquipos.Equipo;
import GestionDeEquipos.GestorEquipos;
import GestionDeTemporadas.GestorTemporadas;
import GestionDeUsuarios.GestorUsuarios;
import ServiciosAlmacenamiento.BaseDatos;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dell
 */
public class PrincipalEquipos extends javax.swing.JFrame {
    private JFrame pP;
    private BaseDatos accesoBD;

    /**
     * Creates new form PrincipalPartidos
     */
    public PrincipalEquipos(JFrame pP, BaseDatos accesoBD) {
        initComponents();
        this.pP = pP;
        this.accesoBD = accesoBD;
        setLocationRelativeTo(pP);
        try {
            actualizaComboCatEquipo();
            actualizaComboTempEquipo();
        } catch (SQLException ex) {
            Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
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

        panelEquipos = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        textNombreEquipo = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        comboCatEquipo = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        comboTempEquipo = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        textEntEquipo = new javax.swing.JTextField();
        botonBuscar = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tablaEquipos = new javax.swing.JTable();
        botonModificarEquipo = new javax.swing.JButton();
        botonEliminarEquipo = new javax.swing.JButton();
        botonInfoEquipo = new javax.swing.JButton();
        botonNuevoEquipo = new javax.swing.JButton();
        botonMostrarEquipos = new javax.swing.JButton();
        labelEquiposMostrados = new javax.swing.JLabel();
        labelNumeroEquipos = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jComboBox1 = new javax.swing.JComboBox();
        verClasificacionEquipos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Equipos");

        jLabel10.setText("Nombre:");

        textNombreEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textNombreEquipoActionPerformed(evt);
            }
        });

        jLabel11.setText("Categoria:");

        comboCatEquipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-Categoria-" }));
        comboCatEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCatEquipoActionPerformed(evt);
            }
        });

        jLabel12.setText("Temporada:");

        comboTempEquipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-Temporada-" }));

        jLabel13.setText("Primer Entrenador:");

        botonBuscar.setText("Buscar");
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });

        tablaEquipos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Categoria", "Temporada", "Primer Entrenador", "Segundo Entrenador", "Sexo"
            }
        ));
        tablaEquipos.getTableHeader().setResizingAllowed(false);
        tablaEquipos.getTableHeader().setReorderingAllowed(false);
        jScrollPane5.setViewportView(tablaEquipos);

        botonModificarEquipo.setText("Modificar");
        botonModificarEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonModificarEquipoActionPerformed(evt);
            }
        });

        botonEliminarEquipo.setText("Eliminar");
        botonEliminarEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarEquipoActionPerformed(evt);
            }
        });

        botonInfoEquipo.setText("Info");

        botonNuevoEquipo.setText("Nuevo");
        botonNuevoEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonNuevoEquipoActionPerformed(evt);
            }
        });

        botonMostrarEquipos.setText("Mostrar Todos");
        botonMostrarEquipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMostrarEquiposActionPerformed(evt);
            }
        });

        labelEquiposMostrados.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelEquiposMostrados.setText("Numero de equipos:");

        labelNumeroEquipos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-Entrenador-" }));

        verClasificacionEquipos.setText("Clasificacion");
        verClasificacionEquipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verClasificacionEquiposActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelEquiposLayout = new javax.swing.GroupLayout(panelEquipos);
        panelEquipos.setLayout(panelEquiposLayout);
        panelEquiposLayout.setHorizontalGroup(
            panelEquiposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEquiposLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(panelEquiposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator4)
                    .addGroup(panelEquiposLayout.createSequentialGroup()
                        .addGroup(panelEquiposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addGroup(panelEquiposLayout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addGroup(panelEquiposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelEquiposLayout.createSequentialGroup()
                                        .addGroup(panelEquiposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(panelEquiposLayout.createSequentialGroup()
                                                .addComponent(jLabel10)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(textNombreEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel11)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(comboCatEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel12))
                                            .addGroup(panelEquiposLayout.createSequentialGroup()
                                                .addComponent(jLabel13)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(textEntEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(comboTempEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelEquiposLayout.createSequentialGroup()
                                        .addGap(51, 51, 51)
                                        .addComponent(botonBuscar)
                                        .addGap(56, 56, 56)
                                        .addComponent(botonMostrarEquipos)
                                        .addGap(62, 62, 62)
                                        .addComponent(verClasificacionEquipos))))
                            .addGroup(panelEquiposLayout.createSequentialGroup()
                                .addGap(157, 157, 157)
                                .addComponent(labelEquiposMostrados)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelNumeroEquipos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelEquiposLayout.createSequentialGroup()
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 608, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(panelEquiposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(botonModificarEquipo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                                    .addComponent(botonInfoEquipo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(botonEliminarEquipo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(botonNuevoEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelEquiposLayout.setVerticalGroup(
            panelEquiposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEquiposLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel8)
                .addGap(59, 59, 59)
                .addGroup(panelEquiposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelEquiposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12)
                        .addComponent(comboTempEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelEquiposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(textNombreEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11)
                        .addComponent(comboCatEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(panelEquiposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(textEntEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(panelEquiposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonBuscar)
                    .addComponent(botonMostrarEquipos)
                    .addComponent(verClasificacionEquipos))
                .addGap(18, 18, 18)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelEquiposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelEquiposLayout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(panelEquiposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelEquiposMostrados)
                            .addComponent(labelNumeroEquipos, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelEquiposLayout.createSequentialGroup()
                        .addComponent(botonNuevoEquipo)
                        .addGap(18, 18, 18)
                        .addComponent(botonInfoEquipo)
                        .addGap(18, 18, 18)
                        .addComponent(botonModificarEquipo)
                        .addGap(18, 18, 18)
                        .addComponent(botonEliminarEquipo)))
                .addGap(80, 80, 80))
        );

        this.labelEquiposMostrados.setVisible(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 777, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panelEquipos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 583, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panelEquipos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textNombreEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNombreEquipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textNombreEquipoActionPerformed

    private void comboCatEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCatEquipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboCatEquipoActionPerformed

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
        try {
            actualizaTablaEquiposFiltro(textNombreEquipo.getText(), comboTempEquipo.getSelectedItem().toString(), comboCatEquipo.getSelectedItem().toString(),
                textEntEquipo.getText());
            labelEquiposMostrados.setVisible(true);
            labelNumeroEquipos.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_botonBuscarActionPerformed

    private void botonModificarEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonModificarEquipoActionPerformed
        int fila = tablaEquipos.getSelectedRow();

        if (fila != -1) {
            String nombreEquipo = (String) tablaEquipos.getValueAt(tablaEquipos.getSelectedRow(), 0);
            String selecCat = (String) tablaEquipos.getValueAt(tablaEquipos.getSelectedRow(), 1);
            String selecTemp = (String) tablaEquipos.getValueAt(tablaEquipos.getSelectedRow(), 2);
            String primerEntr = (String) tablaEquipos.getValueAt(tablaEquipos.getSelectedRow(), 3);
            String segundoEntr = (String) tablaEquipos.getValueAt(tablaEquipos.getSelectedRow(), 4);
            String sexo = (String) tablaEquipos.getValueAt(tablaEquipos.getSelectedRow(), 5);

            if (!nombreEquipo.isEmpty() || !selecCat.isEmpty() || !selecTemp.isEmpty() || !primerEntr.isEmpty() || !segundoEntr.isEmpty() || !sexo.isEmpty()) {
                try {
                    new ModificarEquipo(accesoBD, nombreEquipo, selecCat, selecTemp, primerEntr, segundoEntr, sexo).setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                mostrarMensajeError("Falta algún campo por editar");
            }

        } else {
            mostrarMensajeError("No se ha seleccionado ninguna fila de la tabla");
        }
    }//GEN-LAST:event_botonModificarEquipoActionPerformed

    private void botonEliminarEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarEquipoActionPerformed

    }//GEN-LAST:event_botonEliminarEquipoActionPerformed

    private void botonNuevoEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNuevoEquipoActionPerformed
        try {
            new NuevoEquipo(accesoBD).setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_botonNuevoEquipoActionPerformed

    private void botonMostrarEquiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMostrarEquiposActionPerformed
        try {
            actualizaTablaEquipos();
            labelEquiposMostrados.setVisible(true);
            labelNumeroEquipos.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_botonMostrarEquiposActionPerformed

    private void verClasificacionEquiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verClasificacionEquiposActionPerformed
        new ClasificacionLiga(accesoBD).setVisible(true);
    }//GEN-LAST:event_verClasificacionEquiposActionPerformed

    private void actualizaComboCatEquipo() throws SQLException {
        comboCatEquipo.removeAllItems();
        comboCatEquipo.addItem("-Categoria-");
        
        String query = "SELECT tipo FROM Categoria";
        ResultSet res = accesoBD.ejecutaConsulta(query);
        while (res.next()) {
            comboCatEquipo.addItem(res.getString(1));
        }
    }
    
    private void actualizaComboTempEquipo() throws SQLException {
        comboTempEquipo.removeAllItems();
        comboTempEquipo.addItem("-Temporada-");
        
        String query = "SELECT curso FROM Temporada";
        ResultSet res = accesoBD.ejecutaConsulta(query);
        while (res.next()) {
            comboTempEquipo.addItem(res.getString(1));
        }
    }
    
    public void actualizaTablaEquiposFiltro(String nombre, String temporada, String categoria, String entrenador) throws SQLException {
    }
    
    private void mostrarMensajeError(String mensaje) {
        JOptionPane.showMessageDialog(null,
                mensaje, "Error",
                JOptionPane.ERROR_MESSAGE);
    }
    
    public void actualizaTablaEquipos() throws SQLException {
        List<Equipo> equipos = GestorEquipos.getListaEquipos(accesoBD);
        
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("Nombre");
        dtm.addColumn("Categoria");
        dtm.addColumn("Temporada");
        dtm.addColumn("Primer Entrenador");
        dtm.addColumn("Segundo Entrenador");
        dtm.addColumn("Sexo");
        
        
        Object[] fila = new Object[6];
        for (Equipo it : equipos) {
            
            fila[0] = it.getNombre();
            fila[1] = it.getCategoria();
            fila[2] = it.getTemporada();
            fila[3] = it.getEntrenador();
            fila[4] = it.getEntrenador2();
            fila[5] = it.getSexo();

            System.out.println("TABLA: " + fila.toString());
            dtm.addRow(fila);
        }
        
        tablaEquipos.setModel(dtm);
    }
    
    private String getCategoria(String s) throws SQLException {
        
        String cat = GestorCategorias.getCategoria(accesoBD, Integer.parseInt(s));
        
        return cat;
    }
    
    private String getEntrenador(String s) throws SQLException {
        
        return GestorUsuarios.getEntrenador(accesoBD, s);
    }
    
    private String getTemporada(String s) throws SQLException {
        
        return GestorTemporadas.getTemporada(accesoBD, s);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonEliminarEquipo;
    private javax.swing.JButton botonInfoEquipo;
    private javax.swing.JButton botonModificarEquipo;
    private javax.swing.JButton botonMostrarEquipos;
    private javax.swing.JButton botonNuevoEquipo;
    private javax.swing.JComboBox comboCatEquipo;
    private javax.swing.JComboBox comboTempEquipo;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel labelEquiposMostrados;
    private javax.swing.JLabel labelNumeroEquipos;
    private javax.swing.JPanel panelEquipos;
    private javax.swing.JTable tablaEquipos;
    private javax.swing.JTextField textEntEquipo;
    private javax.swing.JTextField textNombreEquipo;
    private javax.swing.JButton verClasificacionEquipos;
    // End of variables declaration//GEN-END:variables
}
