/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author Asus
 */
public class participants {
   private int idpart;
    private String name_part;
    private int ide_client;
   private int nbr_part;
    
 public participants (String name_part, int ide_client, int nbr_part){
     this.name_part=name_part;
     this.ide_client=ide_client;
     this.nbr_part=nbr_part;
     
     
     
 }

    public int getIdpart() {
        return idpart;
    }

    public void setIdpart(int idpart) {
        this.idpart = idpart;
    }

    public String getName_part() {
        return name_part;
    }

    public void setName_part(String name_part) {
        this.name_part = name_part;
    }

    public int getIde_client() {
        return ide_client;
    }

    public void setIde_client(int ide_client) {
        this.ide_client = ide_client;
    }

    public int getNbr_part() {
        return nbr_part;
    }

    public void setNbr_part(int nbr_part) {
        this.nbr_part = nbr_part;
    }

    @Override
    public String toString() {
        return "participants{" + "idpart=" + idpart + ", name_part=" + name_part + ", ide_client=" + ide_client + ", nbr_part=" + nbr_part + '}';
    }
   
   
   
   
   
   
}
