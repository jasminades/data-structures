package org.example.week7_midtermprep;

/*
implement the peek() operation for a stack.
-if the stack is empty, the method should return null.
-if there are elements on the stack, the method should return the top-most item from the stack, without removing it from the stack.
 */
public class task4 {
    public class Stack<Item> {

        /* Node implementation */
        private class Node <Item>{
            Item data;
            Node<Item> next;
        }

        private Node<Item> top = null;
        private int size = 0;

        /* Return the top-most item from the stack, without removing it */
        public Item peek() {
           if(isEmpty()){
               return null;
           }else{
               return top.data;
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

        /* Return the current size of the stack */
        public int size() {
            return size;
        }

        /* Check if the stack is empty */
        public boolean isEmpty() {
            return size == 0;
        }
    }
}
