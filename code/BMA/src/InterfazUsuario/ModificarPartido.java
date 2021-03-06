/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfazUsuario;

import GestionDeCategorias.GestorCategorias;
import GestionDeEquipos.GestorEquipos;
import GestionDeLigas.GestorLigas;
import GestionDePartidos.GestorPartidos;
import GestionDeTemporadas.GestorTemporadas;
import ServiciosAlmacenamiento.BaseDatos;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.Color;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
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
 * Panel para la modificación de los partidos
 * @author Julio Ros Martínez
 * @version 1.0
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
public class ModificarPartido extends javax.swing.JFrame {
    BaseDatos accesoBD;
    private Border bordeError;
    private Border bordeDatePicker;
    PrincipalPartidos principal;
    String fch, hr, cat, temp, eL, eV, inst, liga;
    int rL, rV, idP;
    boolean noEntry,meter;
    int idCat, idTemp, idLig;
    Object equipoAnterior1, equipoAnterior2;

    /**
     * Creates new form ModificarPartido
     */
    public ModificarPartido() {
        initComponents();
        bordeError = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.red);
    }
    
    public ModificarPartido(BaseDatos acceso, String fecha, String hora, String categoria, 
            String temporada, String nomLiga, String eqLoc, String eqVis, int resLoc, int resVis, int idPartido, PrincipalPartidos p) throws SQLException {
        accesoBD = acceso;
        initComponents();
        principal = p;
        fch = fecha;
        hr = hora;
        cat = categoria;
        temp = temporada;
        liga = nomLiga;
        eL = eqLoc;
        eV = eqVis;
        rV = resVis;
        rL = resLoc;
        idP = idPartido;
        bordeError = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.red);
        noEntry = meter = true;
        ((JTextFieldDateEditor) fechaPartido.getComponents()[1]).setEditable(false);
        
        List<String> temporadas = new ArrayList<>();
        temporadas = principal.getListaTemps();
        actualizaComboTemporada(temporadas);
        
        List<List<String>> categorias = new ArrayList<>();
        categorias = principal.getListaCategorias();
        actualizaComboCategoria(categorias);
        
        
        idCat =  GestorCategorias.getIdCategoria(accesoBD, cat);
        idTemp = GestorTemporadas.getIdTemporada(accesoBD, temp);
        idLig = GestorLigas.getIdLiga(accesoBD, liga, idCat, idTemp);
        List<String> equipos = new ArrayList<>();
        List<String> ligas = new ArrayList<>();
        equipos = principal.getListaEquipos(idCat,idTemp,idLig);
        ligas = principal.getListaLigas(idCat, idTemp);
        actualizaComboEquipo(equipos, 1);
        actualizaComboEquipo(equipos, 2);
        actualizaComboLiga(ligas);
        equipoAnterior1 = eL;
        equipoAnterior2 = eV;
        ComboEquipo.removeItem(eV);
        ComboEquipo2.removeItem(eL);
        
        noEntry = meter = false;
        
        
        textHora.setText(convierteHoraString(hr));
        textMin.setText(convierteMinString(hr));
        
        Date fecha_aux = null;
        try {
            fecha_aux = strToDate(fch);
        } catch (ParseException ex) {
            Logger.getLogger(ModificarPartido.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        java.util.Date utilDate = new java.util.Date(fecha_aux.getTime());        
        fechaPartido.setDate(utilDate);
        
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
        Cancelar = new javax.swing.JButton();
        Guardar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        horaLabel = new javax.swing.JLabel();
        textHora = new javax.swing.JTextField();
        textMin = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        labelLiga = new javax.swing.JLabel();
        comboLiga = new javax.swing.JComboBox();

        setResizable(false);

        CrearPartidoLabel.setText("Modificar Partido");

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

        Cancelar.setText("Cancelar");
        Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarActionPerformed(evt);
            }
        });

        Guardar.setText("Guardar Cambios");
        Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarActionPerformed(evt);
            }
        });

        horaLabel.setText("Hora (hh:mm) ");

        textHora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textHoraActionPerformed(evt);
            }
        });

        jLabel1.setText(":");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(horaLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(textHora, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textMin, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(horaLabel)
                    .addComponent(textHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(textMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        labelLiga.setText("Liga");

        comboLiga.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboLiga.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboLigaItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(CrearPartidoLabel)
                .addGap(0, 501, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(TemporadaLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ComboTemporada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addComponent(CategoriaLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ComboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)
                        .addComponent(labelLiga)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboLiga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Guardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Cancelar)
                        .addGap(32, 32, 32))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(fechaLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fechaPartido, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(EquipoVisitanteLabel, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(EquipoLocalLabel, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(ComboEquipo, 0, 456, Short.MAX_VALUE)
                                    .addComponent(ComboEquipo2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(CrearPartidoLabel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TemporadaLabel)
                    .addComponent(ComboTemporada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CategoriaLabel)
                    .addComponent(ComboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelLiga)
                    .addComponent(comboLiga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EquipoLocalLabel)
                    .addComponent(ComboEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EquipoVisitanteLabel)
                    .addComponent(ComboEquipo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(fechaLabel)
                    .addComponent(fechaPartido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Cancelar)
                    .addComponent(Guardar))
                .addContainerGap())
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
        if(comboLiga.getSelectedItem() == "-Liga-"){
            error = true;
            mensajeError += "-No se ha introducido Liga\n";
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
        /*
         * Fin Comprobacion de Errores
         */
        
        if(!error){
            java.sql.Date sqlDate = new java.sql.Date(fechaPartido.getDate().getTime());
            int idEquip1 = 0;
            int idEquip2 = 0;
            try {
                idEquip1 = GestorEquipos.getIdEquipo(accesoBD,ComboEquipo.getSelectedItem().toString(),ComboCategoria.getSelectedItem().toString());
                idEquip2 = GestorEquipos.getIdEquipo(accesoBD,ComboEquipo2.getSelectedItem().toString(),ComboCategoria.getSelectedItem().toString());
            } catch (SQLException ex) {
                Logger.getLogger(NuevoPartido.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                boolean exito = GestorPartidos.modificaPartido(accesoBD, idEquip1, 
                                GestorEquipos.getIdFundacionEquipo(accesoBD, idEquip1),
                                GestorCategorias.getIdCategoria(accesoBD, ComboCategoria.getSelectedItem().toString()), 
                                GestorTemporadas.getIdTemporada(accesoBD, ComboTemporada.getSelectedItem().toString()), 
                                GestorLigas.getIdLiga(accesoBD, comboLiga.getSelectedItem().toString(),
                                    GestorCategorias.getIdCategoria(accesoBD, ComboCategoria.getSelectedItem().toString()),
                                    GestorTemporadas.getIdTemporada(accesoBD, ComboTemporada.getSelectedItem().toString())), 
                                idEquip2, GestorEquipos.getIdFundacionEquipo(accesoBD, idEquip2), 
                                GestorCategorias.getIdCategoria(accesoBD, ComboCategoria.getSelectedItem().toString()), 
                                GestorTemporadas.getIdTemporada(accesoBD, ComboTemporada.getSelectedItem().toString()), 
                                GestorLigas.getIdLiga(accesoBD, comboLiga.getSelectedItem().toString(),
                                    GestorCategorias.getIdCategoria(accesoBD, ComboCategoria.getSelectedItem().toString()),
                                    GestorTemporadas.getIdTemporada(accesoBD, ComboTemporada.getSelectedItem().toString())), 
                                sqlDate, convierteHoraTime(textHora.getText(), textMin.getText()),
                                GestorPartidos.getIdPartido(accesoBD, fch, hr, GestorEquipos.getIdEquipo(accesoBD, eL, cat), GestorEquipos.getIdEquipo(accesoBD, eV, cat)));
                if(exito){
                    JOptionPane.showMessageDialog(null, "Partido modificado con exito", "Confirmacion", JOptionPane.INFORMATION_MESSAGE);
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
        this.dispose();
    }//GEN-LAST:event_CancelarActionPerformed

    private void ComboCategoriaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ComboCategoriaItemStateChanged
        // TODO add your handling code here:
        if(!noEntry){
            if(ComboCategoria.getSelectedItem() != "-Categoria-"){
                try {            
                    idCat = GestorCategorias.getIdCategoria(accesoBD, ComboCategoria.getSelectedItem().toString());
                } catch (SQLException ex) {
                    Logger.getLogger(NuevoPartido.class.getName()).log(Level.SEVERE, null, ex);
                }
                List<String> ligas = new ArrayList<String>();
                List<String> equipos = new ArrayList<String>();
                try {
                    noEntry = true;
                    ligas = principal.getListaLigas(idCat, idTemp);
                    equipos = principal.getListaEquipos(0, 0, 0);
                    actualizaComboEquipo(equipos, 1);
                    actualizaComboEquipo(equipos, 2);
                    if(idCat != 0 && idTemp != 0){
                        actualizaComboLiga(ligas);
                    }
                    noEntry = false;
                } catch (SQLException ex) {
                    Logger.getLogger(NuevoPartido.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else{
                idCat = 0;
                List<String> ligas = new ArrayList<String>();
                try {
                    noEntry = true;
                    ligas = principal.getListaLigas(idCat, 0);
                    actualizaComboEquipo(new ArrayList<String>(),1);
                    actualizaComboEquipo(new ArrayList<String>(),2);
                    actualizaComboLiga(ligas);
                    noEntry = false;
                } catch (SQLException ex) {
                    Logger.getLogger(NuevoPartido.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                equipoAnterior1 = "";
                equipoAnterior2 = "";
        }
    }//GEN-LAST:event_ComboCategoriaItemStateChanged

    private void ComboTemporadaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ComboTemporadaItemStateChanged
        // TODO add your handling code here:
        
        if(!noEntry){
            if(ComboTemporada.getSelectedItem() != "-Temporada-"){
                try {            
                    idTemp = GestorTemporadas.getIdTemporada(accesoBD, ComboTemporada.getSelectedItem().toString());
                } catch (SQLException ex) {
                   Logger.getLogger(NuevoPartido.class.getName()).log(Level.SEVERE, null, ex);
                }
                List<String> ligas = new ArrayList<String>();
                List<String> equipos = new ArrayList<String>();
                try {
                    noEntry = true;
                    ligas = principal.getListaLigas(idCat, idTemp);
                    equipos = principal.getListaEquipos(0, 0, 0);
                    actualizaComboEquipo(equipos, 1);
                    actualizaComboEquipo(equipos, 2);
                    if(idCat != 0 && idTemp != 0){
                        actualizaComboLiga(ligas);
                    }
                    noEntry = false;
                } catch (SQLException ex) {
                    Logger.getLogger(NuevoPartido.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else{
                idTemp = 0;
                List<String> ligas = new ArrayList<String>();
                try {
                    noEntry = true;
                    ligas = principal.getListaLigas(0, idTemp);
                    actualizaComboEquipo(new ArrayList<String>(),1);
                    actualizaComboEquipo(new ArrayList<String>(),2);
                    actualizaComboLiga(ligas);
                    noEntry = false;
                } catch (SQLException ex) {
                    Logger.getLogger(NuevoPartido.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                equipoAnterior1 = "";
                equipoAnterior2 = "";   
        }
    }//GEN-LAST:event_ComboTemporadaItemStateChanged

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

    private void comboLigaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboLigaItemStateChanged
        // TODO add your handling code here:
        if(!noEntry){
            if(comboLiga.getSelectedItem() != "-Liga-"){
                try {            
                    idLig = GestorLigas.getIdLiga(accesoBD, comboLiga.getSelectedItem().toString(),idCat, idTemp);
                } catch (SQLException ex) {
                    Logger.getLogger(NuevoPartido.class.getName()).log(Level.SEVERE, null, ex);
                }
                List<String> equipos = new ArrayList<String>();
                try {
                    noEntry = true;
                    equipos = principal.getListaEquipos(idCat,idTemp,idLig);
                    actualizaComboEquipo(equipos, 1);
                    actualizaComboEquipo(equipos, 2);
                    noEntry = false;
                } catch (SQLException ex) {
                    Logger.getLogger(NuevoPartido.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else{
                idLig = 0;
                List<String> equipos = new ArrayList<String>();
                try {
                    noEntry = true;
                    equipos = principal.getListaEquipos(0,0,0);
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
    }//GEN-LAST:event_comboLigaItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cancelar;
    private javax.swing.JLabel CategoriaLabel;
    private javax.swing.JComboBox ComboCategoria;
    private javax.swing.JComboBox ComboEquipo;
    private javax.swing.JComboBox ComboEquipo2;
    private javax.swing.JComboBox ComboTemporada;
    private javax.swing.JLabel CrearPartidoLabel;
    private javax.swing.JLabel EquipoLocalLabel;
    private javax.swing.JLabel EquipoVisitanteLabel;
    private javax.swing.JButton Guardar;
    private javax.swing.JLabel TemporadaLabel;
    private javax.swing.JComboBox comboLiga;
    private javax.swing.JLabel fechaLabel;
    private com.toedter.calendar.JDateChooser fechaPartido;
    private javax.swing.JLabel horaLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelLiga;
    private javax.swing.JTextField textHora;
    private javax.swing.JTextField textMin;
    // End of variables declaration//GEN-END:variables
    private void actualizaComboTemporada(List<String> temps) throws SQLException {
        ComboTemporada.removeAllItems();
        if(noEntry)
            ComboTemporada.addItem(temp);
        else
            ComboTemporada.addItem("-Temporada-");
        for(String s : temps){
            if(!s.equals(temp))
                ComboTemporada.addItem(s);
            else if(!noEntry)
                ComboTemporada.addItem(s);
        }
        
    }
    
    private void actualizaComboCategoria(List<List<String>> cats) throws SQLException {
        ComboCategoria.removeAllItems();
        if(noEntry)
            ComboCategoria.addItem(cat);
        else
            ComboCategoria.addItem("-Categoria-");
        for(List<String> s : cats){
            if(!s.get(0).equals(cat))
                ComboCategoria.addItem(s.get(0));
            else if(!noEntry)
                ComboCategoria.addItem(s.get(0));
        }        
    }
    
    private void actualizaComboEquipo(List<String> equipos, int numEquipo) throws SQLException {
        if(numEquipo == 1){
            ComboEquipo.removeAllItems();
            if(meter)
                ComboEquipo.addItem(eL);
            else
                ComboEquipo.addItem("-Equipo Local-");
            for(String s : equipos)
                if(!s.equals(eL))
                    ComboEquipo.addItem(s);
                else if(!meter)
                    ComboEquipo.addItem(s);
        } else{
            ComboEquipo2.removeAllItems();
            if(meter)
                ComboEquipo2.addItem(eV);
            else
                ComboEquipo2.addItem("-Equipo Visitante-");
            for(String s : equipos)
                if(!s.equals(eV))
                    ComboEquipo2.addItem(s);
                else if(!meter)
                    ComboEquipo2.addItem(s);
        }
    }
    
    private void actualizaComboLiga(List<String> ligas) throws SQLException {
            comboLiga.removeAllItems();
            if(meter)
                comboLiga.addItem(liga);
            else
                comboLiga.addItem("-Liga-");
            for(String s : ligas)
                if(!s.equals(liga))
                    comboLiga.addItem(s);
                else if(!meter)
                    comboLiga.addItem(s);
    }
    
    private Time convierteHoraTime(String h, String m){
        String hora = h+":"+m;
        java.sql.Time horaDate = null;
        
        try{
            SimpleDateFormat sdf = new java.text.SimpleDateFormat("HH:mm", new Locale("es","ES"));
            horaDate = new java.sql.Time(sdf.parse(hora).getTime());
            
        } catch(Exception e){
            System.out.println("Error al obtener el formato de la hora: " + e.getMessage());
        }
        
        return horaDate;
    }
    
    private Date strToDate(String str) throws ParseException{
        java.sql.Date dat = null;
        
        SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd", new Locale("es","ES"));
        dat = new java.sql.Date(sdf.parse(str).getTime());
        
        return dat;
    }
    
    private String convierteHoraString(String hora){
        String hra = hora.substring(0, hora.indexOf(":"));
        
        return hra;
    }
    
    private String convierteMinString(String hora){
        String min = hora.substring(hora.indexOf(":")+1,hora.length());
        min = min.substring(0,min.indexOf(":"));

        
        return min;
    }
}
