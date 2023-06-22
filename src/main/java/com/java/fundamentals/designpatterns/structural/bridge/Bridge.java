package com.java.fundamentals.designpatterns.structural.bridge;

/**
 * Bridge is used when we need to decouple an abstraction from its implementation so that the two can vary independently.
 * This type of design pattern comes under structural pattern as this pattern decouples implementation class and abstract class by providing a bridge structure between them.
 * This pattern involves an interface which acts as a bridge which makes the functionality of concrete classes independent from interface implementer classes.
 * Both types of classes can be altered structurally without affecting each other.
 */
public class Bridge {
    public static void main(String[] args) {
        Shape redCircle = new CircleBridge(100, 100, 1, new RedCircle());
        Shape greenCircle = new CircleBridge(100, 100, 1, new GreenCircle());
        redCircle.draw();
        greenCircle.draw();
    }
}

interface DrawAPI {
    void drawCircle(int radius, int x, int y);
}

class RedCircle implements DrawAPI {
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing circle [color: red, radius: " + radius + ", x: " + x + ", y: " + y);
    }
}

class GreenCircle implements DrawAPI {
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing circle [color: green, radius: " + radius + ", x: " + x + ", y: " + y);
    }
}

abstract class Shape {
    protected DrawAPI drawAPI;

    protected Shape(DrawAPI drawAPI) {
        this.drawAPI = drawAPI;
    }

    abstract void draw();
}

class CircleBridge extends Shape {

    private int radius;
    private int x;
    private int y;

    // Bridge using DrawAPI that could be an instance of RedCircle or GreenCircle
    public CircleBridge(int radius, int x, int y, DrawAPI drawAPI) {
        super(drawAPI);
        this.radius = radius;
        this.x = x;
        this.y = y;
    }

    @Override
    public void draw() {
        drawAPI.drawCircle(radius, x, y);
    }
}


