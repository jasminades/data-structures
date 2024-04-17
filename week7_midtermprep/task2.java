package org.example.week7_midtermprep;


/*
implement the cloneHead() operation for a queue.
- if the queue is empty, the method does nothing
- if there are elements on the queue, the method should duplicate / clone the head element of the stack, and add it to the back of the queue
 */

public class task2 {
    /* Node implementation */
    private class Node <Item>{
        Item data;
        Node<Item> next;
    }

    private Node<Item> head = null;
    private Node<Item> tail = null;
    private int size = 0;

    /* Duplicate the head item of the stack, and add it to the tail end of the queue */
    public void cloneHead() {
       if(!isEmpty()){                              // checking if the queue is not empty
           Node<Item> newHead = new Node<>();       // creating a new node that serves as a duplicate of the current head node
           newHead.data = head.data;                // copy the data of the head node
           tail.next = newHead;                     // after copying the data, the newNode is at the tail of the queue
           tail = newHead;                          // the tail is updated to the new node
           size++;                                  // increasing the size of the queue
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
