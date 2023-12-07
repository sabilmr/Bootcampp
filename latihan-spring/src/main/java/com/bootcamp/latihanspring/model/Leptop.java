package com.bootcamp.latihanspring.model;
public class Leptop {
    private String nameLeptop;
    private String prosesor;
    private String ram;
    private String penyimpanan;
    private String batrai;
    private String warna;
    private int harga;

    public String getPenyimpanan() {
        return penyimpanan;
    }

    public void setPenyimpanan(String penyimpanan) {
        this.penyimpanan = penyimpanan;
    }

    public String getNameLeptop() {
        return nameLeptop;
    }

    public void setNameLeptop(String nameLeptop) {
        this.nameLeptop = nameLeptop;
    }

    public String getProsesor() {
        return prosesor;
    }

    public void setProsesor(String prosesor) {
        this.prosesor = prosesor;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getBatrai() {
        return batrai;
    }

    public void setBatrai(String batrai) {
        this.batrai = batrai;
    }

    public String getWarna() {
        return warna;
    }

    public void setWarna(String warna) {
        this.warna = warna;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }
}
