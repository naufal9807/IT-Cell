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
import static project.MobileDB.flag;

/**
 *
 * @author Void
 */
public class BeritaDB {
    public static boolean flag = false;
    public static void insertIntoBeritaDB(String nama, String detail, String deskripsi, String image){
        try {
            Connection con = Koneksi.getConnection();
         
            PreparedStatement ps = con.prepareStatement("INSERT INTO berita(nama, detail, deskripsi, photo) VALUES(?,?,?,?)");
            
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
    
    public static void updateBeritaDB(String nama, int id){
         try {
            Connection con = Koneksi.getConnection();
            
            PreparedStatement ps = con.prepareStatement("UPDATE berita SET nama=? WHERE id_berita=?");
            
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
            ResultSet rs = ps.executeQuery("SELECT nama, detail, deskripsi, photo FROM berita");
            
            ProductList pl;
            
            while(rs.next()){
                pl = new ProductList(rs.getString("nama"),rs.getString("detail"),
                        rs.getString("deskripsi"),rs.getString("photo"));
                
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
            ResultSet rs = ps.executeQuery("SELECT nama, detail, deskripsi, photo FROM berita ORDER BY id_berita DESC LIMIT 3");
            
            ProductList pl;
            
            while(rs.next()){
                pl = new ProductList(rs.getString("nama"),rs.getString("detail"),
                        rs.getString("deskripsi"),rs.getString("photo"));
                
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
            ResultSet rs = ps.executeQuery("SELECT id_berita, nama, detail FROM berita");
            
            ProductList pl;
            
            while(rs.next()){
                pl = new ProductList(rs.getString("id_berita"),rs.getString("nama"),rs.getString("detail"),
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
            PreparedStatement ps = con.prepareStatement("DELETE FROM berita WHERE id_berita=?");
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
