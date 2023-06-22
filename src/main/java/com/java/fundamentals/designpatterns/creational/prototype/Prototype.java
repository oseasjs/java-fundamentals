package com.java.fundamentals.designpatterns.creational.prototype;

/**
 * One of the ways we can implement this pattern in Java is by using the clone() method.
 * To do this, we'd implement the Cloneable interface.
 * When we're trying to clone, we should decide between making a shallow or a deep copy.
 * Eventually, it boils down to the requirements.
 *
 * For example, if the class contains only primitive and immutable fields, we may use a shallow copy.
 * If it contains references to mutable fields, we should go for a deep copy.
 * We might do that with copy constructors or serialization and deserialization.
 */
public class Prototype {

    public static void main(String[] args) {

        PlasticTree plasticTree = new PlasticTree(100);
        PlasticTree plasticTreeClone = (PlasticTree) plasticTree.copy();
        plasticTreeClone.setValue(200);

        System.out.println("PlasticTree original value: " + plasticTree.getValue() + " | value from cloned: " + plasticTreeClone.getValue());

    }

}

abstract class Tree {
    abstract Tree copy();
}

class PlasticTree extends Tree {
    private double value;

    public void setValue(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public PlasticTree(double value) {
        this.value = value;
    }

    @Override
    public Tree copy() {
        return new PlasticTree(this.value);
    }

}

