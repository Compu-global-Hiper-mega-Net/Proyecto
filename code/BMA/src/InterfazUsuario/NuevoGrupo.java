package InterfazUsuario;

import GestionDeAlumnos.GestorAlumnos;
import GestionDeCategorias.GestorCategorias;
import GestionDeGrupos.GestorGrupos;
import ServiciosAlmacenamiento.BaseDatos;
import bma.DiasSemana;
import java.awt.Color;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Diego y carlos
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
public class NuevoGrupo extends javax.swing.JFrame {

    private PrincipalGrupos pP;
    private BaseDatos bd;
    private List<String> listaAlumnos;
    private List<String> alumnosCat;

    /**
     * Creates new form NuevoGrupo
     */
    public NuevoGrupo(PrincipalGrupos v, BaseDatos bd) throws SQLException {
        initComponents();
        this.setLocationRelativeTo(v);
        this.pP = v;
        this.bd = bd;
        this.listaAlumnos = new ArrayList<>();

        List<String> aux = pP.getListaTemps();
        actualizaComboTemp(aux);

        //aux = creador.getListaCategorias();
        aux = GestorCategorias.getTipoCategorias(this.bd);
        actualizaComboCat(aux);

        aux = pP.getListaAlumnosSinGrupo("");
        actualizaModeloLista(aux);

        aux = pP.getListaEntrenadores("");
        actualizaComboEntrenadores(aux);

        aux = pP.getListaInstalaciones("");
        actualizaComboInstalaciones(aux);

        labelError.setVisible(false);

        comboDia1.removeAllItems();
        comboDia1.addItem(DiasSemana.Lunes);
        comboDia1.addItem(DiasSemana.Martes);
        comboDia1.addItem(DiasSemana.Miercoles);
        comboDia1.addItem(DiasSemana.Jueves);
        comboDia1.addItem(DiasSemana.Viernes);
        comboDia1.addItem(DiasSemana.Sabado);
        comboDia1.addItem(DiasSemana.Domingo);

        comboDia2.removeAllItems();
        //comboDia2.addItem(DiasSemana.Lunes);
        comboDia2.addItem(DiasSemana.Martes);
        comboDia2.addItem(DiasSemana.Miercoles);
        comboDia2.addItem(DiasSemana.Jueves);
        comboDia2.addItem(DiasSemana.Viernes);
        comboDia2.addItem(DiasSemana.Sabado);
        comboDia2.addItem(DiasSemana.Domingo);


        actualizaListaPorCategoria();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        botonCancelar = new javax.swing.JButton();
        botonAceptar = new javax.swing.JButton();
        comboTemp = new javax.swing.JComboBox();
        comboEnt = new javax.swing.JComboBox();
        comboCat = new javax.swing.JComboBox();
        textMin = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        textHora = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfBuscarEnt = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jlAlumnos = new javax.swing.JList();
        jLabel5 = new javax.swing.JLabel();
        tfBuscarAl = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        labelSelecc = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        labelAnadir = new javax.swing.JLabel();
        botonAnadir = new javax.swing.JButton();
        botonQuitar = new javax.swing.JButton();
        labelError = new javax.swing.JLabel();
        comboDia1 = new javax.swing.JComboBox();
        comboDia2 = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        comboInst = new javax.swing.JComboBox();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nuevo Grupo");
        setResizable(false);

        jLabel1.setText("Introducir los datos para crear un nuevo Grupo de Entrenamiento");

        botonCancelar.setText("Cancelar");
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });

        botonAceptar.setText("Aceptar");
        botonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAceptarActionPerformed(evt);
            }
        });

        comboTemp.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-Temporada-", "12/13", "13/14", "14/15" }));

        comboEnt.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-Entrenador-", "Raul G. D.", "Paco S. J." }));
        comboEnt.setMinimumSize(new java.awt.Dimension(174, 20));
        comboEnt.setPreferredSize(new java.awt.Dimension(174, 20));

        comboCat.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-Categoria-", "Benjamin", "Alevin", "Infantil", "Cadete", "Junior" }));
        comboCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCatActionPerformed(evt);
            }
        });

        textMin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textMinKeyTyped(evt);
            }
        });

        jLabel2.setText(":");

        textHora.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textHoraKeyTyped(evt);
            }
        });

        jLabel3.setText("Horario");

        jLabel4.setText("Entrenador");

        tfBuscarEnt.setText("Buscar...");
        tfBuscarEnt.setMinimumSize(new java.awt.Dimension(70, 20));
        tfBuscarEnt.setPreferredSize(new java.awt.Dimension(70, 20));
        tfBuscarEnt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tfBuscarEntMouseClicked(evt);
            }
        });
        tfBuscarEnt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfBuscarEntKeyTyped(evt);
            }
        });

        jlAlumnos.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jlAlumnos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlAlumnosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jlAlumnos);

        jLabel5.setText("Alumnos");

        tfBuscarAl.setText("Buscar...");
        tfBuscarAl.setMinimumSize(new java.awt.Dimension(70, 20));
        tfBuscarAl.setPreferredSize(new java.awt.Dimension(70, 20));
        tfBuscarAl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tfBuscarAlMouseClicked(evt);
            }
        });
        tfBuscarAl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfBuscarAlKeyTyped(evt);
            }
        });

        jLabel6.setText("Seleccionados:");

        labelSelecc.setText("0");

        jLabel8.setText("Añadidos: ");

        labelAnadir.setText("0");

        botonAnadir.setText("Añadir");
        botonAnadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAnadirActionPerformed(evt);
            }
        });

        botonQuitar.setText("Quitar");

        labelError.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labelError.setForeground(new java.awt.Color(255, 0, 0));
        labelError.setText("Se ha superado el maximo por grupo");

        comboDia1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboDia1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboDia1ActionPerformed(evt);
            }
        });

        comboDia2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel7.setText("Dia 1");

        jLabel9.setText("Dia 2");

        jLabel10.setText("(hh:mm)");

        jLabel11.setText("Instalacion");

        comboInst.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboInst.setMinimumSize(new java.awt.Dimension(117, 20));
        comboInst.setPreferredSize(new java.awt.Dimension(117, 20));
        comboInst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboInstActionPerformed(evt);
            }
        });

        jTextField1.setText("Buscar...");
        jTextField1.setMinimumSize(new java.awt.Dimension(70, 20));
        jTextField1.setPreferredSize(new java.awt.Dimension(70, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(comboTemp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(comboCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfBuscarEnt, javax.swing.GroupLayout.DEFAULT_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)
                                    .addComponent(tfBuscarAl, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboEnt, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelError)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(botonAceptar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(botonCancelar))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(labelAnadir))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(labelSelecc))
                                    .addComponent(jLabel11)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(botonAnadir)
                                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(comboInst, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(botonQuitar)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboDia1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel10))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(comboDia2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(textHora, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textMin, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboTemp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(comboInst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboDia1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboDia2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfBuscarEnt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboEnt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(jLabel5)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfBuscarAl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(botonAnadir)
                                .addComponent(botonQuitar)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelError)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(labelSelecc))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(labelAnadir)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonCancelar)
                    .addComponent(botonAceptar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAceptarActionPerformed
        Integer a = Integer.parseInt(textHora.getText().toString());
        Integer a1 = Integer.parseInt(textMin.getText().toString());
        String cadena = "";
        if (!(a > 0 && a < 23) || !(a1 > 0 && a1 < 59)) {
            if (!(a1 > 0 && a1 < 59)) {

                cadena += "Los minutos introducidos no son validos\n";
            }
            if (!(a > 0 && a < 23)) {

                cadena += "La hora introducida no es valida";
            }

            JOptionPane.showMessageDialog(this,
                    cadena, "Error",
                    JOptionPane.ERROR_MESSAGE);
        } else {

            if (textHora.getText().length() == 2 && textMin.getText().length() == 2) {
                if (textHora.getText() != null && !Character.isLetter(textHora.getText().charAt(0))
                        && !Character.isLetter(textHora.getText().charAt(1))
                        && textMin.getText() != null && !Character.isLetter(textMin.getText().charAt(0))
                        && !Character.isLetter(textMin.getText().charAt(1))) {
                    try {
                        GestorGrupos.insertarDatosGrupo(this.bd, listaAlumnos,
                                comboTemp.getSelectedItem().toString(), comboCat.getSelectedItem().toString(),
                                comboDia1.getSelectedItem().toString(),
                                comboDia2.getSelectedItem().toString(), textHora.getText(), textMin.getText(),
                                comboEnt.getSelectedItem().toString(), comboInst.getSelectedItem().toString());

                    } catch (ParseException | SQLException ex) {
                        Logger.getLogger(NuevoGrupo.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    /* Actualizar la tabla de grupos */
                    try {
                        pP.actualizaTablaGrupos();
                    } catch (SQLException ex) {
                        Logger.getLogger(NuevoGrupo.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    this.dispose();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Error en los campos de la hora", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_botonAceptarActionPerformed

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_botonCancelarActionPerformed

    private void tfBuscarEntMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfBuscarEntMouseClicked
        tfBuscarEnt.setText("");
        tfBuscarEnt.requestFocus();
    }//GEN-LAST:event_tfBuscarEntMouseClicked

    private void tfBuscarEntKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfBuscarEntKeyTyped
        String sEnt = tfBuscarEnt.getText();
        List<String> ents = pP.getListaEntrenadores(sEnt);

        actualizaComboEntrenadores(ents);

    }//GEN-LAST:event_tfBuscarEntKeyTyped

    private void tfBuscarAlMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfBuscarAlMouseClicked
        if ("Buscar...".equals(tfBuscarAl.getText())) {
            tfBuscarAl.setText("");
        }
        tfBuscarAl.requestFocus();
    }//GEN-LAST:event_tfBuscarAlMouseClicked

    private void tfBuscarAlKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfBuscarAlKeyTyped
        List<String> als = new ArrayList<>();
        String s = tfBuscarAl.getText();

        try {
            als = pP.getListaAlumnos(s);
        } catch (SQLException ex) {
            Logger.getLogger(NuevoGrupo.class.getName()).log(Level.SEVERE, null, ex);
        }
        actualizaModeloLista(als);
    }//GEN-LAST:event_tfBuscarAlKeyTyped

    private void jlAlumnosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlAlumnosMouseClicked
        int[] n = jlAlumnos.getSelectedIndices();
        String auxN = Integer.toString(n.length);
        auxN = auxN.concat("/" + (Integer.toString(20 - listaAlumnos.size())));

        if (n.length > (20 - listaAlumnos.size())) {
            labelSelecc.setForeground(Color.red);
            labelError.setVisible(true);
            botonAnadir.setEnabled(false);
        } else {
            labelSelecc.setForeground(Color.BLACK);
            labelError.setVisible(false);
            botonAnadir.setEnabled(true);
        }

        labelSelecc.setText(auxN);
    }//GEN-LAST:event_jlAlumnosMouseClicked

    private void botonAnadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAnadirActionPerformed
        List<String> alsTotales;
        List<String> auxiliarAlumnosNuevos = new ArrayList();
        auxiliarAlumnosNuevos.addAll(jlAlumnos.getSelectedValuesList());
        for (int i = 0; i < auxiliarAlumnosNuevos.size(); i++) {
            if (!listaAlumnos.contains(auxiliarAlumnosNuevos.get(i))) {
                listaAlumnos.add(auxiliarAlumnosNuevos.get(i));
            }
        }

        alsTotales = alumnosCat;
        alsTotales.removeAll(listaAlumnos);

        actualizaModeloLista(alsTotales);

        labelAnadir.setText(Integer.toString(listaAlumnos.size()) + "/20");
        labelSelecc.setText("0/" + (20 - listaAlumnos.size()));

        //actualizaModeloLista(listaAlumnos);
    }//GEN-LAST:event_botonAnadirActionPerformed

    private void textHoraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textHoraKeyTyped
        if (textHora.getText().length() >= 2) {
            evt.consume();
        }
    }//GEN-LAST:event_textHoraKeyTyped

    private void textMinKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textMinKeyTyped
        if (textMin.getText().length() >= 2) {
            evt.consume();
        }
    }//GEN-LAST:event_textMinKeyTyped

    private void comboInstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboInstActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboInstActionPerformed

    private void comboCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCatActionPerformed

        if (bd != null && comboCat.getItemAt(0) != null) {
            //List<String> lista = new ArrayList<String>();

            try {
                int anio = GestorCategorias.getAnioCategoria(bd, comboCat.getSelectedItem().toString());
                listaAlumnos = new ArrayList();
                //lista = GestorAlumnos.getAlumnosCategoria(bd, anio);
                String[] tempo= comboTemp.getSelectedItem().toString().split("/");
                alumnosCat = GestorAlumnos.getAlumnosCategoria(bd, anio,Integer.parseInt(tempo[0]));
                labelAnadir.setText(Integer.toString(listaAlumnos.size()) + "/20");
                labelSelecc.setText("0/" + (20 - listaAlumnos.size()));
                actualizaModeloLista(alumnosCat);

            } catch (SQLException ex) {
                Logger.getLogger(NuevoGrupo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_comboCatActionPerformed

    private void comboDia1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboDia1ActionPerformed

        if (comboDia1.getSelectedItem() != null) {

            String dia = comboDia1.getSelectedItem().toString();

            comboDia2.removeAllItems();
            if (!DiasSemana.Lunes.toString().equals(dia)) {
                comboDia2.addItem(DiasSemana.Lunes);
            }
            if (!DiasSemana.Martes.toString().equals(dia)) {
                comboDia2.addItem(DiasSemana.Martes);
            }
            if (!DiasSemana.Miercoles.toString().equals(dia)) {
                comboDia2.addItem(DiasSemana.Miercoles);
            }
            if (!DiasSemana.Jueves.toString().equals(dia)) {
                comboDia2.addItem(DiasSemana.Jueves);
            }
            if (!DiasSemana.Viernes.toString().equals(dia)) {
                comboDia2.addItem(DiasSemana.Viernes);
            }
            if (!DiasSemana.Sabado.toString().equals(dia)) {
                comboDia2.addItem(DiasSemana.Sabado);
            }
            if (!DiasSemana.Domingo.toString().equals(dia)) {
                comboDia2.addItem(DiasSemana.Domingo);
            }
        }


    }//GEN-LAST:event_comboDia1ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAceptar;
    private javax.swing.JButton botonAnadir;
    private javax.swing.JButton botonCancelar;
    private javax.swing.JButton botonQuitar;
    private javax.swing.JComboBox comboCat;
    private javax.swing.JComboBox comboDia1;
    private javax.swing.JComboBox comboDia2;
    private javax.swing.JComboBox comboEnt;
    private javax.swing.JComboBox comboInst;
    private javax.swing.JComboBox comboTemp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JList jlAlumnos;
    private javax.swing.JLabel labelAnadir;
    private javax.swing.JLabel labelError;
    private javax.swing.JLabel labelSelecc;
    private javax.swing.JTextField textHora;
    private javax.swing.JTextField textMin;
    private javax.swing.JTextField tfBuscarAl;
    private javax.swing.JTextField tfBuscarEnt;
    // End of variables declaration//GEN-END:variables

    private void actualizaComboTemp(List<String> temps) throws SQLException {
        comboTemp.removeAllItems();
        for (String s : temps) {
            comboTemp.addItem(s);
        }

    }

    private void actualizaComboCat(List<String> temps) throws SQLException {
        comboCat.removeAllItems();
        for (String s : temps) {
            comboCat.addItem(s);
        }
    }

    private void actualizaModeloLista(List<String> temps) {
        DefaultListModel modelo = new DefaultListModel();
        for (String s : temps) {
            modelo.addElement(s);
        }

        jlAlumnos.removeAll();
        jlAlumnos.setModel(modelo);
    }

    private void actualizaComboEntrenadores(List<String> ents) {
        comboEnt.removeAllItems();

        for (String s : ents) {
            comboEnt.addItem(s);
        }
    }

    private void actualizaComboInstalaciones(List<String> inst) {
        comboInst.removeAllItems();

        for (String s : inst) {
            comboInst.addItem(s);
        }
    }

    private void actualizaListaPorCategoria() {
        List<String> auxList;

        if (bd != null && comboCat.getItemAt(0) != null) {

            try {
                int anio = GestorCategorias.getAnioCategoria(bd, comboCat.getSelectedItem().toString());
                String[] tempo= comboTemp.getSelectedItem().toString().split("/");
                auxList = GestorAlumnos.getAlumnosCategoria(bd, anio,Integer.parseInt(tempo[0]));

                actualizaModeloLista(auxList);

            } catch (SQLException ex) {
                Logger.getLogger(NuevoGrupo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
