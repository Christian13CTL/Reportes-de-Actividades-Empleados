package interfaces;

import java.awt.Color;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {

    boolean claveOculta = false;
    boolean nick = false, clave = false;
    Connection conexion;
    ResultSet usuario;

    public Login() throws SQLException {
        initComponents();
        this.setLocationRelativeTo(null);
        inicializarClave();
        bloquearNavegacionTab();
        conectar();
        jpnlFondo.requestFocus();
    }

    private void conectar() throws SQLException {
        String jdbc
                = "jdbc:sqlserver://IDKTechnologies.mssql.somee.com:1433;"
                + "database=IDKTechnologies;"
                + "user=Christian13TL_SQLLogin_1;"
                + "password=p3q2pj7nsb;"
                + "encrypt=false;"
                + "trustServerCertificate=false;";
        conexion = DriverManager.getConnection(jdbc);
    }

    private void cerrar() throws SQLException {
        if (conexion != null) {
            conexion.close();
        }
    }

    private boolean verificarLogin() throws SQLException {
        PreparedStatement statement;
        String sql = "SELECT * FROM PERFILES WHERE NOM_PER = ? and CLA_PER = ? and USUARIO = ?";
        statement = conexion.prepareStatement(sql);
        statement.setString(1, jtxtUsuario.getText());
        statement.setString(2, Control.encryptPassword(new String(jpswClave.getPassword())));
        statement.setString(3, "0");
        ResultSet rs = statement.executeQuery();
        usuario = rs;
        return rs.next();
    }

    private void iniciarSesion() throws SQLException {
        if (verificarLogin()) {
            this.dispose();
            PanelPrincipal pp = new PanelPrincipal(conexion, usuario);
            pp.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Credenciales incorrectas", "Error", 2);
        }
    }

    private void verOcultarClave() {
        if (claveOculta) {
            jpswClave.setEchoChar((char) 0);
            claveOculta = false;
            jlblVerOcultarClave.setIcon(new ImageIcon(getClass().getResource("/imagenes/verClave_40.png")));
        } else {
            jpswClave.setEchoChar('*');
            claveOculta = true;
            jlblVerOcultarClave.setIcon(new ImageIcon(getClass().getResource("/imagenes/ocultarClave_40.png")));
        }
    }

    private void inicializarClave() {
        jpswClave.setEchoChar((char) 0);
        jlblVerOcultarClave.setIcon(new ImageIcon(getClass().getResource("/imagenes/verClave_40.png")));
    }

    private void bloquearNavegacionTab() {
        jtxtUsuario.setFocusTraversalKeysEnabled(false);
        jpswClave.setFocusTraversalKeysEnabled(false);
    }

    private void validarUsuario() {
        nick = Validacion.validarUsuario(jtxtUsuario.getText());
    }

    private void validarClave() {
        clave = Validacion.validarClave(new String(jpswClave.getPassword()));
    }

    private void definirEstadoBoton() {
        if (nick && clave) {
            jtxtIngresar.setEnabled(true);
        } else {
            jtxtIngresar.setEnabled(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnlFondo = new javax.swing.JPanel();
        jlblLateral = new javax.swing.JLabel();
        jpnlCabecera = new javax.swing.JPanel();
        jpnlSalir = new javax.swing.JPanel();
        jtxtSalir = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jtxtUsuario = new javax.swing.JTextField();
        jpnlBotonIngreso = new javax.swing.JPanel();
        jtxtIngresar = new javax.swing.JLabel();
        jlblBoton = new javax.swing.JLabel();
        jpswClave = new javax.swing.JPasswordField();
        jpnlVerOcultarClave = new javax.swing.JPanel();
        jlblVerOcultarClave = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);

        jpnlFondo.setBackground(new java.awt.Color(255, 255, 255));
        jpnlFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlblLateral.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondoIDK.jpg"))); // NOI18N
        jpnlFondo.add(jlblLateral, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 450));

        jpnlCabecera.setBackground(new java.awt.Color(255, 255, 255));
        jpnlCabecera.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jpnlCabeceraMouseDragged(evt);
            }
        });
        jpnlCabecera.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jpnlCabeceraMousePressed(evt);
            }
        });

        jpnlSalir.setBackground(new java.awt.Color(255, 255, 255));

        jtxtSalir.setFont(new java.awt.Font("Rubik Light", 0, 14)); // NOI18N
        jtxtSalir.setForeground(new java.awt.Color(54, 58, 64));
        jtxtSalir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jtxtSalir.setText("X");
        jtxtSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jtxtSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtxtSalirMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jtxtSalirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jtxtSalirMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jpnlSalirLayout = new javax.swing.GroupLayout(jpnlSalir);
        jpnlSalir.setLayout(jpnlSalirLayout);
        jpnlSalirLayout.setHorizontalGroup(
            jpnlSalirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnlSalirLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jtxtSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jpnlSalirLayout.setVerticalGroup(
            jpnlSalirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnlSalirLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jtxtSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jpnlCabeceraLayout = new javax.swing.GroupLayout(jpnlCabecera);
        jpnlCabecera.setLayout(jpnlCabeceraLayout);
        jpnlCabeceraLayout.setHorizontalGroup(
            jpnlCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnlCabeceraLayout.createSequentialGroup()
                .addGap(0, 570, Short.MAX_VALUE)
                .addComponent(jpnlSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jpnlCabeceraLayout.setVerticalGroup(
            jpnlCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlCabeceraLayout.createSequentialGroup()
                .addComponent(jpnlSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpnlFondo.add(jpnlCabecera, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 30));

        jLabel6.setFont(new java.awt.Font("Poppins", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(54, 58, 64));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("INICIAR SESI�N");
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jpnlFondo.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 105, 300, 30));

        jtxtUsuario.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jtxtUsuario.setForeground(new java.awt.Color(204, 204, 204));
        jtxtUsuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtxtUsuario.setText("Usuario o correo");
        jtxtUsuario.setBorder(null);
        jtxtUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jtxtUsuarioMousePressed(evt);
            }
        });
        jtxtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtUsuarioKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtxtUsuarioKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtUsuarioKeyTyped(evt);
            }
        });
        jpnlFondo.add(jtxtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(355, 165, 190, 40));

        jpnlBotonIngreso.setBackground(new java.awt.Color(255, 255, 255));
        jpnlBotonIngreso.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtxtIngresar.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        jtxtIngresar.setForeground(new java.awt.Color(255, 255, 255));
        jtxtIngresar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jtxtIngresar.setText("INGRESAR");
        jtxtIngresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jtxtIngresar.setEnabled(false);
        jtxtIngresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtxtIngresarMouseClicked(evt);
            }
        });
        jpnlBotonIngreso.add(jtxtIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 1, 160, 40));

        jlblBoton.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        jlblBoton.setForeground(new java.awt.Color(255, 255, 255));
        jlblBoton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblBoton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/botonAzul_160_40.png"))); // NOI18N
        jlblBoton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jpnlBotonIngreso.add(jlblBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jpnlFondo.add(jpnlBotonIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 305, 160, 40));

        jpswClave.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jpswClave.setForeground(new java.awt.Color(204, 204, 204));
        jpswClave.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jpswClave.setText("Contrase�a");
        jpswClave.setBorder(null);
        jpswClave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jpswClaveMousePressed(evt);
            }
        });
        jpswClave.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jpswClaveKeyReleased(evt);
            }
        });
        jpnlFondo.add(jpswClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 235, 190, 40));

        jpnlVerOcultarClave.setBackground(new java.awt.Color(255, 255, 255));

        jlblVerOcultarClave.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlblVerOcultarClave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlblVerOcultarClaveMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jpnlVerOcultarClaveLayout = new javax.swing.GroupLayout(jpnlVerOcultarClave);
        jpnlVerOcultarClave.setLayout(jpnlVerOcultarClaveLayout);
        jpnlVerOcultarClaveLayout.setHorizontalGroup(
            jpnlVerOcultarClaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlVerOcultarClaveLayout.createSequentialGroup()
                .addComponent(jlblVerOcultarClave, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jpnlVerOcultarClaveLayout.setVerticalGroup(
            jpnlVerOcultarClaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlVerOcultarClaveLayout.createSequentialGroup()
                .addComponent(jlblVerOcultarClave, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jpnlFondo.add(jpnlVerOcultarClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 235, 40, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnlFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnlFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    int xMouse, yMouse;

    private void jpnlCabeceraMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnlCabeceraMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_jpnlCabeceraMousePressed

    private void jpnlCabeceraMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnlCabeceraMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_jpnlCabeceraMouseDragged

    private void jtxtSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtxtSalirMouseClicked
        try {
            cerrar();
            System.exit(0);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }//GEN-LAST:event_jtxtSalirMouseClicked

    private void jtxtSalirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtxtSalirMouseEntered
        jpnlSalir.setBackground(new Color(0, 75, 133));
        jtxtSalir.setForeground(Color.white);
    }//GEN-LAST:event_jtxtSalirMouseEntered

    private void jtxtSalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtxtSalirMouseExited
        jpnlSalir.setBackground(Color.white);
        jtxtSalir.setForeground(new Color(54, 58, 64));
    }//GEN-LAST:event_jtxtSalirMouseExited

    private void jtxtUsuarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtxtUsuarioMousePressed
        if (jtxtUsuario.getText().equals("Usuario o correo")) {
            jtxtUsuario.setText("");
            jtxtUsuario.setForeground(Color.black);
        }
        if (String.valueOf(jpswClave.getPassword()).isEmpty()) {
            jpswClave.setText("Contrase�a");
            jpswClave.setForeground(new Color(204, 204, 204));
        }
    }//GEN-LAST:event_jtxtUsuarioMousePressed

    private void jpswClaveMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpswClaveMousePressed
        if (jtxtUsuario.getText().isEmpty()) {
            jtxtUsuario.setText("Usuario o correo");
            jtxtUsuario.setForeground(new Color(204, 204, 204));
        }
        if (String.valueOf(jpswClave.getPassword()).equals("Contrase�a")) {
            jpswClave.setText("");
            jpswClave.setForeground(Color.black);
        }
    }//GEN-LAST:event_jpswClaveMousePressed

    private void jlblVerOcultarClaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlblVerOcultarClaveMouseClicked
        verOcultarClave();
    }//GEN-LAST:event_jlblVerOcultarClaveMouseClicked

    private void jtxtUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtUsuarioKeyPressed
        Validacion.bloquearCopyPaste(evt);
    }//GEN-LAST:event_jtxtUsuarioKeyPressed

    private void jtxtUsuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtUsuarioKeyReleased
        validarUsuario();
        definirEstadoBoton();
    }//GEN-LAST:event_jtxtUsuarioKeyReleased

    private void jtxtUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtUsuarioKeyTyped
        Validacion.validarSinEspacios(evt);
        Validacion.validarNCaracteres(evt, jtxtUsuario, 30);
    }//GEN-LAST:event_jtxtUsuarioKeyTyped

    private void jpswClaveKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jpswClaveKeyReleased
        validarClave();
        definirEstadoBoton();
    }//GEN-LAST:event_jpswClaveKeyReleased

    private void jtxtIngresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtxtIngresarMouseClicked
        try {
            if (jtxtIngresar.isEnabled()) {
                iniciarSesion();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }//GEN-LAST:event_jtxtIngresarMouseClicked

    public static void main(String args[]) throws SQLException {
        new Login().setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jlblBoton;
    private javax.swing.JLabel jlblLateral;
    private javax.swing.JLabel jlblVerOcultarClave;
    private javax.swing.JPanel jpnlBotonIngreso;
    private javax.swing.JPanel jpnlCabecera;
    private javax.swing.JPanel jpnlFondo;
    private javax.swing.JPanel jpnlSalir;
    private javax.swing.JPanel jpnlVerOcultarClave;
    private javax.swing.JPasswordField jpswClave;
    private javax.swing.JLabel jtxtIngresar;
    private javax.swing.JLabel jtxtSalir;
    private javax.swing.JTextField jtxtUsuario;
    // End of variables declaration//GEN-END:variables
}
