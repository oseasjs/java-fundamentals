package com.java.fundamentals.datastructure.linear;

public class StackDS {

    private int[] array;
    private int capacity;
    private int top;

    public StackDS(int size) {
        this.array = new int[size];
        this.capacity = size;
        this.top = -1;
    }

    public boolean isFull() {
        return this.top == this.capacity-1;
    }

    public boolean isEmpty() {
        return this.top == -1;
    }

    public void push(int i) {
        if (isFull()) {
            throw new RuntimeException("Stack is full");
        }
        this.array[++top] = i;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return this.array[top--];
    }

    public void printStack() {
        String values = "";
        for (int i = 0; i <= this.top; i++) {
            values += this.array[i] + " ";
        }
        System.out.println(values);
    }

    public static void main(String[] args) {
        StackDS stack = new StackDS(3);
        stack.push(10);
        stack.printStack();
        stack.push(20);
        stack.printStack();
        stack.push(30);
        stack.printStack();
        stack.pop();
        stack.printStack();
    }

}
