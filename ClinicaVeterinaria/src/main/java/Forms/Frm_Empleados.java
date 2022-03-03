/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import static Conexiones.Conexion.Consultas;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alexander Martinez
 */
public class Frm_Empleados extends javax.swing.JFrame {

    /**
     * Creates new form Frm_Empleados
     */
    public Frm_Empleados() {
        initComponents();
        dcNaci.setDate(RestarFecha(date, -18));
        dcNaci.setMaxSelectableDate(RestarFecha(date, -18));
        CargarDatos();
    }

    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
    Date date = new Date(System.currentTimeMillis());

    static ResultSet res;
    int cont;
    static String query = "SELECT identidad ID, nombre Nombre, telefono Teléfono, correo Correo, fecha_nacimiento [Fecha Nacimiento], descripcion_puesto Puesto, usuario Usuario  FROM Empleados e join Puesto p on e.id_puesto = p.id_puesto";

    public void CargarDatos() {
        DefaultTableModel modelo = (DefaultTableModel) tbEmpleados.getModel();
        modelo.setRowCount(0);
        res = Conexiones.Conexion.Consultas(query);
        try {
            while (res.next()) {
                Vector v = new Vector();
                v.add(res.getString(1));
                v.add(res.getString(2));
                v.add(res.getString(3));
                v.add(res.getString(4));
                v.add(res.getString(5));
                v.add(res.getString(6));
                v.add(res.getString(7));
                modelo.addRow(v);
                tbEmpleados.setModel(modelo);
            }
        } catch (SQLException e) {
        }
    }

    public static boolean ValEmail(String email) {
        String emailRegex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
        Pattern emailPatr = Pattern.compile(emailRegex, Pattern.CASE_INSENSITIVE);
        Matcher emailMatc = emailPatr.matcher(email);
        return emailMatc.find();
    }

