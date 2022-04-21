package models;

public class Item {
    private String name;
    private double price;

    public Item(String name, double price) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null/blank.");
        }
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative.");
        }

        this.name = name;
        this.price = price;
    }

    public Item(Item source) {
        this.name = source.name;
        this.price = source.price;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null/blank.");
        }
        this.name = name;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative.");
        }
        this.price = price;
    }

    @Override
    public String toString() {
        return " name='" + getName() + "'" +
                ", price='" + getPrice() + "'";
    }
}
