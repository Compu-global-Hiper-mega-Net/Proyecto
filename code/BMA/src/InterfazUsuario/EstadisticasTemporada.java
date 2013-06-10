
package InterfazUsuario;

import GestionDeTemporadas.GestorTemporadas;
import ServiciosAlmacenamiento.BaseDatos;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;


/**
 * ****************************************************************************
 * (c) Copyright 2013
 *
 * Moisés Gautier Gómez Julio Ros Martínez Francisco Javier Gómez del Olmo
 * Francisco Santolalla Quiñonero Carlos Jesús Fernández Basso Alexander Moreno
 * Borrego Jesús Manuel Contreras Siles Diego Muñoz Rio
 *
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************
 */

/**
 * Clase para estadisticas de temporada del paquete InterfazUsuario. Ofrece una manera
 * de interactuar con  los elementos de la interfaz de estadisticas y diversas funcionalidades
 * para estos elementos.
 * @author Javier
 * @version 1.0
 */

public class EstadisticasTemporada extends javax.swing.JFrame {

    BaseDatos accesoBD;
    ResultSet retset;
    String temporadaElegida;
    JFreeChart Grafica;
    ChartPanel Panel ;
    JFrame Ventana ;
    DefaultCategoryDataset Datos = new DefaultCategoryDataset();
    DefaultTableModel dtm = new DefaultTableModel();
    List<Integer> pGanados = new ArrayList<>();
    List<Integer> pPerdidos = new ArrayList<>();
    
    
    /**
     * Constructor sin parametros de la clase
    */ 
    public EstadisticasTemporada() {
        initComponents();
    }
    
    
    /**
     * Constructor con parametros de la clase, usado para inicializar varios componentes 
     * y hacer una llamada al metodo actualizaComboCategoria().
     * @param acceso parametro de tipo BaseDatos usado para acceder a la base de datos.
     * @param tempElegida parametro de tipo String usado para obtener de la interfaz 
     * principal la temporada elegida para mostrarla en esta interfaz.
     */
    public EstadisticasTemporada(BaseDatos acceso, String tempElegida) {

        accesoBD = acceso;
        initComponents();
        temporadaElegida = tempElegida;
        temporadaElegidaTexto.setText(temporadaElegida);
        try {
            actualizaComboCategoria();
        } catch (SQLException ex) {
            Logger.getLogger(EstadisticasTemporada.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    /**
     * Metodo que actualiza la tabla que se va a mostrar en las estadisticas de la temporada,
     * para ello hace dos consultas a las base de datos para obtener el idTemporada y el  
     * idCategoria respectivamente, seguidamente obtiene los datos de la consulta principal 
     * haciendo una llamada al metodo consultarEstadisticasTemporada(accesoBD, idTemp, idCate)
     * de GestorTemporadas y por ultimo va actualizando los datos de la tabla con los resultados
     * obtenidos en retset de la consulta principal y haciendo para cada fila dos consultas para
     * obtener para cada equipo el numero de  partidos que ha ganadao y de partidos que ha perdido 
     * respectivamente.
     * @throws SQLException Excepción que se lanza cuando hay un problema con la BD.
     */
    private void actualizaTablaEstadisticas() throws SQLException {

        int idTemp = 0, idCate = 0;

        String consulta = "SELECT idTemporada FROM mydb.temporada WHERE curso='" + temporadaElegida + "';";
        ResultSet res1 = accesoBD.ejecutaConsulta(consulta);
        if (res1.next()) {
            idTemp = res1.getInt(1);
        }

        consulta = "SELECT idCategoria FROM mydb.categoria WHERE tipo='" + elegirCategoriaLista.getSelectedItem().toString() + "';";
        ResultSet res2 = accesoBD.ejecutaConsulta(consulta);
        if (res2.next()) {
            idCate = res2.getInt(1);
        }

        retset = GestorTemporadas.consultarEstadisticasTemporada(accesoBD, idTemp, idCate);

        if (retset == null) {
           JOptionPane.showMessageDialog(null,"No hay datos que mostrar para la temporada");  
        } else {
            DefaultTableModel dtm = new DefaultTableModel();
            dtm.addColumn("Equipo");
            dtm.addColumn("Entrenador");
            dtm.addColumn("Partidos ganados");
            dtm.addColumn("Partidos perdidos");
            dtm.addColumn("Total puntos liga");

            Object[] fila = new Object[6];

            while (retset.next()) {

                fila[0] = retset.getString(1);

                String entrenador = retset.getString(2) + " " + retset.getString(3) + " " + retset.getString(4);
                fila[1] = entrenador;

                String consulta3 = "SELECT COUNT(*) FROM partido p, equipo e WHERE (resultadoLocal > resultadoVisitante)"
                        + "AND p.idEquipo=e.idEquipo AND e.nombre='" + (String) fila[0] + "'";
                System.out.printf(consulta3);
                ResultSet res3 = accesoBD.ejecutaConsulta(consulta3);
                if (res3.next()) {
                    fila[2] = res3.getString(1);
                    pGanados.add(res3.getInt(1));
                }

                String consulta4 = "SELECT COUNT(*) FROM partido p, equipo e WHERE (resultadoLocal < resultadoVisitante)"
                        + "AND p.idEquipo=e.idEquipo AND e.nombre='" + (String) fila[0] + "'";
                System.out.printf(consulta4);
                ResultSet res4 = accesoBD.ejecutaConsulta(consulta4);
                if (res4.next()) {
                    fila[3] = res4.getString(1);
                    pPerdidos.add(res4.getInt(1));
                }

                fila[4] = retset.getString(5);

                dtm.addRow(fila);
            }

            tablaTemporadaEstadisticas.setModel(dtm);
        }
    }
    

    /**
     * Metodo que actualiza el combo con la lista de categorias existentes en la base
     * de datos, para ello hace una consulta para obtener estos datos.
     * @throws SQLException Excepción que se lanza cuando hay un problema con la BD.
     */
    private void actualizaComboCategoria() throws SQLException {
        elegirCategoriaLista.removeAllItems();
        elegirCategoriaLista.addItem(" ");

        String consulta = "SELECT DISTINCT tipo FROM categoria;";
        ResultSet res = accesoBD.ejecutaConsulta(consulta);
        while (res.next()) {
            elegirCategoriaLista.addItem(res.getString(1));
        }
    }
    
    
    /**
    * Metodo que actualiza las graficas que se muestran con los datos de temporadas, 
    * para ello primero se comprueba que grupo de datos de ha elegido en la interfaz 
    * (pudiendo elegir varios o uno solo) y seguidamente se añaden a Datos todos los 
    * datos obtenidos en cunsultas anteriores los cuales se mostraran en  la grafica.
    * @throws SQLException Excepción que se lanza cuando hay un problema con la BD.
    */
    private void actualizaGraficas() throws SQLException {
        
        int i=0, j=0;

        try {
            if (estadisticasPartidosGanados.isSelected()){
                retset.beforeFirst();
                while(retset.next()){
                    Datos.addValue(pGanados.get(i), (Comparable) tablaTemporadaEstadisticas.getColumnName(2), (Comparable) retset.getString(1)); 
                    i++;
                }
            }
            if(estadisticasPartidosPerdidos.isSelected()){
                retset.beforeFirst();
                while(retset.next()){
                    Datos.addValue(pPerdidos.get(j), (Comparable) tablaTemporadaEstadisticas.getColumnName(3), (Comparable) retset.getString(1));
                        j++;
                }
            }
            if(estadisticasPuntosLiga.isSelected()){
                retset.beforeFirst();
                while(retset.next())
                     Datos.addValue(retset.getInt(5), (Comparable) tablaTemporadaEstadisticas.getColumnName(4), (Comparable) retset.getString(1)); 
            }
        } catch (SQLException ex) {
              Logger.getLogger(EstadisticasJugador.class.getName()).log(Level.SEVERE, null, ex);
        }

        Grafica = ChartFactory.createBarChart3D(null, "Equipos", null,
                                               Datos, PlotOrientation.HORIZONTAL, true, true, false);  
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelTabEstTemp = new javax.swing.JScrollPane();
        tablaTemporadaEstadisticas = new javax.swing.JTable();
        botonSalir = new javax.swing.JToggleButton();
        temporadaLab = new javax.swing.JLabel();
        elegirCategoriaLab = new javax.swing.JLabel();
        elegirCategoriaLista = new javax.swing.JComboBox();
        botonMostrarEstadisticasTemporada = new javax.swing.JButton();
        temporadaElegidaTexto = new javax.swing.JLabel();
        mostrarGraficasTemporada = new javax.swing.JButton();
        estadisticasPuntosLiga = new javax.swing.JCheckBox();
        estadisticasPartidosPerdidos = new javax.swing.JCheckBox();
        estadisticasPartidosGanados = new javax.swing.JCheckBox();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panelTabEstTemp.setAutoscrolls(true);

        tablaTemporadaEstadisticas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tablaTemporadaEstadisticas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Equipo", "Entrenador ", "Partidos ganados", "Partidos perdidos", "Total  puntos  liga"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tablaTemporadaEstadisticas.setColumnSelectionAllowed(true);
        panelTabEstTemp.setViewportView(tablaTemporadaEstadisticas);
        tablaTemporadaEstadisticas.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        botonSalir.setText("Salir");
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });

        temporadaLab.setText("Temporada:");

        elegirCategoriaLab.setText("Elegir categoría:");

        elegirCategoriaLista.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        elegirCategoriaLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                elegirCategoriaListaActionPerformed(evt);
            }
        });

        botonMostrarEstadisticasTemporada.setText("Mostrar");
        botonMostrarEstadisticasTemporada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMostrarEstadisticasTemporadaActionPerformed(evt);
            }
        });

        mostrarGraficasTemporada.setText("Ver Graficas");
        mostrarGraficasTemporada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarGraficasTemporadaActionPerformed(evt);
            }
        });

        estadisticasPuntosLiga.setText("Datos Graficas");

        estadisticasPartidosPerdidos.setText("Datos Graficas");

        estadisticasPartidosGanados.setText("Datos Graficas");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Estadísticas Temporada");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(temporadaLab)
                        .addGap(18, 18, 18)
                        .addComponent(temporadaElegidaTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(elegirCategoriaLab)
                        .addGap(18, 18, 18)
                        .addComponent(elegirCategoriaLista, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonMostrarEstadisticasTemporada))
                    .addComponent(panelTabEstTemp, javax.swing.GroupLayout.DEFAULT_SIZE, 856, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(estadisticasPartidosGanados)
                        .addGap(66, 66, 66)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(estadisticasPartidosPerdidos)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(estadisticasPuntosLiga))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(mostrarGraficasTemporada, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(61, 61, 61)
                                .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(20, 20, 20)))
                .addGap(31, 31, 31))
            .addGroup(layout.createSequentialGroup()
                .addGap(399, 399, 399)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(temporadaLab)
                    .addComponent(elegirCategoriaLab)
                    .addComponent(elegirCategoriaLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonMostrarEstadisticasTemporada)
                    .addComponent(temporadaElegidaTexto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(panelTabEstTemp, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(estadisticasPuntosLiga)
                    .addComponent(estadisticasPartidosPerdidos)
                    .addComponent(estadisticasPartidosGanados))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonSalir)
                    .addComponent(mostrarGraficasTemporada))
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Metodo que al pulsar el boton para salir de la interfaz de estadistics de 
     * la temporada cierra esta ventana.
     * @param evt parametro de tipo java.awt.event.ActionEvent
     */
    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed

        this.setVisible(false);
    }//GEN-LAST:event_botonSalirActionPerformed

    
    private void elegirCategoriaListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_elegirCategoriaListaActionPerformed
    }//GEN-LAST:event_elegirCategoriaListaActionPerformed

    
    /**
     * Metodo que actualiza la tabla que muestra los datos de las estadisticas cada 
     * vez que se pulsa el boton Mostrar de la interfaz, despues de borrar los datos 
     * anteriones de  la tabla comprueba que se haya elegido una categoria del combo y 
     * si no es asi muestra un mensaje indicando que se elija una categoria. Una vez
     * elegida la categoria se llama al metodo actualizaTablaEstadisticas() que actualiza
     * la tabla con los nuevos datos.
     * @param evt parametro de tipo java.awt.event.ActionEvent
     */
    private void botonMostrarEstadisticasTemporadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMostrarEstadisticasTemporadaActionPerformed
        
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("Posicion");
        dtm.addColumn("Nombre equipo");
        dtm.addColumn("Partidos jugados");
        dtm.addColumn("Partidos ganados");
        dtm.addColumn("Partidos perdidos");
        dtm.addColumn("Puntos a favor");
        dtm.addColumn("Puntos en contra");
        tablaTemporadaEstadisticas.setModel(dtm);
        
        if (elegirCategoriaLista.getSelectedItem().equals(" ")) {
            JOptionPane.showMessageDialog(null, "Seleccione una categoria para ver estadisticas");
        } else {
            try {
                actualizaTablaEstadisticas();
            } catch (SQLException ex) {
                Logger.getLogger(EstadisticasTemporada.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_botonMostrarEstadisticasTemporadaActionPerformed

    
    /**
     * Metodo que al pulsar el boton para ver las graficas de las estadisticas de la 
     * temporada comprueba que al menos se haya seleccionado un grupo de datos para
     * mostrar la grafica, mientras no sea asi mostrara un mensaje indicando que se 
     * seleccione uno o varios grupos de datos. Seguidamente hace una llamada a 
     * actualizaGraficas() donde se van a introducir los datos de la grafica en Datos 
     * y por ultimo se crea una nueva ventana que muestra la grafica.
     * @param evt parametro de tipo java.awt.event.ActionEvent
     */
    private void mostrarGraficasTemporadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrarGraficasTemporadaActionPerformed
        
        if(!estadisticasPartidosGanados.isSelected()&& !estadisticasPartidosPerdidos.isSelected() && !estadisticasPuntosLiga.isSelected())
              JOptionPane.showMessageDialog(null,"Seleccione al menos un grupo de datos para ver grafica");                                           
         else{
             try {
                 Datos.clear();
                 actualizaGraficas();
             } catch (SQLException ex) {
                 Logger.getLogger(EstadisticasJugador.class.getName()).log(Level.SEVERE, null, ex);
             }
             Panel = new ChartPanel(Grafica);
             Ventana = new JFrame("Gráficas");
             Ventana.getContentPane().add(Panel);
             Ventana.pack();
             Ventana.setVisible(true);
             Ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
         }
    }//GEN-LAST:event_mostrarGraficasTemporadaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonMostrarEstadisticasTemporada;
    private javax.swing.JToggleButton botonSalir;
    private javax.swing.JLabel elegirCategoriaLab;
    private javax.swing.JComboBox elegirCategoriaLista;
    private javax.swing.JCheckBox estadisticasPartidosGanados;
    private javax.swing.JCheckBox estadisticasPartidosPerdidos;
    private javax.swing.JCheckBox estadisticasPuntosLiga;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton mostrarGraficasTemporada;
    private javax.swing.JScrollPane panelTabEstTemp;
    private javax.swing.JTable tablaTemporadaEstadisticas;
    private javax.swing.JLabel temporadaElegidaTexto;
    private javax.swing.JLabel temporadaLab;
    // End of variables declaration//GEN-END:variables
}
