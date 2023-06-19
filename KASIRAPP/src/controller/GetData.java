/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import models.Produk;
import config.Config;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author HP
 */
public class GetData extends Config {
    public static List<Produk> readData() {
        connection();
        List<Produk> dataList = new ArrayList<>();
        
        try {
            statement = connection.prepareStatement("SELECT * FROM `produk` ");
            resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("nama");
                int harga = resultSet.getInt("harga");
                int jumlah = resultSet.getInt("jumlah");

                Produk produk = new Produk(id, name, harga, jumlah);
                dataList.add(produk);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dataList;
    }
    
    public static void deleteData(int id) {
        connection();

        try {
            String query = "DELETE FROM `produk` WHERE `produk`.`id` = ?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.executeUpdate();
            statement.close();
            updateId();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
        
    public static void insertData(String nama, long harga, int jumlah) {
        connection();
        try {
            resetId();
            statement = connection.prepareStatement("INSERT INTO produk (nama, harga, jumlah) VALUES (?, ?, ?)");
            statement.setString(1, nama);
            statement.setLong(2, harga);
            statement.setInt(3, jumlah);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void updateJumlah(int id, int stock) {
        connection();
        try {
            statement = connection.prepareStatement("UPDATE produk SET jumlah=? WHERE id=?");
            statement.setInt(1, stock);
            statement.setInt(2, id);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateHarga(int id, long harga) {
        connection();
        try {
            statement = connection.prepareStatement("UPDATE produk SET harga=? WHERE id=?");
            statement.setLong(1, harga);
            statement.setInt(2, id);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateNama(int id, String nama) {
        connection();
        try {
            statement = connection.prepareStatement("UPDATE produk SET nama=? WHERE id=?");
            statement.setString(1, nama);
            statement.setInt(2, id);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    public static void resetId(){
        connection();
        try{
            statement = connection.prepareStatement("ALTER TABLE `produk` AUTO_INCREMENT = 1");
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void updateId(){
        connection();
        try{
            List<Produk> dataList = readData();
            for (int i = 0; i < dataList.size(); i++){
                Produk data = dataList.get(i);
                int newId = i + 1;
                statement = connection.prepareStatement("UPDATE produk SET id = ? WHERE id = ?");
                statement.setInt(1, newId);
                statement.setInt(2, data.getId());
                statement.executeUpdate();
                statement.close();
            } 
        } catch (SQLException e){
                e.printStackTrace();
        }
    }
 
    
}

    

