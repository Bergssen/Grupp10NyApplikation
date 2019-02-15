/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grupp10Applikation;

import java.awt.Image;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

/**
 *
 * @author oskar
 */
public class Metoder {
    
    private PreparedStatement pst ;
    private Connection con;
    private Sql sql;
    
    String filename;
    byte[] foto = null;
    
    public Metoder ()
    {
            PreparedStatement pst = null;
            Connection con = null;
            this.pst = pst;
            this.sql = new Sql();
            
        try 
        {
            Connection conn = DriverManager.getConnection("jdbc:mysql://"+sql.getIp()+":3306/namn", "Nikola", "password1234");
            this.con=conn;
        }
        catch (SQLException ex) 
        {
            
        }
    }
    
    public ImageIcon valjBild ()
    {
                
                JFileChooser chooser = new JFileChooser();
                chooser.showOpenDialog(null);
                File f = chooser.getSelectedFile();
               // b.setIcon(new ImageIcon(f.toString()));
                filename = f.getAbsolutePath();
                
                ImageIcon icon = new ImageIcon(filename);
                Image img = icon.getImage().getScaledInstance(208, 212, Image.SCALE_SMOOTH);
                ImageIcon image = new ImageIcon(img);
              //  Image img = icon.getImage().getScaledInstance(b.getWidth(), b.getHeight(), Image.SCALE_SMOOTH);
              //  b.setIcon(image);
                return image;
        
    }    
    
    public void laddaUppBild()
    {
    
         try {
                File image = new File(filename);
                FileInputStream imageInputStream = new FileInputStream(image);
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                byte[] buf = new byte[1024];
                for(int readNum; (readNum = imageInputStream.read(buf)) != -1;)
                {
                    bos.write(buf, 0 , readNum);
                }
                foto = bos.toByteArray();
                
                String sql = "update anvandare set profilbild = ? where fornamn = ?" ;
          
                pst = con.prepareStatement(sql);
                pst.setString(2, "Lars");
                pst.setBytes(1, foto);

                pst.execute();
                pst.close();
        } catch (SQLException ex) {
           
        } catch (FileNotFoundException ex) {
           
        } catch (IOException ex) {
            
        }
    
    }
    
    public static String adminTrueOrFalse(String anvandare){
    String svar = "";
    Sql sql1 = new Sql();
    
    svar = sql1.adminTrueFalse(anvandare);
    
    return svar;
    }
    
}
