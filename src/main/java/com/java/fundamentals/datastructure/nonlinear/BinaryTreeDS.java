package com.java.fundamentals.datastructure.nonlinear;

import com.java.fundamentals.commons.BinaryTreeNode;

public class BinaryTreeDS {

    public String traversePreOrder(BinaryTreeNode node) {
        if (node != null) {
            return new StringBuilder()
                .append(" " + node.getKey())
                .append(" " + traversePreOrder(node.getLeft()))
                .append(" " + traversePreOrder(node.getRight()))
                .toString().trim();
        }
        return "";
    }

    public String traverseInOrder(BinaryTreeNode node) {
        if (node != null) {
            return new StringBuilder()
                .append(" " + traverseInOrder(node.getLeft()))
                .append(" " + node.getKey())
                .append(" " + traverseInOrder(node.getRight()))
                .toString().trim();
        }
        return "";
    }

    public String traversePostOrder(BinaryTreeNode node) {
        if (node != null) {
            return new StringBuilder()
                .append(traversePostOrder(node.getLeft()) + " ")
                .append(traversePostOrder(node.getRight()) + " ")
                .append(node.getKey() + " ")
                .toString()
                .replaceAll("  ", " ")
                .trim();
        }
        return "";
    }

}
