/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;
import entities.GUser;

/**
 *
 * @author taieb
 */
public class gclient extends GUser {
    private int id ; 
    private String Fname ;
    private String Lname ;
    private String email ;
    private String password ;
    private String picture ;
    private int phone ;    
    private String address ;

    public gclient() {
    }

    public gclient( int id, String Fname, String Lname, String email, String picture, int phone, String address) {
        super(id, Fname, Lname, email, picture, phone);
        this.address = address;
    }
 
    
    
    


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "gclient{" + "id=" + id + ", Fname=" + Fname + ", Lname=" + Lname + ", email=" + email + ", password=" + password + ", picture=" + picture + ", phone=" + phone + ", address=" + address + '}';
    }


    
    
}
