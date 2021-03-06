
package InterfazUsuario;

import GestionDeAlumnos.GestorAlumnos;
import ServiciosAlmacenamiento.BaseDatos;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;

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
 * Clase que se encarga de mostra información relacionada con el equipo
 * que no se puede representar en la pantalla principal
 * @author Moisés
 * @version 1.0
 */

public class InformacionEquipo extends javax.swing.JFrame {

    /* Atributos internos de la clase */
    
    String nombreEquipo, Categoria, Sexo, primerEntr, segundoEntr, temporada;
    BaseDatos accesoBD;
    
    /**
     * Constructor predeterminado
     */
    public InformacionEquipo() {
        initComponents();
    }
    
    public InformacionEquipo(BaseDatos acceso, String nombreEquipo, String categoria, String sexo, String primerEntr, String segundoEntr, String temporada) throws SQLException
    {
        initComponents();
        this.setLocationRelativeTo(null);
        this.fieldNombreEquipo.setText(nombreEquipo);
        this.fieldNombreCategoria.setText(categoria);
        this.fieldSexo.setText(sexo);
        this.fieldPrimerEntr.setText(primerEntr);
        this.fieldSegEntr.setText(segundoEntr);
        this.fieldTemporada.setText(temporada);
        this.nombreEquipo = nombreEquipo;
        this.Categoria = categoria;
        this.Sexo = sexo;
        this.primerEntr = primerEntr;
        this.segundoEntr = segundoEntr;
        this.temporada = temporada;
        accesoBD = acceso;
        mostrarListadoAlumnos();
        
    }
    
    private void mostrarListadoAlumnos() throws SQLException
    {
        List<Integer> listaIDAlumnos = new ArrayList<>();
        List<String> listaNombreAlumnos = new ArrayList<>();
        int idCategoria = GestionDeCategorias.GestorCategorias.getIdCategoria(accesoBD, Categoria);
        int idTemporada = GestionDeTemporadas.GestorTemporadas.getIdTemporada(accesoBD, temporada);
        DefaultListModel modelo = new DefaultListModel();
        ResultSet ret, retset;
        String consulta = "SELECT Alumno_idAlumno FROM alumnogrupo WHERE "
                + "Grupo_idGrupo IN (SELECT idGrupo FROM grupo) AND "
                + "Grupo_Categoria_idCategoria = " + idCategoria
                + " AND Grupo_Usuario_idUsuario IN (SELECT idUsuario FROM usuario) AND"
                + " Grupo_Temporada_idTemporada = " + idTemporada;

        System.out.print(
                "\n\nConsulta alumnos equipo " + consulta + "\n");
        ret = accesoBD.ejecutaConsulta(consulta);


        try {
            while (ret.next()) {
                listaIDAlumnos.add(ret.getInt(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(NuevoEquipo.class.getName()).log(Level.SEVERE, null, ex);
        }


        try {
            listaNombreAlumnos = GestorAlumnos.getNombreAl(accesoBD, listaIDAlumnos);
        } catch (SQLException ex) {
            Logger.getLogger(NuevoEquipo.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int i = 0; i < listaNombreAlumnos.size(); i++) {
            modelo.addElement(listaNombreAlumnos.get(i));
        }

        listaAlumnosInscritos.validate();

        listaAlumnosInscritos.setModel(modelo);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        labelEquipo = new javax.swing.JLabel();
        botonCerrarInfo = new javax.swing.JButton();
        labelSexo = new javax.swing.JLabel();
        labelPrimerEntr = new javax.swing.JLabel();
        labelSegEntr = new javax.swing.JLabel();
        labelCategoria = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        labelAlumInscritos = new javax.swing.JLabel();
        fieldNombreEquipo = new javax.swing.JTextField();
        fieldNombreCategoria = new javax.swing.JTextField();
        fieldSexo = new javax.swing.JTextField();
        fieldPrimerEntr = new javax.swing.JTextField();
        fieldSegEntr = new javax.swing.JTextField();
        labelTemporada = new javax.swing.JLabel();
        fieldTemporada = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaAlumnosInscritos = new javax.swing.JList();

        jLabel5.setText("jLabel5");

        jTextField2.setText("jTextField2");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        labelEquipo.setText("Equipo:");

        botonCerrarInfo.setText("Cerrar");
        botonCerrarInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCerrarInfoActionPerformed(evt);
            }
        });

        labelSexo.setText("Sexo:");

        labelPrimerEntr.setText("Primer Entrenador:");

        labelSegEntr.setText("Segundo Entrenador:");

        labelCategoria.setText("Categoría: ");

        jLabel6.setText("Información del equipo");

        labelAlumInscritos.setText("Alumnos inscritos");

        fieldNombreEquipo.setEditable(false);

        fieldNombreCategoria.setEditable(false);

        fieldSexo.setEditable(false);

        fieldPrimerEntr.setEditable(false);

        fieldSegEntr.setEditable(false);

        labelTemporada.setText("Temporada:");

        fieldTemporada.setEditable(false);

        listaAlumnosInscritos.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        listaAlumnosInscritos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listaAlumnosInscritos.setEnabled(false);
        jScrollPane1.setViewportView(listaAlumnosInscritos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelEquipo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(fieldNombreEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(labelCategoria)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fieldNombreCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(labelSexo)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(fieldSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(labelAlumInscritos))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(labelTemporada)
                                        .addGap(18, 18, 18)
                                        .addComponent(fieldTemporada, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(labelPrimerEntr)
                                            .addGap(18, 18, 18)
                                            .addComponent(fieldPrimerEntr, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(labelSegEntr)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(botonCerrarInfo)
                                                .addComponent(fieldSegEntr)))))
                                .addGap(50, 50, 50)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(184, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelEquipo)
                            .addComponent(labelCategoria)
                            .addComponent(labelSexo)
                            .addComponent(fieldNombreEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldNombreCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelPrimerEntr)
                            .addComponent(fieldPrimerEntr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(labelAlumInscritos)))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelSegEntr)
                            .addComponent(fieldSegEntr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelTemporada)
                            .addComponent(fieldTemporada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addComponent(botonCerrarInfo))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(89, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonCerrarInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCerrarInfoActionPerformed
        this.setVisible(false);
        this.setEnabled(false);
    }//GEN-LAST:event_botonCerrarInfoActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCerrarInfo;
    private javax.swing.JTextField fieldNombreCategoria;
    private javax.swing.JTextField fieldNombreEquipo;
    private javax.swing.JTextField fieldPrimerEntr;
    private javax.swing.JTextField fieldSegEntr;
    private javax.swing.JTextField fieldSexo;
    private javax.swing.JTextField fieldTemporada;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel labelAlumInscritos;
    private javax.swing.JLabel labelCategoria;
    private javax.swing.JLabel labelEquipo;
    private javax.swing.JLabel labelPrimerEntr;
    private javax.swing.JLabel labelSegEntr;
    private javax.swing.JLabel labelSexo;
    private javax.swing.JLabel labelTemporada;
    private javax.swing.JList listaAlumnosInscritos;
    // End of variables declaration//GEN-END:variables
}
