package org.practice.recursion;

import java.util.ArrayList;
import java.util.List;

public class LevelOrderTraversal {

    List<List<Integer>> orderList;

    public static void main(String[] args) {
        LevelOrderTraversal lot = new LevelOrderTraversal();
        System.out.println(lot.run());
    }

    private List<List<Integer>> run() {
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

        return levelOrder(node1);
    }

    private List<List<Integer>> levelOrder(TreeNode root) {
        // Get height of tree
        int height = height(root, 0);
        // Initiate the list of level order with the size of hieght
        orderList = new ArrayList<>(height);
        // Traverse the tree in DFS mode and keep adding the elements into the list
        traverse(root, 0);
        return orderList;
    }

    private void traverse(TreeNode node, int level) {
        // Terminate the recursion if reach to the null node
        if (node == null) {
            return;
        }
        // If orderList does not contain the sublist for given level, then add and empty sublist to the main list
        if (orderList.size() <= level || orderList.get(level) == null) {
            orderList.add(level, new ArrayList<>());
        }
        // Add the current element at its level's sublist
        orderList.get(level).add(node.getVal());
        // Traverse to the children
        traverse(node.left, level + 1);
        traverse(node.right, level + 1);
    }

    private int height(TreeNode node, int level) {
        if (node == null) {
            return level;
        }
        level++;
        return Math.max(height(node.left, level), height(node.right, level));
    }


}
