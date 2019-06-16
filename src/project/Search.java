/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Void
 */
public class Search {
    static int berita = 0;
    static int mobile = 0;
    static int tips = 0;
    public static ArrayList<ProductList> mobileSearch(String model){
        ArrayList<ProductList> list = new ArrayList<>();
        try {
            Connection con = Koneksi.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM berita WHERE nama=? COLLATE NOCASE OR detail=? COLLATE NOCASE");
            ps.setString(1, model);
            ps.setString(2, model);
            ResultSet rs = ps.executeQuery();
            
            ProductList pl, gl, kl=null;
            
            while(rs.next()){
                pl = new ProductList(rs.getString("nama"),rs.getString("detail"),
                        rs.getString("deskripsi"),rs.getString("photo"));
                berita++;
                
                list.add(pl);

            }
            con.close();
            
            con = Koneksi.getConnection();
            ps = con.prepareStatement("SELECT * FROM mobiles WHERE nama=? COLLATE NOCASE OR detail=? COLLATE NOCASE");
            ps.setString(1, model);
            ps.setString(2, model);
            rs = ps.executeQuery();

            
            while(rs.next()){
                gl = new ProductList(rs.getString("nama"),rs.getString("detail"),
                        rs.getString("mdescription"),rs.getString("mphoto"));
                mobile++;
                list.add(gl);

            }
            con.close();
            
            con = Koneksi.getConnection();
            ps = con.prepareStatement("SELECT * FROM tips WHERE nama=? COLLATE NOCASE OR detail=? COLLATE NOCASE");
            ps.setString(1, model);
            ps.setString(2, model);
            rs = ps.executeQuery();

            
            while(rs.next()){
                kl = new ProductList(rs.getString("nama"),rs.getString("detail"),
                        rs.getString("deskripsi"),rs.getString("photo"));
                tips++;
                list.add(kl);

            }
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(MobileDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
   }
    
}
