package com.java.fundamentals.datastructure.linear;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class QueueDSTest {

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void testIsEmptySuccessfully() {
        QueueDS queue = new QueueDS(0);
        Assert.assertTrue(queue.isEmpty());
    }

    @Test
    public void testIsFullSuccessfully() {
        QueueDS queue = new QueueDS(1);
        queue.push(10);
        Assert.assertTrue(queue.isFull());
    }

    @Test
    public void testIsNotEmptyAfterPushSuccessfully() {
        QueueDS queue = new QueueDS(1);
        queue.push(10);
        Assert.assertFalse(queue.isEmpty());
    }

    @Test
    public void testIsNotFullAfterPushOneSuccessfully() {
        QueueDS queue = new QueueDS(2);
        queue.push(10);
        Assert.assertFalse(queue.isFull());
    }

    @Test
    public void testPullOnEmptyQueueSuccessfully() {
        expectedEx.expect(RuntimeException.class);
        expectedEx.expectMessage("Queue is empty");

        QueueDS queue = new QueueDS(0);
        queue.pull();
        Assert.fail("Not expect this line execution");
    }

    @Test
    public void testPopBeforePushAnySuccessfully() {
        expectedEx.expect(RuntimeException.class);
        expectedEx.expectMessage("Queue is empty");

        QueueDS queue = new QueueDS(1);
        queue.pull();
        Assert.fail("Not expect this line execution");
    }

    @Test
    public void testPopAfterPushOneSuccessfully() {
        QueueDS queue = new QueueDS(1);
        queue.push(10);
        Assert.assertEquals(10, queue.pull());
    }

    @Test
    public void testPopAfterPushTwoSuccessfully() {
        QueueDS queue = new QueueDS(2);
        queue.push(10);
        queue.push(20);
        Assert.assertEquals(10, queue.pull());
    }

    @Test
    public void testPushWhenStackIsFullSuccessfully() {

        expectedEx.expect(RuntimeException.class);
        expectedEx.expectMessage("Queue is full");

        QueueDS queue = new QueueDS(1);
        queue.push(10);
        queue.push(20);

        Assert.fail("Not expect this line execution");
    }

}
