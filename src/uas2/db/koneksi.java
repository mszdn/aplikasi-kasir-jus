package uas2.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class koneksi {

    private static final String URL = "jdbc:mysql://localhost:3306/jus";
    private static final String USER = "root";
    private static final String PASS = "";

    // Selalu return koneksi baru (bukan static connection)
    public static Connection getKoneksi() {
        try {
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            System.out.println("Koneksi ke database gagal!");
            e.printStackTrace();
            return null;
        }
    }

    // Optional untuk testing
    public static void main(String[] args) {
        Connection c = getKoneksi();
        if (c != null) {
            System.out.println("Koneksi berhasil!");
        } else {
            System.out.println("Koneksi gagal!");
        }
    }
}
