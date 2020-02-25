/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author user
 */
public class post_challenge {
    private 
      int  id_pc =0;
      int  id_ch=0;
      String nom;
      int id_client=0;
      String Desc_post_ch;
      String image;
      String Map_circuit;
      int Nmb_reaction=0;

    public post_challenge(int id_pc,int id_ch, int id_client,String nom, String Desc_post_ch, String image, String Map_circuit, int Nmb_reaction) {
        this.id_pc = id_pc; 
        this.id_client=id_client;
        this.id_ch=id_ch;
        this.nom= nom;
        this.Desc_post_ch = Desc_post_ch;
        this.image = image;
        this.Map_circuit = Map_circuit;
        this.Nmb_reaction = Nmb_reaction;
    }

    

  

    

    public int getId_pc() {
        return id_pc;
    }

    public int getId_ch() {
        return id_ch;
    }

    public int getId_client() {
        return id_client;
    }

    public String getDesc_post_ch() {
        return Desc_post_ch;
    }

    public String getImage() {
        return image;
    }

    public String getMap_circuit() {
        return Map_circuit;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    

    public int getNmb_reaction() {
        return Nmb_reaction;
    }

    public void setId_pc(int id_pc) {
        this.id_pc = id_pc;
    }

    public void setId_ch(int id_ch) {
        this.id_ch = id_ch;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public void setDesc_post_ch(String Desc_post_ch) {
        this.Desc_post_ch = Desc_post_ch;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setMap_circuit(String Map_circuit) {
        this.Map_circuit = Map_circuit;
    }

    
    public void setNmb_reaction(int Nmb_reaction) {
        this.Nmb_reaction = Nmb_reaction;
    }

    

    
    
}
