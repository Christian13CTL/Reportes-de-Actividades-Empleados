/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Christian
 */
public class Principal extends javax.swing.JPanel {
    
    Connection conexion;
    
    public Principal(Connection conexion, ResultSet usuario) throws SQLException {
        initComponents();
        this.conexion = conexion;
        //this.usuario = usuario;
        establecerSaludo(usuario);
        generarEstadisticas();
    }
    
    private void establecerSaludo(ResultSet usuario) throws SQLException {
        PreparedStatement statement = null;
        try {
            String sql = "SELECT NOM_EMP FROM EMPLEADOS WHERE CED_EMP = ? ";
            statement = conexion.prepareStatement(sql);
            statement.setString(1, usuario.getString("CED_EMP_PER"));
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                jtxtBienvenida.setText("HOLA, " + rs.getString("NOM_EMP"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
    }
    
    private void generarEstadisticas() throws SQLException {
        final String sqlMayorNumeroDeTareas = "SELECT TOP 1 NOM_EMP, APE_EMP FROM EMPLEADOS WHERE CED_EMP IN (SELECT EMP_INI_REG FROM REGISTROACTIVIDADES GROUP BY EMP_INI_REG HAVING COUNT(IDE_REG) = (SELECT TOP 1 COUNT(IDE_REG) AS C FROM REGISTROACTIVIDADES GROUP BY EMP_INI_REG ORDER BY C DESC) )";
        final String sqlMenorNumeroDeTareas = "SELECT TOP 1 NOM_EMP, APE_EMP FROM EMPLEADOS WHERE CED_EMP IN (SELECT EMP_INI_REG FROM REGISTROACTIVIDADES GROUP BY EMP_INI_REG HAVING COUNT(IDE_REG) = (SELECT TOP 1 COUNT(IDE_REG) AS C FROM REGISTROACTIVIDADES GROUP BY EMP_INI_REG ORDER BY C ASC) )";
        final String sqlActNoIniciadas = "SELECT COUNT(IDE_REG) as CONTEO FROM REGISTROACTIVIDADES WHERE EST_REG = 'NO INICIADO'";
        final String sqlActEnProgreso = "SELECT COUNT(IDE_REG) as CONTEO FROM REGISTROACTIVIDADES WHERE EST_REG = 'EN PROGRESO'";
        final String sqlActFinalizadas = "SELECT COUNT(IDE_REG) as CONTEO FROM REGISTROACTIVIDADES WHERE EST_REG = 'FINALIZADO'";
        final String sqlTotalActividades = "SELECT COUNT(IDE_REG) as CONTEO FROM REGISTROACTIVIDADES";
        final String sqlActMasSolictada = "SELECT NOM_ACT FROM ACTIVIDADES WHERE IDE_ACT IN (SELECT ACT_REG FROM REGISTROACTIVIDADES GROUP BY ACT_REG HAVING COUNT(IDE_REG) = (SELECT TOP 1 COUNT(IDE_REG) AS C FROM REGISTROACTIVIDADES GROUP BY ACT_REG ORDER BY C DESC) )";
        final String sqlActMenosSolictada = "SELECT NOM_ACT FROM ACTIVIDADES WHERE IDE_ACT IN (SELECT ACT_REG FROM REGISTROACTIVIDADES GROUP BY ACT_REG HAVING COUNT(IDE_REG) = (SELECT TOP 1 COUNT(IDE_REG) AS C FROM REGISTROACTIVIDADES GROUP BY ACT_REG ORDER BY C ASC) )";
        jlblMayNumTareas.setText(obtenerEmpleado(sqlMayorNumeroDeTareas));
        jlblMenNumTareas.setText(obtenerEmpleado(sqlMenorNumeroDeTareas));
        jlblActNoIniciadas.setText(String.valueOf(obtenerValor(sqlActNoIniciadas)));
        jlblActEnProgreso.setText(String.valueOf(obtenerValor(sqlActEnProgreso)));
        jlblActFinalizadas.setText(String.valueOf(obtenerValor(sqlActFinalizadas)));
        jlblTotalActividades.setText(String.valueOf(obtenerValor(sqlTotalActividades)));
        jlblActMasSolicitada.setText(obtenerActividad(sqlActMasSolictada));
        jlblActMenosSolicitada.setText(obtenerActividad(sqlActMenosSolictada));
    }
    
    private String obtenerEmpleado(String sql) throws SQLException {
        PreparedStatement statement = null;
        try {
            statement = conexion.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return rs.getString("NOM_EMP") + " " + rs.getString("APE_EMP");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
        return null;
    }
    
    private int obtenerValor(String sql) throws SQLException {
        PreparedStatement statement = null;
        try {
            statement = conexion.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return rs.getInt("CONTEO");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
        return -1;
    }
    
    private String obtenerActividad(String sql) throws SQLException {
        PreparedStatement statement = null;
        try {
            statement = conexion.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return rs.getString("NOM_ACT");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
        return null;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnlPerfil = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jtxtBienvenida = new javax.swing.JLabel();
        jpnlTitulos = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jpnlDetalles = new javax.swing.JPanel();
        jlblMayNumTareas = new javax.swing.JLabel();
        jlblMenNumTareas = new javax.swing.JLabel();
        jlblActNoIniciadas = new javax.swing.JLabel();
        jlblActEnProgreso = new javax.swing.JLabel();
        jlblActFinalizadas = new javax.swing.JLabel();
        jlblTotalActividades = new javax.swing.JLabel();
        jlblActMasSolicitada = new javax.swing.JLabel();
        jlblActMenosSolicitada = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(415, 390));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpnlPerfil.setBackground(new java.awt.Color(20, 175, 229));
        jpnlPerfil.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Poppins Light", 0, 21)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("SISTEMA DE REPORTES");
        jpnlPerfil.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 22, 225, 30));

        jtxtBienvenida.setFont(new java.awt.Font("Poppins SemiBold", 0, 36)); // NOI18N
        jtxtBienvenida.setForeground(new java.awt.Color(255, 255, 255));
        jtxtBienvenida.setText("Bienvenida");
        jpnlPerfil.add(jtxtBienvenida, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 67, 579, 45));

        add(jpnlPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 623, 135));

        jpnlTitulos.setBackground(new java.awt.Color(255, 255, 255));
        jpnlTitulos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("MAYOR NÚMERO DE TAREAS:");
        jpnlTitulos.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 15, 292, 30));

