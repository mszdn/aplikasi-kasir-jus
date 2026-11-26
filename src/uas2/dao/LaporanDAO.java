package uas2.dao;

import uas2.db.koneksi;
import uas2.model.Laporan;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class LaporanDAO {

    // ======================
    // LAPORAN MINGGUAN
    // ======================
    public List<Laporan> getLaporanMingguan(java.util.Date tanggalAwal) {

        List<Laporan> list = new ArrayList<>();

        try (Connection conn = koneksi.getKoneksi()) {

            java.sql.Date sqlTanggalAwal = new java.sql.Date(tanggalAwal.getTime());

            Calendar cal = Calendar.getInstance();
            cal.setTime(tanggalAwal);
            cal.add(Calendar.DAY_OF_MONTH, 7);
            java.sql.Date sqlTanggalAkhir = new java.sql.Date(cal.getTimeInMillis());

            String sql = "SELECT * FROM transaksi WHERE tanggal BETWEEN ? AND ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDate(1, sqlTanggalAwal);
            ps.setDate(2, sqlTanggalAkhir);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Laporan l = new Laporan(
                        rs.getInt("id_transaksi"),
                        rs.getTimestamp("tanggal"),
                        rs.getDouble("total"),
                        rs.getDouble("bayar"),
                        rs.getDouble("kembali"),
                        rs.getInt("id_kasir"),
                        rs.getString("pelanggan")
                );

                list.add(l);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    // ======================
    // LAPORAN BULANAN
    // ======================
    public List<Laporan> getLaporanBulanan(java.util.Date tanggalAwal) {

        List<Laporan> list = new ArrayList<>();

        try (Connection conn = koneksi.getKoneksi()) {

            java.sql.Date sqlTanggalAwal = new java.sql.Date(tanggalAwal.getTime());

            Calendar cal = Calendar.getInstance();
            cal.setTime(tanggalAwal);
            cal.add(Calendar.DAY_OF_MONTH, 30);
            java.sql.Date sqlTanggalAkhir = new java.sql.Date(cal.getTimeInMillis());

            String sql = "SELECT * FROM transaksi WHERE tanggal BETWEEN ? AND ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDate(1, sqlTanggalAwal);
            ps.setDate(2, sqlTanggalAkhir);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Laporan l = new Laporan(
                        rs.getInt("id_transaksi"),
                        rs.getTimestamp("tanggal"),
                        rs.getDouble("total"),
                        rs.getDouble("bayar"),
                        rs.getDouble("kembali"),
                        rs.getInt("id_kasir"),
                        rs.getString("pelanggan")
                );

                list.add(l);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
