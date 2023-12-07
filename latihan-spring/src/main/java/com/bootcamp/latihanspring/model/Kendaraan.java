package com.bootcamp.latihanspring.model;

public class Kendaraan {
    private String nama_k;
    private String jenis_k;
    private Integer roda;
    private String plat_nomer;
    private String warna;
    private String bahan_bakar;
    private Integer cc;
    private Integer harga;

    public String getNama_k() {
        return nama_k;
    }

    public void setNama_k(String nama_k) {
        this.nama_k = nama_k;
    }

    public String getJenis_k() {
        return jenis_k;
    }

    public void setJenis_k(String jenis_k) {
        this.jenis_k = jenis_k;
    }

    public Integer getRoda() {
        return roda;
    }

    public void setRoda(Integer roda) {
        this.roda = roda;
    }

    public String getPlat_nomer() {
        return plat_nomer;
    }

    public void setPlat_nomer(String plat_nomer) {
        this.plat_nomer = plat_nomer;
    }

    public String getWarna() {
        return warna;
    }

    public void setWarna(String warna) {
        this.warna = warna;
    }

    public String getBahan_bakar() {
        return bahan_bakar;
    }

    public void setBahan_bakar(String bahan_bakar) {
        this.bahan_bakar = bahan_bakar;
    }

    public Integer getCc() {
        return cc;
    }

    public void setCc(Integer cc) {
        this.cc = cc;
    }

    public Integer getHarga() {
        return harga;
    }

    public void setHarga(Integer harga) {
        this.harga = harga;
    }
}
