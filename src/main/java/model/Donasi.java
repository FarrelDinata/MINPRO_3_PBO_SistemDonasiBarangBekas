/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author DELL
 */
public abstract class Donasi implements StatusDonasi {

    private String idDonasi;
    private String namaPendonor;
    private String namaBarang;
    private int jumlahBarang;

    // Constructor utama
    public Donasi(String idDonasi, String namaPendonor, String namaBarang, int jumlahBarang) {
        setIdDonasi(idDonasi);
        setNamaPendonor(namaPendonor);
        setNamaBarang(namaBarang);
        setJumlahBarang(jumlahBarang);
    }

    // Overloading Constructor: Default jumlahBarang = 1
    public Donasi(String idDonasi, String namaPendonor, String namaBarang) {
        this(idDonasi, namaPendonor, namaBarang, 1);
    }

    // ===== Getter =====
    public String getIdDonasi() {
        return idDonasi;
    }

    public String getNamaPendonor() {
        return namaPendonor;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public int getJumlahBarang() {
        return jumlahBarang;
    }

    // ===== Setter dengan Validasi Encapsulation =====
    public void setIdDonasi(String idDonasi) {
        this.idDonasi = validasiTeks(idDonasi, "ID Donasi");
    }

    public void setNamaPendonor(String namaPendonor) {
        this.namaPendonor = validasiTeks(namaPendonor, "Nama Pendonor");
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = validasiTeks(namaBarang, "Nama Barang");
    }

    public void setJumlahBarang(int jumlahBarang) {
        if (jumlahBarang < 1) {
            throw new IllegalArgumentException("Jumlah barang minimal 1 unit.");
        }
        this.jumlahBarang = jumlahBarang;
    }

    protected static String validasiTeks(String teks, String namaField) {
        if (teks == null || teks.trim().isEmpty()) {
            throw new IllegalArgumentException(namaField + " tidak boleh kosong.");
        }
        return teks.trim();
    }

    // Abstract Method (Wajib di-override subclass)
    public abstract String getKategori();
    public abstract String getDetailRincian();

    // Overriding Method
    public String tampilkanInfo() {
        return "[" + getKategori() + "] ID: " + getIdDonasi()
                + " | Pendonor: " + getNamaPendonor()
                + " | Barang: " + getNamaBarang()
                + " | Jumlah: " + getJumlahBarang() + " unit"
                + " | Status: " + cekKelayakanPenyaluran();
    }

    // Overloading Method: Tampilkan info dengan nomor urut
    public String tampilkanInfo(int nomor) {
        return nomor + ". " + tampilkanInfo() + "\n   Detail Rincian: " + getDetailRincian();
    }

    // Overloading Method: Tampilkan info dengan kustom header
    public String tampilkanInfo(String header) {
        return "=== " + header + " ===\n" + tampilkanInfo();
    }
}