    public Date RestarFecha(Date fecha, int anio) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        calendar.add(Calendar.YEAR, anio);
        return calendar.getTime();
    }

    public void IngresarDatos() {
        try {
            res = Conexiones.Conexion.Consultas("SELECT COUNT(identidad) "
                    + "FROM Empleados where identidad = '" + ftxtId.getText() + "'");
            try {
                while (res.next()) {
                    cont = res.getInt(1);
                }
            } catch (SQLException e) {
            }
            if (cont >= 1) {
                JOptionPane.showMessageDialog(null, "Ya existe un registro con "
                        + "esta identidad.", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            } else {
                String url = "jdbc:sqlserver://localhost:1433;databaseName=ClinicaVeterinaria";
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                Connection con = Conexiones.Conexion.getConnection();
                try {
                    String insert = "INSERT INTO Empleados values(?,?,?,?,?,?,?,?,?)";
                    PreparedStatement pst = con.prepareStatement(insert);
                    pst.setString(1, ftxtId.getText());
                    pst.setString(2, txtNombre.getText());
                    pst.setString(3, ftxtTelefono.getText());
                    pst.setString(4, txtCorreo.getText());
                    Date dateFromDateChooser = dcNaci.getDate();
                    String dateString = String.format("%1$tm-%1$td-%1$tY", dateFromDateChooser);
                    pst.setString(5, dateString);
                    pst.setString(6, txtUsuario.getText());
                    String pass = pfContrasenia.getText();
                    pst.setString(7, pass);
                    if (cbPuesto.getSelectedItem() == "Medico") {
                        pst.setInt(8, 1);
                    } else if (cbPuesto.getSelectedItem() == "Enfermero") {
                        pst.setInt(8, 2);
                    } else {
                        pst.setInt(8, 3);
                    }
                    pst.setInt(9, 1);
                    pst.executeUpdate();
                    JOptionPane.showInternalMessageDialog(null, "Se ingreso con exito!");
                    ftxtId.setText("");
                    txtNombre.setText("");
                    ftxtTelefono.setText("");
                    txtCorreo.setText("");
                    dcNaci.setDate(RestarFecha(date, -18));
                    txtUsuario.setText("");
                    pfContrasenia.setText("");
                    pfConfirmacion.setText("");
                    CargarDatos();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        } catch (Exception e) {
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

        jPanel1 = new javax.swing.JPanel();
        btnCerrar = new javax.swing.JButton();
        btnMinimizar = new javax.swing.JButton();
        lblId = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        lblCorreo = new javax.swing.JLabel();
        ftxtId = new javax.swing.JFormattedTextField();
        txtNombre = new javax.swing.JTextField();
        ftxtTelefono = new javax.swing.JFormattedTextField();
        txtCorreo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbEmpleados = new javax.swing.JTable();
        lblFecha = new javax.swing.JLabel();
        dcNaci = new com.toedter.calendar.JDateChooser();
        btnAgregar = new javax.swing.JButton();
        lblUsuario = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        lblContrania = new javax.swing.JLabel();
        lblConfrmacion = new javax.swing.JLabel();
        pfContrasenia = new javax.swing.JPasswordField();
        pfConfirmacion = new javax.swing.JPasswordField();
        lblPuesto = new javax.swing.JLabel();
        cbPuesto = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(112, 244, 129));

        btnCerrar.setBackground(new java.awt.Color(255, 87, 87));
        btnCerrar.setFont(new java.awt.Font("Open Sans", 0, 11)); // NOI18N
        btnCerrar.setText("Cerrar");
        btnCerrar.setBorderPainted(false);
        btnCerrar.setPreferredSize(new java.awt.Dimension(90, 30));
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        btnMinimizar.setBackground(new java.awt.Color(82, 113, 255));
        btnMinimizar.setFont(new java.awt.Font("Open Sans", 0, 11)); // NOI18N
        btnMinimizar.setText("Minimizar");
        btnMinimizar.setBorderPainted(false);
        btnMinimizar.setPreferredSize(new java.awt.Dimension(90, 30));
        btnMinimizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMinimizarActionPerformed(evt);
            }
        });

        lblId.setFont(new java.awt.Font("SansSerif", 0, 21)); // NOI18N
        lblId.setText("Identidad:");

        lblTitulo.setFont(new java.awt.Font("Open Sans", 1, 46)); // NOI18N
        lblTitulo.setText("Registro de Empleados");

        lblNombre.setFont(new java.awt.Font("SansSerif", 0, 21)); // NOI18N
        lblNombre.setText("Nombre:");

        lblTelefono.setFont(new java.awt.Font("SansSerif", 0, 21)); // NOI18N
        lblTelefono.setText("Teléfono:");

        lblCorreo.setFont(new java.awt.Font("SansSerif", 0, 21)); // NOI18N
        lblCorreo.setText("Correo:");

        try {
            ftxtId.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#############")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        ftxtId.setFont(new java.awt.Font("Tahoma", 0, 21)); // NOI18N

        txtNombre.setFont(new java.awt.Font("Tahoma", 0, 21)); // NOI18N
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        try {
            ftxtTelefono.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        ftxtTelefono.setFont(new java.awt.Font("Tahoma", 0, 21)); // NOI18N

        txtCorreo.setFont(new java.awt.Font("Tahoma", 0, 21)); // NOI18N

        tbEmpleados.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tbEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Identidad", "Nombre", "Teléfono", "Correo", "Fecha Nacimineto", "Puesto", "Usuario"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbEmpleados);

        lblFecha.setFont(new java.awt.Font("SansSerif", 0, 21)); // NOI18N
        lblFecha.setText("Fecha Nac:");

        dcNaci.setFont(new java.awt.Font("Tahoma", 0, 21)); // NOI18N

        btnAgregar.setBackground(new java.awt.Color(255, 241, 110));
        btnAgregar.setFont(new java.awt.Font("Open Sans", 1, 12)); // NOI18N
        btnAgregar.setText("Nuevo Empleado");
        btnAgregar.setBorderPainted(false);
        btnAgregar.setPreferredSize(new java.awt.Dimension(90, 30));
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        lblUsuario.setFont(new java.awt.Font("SansSerif", 0, 21)); // NOI18N
        lblUsuario.setText("Usuario:");

        txtUsuario.setFont(new java.awt.Font("Tahoma", 0, 21)); // NOI18N

        lblContrania.setFont(new java.awt.Font("SansSerif", 0, 21)); // NOI18N
        lblContrania.setText("Contraseña:");

        lblConfrmacion.setFont(new java.awt.Font("SansSerif", 0, 21)); // NOI18N
        lblConfrmacion.setText("Confirmacion:");

        pfContrasenia.setFont(new java.awt.Font("Tahoma", 0, 21)); // NOI18N

        pfConfirmacion.setFont(new java.awt.Font("Tahoma", 0, 21)); // NOI18N

        lblPuesto.setFont(new java.awt.Font("SansSerif", 0, 21)); // NOI18N
        lblPuesto.setText("Puesto:");

        cbPuesto.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cbPuesto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Medico", "Enfermero" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnMinimizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(253, 253, 253)
                        .addComponent(lblTitulo)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblId)
                                    .addComponent(lblNombre)
                                    .addComponent(lblTelefono)
                                    .addComponent(lblCorreo))
                                .addGap(33, 33, 33))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(lblFecha)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ftxtId, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ftxtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
                            .addComponent(txtCorreo)
                            .addComponent(dcNaci, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(lblConfrmacion)
                                                .addGap(18, 18, 18))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(lblPuesto)
                                                .addGap(76, 76, 76)))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(pfConfirmacion)
                                            .addComponent(cbPuesto, 0, 210, Short.MAX_VALUE))
                                        .addGap(47, 47, 47))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(lblContrania)
                                                .addGap(34, 34, 34)
                                                .addComponent(pfContrasenia))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(lblUsuario)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                                                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(86, 86, 86))))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMinimizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(lblTitulo)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ftxtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblContrania, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pfContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTelefono)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ftxtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblConfrmacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pfConfirmacion, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCorreo)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblPuesto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dcNaci, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblFecha)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 53, Short.MAX_VALUE)
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnMinimizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinimizarActionPerformed
        this.setExtendedState(this.ICONIFIED);
    }//GEN-LAST:event_btnMinimizarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here: 
        if (ftxtId.getText().isBlank() || txtNombre.getText().isEmpty() || ftxtTelefono.getText().isBlank()
                || txtCorreo.getText().isEmpty() || txtUsuario.getText().isEmpty()
                || pfContrasenia.getText().isEmpty() || pfConfirmacion.getText().isEmpty()
                || cbPuesto.getSelectedIndex() == -1) {
            JOptionPane.showInternalMessageDialog(null, "Falta ingresar datos.");
        } else {
            if (ValEmail(txtCorreo.getText())) {
                String pass = pfConfirmacion.getText();
                String conf = pfConfirmacion.getText();
                System.out.println("" + pass);
                System.out.println("" + conf);
                if (conf == null ? pass == null : conf.equals(pass)) {
                    IngresarDatos();
                } else {
                    JOptionPane.showMessageDialog(null, "Error");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese un correo valido.");
            }
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        // TODO add your handling code here:
        char boton = evt.getKeyChar();
        if (!Character.isLetter(boton) && boton != KeyEvent.VK_SPACE) {
            evt.consume();
        }
    }//GEN-LAST:event_txtNombreKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Frm_Empleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_Empleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_Empleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_Empleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm_Empleados().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnMinimizar;
    private javax.swing.JComboBox<String> cbPuesto;
    private com.toedter.calendar.JDateChooser dcNaci;
    private javax.swing.JFormattedTextField ftxtId;
    private javax.swing.JFormattedTextField ftxtTelefono;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblConfrmacion;
    private javax.swing.JLabel lblContrania;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPuesto;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPasswordField pfConfirmacion;
    private javax.swing.JPasswordField pfContrasenia;
    private javax.swing.JTable tbEmpleados;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
