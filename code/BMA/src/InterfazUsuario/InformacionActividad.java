/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfazUsuario;

import ServiciosAlmacenamiento.BaseDatos;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jesusmcs
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

public class InformacionActividad extends javax.swing.JFrame {

    BaseDatos accesoBD;
    String nombreAct, fechainicio, fechafin;
    int idActividad;

    /**
     * Creates new form InformacionActividad
     */
    public InformacionActividad() {
        initComponents();
    }

    public InformacionActividad(BaseDatos acceso, String nombre, String fInicio, String fFin, int id) throws SQLException {
        accesoBD = acceso;
        initComponents();
        nombreAct = nombre;
        fechainicio = fInicio;
        fechafin = fFin;
        idActividad = id;

        nombreTextField.setEditable(false);
        fechaInicioTextField.setEditable(false);
        fechaFinTextField.setEditable(false);
        //lugarTextField.setEditable(false);
        plazasTextField.setEditable(false);
        jTextArea1.setEditable(false);
        Instalacion.setEditable(false);

        nombreTextField.setText(nombre);
        fechaInicioTextField.setText(fInicio);
        fechaFinTextField.setText(fFin);
        mostrarActividad();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        informacionLabel = new javax.swing.JLabel();
        nombreLabel = new javax.swing.JLabel();
        nombreTextField = new javax.swing.JTextField();
        fechaInicioLabel = new javax.swing.JLabel();
        fechaInicioTextField = new javax.swing.JTextField();
        fechaFinLabel = new javax.swing.JLabel();
        fechaFinTextField = new javax.swing.JTextField();
        plazasLabel = new javax.swing.JLabel();
        plazasTextField = new javax.swing.JTextField();
        descripcionLabel = new javax.swing.JLabel();
        descripcionScrollPane = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        Salir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Instalacion = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        informacionLabel.setText("Informacion");

        nombreLabel.setText("Nombre");

        fechaInicioLabel.setText("Fecha inicio");

        fechaFinLabel.setText("Fecha Fin");

        plazasLabel.setText("Plazas");

        descripcionLabel.setText("Descripcion");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        descripcionScrollPane.setViewportView(jTextArea1);

        Salir.setText("Salir");
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });

        jLabel1.setText("Instalacion");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(fechaInicioLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fechaInicioTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(fechaFinLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fechaFinTextField))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(nombreLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nombreTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(informacionLabel)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(descripcionLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(descripcionScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 68, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(plazasLabel)
                        .addGap(18, 18, 18)
                        .addComponent(plazasTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(121, 121, 121)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Instalacion)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Salir)
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(informacionLabel)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreLabel)
                    .addComponent(nombreTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fechaInicioLabel)
                    .addComponent(fechaInicioTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fechaFinLabel)
                    .addComponent(fechaFinTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(plazasLabel)
                    .addComponent(plazasTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(Instalacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(descripcionLabel)
                    .addComponent(descripcionScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Salir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void mostrarActividad() throws SQLException {
        ResultSet retset;
        String consulta = "SELECT nAlumnos, descripcion FROM actividades WHERE "
                + "nombre = '" + nombreAct + "' AND fechaInicio = '" + fechainicio
                + "' AND fechafin = '" + fechafin + "'";
        String plazas = "Error";
        String descripcion = "Error";

        retset = accesoBD.ejecutaConsulta(consulta);
        System.out.print("\n\nConsulta MostrarActividad " + retset);
        System.out.print("\n\nConsulta MostrarActividad " + consulta + "\n");

        try {
            if (retset.next()) {
                plazas = retset.getString(1).toString();
                descripcion = retset.getString(2).toString();
            }
        } catch (SQLException ex) {
            Logger.getLogger(InformacionActividad.class.getName()).log(Level.SEVERE, null, ex);
            System.out.print("\n\nNo entra en el try\n\n");
        }


        plazasTextField.setText(plazas);
        jTextArea1.append(descripcion);
        Instalacion.setText(getInstalacion());
    }
    
    private String getInstalacion() throws SQLException{
        String nombre = "";
        String consulta = "SELECT Instalacion.nombre FROM actividadesinstalacion, Instalacion "
                + "WHERE actividades_idActividades = " + idActividad + " AND Instalacion_idInstalacion = Instalacion.idInstalacion";
        ResultSet retset;
        
        System.out.print("\nConsulta Instalacion " + consulta);
        
        retset = accesoBD.ejecutaConsulta(consulta);
        
        if(retset.next()){
            nombre = retset.getString(1);
        }
        
        return nombre;
     
    }
    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_SalirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Instalacion;
    private javax.swing.JButton Salir;
    private javax.swing.JLabel descripcionLabel;
    private javax.swing.JScrollPane descripcionScrollPane;
    private javax.swing.JLabel fechaFinLabel;
    private javax.swing.JTextField fechaFinTextField;
    private javax.swing.JLabel fechaInicioLabel;
    private javax.swing.JTextField fechaInicioTextField;
    private javax.swing.JLabel informacionLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel nombreLabel;
    private javax.swing.JTextField nombreTextField;
    private javax.swing.JLabel plazasLabel;
    private javax.swing.JTextField plazasTextField;
    // End of variables declaration//GEN-END:variables
}
