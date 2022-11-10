package org.practice.recursion;

public class BinaryTreeDepth2 {
    public static void main(String[] args) {
        TreeNode node7 = new TreeNode(7);
        TreeNode node15 = new TreeNode(15);
        TreeNode node20 = new TreeNode(20, node15, node7);
        TreeNode node9 = new TreeNode(9);
        TreeNode root = new TreeNode(3, node9, node20);
        BinaryTreeDepth2 btd = new BinaryTreeDepth2();
        System.out.println("Depth of the tree is: " + btd.maxDepth(root, 0));
    }

    private int maxDepth(TreeNode node, int count) {
        // Return 0 if the tree is null
        if (node == null) {
            return count;
        }
        count++;
        // Initialize the tree traversal with current depth 1 and max depath 1
        return Math.max(maxDepth(node.left, count), maxDepth(node.right, count));
    }

}
