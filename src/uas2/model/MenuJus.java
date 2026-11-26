/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uas2.model;

public class MenuJus {
    private int id;
    private String nama;
    private double harga;
    private String status;

    public MenuJus() {}

    public MenuJus(int id, String nama, double harga, String status) {
        this.id = id;
        this.nama = nama;
        this.harga = harga;
        this.status = status;
    }

    // Getter & Setter
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public double getHarga() { return harga; }
    public void setHarga(double harga) { this.harga = harga; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
