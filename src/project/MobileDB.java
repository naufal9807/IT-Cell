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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Void
 */
public class MobileDB {
    public static boolean flag = false;
    public static void insertIntoMobileDB(String nama, String detail, String deskripsi, String image){
        try {
            Connection con = Koneksi.getConnection();
         
            PreparedStatement ps = con.prepareStatement("INSERT INTO mobiles(nama, detail, mdescription, mphoto) VALUES(?,?,?,?)");
            
            ps.setString(1, nama);
            ps.setString(2, detail);
            ps.setString(3, deskripsi);
            ps.setString(4, image);
            if(ps.executeUpdate()==1)
                JOptionPane.showMessageDialog(null, "Entry successful!");
            
        } catch (SQLException ex) {
            Logger.getLogger(MobileDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public static void updateMobileDB(String nama, int id){
         try {
            Connection con = Koneksi.getConnection();
            
            PreparedStatement ps = con.prepareStatement("UPDATE mobiles SET nama=? WHERE id_mobile=?");
            
            ps.setString(1, nama);
            ps.setInt(2, id);
            if(ps.executeUpdate()==0)
                JOptionPane.showMessageDialog(null, "Entry does not exist!");
            else if(ps.executeUpdate()==1 && flag){
                JOptionPane.showMessageDialog(null, "Data updated successfully!");
                flag = false;
            }

        } catch (SQLException ex) {
            Logger.getLogger(MobileDB.class.getName()).log(Level.SEVERE, null, ex);

    }
    }
    
    public static ArrayList<ProductList> TableGenerator(){
        ArrayList<ProductList> list = new ArrayList<>();
        try {
            Connection con = Koneksi.getConnection();
            Statement ps = con.createStatement();
            ResultSet rs = ps.executeQuery("SELECT nama, detail, mdescription, mphoto FROM mobiles");
            
            ProductList pl;
            
            while(rs.next()){
                pl = new ProductList(rs.getString("nama"),rs.getString("detail"),
                        rs.getString("mdescription"),rs.getString("mphoto"));
                
                list.add(pl);

            }

        } catch (SQLException ex) {
            Logger.getLogger(MobileDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
}
    public static ArrayList<ProductList> homePageContent(){
        ArrayList<ProductList> list = new ArrayList<>();
        try {
            Connection con = Koneksi.getConnection();
            Statement ps = con.createStatement();
            ResultSet rs = ps.executeQuery("SELECT nama, detail, mdescription, mphoto FROM mobiles ORDER BY id_mobile DESC LIMIT 3");
            
            ProductList pl;
            
            while(rs.next()){
                pl = new ProductList(rs.getString("nama"),rs.getString("detail"),
                        rs.getString("mdescription"),rs.getString("mphoto"));
                
                list.add(pl);

            }
            
        } catch (SQLException ex) {
            Logger.getLogger(MobileDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
   }
    
    public static ArrayList<ProductList> checkStock(){
        ArrayList<ProductList> list = new ArrayList<>();
        try {
            Connection con = Koneksi.getConnection();
            Statement ps = con.createStatement();
            ResultSet rs = ps.executeQuery("SELECT id_mobile, nama, detail FROM mobiles");
            
            ProductList pl;
            
            while(rs.next()){
                pl = new ProductList(rs.getString("id_mobile"), rs.getString("nama"),rs.getString("detail"),
                         null);
                
                list.add(pl);

            }
            
        } catch (SQLException ex) {
            Logger.getLogger(MobileDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
   }
    
       public static void delete(String id){
        try {
            Connection con = Koneksi.getConnection();
            PreparedStatement ps = con.prepareStatement("DELETE FROM mobiles WHERE id_mobile=?");
            ps.setString(1, id);
           if(ps.executeUpdate()==0)
                JOptionPane.showMessageDialog(null, "Entry does not exist!");
            else
                JOptionPane.showMessageDialog(null, "Entry deleted successfully!");
            
        } catch (SQLException ex) {
            Logger.getLogger(BeritaDB.class.getName()).log(Level.SEVERE, null, ex);
        }
            
   }
    
    
    
}
