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
public class KidsDB {
    public static boolean flag = false;
    public static void insertIntoKidsDB(String brand, String model, String description, String imagePath){
        try {
            Connection con = DriverManager.getConnection("jdbc:sqlite:DBs/kidsDB.db");
         
            PreparedStatement ps = con.prepareStatement("INSERT INTO kids(mbrand, mmodel, mdescription, mphoto) VALUES(?,?,?,?)");
            
            ps.setString(1, brand);
            ps.setString(2, model);
            ps.setString(3, description);
            ps.setString(4, imagePath);
            
            if(ps.executeUpdate()==1)
                JOptionPane.showMessageDialog(null, "Entry successful!");
            
        } catch (SQLException ex) {
            Logger.getLogger(MobileDB.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    }
    
    public static void updateKidsDB(String model, String brand){
         try {
            Connection con = DriverManager.getConnection("jdbc:sqlite:DBs/kidsDB.db");
            
            PreparedStatement ps = con.prepareStatement("UPDATE kids SET mquantity=? WHERE id=?");
            
            ps.setString(1, brand);
            ps.setString(2, model);
            if(ps.executeUpdate()==0)
                JOptionPane.showMessageDialog(null, "Konten Tidak Terupdate!");
            else if(ps.executeUpdate()==1 && flag){
                JOptionPane.showMessageDialog(null, "Konten Berhasil Terupdate!");
                flag = false;
            }

        } catch (SQLException ex) {
            Logger.getLogger(KidsDB.class.getName()).log(Level.SEVERE, null, ex);

    }
    }
    
    public static ArrayList<ProductList> TableGenerator(){
        ArrayList<ProductList> list = new ArrayList<>();
        try {
            Connection con = DriverManager.getConnection("jdbc:sqlite:DBs/kidsDB.db");
            Statement ps = con.createStatement();
            ResultSet rs = ps.executeQuery("SELECT mbrand, mmodel,mdescription, mphoto FROM kids");
            
            ProductList pl;
            
            while(rs.next()){
                pl = new ProductList(rs.getString("mbrand"),rs.getString("mmodel"),
                        rs.getString("mdescription"),
                        rs.getString("mphoto"));
                
                list.add(pl);

            }
            
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(MobileDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
}
    public static ArrayList<ProductList> homePageContent(){
        ArrayList<ProductList> list = new ArrayList<>();
        try {
            Connection con = DriverManager.getConnection("jdbc:sqlite:DBs/kidsDB.db");
            Statement ps = con.createStatement();
            ResultSet rs = ps.executeQuery("SELECT mbrand, mmodel, mdescription, mphoto FROM kids ORDER BY id DESC LIMIT 3");
            
            ProductList pl;
            
            while(rs.next()){
                pl = new ProductList(rs.getString("mbrand"),rs.getString("mmodel"),
                        rs.getString("mdescription"),
                        rs.getString("mphoto"));
                
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
            Connection con = DriverManager.getConnection("jdbc:sqlite:DBs/kidsDB.db");
            Statement ps = con.createStatement();
            ResultSet rs = ps.executeQuery("SELECT mbrand, mmodel FROM kids");
            
            ProductList pl;
            
            while(rs.next()){
                pl = new ProductList(rs.getString("mbrand"),rs.getString("mmodel"),
                        null, null);
                
                list.add(pl);

            }
            
        } catch (SQLException ex) {
            Logger.getLogger(MobileDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
   }
    
       public static void delete(String model){
        try {
            Connection con = DriverManager.getConnection("jdbc:sqlite:DBs/kidsDB.db");
            PreparedStatement ps = con.prepareStatement("DELETE FROM kids WHERE id=?");
            ps.setString(1, model);
            if(ps.executeUpdate()==0)
                JOptionPane.showMessageDialog(null, "Konten tidak terhapus!");
            else
                JOptionPane.showMessageDialog(null, "Konten berhasil dihapus!");
            
        } catch (SQLException ex) {
            Logger.getLogger(ElectronicsDB.class.getName()).log(Level.SEVERE, null, ex);
        }
            
   }
    
    
    
}
