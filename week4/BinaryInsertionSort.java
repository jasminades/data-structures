package org.example.week4;

import org.example.week4.LinkedList;

public class BinaryInsertionSort {
    public static <Data extends Comparable<Data>> void sort(LinkedList<Data> ll) {
        // Iterate from the second node to the end
        for (int i = 1; i < ll.count(); i++) {
            // Get the data to be inserted
            Data key = ll.get(i);
            // Find the correct insertion point using binary search
            int insertionIndex = findInsertionPoint(ll, i - 1, key);
            // Insert the element at the correct position
            ll.remove(i); // Remove the element from its current position
            ll.add(insertionIndex, key); // Insert the element at the insertion index
        }
    }

    public static <Data extends Comparable<Data>> int findInsertionPoint(LinkedList<Data> ll, int high, Data key) {
        int low = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = key.compareTo(ll.get(mid));
            if (cmp == 0) {
                return mid + 1;
            } else if (cmp < 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
