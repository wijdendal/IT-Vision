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
public class charity {
    private int id_charity;
    private String picture;
    private String description;
    private String adresse;
    
  public charity(int id_charity,String picture, String description,String adresse)  {
      this.id_charity=id_charity;
      this.picture=picture;
      this.description=description;
      this.adresse=adresse;
  }

    public charity(String mmm, String desc, String tunis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId_charity() {
        return id_charity;
    }

    public void setId_charity(int id_charity) {
        this.id_charity = id_charity;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @Override
    public String toString() {
        return "charity{" + "id_charity=" + id_charity + ", picture=" + picture + ", description=" + description + ", adresse=" + adresse + '}';
    }
    
    
}
