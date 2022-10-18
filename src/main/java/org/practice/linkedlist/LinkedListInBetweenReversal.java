package org.practice.linkedlist;

import lombok.ToString;

public class LinkedListInBetweenReversal {

    LinkNode prevOfStart = null;
    LinkNode currentNode = null;
    LinkNode tailNode = null;
    LinkNode head = new LinkNode(1);
    int position = 1;
    LinkNode listSoFar = null;


    public static void main(String[] args) {
        LinkedListInBetweenReversal reversal = new LinkedListInBetweenReversal();
        reversal.head.next = new LinkNode(2);
        reversal.head.next.next = new LinkNode(3);
        reversal.head.next.next.next = new LinkNode(4);
        reversal.head.next.next.next.next = new LinkNode(5);
        reversal.head.next.next.next.next.next = new LinkNode(6);
        reversal.head.next.next.next.next.next.next = new LinkNode(7);

        reversal.currentNode = reversal.head;

        reversal.print(reversal.head);
        System.out.println();
        reversal.reverse(reversal.head, 1, 6);
        reversal.print(reversal.head);
    }

    private void reverse(LinkNode node, int start, int end) {

        if (node.next == null) {
            return;
        }

        while (position <= start) {
            prevOfStart = node;
            node = node.next;
            position++;
        }
        tailNode = node;
        reverse(node, end);
        tailNode.next = currentNode;
        if (prevOfStart != null) {
            prevOfStart.next = listSoFar;
        }
    }

    private void reverse(LinkNode node, int end) {
        LinkNode prev = null;
        LinkNode curr = node;
        LinkNode next = null;

        while (curr != null && position <= end) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            listSoFar = curr;
            curr = next;
            position++;
        }
        currentNode = curr;
    }

    private void print(LinkNode head) {
        while (head != null) {
            System.out.print(head.value + " -> ");
            head = head.next;
        }
        System.out.print("null");
    }
}

@ToString(of = "value")
class LinkNode {
    int value;
    LinkNode next;

    LinkNode(int value) {
        this.value = value;
        this.next = null;
    }
}