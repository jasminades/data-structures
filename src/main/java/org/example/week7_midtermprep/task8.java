package org.example.week7_midtermprep;
/*
 implement the cloneTail() operation for a queue.

- if the queue is empty, the method does nothing
- if there are elements on the queue, the method should duplicate / clone the tail element of the stack, and add it to the back of the queue
 */
public class task8 {
    public class Queue<Item> {

        /* Node implementation */
        private class Node <Item>{
            Item data;
            Node<Item> next;
        }

        private Node<Item> head = null;
        private Node<Item> tail = null;
        private int size = 0;

        /* Duplicate the tail item of the stack, and add it to the tail end of the queue */
        public void cloneTail() {
            Node<Item> newTail = new Node<>();
            newTail.data = tail.data;
            tail.next = newTail;
            tail = newTail;
            size++;
        }

        /* Add a new item to the queue */
        public void enqueue(Item item) {
            Node<Item> newNode = new Node<Item>();
            newNode.data = item;
            if (isEmpty()) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
            size++;
        }

        public Item dequeue() throws IndexOutOfBoundsException {
            if (isEmpty()) {
                throw new IndexOutOfBoundsException("Queue is empty.");
            }
            Item data = head.data;
            head = head.next;
            size--;
            if (isEmpty()) {
                tail = null;
            }
            return data;
        }

        /* Return the current size of the queue */
        public int size() {
            return size;
        }

        /* Check if the queue is empty */
        public boolean isEmpty() {
            return size == 0;
        }
    }
}
