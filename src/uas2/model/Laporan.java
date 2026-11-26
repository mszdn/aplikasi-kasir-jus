package uas2.model;

public class Laporan {
    private int idTransaksi;
    private java.sql.Timestamp tanggal;
    private double total;
    private double bayar;
    private double kembali;
    private int idKasir;
    private String pelanggan;

    public Laporan(int idTransaksi, java.sql.Timestamp tanggal, double total,
                   double bayar, double kembali, int idKasir, String pelanggan) {

        this.idTransaksi = idTransaksi;
        this.tanggal = tanggal;
        this.total = total;
        this.bayar = bayar;
        this.kembali = kembali;
        this.idKasir = idKasir;
        this.pelanggan = pelanggan;
    }

    public int getIdTransaksi() { return idTransaksi; }
    public java.sql.Timestamp getTanggal() { return tanggal; }
    public double getTotal() { return total; }
    public double getBayar() { return bayar; }
    public double getKembali() { return kembali; }
    public int getIdKasir() { return idKasir; }
    public String getPelanggan() { return pelanggan; }
}
