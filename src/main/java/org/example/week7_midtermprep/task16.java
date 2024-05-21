package org.example.week7_midtermprep;

/*
stack data structure by filling in the missing code in the following methods:

pop()
push()
isEmpty()
size()

 */
public class task16 {
    public class Stack<Item> {

        /* Node implementation */
        private class Node <Item>{
            Item data;
            Node<Item> next;
        }

        private Node<Item> top = null;
        private int size = 0;

        /* Push an item onto the stack */
        public void push(Item item) {
            // your code
            Node<Item> newNode = new Node<>();
            newNode.data=item;                      // assign item as data to the newNode
            newNode.next = top;                     // set the pointer of new node to top of the stack
            top=newNode;                            // set the top of the stack to be newNode
            size++;
        }

        /* Check if the stack is empty */
        public boolean isEmpty() {
            return top==null;
        }

        /* Remove the top item from the stack, and return its data */
        public Item pop() {
            if(isEmpty()){
                throw new IllegalStateException("Stack is empty");
            }

            Item data = top.data;           // retrieve data from the top node
            top = top.next;                 // update the top pointer to the next node, removing the current top node
            size--;                         // decrease
            return data;
        }

        /* Return the current size of the stack */
        public int size() {
            return size;
        }
    }
}
