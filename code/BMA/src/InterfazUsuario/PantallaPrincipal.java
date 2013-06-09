/*
 * InterfazPrincipal.java
 *
 * Created on 16-mar-2013, 16:58:04
 */
package InterfazUsuario;

import GestionDeUsuarios.GestorUsuarios;
import ServiciosAlmacenamiento.BaseDatos;

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
 * Pantalla de gestión principal de la aplicación
 *
 * @author Compu-global-Hiper-mega-Net
 */
public class PantallaPrincipal extends javax.swing.JFrame {

    private BaseDatos accesoBD;

    /**
     * Constructor de la clase de Gestión Principal
     */
    public PantallaPrincipal(BaseDatos acceso, String usuario) {
        initComponents();
        this.accesoBD = acceso;
        this.initComponentsSegunUsuario(usuario);
        this.setLocationRelativeTo(null);
    }

    /**
     * Método que dependiendo de los privilegios del usuario que ha iniciado
     * sesión, elimina funcionalidades.
     *
     * @param usuario Nombre del usuario que ha iniciado sesión.
     */
    private void initComponentsSegunUsuario(String usuario) {
        if (!GestorUsuarios.tengoPermisosAdministrador(accesoBD, usuario)) {
            this.remove(usuarios);
            this.remove(usuariosDescripcion);
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
        java.awt.GridBagConstraints gridBagConstraints;

        panelGestion = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        jugadores = new javax.swing.JButton();
        jugadoresDescripcion = new javax.swing.JLabel();
        usuarios = new javax.swing.JButton();
        usuariosDescripcion = new javax.swing.JLabel();
        grupos = new javax.swing.JButton();
        gruposDescripcion = new javax.swing.JLabel();
        equipos = new javax.swing.JButton();
        equiposDescripcion = new javax.swing.JLabel();
        partidos = new javax.swing.JButton();
        partidosDescripcion = new javax.swing.JLabel();
        actividades = new javax.swing.JButton();
        acrividadesDescripcion = new javax.swing.JLabel();
        pagos = new javax.swing.JButton();
        pagosDescripcion = new javax.swing.JLabel();
        instalaciones = new javax.swing.JButton();
        instalacionesDescripcion = new javax.swing.JLabel();
        temporadas = new javax.swing.JButton();
        temporadasDescripcion = new javax.swing.JLabel();
        categorias = new javax.swing.JButton();
        categoriasDescripcion = new javax.swing.JLabel();
        cerrarSesion = new javax.swing.JButton();
        cerrarSesionDescripcion = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(610, 395));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        panelGestion.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 15, 15, 15));
        panelGestion.setLayout(new java.awt.GridBagLayout());

        titulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        titulo.setText("Panel de gestión");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        panelGestion.add(titulo, gridBagConstraints);

        jugadores.setText("Jugadores");
        jugadores.setMaximumSize(new java.awt.Dimension(97, 23));
        jugadores.setMinimumSize(new java.awt.Dimension(97, 23));
        jugadores.setPreferredSize(new java.awt.Dimension(97, 23));
        jugadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jugadoresActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelGestion.add(jugadores, gridBagConstraints);

        jugadoresDescripcion.setText("Esta opción permite gestionar todos los jugadores, esto es: insertar, modificar o eliminar.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        panelGestion.add(jugadoresDescripcion, gridBagConstraints);

        usuarios.setText("Usuarios");
        usuarios.setMaximumSize(new java.awt.Dimension(97, 23));
        usuarios.setMinimumSize(new java.awt.Dimension(97, 23));
        usuarios.setPreferredSize(new java.awt.Dimension(97, 23));
        usuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuariosActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelGestion.add(usuarios, gridBagConstraints);

        usuariosDescripcion.setText("Esta opción permite gestionar todos los usuarios, esto es: insertar, modificar o eliminar.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        panelGestion.add(usuariosDescripcion, gridBagConstraints);

        grupos.setText("Grupos");
        grupos.setMaximumSize(new java.awt.Dimension(97, 23));
        grupos.setMinimumSize(new java.awt.Dimension(97, 23));
        grupos.setPreferredSize(new java.awt.Dimension(97, 23));
        grupos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gruposActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelGestion.add(grupos, gridBagConstraints);

        gruposDescripcion.setText("Esta opción permite gestionar todos los grupos, esto es: insertar, modificar o eliminar.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        panelGestion.add(gruposDescripcion, gridBagConstraints);

        equipos.setText("Equipos");
        equipos.setMaximumSize(new java.awt.Dimension(97, 23));
        equipos.setMinimumSize(new java.awt.Dimension(97, 23));
        equipos.setPreferredSize(new java.awt.Dimension(97, 23));
        equipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                equiposActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelGestion.add(equipos, gridBagConstraints);

        equiposDescripcion.setText("Esta opción permite gestionar todos los equipos, esto es: insertar, modificar o eliminar.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        panelGestion.add(equiposDescripcion, gridBagConstraints);

        partidos.setText("Partidos");
        partidos.setMaximumSize(new java.awt.Dimension(97, 23));
        partidos.setMinimumSize(new java.awt.Dimension(97, 23));
        partidos.setPreferredSize(new java.awt.Dimension(97, 23));
        partidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                partidosActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelGestion.add(partidos, gridBagConstraints);

        partidosDescripcion.setText("Esta opción permite gestionar todos los partidos, esto es: insertar, modificar o eliminar.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        panelGestion.add(partidosDescripcion, gridBagConstraints);

        actividades.setText("Actividades");
        actividades.setMaximumSize(new java.awt.Dimension(97, 23));
        actividades.setMinimumSize(new java.awt.Dimension(97, 23));
        actividades.setPreferredSize(new java.awt.Dimension(97, 23));
        actividades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actividadesActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelGestion.add(actividades, gridBagConstraints);

        acrividadesDescripcion.setText("Esta opción permite gestionar todos los actividades, esto es: insertar, modificar o eliminar.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        panelGestion.add(acrividadesDescripcion, gridBagConstraints);

        pagos.setText("Pagos");
        pagos.setMaximumSize(new java.awt.Dimension(97, 23));
        pagos.setMinimumSize(new java.awt.Dimension(97, 23));
        pagos.setPreferredSize(new java.awt.Dimension(97, 23));
        pagos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pagosActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelGestion.add(pagos, gridBagConstraints);

        pagosDescripcion.setText("Esta opción permite gestionar todos los pagos, esto es: modificar o eliminar.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        panelGestion.add(pagosDescripcion, gridBagConstraints);

        instalaciones.setText("Instalaciones");
        instalaciones.setMaximumSize(new java.awt.Dimension(97, 23));
        instalaciones.setMinimumSize(new java.awt.Dimension(97, 23));
        instalaciones.setPreferredSize(new java.awt.Dimension(97, 23));
        instalaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                instalacionesActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelGestion.add(instalaciones, gridBagConstraints);

        instalacionesDescripcion.setText("Esta opción permite gestionar todos los instalaciones, esto es: insertar, modificar o eliminar.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        panelGestion.add(instalacionesDescripcion, gridBagConstraints);

        temporadas.setText("Temporadas");
        temporadas.setMaximumSize(new java.awt.Dimension(97, 23));
        temporadas.setMinimumSize(new java.awt.Dimension(97, 23));
        temporadas.setPreferredSize(new java.awt.Dimension(97, 23));
        temporadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                temporadasActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelGestion.add(temporadas, gridBagConstraints);

        temporadasDescripcion.setText("Esta opción permite gestionar todas las temporadas, esto es: insertar, modificar o eliminar.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        panelGestion.add(temporadasDescripcion, gridBagConstraints);

        categorias.setText("Categorias");
        categorias.setMaximumSize(new java.awt.Dimension(97, 23));
        categorias.setMinimumSize(new java.awt.Dimension(97, 23));
        categorias.setPreferredSize(new java.awt.Dimension(97, 23));
        categorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoriasActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelGestion.add(categorias, gridBagConstraints);

        categoriasDescripcion.setText("Esta opción permite gestionar todas las categorias, esto es: insertar, modificar o eliminar.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        panelGestion.add(categoriasDescripcion, gridBagConstraints);

        cerrarSesion.setText("Cerrar Sesión");
        cerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarSesionActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelGestion.add(cerrarSesion, gridBagConstraints);

        cerrarSesionDescripcion.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        cerrarSesionDescripcion.setText("Salir del panel de gestión.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        panelGestion.add(cerrarSesionDescripcion, gridBagConstraints);

        getContentPane().add(panelGestion, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void cerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarSesionActionPerformed
    this.dispose();
    new Acceso().setVisible(true);
}//GEN-LAST:event_cerrarSesionActionPerformed

    private void categoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoriasActionPerformed
        new PrincipalCategorias(this, this.accesoBD).setVisible(true);
    }//GEN-LAST:event_categoriasActionPerformed

    private void temporadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_temporadasActionPerformed
        new PrincipalTemporadas(this, this.accesoBD).setVisible(true);
    }//GEN-LAST:event_temporadasActionPerformed

    private void gruposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gruposActionPerformed
        new PrincipalGrupos(this, this.accesoBD).setVisible(true);
    }//GEN-LAST:event_gruposActionPerformed

    private void jugadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jugadoresActionPerformed
        new PrincipalJugadores(this, this.accesoBD).setVisible(true);
    }//GEN-LAST:event_jugadoresActionPerformed

    private void instalacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_instalacionesActionPerformed
        new PrincipalInstalaciones(this, this.accesoBD).setVisible(true);
    }//GEN-LAST:event_instalacionesActionPerformed

    private void actividadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actividadesActionPerformed
        new PrincipalActividades(this, this.accesoBD).setVisible(true);
    }//GEN-LAST:event_actividadesActionPerformed

    private void pagosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pagosActionPerformed
        new PrincipalPagos(this, this.accesoBD).setVisible(true);
    }//GEN-LAST:event_pagosActionPerformed

    private void equiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_equiposActionPerformed
        new PrincipalEquipos(this, this.accesoBD).setVisible(true);
    }//GEN-LAST:event_equiposActionPerformed

    private void partidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_partidosActionPerformed
        new PrincipalPartidos(this, this.accesoBD).setVisible(true);
    }//GEN-LAST:event_partidosActionPerformed

    private void usuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuariosActionPerformed
        new PrincipalUsuarios(this, this.accesoBD).setVisible(true);
    }//GEN-LAST:event_usuariosActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        new Acceso().setVisible(true);
    }//GEN-LAST:event_formWindowClosing
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel acrividadesDescripcion;
    private javax.swing.JButton actividades;
    private javax.swing.JButton categorias;
    private javax.swing.JLabel categoriasDescripcion;
    private javax.swing.JButton cerrarSesion;
    private javax.swing.JLabel cerrarSesionDescripcion;
    private javax.swing.JButton equipos;
    private javax.swing.JLabel equiposDescripcion;
    private javax.swing.JButton grupos;
    private javax.swing.JLabel gruposDescripcion;
    private javax.swing.JButton instalaciones;
    private javax.swing.JLabel instalacionesDescripcion;
    private javax.swing.JButton jugadores;
    private javax.swing.JLabel jugadoresDescripcion;
    private javax.swing.JButton pagos;
    private javax.swing.JLabel pagosDescripcion;
    private javax.swing.JPanel panelGestion;
    private javax.swing.JButton partidos;
    private javax.swing.JLabel partidosDescripcion;
    private javax.swing.JButton temporadas;
    private javax.swing.JLabel temporadasDescripcion;
    private javax.swing.JLabel titulo;
    private javax.swing.JButton usuarios;
    private javax.swing.JLabel usuariosDescripcion;
    // End of variables declaration//GEN-END:variables
}
