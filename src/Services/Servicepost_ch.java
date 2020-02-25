/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Challenge;
import Services.*;
import Entities.Event;
import Entities.Event;
import Entities.post_challenge;
import Utils.ConnexionBD;
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
public class Servicepost_ch 
{
    
    Connection c=ConnexionBD.getinstance().getcnx();
     public List<post_challenge> readAll() throws SQLException {
    List<post_challenge> arr=new ArrayList<>();
    Statement ste=c.createStatement();
    ResultSet rs=ste.executeQuery("select * from post_challenge  ");
     while (rs.next()) { 
         int id = rs.getInt(1);
                  int id_cl = rs.getInt(3);

               int id_ch = rs.getInt(2);
               String Desc=rs.getString(4);
                String img = rs.getString(5);
                int nmb = rs.getInt(8);
                String nom = rs.getString(9);


               post_challenge ch = new post_challenge(id,id_ch, id_cl,nom, Desc, img, "", nmb);
     arr.add(ch);
     }
    return arr;
    }
    public boolean ajouter_pc(post_challenge pc)
    {
        try 
        {   

           
           PreparedStatement pst1 = c.prepareStatement("select max(id_pc)+1 from post_challenge");
            ResultSet rs = pst1.executeQuery();
            int user_id =0 ;
            while(rs.next())
            {
                user_id = rs.getInt(1);
            }
PreparedStatement pt5 =c.prepareStatement("select nbr_max_pub from challenge where id_ch = "+pc.getId_ch()+"");
            ResultSet rs7= pt5.executeQuery();
            int b = 0 ;
            while (rs7.next())
            {
                 b = rs7.getInt(1);
            
            
            }
            PreparedStatement pt2 =c.prepareStatement("select count(*)  from post_challenge where id_ch = "+pc.getId_ch()+"");
            ResultSet rs8= pt2.executeQuery();
            int c2 = 0 ;
            while (rs8.next())
            {
                c2 = rs8.getInt(1);
            }
            System.out.println(c2 );

            if ((c2)<b)
            { 
                PreparedStatement pt =c.prepareStatement("select picture,firstname, lastname from client where id = "+pc.getId_client()+"");
            
            ResultSet rs1= pt.executeQuery();
            String firstname = "";
            String lastname = "";
            String pic = "";
            while (rs1.next())
            {           
                        pic = rs1.getString(1);
                        firstname = rs1.getString(2) ;
                         lastname = rs1.getString(3) ;

            }

                        Statement st=c.createStatement();

            String req ;
            req = "insert into post_challenge values("+user_id+","+pc.getId_ch()+","+pc.getId_client()+",'"+pc.getDesc_post_ch()+"','"+pc.getImage()+"','"+pc.getMap_circuit()+"','"+pic+"',0,'"+lastname+" "+firstname+"')";
            System.out.println(req);
            st.executeUpdate(req);            
           return(true);
            }
        
            else
            {
                System.out.println("t3abetttt");
            } }catch (SQLException ex)
        {
            Logger.getLogger(Servicepost_ch.class.getName()).log(Level.SEVERE, null, ex);
       
        }
    return false ; }
  
    
        
    public void modifierpostch (int id , int id_ch , int rea)
    {
        try {
            PreparedStatement pt= c.prepareStatement("update post_challenge set    nmb_reaction = ?	 where (id_pc = ? ) and (id_ch = ? ) 	");
            pt.setInt(1,nmr_rea(id)+1 );
            pt.setInt(2, id);
                        pt.setInt(3,id_ch);

           
                 
                        
            pt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Servicepost_ch.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public int nmr_rea(int id)
    { int i = 0 ;
        try {
            
            PreparedStatement pt =c.prepareStatement("select nmb_reaction from post_challenge where id_pc = ? ");
            pt.setInt(1,id);
            ResultSet rs= pt.executeQuery();
            
            while(rs.next())
            {
                i=rs.getInt(1);
            }
            System.out.println(i);
        } catch (SQLException ex) {
            Logger.getLogger(Servicepost_ch.class.getName()).log(Level.SEVERE, null, ex);
        }
        return(i);
    }
    
}
