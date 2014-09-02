/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models.view;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import models.dao.Usuariodao;
import utilidades.Usuario;

/**
 *
 * @author cepardov
 */
public class LoginServ extends javax.swing.JFrame {
    Usuariodao ud=new Usuariodao();
    int intentos=3;
    String googlecode="http://code.google.com/p/hotelfeedback";
    String version="V1.0 r78";
    String developers="Pablo Santana, Cristian Pardo";
    /**
     * Creates new form LoginServ
     */
    public LoginServ() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.lblayuda.setText("Situe el puntero del mouse donde desee ayuda");
        this.lblversion.setText(version);
        this.setTitle("Inicio de sesión");
        this.comprobarUsuario();
    }
    
    public void Error(){
        dispose();
    }
    
    private void loginAction(){
        if (intentos==0){
            dispose();
            JOptionPane.showMessageDialog(null, "Inicio de sesión denegado!\nContacte con administrador del sistema...", "Error de Inicio de sesión.", JOptionPane.ERROR_MESSAGE);
        }else if(this.txtrut.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Nombre de usuario no es indicado.\nIngrese su nombre de usuario y contraseña para ingresar al sistema.", "Error de Inicio de sesión.", JOptionPane.ERROR_MESSAGE);
        } else if (this.txtpass.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Contraseña no es indicado.\nIngrese su contraseña y nombre de usuario para ingresar al sistema.", "Error de Inicio de sesión.", JOptionPane.WARNING_MESSAGE);
        } else {
            //Extrae información ingresada
            String usuario=this.txtrut.getText();
            String clave=this.txtpass.getText();
            
            System.out.println(usuario+" "+clave);
            
            Usuario u;
            u = new Usuario();
            u=u.verificarUsuario(usuario, clave);
            
            if(u==null){
                intentos=intentos-1;
                System.out.println("Error inicio de sesión");
                JOptionPane.showMessageDialog(this, "El nombre de usuario y/o contraseña no son validos.\nIntentos restantes "+intentos);
            }else if(u!=null){
                Menu m=new Menu(u.getRut(),u.getNombre(),u.getPaterno(),u.getMaterno(),u.getPrivilegio(),u.getClave());
                m.setTitle("Gestión Hotelera - "+u.getNombre()+" "+u.getPaterno()+" "+u.getMaterno()+" ["+u.getPrivilegio()+"]");
                m.setLocationRelativeTo(null);
                m.setVisible(true);
                dispose();
            }
        }
    }
    
    protected final void comprobarUsuario(){
        System.out.println("Comprobando si existen usuarios en base de datos...");
        if(ud.getUserCount()==0){
            MantenedorUsuario mu=new MantenedorUsuario("","","","","","",true);
            mu.setLocationRelativeTo(null);
            mu.setTitle("Primera ejecución - Ingreso Usuario Administrador");
            JOptionPane.showMessageDialog(null, "Bienvenido a FeedBack \"Gestión Hotelera de Reservas\" \n"
                    + "Es la primera vez que inicia la aplicación, en seguida aparecerá el ingreso del primer usuario \n"
                    + "la cual aparecerá solo una vez quien tendrá como usuario predeterminado de administración del sistema.", "Primer Inicio del Sistema", JOptionPane.INFORMATION_MESSAGE);
            mu.setAlwaysOnTop(true);
            mu.setVisible(true);
        } else {
            System.out.println("Existen en base de datos "+ud.getUserCount()+" usuario (s) disponibles.");
        }
    }
    
    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("utilidades/IMG/hotel-icon.png"));
        return retValue;
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
        txtrut = new javax.swing.JFormattedTextField();
        jPanel2 = new javax.swing.JPanel();
        txtpass = new javax.swing.JPasswordField();
        jPanel3 = new javax.swing.JPanel();
        lblayuda = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btnLogin = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        lblversion = new javax.swing.JLabel();
        lblfeedback = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("RUT Usuario"));

        try {
            txtrut.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###-A")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtrut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtrutMouseEntered(evt);
            }
        });
        txtrut.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtrutKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtrut, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(txtrut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Contraseña"));

        txtpass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtpassMouseEntered(evt);
            }
        });
        txtpass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtpassKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtpass, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(txtpass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Descripción"));

        lblayuda.setText("Ayuda");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblayuda)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblayuda)
                .addContainerGap())
        );

        btnLogin.setText("Iniciar Sesión");
        btnLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLoginMouseEntered(evt);
            }
        });
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        btnLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnLoginKeyPressed(evt);
            }
        });

        btnCerrar.setText("Cancelar");
        btnCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCerrarMouseEntered(evt);
            }
        });
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        jButton3.setText("Ayuda");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnLogin)
                .addGap(24, 24, 24)
                .addComponent(btnCerrar)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLogin)
                    .addComponent(btnCerrar)
                    .addComponent(jButton3))
                .addContainerGap())
        );

        lblversion.setText("Versión Aplicación");
        lblversion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblversionMouseEntered(evt);
            }
        });

        lblfeedback.setText("FeedBack (c) 2014");
        lblfeedback.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblfeedbackMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblfeedback)
                            .addComponent(lblversion))))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblversion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblfeedback)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtrutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtrutMouseEntered
        // TODO add your handling code here:
        this.lblayuda.setText("Ingrese su RUT \"01.234.567-k\"");
    }//GEN-LAST:event_txtrutMouseEntered

    private void txtpassMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtpassMouseEntered
        // TODO add your handling code here:
        this.lblayuda.setText("Ingrese su contraseña");
    }//GEN-LAST:event_txtpassMouseEntered

    private void btnLoginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoginMouseEntered
        // TODO add your handling code here:
        this.lblayuda.setText("Inicia sesión deacurdo a los previlegios establecidos.");
    }//GEN-LAST:event_btnLoginMouseEntered

    private void btnCerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarMouseEntered
        // TODO add your handling code here:
        this.lblayuda.setText("Cancela el inicio en curso y cierra sistema.");
    }//GEN-LAST:event_btnCerrarMouseEntered

    private void lblversionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblversionMouseEntered
        // TODO add your handling code here:
        this.lblayuda.setText(googlecode);
    }//GEN-LAST:event_lblversionMouseEntered

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void lblfeedbackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblfeedbackMouseEntered
        // TODO add your handling code here:
        this.lblayuda.setText(this.developers);
    }//GEN-LAST:event_lblfeedbackMouseEntered

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
        this.loginAction();
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnLoginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnLoginKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
        this.loginAction();
        }
    }//GEN-LAST:event_btnLoginKeyPressed

    private void txtpassKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpassKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
        this.loginAction();
        }
    }//GEN-LAST:event_txtpassKeyPressed

    private void txtrutKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtrutKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
        this.loginAction();
        }
    }//GEN-LAST:event_txtrutKeyPressed

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
            java.util.logging.Logger.getLogger(LoginServ.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginServ.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginServ.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginServ.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginServ().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton jButton3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblayuda;
    private javax.swing.JLabel lblfeedback;
    private javax.swing.JLabel lblversion;
    private javax.swing.JPasswordField txtpass;
    private javax.swing.JFormattedTextField txtrut;
    // End of variables declaration//GEN-END:variables
}
