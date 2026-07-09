package com.example.demo_e18.models;

public class PlanetModel {
    private String name;
    private int totalMoon;
    private int image;

    public PlanetModel(String name, int totalMoon, int image) {
        this.name = name;
        this.totalMoon = totalMoon;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public int getTotalMoon() {
        return totalMoon;
    }

    public int getImage() {
        return image;
    }
}
