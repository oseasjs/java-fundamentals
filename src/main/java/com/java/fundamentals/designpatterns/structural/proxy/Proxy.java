package com.java.fundamentals.designpatterns.structural.proxy;

/**
 * In proxy pattern, a class represents functionality of another class.
 * This type of design pattern comes under structural pattern.
 * In proxy pattern, we create object having original object to interface its functionality to outer world.
 */
public class Proxy {

    public static void main(String[] args) {
        Image image = new ProxyImage("file.xml");
        image.display();
    }

}

interface Image {
    void display();
}

class RealImage implements Image {

    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        System.out.println("Displaying " + fileName);
    }

}

class ProxyImage implements Image {

    private String fileName;
    private RealImage realImage;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }
}

