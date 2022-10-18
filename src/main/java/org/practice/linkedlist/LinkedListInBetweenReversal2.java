package org.practice.linkedlist;

import lombok.ToString;

public class LinkedListInBetweenReversal2 {
    LinkNode head = new LinkNode(1);


    public static void main(String[] args) {
        LinkedListInBetweenReversal2 reversal = new LinkedListInBetweenReversal2();
        reversal.head.next = new LinkNode(2);
        reversal.head.next.next = new LinkNode(3);
        reversal.head.next.next.next = new LinkNode(4);
        reversal.head.next.next.next.next = new LinkNode(5);
        reversal.head.next.next.next.next.next = new LinkNode(6);
        reversal.head.next.next.next.next.next.next = new LinkNode(7);


        reversal.print(reversal.head);
        System.out.println();
        LinkNode node = reversal.reverse(reversal.head, 1, 6);
        reversal.print(node);
    }

    private LinkNode reverse(LinkNode node, int m, int n) {

        // Start with current position = 1
        int currentPosition = 1;

        // Assign the head node to current node and start node
        LinkNode currentNode = node;
        LinkNode start = node;

        // Move the start node to the 1 step before start point and current node to the start point
        while (currentPosition < m) {
            start = currentNode;
            currentNode = currentNode.next;
            currentPosition++;
        }

        // Initialize the reversed list as null
        LinkNode reversedList = null;

        // Assign the current node to the tail node as it will be the last node of the reversed list
        LinkNode tail = currentNode;

        // Reverse the list between point m and n
        while (currentPosition >= m && currentPosition <= n) {
            // Store next node of current node
            LinkNode next = currentNode.next;
            // Assign previous node to the next of current node
            currentNode.next = reversedList;
            // Assign current node to the previous node
            reversedList = currentNode;
            // Move the current node to original next node
            currentNode = next;
            currentPosition++;
        }

        // After finishing reversal...
        // Assign the next of the node before list to the head of reversed list
        start.next = reversedList;
        // Assign the next of the tail node of reversed list to the current node after the n
        tail.next = currentNode;

        // if start node is less or equal to 1 then return the head of reversed list or return original head node
        if (m <= 1) {
            return reversedList;
        } else {
            return head;
        }
    }




    private void print(LinkNode head) {
        while (head != null) {
            System.out.print(head.value + " -> ");
            head = head.next;
        }
        System.out.print("null");
    }
}
