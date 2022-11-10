package org.practice.recursion;

public class BinaryTreeDepth {
    public static void main(String[] args) {
        TreeNode node7 = new TreeNode(7);
        TreeNode node15 = new TreeNode(15);
        TreeNode node20 = new TreeNode(20, node15, node7);
        TreeNode node9 = new TreeNode(9);
        TreeNode root = new TreeNode(3, node9, node20);
        BinaryTreeDepth btd = new BinaryTreeDepth();
        System.out.println("Depth of the tree is: " + btd.maxDepth(root));
    }

    private int maxDepth(TreeNode root) {
        // Return 0 if the tree is null
        if (root == null) {
            return 0;
        }

        // Initialize the tree traversal with current depth 1 and max depath 1
        return traverse(root, 1, 1);
    }

    private int traverse(TreeNode node, int depth, int maxDepth) {
        // if the left node is not null then traverse to left with depth increase by 1
        if (node.left != null) {
            maxDepth = traverse(node.left, depth + 1, maxDepth);
        }
        // if the right node is not null then traverse to right with depth increase by 1
        if (node.right != null) {
            maxDepth = traverse(node.right, depth + 1, maxDepth);
        }
        // If current depth is greater than maxDepth then replace maxDepth with current depth
        if (maxDepth < depth) {
            maxDepth = depth;
        }
        // return the maxDepth
        return maxDepth;
    }
}
