package com.Velo.Entite;

public class Delivery {
    //  idDelivery  + IdClient  + IdBike
    private int IdDelivery;
    private int IdClient;
    private int IdBike;
    private String Description;

    public Delivery(int idDelivery, int idClient, int idBike, String description) {
        this.IdDelivery = idDelivery;
        this.IdClient = idClient;
        this.IdBike = idBike;
        this.Description = description;
    }

    public Delivery() {
    }

    public int getIdDelivery() {
        return IdDelivery;
    }

    public void setIdDelivery(int idDelivery) {
        IdDelivery = idDelivery;
    }

    public int getIdClient() {
        return IdClient;
    }

    public void setIdClient(int idClient) {
        IdClient = idClient;
    }

    public int getIdBike() {
        return IdBike;
    }

    public void setIdBike(int idBike) {
        IdBike = idBike;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "IdDelivery=" + IdDelivery +
                ", IdClient=" + IdClient +
                ", IdBike=" + IdBike +
                ", Description='" + Description + '\'' +
                '}';
    }
}
