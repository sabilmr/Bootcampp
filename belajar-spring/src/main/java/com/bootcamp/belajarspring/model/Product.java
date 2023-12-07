package com.bootcamp.belajarspring.model;

public class Product {
    private int id;
    private String nama;
    private String description;
    private int price;
    private int quantity;

    public Product() {
    }

    public Product(int id, String nama, String description, int price, int quantity) {
        this.id = id;
        this.nama = nama;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
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
