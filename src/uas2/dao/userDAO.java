/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uas2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import uas2.db.koneksi;
import uas2.model.user;

public class userDAO {

    /**
     * Cek username/password.
     * Jika cocok -> return user object (dengan id)
     * Jika tidak -> return null
     */
    public user login(user u) {
        try {
            Connection con = koneksi.getKoneksi();
            String sql = "SELECT id_kasir, username, password FROM kasir WHERE username=? AND password=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, u.getUsername());
            ps.setString(2, u.getPassword());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new user(
                    rs.getInt("id_kasir"),
                    rs.getString("username"),
                    rs.getString("password")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
