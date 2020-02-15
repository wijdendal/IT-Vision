/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.charity;
import Entities.recycle;
import Utils.ConnexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Asus
 */
public class servicerecycle {
             Connection c=ConnexionBD.getinstance().getcnx();

       public void ajouterrecycle(recycle r) throws SQLException
    {
        try{
    PreparedStatement pt= c.prepareStatement(" insert into recycle (id_recycle, description, picture)"
        + " values (?, ?, ?)");
            
            
            pt.setInt(1,r.getId_recycle());
            pt.setString(2, r.getDescription());
           pt.setString(3,r.getPicture());
            
            pt.execute();
        }catch (SQLException ex)
            {
            Logger.getLogger(servicerecycle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }            
             
      public void afficherrecycle()
    {
        try {
            PreparedStatement pt =c.prepareStatement("select * from recycle");
            ResultSet rs= pt.executeQuery();
            
            while(rs.next())
            {
                System.out.println("recycle {id_recycle:"+rs.getInt(1)+" ,description:"+rs.getString(2)+" ,picture:"+rs.getString(3)+"");
            }
        } catch (SQLException ex) {
            Logger.getLogger(servicerecycle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }     
        
       public void modifierrecycle(int id_recycle, String description, String picture)
    {
        try {
            PreparedStatement pt= c.prepareStatement("update recycle set description=?, picture= ?  where id_recycle=?");
            
            
           
            pt.setString(1,description);
             pt.setString(2,picture);
            pt.setInt(3,id_recycle);
            
            pt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(servicerecycle.class.getName()).log(Level.SEVERE, null, ex);
        }}   
                
         public void supprimerrecycle(int id_recycle)
    {
        try {
            PreparedStatement pt =c.prepareStatement("delete from recycle where id_recycle=?" );
            pt.setInt(1,id_recycle);
            pt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(servicerecycle.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
  
              
             
             
             
             
}
