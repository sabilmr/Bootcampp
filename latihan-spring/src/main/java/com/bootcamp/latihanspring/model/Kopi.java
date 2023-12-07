package com.bootcamp.latihanspring.model;

public class Kopi {
    private String nameKopi;
    private String diproduksi;
    private String description;
    private int harga;
    private int jumlah;

    public String getNameKopi() {
        return nameKopi;
    }

    public void setNameKopi(String nameKopi) {
        this.nameKopi = nameKopi;
    }

    public String getDiproduksi() {
        return diproduksi;
    }

    public void setDiproduksi(String diproduksi) {
        this.diproduksi = diproduksi;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }
}
