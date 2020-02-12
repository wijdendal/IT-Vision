/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author ACER
 */
public class Order {
    private int Id_Order;
    private int nbr_Order;
    private int Id_Client;
    private int Ide_Bike;
    private int Ide_Equipement;
    private int Ide_Panier;
    private String Date;

    
       
    
    
    
    public Order ( int nbr_Order,int Ide_Equipement, int Ide_Bike, int Ide_Panier,int Id_Client,String Date){
      
       this.nbr_Order=nbr_Order;
       this.Ide_Equipement=Ide_Equipement;
       this.Ide_Bike=Ide_Bike;
       this.Ide_Panier=Ide_Panier;
       this.Id_Client=Id_Client;
       this.Date=Date;
   }
    
    public int getId_Order() {
        return Id_Order;
    }

    public void setId_Order(int Id_Order) {
        this.Id_Order = Id_Order;
    }

    public int getnbr_Order() {
        return nbr_Order;
    }

    public void setnbr_Order(int nbr_Order) {
        this.nbr_Order = nbr_Order;
    }

    public int getIde_Equipement() {
        return Ide_Equipement;
    }

    public void setIde_Equipement(int Ide_Equipement) {
        this.Ide_Equipement = Ide_Equipement;
    }
     public int getIde_Bike() {
        return Ide_Bike;
    }

    public void setIde_Bike(int Ide_Bike) {
        this.Ide_Bike = Ide_Bike;
    }
    public int getIde_Panier() {
        return Ide_Panier;
    }

    public void setIde_Panier(int Ide_Panier) {
        this.Ide_Panier = Ide_Panier;
    }
    public int getId_Client() {
        return Id_Client;
    }

    public void setId_Client(int Id_Client) {
        this.Id_Client = Id_Client;
    }
     public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }
     
    @Override
    public String toString() {
        return "Order{" + "Id_Order=" + Id_Order + ", nbr_Order=" + nbr_Order + ", Ide_Equipement=" + Ide_Equipement +", Ide_Bike=" + Ide_Bike +", Ide_Panier"+Ide_Panier+", Id_Client"+Id_Client+", Date"+Date+ '}';
    }
    
}
