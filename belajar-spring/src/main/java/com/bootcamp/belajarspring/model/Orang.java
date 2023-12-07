package com.bootcamp.belajarspring.model;

public class Orang {
    private Integer id;
    private String name;
    private String gender;
    private String addres;

    public Orang(Integer id, String name, String gender, String addres) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.addres = addres;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }
}
