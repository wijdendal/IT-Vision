package com.Velo.Entite;


public class Appointement {
    //Date + Description

    // mysql ? java ?  DateFormat ?
    // java.util.Date
    // java.sql.Date

    private int idAppointement;
    private String date;
    private String Description;

    public Appointement() {
    }

    public Appointement(String date, String description,int idAppointement) {
        this.date = date;
        this.Description = description;
        this.idAppointement= idAppointement;
    }

    public int getIdAppointement() {
        return idAppointement;
    }

    public void setIdAppointement(int idAppointement) {
        this.idAppointement = idAppointement;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    @Override
    public String toString() {
        return "Appointement{" +
                "idAppointement=" + idAppointement +
                ", date='" + date + '\'' +
                ", Description='" + Description + '\'' +
                '}';
    }
}



