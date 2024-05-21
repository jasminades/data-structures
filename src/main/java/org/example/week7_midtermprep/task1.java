package org.example.week7_midtermprep;



/*
implement the peek() operation for a queue
- if the queue is empty, the method should return null
- if there are elements in the queue, the method should return the first item in the queue, without removing it from the queue
 */

public class task1{
    public class Queue<Item> {
        /* Node implementation */
        private class Node <Item>{
            Item data;
            Node<Item> next;
        }

        private Node<Item> head = null;
        private Node<Item> tail = null;
        private int size = 0;

        /* Return the first item from the queue, without removing it */
        public Item peek() {
            if(isEmpty()){
                return null;                // returns null if the queue is empty
            }else{
                return head.data;           // returns the head of the first node
            }
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