package com.bootcamp.latihanspring.model;

public class Pesawat {
    private String namePesawat;
    private String arahPenerbangan;
    private String description;
    private int jumlahPenumpang;
    private int hargaTiket;

    public String getNamePesawat() {
        return namePesawat;
    }

    public void setNamePesawat(String namePesawat) {
        this.namePesawat = namePesawat;
    }

    public String getArahPenerbangan() {
        return arahPenerbangan;
    }

    public void setArahPenerbangan(String arahPenerbangan) {
        this.arahPenerbangan = arahPenerbangan;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getJumlahPenumpang() {
        return jumlahPenumpang;
    }

    public void setJumlahPenumpang(int jumlahPenumpang) {
        this.jumlahPenumpang = jumlahPenumpang;
    }

    public int getHargaTiket() {
        return hargaTiket;
    }

    public void setHargaTiket(int hargaTiket) {
        this.hargaTiket = hargaTiket;
    }
}
