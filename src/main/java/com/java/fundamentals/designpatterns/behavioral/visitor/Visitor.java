package com.java.fundamentals.designpatterns.behavioral.visitor;

import java.util.Arrays;

/**
 * In Visitor pattern, we use a visitor class which changes the executing algorithm of an element class.
 * By this way, execution algorithm of element can vary as and when visitor varies.
 * This pattern comes under behavior pattern category.
 * As per the pattern, element object has to accept the visitor object so that visitor object handles the operation on the element object.
 */
public class Visitor {
    public static void main(String[] args) {
        IShoppingCartItem[] items = new IShoppingCartItem[] {
                new Book("Clean Code", 100),
                new Book("Clean Architecture", 120),
                new Fruit("Orange", 4, 0.8),
                new Fruit("Apple", 7, 1.2)
        };

        IShoppingCartVisitor shoppingCartVisitor = new ShoppingCartVisitorImpl();
        double total2 = Arrays.stream(items)
                .map(item -> item.accept(shoppingCartVisitor))
                .reduce((a, b) -> a + b).get();

        System.out.println("Total shopping cart: " + total2);
    }
}
interface IShoppingCartVisitor {
    double visit(Book book);
    double visit(Fruit fruit);
}

interface IShoppingCartItem {
    double accept(IShoppingCartVisitor visitor);
}

class Book implements IShoppingCartItem {

    private String name;
    private double price;

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public Book(String name, double price) {
        this.name = name;
        this.price = price;
    }
    @Override
    public double accept(IShoppingCartVisitor visitor) {
        return visitor.visit(this);
    }
}

class Fruit implements IShoppingCartItem {

    private String name;
    private double pricePerKg;
    private double weight;

    public String getName() {
        return name;
    }

    public double getPricePerKg() {
        return pricePerKg;
    }

    public double getWeight() {
        return weight;
    }

    public Fruit(String name, double pricePerKg, double weight) {
        this.name = name;
        this.pricePerKg = pricePerKg;
        this.weight = weight;
    }
    @Override
    public double accept(IShoppingCartVisitor visitor) {
        return visitor.visit(this);
    }
}

class ShoppingCartVisitorImpl implements IShoppingCartVisitor {
    @Override
    public double visit(Book book) {
        double cost = 0;
        if (book.getPrice() > 50) {
            cost = book.getPrice() - 5;
        }
        else {
            cost = book.getPrice();
        }
        System.out.println("Book " + book.getName() + " - price: " + cost);
        return cost;
    }

    @Override
    public double visit(Fruit fruit) {
        double cost = fruit.getPricePerKg() * fruit.getWeight();
        System.out.println("Fruit " + fruit.getName() + " - price: " + cost);
        return cost;
    }
}

