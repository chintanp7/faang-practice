package org.practice.heap;

public class PriorityQueueTest {

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.push(35);
        pq.push(50);
        pq.push(25);
        pq.push(45);
        pq.push(10);
        pq.push(75);
        pq.push(15);
        pq.push(20);
        pq.push(40);

//        pq.push(15);
//        pq.push(12);
//        pq.push(50);
//        pq.push(7);
//        pq.push(40);
//        pq.push(22);

        while (!pq.isEmpty()) {
            System.out.println(pq.pop());
        }

    }
}
