/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Velo_a_louer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.ConnectionBD;
import java.util.Properties;  
import javax.mail.*;  
import javax.mail.internet.*;  

/**
 *
 * @author mh
 */
public class Service_velo_a_louer {
    private static int heure=0,minute=1,seconde=1;
   private Connection con = ConnectionBD.getInstance().getCnx();

    public void ajoutervelo_a_louer(Velo_a_louer vl) {
        Statement st;
        try {
            st = con.createStatement();
            String req = "insert into  velolouer (prix,marque,description,Path_photo,nombre) Values (" + vl.getPrix() + ",'" + vl.getMarque() + "','" + vl.getDescription() +"','" + vl.getPath_photo() +"'," + vl.getNombre() + "   )";
            st.executeUpdate(req);
            System.out.println("ajout avec succes ");
        } catch (SQLException ex) {
            Logger.getLogger(Service_velo_a_louer.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void affichervelo_a_louer() {
        PreparedStatement pt;
        try {

            pt = con.prepareStatement("select * from velolouer ORDER BY prix,nombre");
            ResultSet rs = pt.executeQuery();
          
            while (rs.next()) {
                System.out.println("velo a louer  [id :" + rs.getInt(1) + ",prix" + rs.getFloat(2) + ",marque" + rs.getString(3)+ ",Description" + rs.getString(4)+ ",Nombre total des bike:" + rs.getInt(6)+"]");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Service_velo_a_louer.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void modifiervelo_a_louer(Velo_a_louer Vl) {
        try {
            PreparedStatement pt = con.prepareStatement("update velolouer set prix=?,marque=?,description=?,Path_photo=?,nombre=?  where id=?");
            
            
            pt.setFloat(1, Vl.getPrix());
            
          
            pt.setString(2, Vl.getMarque());
            pt.setString(3, Vl.getDescription());
            pt.setString(4, Vl.getPath_photo());
            pt.setInt(5, Vl.getNombre());
            pt.setInt(6, Vl.getId());
            
            
            
            
            
            
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Service_velo_a_louer.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void supprimervelo_a_louer(  int id) {
        PreparedStatement pt;
        PreparedStatement pt1;
        int nombre=0;
        try {
            
            pt1 = con.prepareStatement("select nombre from velolouer WHERE  id=?");
            pt1.setInt(1, id);
            ResultSet rs = pt1.executeQuery();
        while (rs.next()) {
            nombre=rs.getInt(1);
        }
if(nombre!=0)
{
            nombre--;
            pt = con.prepareStatement("update  velolouer set nombre=? where id=? ");
            
             pt.setInt(1,nombre);
            pt.setInt(2,id);
           
        
            pt.executeUpdate();
            
}  
           

        } catch (SQLException ex) {
            Logger.getLogger(Service_velo_a_louer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       

    }
    
    public void rechercheparmarque()
    { 
        PreparedStatement pt;
        try {

            pt = con.prepareStatement("select prix,nombre,marque,description from velolouer ORDER BY marque DESC");
            ResultSet rs = pt.executeQuery();
            ResultSetMetaData resultMeta = rs.getMetaData();
          String nom = "";
      String nomClass = "";
   
   
         
            while (rs.next()) {
                int i=rs.getInt("nombre");
                
                
              if(!nomClass.equals(rs.getString("marque"))){
          nomClass = rs.getString("marque");
          System.out.println("marque : " + nomClass + " :"); 
          
         
        

        
          
          System.out.println("\t prix: " + rs.getInt("prix") );
        }
        System.out.println("\t" +  " nombre des pieces :"+ rs.getInt("nombre"));
            
          
            }
        } catch (SQLException ex) {
            Logger.getLogger(Service_velo_a_louer.class.getName()).log(Level.SEVERE, null, ex);
        }
   
    
    }

    
     public void VerifierProduits()
             
     {
         PreparedStatement pt;
        try {

            pt = con.prepareStatement("select nombre,id from velolouer");
            ResultSet rs = pt.executeQuery();
          
            while (rs.next()) {
                if(rs.getInt(1)==0)
                {
                    System.out.println("le produit de id : "+rs.getInt(2)+" est en repture de stocke");
                    
                    String host="mahdibensaid100@gmail.com";  
  final String user="mahdibensaid100@gmail.com";//change accordingly  
  final String password="zakataka";//change accordingly  
    
  String to="mahdibensaid100@gmail.com";//change accordingly  
  
   //Get the session object  
   Properties props = new Properties();  
 props.put("mail.smtp.ssl.trust", "*");

   props.put("mail.smtp.auth", "true");  
   props.put("mail.smtp.port", "587"); 
   props.put("mail.smtp.host", "smtp.gmail.com");
   props.put("mail.smtp.starttls.enable", "true");
     
   Session session = Session.getDefaultInstance(props,  
    new javax.mail.Authenticator() {  
      protected PasswordAuthentication getPasswordAuthentication() {  
    return new PasswordAuthentication(user,password);  
      }  
    });  
  
   //Compose the message  
    try {  
     MimeMessage message = new MimeMessage(session);  
     message.setFrom(new InternetAddress(user));  
     message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
     message.setSubject("Alert de repture de produit");  
     message.setText("le produit de id : "+rs.getInt(2)+" est en repture de stocke");  
       
    //send the message  
     Transport.send(message);  
  
     System.out.println("message sent successfully...");  
   
     } catch (MessagingException e) {e.printStackTrace();}  
                
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Service_velo_a_louer.class.getName()).log(Level.SEVERE, null, ex);
        }

     
     }
     
    
     
     
     public int   rechercheid( int nombre)
             
     {
     int id=0;
     PreparedStatement pt;
        try {
            pt = con.prepareStatement("select * from  velolouer where nombre=? ");
            pt.setInt(1,nombre);
            
            ResultSet rs = pt.executeQuery();
          
            while (rs.next()) {
                id=rs.getInt(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Service_velo_a_louer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return id;
     }
     
     
      public void   maxproduit( )
              
      {
       PreparedStatement pt;
        try {

            pt = con.prepareStatement("select MAX(nombre) from velolouer  ");
            ResultSet rs = pt.executeQuery();
          
            while (rs.next()) {
                System.out.println( "l'id :"+rechercheid( rs.getInt(1))+" a plus de produits avec : "+rs.getInt(1));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Service_velo_a_louer.class.getName()).log(Level.SEVERE, null, ex);
        }
      
      
      }
     
     
    
}
