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
public class Bill {
    private int Id_Bill;
    private float Ammount;
    private int Ide_Bike;
    private int Ide_Equipement;
    private int Id_Client;
    
     public Bill (float Ammount,int Ide_Bike, int Ide_Equipement, int Id_Client){
    
         this.Ammount=Ammount;
         this.Ide_Equipement=Ide_Equipement;
        this.Ide_Bike=Ide_Bike;
        this.Id_Client=Id_Client;
       
        
    }
      public int getId_Bill() {
        return Id_Bill;
    }

    public void setId_Bill(int Id_Bill) {
        this.Id_Bill = Id_Bill;
    }

    public int getIde_Bike() {
        return Ide_Bike;
    }

    public void setIde_Bike(int Ide_Bike) {
        this.Ide_Bike=Ide_Bike;
    }
     public int getIde_Equipement() {
        return Ide_Equipement;
    }
      public void setIde_Equipement(int Ide_Equipement) {
        this.Ide_Equipement=Ide_Equipement;
    }
       public int getId_Client() {
        return Id_Client;
    }
      public void setId_Client(int Id_Client) {
        this.Id_Client=Id_Client;
    }

    public float getAmmount() {
        return Ammount;
    }

    public void setAmmount(float Ammount) {
        this.Ammount = Ammount;
    }
    @Override
     public String toString() {
        return "Bill{" + "Id_Bill=" + Id_Bill + ", Ammount"+Ammount+", Id_Client=" +Id_Client+", Ide_Equipement=" + Ide_Equipement + ", Ide_Bike=" + Ide_Bike + '}';
    }
    
     
}
