package org.example.week1;

import com.sun.tools.javac.util.GraphUtils;
import org.w3c.dom.Node;

public class LinkedList<Data> implements Iterable<Data> {
    private GraphUtils.Node<Data> head;
    private int size = 0;


    /* Add an element to a linked list */
    public void add(int index, Data data) {
        if (index < 0 || index > size) {                                       // 1
            throw new IndexOutOfBoundsException("Invalid index for add operation.");   // 1
        }

        Node<Data> newNode = new Node<>();                                    // 2
        newNode.data = data;                                                  // 2

        if (index == 0) {                                                     // 3
            newNode.next = head;                                              // 3
            head = newNode;                                                   // 3
        } else {                                                              // 4
            Node<Data> current = head;                                        // 4
            for (int i = 0; i < index - 1; i++) {                             // 5
                current = current.next;                                       // 5
            }                                                                 // 5
            newNode.next = current.next;                                      // 6
            current.next = newNode;                                           // 7
        }

        size++;                                                               // 8
    }

    /* Delete an element from a linked list  */
    public void remove(int index) {
        if (index < 0 || index >= size) {                                     // 1
            throw new IndexOutOfBoundsException("Invalid index for remove operation.");   // 1
        }

        if (index == 0) {                                                     // 2
            head = head.next;                                                 // 2
        } else {                                                              // 3
            Node<Data> current = head;                                        // 3
            for (int i = 0; i < index - 1; i++) {                             // 4
                current = current.next;                                       // 4
            }                                                                 // 4
            current.next = current.next.next;                                 // 5
        }

        size--;                                                               // 6
    }


}
