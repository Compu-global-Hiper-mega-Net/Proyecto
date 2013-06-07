/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfazUsuario;

import GestionDeAlumnos.Alumno;
import GestionDeAlumnos.GestorAlumnos;
import GestionDeCategorias.GestorCategorias;
import GestionDeGrupos.GestorGrupos;
import GestionDeGrupos.Grupo;
import ServiciosAlmacenamiento.BaseDatos;
import bma.DiasSemana;
import java.awt.Color;
import java.awt.Dimension;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;

/**
 *
 * @author Diego
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
public class ConsultarGrupo extends javax.swing.JFrame {

    private PrincipalGrupos pP;
    private BaseDatos bd;
    private List<String> listaAlumnos;
    private String idGrupo;
    private String temp;
    private String cat;
    private String hora1;
    private String hora2;
    private String min;
    private String dia1;
    private String dia2;
    private String inst;
    private String ent;
    private boolean avanzadas;
    private List<String> alumnosCat;
    private List<String> listaAlumnosIntroducidos;

    /**
     * Creates new form ConsultarGrupo
     */
    public ConsultarGrupo() {
        initComponents();
    }

    public ConsultarGrupo(PrincipalGrupos v, String idG) throws SQLException {
        initComponents();
        setLocationRelativeTo(v);
        pP = v;
        this.idGrupo = idG;

        this.bd = v.getBd();

        //alumnosSel = new ArrayList<Alumno>();
        listaAlumnos = new ArrayList<>();

        temp = GestorGrupos.getTemporada(this.bd, idGrupo);
        cat = GestorGrupos.getCategoria(this.bd, idGrupo);
        hora1 = GestorGrupos.getHora1(this.bd, idGrupo);
        hora2 = GestorGrupos.getHora2(this.bd, idGrupo);
        dia1 = GestorGrupos.getDia1(this.bd, idGrupo);
        dia2 = GestorGrupos.getDia2(this.bd, idGrupo);
        inst = GestorGrupos.getInstalacion(this.bd, idGrupo);
        ent = GestorGrupos.getEntrenador(this.bd, idGrupo);

        labelTemp.setText(temp);
        labelCat.setText(cat);
        labelHora1.setText(hora1);
        labelHora2.setText(hora2);
        labelDia1.setText(dia1);
        labelDia2.setText(dia2);
        labelInstalacion.setText(inst);
        labelEntrenador.setText(ent);

        List<String> aux = pP.getlistaAlumnosIntroducidos(idGrupo);
        labelFijados.setText(Integer.toString(aux.size()));
        actualizaListaAlumnosIntroducidos(aux);

        listaAlumnosIntroducidos = aux;

        aux = pP.getListaTemps();
        actualizaComboTemp(aux);

        //aux = creador.getListaCategorias();
        aux = GestorCategorias.getTipoCategorias(this.bd);
        actualizaComboCat(aux);

        //aux = creador.getListaAlumnos("");
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
        comboDia2.addItem(DiasSemana.Lunes);
        comboDia2.addItem(DiasSemana.Martes);
        comboDia2.addItem(DiasSemana.Miercoles);
        comboDia2.addItem(DiasSemana.Jueves);
        comboDia2.addItem(DiasSemana.Viernes);
        comboDia2.addItem(DiasSemana.Sabado);
        comboDia2.addItem(DiasSemana.Domingo);

        comboEnt.setSelectedItem(ent);
        comboInst.setSelectedItem(inst);

        String auxHora = hora1.substring(0, hora1.indexOf(":"));
        textHora.setText(auxHora);
        auxHora = hora1;
        auxHora = auxHora.substring(auxHora.indexOf(":") + 1, auxHora.indexOf(":") + 3);
        min = auxHora;
        //fila[0] = aux.substring(0, aux.indexOf(","));
        //aux = aux.substring(aux.indexOf(",")+1, aux.length());
        textMin.setText(auxHora);
        comboDia1.setSelectedIndex(DiasSemana.getNumeroDia(dia1));
        comboDia2.setSelectedIndex(DiasSemana.getNumeroDia(dia2));

        avanzadas = false;
        panelAvanzadas.setVisible(false);

        actualizaListaPorCategoria();

        //listaAlumnosIntroducidos = GestorGrupos.getListaAlumnosIntroducidos(bd, idGrupo);
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
        labelTemp = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        labelCat = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        labelDia1 = new javax.swing.JLabel();
        labelHora1 = new javax.swing.JLabel();
        labelDia2 = new javax.swing.JLabel();
        labelHora2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        labelInstalacion = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        jlAlumIntr = new javax.swing.JList();
        tfBuscarAlIntr = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        botonQuitarAlumno = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        labelEntrenador = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        labelFijados = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        panelAvanzadas = new javax.swing.JPanel();
        comboTemp = new javax.swing.JComboBox();
        comboCat = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        comboDia1 = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        comboDia2 = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        textHora = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        textMin = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        comboInst = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        tfBuscarEnt = new javax.swing.JTextField();
        comboEnt = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        tfBuscarAl = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jlAlumnos = new javax.swing.JList();
        botonAnadir = new javax.swing.JButton();
        botonQuitar = new javax.swing.JButton();
        labelError = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        labelSelecc = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        labelAnadir = new javax.swing.JLabel();
        botonCancelar = new javax.swing.JButton();
        botonAceptar = new javax.swing.JButton();
        botonAvanzadas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(605, 675));
        setPreferredSize(new java.awt.Dimension(605, 300));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Temporada:");

        labelTemp.setText("jLabel2");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Categoria:");

        labelCat.setText("jLabel3");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Horario:");

        labelDia1.setText("jLabel5");

        labelHora1.setText("jLabel5");

        labelDia2.setText("jLabel5");

        labelHora2.setText("jLabel5");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Instalacion:");

        labelInstalacion.setText("jLabel6");

        jlAlumIntr.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jlAlumIntr.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(jlAlumIntr);

        tfBuscarAlIntr.setText("Buscar...");
        tfBuscarAlIntr.setMinimumSize(new java.awt.Dimension(70, 20));
        tfBuscarAlIntr.setPreferredSize(new java.awt.Dimension(70, 20));
        tfBuscarAlIntr.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tfBuscarAlIntrMouseClicked(evt);
            }
        });
        tfBuscarAlIntr.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfBuscarAlIntrKeyTyped(evt);
            }
        });

        jLabel16.setText("Alumnos:");

        botonQuitarAlumno.setText("Quitar");
        botonQuitarAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonQuitarAlumnoActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setText("Datos ya introducidos");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setText("Entrenador:");

        labelEntrenador.setText("jLabel19");

        jButton1.setText("Aceptar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        labelFijados.setText("0");

        jLabel20.setText("/20");

        panelAvanzadas.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        comboTemp.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        comboCat.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCatActionPerformed(evt);
            }
        });

        jLabel9.setText("Horario");

        jLabel14.setText("Dia 1");

        comboDia1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel13.setText("Dia 2");

        comboDia2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel12.setText("(hh:mm)");

        textHora.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textHoraKeyTyped(evt);
            }
        });

        jLabel10.setText(":");

        textMin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textMinKeyTyped(evt);
            }
        });

        jLabel11.setText("Instalacion");

        jTextField1.setText("Buscar...");
        jTextField1.setMinimumSize(new java.awt.Dimension(70, 20));
        jTextField1.setPreferredSize(new java.awt.Dimension(70, 20));

        comboInst.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboInst.setMinimumSize(new java.awt.Dimension(174, 20));
        comboInst.setPreferredSize(new java.awt.Dimension(174, 20));

        jLabel8.setText("Entrenador");

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

        comboEnt.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-Entrenador-", "Raul G. D.", "Paco S. J." }));
        comboEnt.setMinimumSize(new java.awt.Dimension(174, 20));
        comboEnt.setPreferredSize(new java.awt.Dimension(174, 20));

        jLabel7.setText("Alumnos");

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

        jLabel6.setText("Seleccionados:");

        labelSelecc.setText("0");

        jLabel15.setText("Añadidos: ");

        labelAnadir.setText("0");

        botonCancelar.setText("Cancelar");
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });

        botonAceptar.setText("Modificar");
        botonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelAvanzadasLayout = new javax.swing.GroupLayout(panelAvanzadas);
        panelAvanzadas.setLayout(panelAvanzadasLayout);
        panelAvanzadasLayout.setHorizontalGroup(
            panelAvanzadasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAvanzadasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAvanzadasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelAvanzadasLayout.createSequentialGroup()
                        .addGroup(panelAvanzadasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelAvanzadasLayout.createSequentialGroup()
                                .addComponent(comboTemp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel9)
                            .addGroup(panelAvanzadasLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(panelAvanzadasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(panelAvanzadasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(comboDia1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel14))
                                    .addGroup(panelAvanzadasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(tfBuscarEnt, javax.swing.GroupLayout.DEFAULT_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel8)
                                        .addComponent(jLabel7)
                                        .addComponent(tfBuscarAl, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelAvanzadasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelAvanzadasLayout.createSequentialGroup()
                                        .addGroup(panelAvanzadasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(panelAvanzadasLayout.createSequentialGroup()
                                                .addComponent(jLabel13)
                                                .addGap(51, 51, 51)
                                                .addComponent(jLabel12))
                                            .addGroup(panelAvanzadasLayout.createSequentialGroup()
                                                .addComponent(comboDia2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(textHora, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(textMin, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(28, 28, 28)
                                        .addGroup(panelAvanzadasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(panelAvanzadasLayout.createSequentialGroup()
                                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(comboInst, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel11)))
                                    .addComponent(comboEnt, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panelAvanzadasLayout.createSequentialGroup()
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(panelAvanzadasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(panelAvanzadasLayout.createSequentialGroup()
                                                .addComponent(botonAnadir)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(botonQuitar))
                                            .addComponent(labelError)
                                            .addGroup(panelAvanzadasLayout.createSequentialGroup()
                                                .addComponent(jLabel6)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(labelSelecc))
                                            .addGroup(panelAvanzadasLayout.createSequentialGroup()
                                                .addComponent(jLabel15)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(labelAnadir)))))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAvanzadasLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(botonAceptar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonCancelar)))
                .addContainerGap())
        );
        panelAvanzadasLayout.setVerticalGroup(
            panelAvanzadasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAvanzadasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAvanzadasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboTemp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelAvanzadasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel13)
                    .addComponent(jLabel12)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelAvanzadasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboDia1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboDia2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(textMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboInst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelAvanzadasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfBuscarEnt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboEnt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelAvanzadasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfBuscarAl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelAvanzadasLayout.createSequentialGroup()
                        .addGroup(panelAvanzadasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botonAnadir)
                            .addComponent(botonQuitar))
                        .addGap(18, 18, 18)
                        .addComponent(labelError)
                        .addGap(18, 18, 18)
                        .addGroup(panelAvanzadasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(labelSelecc))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelAvanzadasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(labelAnadir))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(panelAvanzadasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonCancelar)
                    .addComponent(botonAceptar))
                .addContainerGap())
        );

        botonAvanzadas.setText("Avanzadas ↓↓");
        botonAvanzadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAvanzadasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(panelAvanzadas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelInstalacion))
                            .addComponent(jLabel17))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(labelDia1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(labelHora1))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(labelDia2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(labelHora2))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelCat)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tfBuscarAlIntr, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelTemp)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(115, 115, 115)
                                        .addComponent(botonAvanzadas))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(146, 146, 146)
                                        .addComponent(jLabel16))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelEntrenador)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(botonQuitarAlumno)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(labelFijados)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel20)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton1)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17)
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(labelTemp)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(labelCat)
                            .addComponent(tfBuscarAlIntr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(labelDia1)
                            .addComponent(labelHora1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelDia2)
                            .addComponent(labelHora2))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(labelEntrenador))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(labelInstalacion)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(botonQuitarAlumno)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(labelFijados)
                                .addComponent(jLabel20)))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonAvanzadas)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelAvanzadas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void tfBuscarEntMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfBuscarEntMouseClicked
        tfBuscarEnt.setText("");
        tfBuscarEnt.requestFocus();
    }//GEN-LAST:event_tfBuscarEntMouseClicked

    private void tfBuscarEntKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfBuscarEntKeyTyped
        String sEnt = tfBuscarEnt.getText();
        List<String> ents = pP.getListaEntrenadores(sEnt);

        actualizaComboEntrenadores(ents);

    }//GEN-LAST:event_tfBuscarEntKeyTyped

    private void botonAnadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAnadirActionPerformed
        List<String> auxiliarAlumnosNuevos = new ArrayList();
        auxiliarAlumnosNuevos.addAll(jlAlumnos.getSelectedValuesList());
        for (int i = 0; i < auxiliarAlumnosNuevos.size(); i++) {
            if (!listaAlumnos.contains(auxiliarAlumnosNuevos.get(i))) {
                listaAlumnos.add(auxiliarAlumnosNuevos.get(i));
            }
        }
        labelAnadir.setText(Integer.toString(listaAlumnos.size()) + "/20");
        labelSelecc.setText("0/" + (20 - listaAlumnos.size()));

    }//GEN-LAST:event_botonAnadirActionPerformed

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_botonCancelarActionPerformed

    private void tfBuscarAlIntrMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfBuscarAlIntrMouseClicked
        if ("Buscar...".equals(tfBuscarAlIntr.getText())) {
            tfBuscarAlIntr.setText("");
        }
        tfBuscarAlIntr.requestFocus();
    }//GEN-LAST:event_tfBuscarAlIntrMouseClicked

    private void tfBuscarAlIntrKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfBuscarAlIntrKeyTyped
        List<String> als = new ArrayList<>();
        String s = tfBuscarAlIntr.getText();

        try {
            als = pP.getListaAlumnos(s);
        } catch (SQLException ex) {
            Logger.getLogger(NuevoGrupo.class.getName()).log(Level.SEVERE, null, ex);
        }
        //actualizaModeloListaAlumnosIntroducidos(als);
    }//GEN-LAST:event_tfBuscarAlIntrKeyTyped

    private void botonQuitarAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonQuitarAlumnoActionPerformed
        String alumno = (String) jlAlumIntr.getSelectedValue();
        int idAl = 0;
        try {
            idAl = GestorAlumnos.getIdAl(this.bd, alumno);
        } catch (SQLException ex) {
            Logger.getLogger(ConsultarGrupo.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            GestorGrupos.eliminarAlumnoIntroducido(this.bd, Integer.parseInt(idGrupo), idAl);
        } catch (SQLException ex) {
            Logger.getLogger(ConsultarGrupo.class.getName()).log(Level.SEVERE, null, ex);
        }

        List<String> aux1 = new ArrayList<String>();
        List<String> aux2 = new ArrayList<String>();
        try {
            aux1 = pP.getlistaAlumnosIntroducidos(idGrupo);
            aux2 = pP.getListaAlumnosSinGrupo("");
        } catch (SQLException ex) {
            Logger.getLogger(ConsultarGrupo.class.getName()).log(Level.SEVERE, null, ex);
        }

        actualizaListaAlumnosIntroducidos(aux1);
        actualizaModeloLista(aux2);
        labelFijados.setText(Integer.toString(aux1.size()));

        try {
            pP.actualizaTablaGrupos();
        } catch (SQLException ex) {
            Logger.getLogger(ConsultarGrupo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_botonQuitarAlumnoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void botonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAceptarActionPerformed
        /*String temp = GestorGrupos.getTemporada(creador.accesoBD, idGrupo);
         String cat = GestorGrupos.getCategoria(creador.accesoBD, idGrupo);
         String hora1 = GestorGrupos.getHora1(creador.accesoBD, idGrupo);
         String hora2 = GestorGrupos.getHora2(creador.accesoBD, idGrupo);
         String dia1 = GestorGrupos.getDia1(creador.accesoBD, idGrupo);
         String dia2 = GestorGrupos.getDia2(creador.accesoBD, idGrupo);
         String inst = GestorGrupos.getInstalacion(creador.accesoBD, idGrupo);
         String ent = GestorGrupos.getEntrenador(creador.accesoBD, idGrupo);*/

        Grupo gViejo = null;
        Grupo gNuevo = null;
        try {
            gNuevo = new Grupo(comboTemp.getSelectedItem().toString(),
                    comboDia1.getSelectedItem().toString(),
                    comboDia2.getSelectedItem().toString(),
                    textHora.getText(), textMin.getText(),
                    comboEnt.getSelectedItem().toString(), comboCat.getSelectedItem().toString(), comboInst.getSelectedItem().toString());
            gViejo = new Grupo(temp, dia1, dia2, hora1, min, ent, cat, inst);
        } catch (ParseException ex) {
            Logger.getLogger(ConsultarGrupo.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            GestorGrupos.modificarGrupo(this.bd, gNuevo, gViejo, idGrupo, listaAlumnos);
        } catch (SQLException ex) {
            Logger.getLogger(ConsultarGrupo.class.getName()).log(Level.SEVERE, null, ex);
        }


        try {
            pP.actualizaTablaGrupos();
        } catch (SQLException ex) {
            Logger.getLogger(ConsultarGrupo.class.getName()).log(Level.SEVERE, null, ex);
        }


        this.setVisible(false);
    }//GEN-LAST:event_botonAceptarActionPerformed

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

    private void botonAvanzadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAvanzadasActionPerformed
        if (avanzadas == false) {
            panelAvanzadas.setVisible(true);
            Dimension d = new Dimension(605, 680);
            this.setMaximumSize(d);
            this.setPreferredSize(d);
            this.setMinimumSize(d);
            this.setSize(d);
            this.setLocationRelativeTo(pP);
            avanzadas = true;
        } else {
            panelAvanzadas.setVisible(false);
            Dimension d = new Dimension(605, 300);
            this.setMaximumSize(d);
            this.setPreferredSize(d);
            this.setMinimumSize(d);
            this.setSize(d);

            this.setLocationRelativeTo(pP);
            avanzadas = false;
        }
    }//GEN-LAST:event_botonAvanzadasActionPerformed

    private void comboCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCatActionPerformed

        if (bd != null && comboCat.getItemAt(0) != null) {
            List<String> lista = new ArrayList<String>();

            try {
                int anio = GestorCategorias.getAnioCategoria(bd, comboCat.getSelectedItem().toString());

                //lista = GestorAlumnos.getAlumnosCategoria(bd, anio);
                alumnosCat = GestorAlumnos.getAlumnosCategoria(bd, anio);

                //actualizaModeloLista(alumnosCat);
                actualizaListaPorCategoria();

            } catch (SQLException ex) {
                Logger.getLogger(NuevoGrupo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_comboCatActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAceptar;
    private javax.swing.JButton botonAnadir;
    private javax.swing.JButton botonAvanzadas;
    private javax.swing.JButton botonCancelar;
    private javax.swing.JButton botonQuitar;
    private javax.swing.JButton botonQuitarAlumno;
    private javax.swing.JComboBox comboCat;
    private javax.swing.JComboBox comboDia1;
    private javax.swing.JComboBox comboDia2;
    private javax.swing.JComboBox comboEnt;
    private javax.swing.JComboBox comboInst;
    private javax.swing.JComboBox comboTemp;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JList jlAlumIntr;
    private javax.swing.JList jlAlumnos;
    private javax.swing.JLabel labelAnadir;
    private javax.swing.JLabel labelCat;
    private javax.swing.JLabel labelDia1;
    private javax.swing.JLabel labelDia2;
    private javax.swing.JLabel labelEntrenador;
    private javax.swing.JLabel labelError;
    private javax.swing.JLabel labelFijados;
    private javax.swing.JLabel labelHora1;
    private javax.swing.JLabel labelHora2;
    private javax.swing.JLabel labelInstalacion;
    private javax.swing.JLabel labelSelecc;
    private javax.swing.JLabel labelTemp;
    private javax.swing.JPanel panelAvanzadas;
    private javax.swing.JTextField textHora;
    private javax.swing.JTextField textMin;
    private javax.swing.JTextField tfBuscarAl;
    private javax.swing.JTextField tfBuscarAlIntr;
    private javax.swing.JTextField tfBuscarEnt;
    // End of variables declaration//GEN-END:variables

    private void actualizaModeloLista(List<String> als) {
        DefaultListModel modelo = new DefaultListModel();
        for (String s : als) {
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

    private void actualizaComboTemp(List<String> aux) {
        comboTemp.removeAllItems();
        for (String s : aux) {
            comboTemp.addItem(s);
        }
    }

    private void actualizaComboCat(List<String> aux) {
        comboCat.removeAllItems();
        for (String s : aux) {
            comboCat.addItem(s);
        }
    }

    private void actualizaComboInstalaciones(List<String> aux) {
        comboInst.removeAllItems();

        for (String s : aux) {
            comboInst.addItem(s);
        }
    }

    private void actualizaModeloListaAlumnosIntroducidos(List<String> als) {
        DefaultListModel modelo = new DefaultListModel();
        for (String s : als) {
            modelo.addElement(s);
        }

        jlAlumIntr.removeAll();
        jlAlumIntr.setModel(modelo);
    }

    private void actualizaListaAlumnosIntroducidos(List<String> als) {
        DefaultListModel modelo = new DefaultListModel();
        for (String s : als) {
            modelo.addElement(s);
        }

        jlAlumIntr.removeAll();
        jlAlumIntr.setModel(modelo);
    }

    private void actualizaListaPorCategoria() {
        List<String> auxList = new ArrayList<String>();

        if (bd != null && comboCat.getItemAt(0) != null) {

            try {
                int anio = GestorCategorias.getAnioCategoria(bd, comboCat.getSelectedItem().toString());
                alumnosCat = GestorAlumnos.getAlumnosCategoria(bd, anio);

                auxList = alumnosCat;

                auxList.removeAll(listaAlumnosIntroducidos);

                actualizaModeloLista(alumnosCat);

            } catch (SQLException ex) {
                Logger.getLogger(NuevoGrupo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
