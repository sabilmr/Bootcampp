package com.bootcamp.belajarspring.model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

public class Hp {
    private int id;
    private String name;
    private String description;
    private int price;
    private int quantiry;

    public Hp() {
    }
    public Hp(int id, String name, String description, int price, int quantiry) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantiry = quantiry;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getQuantiry() {
        return quantiry;
    }

    public void setQuantiry(int quantiry) {
        this.quantiry = quantiry;
    }
}
