package org.example.week2;

import java.util.Queue;
import java.util.LinkedList;

public class QueueBasedStack<Data> {
    private Queue<Data> q1;
    private Queue<Data> q2;

    public QueueBasedStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(Data data) {
        q2.offer(data);

        while (!q1.isEmpty()) {
            q2.offer(q1.poll());
        }

        Queue<Data> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    public Data pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return q1.poll();
    }

    public Data peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return q1.peek();
    }

    public int size() {
        return q1.size();
    }

    public boolean isEmpty() {
        return q1.isEmpty();
    }
}
