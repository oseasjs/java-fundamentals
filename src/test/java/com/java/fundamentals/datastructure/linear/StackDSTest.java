package com.java.fundamentals.datastructure.linear;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class StackDSTest {

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void testIsEmptySuccessfully() {
        StackDS stack = new StackDS(0);
        Assert.assertTrue(stack.isEmpty());
    }

    @Test
    public void testIsFullSuccessfully() {
        StackDS stack = new StackDS(1);
        stack.push(10);
        Assert.assertTrue(stack.isFull());
    }

    @Test
    public void testIsNotEmptyAfterPushSuccessfully() {
        StackDS stack = new StackDS(1);
        stack.push(10);
        Assert.assertFalse(stack.isEmpty());
    }

    @Test
    public void testIsNotFullAfterPushOneSuccessfully() {
        StackDS stack = new StackDS(2);
        stack.push(10);
        Assert.assertFalse(stack.isFull());
    }

    @Test
    public void testPopOnEmptyStackSuccessfully() {
        expectedEx.expect(RuntimeException.class);
        expectedEx.expectMessage("Stack is empty");

        StackDS stack = new StackDS(0);
        stack.pop();
        Assert.fail("Not expect this line execution");
    }

    @Test
    public void testPopBeforePushAnySuccessfully() {
        expectedEx.expect(RuntimeException.class);
        expectedEx.expectMessage("Stack is empty");

        StackDS stack = new StackDS(1);
        stack.pop();
        Assert.fail("Not expect this line execution");
    }

    @Test
    public void testPopAfterPushOneSuccessfully() {
        StackDS stack = new StackDS(1);
        stack.push(10);
        Assert.assertEquals(10, stack.pop());
    }

    @Test
    public void testPopAfterPushTwoSuccessfully() {
        StackDS stack = new StackDS(2);
        stack.push(10);
        stack.push(20);
        Assert.assertEquals(20, stack.pop());
    }

    @Test
    public void testPushWhenStackIsFullSuccessfully() {

        expectedEx.expect(RuntimeException.class);
        expectedEx.expectMessage("Stack is full");

        StackDS stack = new StackDS(1);
        stack.push(10);
        stack.push(20);

        Assert.fail("Not expect this line execution");
    }
}
