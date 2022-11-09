package com.java.fundamentals.commons;

public class BinaryTreeNode {

    private String key;
    private BinaryTreeNode left, right;

    public BinaryTreeNode(String key) {
        this.key = key;
    }

    public BinaryTreeNode(String key, BinaryTreeNode left, BinaryTreeNode right) {
        this.key = key;
        this.left = left;
        this.right = right;
    }

    public String getKey() {
        return key;
    }

    public BinaryTreeNode getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode left) {
        this.left = left;
    }

    public BinaryTreeNode getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode right) {
        this.right = right;
    }
}
