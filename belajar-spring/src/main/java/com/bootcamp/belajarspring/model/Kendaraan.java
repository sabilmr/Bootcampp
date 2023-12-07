package com.bootcamp.belajarspring.model;

public class Kendaraan {
    private String name_k;
    private String type_k;
    private int price;
    private int quantity;

    public Kendaraan(String name_k, String type_k, int price, int quantity) {
        this.name_k = name_k;
        this.type_k = type_k;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName_k() {
        return name_k;
    }

    public void setName_k(String name_k) {
        this.name_k = name_k;
    }

    public String getType_k() {
        return type_k;
    }

    public void setType_k(String type_k) {
        this.type_k = type_k;
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
