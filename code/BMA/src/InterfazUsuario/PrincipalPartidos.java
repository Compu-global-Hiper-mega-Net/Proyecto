/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfazUsuario;

import GestionDeCategorias.GestorCategorias;
import GestionDeEquipos.GestorEquipos;
import GestionDeInstalaciones.GestorInstalacion;
import GestionDePartidos.GestorPartidos;
import GestionDeTemporadas.GestorTemporadas;
import ServiciosAlmacenamiento.BaseDatos;
import com.toedter.calendar.JTextFieldDateEditor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
public class PrincipalPartidos extends javax.swing.JFrame {

    private JFrame pP;
    private BaseDatos accesoBD;
    private boolean noEntry;
    private int idC, idT;
    private Object equipoAnterior1, equipoAnterior2;

    /**
     * Creates new form PrincipalPartidos
     */
    public PrincipalPartidos(JFrame pP, BaseDatos bd) {
        initComponents();
        this.pP = pP;
        this.accesoBD = bd;
        setLocationRelativeTo(pP);
        idC = idT = 0;
        noEntry = true;
        //tablaPartidos.setEnabled(false);
        ((JTextFieldDateEditor) fechaPartido.getComponents()[1]).setEditable(false);
        try {
            actualizaComboTemporadaPartidos();
            actualizaComboCategoriaPartidos();
            List<String> equipos = new ArrayList<>();
            equipos = getListaEquipos(idC, idT);
            actualizaComboEquipoPartidos(equipos, 1);
            actualizaComboEquipoPartidos(equipos, 2);
        } catch (SQLException e) {
            Logger.getLogger(AñadirModificarTemporada.class.getName()).log(Level.SEVERE, null, e);
        }
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

        PanelPartidos = new javax.swing.JPanel();
        Partidos = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tablaPartidos = new javax.swing.JTable();
        BotonModificarPartido = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        BotonJPartido = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JSeparator();
        BotonNPartido = new javax.swing.JButton();
        botonMostrarPartidos = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        comboTemporadaPartidos = new javax.swing.JComboBox();
        comboCategoriaPartidos = new javax.swing.JComboBox();
        jLabel26 = new javax.swing.JLabel();
        botonFiltrarPartido = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        comboEquipoLocal = new javax.swing.JComboBox();
        comboEquipoVisitante = new javax.swing.JComboBox();
        jLabel28 = new javax.swing.JLabel();
        fechaPartido = new com.toedter.calendar.JDateChooser();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PanelPartidos.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        Partidos.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Partidos.setText("Partidos");

        tablaPartidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Fecha", "Hora", "Categoría", "Temporada", "Equipo Local", "Equipo Visitante", "Resultado Local", "Resultado Visitante"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane8.setViewportView(tablaPartidos);

        BotonModificarPartido.setText("Modificar Partido");
        BotonModificarPartido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonModificarPartidoActionPerformed(evt);
            }
        });

        jButton9.setText("Eliminar Partido");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        BotonJPartido.setText("Jugar Partido");
        BotonJPartido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonJPartidoActionPerformed(evt);
            }
        });

        BotonNPartido.setText("Nuevo Partido");
        BotonNPartido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonNPartidoActionPerformed(evt);
            }
        });

        botonMostrarPartidos.setText("Mostrar Partidos");
        botonMostrarPartidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMostrarPartidosActionPerformed(evt);
            }
        });

        jLabel16.setText("Buscar");

        comboTemporadaPartidos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboTemporadaPartidos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboTemporadaPartidosItemStateChanged(evt);
            }
        });

        comboCategoriaPartidos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboCategoriaPartidos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboCategoriaPartidosItemStateChanged(evt);
            }
        });

        jLabel26.setText("Equipo Local");

        botonFiltrarPartido.setText("Filtrar Partidos");
        botonFiltrarPartido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonFiltrarPartidoActionPerformed(evt);
            }
        });

        jLabel27.setText("Equipo Visitante");

        comboEquipoLocal.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboEquipoLocal.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboEquipoLocalItemStateChanged(evt);
            }
        });

        comboEquipoVisitante.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboEquipoVisitante.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboEquipoVisitanteItemStateChanged(evt);
            }
        });

        jLabel28.setText("Fecha");

        fechaPartido.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                fechaPartidoFocusLost(evt);
            }
        });

        jButton6.setText("Introducir XML al Partido");

        javax.swing.GroupLayout PanelPartidosLayout = new javax.swing.GroupLayout(PanelPartidos);
        PanelPartidos.setLayout(PanelPartidosLayout);
        PanelPartidosLayout.setHorizontalGroup(
            PanelPartidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPartidosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelPartidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelPartidosLayout.createSequentialGroup()
                        .addGroup(PanelPartidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(PanelPartidosLayout.createSequentialGroup()
                                .addComponent(BotonNPartido)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BotonModificarPartido)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton9))
                            .addGroup(PanelPartidosLayout.createSequentialGroup()
                                .addComponent(botonMostrarPartidos)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botonFiltrarPartido)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(PanelPartidosLayout.createSequentialGroup()
                        .addComponent(Partidos)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelPartidosLayout.createSequentialGroup()
                        .addGroup(PanelPartidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(PanelPartidosLayout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(comboTemporadaPartidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(comboCategoriaPartidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46)
                                .addComponent(jLabel26)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboEquipoLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(jLabel27)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboEquipoVisitante, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel28)
                                .addGap(18, 18, 18)
                                .addComponent(fechaPartido, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelPartidosLayout.createSequentialGroup()
                                .addComponent(jScrollPane8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(PanelPartidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(BotonJPartido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(36, 36, 36))))
        );
        PanelPartidosLayout.setVerticalGroup(
            PanelPartidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPartidosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Partidos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PanelPartidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelPartidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel16)
                        .addComponent(comboTemporadaPartidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboCategoriaPartidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel26)
                        .addComponent(jLabel27)
                        .addComponent(comboEquipoLocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboEquipoVisitante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel28))
                    .addComponent(fechaPartido, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelPartidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelPartidosLayout.createSequentialGroup()
                        .addComponent(BotonJPartido)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelPartidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonMostrarPartidos)
                    .addComponent(botonFiltrarPartido))
                .addGap(19, 19, 19)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelPartidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotonNPartido)
                    .addComponent(BotonModificarPartido)
                    .addComponent(jButton9))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 957, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(PanelPartidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 2, Short.MAX_VALUE)
                    .addComponent(PanelPartidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 2, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonModificarPartidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonModificarPartidoActionPerformed

        ResultSet retsetMostrados;

        int idPartido;

        int iTablaPartido = tablaPartidos.getSelectedRow();

        if (iTablaPartido >= 0) {
            String consulta = null;
            try {
                consulta = "SELECT idPartido FROM partido WHERE fecha = '"
                 + tablaPartidos.getValueAt(iTablaPartido, 0) + "' AND hora = '"
                 + tablaPartidos.getValueAt(iTablaPartido, 1) + "' AND equipo_Categoria_idCategoria = '"                        
                 + GestorCategorias.getIdCategoria(accesoBD, tablaPartidos.getValueAt(iTablaPartido,2).toString()) + "' AND equipo_Temporada_idTemporada = '"
                 + GestorTemporadas.getIdTemporada(accesoBD, tablaPartidos.getValueAt(iTablaPartido, 3).toString())+ "' AND idEquipo = '"
                 + GestorEquipos.getIdEquipo(accesoBD, tablaPartidos.getValueAt(iTablaPartido, 4).toString(), tablaPartidos.getValueAt(iTablaPartido, 2).toString())
                 + "' AND idEquipoVisitante = '" + GestorEquipos.getIdEquipo(accesoBD, tablaPartidos.getValueAt(iTablaPartido, 4).toString(), tablaPartidos.getValueAt(iTablaPartido, 2).toString()) + "'";
            } catch (SQLException ex) {
                Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }

            retsetMostrados = accesoBD.ejecutaConsulta(consulta);

            try {
                if (retsetMostrados.next()) {
                    idPartido = retsetMostrados.getInt("idPartido");

                    new ModificarPartido(accesoBD, 
                            tablaPartidos.getValueAt(iTablaPartido, 0).toString(),
                            tablaPartidos.getValueAt(iTablaPartido, 1).toString(),
                            tablaPartidos.getValueAt(iTablaPartido, 2).toString(),
                            tablaPartidos.getValueAt(iTablaPartido, 3).toString(),
                            tablaPartidos.getValueAt(iTablaPartido, 4).toString(),
                            tablaPartidos.getValueAt(iTablaPartido, 5).toString(),
                            Integer.parseInt(tablaPartidos.getValueAt(iTablaPartido, 6).toString()),
                            Integer.parseInt(tablaPartidos.getValueAt(iTablaPartido, 7).toString()),
                            idPartido, this).setVisible(true);
                }
            } catch (SQLException ex) {
                Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (iTablaPartido == -1) {
            JOptionPane.showMessageDialog(this, "No se ha seleccionado ninguna actividad", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_BotonModificarPartidoActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed

    private void BotonJPartidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonJPartidoActionPerformed
        new JugarPartido().setVisible(true);
    }//GEN-LAST:event_BotonJPartidoActionPerformed

    private void BotonNPartidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonNPartidoActionPerformed
        try {
            new NuevoPartido(accesoBD, this).setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BotonNPartidoActionPerformed

    private void botonMostrarPartidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMostrarPartidosActionPerformed
        actualizaTablaPartidos();

    }//GEN-LAST:event_botonMostrarPartidosActionPerformed

    private void comboTemporadaPartidosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboTemporadaPartidosItemStateChanged
        // TODO add your handling code here:
        if (!noEntry) {
            if (comboTemporadaPartidos.getSelectedItem() != "-Temporada-") {
                try {
                    idT = GestorTemporadas.getIdTemporada(accesoBD, comboTemporadaPartidos.getSelectedItem().toString());
                } catch (SQLException ex) {
                    Logger.getLogger(NuevoPartido.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_comboTemporadaPartidosItemStateChanged

    private void comboCategoriaPartidosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboCategoriaPartidosItemStateChanged
        // TODO add your handling code here:
        if (!noEntry) {
            if (comboCategoriaPartidos.getSelectedItem() != "-Categoria-") {
                try {
                    idC = GestorCategorias.getIdCategoria(accesoBD, comboCategoriaPartidos.getSelectedItem().toString());
                } catch (SQLException ex) {
                    Logger.getLogger(NuevoPartido.class.getName()).log(Level.SEVERE, null, ex);
                }
                List<String> equipos = new ArrayList<>();
                try {
                    noEntry = true;
                    equipos = getListaEquipos(idC, idT);
                    actualizaComboEquipoPartidos(equipos, 1);
                    actualizaComboEquipoPartidos(equipos, 2);
                    noEntry = false;
                } catch (SQLException ex) {
                    Logger.getLogger(NuevoPartido.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                idC = 0;
                List<String> equipos = new ArrayList<>();
                try {
                    noEntry = true;
                    equipos = getListaEquipos(idC, idT);
                    actualizaComboEquipoPartidos(equipos, 1);
                    actualizaComboEquipoPartidos(equipos, 2);
                    noEntry = false;
                } catch (SQLException ex) {
                    Logger.getLogger(NuevoPartido.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            equipoAnterior1 = "";
            equipoAnterior2 = "";
        }
    }//GEN-LAST:event_comboCategoriaPartidosItemStateChanged

    private void botonFiltrarPartidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonFiltrarPartidoActionPerformed
        // TODO add your handling code here:
        String fecha, temporada, categoria, equipoLoc, equipoVis;
        if (fechaPartido.getDate() != null) {
            java.sql.Date sqlFechaPartido = new java.sql.Date(fechaPartido.getDate().getTime());
            fecha = sqlFechaPartido.toString();
        } else {
            fecha = null;
        }
        if (comboTemporadaPartidos.getSelectedItem() != "-Temporada-") {
            temporada = comboTemporadaPartidos.getSelectedItem().toString();
        } else {
            temporada = null;
        }

        if (comboCategoriaPartidos.getSelectedItem() != "-Categoria-") {
            categoria = comboCategoriaPartidos.getSelectedItem().toString();
        } else {
            categoria = null;
        }

        if (comboEquipoLocal.getSelectedItem() != "-Equipo Local-") {
            equipoLoc = comboEquipoLocal.getSelectedItem().toString();
        } else {
            equipoLoc = null;
        }

        if (comboEquipoVisitante.getSelectedItem() != "-Equipo Visitante-") {
            equipoVis = comboEquipoVisitante.getSelectedItem().toString();
        } else {
            equipoVis = null;
        }
        try {
            actualizaTablaPartidosFiltro(fecha, temporada, categoria, equipoLoc, equipoVis);
        } catch (SQLException ex) {
            Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_botonFiltrarPartidoActionPerformed

    private void comboEquipoLocalItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboEquipoLocalItemStateChanged
        // TODO add your handling code here:
        if (!noEntry) {
            if (comboEquipoLocal.getSelectedItem() != "-Equipo Local-") {
                if (equipoAnterior1 == "") {
                    equipoAnterior1 = comboEquipoLocal.getSelectedItem();
                    comboEquipoVisitante.removeItem(equipoAnterior1);

                } else {
                    comboEquipoVisitante.addItem(equipoAnterior1);
                    equipoAnterior1 = comboEquipoLocal.getSelectedItem();
                    comboEquipoVisitante.removeItem(equipoAnterior1);
                }
            } else {
                if (equipoAnterior1 != "") {
                    comboEquipoVisitante.addItem(equipoAnterior1);
                    equipoAnterior1 = "";
                }
            }
        }
    }//GEN-LAST:event_comboEquipoLocalItemStateChanged

    private void comboEquipoVisitanteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboEquipoVisitanteItemStateChanged
        // TODO add your handling code here:
        if (!noEntry) {
            if (comboEquipoVisitante.getSelectedItem() != "-Equipo Visitante-") {
                if (equipoAnterior2 == "") {
                    equipoAnterior2 = comboEquipoVisitante.getSelectedItem();
                    comboEquipoLocal.removeItem(equipoAnterior2);

                } else {
                    comboEquipoLocal.addItem(equipoAnterior2);
                    equipoAnterior2 = comboEquipoVisitante.getSelectedItem();
                    comboEquipoLocal.removeItem(equipoAnterior2);
                }
            } else {
                if (equipoAnterior2 != "") {
                    comboEquipoLocal.addItem(equipoAnterior2);
                    equipoAnterior2 = "";
                }
            }
        }
    }//GEN-LAST:event_comboEquipoVisitanteItemStateChanged

    private void fechaPartidoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fechaPartidoFocusLost
        /*Date dateFromDateChooser = fechaPartido.getDate();
         String dateString = String.format("%1$tY-%1$tm-%1$td", dateFromDateChooser);
         if (dateString.equals("null-null-null")) {
         fechaPartido.setBorder(bordeError);
         } else {
         fechaPartido.setBorder(bordeDatePicker);
         }*/
    }//GEN-LAST:event_fechaPartidoFocusLost

    private void actualizaTablaPartidos() {
        List<List<String>> lpar = new ArrayList<List<String>>();
        try {
            lpar = GestorPartidos.getListaPartidos(accesoBD);
        } catch (SQLException ex) {
            Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("Fecha");
        dtm.addColumn("Hora");
        dtm.addColumn("Categoría");
        dtm.addColumn("Temporada");
        dtm.addColumn("Equipo Local");
        dtm.addColumn("Equipo Visitante");
        dtm.addColumn("Resultado Local");
        dtm.addColumn("Resultado Visitante");

        String aux;
        Object[] fila = new Object[8];
        for (List<String> it : lpar) {
            aux = it.get(0);
            fila[0] = aux.substring(0, aux.indexOf(","));
            aux = aux.substring(aux.indexOf(",") + 1, aux.length());
            fila[1] = aux.substring(0, aux.indexOf(","));
            aux = aux.substring(aux.indexOf(",") + 1, aux.length());
            try {
                fila[2] = getCategoria(aux.substring(0, aux.indexOf(",")));
            } catch (SQLException ex) {
                Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
            aux = aux.substring(aux.indexOf(",") + 1, aux.length());
            try {
                fila[3] = getTemporada(aux.substring(0, aux.indexOf(",")));
            } catch (SQLException ex) {
                Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
            aux = aux.substring(aux.indexOf(",") + 1, aux.length());
            try {
                fila[4] = getEquipo(aux.substring(0, aux.indexOf(",")));
            } catch (SQLException ex) {
                Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
            aux = aux.substring(aux.indexOf(",") + 1, aux.length());
            try {
                fila[5] = getEquipo(aux.substring(0, aux.indexOf(",")));
            } catch (SQLException ex) {
                Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
            aux = aux.substring(aux.indexOf(",") + 1, aux.length());
            fila[6] = aux.substring(0, aux.indexOf(","));
            aux = aux.substring(aux.indexOf(",") + 1, aux.length());
            fila[7] = aux;
            dtm.addRow(fila);
        }

        tablaPartidos.setModel(dtm);

    }

    private String getCategoria(String s) throws SQLException {

        String cat = GestorCategorias.getCategoria(accesoBD, Integer.parseInt(s));

        return cat;
    }

    private String getTemporada(String s) throws SQLException {

        return GestorTemporadas.getTemporada(accesoBD, s);
    }

    private String getEquipo(String s) throws SQLException {
        return GestorEquipos.getEquipo(accesoBD, s);
    }
    
    private void actualizaComboTemporadaPartidos() throws SQLException {
        comboTemporadaPartidos.removeAllItems();
        comboTemporadaPartidos.addItem("-Temporada-");
        
        String query = "SELECT curso FROM Temporada";
        ResultSet res = accesoBD.ejecutaConsulta(query);
        while (res.next()) {
            comboTemporadaPartidos.addItem(res.getString(1));
        }
    }
    
    private void actualizaComboCategoriaPartidos() throws SQLException {
        comboCategoriaPartidos.removeAllItems();
        comboCategoriaPartidos.addItem("-Categoría-");
        
        String query = "SELECT tipo FROM Categoria";
        ResultSet res = accesoBD.ejecutaConsulta(query);
        while (res.next()) {
            comboCategoriaPartidos.addItem(res.getString(1));
        }
    }
    
    void actualizaComboEquipoPartidos(List<String> equipos, int numEquipo) throws SQLException {
        if (numEquipo == 1) {
            comboEquipoLocal.removeAllItems();
            comboEquipoLocal.addItem("-Equipo Local-");
            for (String s : equipos) {
                comboEquipoLocal.addItem(s);
            }
        } else {
            comboEquipoVisitante.removeAllItems();
            comboEquipoVisitante.addItem("-Equipo Visitante-");
            for (String s : equipos) {
                comboEquipoVisitante.addItem(s);
            }
        }
    }
    
    public List<String> getListaEquipos(int idCat, int idTemp) throws SQLException {
        List<String> equipos = new ArrayList<String>();
        String query;
        if (idCat == 0 && idTemp != 0) {
            query = "SELECT nombre FROM Equipo WHERE (temporada_idTemporada = " + idTemp + ");";
        } else if (idCat != 0 && idTemp == 0) {
            query = "SELECT nombre FROM Equipo WHERE (Categoria_IdCategoria = " + idCat + ");";
        } else {
            query = "SELECT nombre FROM Equipo WHERE (Categoria_IdCategoria = " + idCat + " AND temporada_idTemporada = " + idTemp + ");";
        }
        ResultSet res = accesoBD.ejecutaConsulta(query);
        while (res.next()) {
            equipos.add(res.getString(1));
        }
        return equipos;
    }
    
    private void actualizaTablaPartidosFiltro(String fecha, String temporada, String categoria, String equipoLoc, String equipoVis) throws SQLException {
        List<List<String>> lpar = new ArrayList<List<String>>();
        int idCat = 0;
        idCat = GestorCategorias.getIdCategoria(accesoBD, categoria);
        System.out.println();
        System.out.println(equipoLoc);
        try {
            lpar = GestorPartidos.getListaPartidosFiltro(accesoBD, fecha, String.valueOf(GestorTemporadas.getIdTemporada(accesoBD, temporada)),
                    String.valueOf(idCat), String.valueOf(GestorEquipos.getIdEquipo(accesoBD, equipoLoc, categoria)),
                    String.valueOf(GestorEquipos.getIdEquipo(accesoBD, equipoVis, categoria)));
        } catch (SQLException ex) {
            Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("Fecha");
        dtm.addColumn("Hora");
        dtm.addColumn("Categoría");
        dtm.addColumn("Temporada");
        dtm.addColumn("Equipo Local");
        dtm.addColumn("Equipo Visitante");
        dtm.addColumn("Resultado Local");
        dtm.addColumn("Resultado Visitante");
        
        String aux;
        Object[] fila = new Object[8];
        for (List<String> it : lpar) {
            aux = it.get(0);
            fila[0] = aux.substring(0, aux.indexOf(","));
            aux = aux.substring(aux.indexOf(",") + 1, aux.length());
            fila[1] = aux.substring(0, aux.indexOf(","));
            aux = aux.substring(aux.indexOf(",") + 1, aux.length());
            try {
                fila[2] = getCategoria(aux.substring(0, aux.indexOf(",")));
            } catch (SQLException ex) {
                Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
            aux = aux.substring(aux.indexOf(",") + 1, aux.length());
            try {
                fila[3] = getTemporada(aux.substring(0, aux.indexOf(",")));
            } catch (SQLException ex) {
                Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
            aux = aux.substring(aux.indexOf(",") + 1, aux.length());
            try {
                fila[4] = getEquipo(aux.substring(0, aux.indexOf(",")));
            } catch (SQLException ex) {
                Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
            aux = aux.substring(aux.indexOf(",") + 1, aux.length());
            try {
                fila[5] = getEquipo(aux.substring(0, aux.indexOf(",")));
            } catch (SQLException ex) {
                Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
            aux = aux.substring(aux.indexOf(",") + 1, aux.length());
            fila[6] = aux.substring(0, aux.indexOf(","));
            aux = aux.substring(aux.indexOf(",") + 1, aux.length());
            fila[7] = aux;
            dtm.addRow(fila);
        }
        
        tablaPartidos.setModel(dtm);
        
    }
    
    List<String> getListaTemps() throws SQLException {
        return GestorTemporadas.getListaTemporadas(accesoBD);
    }
    
    List<String> getListaInstalaciones(String s) throws SQLException {
        return GestorInstalacion.getListaInstalaciones(accesoBD);
    }
    
    List<List<String>> getListaCategorias() throws SQLException {
        List<List<String>> cats = new ArrayList<List<String>>();
        cats = GestorCategorias.getListaCategorias(accesoBD);
        return cats;
    }
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonJPartido;
    private javax.swing.JButton BotonModificarPartido;
    private javax.swing.JButton BotonNPartido;
    private javax.swing.JPanel PanelPartidos;
    private javax.swing.JLabel Partidos;
    private javax.swing.JButton botonFiltrarPartido;
    private javax.swing.JButton botonMostrarPartidos;
    private javax.swing.JComboBox comboCategoriaPartidos;
    private javax.swing.JComboBox comboEquipoLocal;
    private javax.swing.JComboBox comboEquipoVisitante;
    private javax.swing.JComboBox comboTemporadaPartidos;
    private com.toedter.calendar.JDateChooser fechaPartido;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JTable tablaPartidos;
    // End of variables declaration//GEN-END:variables
}