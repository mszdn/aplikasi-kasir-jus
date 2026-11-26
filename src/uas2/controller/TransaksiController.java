/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uas2.controller;

import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import uas2.dao.MenuJusDAO;
import uas2.model.MenuJus;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import uas2.db.koneksi;



public class TransaksiController {

    private final MenuJusDAO menuJusDAO = new MenuJusDAO();

    // ==============================
    // 1. LOAD SEMUA MENU JUS
    // ==============================
    public void loadMenuJus(JTable table) {
        String[] kolom = {"ID", "Nama Jus", "Harga"};
        DefaultTableModel dtm = new DefaultTableModel(null, kolom);

        List<MenuJus> data = menuJusDAO.getAll();
        if (data != null) {
            for (MenuJus mj : data) {
                if (mj.getStatus().equalsIgnoreCase("tersedia")) {
                dtm.addRow(new Object[]{
                    mj.getId(),
                    mj.getNama(),
                    mj.getHarga()
                    });
                }
            }
        }

        table.setModel(dtm);
    }

    // ==============================
    // 2. SEARCH MENU JUS
    // ==============================
    public void cariJus(JTable table, String keyword) {
        String[] kolom = {"ID", "Nama Jus", "Harga"};
        DefaultTableModel dtm = new DefaultTableModel(null, kolom);

        String key = keyword.toLowerCase();

        List<MenuJus> data = menuJusDAO.getAll();
        if (data != null) {
            List<MenuJus> hasil = data.stream()
                .filter(m -> 
                    m.getStatus().equalsIgnoreCase("tersedia") && (
                    String.valueOf(m.getId()).contains(key) ||
                    m.getNama().toLowerCase().contains(key)
                    )
                )
                .collect(Collectors.toList());

            for (MenuJus mj : hasil) {
                dtm.addRow(new Object[]{
                    mj.getId(),
                    mj.getNama(),
                    mj.getHarga()
                });
            }
        }

        table.setModel(dtm);
    }
    
    public int simpanTransaksi(int idKasir, String pelanggan,double total, double bayar, double kembali) {
        int idGenerated = -1;

        try {
            Connection c = koneksi.getKoneksi();
            String sql = "INSERT INTO transaksi (id_kasir, pelanggan, total, bayar, kembali) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, idKasir);
            ps.setString(2, pelanggan);
            ps.setDouble(3, total);
            ps.setDouble(4, bayar);
            ps.setDouble(5, kembali);
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                idGenerated = rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return idGenerated;
    }
    
    public void simpanDetailTransaksi(int idTransaksi, int idJus, int jumlah, double harga, double total) {
        try {
            Connection c = koneksi.getKoneksi();
            String sql = "INSERT INTO detail_transaksi (id_transaksi, id_jus, jumlah, harga, total) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, idTransaksi);
            ps.setInt(2, idJus);
            ps.setInt(3, jumlah);
            ps.setDouble(4, harga);
            ps.setDouble(5, total);

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public int getIdJusByNama(String nama) {
        int id = -1;

        try {
            Connection c = koneksi.getKoneksi();
            String sql = "SELECT id_jus FROM menu_jus WHERE nama_jus = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, nama);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                id = rs.getInt("id_jus");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return id;
    }
    
    
    public double getHargaByIdJus(int idJus) {
        double harga = 0;

        try {
            Connection c = koneksi.getKoneksi();
            String sql = "SELECT harga FROM menu_jus WHERE id_jus = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, idJus);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                harga = rs.getDouble("harga");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return harga;
    }


}
