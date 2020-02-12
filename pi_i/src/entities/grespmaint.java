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
public class grespmaint extends GUser {
    private int id ; 
    private String Fname ;
    private String Lname ;
    private String email ;
    private String password ;
    private String picture ;
    private int phone ;
    private int salary ;

    public grespmaint() {
    }

    public grespmaint( int id, String Fname, String Lname, String email, String picture, int phone,int salary) {
        super(id, Fname, Lname, email, picture, phone);
        this.salary = salary;
    }



    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "grespmaint{" + "id=" + id + ", Fname=" + Fname + ", Lname=" + Lname + ", email=" + email + ", password=" + password + ", picture=" + picture + ", phone=" + phone + ", salary=" + salary + '}';
    }


    
    
}
