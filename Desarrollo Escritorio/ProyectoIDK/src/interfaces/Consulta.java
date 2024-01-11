/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.sql.*;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author Christian
 */
public class Consulta extends javax.swing.JPanel {

    private Connection conexion;
    DefaultTableModel modeloRegistros;

    public Consulta(Connection conexion) throws SQLException {
        initComponents();
        this.conexion = conexion;
        jdtcFechaInicial.setCalendar(Calendar.getInstance());
        jdtcFechaFinal.setCalendar(Calendar.getInstance());
        cargarTabla();
    }

    private void cargarTabla() throws SQLException {
        String fechaInicial = Reportes.obtenerFecha(jdtcFechaInicial, this);
        if (fechaInicial == null) {
            return;
        }
        String fechaFinal = Reportes.obtenerFecha(jdtcFechaFinal, this);
        if (fechaFinal == null) {
            return;
        }
        PreparedStatement statement = null;
        try {
            String[] titles = {"ID", "ACTIVIDAD", "FECHA", "ESTADO", "EMPLEADO", "HORAS"};
            String[] records = new String[7];
            modeloRegistros = new DefaultTableModel(null, titles);
            String sql = "SELECT RegistroActividades.IDE_REG, ACTIVIDADES.NOM_ACT, RegistroActividades.FEC_INI_REG, RegistroActividades.EST_REG, CONCAT(Empleados.NOM_EMP, ' ', SUBSTRING(Empleados.APE_EMP, 1, 1), '.') AS EMPLEADO, RegistroActividades.NUM_HOR_REG"
                    + " FROM ACTIVIDADES, REGISTROACTIVIDADES, EMPLEADOS"
                    + " WHERE RegistroActividades.EMP_INI_REG = Empleados.CED_EMP AND"
                    + " RegistroActividades.ACT_REG = Actividades.IDE_ACT AND"
                    + " RegistroActividades.FEC_INI_REG BETWEEN ? AND ? ";
            statement = conexion.prepareStatement(sql);
            statement.setString(1, fechaInicial);
            statement.setString(2, fechaFinal);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                records[0] = rs.getString("IDE_REG");
                records[1] = rs.getString("NOM_ACT");
                records[2] = rs.getString("FEC_INI_REG");
                records[3] = rs.getString("EST_REG");
                records[4] = rs.getString("EMPLEADO");
                //records[5] = rs.getString("EMP_SOL_REG");
                records[5] = rs.getString("NUM_HOR_REG");
                modeloRegistros.addRow(records);
            }
            jtblRegistros.setModel(modeloRegistros);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnlFiltros = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jdtcFechaInicial = new com.toedter.calendar.JDateChooser();
        jdtcFechaFinal = new com.toedter.calendar.JDateChooser();
        jpnlReporte = new javax.swing.JPanel();
        jtxtReporte = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblRegistros = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(415, 350));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpnlFiltros.setBackground(new java.awt.Color(255, 255, 255));
        jpnlFiltros.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Poppins", 0, 21)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("INICIO");
        jpnlFiltros.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 15, 67, 45));

        jLabel5.setFont(new java.awt.Font("Poppins", 0, 21)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("FIN");
        jpnlFiltros.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 15, 37, 45));

        jSeparator1.setForeground(new java.awt.Color(54, 58, 64));
        jpnlFiltros.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 72, 623, 7));

        jdtcFechaInicial.setToolTipText("");
        jdtcFechaInicial.setDateFormatString("yyyy-MM-dd");
        jdtcFechaInicial.setFont(new java.awt.Font("Poppins", 0, 21)); // NOI18N
        jdtcFechaInicial.setMaxSelectableDate(new java.util.Date(4102466491000L));
        jdtcFechaInicial.setMinSelectableDate(new java.util.Date(-2208967333000L));
        jpnlFiltros.add(jdtcFechaInicial, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 15, 195, 45));

        jdtcFechaFinal.setDateFormatString("yyyy-MM-dd");
        jdtcFechaFinal.setFont(new java.awt.Font("Poppins", 0, 21)); // NOI18N
        jpnlFiltros.add(jdtcFechaFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(345, 15, 195, 45));

        jpnlReporte.setBackground(new java.awt.Color(255, 255, 255));
        jpnlReporte.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtxtReporte.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jtxtReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/reporte_39_39.png"))); // NOI18N
        jtxtReporte.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jtxtReporte.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtxtReporteMouseClicked(evt);
            }
        });
        jpnlReporte.add(jtxtReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 3, 39, 39));

        jpnlFiltros.add(jpnlReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(562, 15, 45, 45));

        add(jpnlFiltros, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 623, 75));

        jtblRegistros.setFont(new java.awt.Font("Poppins Light", 0, 14)); // NOI18N
        jtblRegistros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jtblRegistros.setRowHeight(25);
        jtblRegistros.setRowMargin(2);
        jScrollPane1.setViewportView(jtblRegistros);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 75, 623, 510));
    }// </editor-fold>//GEN-END:initComponents

    private void jtxtReporteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtxtReporteMouseClicked
        try {
            cargarTabla();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Intente nuevamente más tarde", "Error", 0);
        }
    }//GEN-LAST:event_jtxtReporteMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private com.toedter.calendar.JDateChooser jdtcFechaFinal;
    private com.toedter.calendar.JDateChooser jdtcFechaInicial;
    private javax.swing.JPanel jpnlFiltros;
    private javax.swing.JPanel jpnlReporte;
    private javax.swing.JTable jtblRegistros;
    private javax.swing.JLabel jtxtReporte;
    // End of variables declaration//GEN-END:variables
}
