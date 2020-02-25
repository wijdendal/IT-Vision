/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Event;
import Utils.ConnexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.*;
import javax.mail.internet.*;


/**
 *
 * @author user
 */
public class ServiceEvent 
{
    Connection c=ConnexionBD.getinstance().getcnx();
   public List<Event> Type(String type) throws SQLException {
    List<Event> arr=new ArrayList<>();
    Statement ste=c.createStatement();
    ResultSet rs=ste.executeQuery("select * from Event where Type ='"+type+"' ");
    
     while (rs.next()) { 
         int id = rs.getInt(1);
               String title =rs.getString(2);
               String date = rs.getString(3);
               String IMG=rs.getString(7);
               String h1 = rs.getString(3);
                 String h2 = rs.getString(4);
               String desc = rs.getString("Description");
               int cap = rs.getInt("Capacite");
               String typee  = rs.getString("Type");
               String lieu  = rs.getString("lieu");
System.out.println(typee);
               Event p=new Event( id,  title, date, h1, h2, desc, typee, "", IMG, 0, lieu, cap);
     arr.add(p);
     }
    return arr;
    }
    public List<Event> readAll() throws SQLException {
    List<Event> arr=new ArrayList<>();
    Statement ste=c.createStatement();
    ResultSet rs=ste.executeQuery("select * from Event  ");
     while (rs.next()) { 
         int id = rs.getInt(1);
               String title =rs.getString(2);
               String date = rs.getString(3);
               String IMG=rs.getString(7);
               String h1 = rs.getString(3);
                 String h2 = rs.getString(4);
               String desc = rs.getString("Description");
               int cap = rs.getInt("Capacite");
String type  = rs.getString("Type");
               String lieu  = rs.getString("lieu");

               Event p=new Event( id,  title, date, h1, h2, desc, type, "", IMG, 0, lieu, cap);
     arr.add(p);
     }
    return arr;
    }
    public String reporter (int id )
    {            String date = "" ;

       try {
            
            PreparedStatement pt =c.prepareStatement("select date from event WHERE id = ?");
            pt.setInt(1, id);
            ResultSet rs= pt.executeQuery();
            while(rs.next())
            {
                date = rs.getString("date");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceEvent.class.getName()).log(Level.SEVERE, null, ex);
        } 
       return(date);
    }
    
        public void cat (String cat)
        {
            
        }
   
    public List<Event> RA(String A) throws SQLException {
    List<Event> arr=new ArrayList<>();
    Statement ste=c.createStatement();
    ResultSet rs=ste.executeQuery("select * from Event where title like '"+A+"%' or description like '"+A+"%' or date like '"+A+"%' ");
     while (rs.next()) { 
         int id = rs.getInt(1);
               String title =rs.getString(2);
               String date = rs.getString(3);
               String IMG=rs.getString(7);
               String h1 = rs.getString(3);
                 String h2 = rs.getString(4);
               String desc = rs.getString("Description");
               int cap = rs.getInt("Capacite");
String type  = rs.getString("Type");
               String lieu  = rs.getString("lieu");

               Event p=new Event( id,  title, date, h1, h2, desc, type, "", IMG, 0, lieu, cap);
     arr.add(p);
     }
    return arr;
    }
   public int id ()
   {
                 int user_id =0 ;

        try {
            PreparedStatement pst1;
            pst1 = c.prepareStatement("select max(id)+1 from event");
            ResultSet rs = pst1.executeQuery();
            while(rs.next())
            {
                user_id = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceEvent.class.getName()).log(Level.SEVERE, null, ex);
        }           
        return(user_id);

   }
    public void ajouterEvent(Event p)
    {
       try 
       {
            PreparedStatement pst1;
            pst1 = c.prepareStatement("select max(id)+1 from event");
            ResultSet rs = pst1.executeQuery();
            int user_id =0 ;
            while(rs.next())
            {
                user_id = rs.getInt(1);
            }

            Statement st=c.createStatement();                          

          
            String req ;
            req = "insert into Event values("+user_id+",'"+p.getTitle()+"','"+p.getDate()+"','"+p.getHeur_deb()+"','"+p.getHeure_fin()+"','"+p.getDescription()+"',\""+p.getPic()+"\",'"+p.getEtat()+"','"+p.getLieu()+"','"+p.getCategorie()+"','"+p.getType()+"','" +p.getCapacite() + "')";
            System.out.println(req);
           String P  =p.getTitle();
                      String P2  =p.getType();
                      String P3 = p.getCategorie();
                      String P4 = p.getDate();
                      String P5 = p.getHeur_deb();
                      String P6 = p.getHeure_fin();
                               
                      

               st.executeUpdate(req) ;
                
       
       }
       catch (SQLException ex)
        {
            Logger.getLogger(ServiceEvent.class.getName()).log(Level.SEVERE, null, ex);
        }
       } 
  
        public int GetterId () 
             {
        
                        int k=0;

        try {
            
            PreparedStatement pt =c.prepareStatement("select count(*) from event ");
            ResultSet rs= pt.executeQuery();
            
            while(rs.next())
            {
                k = rs.getInt(1);
            }
            return (k);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceEvent.class.getName()).log(Level.SEVERE, null, ex);
        }            return k;

        
             }
        

public int seuil (int id)
{
    int Cap = 0 ;
    try {
            
            PreparedStatement pt =c.prepareStatement("select Capacite from event WHERE id = ?");
            pt.setInt(1, id);
            ResultSet rs= pt.executeQuery();
            
            while(rs.next())
            {
                Cap = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceEvent.class.getName()).log(Level.SEVERE, null, ex);
        }
    return (Cap);
}
 
    public void modifierEvent (int id,Event p2)
    {
        try {
            PreparedStatement pt= c.prepareStatement("update event set    title=? , date = ?,	Description=?,	pic=?,	lieu=? where id = ?	");
            pt.setString(1,p2.getTitle());
                       pt.setString(2,p2.getDate());

            pt.setString(3,p2.getDescription());
                        pt.setString(4,p2.getPic());

            pt.setString(5,p2.getLieu());
                    pt.setInt(6,id);
                        
            pt.execute();

        } catch (SQLException ex) {
            Logger.getLogger(ServiceEvent.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void afficherEvent(String Type)
    {
        try {
            
            PreparedStatement pt =c.prepareStatement("select * from event WHERE Type = ?");
            pt.setString(1, Type);
            ResultSet rs= pt.executeQuery();
            
            while(rs.next())
            {
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceEvent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void supprimerEvent(int id  ){           

        try {    
            PreparedStatement pt=c.prepareStatement("delete from event where id=?" );

            pt.setInt(1,id);
            pt.executeUpdate();
            System.out.println("c bon");

        } catch (SQLException ex) {
            Logger.getLogger(ServiceEvent.class.getName()).log(Level.SEVERE, null, ex);
        }       

    }
}
