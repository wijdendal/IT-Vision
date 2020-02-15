package com.Velo.Entite;
// import java.util.Date;
// import java.sql.Date;

public class Appointement {
    //Appointement : idAppointement + date + description

    private int idappointement;
    private String date;
    private String description;

    public Appointement(String idappointement, String date, String description) {
    }

    public Appointement(int idappointement, String date, String description) {
        this.idappointement = idappointement;
        this.date = date;
        this.description = description;
    }


    public Appointement(String date, String description) {
        this.date = date;
        this.description = description;
    }

    public int getIdAppointement() {
        return idappointement;
    }

    public void setIdAppointement(int idappointement) {
        this.idappointement = idappointement;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    //java output
    @Override
    public String toString() {
        return "              " +
                "{" +
                "" + idappointement +
                ", '" + date + '\'' +
                ", '" + description + '\'' +
                '}' + "\n";
    }

}




/*
@Override
public String toString() {
        return "Appointement{" +
                "idappointement=" + idappointement +
                ", date='" + date + '\'' +
                ", description='" + description + '\'' +
                '}' + "\n" ; }
*/




