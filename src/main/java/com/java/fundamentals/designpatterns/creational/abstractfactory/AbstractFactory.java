package com.java.fundamentals.designpatterns.creational.abstractfactory;

/**
 * Abstract Factory patterns work around a super-factory which creates other factories.
 * This factory is also called as factory of factories.
 * This type of design pattern comes under creational pattern as this pattern provides one of the best ways to create an object.
 *
 * In Abstract Factory pattern an interface is responsible for creating a factory of related objects without explicitly specifying their classes.
 * Each generated factory can give the objects as per the Factory pattern.
 */
public class AbstractFactory {
    public static void main(String[] args) {
        ShapeAbstractFactory normalShapeAbstractFactory = FactoryProducer.getFactory(ShapeFactoryTypeEnum.NORMAL);
        IShape normalRectangle = normalShapeAbstractFactory.getShape(ShapeTypeEnum.RECTANGLE);
        normalRectangle.draw();
        IShape normalSquare = normalShapeAbstractFactory.getShape(ShapeTypeEnum.SQUARE);
        normalSquare.draw();

        ShapeAbstractFactory roundedShapeAbstractFactory = FactoryProducer.getFactory(ShapeFactoryTypeEnum.ROUNDED);
        IShape roundedRectangle = roundedShapeAbstractFactory.getShape(ShapeTypeEnum.ROUNDED_RECTANGLE);
        roundedRectangle.draw();
        IShape roundedSquare = roundedShapeAbstractFactory.getShape(ShapeTypeEnum.ROUNDED_SQUARE);
        roundedSquare.draw();
    }
}

interface IShape {
    void draw();
}

class Rectangle implements IShape {
    public void draw() {
        System.out.println("Rectangle draw");
    }
}

class Square implements IShape {
    public void draw() {
        System.out.println("Square draw");
    }
}

class RoundedRectangle implements IShape {
    public void draw() {
        System.out.println("RoundedRectangle draw");
    }
}

class RoundedSquare implements IShape {
    public void draw() {
        System.out.println("RoundedSquare draw");
    }
}

enum ShapeTypeEnum {
    RECTANGLE, ROUNDED_RECTANGLE, SQUARE, ROUNDED_SQUARE;
}

abstract class ShapeAbstractFactory {
    abstract IShape getShape(ShapeTypeEnum shapeType);
}
class NormalShapeFactory extends ShapeAbstractFactory {
    public IShape getShape(ShapeTypeEnum shapeType) {
        switch (shapeType) {
            case RECTANGLE: return new Rectangle();
            case SQUARE: return new Square();
            default: return null;
        }
    }
}

class RoundedShapeFactory extends ShapeAbstractFactory {
    public IShape getShape(ShapeTypeEnum shapeType) {
        switch (shapeType) {
            case ROUNDED_RECTANGLE: return new RoundedRectangle();
            case ROUNDED_SQUARE: return new RoundedSquare();
            default: return null;
        }
    }
}

enum ShapeFactoryTypeEnum {
    NORMAL, ROUNDED;
}

class FactoryProducer {
    public static ShapeAbstractFactory getFactory(ShapeFactoryTypeEnum shapeFactoryTypeEnum) {
        switch (shapeFactoryTypeEnum) {
            case NORMAL: return new NormalShapeFactory();
            case ROUNDED: return new RoundedShapeFactory();
            default: return null;
        }
    }
}
