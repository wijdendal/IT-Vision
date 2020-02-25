/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Event;
import Entities.Participant_com;
import Utils.ConnexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class ServiceParticipants_com 
{
    Connection c=ConnexionBD.getinstance().getcnx();
    
    /**
     *
     * @param id
     * @return
     */
    
    public int retouretat(int id_ev , int id_cl)
    {
        int i = 0 ;
        try {
            Connection c=ConnexionBD.getinstance().getcnx();
            PreparedStatement pt1 =c.prepareStatement("SELECT etat from participant where (id_client ="+id_cl+") and (id_event = "+id_ev+") ");
            ResultSet r= pt1.executeQuery();
            int idd  ;
            while (r.next())
                
            {
                i=r.getInt(1);
            }   } catch (SQLException ex) {
            Logger.getLogger(ServiceParticipants_com.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i; 
    }
    public void modifieretat(int idE, int idP)
    {
        try{
            PreparedStatement pt= c.prepareStatement("update participant set etat= 1 where (id_event="+idE+") and (id_client = "+idP+")");
           
            
            pt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceParticipants_com.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public List<Integer> etat(int id)
    {
        List<Integer>  arr = null;
   try {
        Connection c=ConnexionBD.getinstance().getcnx();
               arr =  new ArrayList<>();
        PreparedStatement pt1 =c.prepareStatement("SELECT id_event from participant where (id_client ="+id+") and (etat = 0) ");
        ResultSet r= pt1.executeQuery();
        int idd  ;
        while (r.next())
            
        {
           idd =  r.getInt(1);
           
            arr.add(idd);
            
        }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceParticipants_com.class.getName()).log(Level.SEVERE, null, ex);
        }   
   System.out.println(arr + "si bon");
    return arr;
    }
    public List<Integer> etat2(int id)
    {
        List<Integer>  arr = null;
   try {
        Connection c=ConnexionBD.getinstance().getcnx();
               arr =  new ArrayList<>();
        PreparedStatement pt1 =c.prepareStatement("SELECT id_event from participant where (id_client ="+id+") and (etat = 1) ");
        ResultSet r= pt1.executeQuery();
        int idd 
                ;
        while (r.next())
            
        {
           idd =  r.getInt(1);
           
            arr.add(idd);
            
        }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceParticipants_com.class.getName()).log(Level.SEVERE, null, ex);
        }        
    return arr;
    }
    public boolean ajouterParticipant_com(int id_ev , int id_cl)
    {
       
        try 
        {
             PreparedStatement pst1 = c.prepareStatement("select max(id)+1 from participant");
            ResultSet rs3 = pst1.executeQuery();
            int user_id =0 ;
            while(rs3.next())
            {
                user_id = rs3.getInt(1);
            }
PreparedStatement pt5 =c.prepareStatement("select capacite from event where id = "+id_ev+"");
            ResultSet rs7= pt5.executeQuery();
            int b = 0 ;
            while (rs7.next())
            {
                 b = rs7.getInt(1);
            
            
            }
            PreparedStatement pt2 =c.prepareStatement("select count(*)  from participant where id_event = "+id_ev+"");
            ResultSet rs8= pt2.executeQuery();
            int c2 = 0 ;
            while (rs8.next())
            {
                c2 = rs8.getInt(1);
            }
            System.out.println(c2 );

            if ((c2)<b)
            { 
            
            PreparedStatement pt3 =c.prepareStatement("SELECT firstname, lastname FROM   Client   where id = ?");
                pt3.setInt(1,id_cl);                  
                ResultSet rs= pt3.executeQuery();
                String nom="";
                String prenom="" ;
  while(rs.next()){nom = rs.getString(1); prenom = rs.getString(2);}
             PreparedStatement pt4 =c.prepareStatement("SELECT title, Type FROM   event   where id = ? ");
                          pt4.setInt(1,id_ev); 
                          ResultSet rs2= pt4.executeQuery();
                                          String title="";
                                          String type="" ;

                            while(rs2.next()){title = rs2.getString(1); type = rs2.getString(2);}

            Statement st=c.createStatement();
            
            String req="insert into Participant values("+user_id+","+id_ev+ ","+id_cl+","+0+",'"+nom+"','"+prenom+"','"+title+"','"+type+"')";
            st.executeUpdate(req);
            System.out.println(req);
            System.out.println(req); 
          return(true);  
        }
        else
            {
                System.out.println("taabaaa");
            }
        
            } 
        catch (SQLException ex)
        {
            Logger.getLogger(ServiceParticipants_com.class.getName()).log(Level.SEVERE, null, ex);
        }
                  return(false);

    }
     
    /*public void modifierParticipant (Participant_com p,String nom)
    {
        try {
        
        
    }*/
    public List<Participant_com> afficherParticipant()
    {        List<Participant_com>  arr=null ; 
   try {
        Connection c=ConnexionBD.getinstance().getcnx();
               arr =  new ArrayList<>();
        PreparedStatement pt1 =c.prepareStatement("SELECT * from participant ");
        ResultSet r= pt1.executeQuery();
        while (r.next())
            
        {
            System.out.println( r.getInt(1) + r.getInt(2) + r.getString(3) + r.getInt(4) + r.getString(5)+ r.getString(6) +r.getString(7));
            Participant_com pc = new Participant_com(r.getInt(3), r.getInt(2),r.getString(5),r.getString(6),r.getString(7),r.getInt(4),r.getString(8));
            arr.add(pc);
            
        }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceParticipants_com.class.getName()).log(Level.SEVERE, null, ex);
        }        
    return arr;


            }
       
    
        public void supprimerpersonne(int id_ev , int id_cl)
    {
        try {
            PreparedStatement pt =c.prepareStatement("delete from participant where id_event=" +id_ev+" and id_Client = " +id_cl+ "");
            pt.execute();
            System.out.println("ci d");
        } catch (SQLException ex) {
            Logger.getLogger(ServiceParticipants_com.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

