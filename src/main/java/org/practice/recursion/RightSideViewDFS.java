package org.practice.recursion;

import java.util.ArrayList;
import java.util.List;

public class RightSideViewDFS {

    List<Integer> result = new ArrayList<>();

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

        RightSideViewDFS rsv = new RightSideViewDFS();
        System.out.println(rsv.rightSideView(node1));

    }

    public List<Integer> rightSideView(TreeNode root) {
        preorder(root, 0);
        return result;
    }
    private void preorder(TreeNode node, int level) {
        if (node == null) {
            return;
        }
        if (level >= result.size()) {
            result.add(node.val);
        }
        preorder(node.right, level + 1);
        preorder(node.left, level + 1);
    }
}
