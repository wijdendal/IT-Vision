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
public class ShoppingCart {
     
    private int NbrEquipMax;
     private int Id_Panier;

    public ShoppingCart(int NbrEquipMax) {
        this.NbrEquipMax = NbrEquipMax;
    }

    public int getNbrEquipMax() {
        return NbrEquipMax;
    }

    public int getId_Panier() {
        return Id_Panier;
    }

    public void setNbrEquipMax(int NbrEquipMax) {
        this.NbrEquipMax = NbrEquipMax;
    }

    public void setId_Panier(int Id_Panier) {
        this.Id_Panier = Id_Panier;
    }
     
     
    
}
