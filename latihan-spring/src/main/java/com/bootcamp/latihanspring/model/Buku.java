package com.bootcamp.latihanspring.model;

public class Buku {
    private String nameBuku;
    private int halamanBuku;
    private  String description;
    private int herga;
    private int jumlah;

    public String getNameBuku() {
        return nameBuku;
    }

    public void setNameBuku(String nameBuku) {
        this.nameBuku = nameBuku;
    }

    public int getHalamanBuku() {
        return halamanBuku;
    }

    public void setHalamanBuku(int halamanBuku) {
        this.halamanBuku = halamanBuku;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getHerga() {
        return herga;
    }

    public void setHerga(int herga) {
        this.herga = herga;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }
}
