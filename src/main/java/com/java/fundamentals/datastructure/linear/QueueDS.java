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

    public void print() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        System.out.println("Front Index: " + this.front);

        for (int i = this.front; i < this.rear; i++) {
            System.out.println(this.items[i] + "");
        }

        System.out.println("Rear Index: " + this.rear);
    }

    private void validate(boolean expected, boolean result) {
        if (result != expected)
            throw new RuntimeException(String.format("Invalid result. Expected %b, but found %b",
                expected, result));
    }

    private void validate(int expected, int result) {
        if (result != expected)
            throw new RuntimeException(String.format("Invalid result. Expected %d, but found %d",
                expected, result));
    }

    public static void main(String[] args) {

        QueueDS queue = new QueueDS(2);
        queue.push(10);
        queue.push(20);

        queue.validate(true, queue.isFull());
        queue.validate(false, queue.isEmpty());

        int result = queue.pull();
        queue.validate(10, result);
        queue.validate(false, queue.isFull());
        queue.validate(false, queue.isEmpty());

        result = queue.pull();
        queue.validate(20, result);
        queue.validate(false, queue.isFull());
        queue.validate(true, queue.isEmpty());

    }

}
