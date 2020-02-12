/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.ShoppingCart;
import Utiles.ConnexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ACER
 */
public class ServiceShoppinCart {
    
    Connection c=ConnexionBD.getinstance().getcnx();
    
    public void ajoutershoppingcart(ShoppingCart sc) throws SQLException
    {
        try{
    PreparedStatement pt= c.prepareStatement(" insert into shoppingcart (NbrEquipMax)"
        + " values (?)");
            //pt.setInt(1,t.getId_Tache());
            pt.setInt(1,sc.getNbrEquipMax());
           
            
            pt.execute();
        }catch (SQLException ex)
            {
            Logger.getLogger(ServiceShoppinCart.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       public void affichershoppingcart()
    {
        try {
            PreparedStatement pt =c.prepareStatement("select * from shoppingcart");
            ResultSet rs= pt.executeQuery();
            
            while(rs.next())
            {
                System.out.println("shoppingcart {id_Panier:"+rs.getInt(1)+" ,NbrEquipMax:"+rs.getInt(2)+"");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceShoppinCart.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       public void modifiershoppingcart (int Id_Panier,int NbrEquipMax)
    {
        try {
            PreparedStatement pt= c.prepareStatement("update shoppingcart set NbrEquipMax=?  where Id_Panier=?");
            pt.setInt(1,NbrEquipMax);
            pt.setInt(2,Id_Panier);
            
            pt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceShoppinCart.class.getName()).log(Level.SEVERE, null, ex);
        } 
    
}
        public void supprimershoppingcart(int Id_Panier)
    {
        try {
            PreparedStatement pt =c.prepareStatement("delete from shoppingcart where Id_Panier=?" );
            pt.setInt(1,Id_Panier);
            pt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceShoppinCart.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       
    
}
