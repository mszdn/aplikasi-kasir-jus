/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uas2.dao;

import java.sql.*;
import uas2.db.koneksi;
import uas2.model.Transaksi;

public class TransaksiDAO {

    // insert transaksi (header)
public int insertTransaksi(Transaksi t) {
        String sql = "INSERT INTO transaksi (id_kasir, pelanggan, total, bayar, kembali) VALUES (?, ?, ?, ?)";

        try {
            Connection conn = koneksi.getKoneksi();
            PreparedStatement pst = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            pst.setInt(1, t.getIdKasir());
            pst.setString(2, t.getPelanggan());
            pst.setDouble(3, t.getTotal());
            pst.setDouble(4, t.getBayar());
            pst.setDouble(5, t.getKembali());

            pst.executeUpdate();

            ResultSet rs = pst.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1); // return id_transaksi yang baru dibuat
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return -1;
    }
}
