package org.practice.recursion;

public class RightSidePriorityTraversal {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        node1.setLeft(node2);
        node1.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node4.setRight(node7);
        node7.setLeft(node8);
        node3.setRight(node6);

        RightSidePriorityTraversal rspt = new RightSidePriorityTraversal();
        System.out.print("Preorder: ");
        rspt.preorder(node1);
        System.out.println();
        System.out.print("Inorder: ");
        rspt.inorder(node1);
        System.out.println();
        System.out.print("Postorder: ");
        rspt.postorder(node1);
    }

    private void preorder(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + ", ");
        preorder(node.right);
        preorder(node.left);
    }

    private void inorder(TreeNode node) {
        if (node == null) {
            return;
        }
        inorder(node.right);
        System.out.print(node.val + ", ");
        inorder(node.left);
    }

    private void postorder(TreeNode node) {
        if (node == null) {
            return;
        }
        postorder(node.right);
        postorder(node.left);
        System.out.print(node.val + ", ");
    }
}
