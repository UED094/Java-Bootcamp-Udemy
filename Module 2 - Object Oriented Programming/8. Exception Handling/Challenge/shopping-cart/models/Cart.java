package models;

import java.util.ArrayList;

public class Cart {
    private ArrayList<Item> items;

    public Cart() {
        this.items = new ArrayList<Item>();
    }

    public Cart(ArrayList<Item> items) {
        for (int i = 0; i < items.size(); i++) {
            this.items.add(new Item(items.get(i)));
        }
    }

    public Item getItem(int index) {
        return new Item(this.items.get(index));
    }

    public void setItem(int index, Item item) {
        this.items.set(index, new Item(item));
    }

    /**
     * Name: add
     * 
     * @param item
     * @return boolean
     *
     *         Inside the function:
     *         1. Adds an item to the cart if it wasn't already added.
     */
    public boolean add(Item item) {
        if (!(this.items.contains(item))) {
            this.items.add(new Item(item));
            return true;
        } else {
            return false;
        }
    }

    /**
     * Name: remove
     * 
     * @param name
     *
     *             Inside the function:
     *             1. Removes the item that matches the name passed in.
     */
    public void remove(String name) {
        if (this.items.isEmpty()) {
            throw new IllegalStateException("There is no item to be removed.");
        }
        for (int i = 0; i < this.items.size(); i++) {
            if (this.items.get(i).getName().equals(name)) {
                this.items.remove(i);
            }
        }
    }

    /**
     * Name: checkout
     * 
     * @return (String)
     *
     *         Inside the function:
     *         1. Calculates the subtotal (price before tax).
     *         2. Calculates the tax (assume tax is 13%).
     *         3. Calculates total: subtotal + tax
     *         4. Returns a String that resembles a receipt. See below.
     */
    public String checkout() {
        if (this.items.isEmpty()) {
            throw new IllegalStateException("There is no item to be checkout.");
        }
        double subtotal = 0;
        for (int i = 0; i < this.items.size(); i++) {
            subtotal += this.items.get(i).getPrice();
        }
        double tax = subtotal * 13 / 100;
        double total = subtotal + tax;

        return "\tRECEIPT\n\n" +
                "\tSubtotal: $" + subtotal + "\n" +
                "\tTax: $" + tax + "\n" +
                "\tTotal: $" + total + "\n";
    }

    @Override
    public String toString() {
        String temp = "";
        for (int i = 0; i < this.items.size(); i++) {
            temp += this.items.get(i) + "\n";
        }
        return temp;
    }

}
