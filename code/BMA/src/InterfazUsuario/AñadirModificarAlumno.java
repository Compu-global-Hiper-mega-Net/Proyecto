/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfazUsuario;

import GestionDeAlumnos.GestorAlumnos;
import ServiciosAlmacenamiento.BaseDatos;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.Color;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

/**
 *
 * @author Alex
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

public class AñadirModificarAlumno extends javax.swing.JFrame {
    private PrincipalJugadores pP;
    private BaseDatos bd;
    private Border bordeOriginal, bordeDatePicker, bordeError;
    private String nombreAnt, primerApellidoAnt, segundoApellidoAnt, cuentaCorrienteAnt, domicilioAnt, localidadAnt,
            provinciaAnt, colegioAnt, nombrePadreAnt, nombreMadreAnt, emailAnt, tallaAlumnoAnt, sexoAnt, fechaNacAnt;
    private int codPostalAnt, telFijoAnt, telMovilAnt;

    /**
     * Creates new form AnadorAlumno
     */
    public AñadirModificarAlumno(PrincipalJugadores pP, BaseDatos bd) {
        this.pP = pP;
        this.bd = bd;
        initComponents();
        bordeOriginal = nombre.getBorder();
        bordeDatePicker = fechaNac.getBorder();
        bordeError = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.red);
        ((JTextFieldDateEditor) fechaNac.getComponents()[1]).setEditable(false);
        jLabel4.setVisible(false);
    }
    
    public AñadirModificarAlumno(PrincipalJugadores pP, BaseDatos bd, String nombre, String primerApellido, String segundoApellido, String fechaNac,
            String cuentaCorriente, String domicilio, String localidad, int codPostal, String provincia, String colegio,
            String nombrePadre, String nombreMadre, int telFijo, int telMovil, String email, String tallaAlumno, String sexo) {
        this.pP = pP;
        this.bd = bd;
        initComponents();
        bordeOriginal = this.nombre.getBorder();
        bordeDatePicker = this.fechaNac.getBorder();
        bordeError = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.red);
        ((JTextFieldDateEditor) this.fechaNac.getComponents()[1]).setEditable(false);
        jLabel2.setVisible(false);
        nombreAnt = nombre;
        this.nombre.setText(nombre);
        primerApellidoAnt = primerApellido;
        this.primerApellido.setText(primerApellido);
        segundoApellidoAnt = segundoApellido;
        this.segundoApellido.setText(segundoApellido);
        fechaNacAnt = fechaNac;
        this.fechaNac.setDate(new Date(fechaNac));
        cuentaCorrienteAnt = cuentaCorriente;
        this.numCuenta.setText(cuentaCorriente);
        domicilioAnt = domicilio;
        this.domicilio.setText(domicilioAnt);
        localidadAnt = localidad;
        this.localidad.setText(localidad);
        codPostalAnt = codPostal;
        this.codPostal.setText(String.valueOf(codPostal));
        provinciaAnt = provincia;
        this.provincia.setText(provincia);
        colegioAnt = colegio;
        this.colegio.setText(colegio);
        nombrePadreAnt = nombrePadre;
        this.nombrePadre.setText(nombrePadre);
        nombreMadreAnt = nombreMadre;
        this.nombreMadre.setText(nombreMadre);
        telFijoAnt = telFijo;
        this.telFijo.setText(String.valueOf(telFijo));
        telMovilAnt = telMovil;
        this.telMovil.setText(String.valueOf(telMovil));
        emailAnt = email;
        this.email.setText(email);
        tallaAlumnoAnt = tallaAlumno;
        this.talla.setSelectedItem(tallaAlumno);
        sexoAnt = sexo;
        if (sexo.equals("M")) this.sexoAlumno.setSelectedItem("Masculino");
        else this.sexoAlumno.setSelectedItem("Femenino");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        colegioLabel = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        talla = new javax.swing.JComboBox();
        provincia = new javax.swing.JTextField();
        tallaLabel = new javax.swing.JLabel();
        codPostalLabel = new javax.swing.JLabel();
        participante = new javax.swing.JLabel();
        nombreLabel = new javax.swing.JLabel();
        segundoApellido = new javax.swing.JTextField();
        nombrePadre = new javax.swing.JTextField();
        datosFamiliares = new javax.swing.JLabel();
        domicilio = new javax.swing.JTextField();
        nombreMadre = new javax.swing.JTextField();
        botonAnadir = new javax.swing.JButton();
        telFijoLabel = new javax.swing.JLabel();
        separador = new javax.swing.JSeparator();
        nombreMadreLabel = new javax.swing.JLabel();
        nombrePadreLabel = new javax.swing.JLabel();
        numCuentaLabel = new javax.swing.JLabel();
        telMovilLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        localidad = new javax.swing.JTextField();
        telMovil = new javax.swing.JTextField();
        primerApellido = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        colegio = new javax.swing.JTextField();
        fechaNacLabel = new javax.swing.JLabel();
        telFijo = new javax.swing.JTextField();
        fechaNac = new com.toedter.calendar.JDateChooser();
        domicilioLabel = new javax.swing.JLabel();
        localidadLabel = new javax.swing.JLabel();
        primerApellidoLabel = new javax.swing.JLabel();
        segundoApellidoLabel = new javax.swing.JLabel();
        codPostal = new javax.swing.JTextField();
        numCuenta = new javax.swing.JTextField();
        provinciaLabel = new javax.swing.JLabel();
        sexoAlumno = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        botonModificar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nuevo alumno");
        setMinimumSize(new java.awt.Dimension(850, 480));
        setResizable(false);

        jPanel1.setMaximumSize(new java.awt.Dimension(807, 450));
        jPanel1.setMinimumSize(new java.awt.Dimension(807, 450));
        jPanel1.setPreferredSize(new java.awt.Dimension(807, 450));

        colegioLabel.setText("Colegio:");

        nombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                nombreFocusLost(evt);
            }
        });

        talla.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SinMedir", "6", "8", "10", "12", "XS", "S", "M", "L", "XL", "XXL" }));

        provincia.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                provinciaFocusLost(evt);
            }
        });

        tallaLabel.setText("Talla:");

        codPostalLabel.setText("Codigo Postal:");

        participante.setBackground(new java.awt.Color(191, 138, 138));
        participante.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        participante.setForeground(new java.awt.Color(242, 236, 236));
        participante.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        participante.setText("PARTICIPANTE");
        participante.setOpaque(true);

        nombreLabel.setText("Nombre:");

        segundoApellido.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                segundoApellidoFocusLost(evt);
            }
        });

        nombrePadre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                nombrePadreFocusLost(evt);
            }
        });

        datosFamiliares.setBackground(new java.awt.Color(134, 190, 134));
        datosFamiliares.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        datosFamiliares.setForeground(new java.awt.Color(242, 236, 236));
        datosFamiliares.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        datosFamiliares.setText("DATOS FAMILIARES");
        datosFamiliares.setOpaque(true);

        domicilio.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                domicilioFocusLost(evt);
            }
        });

        nombreMadre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                nombreMadreFocusLost(evt);
            }
        });

        botonAnadir.setText("Aceptar");
        botonAnadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAnadirActionPerformed(evt);
            }
        });

        telFijoLabel.setText("Telefono Fijo:");

        nombreMadreLabel.setText("Nombre Madre:");

        nombrePadreLabel.setText("Nombre Padre:");

        numCuentaLabel.setText("Numero Cuenta:");

        telMovilLabel.setText("Telefono Móvil:");

        emailLabel.setText("Email:");

        localidad.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                localidadFocusLost(evt);
            }
        });

        telMovil.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                telMovilFocusLost(evt);
            }
        });

        primerApellido.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                primerApellidoFocusLost(evt);
            }
        });

        email.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                emailFocusLost(evt);
            }
        });

        colegio.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                colegioFocusLost(evt);
            }
        });

        fechaNacLabel.setText("Fecha Nacimiento: ");

        telFijo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                telFijoFocusLost(evt);
            }
        });

        fechaNac.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                fechaNacFocusLost(evt);
            }
        });

        domicilioLabel.setText("Domicilio:");

        localidadLabel.setText("Localidad:");

        primerApellidoLabel.setText("Primer apellido:");

        segundoApellidoLabel.setText("Segundo apellido:");

        codPostal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                codPostalFocusLost(evt);
            }
        });

        numCuenta.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                numCuentaFocusLost(evt);
            }
        });

        provinciaLabel.setText("Provincia:");

        sexoAlumno.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Masculino", "Femenino" }));

        jLabel1.setText("Sexo:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Nuevo Jugador");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Modificar Jugador");

        botonModificar.setText("Guardar");
        botonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonModificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(334, 334, 334)
                        .addComponent(jLabel4)))
                .addGap(0, 466, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sexoAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(311, 311, 311))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(botonAnadir, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(187, 187, 187))))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(participante, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(separador, javax.swing.GroupLayout.PREFERRED_SIZE, 910, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(datosFamiliares, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(30, 30, 30)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(nombreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(180, 180, 180)
                                    .addComponent(primerApellidoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, 0)
                                    .addComponent(primerApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(30, 30, 30)
                                    .addComponent(segundoApellidoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, 0)
                                    .addComponent(segundoApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(fechaNacLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, 0)
                                    .addComponent(fechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(40, 40, 40)
                                    .addComponent(tallaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, 0)
                                    .addComponent(talla, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(domicilioLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, 0)
                                    .addComponent(domicilio, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(localidadLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(50, 50, 50)
                                            .addComponent(localidad, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(30, 30, 30)
                                    .addComponent(codPostalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, 0)
                                    .addComponent(codPostal, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(30, 30, 30)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(provinciaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(50, 50, 50)
                                            .addComponent(provincia, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(colegioLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, 0)
                                    .addComponent(colegio, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(nombrePadreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, 0)
                                    .addComponent(nombrePadre, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(nombreMadreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(telFijoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(nombreMadre, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(telFijo, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(35, 35, 35)
                                            .addComponent(telMovilLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, 0)
                                            .addComponent(telMovil, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(emailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, 0)
                                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(numCuentaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(3, 3, 3)
                                    .addComponent(numCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(344, Short.MAX_VALUE)
                    .addComponent(jLabel2)
                    .addContainerGap(474, Short.MAX_VALUE)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(615, Short.MAX_VALUE)
                    .addComponent(botonModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(187, 187, 187)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addGap(54, 54, 54)
                .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(sexoAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 193, Short.MAX_VALUE)
                .addComponent(botonAnadir)
                .addGap(114, 114, 114))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 20, Short.MAX_VALUE)
                    .addComponent(participante, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(20, 20, 20)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(nombreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(primerApellidoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(primerApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(segundoApellidoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(segundoApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(10, 10, 10)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(fechaNacLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(fechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tallaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(talla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(10, 10, 10)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(domicilioLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(domicilio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(10, 10, 10)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(localidadLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(localidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(codPostalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(codPostal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(provinciaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(provincia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(10, 10, 10)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(colegioLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(colegio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(20, 20, 20)
                    .addComponent(separador, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)
                    .addComponent(datosFamiliares, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(20, 20, 20)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(nombrePadreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(nombrePadre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(10, 10, 10)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(nombreMadreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(telFijoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(nombreMadre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(telFijo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(telMovilLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(telMovil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGap(10, 10, 10)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(emailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(10, 10, 10)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(numCuentaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(numCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 20, Short.MAX_VALUE)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(jLabel2)
                    .addGap(0, 435, Short.MAX_VALUE)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(313, Short.MAX_VALUE)
                    .addComponent(botonModificar)
                    .addGap(114, 114, 114)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 850, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 21, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 22, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 16, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 14, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nombreFocusLost
        if (nombre.getText().isEmpty() || nombre.getText().length() > 45) {
            nombre.setBorder(bordeError);
        } else {
            nombre.setBorder(bordeOriginal);
        }
    }//GEN-LAST:event_nombreFocusLost

    private void primerApellidoFocusLost(java.awt.event.FocusEvent evt) {
        if (primerApellido.getText().isEmpty() || primerApellido.getText().length() > 45) {
            primerApellido.setBorder(bordeError);
        } else {
            primerApellido.setBorder(bordeOriginal);
        }
    }

    private void segundoApellidoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_primerApellidoFocusLost
        if (segundoApellido.getText().isEmpty() || segundoApellido.getText().length() > 45) {
            segundoApellido.setBorder(bordeError);
        } else {
            segundoApellido.setBorder(bordeOriginal);
        }
    }//GEN-LAST:event_primerApellidoFocusLost

    private void botonAnadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAnadirActionPerformed
        String campos = "";

        if (!nombre.getText().matches("[a-zA-Z]{1,45}")) {
            campos = campos + "'Nombre',";
            nombre.setBorder(bordeError);
        }
        if (!primerApellido.getText().matches("[a-zA-Z]{1,45}")) {
            campos = campos + "'Primer apellido',";
            primerApellido.setBorder(bordeError);
        }
        if (!segundoApellido.getText().matches("[a-zA-Z]{1,45}")) {
            campos = campos + "'Segundo apellido',";
            segundoApellido.setBorder(bordeError);
        }
        Date dateFromDateChooser = fechaNac.getDate();
        String dateString = String.format("%1$tY-%1$tm-%1$td", dateFromDateChooser);
        if (dateString.equals("null-null-null")) {
            campos = campos + "'Fecha de nacimiento',";
            fechaNac.setBorder(bordeError);
        }
        if (!domicilio.getText().matches("[a-zA-Z0-9/ºª.,()-]{1,100}")) {
            campos = campos + "'Domicilio',";
            domicilio.setBorder(bordeError);
        }
        if (!localidad.getText().matches("[a-zA-Z-]{1,45}")) {
            campos = campos + "'Localidad',";
            localidad.setBorder(bordeError);
        }
        if (!codPostal.getText().matches("[0-9]{1,10}")) {
            campos = campos + "'Codigo postal',";
            codPostal.setBorder(bordeError);
        }
        if (!provincia.getText().matches("[a-zA-Z-]{1,70}")) {
            campos = campos + "'Provincia',";
            provincia.setBorder(bordeError);
        }
        if (!colegio.getText().matches("[a-zA-Z-]{1,45}")) {
            campos = campos + "'Colegio',";
            colegio.setBorder(bordeError);
        }
        if (!nombrePadre.getText().matches("[a-zA-Z-]{1,100}")) {
            campos = campos + "'Nombre padre',";
            nombrePadre.setBorder(bordeError);
        }
        if (!nombreMadre.getText().matches("[a-zA-Z-]{1,100}")) {
            campos = campos + "'Nombre madre',";
            nombreMadre.setBorder(bordeError);
        }
        if (!telFijo.getText().matches("[0-9]{1,30}")) {
            campos = campos + "'Telefono fijo',";
            telFijo.setBorder(bordeError);
        }
        if (!telMovil.getText().matches("[0-9]{1,30}")) {
            campos = campos + "'Telefono movil',";
            telMovil.setBorder(bordeError);
        }
        if (!email.getText().matches("[a-zA-Z0-9_-]{1,45}@[a-zA-Z0-9_-]{1,25}.[a-z]{1,5}")) {
            campos = campos + "'Email',";
            email.setBorder(bordeError);
        }
        if (!numCuenta.getText().matches("[0-9]{1,40}")) {
            campos = campos + "'Telefono movil',";
            numCuenta.setBorder(bordeError);
        }
        //Si no ha habido ningún error al introducir los campos, entonces hacemos el insert
        if (campos.isEmpty()) {
            boolean error = GestorAlumnos.darAltaAlumno(bd, nombre.getText(), primerApellido.getText(), segundoApellido.getText(), dateFromDateChooser,
                    numCuenta.getText(), domicilio.getText(), localidad.getText(),
                    Integer.parseInt(codPostal.getText()), provincia.getText(), colegio.getText(), nombrePadre.getText(),
                    nombreMadre.getText(), Integer.parseInt(telFijo.getText()), Integer.parseInt(telMovil.getText()), email.getText(), "",
                    (String) talla.getSelectedItem(), (String) sexoAlumno.getSelectedItem());

            if(false==error){
                JOptionPane.showMessageDialog(null, "Ha habido un error en la base de datos",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "Alumno creado con exito",
                        "Confirmacion", JOptionPane.INFORMATION_MESSAGE);
            }
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Se han encontrado errores en los siguientes campos:\n" +
                    campos.substring(0, campos.length() - 1),
                    "Errores en el formulario", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_botonAnadirActionPerformed

    private void fechaNacFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fechaNacFocusLost
        Date dateFromDateChooser = fechaNac.getDate();
        String dateString = String.format("%1$tY-%1$tm-%1$td", dateFromDateChooser);
        if (dateString.equals("null-null-null")) {
            fechaNac.setBorder(bordeError);
        } else {
            fechaNac.setBorder(bordeDatePicker);
        }
    }//GEN-LAST:event_fechaNacFocusLost

    private void domicilioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_domicilioFocusLost
        if (domicilio.getText().isEmpty() || domicilio.getText().length() > 100) {
            domicilio.setBorder(bordeError);
        } else {
            domicilio.setBorder(bordeOriginal);
        }
    }//GEN-LAST:event_domicilioFocusLost

    private void localidadFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_localidadFocusLost
        if (localidad.getText().isEmpty() || localidad.getText().length() > 45) {
            localidad.setBorder(bordeError);
        } else {
            localidad.setBorder(bordeOriginal);
        }
    }//GEN-LAST:event_localidadFocusLost

    private void codPostalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_codPostalFocusLost
        if (codPostal.getText().isEmpty() || codPostal.getText().length() > 10 || !isInteger(codPostal.getText())) {
            codPostal.setBorder(bordeError);
        } else {
            codPostal.setBorder(bordeOriginal);
        }
    }//GEN-LAST:event_codPostalFocusLost

    private void provinciaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_provinciaFocusLost
        if (provincia.getText().isEmpty() || provincia.getText().length() > 70) {
            provincia.setBorder(bordeError);
        } else {
            provincia.setBorder(bordeOriginal);
        }
    }//GEN-LAST:event_provinciaFocusLost

    private void colegioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_colegioFocusLost
        if (colegio.getText().isEmpty() || colegio.getText().length() > 45) {
            colegio.setBorder(bordeError);
        } else {
            colegio.setBorder(bordeOriginal);
        }
    }//GEN-LAST:event_colegioFocusLost

    private void nombrePadreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nombrePadreFocusLost
        if (nombrePadre.getText().isEmpty() || nombrePadre.getText().length() > 100) {
            nombrePadre.setBorder(bordeError);
        } else {
            nombrePadre.setBorder(bordeOriginal);
        }
    }//GEN-LAST:event_nombrePadreFocusLost

    private void nombreMadreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nombreMadreFocusLost
        if (nombreMadre.getText().isEmpty() || nombreMadre.getText().length() > 100) {
            nombreMadre.setBorder(bordeError);
        } else {
            nombreMadre.setBorder(bordeOriginal);
        }
    }//GEN-LAST:event_nombreMadreFocusLost

    private void telFijoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_telFijoFocusLost
        if (telFijo.getText().isEmpty() || telFijo.getText().length() > 30 || !isInteger(telFijo.getText())) {
            telFijo.setBorder(bordeError);
        } else {
            telFijo.setBorder(bordeOriginal);
        }
    }//GEN-LAST:event_telFijoFocusLost

    private void telMovilFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_telMovilFocusLost
        if (telMovil.getText().isEmpty() || telMovil.getText().length() > 30 || !isInteger(telMovil.getText())) {
            telMovil.setBorder(bordeError);
        } else {
            telMovil.setBorder(bordeOriginal);
        }
    }//GEN-LAST:event_telMovilFocusLost

    private void emailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emailFocusLost
        if (email.getText().isEmpty() || email.getText().length() > 75) {
            email.setBorder(bordeError);
        } else {
            email.setBorder(bordeOriginal);
        }
    }//GEN-LAST:event_emailFocusLost

    private void numCuentaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_numCuentaFocusLost
        if (numCuenta.getText().isEmpty() || numCuenta.getText().length() > 40) {
            numCuenta.setBorder(bordeError);
        } else {
            numCuenta.setBorder(bordeOriginal);
        }
    }//GEN-LAST:event_numCuentaFocusLost

    private void botonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonModificarActionPerformed
        if (!nombre.getText().equals(nombreAnt) || !primerApellido.getText().equals(primerApellidoAnt)
                || !segundoApellido.getText().equals(segundoApellidoAnt)
                || !numCuenta.getText().equals(cuentaCorrienteAnt) || !domicilio.getText().equals(domicilioAnt)
                || !localidad.getText().equals(localidadAnt) || !codPostal.getText().equals(String.valueOf(codPostalAnt))
                || !provincia.getText().equals(provinciaAnt) || !colegio.getText().equals(colegioAnt)
                || !nombrePadre.getText().equals(nombrePadreAnt) || !nombreMadre.getText().equals(nombreMadreAnt)
                || !telFijo.getText().equals(String.valueOf(telFijoAnt)) || !telMovil.getText().equals(String.valueOf(telMovilAnt))
                || !email.getText().equals(emailAnt) || !((String)talla.getSelectedItem()).equals(tallaAlumnoAnt)
                || !((String)sexoAlumno.getSelectedItem()).substring(0, 1).equals(sexoAnt)) {
            GestorAlumnos.modificarDatos(bd, emailAnt, nombreAnt, primerApellidoAnt, segundoApellidoAnt, fechaNacAnt, cuentaCorrienteAnt, domicilioAnt, localidadAnt, nombreAnt, provinciaAnt, colegioAnt, nombrePadreAnt, nombreMadreAnt, sexoAnt, sexoAnt, emailAnt, colegioAnt, tallaAlumnoAnt);
        }
    }//GEN-LAST:event_botonModificarActionPerformed

    private boolean isInteger(String cadena) {
        boolean esEntero = true;
        try {
            Integer.parseInt(cadena);
        } catch (Exception e) {
            esEntero = false;
        }
        return esEntero;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAnadir;
    private javax.swing.JButton botonModificar;
    private javax.swing.JTextField codPostal;
    private javax.swing.JLabel codPostalLabel;
    private javax.swing.JTextField colegio;
    private javax.swing.JLabel colegioLabel;
    private javax.swing.JLabel datosFamiliares;
    private javax.swing.JTextField domicilio;
    private javax.swing.JLabel domicilioLabel;
    private javax.swing.JTextField email;
    private javax.swing.JLabel emailLabel;
    private com.toedter.calendar.JDateChooser fechaNac;
    private javax.swing.JLabel fechaNacLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField localidad;
    private javax.swing.JLabel localidadLabel;
    private javax.swing.JTextField nombre;
    private javax.swing.JLabel nombreLabel;
    private javax.swing.JTextField nombreMadre;
    private javax.swing.JLabel nombreMadreLabel;
    private javax.swing.JTextField nombrePadre;
    private javax.swing.JLabel nombrePadreLabel;
    private javax.swing.JTextField numCuenta;
    private javax.swing.JLabel numCuentaLabel;
    private javax.swing.JLabel participante;
    private javax.swing.JTextField primerApellido;
    private javax.swing.JLabel primerApellidoLabel;
    private javax.swing.JTextField provincia;
    private javax.swing.JLabel provinciaLabel;
    private javax.swing.JTextField segundoApellido;
    private javax.swing.JLabel segundoApellidoLabel;
    private javax.swing.JSeparator separador;
    private javax.swing.JComboBox sexoAlumno;
    private javax.swing.JComboBox talla;
    private javax.swing.JLabel tallaLabel;
    private javax.swing.JTextField telFijo;
    private javax.swing.JLabel telFijoLabel;
    private javax.swing.JTextField telMovil;
    private javax.swing.JLabel telMovilLabel;
    // End of variables declaration//GEN-END:variables
}
