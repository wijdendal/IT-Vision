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
public class Participant_com {
 
private int id_cl ;
 int id_ev ; 
int etat= 0 ; 
String nomP ;
 String nomE ;
 String prenomP;
 String Type;

    public String getNomP() {
        return nomP;
    }

    public void setNomP(String nomP) {
        this.nomP = nomP;
    }

    public String getNomE() {
        return nomE;
    }

    public void setNomE(String nomE) {
        this.nomE = nomE;
    }

    public String getPrenomP() {
        return prenomP;
    }

    public void setPrenomP(String prenomP) {
        this.prenomP = prenomP;
    }

    public void setId_cl(int id_cl) {
        this.id_cl = id_cl;
    }

    public void setId_ev(int id_ev) {
        this.id_ev = id_ev;
    }

    public int getId_cl() {
        return id_cl;
    }

    public int getId_ev() {
        return id_ev;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public Participant_com(int id_cl, int id_ev,String nomP, String PrenomP, String nomE, int etat, String type) {
        this.id_cl = id_cl;
        this.id_ev = id_ev;
        this.nomP = nomP; 
        this.prenomP=prenomP;
        this.nomE = nomE ;
        this.etat = etat;
        this.Type = type;
    }
 
    public Participant_com() {
       
     
    }
    



    
   
}
