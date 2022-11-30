package com.java.fundamentals.datastructure.linear;

import com.java.fundamentals.commons.LinkedListNode;

public class LinkedListDS {

    private LinkedListNode head;

    public LinkedListDS(LinkedListNode head) {
        this.head = head;
    }

    public LinkedListNode getHead() {
        return head;
    }

    private void validate(LinkedListNode node, int expected) {
        int result = node.getValue();

        if (result != expected)
            throw new RuntimeException(String.format("Invalid result. Expected %d, but found %d",
                expected, result));
    }

    public static void main(String[] args) {

        LinkedListNode head = new LinkedListNode(10);
        LinkedListNode second = new LinkedListNode(20);
        LinkedListNode third = new LinkedListNode(30);

        head.setNext(second);
        second.setNext(third);
        LinkedListDS linkedList = new LinkedListDS(head);

        linkedList.validate(linkedList.getHead(), 10);
        linkedList.validate(linkedList.getHead().getNext(), 20);
        linkedList.validate(linkedList.getHead().getNext().getNext(), 30);

    }

}

