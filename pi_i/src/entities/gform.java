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
public class gform extends GUser{
    private int id ; 
    private String Fname ;
    private String Lname ;
    private String email ;
    private String password ;
    private String picture ;
    private int phone ;    
    private String diploma;

    public gform() {
    }

    public gform( int id, String Fname, String Lname, String email, String picture, int phone, String diploma) {
        super(id, Fname, Lname, email, picture, phone);
        this.diploma = diploma;
    }



    public String getDiploma() {
        return diploma;
    }

    public void setDiploma(String diploma) {
        this.diploma = diploma;
    }

    @Override
    public String toString() {
        return "gform{" + "id=" + id + ", Fname=" + Fname + ", Lname=" + Lname + ", email=" + email + ", password=" + password + ", picture=" + picture + ", phone=" + phone + ", diploma=" + diploma + '}';
    }


    
}
