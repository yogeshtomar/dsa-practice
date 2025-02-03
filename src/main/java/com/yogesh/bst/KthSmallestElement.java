package com.yogesh.bst;

public class KthSmallestElement {
    private int count = 0;
    private int result = 0;

    public int kthSmallest(TreeNode root, int k) {
        inOrderTraversal(root, k);
        return result;
    }

    private void inOrderTraversal(TreeNode node, int k) {
        if (node == null) {
            return;
        }

        // Traverse the left subtree
        inOrderTraversal(node.left, k);

        // Process the current node
        count++;
        if (count == k) {
            result = node.data;
            return; // Early exit once the kth smallest element is found
        }

        // Traverse the right subtree
        inOrderTraversal(node.right, k);
    }
}
