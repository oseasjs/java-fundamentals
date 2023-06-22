package com.java.fundamentals.designpatterns.creational.prototype;

import java.util.Hashtable;

/**
 * Prototype pattern refers to creating duplicate object while keeping performance in mind.
 * This type of design pattern comes under creational pattern as this pattern provides one of the best ways to create an object.
 *
 * This pattern involves implementing a prototype interface which tells to create a clone of the current object.
 * This pattern is used when creation of object directly is costly. For example, an object is to be created after a costly database operation.
 * We can cache the object, returns its clone on next request and update the database as and when needed thus reducing database calls.
 */
public class PrototypeClonable {

    public static void main(String[] args) {
        ShapeCache.loadCache();

        Shape rectangle = ShapeCache.getShape(1);
        rectangle.draw();

        Shape square = ShapeCache.getShape(2);
        square.draw();
    }

}

abstract class Shape implements Cloneable {

    private int id;
    private ShapeTypeEnum shapeTypeEnum;

    public Shape(int id, ShapeTypeEnum shapeTypeEnum) {
        this.id = id;
        this.shapeTypeEnum = shapeTypeEnum;
    }
    abstract void draw();

    public int getId() {
        return id;
    }

    public ShapeTypeEnum getShapeTypeEnum() {
        return shapeTypeEnum;
    }

    @Override
    protected Object clone() {
        Object obj = null;
        try {
            obj = super.clone();
        }
        catch (CloneNotSupportedException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return obj;
    }
}

enum ShapeTypeEnum {
    RECTANGLE, SQUARE;
}

class Rectangle extends Shape {
    public Rectangle(int id) {
        super(id, ShapeTypeEnum.RECTANGLE);
    }

    @Override
    public void draw() {
        System.out.println("Shape: " + this.getShapeTypeEnum());
    }
}

class Square extends Shape {
    public Square(int id) {
        super(id, ShapeTypeEnum.SQUARE);
    }

    @Override
    public void draw() {
        System.out.println("Shape: " + this.getShapeTypeEnum());
    }
}

class ShapeCache {

    private static Hashtable<Integer, Shape> shapeMap = new Hashtable<>();

    public static Shape getShape(Integer shapeId) {
        Shape shape = shapeMap.get(shapeId);
        return (Shape) shape.clone();
    }

    public static void loadCache() {
        Shape rectangle = new Rectangle(1);
        Shape square = new Square(2);

        shapeMap.put(rectangle.getId(), rectangle);
        shapeMap.put(square.getId(), square);
    }

}
