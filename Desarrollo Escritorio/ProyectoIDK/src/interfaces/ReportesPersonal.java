/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author Christian
 */
public class ReportesPersonal extends javax.swing.JPanel {

    private Connection conexion;

    public ReportesPersonal(Connection conexion) {
        initComponents();
        this.conexion = conexion;
        jdtcFechaInicial.setCalendar(Calendar.getInstance());
        jdtcFechaFinal.setCalendar(Calendar.getInstance());
    }

    private void reporte(String fechaInicial, String fechaFinal) {
        try {
            Map ced = new HashMap();
            ced.put("FEC1", fechaInicial);
            ced.put("FEC2", fechaFinal);
            JasperReport reporte = JasperCompileManager.compileReport("D:\\Ingeniería en Software (II Semestre)\\IV Semestre\\Metodologías Ágiles\\Proyecto\\IDK_Chancusig_Jaramillo_Zamora\\Desarrollo Escritorio\\ProyectoIDK\\src\\reportes\\reportePersonalG.jrxml");
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, ced, conexion);
            JInternalFrame iFrame = new JInternalFrame();
            iFrame.getContentPane().add(new JRViewer(jasperPrint));
            redefinirContenido(iFrame);
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(this, "Inténtelo de nuevo más tarde", "Error", 0);
        }
    }

    private void redefinirContenido(JInternalFrame contenido) {
        contenido.setBounds(-5, -30, 632, 484);
        contenido.setVisible(true);
        jdskResultado.removeAll();
        jdskResultado.add(contenido, BorderLayout.CENTER);
        jdskResultado.revalidate();
        jdskResultado.repaint();
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
        jdskResultado = new javax.swing.JDesktopPane();

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
        add(jdskResultado, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 75, 623, 450));
    }// </editor-fold>//GEN-END:initComponents

    private void jtxtReporteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtxtReporteMouseClicked
        String fechaInicial = Reportes.obtenerFecha(jdtcFechaInicial, this);
        if (fechaInicial == null) {
            return;
        }
        String fechaFinal = Reportes.obtenerFecha(jdtcFechaFinal, this);
        if (fechaFinal == null) {
            return;
        }
        reporte(fechaInicial, fechaFinal);
    }//GEN-LAST:event_jtxtReporteMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JDesktopPane jdskResultado;
    private com.toedter.calendar.JDateChooser jdtcFechaFinal;
    private com.toedter.calendar.JDateChooser jdtcFechaInicial;
    private javax.swing.JPanel jpnlFiltros;
    private javax.swing.JPanel jpnlReporte;
    private javax.swing.JLabel jtxtReporte;
    // End of variables declaration//GEN-END:variables
}
