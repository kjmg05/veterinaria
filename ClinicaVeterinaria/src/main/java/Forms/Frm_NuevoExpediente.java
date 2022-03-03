/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import javax.swing.JOptionPane;
import Conexiones.*;
import java.util.Date;

/**
 *
 * @author Walter Amador
 */
public class Frm_NuevoExpediente extends javax.swing.JFrame {

    /**
     * Creates new form Frm_NuevoExpediente
     */
    public Frm_NuevoExpediente() {
        initComponents();
        nuevoExp.llenarComboBoxCliente(cb_clientes);
        txt_identidad.setText(nuevoExp.traerIdentidad(cb_clientes.getSelectedIndex()));
        nuevoExp.llenarComboBoxTipoMascota(cb_tipoMascota);
    }

    private Cls_NuevoExpediente nuevoExp = new Cls_NuevoExpediente();

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        cb_ordenarPor1 = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        btnVolver = new javax.swing.JButton();
        btnMinimizar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        btnCrearExpediente = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cb_clientes = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cb_tipoMascota = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txt_nombreMascota = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_identidad = new javax.swing.JTextField();
        jdc_nacimiento = new com.toedter.calendar.JDateChooser();

        jLabel3.setFont(new java.awt.Font("Open Sans", 0, 16)); // NOI18N
        jLabel3.setText("Dueño de mascota:");

