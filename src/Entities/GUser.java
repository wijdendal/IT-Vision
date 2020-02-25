/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author taieb
 */
public class GUser {

    private SimpleIntegerProperty id ; 
    private SimpleStringProperty Fname ;
    private SimpleStringProperty Lname ;
    private SimpleStringProperty email ;
    private SimpleStringProperty password ;
    private SimpleStringProperty picture ;
    private SimpleIntegerProperty phone ;

    public GUser() {
    }

    public GUser(int id, String Fname, String Lname, String email,String password, String picture, int phone) {
        this.id = new SimpleIntegerProperty(id);
        this.Fname = new SimpleStringProperty(Fname);
        this.Lname = new SimpleStringProperty(Lname);
        this.email = new SimpleStringProperty(email);
        this.password = new SimpleStringProperty(password);
        this.picture = new SimpleStringProperty (picture);
        this.phone = new SimpleIntegerProperty(phone);
    }

    public int getId() {
        return id.get();
    }

    /* public void setId(int id) {
        this.id = id;
    } */

    public String getFname() {
        return Fname.get();
    }

    /* public void setFname(String Fname) {
        this.Fname = Fname;
    } */

    public String getLname() {
        return Lname.get();
    }

   /* public void setLname(String Lname) {
        this.Lname = Lname;
    } */

    public String getEmail() {
        return email.get();
    }

   /* public void setEmail(String email) {
        this.email = email;
    } */

    public String getPassword() {
        return password.get();
    } 

/*    public void setPassword(String password) {
        this.password = password;
    } */

    public String getPicture() {
        return picture.get();
    }

   /* public void setPicture(String picture) {
        this.picture = picture;
    } */

    public int getPhone() {
        return phone.get();
    }

  /*  public void setPhone(int phone) {
        this.phone = phone;
    } */

    @Override
    public String toString() {
        return "GUser{" + "id=" + id + ", Fname=" + Fname + ", Lname=" + Lname + ", email=" + email + ", password=" + password + ", picture=" + picture + ", phone=" + phone + '}';
    }
    
    
    
}
