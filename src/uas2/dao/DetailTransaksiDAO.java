/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uas2.dao;

import java.sql.*;
import uas2.db.koneksi;
import uas2.model.DetailTransaksi;

public class DetailTransaksiDAO {

    public boolean insertDetail(DetailTransaksi d) {
        String sql = "INSERT INTO detail_transaksi (id_transaksi, id_jus, jumlah, harga, total) "
                   + "VALUES (?, ?, ?, ?, ?)";

        try {
            Connection conn = koneksi.getKoneksi();
            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setInt(1, d.getIdTransaksi());
            pst.setInt(2, d.getIdJus());
            pst.setInt(3, d.getJumlah());
            pst.setDouble(4, d.getHarga());
            pst.setDouble(5, d.getTotal());

            pst.executeUpdate();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}