        jLabel4.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("MENOR NÚMERO DE TAREAS:");
        jpnlTitulos.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 60, 292, 30));

        jLabel5.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("ACTIVIDADES NO INICIADAS:");
        jpnlTitulos.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 105, 292, 30));

        jLabel6.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("ACTIVIDADES EN PROGRESO:");
        jpnlTitulos.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 150, 292, 30));

        jLabel7.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("ACTIVIDADES FINALIZADAS:");
        jpnlTitulos.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 195, 292, 30));

        jLabel8.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("TOTAL DE ACTIVIDADES:");
        jpnlTitulos.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 240, 292, 30));

        jLabel9.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("ACTIVIDAD MÁS SOLICITADA:");
        jpnlTitulos.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 285, 292, 30));

        jLabel10.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("ACTIVIDAD MENOS SOLICITADA:");
        jpnlTitulos.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 330, 292, 30));

        add(jpnlTitulos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 195, 315, 390));

        jpnlDetalles.setBackground(new java.awt.Color(255, 255, 255));
        jpnlDetalles.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlblMayNumTareas.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        jlblMayNumTareas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jpnlDetalles.add(jlblMayNumTareas, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 15, 285, 30));

        jlblMenNumTareas.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        jlblMenNumTareas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jpnlDetalles.add(jlblMenNumTareas, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 60, 285, 30));

        jlblActNoIniciadas.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        jlblActNoIniciadas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jpnlDetalles.add(jlblActNoIniciadas, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 105, 285, 30));

        jlblActEnProgreso.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        jlblActEnProgreso.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jpnlDetalles.add(jlblActEnProgreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 150, 285, 30));

        jlblActFinalizadas.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        jlblActFinalizadas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jpnlDetalles.add(jlblActFinalizadas, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 195, 285, 30));

        jlblTotalActividades.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        jlblTotalActividades.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jpnlDetalles.add(jlblTotalActividades, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 240, 285, 30));

        jlblActMasSolicitada.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        jlblActMasSolicitada.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jpnlDetalles.add(jlblActMasSolicitada, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 285, 285, 30));

        jlblActMenosSolicitada.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        jlblActMenosSolicitada.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jpnlDetalles.add(jlblActMenosSolicitada, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 330, 285, 30));

        add(jpnlDetalles, new org.netbeans.lib.awtextra.AbsoluteConstraints(315, 195, 310, 390));

        jLabel1.setFont(new java.awt.Font("Poppins Medium", 0, 22)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ESTADÍSTICAS GENERALES");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 623, 45));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jlblActEnProgreso;
    private javax.swing.JLabel jlblActFinalizadas;
    private javax.swing.JLabel jlblActMasSolicitada;
    private javax.swing.JLabel jlblActMenosSolicitada;
    private javax.swing.JLabel jlblActNoIniciadas;
    private javax.swing.JLabel jlblMayNumTareas;
    private javax.swing.JLabel jlblMenNumTareas;
    private javax.swing.JLabel jlblTotalActividades;
    private javax.swing.JPanel jpnlDetalles;
    private javax.swing.JPanel jpnlPerfil;
    private javax.swing.JPanel jpnlTitulos;
    private javax.swing.JLabel jtxtBienvenida;
    // End of variables declaration//GEN-END:variables
}
