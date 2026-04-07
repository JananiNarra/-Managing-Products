package com.example.easy.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tasks")
public class Product {

    @Id
    private String id;
    private String name;
    private double price;
    private boolean inCart;

    public Product() {}

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
        this.inCart = false;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public boolean isInCart() { return inCart; }

    public void setName(String name) { this.name = name; }
    public void setPrice(double price) { this.price = price; }
    public void setInCart(boolean inCart) { this.inCart = inCart; }
}