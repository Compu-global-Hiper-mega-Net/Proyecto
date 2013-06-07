/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfazUsuario;

import GestionActividades.GestorActividad;
import ServiciosAlmacenamiento.BaseDatos;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Dell
 */
public class PrincipalActividades extends javax.swing.JFrame {
    private JFrame pP;
    private BaseDatos bd;
    private String consultaActividadesMostradas;
    private ResultSet retset;
    
    /**
     * Creates new form PrincipalActividades
     */
    public PrincipalActividades(JFrame pP, BaseDatos bd) {
        initComponents();
        setLocationRelativeTo(pP);
        this.bd = bd;
        this.pP = pP;
        mostrarActividades();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelActividades = new javax.swing.JPanel();
        actividadesLabel = new javax.swing.JLabel();
        buscarLabel = new javax.swing.JLabel();
        nombreLabel = new javax.swing.JLabel();
        nombreTextField = new javax.swing.JTextField();
        fechaInicioLabel = new javax.swing.JLabel();
        fechaInicioDateChooser = new com.toedter.calendar.JDateChooser();
        fechaFinLabel = new javax.swing.JLabel();
        fechaFinDateChooser = new com.toedter.calendar.JDateChooser();
        Insertar = new javax.swing.JButton();
        Eliminar = new javax.swing.JButton();
        Modificar = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        actividadesTable = new javax.swing.JTable();
        Informacion = new javax.swing.JButton();
        AñaridAlumno = new javax.swing.JButton();
        buscarActividad = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Actividades");

        panelActividades.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        panelActividades.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        panelActividades.setMinimumSize(new java.awt.Dimension(1300, 640));

        actividadesLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        actividadesLabel.setText("Actividades");

        buscarLabel.setText("Buscar por");

        nombreLabel.setText("Nombre");

        nombreTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreTextFieldActionPerformed(evt);
            }
        });
        nombreTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nombreTextFieldKeyTyped(evt);
            }
        });

        fechaInicioLabel.setText("Fecha inicio");

        fechaInicioDateChooser.setDateFormatString("dd-MM-yyyy");
        fechaInicioDateChooser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fechaInicioDateChooserKeyTyped(evt);
            }
        });

        fechaFinLabel.setText("Fecha Fin");

        fechaFinDateChooser.setDateFormatString("dd-MM-yyyy");

        Insertar.setText("Insertar");
        Insertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InsertarActionPerformed(evt);
            }
        });

        Eliminar.setText("Eliminar");
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });

        Modificar.setText("Modificar");
        Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarActionPerformed(evt);
            }
        });

        actividadesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre", "Fecha de Inicio", "Fecha Fin", "Instalacion"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
<<<<<<< HEAD
        actividadesTable.getTableHeader().setResizingAllowed(false);
        actividadesTable.getTableHeader().setReorderingAllowed(false);
=======
        actividadesTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
