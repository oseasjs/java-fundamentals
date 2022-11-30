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

    public void print() {
        String values = "";
        for (int i = 0; i <= this.top; i++) {
            values += this.array[i] + " ";
        }
        System.out.println(values);
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
        StackDS stack = new StackDS(3);
        stack.validate(true, stack.isEmpty());
        stack.push(10);

        stack.print();
        stack.validate(false, stack.isFull());
        stack.validate(false, stack.isEmpty());

        stack.push(20);
        stack.print();
        stack.validate(false, stack.isFull());
        stack.validate(false, stack.isEmpty());

        stack.push(30);
        stack.print();
        stack.validate(true, stack.isFull());

        int result = stack.pop();
        stack.print();
        stack.validate(false, stack.isFull());
        stack.validate(false, stack.isEmpty());
        stack.validate(30, result);

        result = stack.pop();
        stack.print();
        stack.validate(false, stack.isFull());
        stack.validate(false, stack.isEmpty());
        stack.validate(20, result);

        result = stack.pop();
        stack.print();
        stack.validate(false, stack.isFull());
        stack.validate(true, stack.isEmpty());
        stack.validate(10, result);

    }

}
