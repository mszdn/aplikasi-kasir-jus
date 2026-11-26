/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uas2.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import uas2.db.koneksi;
import uas2.model.MenuJus;

public class MenuJusDAO {

    // ambil semua data
    public List<MenuJus> getAll() {
        List<MenuJus> list = new ArrayList<>();
        String sql = "SELECT * FROM menu_jus";

        try {
            Connection conn = koneksi.getKoneksi();
            ResultSet rs = conn.createStatement().executeQuery(sql);

            while (rs.next()) {
                MenuJus m = new MenuJus(
                    rs.getInt("id_jus"),
                    rs.getString("nama_jus"),
                    rs.getDouble("harga"),
                    rs.getString("status")
                );
                list.add(m);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    // tambah data
    public boolean insert(MenuJus m) {
        String sql = "INSERT INTO menu_jus (nama_jus, harga, status) VALUES (?, ?, ?)";

        try {
            Connection conn = koneksi.getKoneksi();
            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, m.getNama());
            pst.setDouble(2, m.getHarga());
            pst.setString(3, m.getStatus());

            pst.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // update data
    public boolean update(MenuJus m) {
        String sql = "UPDATE menu_jus SET nama_jus=?, harga=?, status=? WHERE id_jus=?";

        try {
            Connection conn = koneksi.getKoneksi();
            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, m.getNama());
            pst.setDouble(2, m.getHarga());
            pst.setString(3, m.getStatus());
            pst.setInt(4, m.getId());

            pst.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // hapus data
    public boolean delete(int id) {
        String sql = "DELETE FROM menu_jus WHERE id_jus=?";

        try {
            Connection conn = koneksi.getKoneksi();
            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setInt(1, id);
            pst.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

