/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.tigrium.csomozottkarkoto.gui;

import hu.tigrium.csomozottkarkoto.CsomozottKarkoto;
import java.awt.Color;
import javax.swing.JColorChooser;

/**
 *
 * @author Kata
 */
public class SzalSzin extends javax.swing.JPanel {
    private int index;
    /**
     * Creates new form SzalSzin
     */
    public SzalSzin(int index) {
        this.index = index;
        initComponents();
    }
    
    public SzalSzin(Color szin, int index) {
        this(index);
        setSzin(szin);
    }
    
    public Color getSzin() {
        return szinminta.getBackground();
    }
    
    public void setSzin(Color szin) {
        szinminta.setBackground(szin);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        szinminta = new javax.swing.JPanel();
        modosit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 0, 2, 0));

        javax.swing.GroupLayout szinmintaLayout = new javax.swing.GroupLayout(szinminta);
        szinminta.setLayout(szinmintaLayout);
        szinmintaLayout.setHorizontalGroup(
            szinmintaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 19, Short.MAX_VALUE)
        );
        szinmintaLayout.setVerticalGroup(
            szinmintaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );

        modosit.setText("Módosít");
        modosit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modositActionPerformed(evt);
            }
        });

        jLabel1.setText((index + 1) + ".");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(szinminta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(modosit))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(modosit)
            .addComponent(jLabel1)
            .addComponent(szinminta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void modositActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modositActionPerformed
        Color color = JColorChooser.showDialog(this, "Szál szín", szinminta.getBackground());
        if (color != null) {
            szinminta.setBackground(color);
            CsomozottKarkoto.getKarkoto().setSzalSzin(index, color);
            CsomozottKarkoto.repaintKarkoto();
        }
    }//GEN-LAST:event_modositActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton modosit;
    private javax.swing.JPanel szinminta;
    // End of variables declaration//GEN-END:variables

}
