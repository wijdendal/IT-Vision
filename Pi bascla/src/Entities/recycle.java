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
public class recycle {
    private int id_recycle;
    private String description;
    private String picture;
   
    public recycle (int id_recyle,String description,String picture){
        this.id_recycle=id_recycle;
        this.description=description;
        this.picture=picture;
        
        
    }

    public int getId_recycle() {
        return id_recycle;
    }

    public void setId_recycle(int id_recycle) {
        this.id_recycle = id_recycle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "recycle{" + "id_recycle=" + id_recycle + ", description=" + description + ", picture=" + picture + '}';
    }
    
    
    
    
    
    
}
