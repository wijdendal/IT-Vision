/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Bill;
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
public class ServiceBill {
     Connection c=ConnexionBD.getinstance().getcnx();
      
     public void ajouterBill(Bill b) throws SQLException
    {
        try{
    PreparedStatement pt= c.prepareStatement(" insert into bill (Ammount, Ide_Bike, Ide_Equipement, Id_Client)"
        + " values (?, ?, ?,?)");
           
            pt.setFloat(1,b.getAmmount());
            pt.setInt(2,b.getIde_Bike());
            pt.setInt(3,b.getIde_Equipement());
            pt.setInt(4,b.getId_Client());
          
            
            pt.execute();
        }catch (SQLException ex)
            {
            Logger.getLogger(ServiceBill.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
      public void afficherBill()
    {
        try {
            PreparedStatement pt =c.prepareStatement("select * from bill");
            ResultSet rs= pt.executeQuery();
            
            while(rs.next())
            {
                System.out.println("bill {Id_Bill:"+rs.getInt(1)+" ,Ammount:"+rs.getFloat(2)+" ,Ide_Bike:"+rs.getInt(3)+" ,Ide_Equipement:"+rs.getInt(4)+" ,Id_Client:"+rs.getInt(5)+"");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceBill.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
       public void modifierBill (float Ammount,int Ide_Bike,int Ide_Equipement,int Id_Client,int Id_Bill)
    {
        try {
            PreparedStatement pt= c.prepareStatement("update bill set Ide_Equipement=? , Ide_Bike= ? ,Id_Client= ?, Ammount= ?   where Id_Bill=?");
            pt.setInt(1,Ide_Equipement);
            pt.setInt(2,Ide_Bike);
            pt.setInt(3,Id_Client);
            pt.setFloat(4,Ammount);
            pt.setInt(5,Id_Bill);
       
            pt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceBill.class.getName()).log(Level.SEVERE, null, ex);
        }
}
       
       public void supprimerBill(int Id_Bill)
    {
        try {
            PreparedStatement pt =c.prepareStatement("delete from bill where Id_Bill=?" );
            pt.setInt(1,Id_Bill);
            pt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceBill.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
