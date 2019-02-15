/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grupp10Applikation;

import static com.sun.javafx.tk.Toolkit.getToolkit;
import java.awt.Component;
import java.awt.Image;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

/**
 *
 * @author mathias
 */
public class BildMetoder {
 
    private PreparedStatement pst ;
    private Connection con;
    
    private String filename;
    byte[] foto = null;
    private Sql sql;
    
    public BildMetoder()
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
    
    public ImageIcon valjProfilBild ()
    {
                JFileChooser chooser = new JFileChooser();
                chooser.showOpenDialog(null);
                File f = chooser.getSelectedFile();
               
                filename = f.getAbsolutePath();
                
                ImageIcon icon = new ImageIcon(filename);
                // Skriv in ScaledInstance som labeln är för att det ska visas rätt.
                Image img = icon.getImage().getScaledInstance(154, 144, Image.SCALE_SMOOTH);
                ImageIcon image = new ImageIcon(img);
                return image;
        
    }    
    
    public void laddaUppBildFlode(int FILID){
        try{
                File image = new File(filename); // filename ligger i fältet och instansieras i metoden valjBild.
                FileInputStream imageInputStream = new FileInputStream(image);
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                byte[] buf = new byte[1024];
                for(int readNum; (readNum = imageInputStream.read(buf)) != -1;)
                {
                    bos.write(buf, 0 , readNum);
                }
                foto = bos.toByteArray();
                
                String sql = "insert into fil (FILID, Fil) values (?, ?)";
          
                pst = con.prepareStatement(sql);
                pst.setInt(1, FILID);  
                pst.setBytes(2, foto);

                pst.execute();
                pst.close();
        } catch (SQLException ex) {

            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BildMetoder.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(BildMetoder.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }
    
    public void laddaUppBildDatabas(String anvandarNamn)
    {
    
        try{
                File image = new File(filename); // filename ligger i fältet och instansieras i metoden valjBild.
                FileInputStream imageInputStream = new FileInputStream(image);
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                byte[] buf = new byte[1024];
                for(int readNum; (readNum = imageInputStream.read(buf)) != -1;)
                {
                    bos.write(buf, 0 , readNum);
                }
                foto = bos.toByteArray();
                
                String sql = "update anvandare set profilbild = ? where Anvandarnamn = ?";
          
                pst = con.prepareStatement(sql);
                pst.setString(2, anvandarNamn);  
                pst.setBytes(1, foto);

                pst.execute();
                pst.close();
        } catch (SQLException ex) {

            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BildMetoder.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(BildMetoder.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
}
