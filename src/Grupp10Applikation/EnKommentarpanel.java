/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grupp10Applikation;

import javax.swing.ImageIcon;

/**
 *
 * @author mathias
 */
public class EnKommentarpanel extends javax.swing.JPanel {

    /**
     * Creates new form EnKommentarpanel
     */
    public EnKommentarpanel(String text,String tid,String datum,String anvandarnamn,ImageIcon profilbild) {
        initComponents();
        jLanvandarnamn.setText(anvandarnamn);
        jLdatum.setText(datum);
        jLtid.setText(tid);
        jTextKommentar.setText(text);
        jLbild.setIcon(profilbild);
        jTextKommentar.setLineWrap(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLbild = new javax.swing.JLabel();
        jLanvandarnamn = new javax.swing.JLabel();
        jLdatum = new javax.swing.JLabel();
        jLtid = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextKommentar = new javax.swing.JTextArea();

        setBackground(new java.awt.Color(255, 255, 255));

        jLbild.setText("Bild");
        jLbild.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 255), 3, true));

        jLanvandarnamn.setText("Användarnamn");

        jLdatum.setText("Datum");

        jLtid.setText("Tid");

        jTextKommentar.setEditable(false);
        jTextKommentar.setColumns(20);
        jTextKommentar.setRows(5);
        jScrollPane1.setViewportView(jTextKommentar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLbild, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLanvandarnamn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLtid, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(jLdatum, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 703, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLbild, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLdatum)
                            .addComponent(jLtid)
                            .addComponent(jLanvandarnamn))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLanvandarnamn;
    private javax.swing.JLabel jLbild;
    private javax.swing.JLabel jLdatum;
    private javax.swing.JLabel jLtid;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextKommentar;
    // End of variables declaration//GEN-END:variables
}
