package com.java.fundamentals.datastructure.linear;

public class QueueDS {

    private int capacity;
    private int[] items;
    private int front, rear;

    public QueueDS(int size) {
        this.items = new int[size];
        this.capacity = size;
        this.front = -1;
        this.rear = -1;
    }

    public boolean isEmpty() {
        return this.front == -1;
    }

    public boolean isFull() {
        return this.front == 0 && this.rear == this.capacity -1;
    }

    public void push(int i) {
        if (isFull()) {
            throw new RuntimeException("Queue is full");
        }

        if (this.front == -1)
            this.front++;

        this.rear++;
        this.items[this.rear] = i;
    }

    public int pull() {
        int element;
        if (this.isEmpty())
            throw new RuntimeException("Queue is empty");
        else {

            element = this.items[front];

            if (this.front >= this.rear) {
                this.front = -1;
                this.rear = -1;
            }
            else
                this.front++;

        }

        return element;

    }

    public void display() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        System.out.println("Front Index: " + this.front);

        for (int i = this.front; i < this.rear; i++) {
            System.out.println(this.items[i] + "");
        }

        System.out.println("Rear Index: " + this.rear);
    }

}
