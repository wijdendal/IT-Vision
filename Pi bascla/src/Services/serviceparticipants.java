/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.participants;
import Entities.training;
import Utils.ConnexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.*;  
import javax.mail.internet.*;

/**
 *
 * @author Asus
 */
public class serviceparticipants {
  
         Connection c=ConnexionBD.getinstance().getcnx();

   public void ajouterparticipants(participants p) throws SQLException
    {
        try{
    PreparedStatement pt= c.prepareStatement(" insert into participants (name_part,ide_client,nbr_part)"
        + " values (?, ?, ?)");
            
            pt.setString(1,p.getName_part());
            pt.setInt(2,p.getIde_client());
            pt.setInt(3, p.getNbr_part());
            
         
            
            pt.execute();
        }catch (SQLException ex)
            {
            Logger.getLogger(serviceparticipants.class.getName()).log(Level.SEVERE, null, ex);
        }
    }      
         
 public void afficherparticipants()
    {
        try {
            PreparedStatement pt =c.prepareStatement("select * from participants");
            ResultSet rs= pt.executeQuery();
            
            while(rs.next())
            {
                System.out.println("participants {idpart:"+rs.getInt(1)+" ,name_part"+rs.getString(2)+" ,:"+" ,ide_client:"+rs.getInt(3)+" ,nbr_part:"+rs.getInt(4)+"");
            }
        } catch (SQLException ex) {
            Logger.getLogger(serviceparticipants.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
          
  public void modifierparticipants(int idpart,String name_part,int ide_client,int nbr_part)
    {
        try {
            PreparedStatement pt= c.prepareStatement("update participants set name_part= ? , ide_client=? ,nbr_part=?  where idpart=?");
            
            pt.setString(1,name_part);
            pt.setInt(2, ide_client);
            pt.setInt(3,nbr_part );
            pt.setInt(4,idpart);
            
            pt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(servicetraining.class.getName()).log(Level.SEVERE, null, ex);
        }
    
}              
         
      
        public void supprimerparticipants(int idpart)
    {
        try {
            PreparedStatement pt =c.prepareStatement("delete from participants where idpart=?" );
            pt.setInt(1,idpart);
            pt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(serviceparticipants.class.getName()).log(Level.SEVERE, null, ex);
        }
    }       

  public int   rechercheid( int nombre)
             
     {
     int id=0;
     PreparedStatement pt;
        try {
            pt = c.prepareStatement("select * from  participants where nbr_part=? ");
            pt.setInt(1,nombre);
            
            ResultSet rs = pt.executeQuery();
          
            while (rs.next()) {
                id=rs.getInt(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(serviceparticipants.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return id;
     }
     
   public void maxpart( )
              
      {
       PreparedStatement pt;
        try {

            pt = c.prepareStatement("select MAX(nbr_part) from participants  ");
            ResultSet rs = pt.executeQuery();
          
            while (rs.next()) {
                System.out.println( "l'id :"+rechercheid( rs.getInt(1))+" a plus de prticipants avec : "+rs.getInt(1));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(serviceparticipants.class.getName()).log(Level.SEVERE, null, ex);
        }
      
      
      }
           
    public void search() {
    
    Connection c=ConnexionBD.getinstance().getcnx();
    {
        PreparedStatement pt;
        try {

            pt = c.prepareStatement("select idpart,name_part,nbr_part from participants ");
            ResultSet rs = pt.executeQuery();
            ResultSetMetaData resultMeta = rs.getMetaData();
          String nom = "";
      String xxx = "";
   
   
         
            while (rs.next()) {
                int i=rs.getInt("idpart");
                
                
              if(!xxx.equals(rs.getInt("idpart"))){
          xxx = rs.getString("name_part");
          System.out.println("idpart : " + xxx + " :"); 
          
          
          System.out.println("\t idpart: " + rs.getInt("idpart") );
        }
        System.out.println("\t" +  " nbr_part :"+  rs.getInt("nbr_part"));
            
            
            
            }
        } catch (SQLException ex) {
            Logger.getLogger(serviceparticipants.class.getName()).log(Level.SEVERE, null, ex);
        }
   
    
    }
}     
         
}

   