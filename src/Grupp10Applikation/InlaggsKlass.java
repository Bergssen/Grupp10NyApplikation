/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grupp10Applikation;

import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author Nikola
 */
public class InlaggsKlass {

    private String text;
    private byte[] imageBytes;
    private Sql sql;

    public void InlagssKlass() {

        text = "";
        imageBytes = null;
        this.sql = new Sql();

    }

    private void hamtaProfilbild() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://"+sql.getIp()+":3306/namn", "Nikola", "password1234");
            PreparedStatement ps = con.prepareStatement("select Profilbild from anvandare where Anvandarnamn = 'oskareriksson'");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                imageBytes = rs.getBytes(1);
                

            }

        } catch (SQLException ex) {
            Logger.getLogger(InlaggsKlass.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InlaggsKlass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void hamtaTextMeddelande() {

        
        String textR = "";
        
        

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://"+sql.getIp()+":3306/namn", "Nikola", "password1234");

            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("select Text from inlagg");

            while (rs.next()) {

                String text = rs.getString(1);

                StringBuilder sb = new StringBuilder(text);

                int i = 0;
                while ((i = sb.indexOf(" ", i + 100)) != -1) {
                    sb.replace(i, i + 1, "\n");

                }

                
                textR = sb.toString();
                
                

              

            }

        } catch (SQLException ex) {
            Logger.getLogger(Sql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
