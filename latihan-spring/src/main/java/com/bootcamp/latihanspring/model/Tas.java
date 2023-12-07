package com.bootcamp.latihanspring.model;

public class Tas {
    private String nameMerk;
    private String warna;
    private String description;
    private int price;
    private int quantity;

    public String getNameMerk() {
        return nameMerk;
    }

    public void setNameMerk(String nameMerk) {
        this.nameMerk = nameMerk;
    }

    public String getWarna() {
        return warna;
    }

    public void setWarna(String warna) {
        this.warna = warna;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
