/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author user
 */
public class Challenge {
    
int id=0;
       String title;
                        String Description;
                        String pic;
                        int nmbr_pub;
    
    public Challenge( int id,String Nom, String Desc,  String pic, int nmb) {
        this.id = id ; 
        this.title = Nom;
        
        this.Description=Desc;
       
        this.pic=pic;
        this.nmbr_pub=nmb;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return Description;
    }

    public String getPic() {
        return pic;
    }

    public void setNmbr_pub(int nmbr_pub) {
        this.nmbr_pub = nmbr_pub;
    }

    public int getNmbr_pub() {
        return nmbr_pub;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

   
    

    
    
}
