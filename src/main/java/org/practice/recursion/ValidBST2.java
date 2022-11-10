package org.practice.recursion;

public class ValidBST2 {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);

        node4.setLeft(node2);
        node4.setRight(node6);
        node2.setLeft(node1);
        node2.setRight(node3);
        node6.setLeft(node5);
        node6.setRight(node7);
        node7.setRight(node8);

        ValidBST2 validBST = new ValidBST2();
        System.out.println(validBST.isValidBST(node7));

    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return traverse(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean traverse(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }
        if (min < node.val && node.val < max) {
            return traverse(node.left, min, node.val) && traverse(node.right, node.val, max);
        } else {
            return false;
        }
    }
}
