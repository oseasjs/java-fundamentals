package com.java.fundamentals.commons;

public class LinkedListNode {

    private int value;
    private LinkedListNode next;

    public LinkedListNode(int value) {
        this.value = value;
    }

    public void setNext(LinkedListNode next) {
        this.next = next;
    }

    public LinkedListNode getNext() {
        return next;
    }

    public int getValue() {
        return value;
    }
}
