/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grupp10Applikation;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import static javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

/**
 *
 * @author oskar
 */
public class huvudFonster extends javax.swing.JFrame {

    public final String anvandare;
    private AnvändarSida nysida;
    private int admin = 0;
    GridBagLayout layout = new GridBagLayout();
    AktivitetsSkapaInlagg pAktivitet;
    ForetagsSkapaInlagg pForetag;
    Sql sql;

    /**
     * Creates new form huvudFonster
     *
     * @param anvandarNamn
     */

    public huvudFonster(String anvandarNamn, int admin) {
        anvandare = anvandarNamn;
        this.admin = admin;
        this.sql = new Sql();
        initComponents();
        hamtaInlagg();
        
        pAktivitet = new AktivitetsSkapaInlagg(anvandare);
        pForetag = new ForetagsSkapaInlagg(anvandare);
        jPHuvudInlaggPanel.setLayout(layout);
        GridBagConstraints c = new GridBagConstraints();
        c.gridx=0;
        c.gridy=0;
        jPHuvudInlaggPanel.add(pAktivitet, c);
        c.gridx=0;
        c.gridy=0;
        jPHuvudInlaggPanel.add(pForetag, c);
        pAktivitet.setVisible(false);
        pForetag.setVisible(false);
        
  
     /*   int tid = 1;
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                jPanel1.removeAll();
                hamtaInlagg();
            }
        }, 0, 1000 * 60 * tid);
        */
        
        
        if (admin == 1) {
            lblValkomst.setText("Välkommen! Du är inloggad som Admin");
            btnAdmin.setVisible(true);
        } else {
            lblValkomst.setText("Välkommen! Du är inloggad som användare.");
            btnAdmin.setVisible(false);
        }

    }

    public int arAdmin() {

        return admin;
    }

    public void hamtaInlagg() {

        //String textR = "";
        Image image;
        byte[] imageBytes;

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://"+sql.getIp()+":3306/namn", "Nikola", "password1234");

            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("select Text, Profilbild, anvandarnamn, inlagg.`Titel`, datum, tid from inlagg join anvandare on AnvandareID = AnvandarID order by datum desc, tid desc");

            while (rs.next()) {

                
                
                String text = rs.getString(1);
                
                imageBytes=rs.getBytes(2);
                
                String text2 = rs.getString(3);
                
                String titel = rs.getString(4);
                
                String datum = rs.getString(5);
                
                String tid = rs.getString(6);
                
                image=getToolkit().createImage(imageBytes);
                
                ImageIcon icon = new ImageIcon(image);
                
                Image img = icon.getImage().getScaledInstance(76, 52, Image.SCALE_SMOOTH);
                
                ImageIcon bild = new ImageIcon(img);

                
                /*
                StringBuilder sb = new StringBuilder(text);

                int i = 0;
                while ((i = sb.indexOf(" ", i + 100)) != -1) {
                    sb.replace(i, i + 1, "\n");
                 
                }

                textR = sb.toString(); */
                
                PanelTest paneltest = new PanelTest(text, bild, text2,anvandare, admin, titel, datum, tid);
                paneltest.setVisible(true);
                jPanel1.add(paneltest);
                

            }

        } catch (SQLException ex) {
            Logger.getLogger(huvudFonster.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        /**
         * This method is called from within the constructor to initialize the
         * form. WARNING: Do NOT modify this code. The content of this method is
         * always regenerated by the Form Editor.
         */
        @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuBar1 = new java.awt.MenuBar();
        menu1 = new java.awt.Menu();
        menu2 = new java.awt.Menu();
        lblValkomst = new javax.swing.JLabel();
        btnVisaProfil = new javax.swing.JButton();
        btnVisaAktivitetsflode = new javax.swing.JButton();
        btnForskningsFlode = new javax.swing.JButton();
        btnVisaAllaFloden = new javax.swing.JButton();
        btnForetagsFlode = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnVisaMedelande = new javax.swing.JButton();
        btnTaBortMedelande = new javax.swing.JButton();
        btnBokaEttMöte = new javax.swing.JButton();
        lblProfilbild = new javax.swing.JLabel();
        lblInloggadSom = new javax.swing.JLabel();
        jSPValtDatum = new javax.swing.JScrollPane();
        jTAValtDatum = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jCalendar1 = new com.toedter.calendar.JCalendar();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPHuvudInlaggPanel = new javax.swing.JPanel();
        btnAdmin = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        menu1.setLabel("File");
        menuBar1.add(menu1);

        menu2.setLabel("Edit");
        menuBar1.add(menu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        lblValkomst.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblValkomst.setText("Välkommen! Just nu visas startflödet");

        btnVisaProfil.setText("Visa din profil");
        btnVisaProfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisaProfilActionPerformed(evt);
            }
        });

