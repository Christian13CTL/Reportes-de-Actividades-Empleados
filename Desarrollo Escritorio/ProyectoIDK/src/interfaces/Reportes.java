/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Christian
 */
public class Reportes extends javax.swing.JPanel {

    private Connection conexion;
    Cursor cursorDefecto, cursorMano;
    
    public Reportes(Connection conexion) {
        initComponents();
        cursorDefecto = new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR);
        cursorMano = new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR);
        this.conexion = conexion;
        inicializarReportes();
    }
    
    private void inicializarReportes() {
        redefinirPanelReportes(new ReportesEstado(conexion));
    }
    
    private void redefinirPanelReportes(JPanel contenido) {
        contenido.setBounds(0, 0, 623, 525);
        jpnlReportes.removeAll();
        jpnlReportes.add(contenido, BorderLayout.CENTER);
        jpnlReportes.revalidate();
        jpnlReportes.repaint();
    }
    
    private void definirEstadoBotones(JLabel boton, JLabel etiqueta) {
        ArrayList<JLabel> botones = new ArrayList<>(Arrays.asList(jlblFondoEstado, jlblFondoActividad, jlblFondoPersonal));
        ArrayList<JLabel> etiquetas = new ArrayList<>(Arrays.asList(jtxtEstado, jtxtActividad, jtxtPersonal));
        boton.setIcon(new ImageIcon(getClass().getResource("/imagenes/fondoCriterios_188_45.png")));
        etiqueta.setCursor(cursorDefecto);
        botones.remove(boton);
        etiquetas.remove(etiqueta);
        for (int i = 0; i < botones.size(); i++) {
            botones.get(i).setIcon(new ImageIcon(getClass().getResource("/imagenes/fondoCriteriosG_188_45.png")));
            etiquetas.get(i).setCursor(cursorMano);
        }
    }
    
    public static String obtenerFecha(com.toedter.calendar.JDateChooser fecha, JPanel contenedor) {
        try {
            String formato = fecha.getDateFormatString();
            Date date = fecha.getDate();
            SimpleDateFormat sdf = new SimpleDateFormat(formato);
            return String.valueOf(sdf.format(date));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(contenedor, "Elija un rango de fechas v�lido", "Error", JOptionPane.ERROR_MESSAGE);
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

        jpnlCriterios = new javax.swing.JPanel();
        jtxtEstado = new javax.swing.JLabel();
        jlblFondoEstado = new javax.swing.JLabel();
        jtxtActividad = new javax.swing.JLabel();
        jlblFondoActividad = new javax.swing.JLabel();
        jtxtPersonal = new javax.swing.JLabel();
        jlblFondoPersonal = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jpnlReportes = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(415, 390));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpnlCriterios.setBackground(new java.awt.Color(255, 255, 255));
        jpnlCriterios.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtxtEstado.setFont(new java.awt.Font("Roboto Medium", 0, 22)); // NOI18N
        jtxtEstado.setForeground(new java.awt.Color(255, 255, 255));
        jtxtEstado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jtxtEstado.setText("ESTADO");
        jtxtEstado.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jtxtEstado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtxtEstadoMouseClicked(evt);
            }
        });
        jpnlCriterios.add(jtxtEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 15, 188, 45));

        jlblFondoEstado.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jlblFondoEstado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondoCriterios_188_45.png"))); // NOI18N
        jpnlCriterios.add(jlblFondoEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 15, 188, 45));

        jtxtActividad.setFont(new java.awt.Font("Roboto Medium", 0, 22)); // NOI18N
        jtxtActividad.setForeground(new java.awt.Color(255, 255, 255));
        jtxtActividad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jtxtActividad.setText("ACTIVIDAD");
        jtxtActividad.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jtxtActividad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtxtActividadMouseClicked(evt);
            }
        });
        jpnlCriterios.add(jtxtActividad, new org.netbeans.lib.awtextra.AbsoluteConstraints(217, 15, 188, 45));

        jlblFondoActividad.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jlblFondoActividad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondoCriteriosG_188_45.png"))); // NOI18N
        jpnlCriterios.add(jlblFondoActividad, new org.netbeans.lib.awtextra.AbsoluteConstraints(217, 15, 188, 45));

        jtxtPersonal.setFont(new java.awt.Font("Roboto Medium", 0, 22)); // NOI18N
        jtxtPersonal.setForeground(new java.awt.Color(255, 255, 255));
        jtxtPersonal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jtxtPersonal.setText("PERSONAL");
        jtxtPersonal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jtxtPersonal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtxtPersonalMouseClicked(evt);
            }
        });
        jpnlCriterios.add(jtxtPersonal, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 15, 188, 45));

        jlblFondoPersonal.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jlblFondoPersonal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondoCriteriosG_188_45.png"))); // NOI18N
        jpnlCriterios.add(jlblFondoPersonal, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 15, 188, 45));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondoCriterios_623_60.png"))); // NOI18N
        jpnlCriterios.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 623, 60));

        add(jpnlCriterios, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 623, 60));

        javax.swing.GroupLayout jpnlReportesLayout = new javax.swing.GroupLayout(jpnlReportes);
        jpnlReportes.setLayout(jpnlReportesLayout);
        jpnlReportesLayout.setHorizontalGroup(
            jpnlReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 623, Short.MAX_VALUE)
        );
        jpnlReportesLayout.setVerticalGroup(
            jpnlReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 525, Short.MAX_VALUE)
        );

        add(jpnlReportes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 623, 525));
    }// </editor-fold>//GEN-END:initComponents

    private void jtxtEstadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtxtEstadoMouseClicked
        if (jtxtEstado.getCursor().toString().equals(cursorMano.toString())) {
            redefinirPanelReportes(new ReportesEstado(conexion));
            definirEstadoBotones(jlblFondoEstado, jtxtEstado);
        }
    }//GEN-LAST:event_jtxtEstadoMouseClicked

    private void jtxtActividadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtxtActividadMouseClicked
        if (jtxtActividad.getCursor().toString().equals(cursorMano.toString())) {
            redefinirPanelReportes(new ReportesActividad(conexion));
            definirEstadoBotones(jlblFondoActividad, jtxtActividad);
        }
    }//GEN-LAST:event_jtxtActividadMouseClicked

    private void jtxtPersonalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtxtPersonalMouseClicked
        if (jtxtPersonal.getCursor().toString().equals(cursorMano.toString())) {
            redefinirPanelReportes(new ReportesPersonal(conexion));
            definirEstadoBotones(jlblFondoPersonal, jtxtPersonal);
        }
    }//GEN-LAST:event_jtxtPersonalMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jlblFondoActividad;
    private javax.swing.JLabel jlblFondoEstado;
    private javax.swing.JLabel jlblFondoPersonal;
    private javax.swing.JPanel jpnlCriterios;
    private javax.swing.JPanel jpnlReportes;
    private javax.swing.JLabel jtxtActividad;
    private javax.swing.JLabel jtxtEstado;
    private javax.swing.JLabel jtxtPersonal;
    // End of variables declaration//GEN-END:variables
}
