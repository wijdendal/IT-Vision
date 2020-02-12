/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Velo_a_vendre;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.ConnectionBD;

/**
 *
 * @author mh
 */
public class Service_velo_a_vendre {
    
    private Connection con = ConnectionBD.getInstance().getCnx();

    public void ajoutervelo_a_louer(Velo_a_vendre vl) {
        Statement st;
        try {
            st = con.createStatement();
            String req = "insert into  velovendre (prix,marque,Path_photo,description,nombre) Values (" + vl.getPrix() + ",'" + vl.getMarque() + "','" + vl.getPath_photo()+  "','" + vl.getDescription() +"'," + vl.getNombre() + "   )";
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(Service_velo_a_louer.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void modifiervelo_a_vendre(Velo_a_vendre Vl) {
        try {
            PreparedStatement pt = con.prepareStatement("update velovendre set prix=?,marque=?,path_photo=?,description=?,nombre=?  where id=?");
            
            
            pt.setFloat(1, Vl.getPrix());
            pt.setString(2,  Vl.getMarque());
            pt.setString(3,  Vl.getPath_photo());
            pt.setString(4, Vl.getDescription());
            pt.setInt(5, Vl.getNombre());
            pt.setInt(6, Vl.getId());
            
            
            
            
            
            
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Service_velo_a_louer.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    
    public void affichervelo_a_vendre() {
        PreparedStatement pt;
        try {

            pt = con.prepareStatement("select * from velovendre ORDER BY prix,nombre");
            ResultSet rs = pt.executeQuery();
          
            while (rs.next()) {
                System.out.println("velo a louer  [id :" + rs.getInt(1) + ",prix" + rs.getFloat(2) + ",marque" + rs.getString(3)+ ",Description" + rs.getString(5)+ ",Nombre total des bike:" + rs.getInt(6)+"]");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Service_velo_a_louer.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void supprimervelo_a_vendre(  int id) {
        PreparedStatement pt;
        PreparedStatement pt1;
        int nombre=0;
        try {
            
            pt1 = con.prepareStatement("select nombre from velovendre WHERE  id=?");
            pt1.setInt(1, id);
            ResultSet rs = pt1.executeQuery();
        while (rs.next()) {
            nombre=rs.getInt(1);
        }

            nombre--;
            pt = con.prepareStatement("update  velovendre set nombre=? where id=? ");
            
             pt.setInt(1,nombre);
            pt.setInt(2,id);
           
        
            pt.executeUpdate();
            
            
           

        } catch (SQLException ex) {
            Logger.getLogger(Service_velo_a_louer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       

    }
    
   
     
     
     
    
}
