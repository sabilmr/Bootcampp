package com.bootcamp.latihanspring.model;

public class Hp {
    private String name_hp;
    private Integer ram;
    private String prosesor;
    private String color;
    private Integer price;
    private Integer quantity;

    public String getName_hp() {
        return name_hp;
    }

    public void setName_hp(String name_hp) {
        this.name_hp = name_hp;
    }

    public Integer getRam() {
        return ram;
    }

    public void setRam(Integer ram) {
        this.ram = ram;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getProsesor() {
        return prosesor;
    }

    public void setProsesor(String prosesor) {
        this.prosesor = prosesor;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
