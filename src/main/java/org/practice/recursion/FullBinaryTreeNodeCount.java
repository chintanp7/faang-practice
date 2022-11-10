package org.practice.recursion;

public class FullBinaryTreeNodeCount {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);

        node1.setLeft(node2);
        node2.setLeft(node4);
        node2.setRight(node5);
        node1.setRight(node3);
        node3.setLeft(node6);

        FullBinaryTreeNodeCount fbtnc = new FullBinaryTreeNodeCount();
        System.out.println("No of nodes: " + fbtnc.countNodes(node1));
    }

    public int countNodes(TreeNode root) {
        // Handle null case and 0 height
        if (root == null) {
            return 0;
        }
        // Get tree height
        int height = height(root);
        if (height == 0) {
            return 1;
        }
        // Get upper count
        int upperCount = (int)(Math.pow(2, height) - 1);

        // for last row - get max available node - perform custom binary search
        // while left < right, get the middle element
        int left = 0, right = upperCount;
        while (left < right) {
            int indexToFind = (int) (Math.ceil((left + right) / 2.0));
            // check if node exists at that place and based on that adjust the left or right. Parmas: indextofind, height,
            if (nodeExists(indexToFind, height, root)) {
                left = indexToFind;
            } else {
                right = indexToFind - 1;
            }
        }
        return upperCount + left + 1;
    }

    private int height(TreeNode node) {
        int height = 0;
        while (node.left != null) {
            height++;
            node = node.left;
        }
        return height;
    }

    private boolean nodeExists(int indexToFind, int height, TreeNode root) {
        int count = 0;
        int left = 0;
        int right = (int) (Math.pow(2, height) - 1);

        while (count < height) {
            int mid = (int) (Math.ceil((left + right) / 2.0));
            if (indexToFind < mid) {
                root = root.left;
                right = mid - 1;
            } else {
                root = root.right;
                left = mid;
            }
            count++;
        }
        return root != null;
    }
}
