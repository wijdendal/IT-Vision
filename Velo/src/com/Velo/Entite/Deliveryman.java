package com.Velo.Entite;

public class Deliveryman {
//  in → user ??? inherit from Client !!
//phoneNumber + Salary

    private int IdDeliveryMan;
    private int Phone;
    private int Salary;

    public Deliveryman(int idDeliveryMan, int phone, int salary) {
        this.IdDeliveryMan = idDeliveryMan;
        this.Phone = phone;
        this.Salary = salary;
    }
        /***********        ***********/
    public Deliveryman() {
    }

    public int getIdDeliveryMan() {
        return IdDeliveryMan;
    }

    public void setIdDeliveryMan(int idDeliveryMan) {
        IdDeliveryMan = idDeliveryMan;
    }

    public int getPhone() {
        return Phone;
    }

    public void setPhone(int phone) {
        Phone = phone;
    }

    public int getSalary() {
        return Salary;
    }

    public void setSalary(int salary) {
        this.Salary = salary;
    }

    @Override
    public String toString() {
        return "Deliveryman{" +
                "IdDeliveryMan=" + IdDeliveryMan +
                ", Phone=" + Phone +
                ", salary=" + Salary +
                '}';
    }
}
