package com.java.fundamentals.solid.lsp;

public class LiskovSubstitutionPrinciple {

    public static void main(String[] args) {

        RectangleWrong rectangleWrong = new RectangleWrong();
        rectangleWrong.setHeight(10);
        rectangleWrong.setWidth(12);
        rectangleWrong.getArea();

        SquareWrong squareWrong = new SquareWrong();
        squareWrong.setHeight(10);
        squareWrong.setWidth(10);
        squareWrong.getArea();

        // CORRECT: Immutable object approach will protect the object and Shape can substitute Rectangle
        Shape rectangle = new Rectangule(10, 12);
        rectangle.getArea();

        // CORRECT: Immutable object approach will protect the object and Shape can substitute Square
        Shape square = new Square(10);
        square.getArea();

    }
}

class RectangleWrong {

    private double height;
    private double width;

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getArea() {
        return height * width;
    }
}

class SquareWrong extends RectangleWrong {

    @Override
    public void setHeight(double height) {
        setHeight(height);
        setWidth(height);
    }

    @Override
    public void setWidth(double width) {
        setHeight(width);
        setWidth(width);
    }
}

interface Shape {
    double getArea();
}

class Rectangule implements Shape {

    private double height;
    private double width;

    public Rectangule(double height, double width) {
        this.height = height;
        this.width = width;
    }

    @Override
    public double getArea() {
        return height * width;
    }
}

class Square implements Shape {

    private double height;
    private double width;
    public Square(double size) {
        this.height = height;
        this.width = width;
    }

    @Override
    public double getArea() {
        return height * width;
    }
}



