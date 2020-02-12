package com.Velo.Entite;

public class Reclamation {

//  IdReclamation  +  Description  + [TypeRecommandation later ? ]

    private int IdReclamation;
    private String Description;

    public Reclamation(int idReclamation, String description) {
        this.IdReclamation = idReclamation;
        this.Description = description;
    }
        /**********         **********/
    public Reclamation() {
    }

    public int getIdReclamation() {
        return IdReclamation;
    }

    public void setIdReclamation(int idReclamation) {
        IdReclamation = idReclamation;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    @Override
    public String toString() {
        return "Reclamation{" +
                "IdReclamation=" + IdReclamation +
                ", Description='" + Description + '\'' +
                '}';
    }
}
