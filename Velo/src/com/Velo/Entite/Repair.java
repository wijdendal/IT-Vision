package com.Velo.Entite;

public class Repair {
    // Repair : IdRepair + IdBike + [Schedule? : Repair Status ???]

    private int IdRepair;
    private int IdBike;


    public Repair(int idRepair, int idBike) {
        this.IdRepair = idRepair;
        this.IdBike = idBike;
    }

    public Repair() {
    }

    public int getIdRepair() {
        return IdRepair;
    }

    public void setIdRepair(int idRepair) {
        IdRepair = idRepair;
    }

    public int getIdBike() {
        return IdBike;
    }

    public void setIdBike(int idBike) {
        IdBike = idBike;
    }

    @Override
    public String toString() {
        return "Repair{" +
                "IdRepair=" + IdRepair +
                ", IdBike=" + IdBike +
                '}' + "\n";
    }
}