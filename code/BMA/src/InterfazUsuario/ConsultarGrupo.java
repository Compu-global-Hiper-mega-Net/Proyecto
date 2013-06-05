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
import GestionDeGrupos.GruposBD;
import bma.DiasSemana;
import java.awt.Color;
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

    private PantallaPrincipal creador;
    private List<Alumno> alumnosSel;
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
    

    /**
     * Creates new form ConsultarGrupo
     */
    public ConsultarGrupo() {
        initComponents();
    }
    
    public ConsultarGrupo(PantallaPrincipal v, String idG) throws SQLException {
        initComponents();
        this.setLocation(250, 100);
        creador = v;
        this.idGrupo = idG;
        
        //alumnosSel = new ArrayList<Alumno>();
        listaAlumnos = new ArrayList<String>();
        
        temp = GestorGrupos.getTemporada(creador.accesoBD, idGrupo);
        cat = GestorGrupos.getCategoria(creador.accesoBD, idGrupo);
        hora1 = GestorGrupos.getHora1(creador.accesoBD, idGrupo);
        hora2 = GestorGrupos.getHora2(creador.accesoBD, idGrupo);
        dia1 = GestorGrupos.getDia1(creador.accesoBD, idGrupo);
        dia2 = GestorGrupos.getDia2(creador.accesoBD, idGrupo);
        inst = GestorGrupos.getInstalacion(creador.accesoBD, idGrupo);
        ent = GestorGrupos.getEntrenador(creador.accesoBD, idGrupo);
        
        labelTemp.setText(temp);
        labelCat.setText(cat);
        labelHora1.setText(hora1);
        labelHora2.setText(hora2);
        labelDia1.setText(dia1);
        labelDia2.setText(dia2);
        labelInstalacion.setText(inst);
        labelEntrenador.setText(ent);
        
        List<String> aux = new ArrayList<String>();
        
        aux = creador.getlistaAlumnosIntroducidos(idGrupo);
        jLabel19.setText(Integer.toString(aux.size()));
        actualizaListaAlumnosIntroducidos(aux);
        
        aux = creador.getListaTemps();
        actualizaComboTemp(aux);
        
        //aux = creador.getListaCategorias();
        aux = GestorCategorias.getTipoCategorias(creador.accesoBD);
        actualizaComboCat(aux);
        
        //aux = creador.getListaAlumnos("");
        aux = creador.getListaAlumnosSinGrupo("");
        actualizaModeloLista(aux);
        
        aux = creador.getListaEntrenadores("");
        actualizaComboEntrenadores(aux);
        
        aux = creador.getListaInstalaciones("");
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
        
        String auxHora = "";
        auxHora = hora1.substring(0, hora1.indexOf(":"));
        textHora.setText(auxHora);
        auxHora = hora1;
        auxHora = auxHora.substring(auxHora.indexOf(":")+1, auxHora.indexOf(":")+3);
        min = auxHora;   
        //fila[0] = aux.substring(0, aux.indexOf(","));
        //aux = aux.substring(aux.indexOf(",")+1, aux.length());
        textMin.setText(auxHora);
        comboDia1.setSelectedIndex(DiasSemana.getNumeroDia(dia1));
        comboDia2.setSelectedIndex(DiasSemana.getNumeroDia(dia2));
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        comboTemp = new javax.swing.JComboBox();
        comboCat = new javax.swing.JComboBox();
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
        labelSelecc = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tfBuscarAl = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jlAlumnos = new javax.swing.JList();
        jLabel11 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        comboInst = new javax.swing.JComboBox();
        tfBuscarEnt = new javax.swing.JTextField();
        textHora = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        comboEnt = new javax.swing.JComboBox();
        textMin = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        comboDia2 = new javax.swing.JComboBox();
        comboDia1 = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        labelAnadir = new javax.swing.JLabel();
        botonAnadir = new javax.swing.JButton();
        botonQuitar = new javax.swing.JButton();
        labelError = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        botonCancelar = new javax.swing.JButton();
        botonAceptar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jlAlumIntr = new javax.swing.JList();
        tfBuscarAlIntr = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        botonQuitarAlumno = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        labelEntrenador = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        comboTemp.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        comboCat.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

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

        labelSelecc.setText("0");

        jLabel6.setText("Seleccionados:");

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

        jLabel7.setText("Alumnos");

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

        jLabel11.setText("Instalacion");

        jLabel8.setText("Entrenador");

        comboInst.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboInst.setMinimumSize(new java.awt.Dimension(174, 20));
        comboInst.setPreferredSize(new java.awt.Dimension(174, 20));

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

        textHora.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textHoraKeyTyped(evt);
            }
        });

        jLabel9.setText("Horario");

        jTextField1.setText("Buscar...");
        jTextField1.setMinimumSize(new java.awt.Dimension(70, 20));
        jTextField1.setPreferredSize(new java.awt.Dimension(70, 20));

        comboEnt.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-Entrenador-", "Raul G. D.", "Paco S. J." }));
        comboEnt.setMinimumSize(new java.awt.Dimension(174, 20));
        comboEnt.setPreferredSize(new java.awt.Dimension(174, 20));

        textMin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textMinKeyTyped(evt);
            }
        });

        jLabel10.setText(":");

        jLabel12.setText("(hh:mm)");

        comboDia2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        comboDia1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel13.setText("Dia 2");

        jLabel14.setText("Dia 1");

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

        jLabel15.setText("Añadidos: ");

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

        jLabel19.setText("jLabel19");

        jLabel20.setText("/20");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelInstalacion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addGap(38, 38, 38)
                                        .addComponent(jLabel13)
                                        .addGap(38, 38, 38)
                                        .addComponent(jLabel12)
                                        .addGap(80, 80, 80)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel11)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(comboInst, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(comboDia1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(tfBuscarEnt, javax.swing.GroupLayout.DEFAULT_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel8)
                                                .addComponent(jLabel7)
                                                .addComponent(tfBuscarAl, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(comboDia2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(textHora, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(textMin, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(comboEnt, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(labelError)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(botonAnadir)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(botonQuitar))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabel6)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(labelSelecc))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabel15)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addGroup(layout.createSequentialGroup()
                                                                .addComponent(labelAnadir)
                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                            .addGroup(layout.createSequentialGroup()
                                                                .addComponent(botonAceptar)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(botonCancelar))))))))))
                            .addComponent(jLabel17)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                        .addComponent(labelCat))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(labelTemp)
                                        .addGap(115, 115, 115)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tfBuscarAlIntr, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel16)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel18)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(labelEntrenador)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(botonQuitarAlumno)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel19)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel20))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(comboTemp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfBuscarAlIntr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(labelCat))
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
                                    .addComponent(labelEntrenador))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(labelInstalacion)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(botonQuitarAlumno)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel19)
                                    .addComponent(jLabel20)))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboTemp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel13)
                    .addComponent(jLabel12)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfBuscarEnt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboEnt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfBuscarAl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(botonAnadir)
                                    .addComponent(botonQuitar))
                                .addGap(18, 18, 18)
                                .addComponent(labelError)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(labelSelecc))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(labelAnadir))
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botonAceptar)
                            .addComponent(botonCancelar)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        List<String> als = new ArrayList<String>();
        String s = tfBuscarAl.getText();
        try {
            als = creador.getListaAlumnos(s);
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
        List<String> ents = new ArrayList<String>();

        String sEnt = tfBuscarEnt.getText();
        ents = creador.getListaEntrenadores(sEnt);

        actualizaComboEntrenadores(ents);

    }//GEN-LAST:event_tfBuscarEntKeyTyped

    private void botonAnadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAnadirActionPerformed
        listaAlumnos.addAll(jlAlumnos.getSelectedValuesList());
        labelAnadir.setText(Integer.toString(listaAlumnos.size()) + "/20");
        labelSelecc.setText("0/" + (20 - listaAlumnos.size()));

    }//GEN-LAST:event_botonAnadirActionPerformed

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_botonCancelarActionPerformed

    private void tfBuscarAlIntrMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfBuscarAlIntrMouseClicked
        if ("Buscar...".equals(tfBuscarAlIntr.getText())) {
            tfBuscarAlIntr.setText("");
        }
        tfBuscarAlIntr.requestFocus();
    }//GEN-LAST:event_tfBuscarAlIntrMouseClicked

    private void tfBuscarAlIntrKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfBuscarAlIntrKeyTyped
        List<String> als = new ArrayList<String>();
        String s = tfBuscarAlIntr.getText();
        
        try {
            als = creador.getListaAlumnos(s);
        } catch (SQLException ex) {
            Logger.getLogger(NuevoGrupo.class.getName()).log(Level.SEVERE, null, ex);
        }
        //actualizaModeloListaAlumnosIntroducidos(als);
    }//GEN-LAST:event_tfBuscarAlIntrKeyTyped

    private void botonQuitarAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonQuitarAlumnoActionPerformed
        String alumno = (String) jlAlumIntr.getSelectedValue();
        int idAl = 0;
        try {
            idAl = GestorAlumnos.getIdAl(creador.accesoBD, alumno);
        } catch (SQLException ex) {
            Logger.getLogger(ConsultarGrupo.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            GestorGrupos.eliminarAlumnoIntroducido(creador.accesoBD, Integer.parseInt(idGrupo), idAl);
        } catch (SQLException ex) {
            Logger.getLogger(ConsultarGrupo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        List<String> aux1 = new ArrayList<String>();
        List<String> aux2 = new ArrayList<String>();
        try {
            aux1 = creador.getlistaAlumnosIntroducidos(idGrupo);
            aux2 = creador.getListaAlumnosSinGrupo("");
        } catch (SQLException ex) {
            Logger.getLogger(ConsultarGrupo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        actualizaListaAlumnosIntroducidos(aux1);
        actualizaModeloLista(aux2);
        jLabel19.setText(Integer.toString(aux1.size()));
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
            GestorGrupos.modificarGrupo(creador.accesoBD, gNuevo, gViejo, idGrupo, listaAlumnos);
        } catch (SQLException ex) {
            Logger.getLogger(ConsultarGrupo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        try {
            creador.actualizaTablaGrupos();
        } catch (SQLException ex) {
            Logger.getLogger(ConsultarGrupo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        this.setVisible(false);
    }//GEN-LAST:event_botonAceptarActionPerformed

    private void textHoraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textHoraKeyTyped
        if(textHora.getText().length() >= 2)
            evt.consume();
    }//GEN-LAST:event_textHoraKeyTyped

    private void textMinKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textMinKeyTyped
        if(textMin.getText().length() >= 2)
            evt.consume();
    }//GEN-LAST:event_textMinKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ConsultarGrupo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultarGrupo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultarGrupo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultarGrupo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new ConsultarGrupo().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAceptar;
    private javax.swing.JButton botonAnadir;
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
    private javax.swing.JLabel jLabel19;
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
    private javax.swing.JLabel labelHora1;
    private javax.swing.JLabel labelHora2;
    private javax.swing.JLabel labelInstalacion;
    private javax.swing.JLabel labelSelecc;
    private javax.swing.JLabel labelTemp;
    private javax.swing.JTextField textHora;
    private javax.swing.JTextField textMin;
    private javax.swing.JTextField tfBuscarAl;
    private javax.swing.JTextField tfBuscarAlIntr;
    private javax.swing.JTextField tfBuscarEnt;
    // End of variables declaration//GEN-END:variables

    private void actualizaModeloLista(List<String> als) {
        DefaultListModel modelo = new DefaultListModel();
        for(String s : als)
            modelo.addElement(s);
        
        jlAlumnos.removeAll();
        jlAlumnos.setModel(modelo);
    }

    private void actualizaComboEntrenadores(List<String> ents) {
        comboEnt.removeAllItems();
        
        for(String s : ents)
            comboEnt.addItem(s);
    }

    private void actualizaComboTemp(List<String> aux) {
        comboTemp.removeAllItems();
        for(String s : aux)
            comboTemp.addItem(s);
    }

    private void actualizaComboCat(List<String> aux) {
        comboCat.removeAllItems();
        for(String s : aux)
            comboCat.addItem(s);
    }

    private void actualizaComboInstalaciones(List<String> aux) {
        comboInst.removeAllItems();
        
        for(String s : aux)
            comboInst.addItem(s);
    }

    private void actualizaModeloListaAlumnosIntroducidos(List<String> als) {
        DefaultListModel modelo = new DefaultListModel();
        for(String s : als)
            modelo.addElement(s);
        
        jlAlumIntr.removeAll();
        jlAlumIntr.setModel(modelo);
    }

    private void actualizaListaAlumnosIntroducidos(List<String> als) {
        DefaultListModel modelo = new DefaultListModel();
        for(String s : als)
            modelo.addElement(s);
        
        jlAlumIntr.removeAll();
        jlAlumIntr.setModel(modelo);
    }
}
