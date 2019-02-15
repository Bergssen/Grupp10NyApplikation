/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grupp10Applikation;

import Grupp10Applikation.BildMetoder;
import Grupp10Applikation.Sql;
import java.awt.Color;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author mathias
 */
public class AktivitetsSkapaInlagg extends javax.swing.JPanel {

    Sql sql;
    private BildMetoder bildmetoder;
    /**
     * Creates new form AktivitetsSkapaInlagg
     */
    public AktivitetsSkapaInlagg(String anvandarnamn) {
        initComponents();
        sql = new Sql(anvandarnamn);
        uppdateraBox();
        jTAInlaggsText.setLineWrap(true);
        bildmetoder = new BildMetoder();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTAInlaggsText = new javax.swing.JTextArea();
        jTTitel = new javax.swing.JTextField();
        jBPublicera = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jCKategori = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jBVäljbild = new javax.swing.JButton();
        jLbild = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(776, 269));
        setPreferredSize(new java.awt.Dimension(776, 269));

        jTAInlaggsText.setColumns(20);
        jTAInlaggsText.setForeground(new java.awt.Color(153, 153, 153));
        jTAInlaggsText.setRows(5);
        jTAInlaggsText.setText("Vad tänker du på?");
        jTAInlaggsText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTAInlaggsTextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTAInlaggsTextFocusLost(evt);
            }
        });
        jScrollPane1.setViewportView(jTAInlaggsText);

        jTTitel.setForeground(new java.awt.Color(153, 153, 153));
        jTTitel.setText("Titel...");
        jTTitel.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTTitelFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTTitelFocusLost(evt);
            }
        });

        jBPublicera.setText("Publicera");
        jBPublicera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBPubliceraActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 16)); // NOI18N
        jLabel1.setText("Skapa inlägg");

        jCKategori.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setText("Välj kategori");

        jBVäljbild.setText("Välj bild");
        jBVäljbild.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBVäljbildActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jTTitel, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jCKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBPublicera, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLbild, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jBVäljbild)))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTTitel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jCKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jLbild, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBVäljbild)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBPublicera)))
                .addGap(18, 18, 18))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void uppdateraBox()
    {
      DefaultComboBoxModel kategoriModell = new DefaultComboBoxModel(sql.getKategorierAktivitet());
      jCKategori.setModel(kategoriModell);
    }
    
    private void jTTitelFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTTitelFocusLost
        if(jTTitel.getText().equals(""))
        {
            jTTitel.setText("Titel...");
            jTTitel.setForeground(Color.gray);
        }
        else if (!jTTitel.getText().equals(""))
        {    
        jTTitel.setForeground(Color.black);
        }
        
    }//GEN-LAST:event_jTTitelFocusLost

    private void jTTitelFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTTitelFocusGained
        if(jTTitel.getText().equals("Titel..."))
        {
            jTTitel.setText("");
        }
        jTTitel.setForeground(Color.black);
    }//GEN-LAST:event_jTTitelFocusGained

    private void jTAInlaggsTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTAInlaggsTextFocusLost
        if(jTAInlaggsText.getText().equals(""))
        {
            jTAInlaggsText.setText("Vad tänker du på?");
            jTAInlaggsText.setForeground(Color.gray);
        }
        
        else if (!jTAInlaggsText.getText().equals(""))
        {    
        jTAInlaggsText.setForeground(Color.black);
        }
    }//GEN-LAST:event_jTAInlaggsTextFocusLost

    private void jTAInlaggsTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTAInlaggsTextFocusGained
        if(jTAInlaggsText.getText().equals("Vad tänker du på?"))
        {
            jTAInlaggsText.setText("");
        }
        jTAInlaggsText.setForeground(Color.black);
    }//GEN-LAST:event_jTAInlaggsTextFocusGained

    private void jBPubliceraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBPubliceraActionPerformed
        String titel = jTTitel.getText();
        String inlagg = jTAInlaggsText.getText();
        String kategori = (String)jCKategori.getSelectedItem();
        boolean hittad = true;
        int flodeID = 2;
        int inlaggsId = sql.incrementInlaggsID();
        int filID = sql.incrementFilID();
        try {
            sql.skapaInlagg(titel, inlagg, flodeID, kategori);
        } catch (ParseException ex) {
            Logger.getLogger(AktivitetsSkapaInlagg.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(jLbild.getIcon() == null)
        {
        hittad = false;
        }
        if (hittad)
        {
            bildmetoder.laddaUppBildFlode(filID);
            sql.setInlaggHarBild(inlaggsId, filID);
        }
    }//GEN-LAST:event_jBPubliceraActionPerformed

    private void jBVäljbildActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBVäljbildActionPerformed
        jLbild.setIcon(bildmetoder.valjProfilBild());
       
    }//GEN-LAST:event_jBVäljbildActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBPublicera;
    private javax.swing.JButton jBVäljbild;
    private javax.swing.JComboBox<String> jCKategori;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLbild;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTAInlaggsText;
    private javax.swing.JTextField jTTitel;
    // End of variables declaration//GEN-END:variables
}
