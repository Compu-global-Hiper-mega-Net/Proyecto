/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfazUsuario;

import ServiciosAlmacenamiento.BaseDatos;
import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.border.Border;


/**
 *
 * @author Julio
 */
public class ModificarPartido extends javax.swing.JFrame {
    BaseDatos accesoBD;
    private Border bordeError;
    private Border bordeDatePicker;
    PrincipalPartidos principal;

    /**
     * Creates new form ModificarPartido
     */
    public ModificarPartido() {
        initComponents();
        bordeError = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.red);
    }
    
    public ModificarPartido(BaseDatos acceso, String fecha, String hora, String categoria, 
            String temporada, String eqLoc, String eqVis, int resLoc, int resVis, int idPartido, PrincipalPartidos p) throws SQLException {
        accesoBD = acceso;
        initComponents();
        principal = p;
        bordeError = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.red);
        
        List<String> temporadas = new ArrayList<String>();
        temporadas = principal.getListaTemps();
        actualizaComboTemporada(temporadas);
        
        List<List<String>> categorias = new ArrayList<List<String>>();
        categorias = principal.getListaCategorias();
        actualizaComboCategoria(categorias);
        
        List<String> instalaciones = new ArrayList<String>();
        instalaciones = principal.getListaInstalaciones(null);
        actualizaComboInstalacion(instalaciones);
        
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
        lugarLabel = new javax.swing.JLabel();
        ComboInstalacion = new javax.swing.JComboBox();
        Cancelar = new javax.swing.JButton();
        Guardar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        horaLabel = new javax.swing.JLabel();
        horaPartido = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        CrearPartidoLabel.setText("Modificar Partido");

        TemporadaLabel.setText("Temporada:");

        ComboTemporada.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ComboTemporada.setName(""); // NOI18N

        CategoriaLabel.setText("Categoría: ");

        ComboCategoria.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        EquipoLocalLabel.setText("Equipo Local: ");

        EquipoVisitanteLabel.setText("Equipo Visitante: ");

        ComboEquipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        ComboEquipo2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        fechaLabel.setText("Fecha: ");

        fechaPartido.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                fechaPartidoFocusLost(evt);
            }
        });

        lugarLabel.setText("Lugar: ");

        ComboInstalacion.setEditable(true);

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

        horaLabel.setText("Hora (hh:mm) ");

        horaPartido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                horaPartidoActionPerformed(evt);
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
                .addComponent(horaPartido, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(horaLabel)
                    .addComponent(horaPartido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CrearPartidoLabel)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(lugarLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(ComboInstalacion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(fechaLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(fechaPartido, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(32, 32, 32)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(EquipoVisitanteLabel, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(EquipoLocalLabel, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ComboEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(TemporadaLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(ComboTemporada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(34, 34, 34)
                                        .addComponent(CategoriaLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ComboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(ComboEquipo2, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(3, 138, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Guardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Cancelar)
                        .addGap(32, 32, 32)))
                .addContainerGap())
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
                    .addComponent(ComboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EquipoLocalLabel)
                    .addComponent(ComboEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EquipoVisitanteLabel)
                    .addComponent(ComboEquipo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(fechaLabel)
                    .addComponent(fechaPartido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lugarLabel)
                    .addComponent(ComboInstalacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
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

    private void horaPartidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_horaPartidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_horaPartidoActionPerformed

    private void GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GuardarActionPerformed

    private void CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_CancelarActionPerformed

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
    private javax.swing.JTextField horaPartido;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lugarLabel;
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
            ComboCategoria.addItem(s);
        
    }
    
    private void actualizaComboInstalacion(List<String> insts) throws SQLException {
        ComboInstalacion.removeAllItems();
        ComboInstalacion.addItem("-Instalacion-");
        for(String s : insts)
            ComboInstalacion.addItem(s);
    }
}
