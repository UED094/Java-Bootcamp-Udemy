package src.main.model.account;

import java.text.DecimalFormat;
import java.util.Objects;

public abstract class Account {
    private String id;
    private String name;
    private double balance;

    public abstract void deposit(double amount);

    public abstract boolean withdraw(double amount);

    public abstract Account clone();

    public Account() {
    }

    public Account(String id, String name, double balance) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("id cannot be null/blank!");
        }
        if (name == null || id.isBlank()) {
            throw new IllegalArgumentException("name cannot be null/blank");
        }

        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public Account(Account source) {
        this.id = source.id;
        this.name = source.name;
        this.balance = source.balance;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("id cannot be null/blank!");
        }
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name == null || id.isBlank()) {
            throw new IllegalArgumentException("name cannot be null/blank");
        }
        this.name = name;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Account id(String id) {
        setId(id);
        return this;
    }

    public Account name(String name) {
        setName(name);
        return this;
    }

    public Account balance(double balance) {
        setBalance(balance);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Account)) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(id, account.id) && Objects.equals(name, account.name) && balance == account.balance;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, balance);
    }

    @Override
    public String toString() {
        return (this.getClass().getSimpleName()) + "    " +
                "\t" + this.getId() + "" +
                "\t" + this.getName() + "" +
                "\t$" + this.getBalance() + "";
    }

    protected double round(double amount) {
        DecimalFormat formatter = new DecimalFormat("#.##");
        return Double.parseDouble(formatter.format(amount));
    }

}
