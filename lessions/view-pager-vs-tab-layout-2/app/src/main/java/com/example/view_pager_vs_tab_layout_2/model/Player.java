package com.example.view_pager_vs_tab_layout_2.model;

public class Player {
    private int avatar;
    private int name;
    private double price;
    private String description;

    public Player() {
    }

    public Player(int avatar, int name, double price, String description) {
        this.avatar = avatar;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
