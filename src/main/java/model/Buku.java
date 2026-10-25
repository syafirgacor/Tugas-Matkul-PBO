/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author user
 */
public class Buku {
    private final String id;
    private final String judul;

    public Buku(String id, String judul) {
        this.id = id;
        this.judul = judul;
    }

    public String getId() { 
        return id; 
    }

    public String getJudul() { 
        return judul; 
    }

    @Override
    public String toString() {
        return "[" + id + "] " + judul;
    }
}
