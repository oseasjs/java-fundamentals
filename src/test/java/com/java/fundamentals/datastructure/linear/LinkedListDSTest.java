package com.java.fundamentals.datastructure.linear;

import com.java.fundamentals.commons.LinkedListNode;
import org.junit.Assert;
import org.junit.Test;

public class LinkedListDSTest {

    @Test
    public void testWithoutHeadSuccessfully() {
        LinkedListDS linkedList = new LinkedListDS(null);
        Assert.assertNull(linkedList.getHead());
    }

    @Test
    public void testWithHeadSuccessfully() {
        LinkedListNode head = new LinkedListNode(10);
        LinkedListDS linkedList = new LinkedListDS(head);
        Assert.assertNotNull(linkedList.getHead());
        Assert.assertEquals(10, linkedList.getHead().getValue());
    }

    @Test
    public void testWithHeadAndWithoutNextSuccessfully() {
        LinkedListNode head = new LinkedListNode(10);
        LinkedListDS linkedList = new LinkedListDS(head);
        Assert.assertNull(linkedList.getHead().getNext());
    }

    @Test
    public void testWithHeadAndWithNextSuccessfully() {
        LinkedListNode head = new LinkedListNode(10);
        LinkedListNode second = new LinkedListNode(20);
        LinkedListNode third = new LinkedListNode(30);

        head.setNext(second);
        second.setNext(third);
        LinkedListDS linkedList = new LinkedListDS(head);

        Assert.assertNotNull(linkedList.getHead());
        Assert.assertEquals(10, linkedList.getHead().getValue());

        Assert.assertNotNull(linkedList.getHead().getNext());
        Assert.assertEquals(20, linkedList.getHead().getNext().getValue());

        Assert.assertNotNull(linkedList.getHead().getNext().getNext());
        Assert.assertEquals(30, linkedList.getHead().getNext().getNext().getValue());
    }
}
