package com.yogesh.bst;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KthSmallestElementTest {
    @Test
    public void testExample1() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        int k = 1;
        int expected = 1;
        assertEquals(expected, new KthSmallestElement().kthSmallest(root, k));
    }

    @Test
    public void testExample2() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);
        int k = 3;
        int expected = 3;
        assertEquals(expected, new KthSmallestElement().kthSmallest(root, k));
    }

    @Test
    public void testSingleNode() {
        TreeNode root = new TreeNode(1);
        int k = 1;
        int expected = 1;
        assertEquals(expected, new KthSmallestElement().kthSmallest(root, k));
    }

    @Test
    public void testAllLeftSubtree() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(2);
        root.left.left.left.left = new TreeNode(1);
        int k = 2;
        int expected = 2;
        assertEquals(expected, new KthSmallestElement().kthSmallest(root, k));
    }

    @Test
    public void testAllRightSubtree() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(4);
        root.right.right.right.right = new TreeNode(5);
        int k = 4;
        int expected = 4;
        assertEquals(expected, new KthSmallestElement().kthSmallest(root, k));
    }

    @Test
    public void testBalancedBST() {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        int k = 5;
        int expected = 5;
        assertEquals(expected, new KthSmallestElement().kthSmallest(root, k));
    }
}
