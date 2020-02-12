/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author taieb
 */
public class gadmin extends GUser{
    private int id ; 
    private String Fname ;
    private String Lname ;
    private String email ;
    private String password ;
    private String picture ;
    private int phone ;
    
    public gadmin() {
    }

    public gadmin(int id, String Fname, String Lname, String email, String picture, int phone) {
        super(id, Fname, Lname, email, picture, phone);
    }

    @Override
    public String toString() {
        return "gadmin{" + "id=" + id + ", Fname=" + Fname + ", Lname=" + Lname + ", email=" + email + ", password=" + password + ", picture=" + picture + ", phone=" + phone + '}';
    }
 
    

    
    
}
