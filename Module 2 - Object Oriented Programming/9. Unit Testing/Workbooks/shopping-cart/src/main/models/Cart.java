package src.main.models;

import static org.junit.jupiter.api.DynamicTest.stream;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

import javax.xml.stream.StreamFilter;

public class Cart {
    ArrayList<Item> items;

    public Cart() {
        this.items = new ArrayList<Item>();
    }

    public Item getItem(int index) {
        return new Item(this.items.get(index));
    }

    public void setItem(int index, Item item) {
        this.items.set(index, new Item(item));
    }

    public boolean add(Item item) {
        if (this.items.contains(item)) {
            return false;
        } else {
            this.items.add(new Item(item));
            return true;
        }
    }

    public String toString() {
        String temp = "";
        for (int i = 0; i < this.items.size(); i++) {
            temp += this.items.get(i).toString();
            temp += "\n";
        }
        return temp;
    }

    public boolean contains(Item item) {
        return this.items.contains(item);
    }

    public void remove(String name) {
        this.items.removeIf(item -> item.getName().equals(name));
    }

    public double getSubtotal() {
        return this.items.stream().mapToDouble(item -> item.getPrice()).sum();
    }

    public double getTax(double subtotal) {
        DecimalFormat formatter = new DecimalFormat("#.##");
        return Double.parseDouble(formatter.format(subtotal * 0.13));
    }

    public double getTotal(double subtotal, double tax) {
        return subtotal + tax;
    }

}