>>>>>>> origin/HEAD
        jScrollPane4.setViewportView(actividadesTable);

        Informacion.setText("Info");
        Informacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InformacionActionPerformed(evt);
            }
        });

        AñaridAlumno.setText("Añadir Alumno");
        AñaridAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AñaridAlumnoActionPerformed(evt);
            }
        });

        buscarActividad.setText("Buscar");
        buscarActividad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActividadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelActividadesLayout = new javax.swing.GroupLayout(panelActividades);
        panelActividades.setLayout(panelActividadesLayout);
        panelActividadesLayout.setHorizontalGroup(
            panelActividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelActividadesLayout.createSequentialGroup()
                .addGroup(panelActividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelActividadesLayout.createSequentialGroup()
                        .addGap(300, 300, 300)
                        .addComponent(fechaFinLabel)
                        .addGap(18, 18, 18)
                        .addComponent(fechaFinDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelActividadesLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(buscarLabel))
                    .addGroup(panelActividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(panelActividadesLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(AñaridAlumno)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(Informacion))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelActividadesLayout.createSequentialGroup()
                            .addGap(81, 81, 81)
                            .addGroup(panelActividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panelActividadesLayout.createSequentialGroup()
                                    .addComponent(fechaInicioLabel)
                                    .addGap(18, 18, 18)
                                    .addComponent(fechaInicioDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(panelActividadesLayout.createSequentialGroup()
                                    .addComponent(nombreLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(nombreTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(panelActividadesLayout.createSequentialGroup()
                                    .addComponent(Insertar)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(Eliminar)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(Modificar)
                                    .addGap(18, 18, 18)
                                    .addComponent(buscarActividad)))
                            .addGap(86, 86, 86)))
                    .addGroup(panelActividadesLayout.createSequentialGroup()
                        .addGap(231, 231, 231)
                        .addComponent(actividadesLabel))
                    .addGroup(panelActividadesLayout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelActividadesLayout.setVerticalGroup(
            panelActividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelActividadesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(actividadesLabel)
                .addGap(38, 38, 38)
                .addComponent(buscarLabel)
                .addGap(3, 3, 3)
                .addGroup(panelActividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreLabel)
                    .addComponent(nombreTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelActividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(fechaInicioLabel)
                    .addComponent(fechaInicioDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fechaFinLabel)
                    .addComponent(fechaFinDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelActividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Insertar)
                    .addComponent(Eliminar)
                    .addComponent(Modificar)
                    .addComponent(buscarActividad))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelActividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AñaridAlumno)
                    .addComponent(Informacion))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 566, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelActividades, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 386, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelActividades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nombreTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreTextFieldKeyTyped
        // TODO add your handling code here:
        if (!nombreTextField.getText().isEmpty()) {
            String nombre = nombreTextField.getText();
            String consulta = "SELECT nombre, fechaInicio, fechaFin FROM actividades"
            + " WHERE nombre LIKE '%" + nombre + "%'";
            ResultSet retset;

            retset = bd.ejecutaConsulta(consulta);

            actividadesTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null}
                },
                new String[]{
                    "Nombre", "Fecha Inicio", "Fecha Fin"
                }));
                javax.swing.table.TableModel modelo_tabla = new javax.swing.table.DefaultTableModel();
                modelo_tabla = actividadesTable.getModel();
                int i = 0;
                try {
                    while (retset.next()) {

                        if (i < 25) {
                            actividadesTable.setValueAt(retset.getString("nombre"), i, 0);
                            actividadesTable.setValueAt(retset.getString("fechaInicio"), i, 1);
                            actividadesTable.setValueAt(retset.getString("fechaFin"), i, 2);
                        } else {
                            javax.swing.table.DefaultTableModel temp = new javax.swing.table.DefaultTableModel();
                            Object nuevo[] = {"", "", ""};
                            temp.addRow(nuevo);
                            actividadesTable.setValueAt(retset.getString("nombre"), i, 0);
                            actividadesTable.setValueAt(retset.getString("fechaInicio"), i, 1);
                            actividadesTable.setValueAt(retset.getString("fechaFin"), i, 2);
                        }
                        i++;
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                mostrarActividades();
            }
    }//GEN-LAST:event_nombreTextFieldKeyTyped

    private void fechaInicioDateChooserKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fechaInicioDateChooserKeyTyped
        // TODO add your handling code here:
        Date nombre = (java.sql.Date) fechaInicioDateChooser.getDate();
        String consulta = "SELECT nombre, fechaInicio, fechaFin FROM actividades"
        + " WHERE fechaInicio LIKE '%" + nombre + "%'";
        ResultSet retset;

        System.out.println("Consulta Fecha " + consulta);

        retset = bd.ejecutaConsulta(consulta);

        actividadesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object[][]{
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String[]{
                "Nombre", "Fecha Inicio", "Fecha Fin"
            }));
            javax.swing.table.TableModel modelo_tabla = new javax.swing.table.DefaultTableModel();
            modelo_tabla = actividadesTable.getModel();
            int i = 0;
            try {
                while (retset.next()) {

                    if (i < 25) {
                        actividadesTable.setValueAt(retset.getString("nombre"), i, 0);
                        actividadesTable.setValueAt(retset.getString("fechaInicio"), i, 1);
                        actividadesTable.setValueAt(retset.getString("fechaFin"), i, 2);
                    } else {

                        javax.swing.table.DefaultTableModel temp = new javax.swing.table.DefaultTableModel();
                        Object nuevo[] = {"", "", ""};
                        temp.addRow(nuevo);
                        actividadesTable.setValueAt(retset.getString("nombre"), i, 0);
                        actividadesTable.setValueAt(retset.getString("fechaInicio"), i, 1);
                        actividadesTable.setValueAt(retset.getString("fechaFin"), i, 2);
                    }
                    i++;
                }
            } catch (SQLException ex) {
                Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_fechaInicioDateChooserKeyTyped

    private void InsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InsertarActionPerformed
        // TODO add your handling code here:
        new AltaActividad(bd, this).setVisible(true);
    }//GEN-LAST:event_InsertarActionPerformed

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
        // TODO add your handling code here:
        int nTabla = actividadesTable.getSelectedRow();
        ResultSet retset;
        float precioS = 50;
        float precioNS = 70;
        String descripcion = "";
        int temporada = 0;
        int plazas = 0;

        if (nTabla >= 0) {
            int idActividad = getIDActividad();
            SimpleDateFormat formato = new java.text.SimpleDateFormat("yyyy-MM-dd");
            java.sql.Date fechaInicio = null;
            java.sql.Date fechafin = null;
            try {
                fechaInicio = new java.sql.Date(formato.parse(actividadesTable.getValueAt(nTabla, 1).toString()).getTime());
                System.out.print(fechaInicio);
            } catch (ParseException ex) {
            }
            try {
                fechafin = new java.sql.Date(formato.parse(actividadesTable.getValueAt(nTabla, 2).toString()).getTime());
            } catch (ParseException ex) {
                Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }

            String consulta = "SELECT Temporada_idTemporada, nAlumnos, descripcion FROM actividades where idActividades = "
            + idActividad;

            /*nombre = ' "
            + actividadesTable.getValueAt(nTabla, 0) + "' AND fechaInicio ='" + actividadesTable.getValueAt(nTabla, 1)
            + "' AND fechaFin = '" + actividadesTable.getValueAt(nTabla, 2) + "'"*/

            System.out.print("\n\n" + consulta);
            System.out.print("\n\n" + actividadesTable.getValueAt(nTabla, 1));
            System.out.print("\n\n" + actividadesTable.getValueAt(nTabla, 2));
            retset = bd.ejecutaConsulta(consulta);
            int selection = JOptionPane.showConfirmDialog(this, "Desea eliminar la Instalacion?", "Instalacion usuario", JOptionPane.YES_NO_OPTION);
            if (selection == JOptionPane.YES_OPTION) {
                try {
                    if (retset.next()) {
                        temporada = retset.getInt(1);
                        plazas = retset.getInt(2);
                        descripcion = retset.getString(3);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }

                GestorActividad.eliminaActividad(bd, descripcion, plazas, precioS, precioNS, temporada, fechaInicio, fechafin, (String) actividadesTable.getValueAt(nTabla, 0));

            }
        } else if (nTabla == -1) {
            JOptionPane.showMessageDialog(this, "No se ha seleccionado ninguna instalacion", "Error", JOptionPane.ERROR_MESSAGE);
        }
        mostrarActividades();
    }//GEN-LAST:event_EliminarActionPerformed

    private void ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarActionPerformed
        // TODO add your handling code here:
        ResultSet retsetMostrados;

        int idActividad, plazas;
        String decripcion = new String();

        int indiceTabla = actividadesTable.getSelectedRow();

        if (indiceTabla >= 0) {
            String consulta = "SELECT idActividades, descripcion, nAlumnos FROM actividades WHERE nombre = '"
            + actividadesTable.getValueAt(indiceTabla, 0) + "' AND fechaInicio = '"
            + actividadesTable.getValueAt(indiceTabla, 1) + "' AND fechaFin = '"
            + actividadesTable.getValueAt(indiceTabla, 2) + "'";

            retsetMostrados = bd.ejecutaConsulta(consulta);

            try {
                if (retsetMostrados.next()) {
                    idActividad = retsetMostrados.getInt("idActividades");
                    decripcion = retsetMostrados.getString("descripcion");
                    plazas = retsetMostrados.getInt("nAlumnos");

                    new ModificarActividad(bd, actividadesTable.getValueAt(indiceTabla, 0).toString(),
                        actividadesTable.getValueAt(indiceTabla, 1).toString(),
                        actividadesTable.getValueAt(indiceTabla, 2).toString(), idActividad, decripcion, plazas, this).setVisible(true);
                }
            } catch (SQLException ex) {
                Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (indiceTabla == -1) {
            JOptionPane.showMessageDialog(this, "No se ha seleccionado ninguna actividad", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_ModificarActionPerformed

    private void InformacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InformacionActionPerformed
        // TODO add your handling code here:
        int nTabla = actividadesTable.getSelectedRow();
        try {
            new InformacionActividad(bd, (String) actividadesTable.getValueAt(nTabla, 0),
                actividadesTable.getValueAt(nTabla, 1).toString(), actividadesTable.getValueAt(nTabla, 2).toString()).setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_InformacionActionPerformed

    private void AñaridAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AñaridAlumnoActionPerformed
        // TODO add your handling code here:
        int idTemporada = 0;
        int idActividad = 0;

        idTemporada = getIDTemporada();
        idActividad = getIDActividad();
        new AñadirAlumno(bd, idTemporada, idActividad).setVisible(true);
    }//GEN-LAST:event_AñaridAlumnoActionPerformed

    private void buscarActividadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActividadActionPerformed
          // TODO add your handling code here:
        if (!nombreTextField.getText().isEmpty()) {
            String nombre = nombreTextField.getText();
            String consulta = "SELECT IdActividaes,nombre, fechaInicio, fechaFin FROM actividades"
            + " WHERE nombre LIKE '%" + nombre + "%'";
            String consultaInstalaciones="SELECT * FROM mydb.actividadesinstalacion Where actividades_idActividades=";
            ResultSet retset;
            

            retset = bd.ejecutaConsulta(consulta);

            
            actividadesTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                    {null, null, null,null},
                    {null, null, null,null},
                    {null, null, null,null},
                    {null, null, null,null},
                    {null, null, null,null},
                    {null, null, null,null},
                    {null, null, null,null},
                    {null, null, null,null},
                    {null, null, null,null},
                    {null, null, null,null},
                    {null, null, null,null},
                    {null, null, null,null},
                    {null, null, null,null},
                    {null, null, null,null},
                    {null, null, null,null},
                    {null, null, null,null},
                    {null, null, null,null},
                    {null, null, null,null},
                    {null, null, null,null},
                    {null, null, null,null},
                    {null, null, null,null},
                    {null, null, null,null},
                    {null, null, null,null},
                    {null, null, null,null},
                    {null, null, null,null}
                },
                new String[]{
                    "Nombre", "Fecha Inicio", "Fecha Fin","Instalacion",
                }));
                javax.swing.table.TableModel modelo_tabla = new javax.swing.table.DefaultTableModel();
                modelo_tabla = actividadesTable.getModel();
                int i = 0;
                try {
                    while (retset.next()) {

                        if (i < 25) {
                            actividadesTable.setValueAt(retset.getString("nombre"), i, 0);
                            actividadesTable.setValueAt(retset.getString("fechaInicio"), i, 1);
                            actividadesTable.setValueAt(retset.getString("fechaFin"), i, 2);
                        } else {
                            javax.swing.table.DefaultTableModel temp = new javax.swing.table.DefaultTableModel();
                            Object nuevo[] = {"", "", ""};
                            temp.addRow(nuevo);
                            actividadesTable.setValueAt(retset.getString("nombre"), i, 0);
                            actividadesTable.setValueAt(retset.getString("fechaInicio"), i, 1);
                            actividadesTable.setValueAt(retset.getString("fechaFin"), i, 2);
                        }
                        i++;
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                mostrarActividades();
            }
    }//GEN-LAST:event_buscarActividadActionPerformed

    private void nombreTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreTextFieldActionPerformed

    public void mostrarActividades() {
        
        actividadesTable.removeAll();
        try {
            // TODO add your handling code here:
            String consulta_actividades = leeConsultaActividad();
            consultaActividadesMostradas = consulta_actividades;
            System.out.print("\nLA consulta a " + consulta_actividades + "  y aqui termina ");
            retset = GestorActividad.consultaActividad(bd, consulta_actividades);
            actividadesTable.setModel(new javax.swing.table.DefaultTableModel(
                    new Object[][]{
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
                    new String[]{
                "Nombre", "Fecha Inicio", "Fecha Fin"
            }));
            javax.swing.table.TableModel modelo_tabla = new javax.swing.table.DefaultTableModel();
            modelo_tabla = actividadesTable.getModel();
            int i = 0;
            while (retset.next()) {
                
                if (i < 25) {
                    actividadesTable.setValueAt(retset.getString("a.nombre"), i, 0);
                    actividadesTable.setValueAt(retset.getString("a.fechaInicio"), i, 1);
                    actividadesTable.setValueAt(retset.getString("a.fechaFin"), i, 2);
                } else {
                    javax.swing.table.DefaultTableModel temp = new javax.swing.table.DefaultTableModel();
                    Object nuevo[] = {"", "", ""};
                    temp.addRow(nuevo);
                    actividadesTable.setValueAt(retset.getString("a.nombre"), i, 0);
                    actividadesTable.setValueAt(retset.getString("a.fechaInicio"), i, 1);
                    actividadesTable.setValueAt(retset.getString("a.fechaFin"), i, 2);
                }
                i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private int getIDActividad() {
        
        int indiceTabla = actividadesTable.getSelectedRow();
        ResultSet rts;
        int idActividad = 0;
        
        String actividad = "SELECT idActividades FROM actividades WHERE nombre = '"
                + actividadesTable.getValueAt(indiceTabla, 0) + "' AND fechaInicio = '"
                + actividadesTable.getValueAt(indiceTabla, 1) + "' AND fechaFin = '"
                + actividadesTable.getValueAt(indiceTabla, 2) + "'";
        
        
        
        rts = bd.ejecutaConsulta(actividad);
        System.out.print("\n\n Busaca " + rts + "\n\n");
        try {
            if (rts.next()) {
                idActividad = rts.getInt("idActividades");
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return idActividad;
    }
    
    private int getIDTemporada() {
        
        int indiceTabla = actividadesTable.getSelectedRow();
        ResultSet rts;
        int idTemporada = 0;
        
        String actividad = "SELECT Temporada_idTemporada FROM actividades WHERE nombre = '"
                + actividadesTable.getValueAt(indiceTabla, 0) + "' AND fechaInicio = '"
                + actividadesTable.getValueAt(indiceTabla, 1) + "' AND fechaFin = '"
                + actividadesTable.getValueAt(indiceTabla, 2) + "'";
        
        
        
        rts = bd.ejecutaConsulta(actividad);
        System.out.print("\n\n Busaca " + rts + "\n\n");
        try {
            if (rts.next()) {
                idTemporada = rts.getInt("Temporada_idTemporada");
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return idTemporada;
    }
    
    private String leeConsultaActividad() {
        
        
        String consulta_actividades = "SELECT a.idActividades, a.nAlumnos, a.descripcion, a.precioSocio,"
                + " a.precioNoSocio, a.Temporada_idTemporada, a.fechaInicio, a.fechaFin, a.nombre FROM ";
        String TablasImplicadas = " actividades a";
        String condicionConsulta = " WHERE";

        //Date fechaInicio = (Date) fechaInicioDateChooser.getDate();
        //SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        
        if (!nombreTextField.getText().equals("") || !fechaInicioDateChooser.getDateFormatString().equals("dd-MMM-yyyy")
                || !fechaFinDateChooser.getDateFormatString().equals("dd-MMM-yyyy")) {
            if (!nombreTextField.getText().equals("")) {
                condicionConsulta = condicionConsulta + " a.nombre= '" + nombreTextField.getText() + "' AND ";
            }
            
            if (!fechaInicioDateChooser.getDateFormatString().equals("dd-MM-yyyy")) {
                condicionConsulta = condicionConsulta + " a.fechaInicio = " + fechaInicioDateChooser.getDateFormatString() + " AND ";
                System.out.print("\n\n fecha" + fechaInicioDateChooser.getDateFormatString());
            }
            if (!fechaFinDateChooser.getDateFormatString().equals("dd-MM-yyyy")) {
                condicionConsulta = condicionConsulta + " a.fechaFin = " + fechaFinDateChooser.getDateFormatString() + " AND  ";
            }
            
            
            condicionConsulta = condicionConsulta.substring(0, condicionConsulta.length() - 5);
            TablasImplicadas = TablasImplicadas + condicionConsulta;
        }
        
        
        consulta_actividades = consulta_actividades + TablasImplicadas;
        
        
        return consulta_actividades;
        
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AñaridAlumno;
    private javax.swing.JButton Eliminar;
    private javax.swing.JButton Informacion;
    private javax.swing.JButton Insertar;
    private javax.swing.JButton Modificar;
    private javax.swing.JLabel actividadesLabel;
    private javax.swing.JTable actividadesTable;
    private javax.swing.JButton buscarActividad;
    private javax.swing.JLabel buscarLabel;
    private com.toedter.calendar.JDateChooser fechaFinDateChooser;
    private javax.swing.JLabel fechaFinLabel;
    private com.toedter.calendar.JDateChooser fechaInicioDateChooser;
    private javax.swing.JLabel fechaInicioLabel;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel nombreLabel;
    private javax.swing.JTextField nombreTextField;
    private javax.swing.JPanel panelActividades;
    // End of variables declaration//GEN-END:variables
}
