/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models.view;

/**
 *
 * @author cepardov
 */
public class Menu extends javax.swing.JFrame {
    String rut,nombre,paterno,materno,privilegio,clave;
    /**
     * Creates new form Menu
     * @param rut
     * @param nombre
     * @param paterno
     * @param materno
     * @param privilegio
     * @param clave
     */
    public Menu(String rut, String nombre, String paterno, String materno, String privilegio, String clave) {
        initComponents();
        this.funcPrivilegio(privilegio);
        this.rut=rut;
        this.nombre=nombre;
        this.paterno=paterno;
        this.materno=materno;
        this.privilegio=privilegio;
        this.clave=clave;
    }
    public Menu() {
        initComponents();
        //No se Utiliza
    }

    private void funcPrivilegio(String privilegio){
        System.out.println("Privilegio="+privilegio);
        if(privilegio.equals("Recepcionista")){
            this.btnMantenedorClientes.setVisible(false);
            this.btnMantenedorHabitacion.setVisible(false);
            this.btnMantenedorReserva.setVisible(false);
            this.btnMantenedorTipo.setVisible(false);
            this.btnmantenedorusuario.setVisible(false);
        } else {
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
        btnmantenedorusuario = new javax.swing.JButton();
        lblayuda = new javax.swing.JPanel();
        lbldescripcion = new javax.swing.JLabel();
        btnMantenedorTipo = new javax.swing.JButton();
        btnMantenedorHabitacion = new javax.swing.JButton();
        btnMantenedorClientes = new javax.swing.JButton();
        btnMantenedorReserva = new javax.swing.JButton();
        btn6 = new javax.swing.JButton();
        btn7 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmSesion = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        btnmenubloq = new javax.swing.JMenuItem();
        btnmenucerrarsesion = new javax.swing.JMenuItem();
        btnmenusalir = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Menú Principal"));

        btnmantenedorusuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utilidades/IMG/MantenedorUsuarios.png"))); // NOI18N
        btnmantenedorusuario.setText("Mantenedor Usuarios");
        btnmantenedorusuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                btnmantenedorusuarioFocusGained(evt);
            }
        });
        btnmantenedorusuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnmantenedorusuarioMouseReleased(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnmantenedorusuarioMouseEntered(evt);
            }
        });
        btnmantenedorusuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmantenedorusuarioActionPerformed(evt);
            }
        });

        lblayuda.setBorder(javax.swing.BorderFactory.createTitledBorder("Descripción"));

        lbldescripcion.setText(" ");

        javax.swing.GroupLayout lblayudaLayout = new javax.swing.GroupLayout(lblayuda);
        lblayuda.setLayout(lblayudaLayout);
        lblayudaLayout.setHorizontalGroup(
            lblayudaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lblayudaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbldescripcion)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        lblayudaLayout.setVerticalGroup(
            lblayudaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lblayudaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbldescripcion)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        btnMantenedorTipo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utilidades/IMG/MantenedorTipo.png"))); // NOI18N
        btnMantenedorTipo.setText("Mantenedor Tipo Habitación");
        btnMantenedorTipo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                btnMantenedorTipoFocusGained(evt);
            }
        });
        btnMantenedorTipo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMantenedorTipoMouseEntered(evt);
            }
        });
        btnMantenedorTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMantenedorTipoActionPerformed(evt);
            }
        });

        btnMantenedorHabitacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utilidades/IMG/MantenedorHabitacion.png"))); // NOI18N
        btnMantenedorHabitacion.setText("Mantenedor Habitaciones");
        btnMantenedorHabitacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMantenedorHabitacionMouseEntered(evt);
            }
        });
        btnMantenedorHabitacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMantenedorHabitacionActionPerformed(evt);
            }
        });

        btnMantenedorClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utilidades/IMG/MantenedorClientes.png"))); // NOI18N
        btnMantenedorClientes.setText("Mantenedor Clientes");
        btnMantenedorClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMantenedorClientesMouseEntered(evt);
            }
        });
        btnMantenedorClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMantenedorClientesActionPerformed(evt);
            }
        });

        btnMantenedorReserva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utilidades/IMG/MantenedorReserva.png"))); // NOI18N
        btnMantenedorReserva.setText("Mantenedor Reserva");
        btnMantenedorReserva.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMantenedorReservaMouseEntered(evt);
            }
        });
        btnMantenedorReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMantenedorReservaActionPerformed(evt);
            }
        });

        btn6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utilidades/IMG/addClient.png"))); // NOI18N
        btn6.setText("Ingreso de Clientes");
        btn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn6ActionPerformed(evt);
            }
        });

        btn7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utilidades/IMG/MantenedorReserva.png"))); // NOI18N
        btn7.setText("Reservar");
        btn7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblayuda, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnMantenedorReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btn7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btn6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnMantenedorTipo, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(btnMantenedorClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnMantenedorHabitacion, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(btnmantenedorusuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn6)
                            .addComponent(btnMantenedorTipo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn7)
                            .addComponent(btnMantenedorClientes)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnmantenedorusuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMantenedorHabitacion)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMantenedorReserva)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblayuda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jmSesion.setText("Sesión");

        jMenu3.setText("Administrar Cuenta");
        jMenu3.setEnabled(false);

        jMenuItem1.setText("Cambiar Contraseña");
        jMenu3.add(jMenuItem1);

        jMenuItem2.setText("Editar datos personales");
        jMenu3.add(jMenuItem2);

        jMenuItem3.setText("Administrar otra cuenta");
        jMenu3.add(jMenuItem3);

        jmSesion.add(jMenu3);

        btnmenubloq.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        btnmenubloq.setText("Bloquear");
        btnmenubloq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmenubloqActionPerformed(evt);
            }
        });
        jmSesion.add(btnmenubloq);

        btnmenucerrarsesion.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        btnmenucerrarsesion.setText("Cerrar sesión");
        btnmenucerrarsesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmenucerrarsesionActionPerformed(evt);
            }
        });
        jmSesion.add(btnmenucerrarsesion);

        btnmenusalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        btnmenusalir.setText("Salir");
        btnmenusalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmenusalirActionPerformed(evt);
            }
        });
        jmSesion.add(btnmenusalir);
        jmSesion.add(jSeparator1);

        jMenuBar1.add(jmSesion);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnmantenedorusuarioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btnmantenedorusuarioFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_btnmantenedorusuarioFocusGained

    private void btnMantenedorTipoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btnMantenedorTipoFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMantenedorTipoFocusGained

    private void btnmantenedorusuarioMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnmantenedorusuarioMouseReleased
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnmantenedorusuarioMouseReleased

    private void btnmantenedorusuarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnmantenedorusuarioMouseEntered
        // TODO add your handling code here:
        this.lbldescripcion.setText(this.btnmantenedorusuario.getText()+": Prodrá realizar cambios eliminar o editar usuario");
    }//GEN-LAST:event_btnmantenedorusuarioMouseEntered

    private void btnMantenedorTipoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMantenedorTipoMouseEntered
        // TODO add your handling code here:
        this.lbldescripcion.setText(this.btnMantenedorTipo.getText()+": Cree, edite y elimine tipos de habitaciones.");
    }//GEN-LAST:event_btnMantenedorTipoMouseEntered

    private void btnmenusalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmenusalirActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnmenusalirActionPerformed

    private void btnmantenedorusuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmantenedorusuarioActionPerformed
        // TODO add your handling code here:
        MantenedorUsuario mu=new MantenedorUsuario(rut,nombre,paterno,materno,privilegio,clave,false);
        mu.setTitle("Mantenedor de Usuarios - "+nombre+" "+paterno+" "+materno+" ["+privilegio+"]");
        mu.setLocationRelativeTo(null);
        mu.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnmantenedorusuarioActionPerformed

    private void btnmenucerrarsesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmenucerrarsesionActionPerformed
        // TODO add your handling code here:
        LoginServ login=new LoginServ();
        login.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnmenucerrarsesionActionPerformed

    private void btnMantenedorTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMantenedorTipoActionPerformed
        // TODO add your handling code here:
        MantenedorTipo mt=new MantenedorTipo(rut,nombre,paterno,materno,privilegio,clave);
        mt.setTitle("Mantenedor Tipo - "+nombre+" "+paterno+" "+materno+" ["+privilegio+"]");
        mt.setLocationRelativeTo(null);
        mt.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnMantenedorTipoActionPerformed

    private void btnMantenedorHabitacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMantenedorHabitacionActionPerformed
        // TODO add your handling code here:
        MantenedorHabitaciones mh=new MantenedorHabitaciones(rut,nombre,paterno,materno,privilegio,clave);
        mh.setTitle("Mantenedor habitaciones - "+nombre+" "+paterno+" "+materno+" ["+privilegio+"]");
        mh.setLocationRelativeTo(null);
        mh.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnMantenedorHabitacionActionPerformed

    private void btnMantenedorClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMantenedorClientesActionPerformed
        // TODO add your handling code here:
        MantenedorClientes mc=new MantenedorClientes(rut,nombre,paterno,materno,privilegio,clave);
        mc.setTitle("Mantenedor Clientes - "+nombre+" "+paterno+" "+materno+" ["+privilegio+"]");
        mc.setLocationRelativeTo(null);
        mc.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnMantenedorClientesActionPerformed

    private void btnMantenedorReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMantenedorReservaActionPerformed
        // TODO add your handling code here:
        MantenedorReserva mr=new MantenedorReserva(rut,nombre,paterno,materno,privilegio,clave);
        mr.setTitle("Mantenedor Reserva - "+nombre+" "+paterno+" "+materno+" ["+privilegio+"]");
        mr.setLocationRelativeTo(null);
        mr.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnMantenedorReservaActionPerformed

    private void btnMantenedorHabitacionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMantenedorHabitacionMouseEntered
        // TODO add your handling code here:
        this.lbldescripcion.setText(this.btnMantenedorHabitacion.getText()+": Cree, edite y elimine habitaciones segun tipo");
    }//GEN-LAST:event_btnMantenedorHabitacionMouseEntered

    private void btnMantenedorClientesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMantenedorClientesMouseEntered
        // TODO add your handling code here:
        this.lbldescripcion.setText(this.btnMantenedorClientes.getText()+": Cree, edite y elimine usuarios del sistema");
    }//GEN-LAST:event_btnMantenedorClientesMouseEntered

    private void btnMantenedorReservaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMantenedorReservaMouseEntered
        // TODO add your handling code here:
        this.lbldescripcion.setText(this.btnMantenedorReserva.getText()+": Cree, edite y elimine reservas relizadas");
    }//GEN-LAST:event_btnMantenedorReservaMouseEntered

    private void btn6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn6ActionPerformed
        // TODO add your handling code here:
        MantenedorClientes mc=new MantenedorClientes(rut,nombre,paterno,materno,privilegio,clave);
        mc.setTitle("Ingreso Clientes - "+nombre+" "+paterno+" "+materno+" ["+privilegio+"]");
        mc.setLocationRelativeTo(null);
        mc.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn6ActionPerformed

    private void btn7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn7ActionPerformed
        // TODO add your handling code here:
        MantenedorReserva mr=new MantenedorReserva(rut,nombre,paterno,materno,privilegio,clave);
        mr.setTitle("Reserva Habitación - "+nombre+" "+paterno+" "+materno+" ["+privilegio+"]");
        mr.setLocationRelativeTo(null);
        mr.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn7ActionPerformed

    private void btnmenubloqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmenubloqActionPerformed
        // TODO add your handling code here:
        LoginServ login=new LoginServ();
        login.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnmenubloqActionPerformed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn6;
    private javax.swing.JButton btn7;
    private javax.swing.JButton btnMantenedorClientes;
    private javax.swing.JButton btnMantenedorHabitacion;
    private javax.swing.JButton btnMantenedorReserva;
    private javax.swing.JButton btnMantenedorTipo;
    private javax.swing.JButton btnmantenedorusuario;
    private javax.swing.JMenuItem btnmenubloq;
    private javax.swing.JMenuItem btnmenucerrarsesion;
    private javax.swing.JMenuItem btnmenusalir;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenu jmSesion;
    private javax.swing.JPanel lblayuda;
    private javax.swing.JLabel lbldescripcion;
    // End of variables declaration//GEN-END:variables
}
