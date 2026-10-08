# Mini Project 3 - Sistem Donasi Barang Bekas

**Nama Repository**: `Minpro-3-PBO-SistemDonasiBarangBekas`

**Nama**: Farrel Fazzadinata Sumarna

**NIM** : 2509116111

**Kelas** : C'25

---

## 1. Deskripsi Singkat Program
Program **Sistem Donasi Barang Bekas** adalah aplikasi berbasis Console Java yang mengelola pencatatan barang donasi dari masyarakat. Program mendukung operasi CRUD (*Create, Read, Update, Delete*) serta fitur pencarian donasi. Sistem membagi kategori donasi menjadi dua jenis barang, yaitu **Pakaian** dan **Elektronik**.

---

## 2. Penjelasan Struktur Package
Proyek ini menerapkan pola arsitektur **MVC (Model-View-Controller)** untuk memisahkan tanggung jawab kode secara terstruktur:

1. `model`:
   - `Donasi.java`: Abstract class dasar untuk entitas donasi.
   - `DonasiPakaian.java` & `DonasiElektronik.java`: Subclass spesifik entitas barang.
   - `StatusDonasi.java`: Interface penyedia kontrak status kelayakan donasi.
2. `controller`:
   - `DonasiController.java`: Mengelola logika bisnis, penyimpanan data berbasis `ArrayList`, serta manipulasi data CRUD.
3. `view`:
   - `DonasiView.java`: Menangani antarmuka CLI, menampilkan menu, dan memvalidasi masukan (*input*) dari pengguna.
4. `main`:
   - `MainApp.java`: Class utama (*entry point*) yang menjalankan aplikasi.

---

## 3. Penjelasan Alur Program
1. **Inisialisasi**: Program dimulai melalui `MainApp.java` yang memanggil `DonasiView.start()`. Controller dimuat dan menginisialisasi data awal (dummy data).
2. **Menu Utama**: Pengguna disajikan 6 pilihan menu utama (Tambah, Tampilkan, Ubah, Hapus, Cari, Keluar).
3. **Tambah Data**: Pengguna memilih jenis donasi (Pakaian/Elektronik). Sistem memvalidasi keunikan ID dan atribut spesifik sebelum disimpan ke list melalui Controller.
4. **Tampilkan Data**: Mengiterasi seluruh objek donasi dan memanfaatkan *polymorphism* untuk mencetak format spesifik tiap kategori.
5. **Ubah Data**: Pengguna memilih nomor data. Validasi input dilakukan terlebih dahulu secara utuh (*atomic update*). Apabila input valid, Controller memperbarui data secara menyeluruh sehingga tidak ada data setengah-terubah saat terjadi kesalahan.
6. **Hapus Data**: Menghapus data terpilih setelah dikonfirmasi oleh pengguna.
7. **Cari Data**: Mencari donasi berdasarkan nama pendonor dan menampilkan detail spesifik menggunakan method getter.

---

## 4. Penjelasan Penerapan Encapsulation dan Inheritance
* **Encapsulation**:
  * Seluruh atribut entitas diset bertipe `private` (`idDonasi`, `namaPendonor`, `namaBarang`, `jumlahBarang`, `ukuran`, `merek`, `masihBerfungsi`).
  * Akses data dialirkan melalui method `getter` dan `setter` yang dilengkapi pengecekan/validasi (misal jumlah barang tidak boleh < 1, teks tidak boleh kosong).
* **Inheritance**:
  * Class `DonasiPakaian` dan `DonasiElektronik` menurunkan (*extends*) class induk `Donasi`. Subclass mewarisi seluruh atribut dasar serta method dari class induk.

---

## 5. Penjelasan Penerapan Polymorphism dan Abstraction
* **Abstraction**:
  * Class `Donasi` dideklarasikan sebagai `abstract class` sehingga tidak dapat diinstansiasi secara langsung.
  * Class `Donasi` memiliki *abstract method* `getKategori()` dan `getDetailRincian()` yang wajib diimplementasikan oleh `DonasiPakaian` dan `DonasiElektronik`.
* **Polymorphism**:
  * **Overriding**:
    * Method `tampilkanInfo()`, `getKategori()`, dan `getDetailRincian()` di-override pada subclass `DonasiPakaian` dan `DonasiElektronik` untuk menyesuaikan tampilan data spesifik.
  * **Overloading**:
    * Overloading Constructor pada class `Donasi` (constructor dengan 3 parameter & 4 parameter).
    * Overloading Method `tampilkanInfo()` pada `Donasi`:
      * `tampilkanInfo()`
      * `tampilkanInfo(int nomor)`
      * `tampilkanInfo(String header)`

---

## 6. Penjelasan Letak Penerapan Nilai Tambah
* **Penerapan Interface**:
  * Dibuat interface `StatusDonasi.java` di package `model` dengan method kontrak `cekKelayakanPenyaluran()` dan `isSiapDisalurkan()`.
  * Class `Donasi` meng-implement interface `StatusDonasi`, sehingga subclass secara otomatis mengimplementasikan aturan pengecekan kelayakan barang (contoh: barang elektronik diperiksa berdasarkan kondisi berfungsi/tidaknya).
  * <img width="246" height="56" alt="image" src="https://github.com/user-attachments/assets/c53a0165-ae73-487e-a571-e0743c3658da" />


---

## 7. Contoh Output Program & Dokumentasi Screenshot

### A. Tampilan Menu Utama & Menampilkan Data Donasi
<img width="714" height="229" alt="image" src="https://github.com/user-attachments/assets/844e336c-9e38-4135-9a76-5698eb73be40" />

### B. Tambah Data Donasi Baru
<img width="226" height="218" alt="image" src="https://github.com/user-attachments/assets/5ac586ef-a0d1-4a2d-b26c-76adbf12528f" />

### C. Mengubah Data Donasi (Update Safely)
<img width="210" height="71" alt="image" src="https://github.com/user-attachments/assets/269ab176-9daf-4b0d-979a-34b61db70ec4" />

### D. Pencarian Donasi berdasarkan Nama Pendonor
<img width="426" height="379" alt="WhatsApp Image 2026-10-08 at 22 19 14" src="https://github.com/user-attachments/assets/9f91a759-00c4-4e81-907e-0d9fc5fcffaa" />

### E. Menghapus Data Donasi
<img width="1438" height="595" alt="WhatsApp Image 2026-10-08 at 22 21 16" src="https://github.com/user-attachments/assets/36337abd-57e0-42e7-bba0-3b52587a67ce" />


