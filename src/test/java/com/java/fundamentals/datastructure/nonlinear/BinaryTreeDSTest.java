package com.java.fundamentals.datastructure.nonlinear;

import com.java.fundamentals.commons.BinaryTreeNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BinaryTreeDSTest {

    private static final String ROOT = "root";
    private static final String LEFT = "left";

    private static final String LEFT_1 = "left1";
    private static final String RIGHT = "right";

    private BinaryTreeNode root;
    private BinaryTreeNode left;

    private BinaryTreeNode left1;
    private BinaryTreeNode right;

    private BinaryTreeDS tree;

    @Before
    public void setup() {
        root = new BinaryTreeNode(ROOT);
        left = new BinaryTreeNode(LEFT);
        left1 = new BinaryTreeNode(LEFT_1);
        right = new BinaryTreeNode(RIGHT);

        tree = new BinaryTreeDS();
    }

    // Tree Transverse Pre Order Tests

    @Test
    public void testTreeTraversePreOrderWithRootNodeSuccessfully() {
        Assert.assertTrue(tree.traversePreOrder(root).contains(ROOT));
    }

    @Test
    public void testTreeTraversePreOrderWithRootAndLeftNodeSuccessfully() {
        root.setLeft(left);

        String[] expectedValues = tree.traversePreOrder(root).split(" ");

        Assert.assertEquals(2, expectedValues.length);
        Assert.assertEquals(ROOT,  expectedValues[0].trim());
        Assert.assertEquals(LEFT, expectedValues[1].trim());
    }

    @Test
    public void testTreeTraversePreOrderWithRootAndLeftAndRightNodeSuccessfully() {
        root.setLeft(left);
        root.setRight(right);

        String[] expectedValues = tree.traversePreOrder(root).split(" ");

        Assert.assertEquals(3, expectedValues.length);
        Assert.assertEquals(ROOT, expectedValues[0].trim());
        Assert.assertEquals(LEFT, expectedValues[1].trim());
        Assert.assertEquals(RIGHT, expectedValues[2].trim());
    }

    @Test
    public void testTreeTraversePreOrderWithRootAndLeftAndLeft1AndRightNodeSuccessfully() {

        left.setLeft(left1);
        root.setLeft(left);
        root.setRight(right);

        String[] expectedValues = tree.traversePreOrder(root).split(" ");

        Assert.assertEquals(4, expectedValues.length);
        Assert.assertEquals(ROOT, expectedValues[0].trim());
        Assert.assertEquals(LEFT, expectedValues[1].trim());
        Assert.assertEquals(LEFT_1, expectedValues[2].trim());
        Assert.assertEquals(RIGHT, expectedValues[3].trim());
    }

    // Tree Transverse In Order Tests

    @Test
    public void testTreeTraverseInOrderWithRootNodeSuccessfully() {
        Assert.assertTrue(tree.traverseInOrder(root).contains(ROOT));
    }

    @Test
    public void testTreeTraverseInOrderWithRootAndLeftNodeSuccessfully() {
        root.setLeft(left);

        String[] expectedValues = tree.traverseInOrder(root).split(" ");

        Assert.assertEquals(2, expectedValues.length);
        Assert.assertEquals(LEFT, expectedValues[0].trim());
        Assert.assertEquals(ROOT,  expectedValues[1].trim());
    }

    @Test
    public void testTreeTraverseInOrderWithRootAndLeftAndRightNodeSuccessfully() {

        root.setLeft(left);
        root.setRight(right);

        String[] expectedValues = tree.traverseInOrder(root).split(" ");

        Assert.assertEquals(3, expectedValues.length);
        Assert.assertEquals(LEFT, expectedValues[0].trim());
        Assert.assertEquals(ROOT, expectedValues[1].trim());
        Assert.assertEquals(RIGHT, expectedValues[2].trim());
    }

    @Test
    public void testTreeTraverseInOrderWithRootAndLeftAndLeft1AndRightNodeSuccessfully() {

        left.setLeft(left1);
        root.setLeft(left);
        root.setRight(right);

        String[] expectedValues = tree.traverseInOrder(root).split(" ");

        Assert.assertEquals(4, expectedValues.length);
        Assert.assertEquals(LEFT_1, expectedValues[0].trim());
        Assert.assertEquals(LEFT, expectedValues[1].trim());
        Assert.assertEquals(ROOT, expectedValues[2].trim());
        Assert.assertEquals(RIGHT, expectedValues[3].trim());
    }

    // Tree Transverse Post Order Tests

    @Test
    public void testTreeTraversePostOrderWithRootNodeSuccessfully() {
        Assert.assertTrue(tree.traversePostOrder(root).contains(ROOT));
    }

    @Test
    public void testTreeTraversePostOrderWithRootAndLeftNodeSuccessfully() {
        root.setLeft(left);

        String[] expectedValues = tree.traversePostOrder(root).split(" ");

        Assert.assertEquals(2, expectedValues.length);
        Assert.assertEquals(LEFT, expectedValues[0].trim());
        Assert.assertEquals(ROOT,  expectedValues[1].trim());

    }

    @Test
    public void testTreeTraversePostOrderWithRootAndLeftAndRightNodeSuccessfully() {

        root.setLeft(left);
        root.setRight(right);

        String[] expectedValues = tree.traversePostOrder(root).split(" ");

        Assert.assertEquals(3, expectedValues.length);
        Assert.assertEquals(LEFT, expectedValues[0].trim());
        Assert.assertEquals(RIGHT, expectedValues[1].trim());
        Assert.assertEquals(ROOT, expectedValues[2].trim());
    }

    @Test
    public void testTreeTraversePostOrderWithRootAndLeftAndLeft1AndRightNodeSuccessfully() {

        left.setLeft(left1);
        root.setLeft(left);
        root.setRight(right);

        String[] expectedValues = tree.traversePostOrder(root).split(" ");

        Assert.assertEquals(4, expectedValues.length);
        Assert.assertEquals(LEFT_1, expectedValues[0].trim());
        Assert.assertEquals(LEFT, expectedValues[1].trim());
        Assert.assertEquals(RIGHT, expectedValues[2].trim());
        Assert.assertEquals(ROOT, expectedValues[3].trim());
    }

}
