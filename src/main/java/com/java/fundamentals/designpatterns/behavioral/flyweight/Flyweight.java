package com.java.fundamentals.designpatterns.behavioral.flyweight;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Flyweight pattern is primarily used to reduce the number of objects created and to decrease memory footprint and increase performance.
 * This type of design pattern comes under structural pattern as this pattern provides ways to decrease object count thus improving the object structure of application.
 * Flyweight pattern tries to reuse already existing similar kind objects by storing them and creates new object when no matching object is found.
 */
public class Flyweight {
    public static void main(String[] args) {
        final String[] colors = new String[]{"Yellow", "Green", "Blue", "Red", "Black"};

        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            String color = colors[random.nextInt(colors.length)];
            Circle circle = (Circle) ShapeFactory.getCircle(color);
            circle.setX(random.nextInt(100));
            circle.setY(random.nextInt(100));
            circle.setRadius(100);
            circle.draw();
        }
    }
}

interface Shape {
    void draw();
}

class Circle implements Shape {

    private String color;
    private int x;
    private int y;
    private int radius;

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public Circle(String color) {
        this.color = color;
    }

    @Override
    public void draw() {
        System.out.println("Circle: Draw() [Color=" + color + ", X=" + x + ", y=" + y + ", radius=" + radius + "]");
    }
}

class ShapeFactory {
    private static final Map<String, Shape> map = new HashMap<>();

    public static Shape getCircle(String color) {
        if (map.containsKey(color)) {
            return map.get(color);
        }

        Shape circle = new Circle(color);
        map.put(color, circle);
        return circle;
    }

}
