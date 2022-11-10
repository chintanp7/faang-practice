package org.practice.recursion;

import java.util.ArrayList;
import java.util.List;

public class ValidBST {

    List<Integer> list = new ArrayList<>();

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

        ValidBST validBST = new ValidBST();
        System.out.println(validBST.isValidBST(node4));
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        traverse(root);
        if (list.size() == 1) {
            return true;
        }
        int num = list.get(0);
        for (int j = 1; j < list.size(); j++) {
            if (list.get(j) < num) {
                return false;
            }
            num = list.get(j);
        }
        return true;
    }

    private void traverse(TreeNode node) {
        if (node == null) {
            return;
        }
        traverse(node.left);
        list.add(node.val);
        traverse(node.right);
    }
}