        cb_ordenarPor1.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        cb_ordenarPor1.setToolTipText("Ordenar la tabla por la opción seleccionada");
        cb_ordenarPor1.setPreferredSize(new java.awt.Dimension(230, 32));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(112, 244, 129));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setToolTipText("");

        btnVolver.setBackground(new java.awt.Color(255, 161, 161));
        btnVolver.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        btnVolver.setText("Volver");
        btnVolver.setToolTipText("Volver a ventana anterior");
        btnVolver.setBorderPainted(false);
        btnVolver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        btnMinimizar.setBackground(new java.awt.Color(82, 113, 255));
        btnMinimizar.setFont(new java.awt.Font("Open Sans", 0, 11)); // NOI18N
        btnMinimizar.setText("Minimizar");
        btnMinimizar.setToolTipText("Minimizar ventana");
        btnMinimizar.setBorderPainted(false);
        btnMinimizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMinimizar.setPreferredSize(new java.awt.Dimension(90, 30));
        btnMinimizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMinimizarActionPerformed(evt);
            }
        });

        btnCerrar.setBackground(new java.awt.Color(255, 87, 87));
        btnCerrar.setFont(new java.awt.Font("Open Sans", 0, 11)); // NOI18N
        btnCerrar.setText("Cerrar");
        btnCerrar.setToolTipText("Cerrar ventana");
        btnCerrar.setBorderPainted(false);
        btnCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCerrar.setPreferredSize(new java.awt.Dimension(90, 30));
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        btnCrearExpediente.setBackground(new java.awt.Color(255, 246, 131));
        btnCrearExpediente.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        btnCrearExpediente.setText("Crear Expediente");
        btnCrearExpediente.setBorderPainted(false);
        btnCrearExpediente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCrearExpediente.setPreferredSize(new java.awt.Dimension(190, 35));
        btnCrearExpediente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearExpedienteActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Open Sans", 1, 46)); // NOI18N
        jLabel1.setText("Nuevo Expediente");

        jLabel2.setFont(new java.awt.Font("Open Sans", 0, 16)); // NOI18N
        jLabel2.setText("Dueño de mascota:");

        cb_clientes.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        cb_clientes.setToolTipText("Ordenar la tabla por la opción seleccionada");
        cb_clientes.setPreferredSize(new java.awt.Dimension(230, 32));
        cb_clientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_clientesActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Open Sans", 0, 16)); // NOI18N
        jLabel4.setText("Tipo de mascota:");

        cb_tipoMascota.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        cb_tipoMascota.setToolTipText("Ordenar la tabla por la opción seleccionada");
        cb_tipoMascota.setPreferredSize(new java.awt.Dimension(230, 32));

        jLabel5.setFont(new java.awt.Font("Open Sans", 0, 16)); // NOI18N
        jLabel5.setText("Nombre mascota:");

        txt_nombreMascota.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        txt_nombreMascota.setToolTipText("Busqueda por nombre de cliente");
        txt_nombreMascota.setMinimumSize(new java.awt.Dimension(32, 700));
        txt_nombreMascota.setPreferredSize(new java.awt.Dimension(700, 32));
        txt_nombreMascota.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_nombreMascotaKeyPressed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Open Sans", 0, 16)); // NOI18N
        jLabel6.setText("Fecha de Nacimiento:");

        txt_identidad.setEditable(false);
        txt_identidad.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N

        jdc_nacimiento.setDateFormatString("yyyy/MM/dd");
        jdc_nacimiento.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 177, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(26, 26, 26)
                        .addComponent(jdc_nacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(483, 483, 483)
                            .addComponent(btnCrearExpediente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(32, 32, 32))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnMinimizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel2)
                                            .addGap(18, 18, 18)
                                            .addComponent(cb_clientes, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel5)
                                                .addComponent(jLabel4))
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addGap(28, 28, 28)
                                                    .addComponent(cb_tipoMascota, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addGap(29, 29, 29)
                                                    .addComponent(txt_nombreMascota, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)))))
                                    .addGap(18, 18, 18)
                                    .addComponent(txt_identidad, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, Short.MAX_VALUE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnVolver)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnMinimizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_clientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txt_identidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_tipoMascota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_nombreMascota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jdc_nacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 224, Short.MAX_VALUE)
                .addComponent(btnCrearExpediente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        datoSinGuardar();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnMinimizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinimizarActionPerformed
        this.setExtendedState(this.ICONIFIED);
    }//GEN-LAST:event_btnMinimizarActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        datoSinGuardar();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnCrearExpedienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearExpedienteActionPerformed

        if (cb_clientes.getSelectedIndex() != -1 && cb_tipoMascota.getSelectedIndex() != -1
                && !txt_nombreMascota.getText().isBlank() && jdc_nacimiento.getDate() != null) {
            
            Date date = jdc_nacimiento.getDate();
            long d = date.getTime();
            java.sql.Date fecha = new java.sql.Date(d);

            String id = nuevoExp.traerIDcliente(cb_clientes.getSelectedIndex());
            nuevoExp.guardarExpediente(id, txt_nombreMascota.getText(), nuevoExp.traerIDtipoMascota(cb_tipoMascota.getSelectedIndex()), fecha.toString());

            JOptionPane.showMessageDialog(null, "Expediente creado con éxito", "Datos guardados",
                    JOptionPane.INFORMATION_MESSAGE);

            cerrarVentana();
        }else{
            JOptionPane.showMessageDialog(null, "Faltan datos por llenar...","Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnCrearExpedienteActionPerformed

    private void cb_clientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_clientesActionPerformed
        int index = cb_clientes.getSelectedIndex();
        String id = nuevoExp.traerIdentidad(index);
        txt_identidad.setText(id);
    }//GEN-LAST:event_cb_clientesActionPerformed

    private void txt_nombreMascotaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nombreMascotaKeyPressed
        
    }//GEN-LAST:event_txt_nombreMascotaKeyPressed

    private void datoSinGuardar() {
        int cerrar = JOptionPane.showConfirmDialog(this, "Los datos no han sido guardados, ¿Cerrar de todos modos?",
                "Advertencia", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);

        if (cerrar == 0) {
            cerrarVentana();
        }
    }

    private void cerrarVentana() {
        Frm_Expedientes expediente = new Frm_Expedientes();
        expediente.setVisible(true);
        this.dispose();
    }

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
            java.util.logging.Logger.getLogger(Frm_NuevoExpediente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_NuevoExpediente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_NuevoExpediente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_NuevoExpediente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm_NuevoExpediente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnCrearExpediente;
    private javax.swing.JButton btnMinimizar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox<String> cb_clientes;
    private javax.swing.JComboBox<String> cb_ordenarPor1;
    private javax.swing.JComboBox<String> cb_tipoMascota;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private com.toedter.calendar.JDateChooser jdc_nacimiento;
    private javax.swing.JTextField txt_identidad;
    private javax.swing.JTextField txt_nombreMascota;
    // End of variables declaration//GEN-END:variables
}
