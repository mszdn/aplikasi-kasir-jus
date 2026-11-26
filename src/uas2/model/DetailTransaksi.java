/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uas2.model;

public class DetailTransaksi {
    private int idDetail;
    private int idTransaksi;
    private int idJus;
    private int jumlah;
    private double harga;
    private double total;

    public DetailTransaksi(int idJus, int jumlah, double harga) {
        this.idJus = idJus;
        this.jumlah = jumlah;
        this.harga = harga;
        this.total = jumlah * harga;
    }

    public int getIdDetail() { return idDetail; }
    public void setIdDetail(int idDetail) { this.idDetail = idDetail; }

    public int getIdTransaksi() { return idTransaksi; }
    public void setIdTransaksi(int idTransaksi) { this.idTransaksi = idTransaksi; }

    public int getIdJus() { return idJus; }
    public void setIdJus(int idJus) { this.idJus = idJus; }

    public int getJumlah() { return jumlah; }
    public void setJumlah(int jumlah) { this.jumlah = jumlah; }

    public double getHarga() { return harga; }
    public void setHarga(double harga) { this.harga = harga; }

    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }
}
