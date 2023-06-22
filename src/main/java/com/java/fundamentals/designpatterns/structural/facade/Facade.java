package com.java.fundamentals.designpatterns.structural.facade;

/**
 * Facade pattern hides the complexities of the system and provides an interface to the client using which the client can access the system.
 * This type of design pattern comes under structural pattern as this pattern adds an interface to existing system to hide its complexities.
 * This pattern involves a single class which provides simplified methods required by client and delegates calls to methods of existing system classes.
 */
public class Facade {

    public static void main(String[] args) {
        ShapeFacade facade = new ShapeFacade();
        facade.drawRectangle();
        facade.drawSquare();
        facade.drawCircle();
    }

}

interface Shape {
    void draw();
}

class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing Rectangle");
    }
}

class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing Square");
    }
}

class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing Circle");
    }
}

class ShapeFacade {
    private Shape rectangle;
    private Shape square;
    private Shape circle;

    public ShapeFacade() {
        rectangle = new Rectangle();
        square = new Square();
        circle = new Circle();
    }

    public void drawRectangle() {
        rectangle.draw();
    }

    public void drawSquare() {
        square.draw();
    }

    public void drawCircle() {
        circle.draw();
    }
}
