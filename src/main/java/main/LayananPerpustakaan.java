/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import model.Buku;

/**
 *
 * @author user
 */
public class LayananPerpustakaan {
    private final String[] kategori1D;
    private final int[][] statistik2D;
    private final String[] namaHari;
    private final String[][][] lokasi3D;
    private final ArrayList<Buku> daftarBuku;
    private final Stack<String> riwayatStack;
    private final Queue<String> antreanQueue;

    public LayananPerpustakaan() {
        kategori1D = new String[]{"Pemrograman", "Matematika", "Jaringan Komputer", "Basis Data"};
        
        namaHari = new String[]{"Senin", "Selasa", "Rabu", "Kamis", "Jumat", "Sabtu", "Minggu"};
        statistik2D = new int[][]{
            {5, 3, 4, 6, 2, 0, 1},
            {2, 1, 3, 2, 4, 1, 0},
            {4, 2, 5, 3, 1, 0, 2},
            {1, 4, 2, 5, 3, 2, 1}
        };

        lokasi3D = new String[2][2][3];
        lokasi3D[0][0][0] = "Java Fundamentals";
        lokasi3D[0][0][1] = "Aljabar Linear";
        lokasi3D[0][0][2] = "Struktur Data";
        
        lokasi3D[0][1][0] = "Matematika Diskrit";
        lokasi3D[0][1][1] = "Kalkulus Lanjut";
        lokasi3D[0][1][2] = "Statistika & Probabilitas";
        
        lokasi3D[1][0][0] = "Jaringan Komputer Dasar";
        lokasi3D[1][0][1] = "Keamanan Siber";
        lokasi3D[1][0][2] = "Sistem Operasi";
        
        lokasi3D[1][1][0] = "Sistem Basis Data";
        lokasi3D[1][1][1] = "Desain Web & UI/UX";
        lokasi3D[1][1][2] = "Kecerdasan Buatan";

        daftarBuku = new ArrayList<>();
        daftarBuku.add(new Buku("B01", "Pemrograman Java"));
        daftarBuku.add(new Buku("B02", "Struktur Data & Algoritma"));

        riwayatStack = new Stack<>();
        antreanQueue = new LinkedList<>();
    }

    public void tampilkanKategori() {
        System.out.println("\n--- DAFTAR KATEGORI BUKU (Array 1D) ---");
        for (int i = 0; i < kategori1D.length; i++) {
            System.out.println((i + 1) + ". " + kategori1D[i]);
        }
    }

    public void tampilkanStatistik() {
        System.out.println("\n--- STATISTIK PEMINJAMAN PER HARI (Array 2D) ---");
        System.out.printf("%-20s", "Kategori");
        for (String hari : namaHari) {
            System.out.printf("%-8s", hari);
        }
        System.out.println();
        for (int i = 0; i < statistik2D.length; i++) {
            System.out.printf("%-20s", kategori1D[i]);
            for (int j = 0; j < statistik2D[i].length; j++) {
                System.out.printf("%-8d", statistik2D[i][j]);
            }
            System.out.println();
        }
    }

    public void cekLokasiBuku(int lantai, int rak, int posisi) {
        if (lantai >= 0 && lantai < 2 && rak >= 0 && rak < 2 && posisi >= 0 && posisi < 3) {
            String isi = lokasi3D[lantai][rak][posisi];
            if (isi != null) {
                System.out.println("Buku ditemukan: " + isi);
            } else {
                System.out.println("Slot lokasi ini masih kosong.");
            }
        } else {
            System.out.println("Indeks lokasi di luar jangkauan!");
        }
    }

    public void tampilkanDaftarBuku() {
        if (daftarBuku.isEmpty()) {
            System.out.println("Daftar buku kosong.");
        } else {
            for (Buku b : daftarBuku) {
                System.out.println(b);
            }
        }
    }

    public void tambahBuku(String id, String judul) {
        daftarBuku.add(new Buku(id, judul));
        System.out.println("Buku berhasil ditambahkan.");
    }

    public void hapusBuku(int index) {
        if (index >= 0 && index < daftarBuku.size()) {
            Buku removed = daftarBuku.remove(index);
            System.out.println("Buku '" + removed.getJudul() + "' berhasil dihapus.");
        } else {
            System.out.println("Indeks buku tidak valid!");
        }
    }

    public int getJumlahBuku() {
        return daftarBuku.size();
    }

    public void tambahAntrean(String nama) {
        antreanQueue.add(nama);
        System.out.println(nama + " masuk ke dalam antrean.");
    }

    public void layaniAntrean() {
        if (!antreanQueue.isEmpty()) {
            String dilayani = antreanQueue.poll();
            System.out.println("Melayani peminjaman untuk: " + dilayani);
            riwayatStack.push("Peminjaman oleh " + dilayani); // Otomatis mencatat transaksi ke Stack
        } else {
            System.out.println("Antrean kosong.");
        }
    }

    public void lihatAntrean() {
        System.out.println("Daftar Antrean (Depan -> Belakang): " + antreanQueue);
    }

    public void lihatRiwayat() {
        if (!riwayatStack.isEmpty()) {
            System.out.println("Transaksi Terakhir: " + riwayatStack.peek());
            System.out.println("Semua Riwayat Stack: " + riwayatStack);
        } else {
            System.out.println("Belum ada riwayat transaksi.");
        }
    }

    public void undoTransaksi() {
        if (!riwayatStack.isEmpty()) {
            String undone = riwayatStack.pop();
            System.out.println("Transaksi dibatalkan (Undo): " + undone);
        } else {
            System.out.println("Tidak ada transaksi untuk dibatalkan.");
            }
    }
    public void tampilkanSemuaLokasi() {
        System.out.println("\n--- PETA LOKASI PERPUSTAKAAN (Array 3D) ---");
        for (int i = 0; i < lokasi3D.length; i++) {
            System.out.println("Lantai " + (i + 1) + ":");
            for (int j = 0; j < lokasi3D[i].length; j++) {
                System.out.println("  Rak " + (j + 1) + ":");
                for (int k = 0; k < lokasi3D[i][j].length; k++) {
                    String buku = (lokasi3D[i][j][k] != null) ? lokasi3D[i][j][k] : "Kosong";
                    System.out.println("    [Slot " + k + "] -> " + buku);
}
            }
        }
    }
}