package com.Velo.Entite;

public class Reclamation {
    //  Reclamation : IdReclamation  +  Description  + [ TypeRecommandation if needed ? ]

    private int IdReclamation;
    private String description;

    public Reclamation(int idReclamation, String description) {
        this.IdReclamation = idReclamation;
        this.description = description;
    }

    public Reclamation() {
    }

    public int getIdReclamation() {
        return IdReclamation;
    }

    public void setIdReclamation(int idReclamation) {
        IdReclamation = idReclamation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        description = description;
    }

    @Override
    public String toString() {
        return "Reclamation{" +
                "IdReclamation=" + IdReclamation +
                ", Description='" + description + '\'' +
                '}' + "\n" ;
    }
}
