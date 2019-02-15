/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grupp10Applikation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class Sql {

    private static Connection conn;
    private String anvandare;
    private String guestFornamn = "";
    private String guestEfternamn = "";
    private String guestTitel = "";
    private String guestEpost = "";
    private String guestTelnr = "";
    private int anvandarID = 0;
    private String ip = "10.22.19.205";

    public Sql() {

        try {
            Connection conn1 = DriverManager.getConnection("jdbc:mysql://"+ip+":3306/namn", "Nikola", "password1234");
            conn = conn1;
        } catch (SQLException ex) {
            Logger.getLogger(Sql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Sql(String anvandarnamn) {

        this.anvandare = anvandarnamn;
        try {
            Connection conn1 = DriverManager.getConnection("jdbc:mysql://"+ip+":3306/namn", "Nikola", "password1234");
            conn = conn1;
        } catch (SQLException ex) {
            Logger.getLogger(Sql.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
     public void setInlaggHarBild(int inlaggsID, int filID){
        
        try{
        String sql = "Insert into inlagg_har_fil (InlaggsID, FillID) values (?, ?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, inlaggsID);
            pst.setInt(2, filID);
            
            pst.execute();
        }
        catch(SQLException ex){
        System.out.print(ex);
        }
        
    }
    
    public void skapaInlagg(String titel, String inlaggstext, int flodeID, String kategori) throws ParseException
    {
        int kategoriID = getKategoriID(kategori);
        int inlaggsID = incrementInlaggsID();
        int anvID = getAnvandarID();
        String tid = getCurrentTime();
        
        
        try{
        String sql = "Insert into inlagg (InlaggsID, Titel, text, Tid, Datum, AnvandarID, KategoriID, TillhorFlode) values (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, inlaggsID);
            pst.setString(2, titel);
            pst.setString(3, inlaggstext);
            pst.setString(4, tid);
            pst.setTimestamp(5, getCurrentDate());
            pst.setInt(6, anvID);
            pst.setInt(7, kategoriID);
            pst.setInt(8, flodeID);
            
            pst.executeUpdate();
        }
        catch(SQLException ex){
        System.out.print(ex);
        }
        
    }
    
    private String getCurrentTime()
    {

     String time = new SimpleDateFormat("HH:mm").format(new Date());
     
     return time;   
    }
    
    private java.sql.Timestamp getCurrentDate() throws ParseException
    {
        
      java.util.Date today = new java.util.Date();
      return new java.sql.Timestamp(today.getTime());
    }
    
    private int getAnvandarID()
    {
        int anvID = 0;
     try {
            String sql = "select AnvandareID from anvandare where Anvandarnamn = '" + anvandare + "'";
            PreparedStatement pst = conn.prepareStatement(sql);

            ResultSet rs = pst.executeQuery(sql);

            while (rs.next()) {

                anvID = rs.getInt(1);

            }

        } catch (SQLException ex) {
            Logger.getLogger(Sql.class.getName()).log(Level.SEVERE, null, ex);
        }
      return anvID;
    }
    
    public int incrementFilID(){
        
          int FILID = 0;
        try {
            String sql = "Select max(FILID) from fil";
            PreparedStatement pst = conn.prepareStatement(sql);

            ResultSet rs = pst.executeQuery(sql);

            while (rs.next()) {

            FILID = rs.getInt(1);

            }

        } catch (SQLException ex) {
            Logger.getLogger(Sql.class.getName()).log(Level.SEVERE, null, ex);
        }
        FILID += 1;
        return FILID;
        
    }
    
    public int incrementKommentarID()
    {
    
         int kommentarID = 0;
        try {
            String sql = "Select max(KommentarID) from kommentar";
            PreparedStatement pst = conn.prepareStatement(sql);

            ResultSet rs = pst.executeQuery(sql);

            while (rs.next()) {

            kommentarID = rs.getInt(1);

            }

        } catch (SQLException ex) {
            Logger.getLogger(Sql.class.getName()).log(Level.SEVERE, null, ex);
        }
        kommentarID += 1;
        return kommentarID;
        
    
    }
    
    private int getAnvandarIDAnvandarnamn(String anvandarnamn)
    {
    
    int anvID = 0;
     try {
            String sql = "select AnvandareID from anvandare where Anvandarnamn = '" + anvandarnamn + "'";
            PreparedStatement pst = conn.prepareStatement(sql);

            ResultSet rs = pst.executeQuery(sql);

            while (rs.next()) {

                anvID = rs.getInt(1);

            }

        } catch (SQLException ex) {
            Logger.getLogger(Sql.class.getName()).log(Level.SEVERE, null, ex);
        }
      return anvID;
        
    }
    
    public int getInlaggsIDkommentar(String tid, String datum, String text, String anvandarnamn)
    {
    int inlaggsID = 0;
    int anvandarIdet = getAnvandarIDAnvandarnamn(anvandarnamn);
    System.out.println(anvandarIdet + " anvandar" + tid + " tid" + text + " text" + anvandarnamn + " anvandarnamn");
    try {
            String sql = "select InlaggsID from inlagg where text = '"+text+"' and Datum = '"+datum+"' and Tid = '"+tid+"' and AnvandarID ="+anvandarIdet;
            PreparedStatement pst = conn.prepareStatement(sql);

            ResultSet rs = pst.executeQuery(sql);

            while (rs.next()) {

                inlaggsID = rs.getInt(1);

            }

        } catch (SQLException ex) {
            Logger.getLogger(Sql.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    System.out.println(inlaggsID + " hämtar id");
    return inlaggsID;
    }
    
    public void nyKommentar(String tid, String datum, String inlaggsText, String anvandarnamn, String kommentarText) throws ParseException
    {
      int kommentarID = incrementKommentarID();
      int anvandarIDD = getAnvandarID();
      int inlaggsID = getInlaggsIDkommentar(tid, datum, inlaggsText, anvandarnamn);
      System.out.println(inlaggsID + " ID");
      String tiden = getCurrentTime();
      
      System.out.println(anvandarIDD);
      System.out.println(anvandare);
      
      try{
        String sql = "Insert into kommentar (KommentarID, text) values (?, ?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, kommentarID);
            pst.setString(2, kommentarText);
            
            
            pst.executeUpdate();
        }
        catch(SQLException ex){
        System.out.print(ex);
        }  
      
      
      try{
        String sql = "Insert into anvandare_kommentar_inlagg values (?, ?, ?, ?, ?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, anvandarIDD);
            pst.setInt(2, kommentarID);
            pst.setInt(3, inlaggsID);
            pst.setString(4, tiden);
            pst.setTimestamp(5, getCurrentDate());
            
            
            pst.executeUpdate();
        }
        catch(SQLException ex){
        System.out.print(ex);
        }
      
    }
    
    public int incrementInlaggsID()
    {
       int inlaggsID = 0;
        try {
            String sql = "Select max(InlaggsID) from inlagg";
            PreparedStatement pst = conn.prepareStatement(sql);

            ResultSet rs = pst.executeQuery(sql);

            while (rs.next()) {

            inlaggsID = rs.getInt(1);

            }

        } catch (SQLException ex) {
            Logger.getLogger(Sql.class.getName()).log(Level.SEVERE, null, ex);
        }
        inlaggsID += 1;
        return inlaggsID;
    }
    
    private int getKategoriID(String kategori)
    {
       int kategoriID = 0;
        
        try {
            String sql = "select KategoriID from kategori where namn = " + "'" + kategori + "'";
            PreparedStatement pst = conn.prepareStatement(sql);

            ResultSet rs = pst.executeQuery(sql);

            while (rs.next()) {

            kategoriID = rs.getInt(1);

            }

        } catch (SQLException ex) {
            Logger.getLogger(Sql.class.getName()).log(Level.SEVERE, null, ex);
        }
       return kategoriID;
    }
    
    public String[] getKategoriForetag()
    {
    
        String kategorier ="";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("Select namn from kategori " +
                                             "where Tillhorflode = 1;");
            
            while(rs.next())
            {
               kategorier += rs.getString("namn") + "\n";
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(Sql.class.getName()).log(Level.SEVERE, null, ex);
        }
        String[] allaKategorier = kategorier.split("\n");
        return allaKategorier;
        
    }
    
    public String[] getKategorierAktivitet()
    {
        String kategorier ="";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("Select namn from kategori " +
                                             "where Tillhorflode = 2;");
            
            while(rs.next())
            {
               kategorier += rs.getString("namn") + "\n";
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(Sql.class.getName()).log(Level.SEVERE, null, ex);
        }
        String[] allaKategorier = kategorier.split("\n");
        return allaKategorier;
    }

    public boolean inlogg(String Anvandare, String Losen) {
        String sqlAnvandare = "";
        String sqlLosen = "";       // Inloggningsfunktionen
        boolean hittad = false;

        try {
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("select * from anvandare");

            while (rs.next()) {

                sqlAnvandare = rs.getString(7);
                sqlLosen = rs.getString(6);
                if (sqlAnvandare.equals(Anvandare) && sqlLosen.equals(Losen)) {
                    hittad = true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Sql.class.getName()).log(Level.SEVERE, null, ex);
        }

        return hittad;

    }

    public int hamtaAnvandarID(JLabel varde) {

        String anvandarenamnGuest = varde.getText();

        try {
            String sql = "select AnvandareID from anvandare where Anvandarnamn = " + "'" + anvandarenamnGuest + "'";
            PreparedStatement pst = conn.prepareStatement(sql);

            ResultSet rs = pst.executeQuery(sql);

            while (rs.next()) {

                anvandarID = rs.getInt(1);

            }

            System.out.println(anvandarID);

        } catch (SQLException ex) {
            Logger.getLogger(Sql.class.getName()).log(Level.SEVERE, null, ex);
        }

        return anvandarID;
    }

    public void getResultGuestVarde(JLabel varde) {

        hamtaAnvandarID(varde);

        int anvandareID = hamtaAnvandarID(varde);

        String anvandarIDString = Integer.toString(anvandareID);

        try {

            String sql = "select fornamn, efternamn, telnr, Epost, Titel from anvandare where AnvandareID = " + anvandarIDString;
            PreparedStatement pst = conn.prepareStatement(sql);

            ResultSet rs = pst.executeQuery(sql);

            while (rs.next()) {

                guestFornamn = rs.getString(1);
                guestEfternamn = rs.getString(2);
                guestTelnr = rs.getString(3);
                guestEpost = rs.getString(4);
                guestTitel = rs.getString(5);

            }

        } catch (SQLException ex) {
            Logger.getLogger(Sql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void andraLosen(String losen) {

        String nyalosen = losen;

        try {

            String sql = "Update anvandare set losenord='" + nyalosen + "'" + "where Anvandarnamn='" + anvandare + "'";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Ditt lösenord är ändrat");

        } catch (SQLException ex) {
            Logger.getLogger(Sql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void andraFornamn(String fornamn) {

        try {
            String sql = "Update anvandare set fornamn='" + fornamn + "'" + "where Anvandarnamn='" + anvandare + "'";
            PreparedStatement pst = conn.prepareStatement(sql);
            int updateCount = pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Sql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void andraEfternamn(String efternamn) {

        try {
            String sql = "Update anvandare set efternamn='" + efternamn + "'" + "where Anvandarnamn='" + anvandare + "'";
            PreparedStatement pst = conn.prepareStatement(sql);
            int updateCount = pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Sql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void andraTitel(String titel) {

        try {
            String sql = "Update anvandare set titel='" + titel + "'" + "where Anvandarnamn='" + anvandare + "'";
            PreparedStatement pst = conn.prepareStatement(sql);
            int updateCount = pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Sql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void andraEpost(String epost) {

        try {
            String sql = "Update anvandare set epost='" + epost + "'" + "where Anvandarnamn='" + anvandare + "'";
            PreparedStatement pst = conn.prepareStatement(sql);
            int updateCount = pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Sql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void andraTelefonnummer(String telefon) {

        try {
            String sql = "Update anvandare set telnr='" + telefon + "'" + "where Anvandarnamn='" + anvandare + "'";
            PreparedStatement pst = conn.prepareStatement(sql);
            int updateCount = pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Sql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getGuestFornamn() {
        return guestFornamn;
    }

    public String getGuestEfternamn() {
        return guestEfternamn;
    }

    public String getGuestTitel() {
        return guestTitel;
    }

    public String getGuestTelnr() {
        return guestTelnr;
    }

    public String getGuestEpost() {
        return guestEpost;
    }

    public String fyllText(String anvandare, String kolumn) {
        String resultat = "";

        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select " + kolumn + " from anvandare where Anvandarnamn = '" + anvandare + "'");
            if (rs.next()) {
                resultat = rs.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Sql.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resultat;
    }

    public String kollaAdmin(String anvandare) {
        String resultat = "";

        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select admin from anvandare where Anvandarnamn = '" + anvandare + "'");
            if (rs.next()) {
                resultat = rs.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Sql.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println(resultat);
        return resultat;
    }

    public static String adminTrueFalse(String anvandare) {
        String svar = "";

        try {

            String SqlFraga = "select anvandare.Admin from anvandare where anvandare.Anvandarnamn = '" + anvandare + "'";

            PreparedStatement pst = conn.prepareStatement(SqlFraga);
            ResultSet rssvar = pst.executeQuery();

            svar = rssvar.toString();

        } catch (SQLException ex) {
            Logger.getLogger(Sql.class.getName()).log(Level.SEVERE, null, ex);
        }

        return svar;
    }
   public void taBortInlagg(String text)
    {
      
        String s = "";
        String s1 = "";
        String s2 = "";
       
        try
        {
           
            String sql1 = "Select InlaggsID from inlagg where text = '"+text+"'";
            PreparedStatement pst = conn.prepareStatement(sql1);
            ResultSet rs = pst.executeQuery(sql1);
            if(rs.next())
            {
                s = rs.getString(1);
                
            }
            String sql2 = "Select FillID from inlagg_har_fil where InlaggsID = '"+s+"'";
            rs = pst.executeQuery(sql2);
            if(rs.next())
            {
                 s1 = rs.getString(1);
               
            }
            /*String sql3 = "Select anvandare_kommentar_inlagg.KommentarID from anvandare_kommentar_inlagg where InlaggsID = '"+s+"'";
            rs = pst.executeQuery(sql3);
            if(rs.next())
            {
                s2 = rs.getString();
            }
            //String sql4 = "Delete from anvandare_kommentar_inlagg where InlaggsID = '"+s+"'";
            String sql5 = "Delete kommentar,anvandare_kommentar_inlagg from kommentar join anvandare_kommentar_inlagg on anvandare_kommentar_inlagg.KommentarID = kommentar.KommentarID where anvandare_kommentar_inlagg.KommentarID = '"+s2+"'";
            */String sql6 = "Delete from inlagg_har_fil where InlaggsId = '"+s+"'";
            String sql7 = "Delete from fil where FILID = '"+s1+"'";
            String sql8 = "Delete from inlagg where text = '"+text+"'";
           
            //pst.executeUpdate(sql4);
            //pst.executeUpdate(sql5);
            pst.executeUpdate(sql6);
            pst.executeUpdate(sql7);
            pst.executeUpdate(sql8);
    
            
            
        }
        catch (SQLException ex) {
            System.out.println(ex);
        }
    }

public String getIp(){
    
    return ip;
       
}

   public void laggTillAnvandare(String fornamn2, String efternamn2, String epost, String telefon, String titel, String losenord, String anvandarnamn){
        int nyid= 0;
        try {
        String sqlfraga = "select max(anvandareid) from anvandare";
        int maxid = 0;
        
          PreparedStatement pst1 = conn.prepareStatement(sqlfraga);
            ResultSet rssvar = pst1.executeQuery(sqlfraga);

            while (rssvar.next()) {
            maxid = rssvar.getInt(1);
            
            }
          nyid = maxid + 1;
        } catch (SQLException ex) {
            Logger.getLogger(Sql.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        try{
          
        String sql = "Insert into anvandare (anvandareid, fornamn, efternamn, telnr, epost, losenord, anvandarnamn, admin, titel, profilbild, testcolumn) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, nyid);
            pst.setString(2, fornamn2);
            pst.setString(3, efternamn2);
            pst.setString(4, telefon);
            pst.setString(5, epost);
            pst.setString(6, losenord);
            pst.setString(7, anvandarnamn);
            pst.setString(8, "false");
            pst.setString(9, titel);
            pst.setBytes(10, null);
            pst.setString(11, null);
            
            pst.executeUpdate();
        }
        catch(SQLException ex){
        System.out.print(ex);
        }
    
    }
    
    public void AdminAndraLosen(String losen, String anvandarnamn) {

        String nyalosen = losen;
        String Anvandare = anvandarnamn;
        
        try {

            String sql = "Update anvandare set losenord='" + nyalosen + "'" + "where Anvandarnamn='" + Anvandare + "'";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Lösenordet är ändrat");

        } catch (SQLException ex) {
            Logger.getLogger(Sql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
    
    

}

/* 
try {
         
            //Specifierar anslutningen till databasen, notera här att databasen är uppkopplad till servern, därav man måste ange den lokala ip-adressen för personen som hostar servern.
            Connection conn = DriverManager.getConnection("jdbc:mysql://10.22.25.76:3306/namn", "Nikola", "password1234");

            //Skapar en connection statement som ska användas för att hämta ut saker ur databasen, eller göra ändringar.
            Statement stmt = conn.createStatement();
            
            //Hämtar ut värdet/värden från databasen och lagrar det som ett "ResultSet", notera att man här skriver sin SQL Query i metoden executeQuery().
            ResultSet rs = stmt.executeQuery("select * from namn");
            
            //Loopa igenom ResultSet variabeln för att få fram alla värdena som finns i ResultSet. Notera att loopen loopar igenom rader, för att få ut kolumnerna se nedan. 
            while (rs.next()) {
                System.out.println(rs.getString(1) + "  " + rs.getString(2)); //Notera att getString(1) är ID-nummer kolumnen och getString(2) är namn kolumnen.
                sqlNamn = rs.getString(1) + "  " + rs.getString(2);
            }

            jTextArea1.setText(sqlNamn);

            
        } catch (Exception e) {
            System.out.println(e);
        }


    }
 */
