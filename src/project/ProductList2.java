/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Void
 */
public class ProductList2 {
    private String ID;
    private String nama;
    private String detail;
    private String deskripsi;
    private String mimage;

    public ProductList2(String ID, String nama, String detail, String deskripsi, String image) {
        this.ID = ID;
        this.nama = nama;
        this.detail = detail;
        this.deskripsi = deskripsi;
        this.mimage = image;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getDescription() {
        return deskripsi;
    }

    public void setDescription(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getMimage() {
        //return new ImageIcon(new ImageIcon(mimage).getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH));
        return mimage;
    }

    public void setMimage(String mimage) {
        this.mimage = mimage;
    }
    
    
    
}
