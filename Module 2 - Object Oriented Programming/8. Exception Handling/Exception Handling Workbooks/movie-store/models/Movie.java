package models;

import javax.naming.ldap.SortControl;

public class Movie {
    private String name;
    private String format;
    private double rating;
    private double sellPrice;
    private double rentPrice;
    private boolean isAvailable;

    public Movie(String name, String format, double rating) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null/blank.");
        }
        if (!format.equalsIgnoreCase("Blue-Ray") && !format.equalsIgnoreCase("DVD")) {
            throw new IllegalArgumentException("Format should be either Blue-Ray or DVD");
        }
        if (rating < 0 || rating > 10) {
            throw new IllegalArgumentException("Rating should be between 0 to 10");
        }
        this.name = name;
        this.format = format;
        this.rating = rating;
        this.isAvailable = true;
        this.sellPrice = format.equals("Blue-Ray") ? 4.25 : 2.25;
        this.rentPrice = format.equals("Blue-Ray") ? 1.99 : 0.99;
    }

    public Movie(Movie source) {
        this.name = source.name;
        this.format = source.format;
        this.rating = source.rating;
        this.rentPrice = source.rentPrice;
        this.sellPrice = source.sellPrice;
        this.isAvailable = source.isAvailable;
    }

    public String getName() {
        return name;
    }

    public String getFormat() {
        return format;
    }

    public double getRating() {
        if (rating < 0 || rating > 10) {
            throw new IllegalArgumentException("Rating should be between 0 to 10");
        }
        return rating;
    }

    public double getRentPrice() {
        return rentPrice;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null/blank.");
        }
        this.name = name;
    }

    public void setFormat(String format) {
        if (!format.equalsIgnoreCase("Blue-Ray") || !format.equalsIgnoreCase("DVD")) {
            throw new IllegalArgumentException("Format should be either Blue-Ray or DVD");
        }
        this.format = format;
        setSellPrice(format.equals("Blue-Ray") ? 4.25 : 2.25);
        setRentPrice(format.equals("Blue-Ray") ? 1.99 : 0.99);
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    private void setRentPrice(double rentPrice) {
        this.rentPrice = rentPrice;
    }

    private void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public String toString() {
        return "\t Name: " + this.name + "\n" +

                "\t Format: " + this.format + "\n" +

                "\t Rating: " + this.rating + "\n" +

                "\t Selling Price: " + this.sellPrice + "\n" +

                "\t Rental Price: " + this.rentPrice + "\n" +

                "\t Availability: " + (isAvailable == true ? "in-stock" : "rented") + "\n";
    }

    // Status will be related to rent/in-stock default in stock maybe ?
    // Create a price variable depending on type.

}
