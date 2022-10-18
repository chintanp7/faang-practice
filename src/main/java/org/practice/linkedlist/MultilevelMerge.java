package org.practice.linkedlist;

import java.util.Stack;

public class MultilevelMerge {

    public static void main(String[] args) {
        MultilevelMerge multilevelMerge = new MultilevelMerge();
        multilevelMerge.go();
    }

    private void go() {
        DoublyLinkedNode node1 = new DoublyLinkedNode(1);
        DoublyLinkedNode node2 = new DoublyLinkedNode(2);
        DoublyLinkedNode node3 = new DoublyLinkedNode(3);
        DoublyLinkedNode node4 = new DoublyLinkedNode(4);
        DoublyLinkedNode node5 = new DoublyLinkedNode(5);
        DoublyLinkedNode node6 = new DoublyLinkedNode(6);
        DoublyLinkedNode node7 = new DoublyLinkedNode(7);
        DoublyLinkedNode node8 = new DoublyLinkedNode(8);
        DoublyLinkedNode node9 = new DoublyLinkedNode(9);
        DoublyLinkedNode node10 = new DoublyLinkedNode(10);
        DoublyLinkedNode node11 = new DoublyLinkedNode(11);
        DoublyLinkedNode node12 = new DoublyLinkedNode(12);
        DoublyLinkedNode node13 = new DoublyLinkedNode(13);

        node1.next = node2;
        node2.next = node3;
        node2.child = node7;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node7.next = node8;
        node8.next = node9;
        node8.child = node10;
        node10.next = node11;
        node5.child = node12;
        node12.next = node13;

        DoublyLinkedNode node = flatten(node1);
        print(node);
    }

    public DoublyLinkedNode flatten(DoublyLinkedNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null && head.child == null) {
            return head;
        }

        Stack<DoublyLinkedNode> nodeStack = new Stack<>();

        DoublyLinkedNode node = head;
        while (true) {
            if (node.child != null) {
                if (node.next != null) {
                    nodeStack.push(node.next);
                }
                node.next = node.child;
                node.child.prev = node;
                node.child = null;
            } else if (node.next == null) {
                if (!nodeStack.isEmpty()) {
                    node.next = nodeStack.pop();
                    node.next.prev = node;
                } else {
                    return head;
                }
            }
            node = node.next;
        }
    }

    void print(DoublyLinkedNode node) {
        while (node != null) {
            System.out.print(node.val);
            System.out.print(" -> ");
            node = node.next;
        }
        System.out.print("null");
    }
}

class DoublyLinkedNode {
    int val;
    DoublyLinkedNode prev;
    DoublyLinkedNode next;
    DoublyLinkedNode child;

    DoublyLinkedNode(int val) {
        this.val = val;
    }
}