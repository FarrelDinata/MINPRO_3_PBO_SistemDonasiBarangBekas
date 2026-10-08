/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import model.Donasi;
import model.DonasiElektronik;
import model.DonasiPakaian;

public class DonasiController {

    private final List<Donasi> daftarDonasi;

    public DonasiController() {
        this.daftarDonasi = new ArrayList<>();
        isiDummyData();
    }

    private void isiDummyData() {
        daftarDonasi.add(new DonasiPakaian("D001", "Budi Santoso", "Jaket Hoodie", 3, "L"));
        daftarDonasi.add(new DonasiPakaian("D002", "Siti Aminah", "Kemeja Batik", 5));
        daftarDonasi.add(new DonasiElektronik("D003", "Andi Wijaya", "Kipas Angin", 2, "Miyako", true));
        daftarDonasi.add(new DonasiElektronik("D004", "Rina Lestari", "Setrika", 1, "Philips", false));
    }

    public List<Donasi> getAllDonasi() {
        return daftarDonasi;
    }

    public boolean isIdExist(String id) {
        for (Donasi d : daftarDonasi) {
            if (d.getIdDonasi().equalsIgnoreCase(id.trim())) {
                return true;
            }
        }
        return false;
    }

    public void tambahDonasiPakaian(String id, String pendonor, String barang, int jumlah, String ukuran) {
        if (isIdExist(id)) {
            throw new IllegalArgumentException("ID Donasi " + id + " sudah digunakan!");
        }
        DonasiPakaian p = new DonasiPakaian(id, pendonor, barang, jumlah, ukuran);
        daftarDonasi.add(p);
    }

    public void tambahDonasiElektronik(String id, String pendonor, String barang, int jumlah, String merek, boolean berfungsi) {
        if (isIdExist(id)) {
            throw new IllegalArgumentException("ID Donasi " + id + " sudah digunakan!");
        }
        DonasiElektronik e = new DonasiElektronik(id, pendonor, barang, jumlah, merek, berfungsi);
        daftarDonasi.add(e);
    }

    public void ubahDonasiPakaian(int index, String pendonorBaru, String barangBaru, int jumlahBaru, String ukuranBaru) {
        Donasi d = daftarDonasi.get(index);
        if (!(d instanceof DonasiPakaian)) {
            throw new IllegalArgumentException("Tipe objek tidak sesuai!");
        }

        // Pengubahan dilakukan bersamaan (atomic update) setelah validasi instansiasi berhasil
        DonasiPakaian pBaru = new DonasiPakaian(d.getIdDonasi(), pendonorBaru, barangBaru, jumlahBaru, ukuranBaru);
        daftarDonasi.set(index, pBaru);
    }

    public void ubahDonasiElektronik(int index, String pendonorBaru, String barangBaru, int jumlahBaru, String merekBaru, boolean berfungsiBaru) {
        Donasi d = daftarDonasi.get(index);
        if (!(d instanceof DonasiElektronik)) {
            throw new IllegalArgumentException("Tipe objek tidak sesuai!");
        }

        DonasiElektronik eBaru = new DonasiElektronik(d.getIdDonasi(), pendonorBaru, barangBaru, jumlahBaru, merekBaru, berfungsiBaru);
        daftarDonasi.set(index, eBaru);
    }

    public boolean hapusDonasi(int index) {
        if (index >= 0 && index < daftarDonasi.size()) {
            daftarDonasi.remove(index);
            return true;
        }
        return false;
    }

    public List<Donasi> cariBerdasarkanPendonor(String nama) {
        List<Donasi> hasil = new ArrayList<>();
        for (Donasi d : daftarDonasi) {
            if (d.getNamaPendonor().toLowerCase().contains(nama.toLowerCase())) {
                hasil.add(d);
            }
        }
        return hasil;
    }
}