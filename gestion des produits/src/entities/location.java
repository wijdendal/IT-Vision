/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.Timestamp;

/**
 *
 * @author mh
 */
public class location {
    
     private int id;
    private Timestamp  Date_debut;
    private Timestamp  Date_fin;

    
    
    public location(int id,Timestamp dd,Timestamp df)
           
 {
     this.id=id;
     this.Date_debut=dd;
     this.Date_fin=df;
     



}
    public int getid() {
        return id;
    }

    
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the Date_debut
     */
    public Timestamp getDate_debut() {
        return Date_debut;
    }

    /**
     * @param Date_debut the Date_debut to set
     */
    public void setDate_debut(Timestamp Date_debut) {
        this.Date_debut = Date_debut;
    }

    /**
     * @return the Date_fin
     */
    public Timestamp getDate_fin() {
        return Date_fin;
    }

    /**
     * @param Date_fin the Date_fin to set
     */
    public void setDate_fin(Timestamp Date_fin) {
        this.Date_fin = Date_fin;
    }
    
}
