package InterfazUsuario;

import GestionDeAlumnos.GestorAlumnos;
import ServiciosAlmacenamiento.BaseDatos;
import bma.ComboBoxItem;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

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

/**
 * Clase interfaz que se encarga de mostrar los datos relacionados con la
 * pantalla del gestor de jugadores de la aplicación
 *
 * @author Alex
 */
public class PrincipalJugadores extends javax.swing.JFrame {

    private BaseDatos bd;

    /**
     * Constructor de la clase
     *
     * @param pP Parametro formal correspondiente al componente padre de donde
     * hereda la interfaz que esta en uso.
     * @param bd datos para acceder a la base de datos de nuestro sistema.
     */
    public PrincipalJugadores(PantallaPrincipal pP, BaseDatos bd) {
        initComponents();
        this.bd = bd;
        setLocationRelativeTo(pP);

        // Se cargan los datos de "lookup"
        try {
            ResultSet consulta = bd.ejecutaConsulta("SELECT idGrupo FROM grupo");
            ComboBoxItem cbi;
            consultaGrupo.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"No seleccionado"}));
            while (consulta.next()) {
                consultaGrupo.addItem(consulta.getInt("idGrupo"));
            }
            consulta = bd.ejecutaConsulta("SELECT idEquipo, nombre FROM equipo");
            consultaEquipo.setModel(new javax.swing.DefaultComboBoxModel(new ComboBoxItem[]{new ComboBoxItem(0, "No seleccionado")}));
            while (consulta.next()) {
                cbi = new ComboBoxItem(consulta.getInt("idEquipo"), consulta.getString("nombre"));
                consultaEquipo.addItem(cbi);
            }
            consulta = bd.ejecutaConsulta("SELECT idCategoria, tipo FROM categoria");
            consultaCategoria.setModel(new javax.swing.DefaultComboBoxModel(new ComboBoxItem[]{new ComboBoxItem(0, "No seleccionada")}));
            while (consulta.next()) {
                cbi = new ComboBoxItem(consulta.getInt("idCategoria"), consulta.getString("tipo"));
                consultaCategoria.addItem(cbi);
            }
            consulta = bd.ejecutaConsulta("SELECT idTemporada, curso FROM temporada ORDER BY curso DESC");
            consultaTemporada.setModel(new javax.swing.DefaultComboBoxModel(new ComboBoxItem[]{new ComboBoxItem(0, "No seleccionada")}));
            while (consulta.next()) {
                cbi = new ComboBoxItem(consulta.getInt("idTemporada"), consulta.getString("curso"));
                consultaTemporada.addItem(cbi);
            }
            alumnosFiltrado();
        } catch (SQLException ex) {
            System.out.print(ex.getMessage());
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

        jPanel2 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        equipoAlLabel = new javax.swing.JLabel();
        categoriaAlLabel = new javax.swing.JLabel();
        consultaCategoria = new javax.swing.JComboBox();
        consultaGrupo = new javax.swing.JComboBox();
        botonEliminarAlumno = new javax.swing.JButton();
        consultaTemporada = new javax.swing.JComboBox();
        nombreAlLabel = new javax.swing.JLabel();
        botonNuevoAlumno = new javax.swing.JButton();
        estadisticasJugador = new javax.swing.JButton();
        grupoAlLabel = new javax.swing.JLabel();
        nombreAlumno = new javax.swing.JTextField();
        consultaEquipo = new javax.swing.JComboBox();
        temporadaLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        botonModificar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaAlumnos = new javax.swing.JTable();
        consultar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel10.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        equipoAlLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        equipoAlLabel.setText("Equipo:");
        jPanel10.add(equipoAlLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 40, 40, 20));

        categoriaAlLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        categoriaAlLabel.setText("Categoria:");
        jPanel10.add(categoriaAlLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 60, 20));

        consultaCategoria.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        consultaCategoria.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                consultaCategoriaItemStateChanged(evt);
            }
        });
        jPanel10.add(consultaCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 110, 22));

        consultaGrupo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        consultaGrupo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                consultaGrupoItemStateChanged(evt);
            }
        });
        jPanel10.add(consultaGrupo, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 40, 110, 22));

        botonEliminarAlumno.setText("Eliminar");
        botonEliminarAlumno.setMaximumSize(new java.awt.Dimension(63, 23));
        botonEliminarAlumno.setMinimumSize(new java.awt.Dimension(63, 23));
        botonEliminarAlumno.setPreferredSize(new java.awt.Dimension(100, 23));
        botonEliminarAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarAlumnoActionPerformed(evt);
            }
        });
        jPanel10.add(botonEliminarAlumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 180, -1, -1));

        consultaTemporada.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                consultaTemporadaItemStateChanged(evt);
            }
        });
        jPanel10.add(consultaTemporada, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, 110, 22));

        nombreAlLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        nombreAlLabel.setText("Nombre/Apellidos:");
        jPanel10.add(nombreAlLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 90, 20));

        botonNuevoAlumno.setText("Nuevo");
        botonNuevoAlumno.setPreferredSize(new java.awt.Dimension(100, 23));
        botonNuevoAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonNuevoAlumnoActionPerformed(evt);
            }
        });
        jPanel10.add(botonNuevoAlumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 90, -1, -1));

        estadisticasJugador.setText("Estadisticas");
        estadisticasJugador.setMaximumSize(new java.awt.Dimension(63, 23));
        estadisticasJugador.setMinimumSize(new java.awt.Dimension(63, 23));
        estadisticasJugador.setPreferredSize(new java.awt.Dimension(100, 23));
        estadisticasJugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                estadisticasJugadorActionPerformed(evt);
            }
        });
        jPanel10.add(estadisticasJugador, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 290, -1, -1));

        grupoAlLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        grupoAlLabel.setText("Grupo:");
        jPanel10.add(grupoAlLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 40, 40, 20));

        nombreAlumno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nombreAlumnoKeyReleased(evt);
            }
        });
        jPanel10.add(nombreAlumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 201, 20));

        consultaEquipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        consultaEquipo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                consultaEquipoItemStateChanged(evt);
            }
        });
        jPanel10.add(consultaEquipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 40, 110, 22));

        temporadaLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        temporadaLabel.setText("Temporada:");
        jPanel10.add(temporadaLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, 70, 20));
        jPanel10.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 600, -1));

        botonModificar.setText("Modificar");
        botonModificar.setMaximumSize(new java.awt.Dimension(63, 23));
        botonModificar.setMinimumSize(new java.awt.Dimension(63, 23));
        botonModificar.setPreferredSize(new java.awt.Dimension(100, 23));
        botonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonModificarActionPerformed(evt);
            }
        });
        jPanel10.add(botonModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 150, -1, -1));

        tablaAlumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaAlumnos.getTableHeader().setResizingAllowed(false);
        tablaAlumnos.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tablaAlumnos);

        jPanel10.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 460, 240));

        consultar.setText("Consultar");
        consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarActionPerformed(evt);
            }
        });
        jPanel10.add(consultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 120, 100, -1));

        jPanel2.add(jPanel10, java.awt.BorderLayout.CENTER);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Jugadores");
        jPanel1.add(jLabel4);

        jPanel2.add(jPanel1, java.awt.BorderLayout.PAGE_START);

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     *
     * @param evt
     */
    private void botonEliminarAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarAlumnoActionPerformed
        // Se comprueba si se ha seleccionado un alumno
        int fila = tablaAlumnos.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Debes seleccionar un jugador", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            // Si se ha seleccionado y se está de acuerdo con borrarlo, se borra.
            int selection = JOptionPane.showConfirmDialog(this, "Desea eliminar el jugador?", "Eliminar jugador", JOptionPane.YES_NO_OPTION);
            if (selection == JOptionPane.YES_OPTION) {
                GestorAlumnos.eliminaAlumno(this.bd, Integer.parseInt((String) tablaAlumnos.getValueAt(fila, 0)));
                try {
                    alumnosFiltrado();
                } catch (SQLException ex) {
                    Logger.getLogger(PrincipalJugadores.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_botonEliminarAlumnoActionPerformed

    /**
     *
     * @param evt
     */
    private void botonNuevoAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNuevoAlumnoActionPerformed
        new AñadirConsultarModificarJugador(null, this.bd).setVisible(true);
    }//GEN-LAST:event_botonNuevoAlumnoActionPerformed

    private void estadisticasJugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_estadisticasJugadorActionPerformed
        String jugadorElegido = "";
        ResultSet retset = null;

        // Se comprueba si se ha seleccionado a un alumno.
        int i = tablaAlumnos.getSelectedRow();
        if (i == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione un jugador para ver estadisticas");
        } else {
            int idAlumno = Integer.parseInt((String) tablaAlumnos.getValueAt(i, 0));
            String consulta = "SELECT CONCAT(`nombre`,' ',`primerApellido`,' ',`segundoApellido`)"
                    + " FROM alumno WHERE idAlumno=" + idAlumno;
            ResultSet res = bd.ejecutaConsulta(consulta);
            try {
                if (res.next()) {
                    jugadorElegido = res.getString(1);
                }

                retset = GestorAlumnos.consultarEstadisticasAlumno(this.bd, idAlumno);
            } catch (SQLException ex) {
                Logger.getLogger(PrincipalJugadores.class.getName()).log(Level.SEVERE, null, ex);
            }

            // Si hay estadisticas se muestran, sino no
            if (retset != null) {
                new EstadisticasJugador(this.bd, retset, jugadorElegido).setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "No hay datos que mostrar para el jugador");
            }
        }
    }//GEN-LAST:event_estadisticasJugadorActionPerformed

    /**
     *
     * @param evt
     */
    private void botonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonModificarActionPerformed
        // Se comprueba si se ha seleccionado a un alumno para modificarlo
        int filaSel = tablaAlumnos.getSelectedRow();
        if (filaSel == -1) {
            JOptionPane.showMessageDialog(this, "Debes seleccionar un jugador", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                new AñadirConsultarModificarJugador(this, this.bd, Integer.parseInt((String) tablaAlumnos.getValueAt(filaSel, 0)), false).setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(PrincipalJugadores.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_botonModificarActionPerformed

    /**
     *
     * @param evt
     */
    private void nombreAlumnoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreAlumnoKeyReleased
        try {
            alumnosFiltrado();
        } catch (SQLException ex) {
            Logger.getLogger(PrincipalJugadores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_nombreAlumnoKeyReleased

    /**
     *
     * @param evt
     */
    private void consultaTemporadaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_consultaTemporadaItemStateChanged
        if (evt.getStateChange() == 1) {
            ResultSet consulta;
            if (((ComboBoxItem) consultaTemporada.getSelectedItem()).getId() != 0) {
                try {
                    consulta = bd.ejecutaConsulta("SELECT idGrupo FROM grupo "
                            + "WHERE Temporada_idTemporada=" + ((ComboBoxItem) consultaTemporada.getSelectedItem()).getId());
                    ComboBoxItem cbi;
                    consultaGrupo.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"No seleccionado"}));
                    while (consulta.next()) {
                        consultaGrupo.addItem(consulta.getInt(1));
                    }

                    consulta = bd.ejecutaConsulta("SELECT idEquipo, nombre FROM equipo "
                            + "WHERE temporada_idTemporada=" + ((ComboBoxItem) consultaTemporada.getSelectedItem()).getId());
                    consultaEquipo.setModel(new javax.swing.DefaultComboBoxModel(new ComboBoxItem[]{new ComboBoxItem(0, "No seleccionado")}));
                    while (consulta.next()) {
                        cbi = new ComboBoxItem(consulta.getInt("idEquipo"), consulta.getString("nombre"));
                        consultaEquipo.addItem(cbi);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(PrincipalJugadores.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                try {
                    consulta = bd.ejecutaConsulta("SELECT idGrupo FROM grupo");
                    ComboBoxItem cbi;
                    consultaGrupo.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"No seleccionado"}));
                    while (consulta.next()) {
                        consultaGrupo.addItem(consulta.getInt("idGrupo"));
                    }

                    consulta = bd.ejecutaConsulta("SELECT idEquipo, nombre FROM equipo");
                    consultaEquipo.setModel(new javax.swing.DefaultComboBoxModel(new ComboBoxItem[]{new ComboBoxItem(0, "No seleccionado")}));
                    while (consulta.next()) {
                        cbi = new ComboBoxItem(consulta.getInt("idEquipo"), consulta.getString("nombre"));
                        consultaEquipo.addItem(cbi);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(PrincipalJugadores.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            try {
                alumnosFiltrado();
            } catch (SQLException ex) {
                Logger.getLogger(PrincipalJugadores.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_consultaTemporadaItemStateChanged

    /**
     *
     * @param evt
     */
    private void consultaCategoriaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_consultaCategoriaItemStateChanged
        if (evt.getStateChange() == 1) {
            if (((ComboBoxItem) consultaTemporada.getSelectedItem()).getId() == 0) {
                try {
                    ResultSet consulta = bd.ejecutaConsulta("SELECT idTemporada, curso FROM temporada ORDER BY curso DESC");
                    if (consulta.next()) {
                        consultaTemporada.setSelectedItem(new ComboBoxItem(consulta.getInt("idTemporada"), consulta.getString("curso")));
                    }

                } catch (SQLException ex) {
                    Logger.getLogger(PrincipalJugadores.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            try {
                alumnosFiltrado();
            } catch (SQLException ex) {
                Logger.getLogger(PrincipalJugadores.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_consultaCategoriaItemStateChanged
    /**
     *
     * @param evt
     */
    private void consultaEquipoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_consultaEquipoItemStateChanged
        if (evt.getStateChange() == 1) {
            ComboBoxItem equipo = (ComboBoxItem) consultaEquipo.getSelectedItem();
            if (equipo.getId() != 0) {
                try {
                    if (((ComboBoxItem) consultaTemporada.getSelectedItem()).getId() != 0) {
                        ComboBoxItem cbi;
                        ResultSet consulta = bd.ejecutaConsulta("SELECT idTemporada, curso FROM temporada t, equipo e"
                                + " WHERE e.temporada_idTemporada=t.idTemporada AND e.idEquipo=" + equipo.getId() + " ORDER BY curso DESC");
                        if (consulta.next()) {
                            consultaTemporada.setSelectedItem(new ComboBoxItem(consulta.getInt("idTemporada"), consulta.getString("curso")));
                        }

                        consulta = bd.ejecutaConsulta("SELECT idGrupo FROM grupo "
                                + "WHERE Temporada_idTemporada=" + ((ComboBoxItem) consultaTemporada.getSelectedItem()).getId());
                        consultaGrupo.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"No seleccionado"}));
                        while (consulta.next()) {
                            consultaGrupo.addItem(consulta.getInt(1));
                        }

                        consulta = bd.ejecutaConsulta("SELECT idEquipo, nombre FROM equipo "
                                + "WHERE temporada_idTemporada=" + ((ComboBoxItem) consultaTemporada.getSelectedItem()).getId());
                        consultaEquipo.setModel(new javax.swing.DefaultComboBoxModel(new ComboBoxItem[]{new ComboBoxItem(0, "No seleccionado")}));
                        while (consulta.next()) {
                            cbi = new ComboBoxItem(consulta.getInt("idEquipo"), consulta.getString("nombre"));
                            consultaEquipo.addItem(cbi);
                        }
                        consultaEquipo.setSelectedItem(equipo);
                        System.out.print("\n sale "+consulta);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(PrincipalJugadores.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            try {
                alumnosFiltrado();
            } catch (SQLException ex) {
                Logger.getLogger(PrincipalJugadores.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_consultaEquipoItemStateChanged
    /**
     *
     * @param evt
     */
    private void consultaGrupoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_consultaGrupoItemStateChanged
        if (evt.getStateChange() == 1) {
            String grupo = consultaGrupo.getSelectedItem().toString();
            if (!grupo.equals("No seleccionado")) {
                try {
                    if (((ComboBoxItem) consultaTemporada.getSelectedItem()).getId() == 0) {
                        ComboBoxItem cbi;
                        ResultSet consulta = bd.ejecutaConsulta("SELECT idTemporada, curso FROM temporada t, grupo g"
                                + " WHERE g.Temporada_idTemporada=t.idTemporada AND g.idGrupo=" + grupo + " ORDER BY curso DESC");
                        if (consulta.next()) {
                            consultaTemporada.setSelectedItem(new ComboBoxItem(consulta.getInt("idTemporada"), consulta.getString("curso")));
                        }

                        consulta = bd.ejecutaConsulta("SELECT idEquipo, nombre FROM equipo "
                                + "WHERE temporada_idTemporada=" + ((ComboBoxItem) consultaTemporada.getSelectedItem()).getId());
                        consultaEquipo.setModel(new javax.swing.DefaultComboBoxModel(new ComboBoxItem[]{new ComboBoxItem(0, "No seleccionado")}));
                        while (consulta.next()) {
                            cbi = new ComboBoxItem(consulta.getInt("idEquipo"), consulta.getString("nombre"));
                            consultaEquipo.addItem(cbi);
                        }

                        consulta = bd.ejecutaConsulta("SELECT idGrupo FROM grupo "
                                + "WHERE Temporada_idTemporada=" + ((ComboBoxItem) consultaTemporada.getSelectedItem()).getId());
                        consultaGrupo.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"No seleccionado"}));
                        while (consulta.next()) {
                            consultaGrupo.addItem(consulta.getString(1));
                        }
                        consultaGrupo.setSelectedItem(grupo);
                        System.out.print("\n grupo "+consulta);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(PrincipalJugadores.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            try {
                alumnosFiltrado();
            } catch (SQLException ex) {
                Logger.getLogger(PrincipalJugadores.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_consultaGrupoItemStateChanged
    /**
     *
     * @param evt
     */
    private void consultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarActionPerformed
        // Se comprueba si se ha seleccionado a un alumno para modificarlo
        int filaSel = tablaAlumnos.getSelectedRow();
        if (filaSel == -1) {
            JOptionPane.showMessageDialog(this, "Debes seleccionar un jugador", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                new AñadirConsultarModificarJugador(this, this.bd, Integer.parseInt((String) tablaAlumnos.getValueAt(filaSel, 0)), true).setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(PrincipalJugadores.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_consultarActionPerformed
    /**
     *
     * @throws SQLException
     */
    protected final void alumnosFiltrado() throws SQLException {
        String consulta = "SELECT a.idAlumno, CONCAT(`a`.`nombre`,' ',`a`.`primerApellido`,' ',`a`.`segundoApellido`), "
                + "a.localidad, a.sexo "
                + "FROM alumno a";
        String tablasImplicadas = "";
        String where = " WHERE";
        if (!nombreAlumno.getText().isEmpty()) {
            where = where + " CONCAT(`a`.`nombre`,' ',`a`.`primerApellido`,' ',`a`.`segundoApellido`) LIKE '%" + nombreAlumno.getText() + "%' AND ";
        }
        if (!consultaGrupo.getSelectedItem().toString().equals("No seleccionado")) {
            where = where + " ag.alumno_idalumno=a.idalumno AND ag.Grupo_idGrupo=" + consultaGrupo.getSelectedItem().toString() + " AND";
            tablasImplicadas = tablasImplicadas + ", alumnogrupo ag";
        }
        if (!consultaCategoria.getSelectedItem().toString().equals("No seleccionada")) {
            String ComprobacionMenores = "Select edadmin from categoria where "
                    + "categoria.idcategoria=(select min(c.idcategoria) from categoria c)";
            ResultSet sal = bd.ejecutaConsulta(ComprobacionMenores);
            sal.next();
            int edad = Integer.parseInt(((ComboBoxItem) consultaTemporada.getSelectedItem()).getDescription().substring(0, 4)) - sal.getInt(1);

            String edadMinimaCategoriaBuscada = "Select edadmin from categoria where "
                    + "categoria.idcategoria=" + ((ComboBoxItem) consultaCategoria.getSelectedItem()).getId();
            sal = bd.ejecutaConsulta(edadMinimaCategoriaBuscada);
            sal.next();
            int año = Integer.parseInt(((ComboBoxItem) consultaTemporada.getSelectedItem()).getDescription().substring(0, 4)) - sal.getInt(1);

            if (edad == año) {
                where = where + " fechaNacimiento >'" + año + "-1-1' AND";
            } else {
                where = where + " fechaNacimiento >'" + año + "-1-1' And fechaNacimiento <'" + (año + 1) + "-1-1' AND";
            }
        }
        if (!consultaEquipo.getSelectedItem().toString().equals("No seleccionado")) {
            where = where + " ae.Alumno_idAlumno=a.idalumno AND ae.Equipo_idEquipo=" + ((ComboBoxItem) consultaEquipo.getSelectedItem()).getId() + " AND";
            tablasImplicadas = tablasImplicadas + ", alumnoequipo ae";
        }
        if (!consultaTemporada.getSelectedItem().toString().equals("No seleccionada")) {
            where = where + " at.alumno_idalumno=a.idalumno and at.temporada_idtemporada=" + ((ComboBoxItem) consultaTemporada.getSelectedItem()).getId() + " AND";
            tablasImplicadas = tablasImplicadas + ", alumnotemporada at";
        }

        if (!tablasImplicadas.isEmpty()) {
            consulta = consulta + tablasImplicadas;
        }
        String con;
        if (!where.equals(" WHERE")) {
            consulta = consulta + where;
            con = consulta.substring(0, consulta.length() - 4);
        } else {
            con = consulta + " ORDER BY a.idAlumno DESC";
        }
        ResultSet retset = this.bd.ejecutaConsulta(con);

        try {
            // Se extraen los datos de la BD segun los filtros que haya puesto el usuario
            ArrayList<ArrayList<Object>> dataCollection = new ArrayList<>();
            ArrayList<Object> row;
            while (retset.next()) {
                row = new ArrayList<>();
                row.add(retset.getString("idAlumno"));
                row.add(retset.getString(2));
                row.add(retset.getString("localidad"));
                if (retset.getString("sexo").equals("M")) {
                    row.add("Masculino");
                } else {
                    row.add("Femenino");
                }
                dataCollection.add(row);
            }

            Object[][] data = new Object[dataCollection.size()][17];
            for (int i = 0; i < dataCollection.size(); i++) {
                data[i] = dataCollection.get(i).toArray(new Object[17]);
            }

            // Se introducen los datos enpaco la tabla
            DefaultTableModel dtm = new DefaultTableModel(data, new String[]{"ID alumno", "Nombre completo", "Localidad", "Sexo"}) {
                Class[] types = new Class[]{String.class, String.class, String.class, String.class};
                boolean[] canEdit = new boolean[]{false, false, false, false};

                @Override
                public Class getColumnClass(int columnIndex) {
                    return types[columnIndex];
                }

                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit[columnIndex];
                }
            };

            tablaAlumnos.setModel(dtm);
            tablaAlumnos.getColumnModel().getColumn(0).setMaxWidth(0);
            tablaAlumnos.getColumnModel().getColumn(0).setMinWidth(0);
            tablaAlumnos.getColumnModel().getColumn(0).setPreferredWidth(0);

            tablaAlumnos.getColumnModel().getColumn(2).setMaxWidth(150);
            tablaAlumnos.getColumnModel().getColumn(2).setMinWidth(150);
            tablaAlumnos.getColumnModel().getColumn(2).setPreferredWidth(150);

            tablaAlumnos.getColumnModel().getColumn(3).setMaxWidth(100);
            tablaAlumnos.getColumnModel().getColumn(3).setMinWidth(100);
            tablaAlumnos.getColumnModel().getColumn(3).setPreferredWidth(100);
        } catch (SQLException ex) {
            System.out.print(ex.getMessage());
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonEliminarAlumno;
    private javax.swing.JButton botonModificar;
    private javax.swing.JButton botonNuevoAlumno;
    private javax.swing.JLabel categoriaAlLabel;
    private javax.swing.JComboBox consultaCategoria;
    private javax.swing.JComboBox consultaEquipo;
    private javax.swing.JComboBox consultaGrupo;
    private javax.swing.JComboBox consultaTemporada;
    private javax.swing.JButton consultar;
    private javax.swing.JLabel equipoAlLabel;
    private javax.swing.JButton estadisticasJugador;
    private javax.swing.JLabel grupoAlLabel;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel nombreAlLabel;
    private javax.swing.JTextField nombreAlumno;
    private javax.swing.JTable tablaAlumnos;
    private javax.swing.JLabel temporadaLabel;
    // End of variables declaration//GEN-END:variables
}
