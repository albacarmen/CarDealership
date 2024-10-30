package com.pluralsight;

public class Vehicle {
    private String vin; // Changed to String for VIN format
    private int year;
    private String make;
    private String model;
    private String vehicletype;
    private String color;
    private int odometer;
    private double price;

    // Constructor
    public Vehicle(String vin, int year, String make, String model, String vehicletype, String color, int odometer, double price) {
        this.vin = vin;
        this.year = year;
        this.make = make;
        this.model = model;
        this.vehicletype = vehicletype;
        this.color = color;
        this.odometer = odometer;
        this.price = price;
    }

    // Getters and Setters
    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVehicletype() {
        return vehicletype;
    }

    public void setVehicletype(String vehicletype) {
        this.vehicletype = vehicletype;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("Vehicle [VIN=%s, Year=%d, Make=%s, Model=%s, Type=%s, Color=%s, Odometer=%d, Price=%.2f]",
                vin, year, make, model, vehicletype, color, odometer, price);
    }
}

