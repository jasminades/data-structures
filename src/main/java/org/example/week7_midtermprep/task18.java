package org.example.week7_midtermprep;
/*
 queue data structure by filling in the missing code in the following methods:

enqueue()
dequeue()
isEmpty()
size()
 */
public class task18 {
    public class Queue<Item> {

        /* Node implementation */
        private class Node <Item>{
            Item data;
            Node<Item> next;
        }

        private Node<Item> head = null;
        private Node<Item> tail = null;
        private int size = 0;

        /* Add new item to the back of the queue */
        public void enqueue(Item item) {
            Node<Item> newNode = new Node<>();          // create a new node
            newNode.data = item;                        // set the data f the node to the given item
            newNode.next=tail;                          // make the next pointer of the new node point to the current tail
            if(isEmpty()){                              // if the queue is empty set head and tail to the new node
                head=newNode;
            }else{
                tail.next=newNode;                      // otherwise set the next pointer of the current tail to the new node
            }
            tail=newNode;                               // update the tail pointer to the new node
            size++;

        }

        /* Check if the queue is empty */
        public boolean isEmpty() {
            return size==0;
        }

        /* Removes an item from the front of the queue, and returns its data */
        public Item dequeue() {
            if(isEmpty()){
                throw new IllegalStateException("Queue is empty");          // throw exception if the queue is empty
            }

            Item data = head.data;          // retrieve data from the head node
            head=head.next;                 // update the head pointer to the next node in the queue
            size--;                         // decrease the queue
            if(isEmpty()){                  // if it's empty after removing an item from the head
                tail=null;                  // tail is set to null
            }
            return data;
        }

        /* Return the current size of the queue */
        public int size() {
            return size;
        }
    }
}
