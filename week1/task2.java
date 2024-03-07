package org.example.week1;


import java.util.Iterator;

public class DoublyLinkedList<Data> implements Iterable<Data> {
    private DoubleNode<Data> head;
    private DoubleNode<Data> tail;
    private int size = 0;

    /* Add a new node to the front */
    public void addToFront(Data data) {
        DoubleNode<Data> newNode = new DoubleNode<>(data);

        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.setNext(head);
            head.setPrev(newNode);
            head = newNode;
        }

        size++;
    }

    /* Remove a node from the front  */
    public void removeFromFront() {
        if (head != null) {
            head = head.getNext();

            if (head != null) {
                head.setPrev(null);
            } else {
                // The list is now empty, update tail
                tail = null;
            }

            size--;
        }
    }

    /* Add a new node to the end  */
    public void addToRear(Data data) {
        DoubleNode<Data> newNode = new DoubleNode<>(data);

        if (tail == null) {
            head = tail = newNode;
        } else {
            newNode.setPrev(tail);
            tail.setNext(newNode);
            tail = newNode;
        }

        size++;
    }

    /* Remove a node at the end  */
    public void removeFromRear() {
        if (tail != null) {
            tail = tail.getPrev();

            if (tail != null) {
                tail.setNext(null);
            } else {
                head = null;
            }

            size--;
        }
    }

    /* Get a linked list node by index */
    public Data get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        DoubleNode<Data> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }

        return current.getData();
    }

    /* Add an element to a doubly linked list  */
    public void add(int index, Data data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        if (index == 0) {
            addToFront(data);
        } else if (index == size) {
            addToRear(data);
        } else {
            DoubleNode<Data> newNode = new DoubleNode<>(data);
            DoubleNode<Data> current = head;

            for (int i = 0; i < index - 1; i++) {
                current = current.getNext();
            }

            newNode.setPrev(current);
            newNode.setNext(current.getNext());
            current.getNext().setPrev(newNode);
            current.setNext(newNode);

            size++;
        }
    }

    /* Delete an element from a doubly linked list */
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        if (index == 0) {
            removeFromFront();
        } else if (index == size - 1) {
            removeFromRear();
        } else {
            DoubleNode<Data> current = head;

            for (int i = 0; i < index; i++) {
                current = current.getNext();
            }

            current.getPrev().setNext(current.getNext());
            current.getNext().setPrev(current.getPrev());

            size--;
        }
    }

    public int count() {
        return size;
    }

    @Override
    public Iterator<Data> iterator() {
        return new DoublyLinkedListIterator();
    }
+
    private class DoublyLinkedListIterator implements Iterator<Data> {
        private DoubleNode<Data> current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Data next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            }
            Data data = current.getData();
            current = current.getNext();
            return data;
        }
    }

    public DoubleNode<Data> getHead() {
        return head;
    }

    public DoubleNode<Data> getTail() {
        return tail;
    }
}
