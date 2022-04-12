package com.example.listapp;

public class Product {
    private String name;
    private double price;
    private int imgResource;

    Product(String name, double price, int img){
        this.name = name;
        this.price = price;
        this.imgResource = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getImgResource() {
        return imgResource;
    }

    public void setImgResource(int imgResource) {
        this.imgResource = imgResource;
    }
}
