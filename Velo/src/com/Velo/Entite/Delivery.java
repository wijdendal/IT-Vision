package com.Velo.Entite;

public class Delivery {
    //  Delivery : idDelivery  + idClient  + idBike

    private int idDelivery;
    private int idClient;
    private int idBike;
    private String description;

    public Delivery() {
    }

    public Delivery(int idDelivery, int idClient, int idBike, String description) {
        this.idDelivery = idDelivery;
        this.idClient = idClient;
        this.idBike = idBike;
        this.description = description;
    }

    public int getIdDelivery() {
        return idDelivery;
    }

    public void setIdDelivery(int idDelivery) {
        this.idDelivery = idDelivery;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public int getIdBike() {
        return idBike;
    }

    public void setIdBike(int idBike) {
        this.idBike = idBike;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "idDelivery=" + idDelivery +
                ", idClient=" + idClient +
                ", idBike=" + idBike +
                ", description='" + description + '\'' +
                '}'+"\n";
    }
}

