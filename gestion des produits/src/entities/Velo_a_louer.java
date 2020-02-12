/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Date;



/**
 *
 * @author mh
 */
public class Velo_a_louer{
    
     private int id;
    private float prix;
    private String marque;
    private String path_photo;
    private String description;
    private int nombre;
    
    
    

   public Velo_a_louer(int id,float prix,String marque,String path,String des,int nbr)
           
 {
     this.id=id;
     this.prix=prix;
     this.marque=marque;
     this.path_photo=path;
     this.description=des;
     this.nombre=nbr;
    




}
    
    
    
    
    
    
    
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the prix
     */
    public float getPrix() {
        return prix;
    }

    /**
     * @param prix the prix to set
     */
    public void setPrix(float prix) {
        this.prix = prix;
    }

    /**
     * @return the marque
     */
    public String getMarque() {
        return marque;
    }

    /**
     * @param marque the marque to set
     */
    public void setMarque(String marque) {
        this.marque = marque;
    }

    /**
     * @return the path_photo
     */
    public String getPath_photo() {
        return path_photo;
    }

    /**
     * @param path_photo the path_photo to set
     */
    public void setPath_photo(String path_photo) {
        this.path_photo = path_photo;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the nombre
     */
    public int getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the date_debut
     */
    

    /**
     * @return the date_fin
     */
    
}
