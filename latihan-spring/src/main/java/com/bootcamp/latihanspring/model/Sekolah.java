package com.bootcamp.latihanspring.model;

public class Sekolah {
    private int id;
    private String namaSekolah;
    private String rengkingSekolah;
    private String lokasiSekolah;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamaSekolah() {
        return namaSekolah;
    }

    public void setNamaSekolah(String namaSekolah) {
        this.namaSekolah = namaSekolah;
    }

    public String getRengkingSekolah() {
        return rengkingSekolah;
    }

    public void setRengkingSekolah(String rengkingSekolah) {
        this.rengkingSekolah = rengkingSekolah;
    }

    public String getLokasiSekolah() {
        return lokasiSekolah;
    }

    public void setLokasiSekolah(String lokasiSekolah) {
        this.lokasiSekolah = lokasiSekolah;
    }
}