        btnVisaAktivitetsflode.setText("Visa aktivitetsflöde");
        btnVisaAktivitetsflode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisaAktivitetsflodeActionPerformed(evt);
            }
        });

        btnForskningsFlode.setText("Visa forskningsflöde");

        btnVisaAllaFloden.setText("Visa alla flöden");
        btnVisaAllaFloden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisaAllaFlodenActionPerformed(evt);
            }
        });

        btnForetagsFlode.setText("Visa företagsflöde");
        btnForetagsFlode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnForetagsFlodeActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Du har 10000 nya notiser");

        btnVisaMedelande.setText("Visa notis");

        btnTaBortMedelande.setText("Ta bort notis");

        btnBokaEttMöte.setText("Boka ett möte");

        lblProfilbild.setText(" Här visas profilbilden");

        lblInloggadSom.setText("Du är inloggad som: namn");

        jTAValtDatum.setColumns(20);
        jTAValtDatum.setRows(5);
        jTAValtDatum.setText("Här visas information om valt datum");
        jSPValtDatum.setViewportView(jTAValtDatum);

        jButton1.setText("Skapa nytt inlägg");

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.PAGE_AXIS));
        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout jPHuvudInlaggPanelLayout = new javax.swing.GroupLayout(jPHuvudInlaggPanel);
        jPHuvudInlaggPanel.setLayout(jPHuvudInlaggPanelLayout);
        jPHuvudInlaggPanelLayout.setHorizontalGroup(
            jPHuvudInlaggPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 776, Short.MAX_VALUE)
        );
        jPHuvudInlaggPanelLayout.setVerticalGroup(
            jPHuvudInlaggPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 269, Short.MAX_VALUE)
        );

        btnAdmin.setText("Admin Inställningar");
        btnAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminActionPerformed(evt);
            }
        });

        jButton2.setText("Uppdatera Flöde");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnVisaAktivitetsflode, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnForetagsFlode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnVisaAllaFloden, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnBokaEttMöte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnVisaProfil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnForskningsFlode, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 865, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(jPHuvudInlaggPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(165, 165, 165))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSPValtDatum, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnVisaMedelande, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnTaBortMedelande, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblInloggadSom)
                                        .addGap(107, 107, 107)
                                        .addComponent(lblProfilbild))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(103, 103, 103)
                                .addComponent(jCalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(30, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(493, 493, 493)
                .addComponent(lblValkomst)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblProfilbild, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblInloggadSom))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblValkomst)
                        .addGap(108, 108, 108)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnVisaMedelande, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnTaBortMedelande, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(107, 107, 107)
                                .addComponent(jCalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(175, 175, 175)
                                .addComponent(jSPValtDatum, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnVisaProfil, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(36, 36, 36)
                                        .addComponent(btnVisaAktivitetsflode, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(40, 40, 40)
                                        .addComponent(btnForskningsFlode, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(38, 38, 38)
                                        .addComponent(btnForetagsFlode, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(37, 37, 37)
                                        .addComponent(btnVisaAllaFloden, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(29, 29, 29)
                                        .addComponent(btnBokaEttMöte, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(29, 29, 29)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(31, 31, 31)
                                        .addComponent(btnAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jPHuvudInlaggPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2)))
                        .addGap(157, 157, 157))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    



    private void btnVisaProfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisaProfilActionPerformed
        AnvändarSida nySida = new AnvändarSida(anvandare, admin);
        nySida.textAnvandare();
        nySida.setVisible(true);
        this.setVisible(false);

    }//GEN-LAST:event_btnVisaProfilActionPerformed

    private void btnVisaAktivitetsflodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisaAktivitetsflodeActionPerformed
        pAktivitet.setVisible(true);
        pForetag.setVisible(false);
    }//GEN-LAST:event_btnVisaAktivitetsflodeActionPerformed

    private void btnForetagsFlodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnForetagsFlodeActionPerformed
        pForetag.setVisible(true);
        pAktivitet.setVisible(false);
    }//GEN-LAST:event_btnForetagsFlodeActionPerformed

    private void btnAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminActionPerformed
        AdminSida admin = new AdminSida();
        admin.setVisible(true);
        
    }//GEN-LAST:event_btnAdminActionPerformed

    private void btnVisaAllaFlodenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisaAllaFlodenActionPerformed
        pAktivitet.setVisible(false);
        pForetag.setVisible(false);
    }//GEN-LAST:event_btnVisaAllaFlodenActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      
         jPanel1.removeAll();
        hamtaInlagg();
       
      
    }//GEN-LAST:event_jButton2ActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(huvudFonster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                huvudFonster nysida = new huvudFonster("lol", 1);
                nysida.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdmin;
    private javax.swing.JButton btnBokaEttMöte;
    private javax.swing.JButton btnForetagsFlode;
    private javax.swing.JButton btnForskningsFlode;
    private javax.swing.JButton btnTaBortMedelande;
    private javax.swing.JButton btnVisaAktivitetsflode;
    private javax.swing.JButton btnVisaAllaFloden;
    private javax.swing.JButton btnVisaMedelande;
    private javax.swing.JButton btnVisaProfil;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPHuvudInlaggPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jSPValtDatum;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTAValtDatum;
    private javax.swing.JLabel lblInloggadSom;
    private javax.swing.JLabel lblProfilbild;
    private javax.swing.JLabel lblValkomst;
    private java.awt.Menu menu1;
    private java.awt.Menu menu2;
    private java.awt.MenuBar menuBar1;
    // End of variables declaration//GEN-END:variables
}
