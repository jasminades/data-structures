package org.example.week1;

import java.util.Iterator;

public class LinkedList<Data> implements Iterable<Data> {
    private Node<Data> head;
    private int size = 0;

    private static class Node<Data> {
        Data data;
        Node<Data> next;
    }

    public void add(int index, Data data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index for add operation.");
        }

        Node<Data> newNode = new Node<>();
        newNode.data = data;

        if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node<Data> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }

        size++;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index for remove operation.");
        }

        if (index == 0) {
            head = head.next;
        } else {
            Node<Data> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }

        size--;
    }

    @Override
    public Iterator<Data> iterator() {
        return new Iterator<Data>() {
            private Node<Data> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Data next() {
                Data data = current.data;
                current = current.next;
                return data;
            }
        };
    }
}
