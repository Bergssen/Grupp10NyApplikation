/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grupp10Applikation;

import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author User
 */
public class Validering {
    


  public static boolean kontrollAttNyaLosenMatchar(JTextField nya, JTextField nya1){ // Kontrollerar så att två fält matchar varandra.
    
    boolean resultat = false;
    String testaNya = nya.getText();
    String testaNya1 = nya1.getText();
    
    if(testaNya1.equals(testaNya)){
    
    resultat = true;
    
    
    }
    else {
    JOptionPane.showMessageDialog(null, "De nya lösenorden matchar ej!");
    }
    
    
    return resultat;
    }
  public static boolean kontrolleraLosenord(String text)
    {
       boolean resultat = false;
       char ch;
       int a = 0;
       if(text.length()>=8)
       {
           boolean r = true;
           if(r)
           {
               for(int i = 0; i < text.length();i++)
               {
                   ch = text.charAt(i);
                   if(Character.isDigit(ch))
                   {
                       resultat = true;
                       
                   }
               }
                   if(!resultat)
                   {
                      JOptionPane.showMessageDialog(null, "Lösenordet måste innehålla en siffra");
                   }
               
           }
       }
       else
       {
           JOptionPane.showMessageDialog(null, "Lösenordet måste vara 8 tecken långt.");
       }
    

       return resultat;
}
public static boolean validEpost(String email) 
  {     boolean hittad = false;
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                            "[a-zA-Z0-9_+&*-]+)*@" + 
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                            "A-Z]{2,7}$"; 
                              
        Pattern pat = Pattern.compile(emailRegex); 
        if (!pat.matcher(email).matches()) {
            hittad = false; 
            JOptionPane.showMessageDialog(null, "Fel format på lösenordet");
        }
        else {
        hittad = true;
        
        }
        return hittad;
    }
  
  
}