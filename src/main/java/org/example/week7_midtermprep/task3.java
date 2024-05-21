package org.example.week7_midtermprep;
import java.util.Stack;
import java.util.*;

/*
implement the cloneTop() operation for a stack.
- if the stack is empty, the method does nothing
- if there are elements on the stack, the method should duplicate / clone the top element of the stack, and add it into the stack
 */

public class task3 {
    /* Node implementation */
    private class Node <Item>{
        Item data;
        Node<Item> next;
    }

    private Node<Item> top = null;
    private int size = 0;

    /* Duplicate the top item of the stack, and add it into the stack */
    public void cloneTop() {
        if(!isEmpty()){                             // checking if the stack is not empty
            Node<Item> newTop = new Node<>();       // creating a new node that serves as a duplicate
            newTop.data = top.data;                 // copying the data to the new node from the top of the stack
            newTop.next = top;                      // setting the next field of the new node to point to the current top node of the stack
            top = newTop;                           // updating the top of the stack to be new node
            size++;

        }
    }

    /* Push an item onto the stack */
    public void push(Item item) {
        Node<Item> newNode = new Node<Item>();
        newNode.data = item;
        newNode.next = top;
        top = newNode;
        size++;
    }

    public Item pop() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("The stack is empty.");
        }
        Item item = top.data;
        top = top.next;
        size--;
        return item;
    }

    /* Return the current size of the stack */
    public int size() {
        return size;
    }

    /* Check if the stack is empty */
    public boolean isEmpty() {
        return size == 0;
    }
}
