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
public class Event {
    
 int  id =0;
       String title;
        String date;
               String heur_deb;
                String heure_fin;
                        String Description;
                        String pic;
                                int etat;
                                String lieu;
                                        String categorie;
                                        String Type;
                                        int  capacite;

    public Event(int id,  String title, String date, String h1 , String h2, String Desc,String Type, String cat,String pic, int etat, String lieu,int Cap) {
       this.id= id;
        this.title = title;
        this.date = date;
        this.heur_deb=h1;
        this.heure_fin=h2 ; 
        this.Description=Desc;
        this.Type=Type;
        this.categorie=cat;
        this.pic=pic;
        this.etat=etat;
        this.lieu = lieu;     
        this.capacite = Cap ; 

    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public int getCapacite() {
        return capacite;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getHeur_deb() {
        return heur_deb;
    }

    public String getHeure_fin() {
        return heure_fin;
    }

    public String getDescription() {
        return Description;
    }

    public String getPic() {
        return pic;
    }

    public int getEtat() {
        return etat;
    }

    public String getLieu() {
        return lieu;
    }

    public String getCategorie() {
        return categorie;
    }

    public String getType() {
        return Type;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setHeur_deb(String heur_deb) {
        this.heur_deb = heur_deb;
    }

    public void setHeure_fin(String heure_fin) {
        this.heure_fin = heure_fin;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public String get() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    
    
}
