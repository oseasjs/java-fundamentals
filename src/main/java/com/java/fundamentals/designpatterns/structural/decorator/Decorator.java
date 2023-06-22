package com.java.fundamentals.designpatterns.structural.decorator;

/**
 * Decorator pattern allows a user to add new functionality to an existing object without altering its structure.
 * This type of design pattern comes under structural pattern as this pattern acts as a wrapper to existing class.
 * This pattern creates a decorator class which wraps the original class and provides additional functionality keeping class methods signature intact.
 */
public class Decorator {
    public static void main(String[] args) {
        RedShapeDecorator redShapeDecorator = new RedShapeDecorator(new Rectangle());
        redShapeDecorator.draw();

        GreenShapeDecorator greenShapeDecorator = new GreenShapeDecorator(new Circle());
        greenShapeDecorator.draw();
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

class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing Circle");
    }
}

class ShapeDecorator implements Shape {
    protected Shape decoratedShape;
    public ShapeDecorator(Shape shape) {
        this.decoratedShape = shape;
    }
    @Override
    public void draw() {
        this.decoratedShape.draw();
    }
}

class RedShapeDecorator extends ShapeDecorator {
    public RedShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw() {
        decoratedShape.draw();
        setRedBorder();
    }
    private void setRedBorder(){
        System.out.println("Border Color: Red");
    }
}

class GreenShapeDecorator extends ShapeDecorator {
    public GreenShapeDecorator(Shape shape) {
        super(shape);
    }

    @Override
    public void draw() {
        decoratedShape.draw();
        setGreenBorder();
    }

    private void setGreenBorder() {
        System.out.println("Border Color: Green");
    }
}

