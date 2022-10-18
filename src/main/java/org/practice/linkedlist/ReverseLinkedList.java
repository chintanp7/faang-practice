package org.practice.linkedlist;

import lombok.AllArgsConstructor;

public class ReverseLinkedList {
    public static void main(String[] args) {
        Node<Integer> node5 = new Node<>(5, null);
        Node<Integer> node4 = new Node<>(4, node5);
        Node<Integer> node3 = new Node<>(3, node4);
        Node<Integer> node2 = new Node<>(2, node3);
        Node<Integer> node1 = new Node<>(1, node2);

        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        reverseLinkedList.print(node1);
        System.out.println();
        reverseLinkedList.reverse(node1);
        reverseLinkedList.print(node5);
    }

    private void reverse(Node head) {
        Node prev = null;
        Node curr = head; //1
        Node next = null; //2

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
    }

    private void print(Node head) {
        while (head != null) {
            System.out.print(head.value + " -> ");
            head = head.next;
        }
        System.out.print("null");
    }
}

@AllArgsConstructor
class Node<T> {
    T value;
    Node<T> next;

    Node(T value) {
        this.value = value;
    }
}