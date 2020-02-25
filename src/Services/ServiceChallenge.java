/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Challenge;
import Entities.Event;
import Utils.ConnexionBD;
import View.NotificationsPush;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class ServiceChallenge 
{
    Connection c=ConnexionBD.getinstance().getcnx();
    public List<Challenge> readAll() throws SQLException {
    List<Challenge> arr=new ArrayList<>();
    Statement ste=c.createStatement();
    ResultSet rs=ste.executeQuery("select * from Challenge  ");
     while (rs.next()) { 
         int id = rs.getInt(1);
               String title = rs.getString(2);
               String desc=rs.getString(3);
               String img = rs.getString(4);
                int Max = rs.getInt(5);


               Challenge ch = new Challenge(id,title, desc, img, Max);
     arr.add(ch);
     }
    return arr;
    }
    public void ajouterChallenge(Challenge p)
    {
       
        try 
        {
            PreparedStatement pst1 = c.prepareStatement("select max(id_ch)+1 from Challenge");
            ResultSet rs = pst1.executeQuery();
            int user_id =0 ;
            while(rs.next())
            {
                user_id = rs.getInt(1);
            }

            Statement st=c.createStatement();

          
            String req ;
            req = "insert into challenge values("+user_id+",'"+p.getTitle()+"','"+p.getDescription()+"','"+p.getPic()+"',"+p.getNmbr_pub()+")";
            System.out.println(req);
            NotificationsPush NP = new NotificationsPush();
            NP.notifpush("dd", "vgbhnj");
            st.executeUpdate(req);
        } catch (SQLException ex)
        {
            Logger.getLogger(ServiceChallenge.class.getName()).log(Level.SEVERE, null, ex);
        }
  
    }
        public List<Challenge> RA(String A) throws SQLException {
    List<Challenge> arr=new ArrayList<>();
    Statement ste=c.createStatement();
    ResultSet rs=ste.executeQuery("select * from Challenge where title_ch like '"+A+"%' or desc_ch like '"+A+"%'");
     while (rs.next()) { 
         int id = rs.getInt(1);
               String title =rs.getString(2);
               String desc = rs.getString(3);
               String IMG=rs.getString(4);
               int cap = rs.getInt(5);

Challenge ch = new Challenge (id,title,desc,IMG,cap);
     arr.add(ch);
     }
    return arr;
    }
    public void modifierch (int id , Challenge p2)
    {
        try {
           PreparedStatement pt= c.prepareStatement("update Challenge set    title_ch=? , desc_ch = ?,	pic_ch=?,	nbr_max_pub=? where id_ch= ?	");
            pt.setString(1,p2.getTitle());
                       pt.setString(2,p2.getDescription());

                        pt.setString(3,p2.getPic());

            pt.setInt(4,p2.getNmbr_pub());
                    pt.setInt(5,id);
                        NotificationsPush NP = new NotificationsPush();
            NP.notifpush("Update", "Weekly challenge " +p2.getTitle() );
            pt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceChallenge.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public Challenge id2( )
    {Challenge ch = null ;
        try {
            int id = id();
            PreparedStatement pt =c.prepareStatement("select * from  Challenge where id_ch= ?");
            pt.setInt(1,id);
            ResultSet rs= pt.executeQuery();
            
           
             while (rs.next()) { 
         int idd = rs.getInt(1);
               String title =rs.getString(2);
               String desc = rs.getString(3);
               String IMG=rs.getString(4);
               int cap = rs.getInt(5);

ch= new Challenge (idd,title,desc,IMG,cap);}

        } catch (SQLException ex) {
            Logger.getLogger(Servicepost_ch.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ch ;
    }
    public void supprimerEvent(int id )
    {
        try {
            PreparedStatement pt =c.prepareStatement("delete from Challenge where id_ch=?" );
            pt.setInt(1,id);
            pt.execute();
            System.out.println("c bon");

        } catch (SQLException ex) {
            Logger.getLogger(Servicepost_ch.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void afficherChallenge()
    {
        try {
            
            PreparedStatement pt =c.prepareStatement("select max(id_ch),title_ch,desc_ch,pic_ch,nbr_max_pub from challenge  ");
            ResultSet rs= pt.executeQuery();
            
            while(rs.next())
            {
                System.out.println("Personne {id:"+rs.getInt(1)+" ,Nom:"+rs.getString(2)+" ,Prenom:"+rs.getString(3)+"");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceChallenge.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public int id ()
   {
                 int user_id =0 ;

        try {
            PreparedStatement pst1;
            pst1 = c.prepareStatement("select max(id_ch) from Challenge");
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
    
}
