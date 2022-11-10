package org.practice.recursion;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class RightSideViewBFS {

    // Initiate the result list and place holder queu
    List<Integer> result = new ArrayList<>();
    Queue<TreeNode> queue = new ArrayDeque<>();

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

        System.out.println(new RightSideViewBFS().rightSideView(node1));
    }

    public List<Integer> rightSideView(TreeNode root) {
        if (root != null) {
            // Add root node to queue to initiate
            queue.add(root);
            // traverse through the tree
            traverse();
        }
        // Return the result list
        return result;
    }

    private void traverse() {
        // Run while queue is not empty
        while (!queue.isEmpty()) {
            // Get the length of queue. This will return no of elements at current level
            int length = queue.size();
            TreeNode node = null;
            // Initiate the count = 1
            int count = 1;
            // While count is less or equal to the length...
            while (count <= length) {
                // Poll first element from queue and add its children at the end of queue
                node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                count++;
            }
            // Add the last node value at current level to the result list
            result.add(node.val);
        }
    }

}
