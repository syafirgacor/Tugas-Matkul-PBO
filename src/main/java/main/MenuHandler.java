/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import util.InputHelper;

/**
 *
 * @author user
 */
public class MenuHandler {
    private final LayananPerpustakaan layanan;
    private final InputHelper input;

    public MenuHandler(LayananPerpustakaan layanan, InputHelper input) {
        this.layanan = layanan;
        this.input = input;
    }

    public void jalankan() {
        int pilihan = 0;
        do {
            tampilkanMenuUtama();
            pilihan = input.bacaInt("Pilih menu (1-7): ");

            switch (pilihan) {
                case 1 -> layanan.tampilkanKategori();
                case 2 -> layanan.tampilkanStatistik();
                case 3 -> menuLokasi();
                case 4 -> menuArrayList();
                case 5 -> menuQueue();
                case 6 -> menuStack();
                case 7 -> System.out.println("Terima kasih telah menggunakan sistem perpustakaan.");
                default -> System.out.println("Pilihan menu tidak valid!");
            }
        } while (pilihan != 7);
    }

    private void tampilkanMenuUtama() {
        System.out.println("\n=== SISTEM MANAJEMEN PERPUSTAKAAN KAMPUS ===");
        System.out.println("1. Tampilkan Kategori Buku (Array 1D)");
        System.out.println("2. Tampilkan Statistik Peminjaman (Array 2D)");
        System.out.println("3. Cek Lokasi Buku di Rak (Array 3D)");
        System.out.println("4. Kelola Daftar Buku Dinamis (ArrayList)");
        System.out.println("5. Kelola Antrean Peminjam (Queue - FIFO)");
        System.out.println("6. Kelola Riwayat & Undo Transaksi (Stack - LIFO)");
        System.out.println("7. Keluar");
    }

    private void menuLokasi() {
        System.out.println("\n--- CEK LOKASI BUKU (Array 3D) ---");
        int lt = input.bacaInt("Masukkan Lantai (0-1): ");
        int rk = input.bacaInt("Masukkan Nomor Rak (0-1): ");
        int ps = input.bacaInt("Masukkan Posisi Slot (0-2): ");
        layanan.cekLokasiBuku(lt, rk, ps);
    }

    private void menuArrayList() {
        System.out.println("\n--- KELOLA DAFTAR BUKU (ArrayList) ---");
        System.out.println("1. Tampilkan Buku");
        System.out.println("2. Tambah Buku");
        System.out.println("3. Hapus Buku");
        int sub = input.bacaInt("Pilih sub-menu: ");

        switch (sub) {
            case 1 -> layanan.tampilkanDaftarBuku();
            case 2 -> {
                String id = input.bacaString("Masukkan ID Buku: ");
                String judul = input.bacaString("Masukkan Judul Buku: ");
                layanan.tambahBuku(id, judul);
            }
            case 3 -> {
                int max = layanan.getJumlahBuku() - 1;
                int idx = input.bacaInt("Masukkan indeks buku yang akan dihapus (0 - " + max + "): ");
                layanan.hapusBuku(idx);
            }
            default -> System.out.println("Pilihan sub-menu tidak valid!");
        }
    }

    private void menuQueue() {
        System.out.println("\n--- ANTREAN PEMINJAMAN (Queue - FIFO) ---");
        System.out.println("1. Tambah Mahasiswa ke Antrean");
        System.out.println("2. Layani Mahasiswa Terdepan");
        System.out.println("3. Lihat Seluruh Antrean");
        int sub = input.bacaInt("Pilih sub-menu: ");

        switch (sub) {
            case 1 -> {
                String nama = input.bacaString("Masukkan Nama Mahasiswa: ");
                layanan.tambahAntrean(nama);
            }
            case 2 -> layanan.layaniAntrean();
            case 3 -> layanan.lihatAntrean();
            default -> System.out.println("Pilihan sub-menu tidak valid!");
        }
    }

    private void menuStack() {
        System.out.println("\n--- RIWAYAT & UNDO (Stack - LIFO) ---");
        System.out.println("1. Lihat Riwayat Transaksi Terakhir");
        System.out.println("2. Batalkan/Undo Transaksi Terakhir");
        int sub = input.bacaInt("Pilih sub-menu: ");

        if (sub == 1) {
            layanan.lihatRiwayat();
        } else if (sub == 2) {
            layanan.undoTransaksi();
        }
    }
}
