/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.charity;
import Entities.training;
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
public class servicecharity {
         Connection c=ConnexionBD.getinstance().getcnx();

    public void ajoutercharity(charity s) throws SQLException
    {
        try{
    PreparedStatement pt= c.prepareStatement(" insert into charity (id_charity,picture,description,adresse)"
        + " values (?, ?, ?, ?)");
            
            
            pt.setInt(1,s.getId_charity());
            pt.setString(2,s.getPicture());
            pt.setString(3, s.getDescription());
            pt.setString(4,s.getAdresse());
            
            pt.execute();
        }catch (SQLException ex)
            {
            Logger.getLogger(servicecharity.class.getName()).log(Level.SEVERE, null, ex);
        }
    }     
    public void affichercharity()
    {
        try {
            PreparedStatement pt =c.prepareStatement("select * from charity");
            ResultSet rs= pt.executeQuery();
            
            while(rs.next())
            {
                System.out.println("charity {id_charity:"+rs.getInt(1)+" ,picture:"+rs.getString(2)+" ,description:"+rs.getString(3)+" ,adresse:"+rs.getString(4)+"");
            }
        } catch (SQLException ex) {
            Logger.getLogger(servicecharity.class.getName()).log(Level.SEVERE, null, ex);
        }
    }     
      public void modifiercharity(int id_charity,String picture,String description,String adresse)
    {
        try {
            PreparedStatement pt= c.prepareStatement("update charity set picture= ?  ,description=?, adresse=? where id_charity=?");
            
            
            pt.setString(1,picture);
            pt.setString(2,description);
            pt.setString(3,adresse);
            pt.setInt(4,id_charity);
            
            pt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(servicecharity.class.getName()).log(Level.SEVERE, null, ex);
        }}   
         
          public void supprimercharity(int id_charity)
    {
        try {
            PreparedStatement pt =c.prepareStatement("delete from charity where id_charity=?" );
            pt.setInt(1,id_charity);
            pt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(servicecharity.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
  
         
         
}
