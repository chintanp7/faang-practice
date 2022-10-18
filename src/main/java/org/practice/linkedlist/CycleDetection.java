package org.practice.linkedlist;

public class CycleDetection {
    public static void main(String[] args) {
        CycleDetection cycleDetection = new CycleDetection();
        cycleDetection.go();
    }

    private void go() {
        Node<Integer> head = new Node(1);
        head.next = new Node<>(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);
        head.next.next.next.next.next.next.next = new Node(8);
        head.next.next.next.next.next.next.next.next = head.next.next;

        //print(head);
        System.out.println(getCycleNode(head));
    }

    private void print(Node head) {
        for (int i = 0; i < 15; i++) {
            if (head == null) {
                break;
            }
            System.out.print(head.value + " -> ");
            head = head.next;
        }
        System.out.print("null");
    }

    private Integer getCycleNode(Node<Integer> head) {
        Node slow = head;
        Node fast = head;
        Node detected = null;
        Node<Integer> meetingNode = null;

        while (true) {
            if (fast == null || fast.next == null) {
                return null;
            } else {
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast) {
                    detected = slow;
                    break;
                }
            }
        }
        slow = head;
        while(true) {
            if (slow != detected) {
                slow = slow.next;
                detected = detected.next;
            } else {
                meetingNode = slow;
                break;
            }
        }
        return meetingNode.value;
    }
}
