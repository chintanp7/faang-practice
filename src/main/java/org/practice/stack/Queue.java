package org.practice.stack;

import java.util.Stack;

public class Queue<T> {

    // Initiate main and other stack
    private Stack<T> main;
    private Stack<T> other;

    public Queue() {
        main = new Stack<>();
        other = new Stack<>();
    }

    // Transfers all elements from main to other stack
    private void transfer() {
        while (!main.isEmpty()) {
            other.push(main.pop());
        }
    }

    // push into the main stack
    public void enqueue(T element) {
        main.push(element);
    }

    // if other stack if not empty then pop from other stack or first transfer from main to other and then pop
    public T dequeue() {
        if (other.isEmpty()) {
            transfer();
        }
        return other.pop();
    }

    // if other stack if not empty then pop from other stack or first transfer from main to other and then peek
    public T peek() {
        if (other.isEmpty()) {
            transfer();
        }
        return other.peek();
    }

    // check if both main and other are empty
    public boolean empty() {
        return main.isEmpty() && other.isEmpty();
    }

}
