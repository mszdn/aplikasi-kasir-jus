/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uas2.model;

public class Transaksi {
    private int idTransaksi;
    private int idKasir;
    private String pelanggan;
    private double total;
    private String tanggal;
    private double bayar;
    private double kembali;
    public Transaksi() {}

    public Transaksi(int idKasir, String pelanggan, double bayar, double kembali) {
        this.idKasir = idKasir;
        this.pelanggan = pelanggan;
        this.total = total;
        this.bayar = bayar;
        this.kembali = kembali;

        
    }

    public int getIdTransaksi() { return idTransaksi; }
    public void setIdTransaksi(int idTransaksi) { this.idTransaksi = idTransaksi; }

    public int getIdKasir() { return idKasir; }
    public void setIdKasir(int idKasir) { this.idKasir = idKasir; }

    public String getPelanggan() { return pelanggan; }
    public void setPelanggan(String pelanggan) { this.pelanggan = pelanggan; }
    
    public double getTotal() { return total; }
    public void setTotal(double Total) { this.total = total; }

    public String getTanggal() { return tanggal; }
    public void setTanggal(String tanggal) { this.tanggal = tanggal; }
    
    public double getBayar() { return bayar; }
    public void setBayar(double bayar) { this.bayar = bayar; }

    public double getKembali() { return kembali; }
    public void setKembali(double kembali) { this.kembali = kembali; }
}
