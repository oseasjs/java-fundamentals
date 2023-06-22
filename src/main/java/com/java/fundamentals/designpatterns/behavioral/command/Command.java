package com.java.fundamentals.designpatterns.behavioral.command;

import java.util.ArrayList;
import java.util.List;

/**
 * Command pattern is a data driven design pattern and falls under behavioral pattern category.
 * A request is wrapped under an object as command and passed to invoker object.
 * Invoker object looks for the appropriate object which can handle this command and passes the command to the corresponding object which executes the command.
 */
public class Command {

    public static void main(String[] args) {
        Stock stock = new Stock("GOGL34");
        BuyStock buy10Stock = new BuyStock(stock, 10);
        BuyStock buy5Stock = new BuyStock(stock, 5);
        SellStock sell10Stock = new SellStock(stock, 10);

        Broker broker = new Broker();
        broker.takeOrder(buy10Stock);
        broker.takeOrder(buy10Stock);
        broker.takeOrder(buy5Stock);
        broker.takeOrder(sell10Stock);
        
        broker.placeOrders();

        System.out.println("Current position: Stock name: " + stock.getName() + " - quantity: " + stock.getQuantity());
    }
    
}

interface IOrder {
    void execute();
}

class SellStock implements IOrder {
    private Stock stock;
    private int quantity;
    public SellStock(Stock stock, int quantity) {
        this.stock = stock;
        this.quantity = quantity;
    }
    public void execute() {
        System.out.println("Sell Stock executed");
        this.stock.sell(quantity);
    }
}

class BuyStock implements IOrder {
    private Stock stock;
    private int quantity;
    public BuyStock(Stock stock, int quantity) {
        this.stock = stock;
        this.quantity = quantity;
    }

    @Override
    public void execute() {
        System.out.println("Buy Stock Executed");
        this.stock.buy(quantity);
    }
}

class Stock {
    private String name;
    private int quantity;

    public Stock(String name) {
        this.name = name;
        this.quantity = 0;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    void buy(int quantity) {
        this.quantity += quantity;
        System.out.println("Stock [name: " + name + ", quantity: " + quantity + " ] bought");
    }

    void sell(int quantity) {
        this.quantity -= quantity;
        System.out.println("Stock [name: " + name + ", quantity: " + quantity + " ] sold");
    }
}

class Broker {
    private List<IOrder> orderList = new ArrayList<>();

    public void takeOrder(IOrder order) {
        orderList.add(order);
    }

    public void placeOrders() {
        orderList.forEach(o -> o.execute());
        orderList.clear();
    }
}

